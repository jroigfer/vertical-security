package org.wipo.hague.core.service.exposed;

import java.security.Principal;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.wipo.hague.core.db.DocumentRepository;
import org.wipo.hague.core.db.model.Document;
import org.wipo.hague.core.service.api.PocInternalService;
import org.wipo.hague.core.service.impl.PocServiceSecured;

/**
 * The class {@link PocsRestService} exposes methods that act as POCs.
 */
@RestController
public class PocsRestServiceImpl implements PocInternalService {

  @Autowired
  private PocServiceSecured pocService;

  @Autowired
  private DocumentRepository documentRepository;

  @PreAuthorize("hasAuthority('MANAGER')")
  public String guestNumber(@PathVariable("name") String name) {

    Random r = new Random();
    int number = r.nextInt();

    return "Hi " + name + ", the number you think is: " + number;
  }

  @Override
  @PreAuthorize("hasRole('EXAMINER')")
  public String guestNumberAndWhoYouAre(Principal principal) {

    Random r = new Random();
    int number = r.nextInt();

    return "Hi " + principal.getName() + ", the number you think is: " + number;
  }

  @Override
  public String guestNumberWhoEverYouAre(Principal principal) {

    Random r = new Random();
    int number = r.nextInt();

    return "Hi " + principal.getName() + ", I'm not validating your priviliges so..., the number you think is: "
        + number;

  }

  @Override
  public String guestIfYouHavePermissions(@RequestParam(name = "id", required = true) Integer id) {

    String retval = pocService.guestIfYouHavePermissionsService(id);
    return retval;

  }

  @Override
  @PreAuthorize("hasPermission(#id, 'BACK')") // Check if the user of the record of this document is
                                              // the same as lopgged, and if has BACK permission
  public Document documentId(Long id) {
    return documentRepository.findOne(id);
  }

}
