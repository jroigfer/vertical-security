package org.wipo.hague.core.service.api;

import java.security.Principal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.wipo.hague.core.db.model.Document;

public interface PocInternalService {

  @RequestMapping(method = RequestMethod.GET, value = "/guest")
  String guestNumberAndWhoYouAre(Principal principal);

  @RequestMapping(method = RequestMethod.GET, value = "/letmein")
  String guestIfYouHavePermissions(@RequestParam(name = "id", required = true) Integer id);

  @RequestMapping(method = RequestMethod.GET, value = "/guest_no_auth")
  String guestNumberWhoEverYouAre(Principal principal);

  @RequestMapping(method = RequestMethod.GET, value = "/document")
  Document documentId(@RequestParam(name = "id", required = true) Long id);

}
