package org.wipo.hague.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.wipo.hague.common.conf.HagueCommonBasicConfiguration;
import org.wipo.hague.common.conf.HagueSecurityCoreConfiguration;
import org.wipo.hague.common.conf.HagueSwaggerConfiguration;

/**
 * The Class AppHaguePocsServer.
 */
@SpringBootApplication(scanBasePackages = {"org.wipo.hague.core"})
@Import({HagueSwaggerConfiguration.class, HagueSecurityCoreConfiguration.class, HagueCommonBasicConfiguration.class}) // ,HagueSecurityPocConfiguration.class})
public class AppHaguePocsServer {

  /** The LOG. */
  private static final Logger LOG = LoggerFactory.getLogger(AppHaguePocsServer.class);

  /**
   * The main method.
   *
   * @param args the arguments
   */
  public static void main(String[] args) {
    LOG.info("Starting microservice");
    SpringApplication.run(AppHaguePocsServer.class, args);
  }
}
