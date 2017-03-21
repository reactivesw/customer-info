package io.reactivesw.customer.info.application.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static io.reactivesw.customer.info.infrastructure.Router.CUSTOMER_HEALTH_CHECK;

/**
 * Created by umasuo on 17/2/21.
 */
@RestController
public class HealthController {

  /**
   * service name.
   */
  @Value("${spring.application.name}")
  private transient String serviceName;

  /**
   * this api is used for health check.
   *
   * @return service name.
   */
  @GetMapping(CUSTOMER_HEALTH_CHECK)
  public String index() {
    return serviceName + ", system time: " + System.currentTimeMillis();
  }
}
