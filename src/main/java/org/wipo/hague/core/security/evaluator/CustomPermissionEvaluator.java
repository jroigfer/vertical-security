package org.wipo.hague.core.security.evaluator;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.wipo.hague.common.security.HagueSecurityUtil;
import org.wipo.hague.core.db.DocumentRepository;
import org.wipo.hague.core.db.RecordRepository;

@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {

  @Autowired
  private RecordRepository recordRepository;

  @Autowired
  private DocumentRepository documentRepository;

  @Autowired
  private HagueSecurityUtil securityUtil;

  @Override
  public boolean hasPermission(Authentication auth, Object id, Object permission) {
    // get the username of the record of the document id
    String user = documentRepository.findUsernameDocument((Long) id);
    // chek if the user is the same as logged
    if (user.equals(securityUtil.getLoggedUser())) {
      // check if the user has the permission specified
      return hasPrivilege(auth, permission.toString().toUpperCase());
    } else {
      return false;
    }
  }

  @Override
  public boolean hasPermission(Authentication auth, Serializable targetId, String targetType, Object permission) {
    return false; // Unused
  }

  private boolean hasPrivilege(Authentication auth, String permission) {
    for (GrantedAuthority grantedAuth : auth.getAuthorities()) {
      if (grantedAuth.getAuthority().contains(permission)) {
        return true;
      }
    }
    return false;
  }

}
