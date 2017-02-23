package io.reactivesw.customer.info.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by umasuo on 17/2/22.
 */
@RestController
public class TestController {

  @GetMapping("/test")
  public String testName() {
    return "customerInfo: " + System.currentTimeMillis();
  }

  @GetMapping("/")
  public String index() {
    return "customerInfo index: " + System.currentTimeMillis();
  }
}