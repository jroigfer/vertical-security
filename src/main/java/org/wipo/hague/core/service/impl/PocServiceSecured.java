package org.wipo.hague.core.service.impl;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class PocServiceSecured {

  // Sample of vertical authoritation

  @PreAuthorize("hasPermission(#id, 'BACK')")
  public String guestIfYouHavePermissionsService(Integer idSomeImportantDomain) {

    return "Yeah! You have it";

  }

}
