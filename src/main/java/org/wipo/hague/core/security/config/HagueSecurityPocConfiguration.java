package org.wipo.hague.core.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.wipo.hague.core.security.evaluator.CustomPermissionEvaluator;

/**
 * This class enables ResourceServer protection using Oauth for the core services. The gateways and
 * the oauth server itself have their own custom security configuration. It also provides a feign
 * RequestIntercpetor to use token relay strategy with feign clients. Strategy by default.
 */
@Configuration
@EnableGlobalMethodSecurity
public class HagueSecurityPocConfiguration extends GlobalMethodSecurityConfiguration {

  @Autowired
  CustomPermissionEvaluator customPermissionEvaluator;

  @Bean(name = "dataSource")
  public DriverManagerDataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.h2.Driver");
    dataSource.setUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
    dataSource.setUsername("sa");
    dataSource.setPassword("");

    // schema init
    Resource initSchema = new ClassPathResource("schema.sql");
    Resource initData = new ClassPathResource("data.sql");
    DatabasePopulator databasePopulator = new ResourceDatabasePopulator(initSchema, initData);
    DatabasePopulatorUtils.execute(databasePopulator, dataSource);

    return dataSource;
  }

  @Override
  protected MethodSecurityExpressionHandler createExpressionHandler() {
    DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();
    expressionHandler.setPermissionEvaluator(customPermissionEvaluator);
    return expressionHandler;
  }

}
