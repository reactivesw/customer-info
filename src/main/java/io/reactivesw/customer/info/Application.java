package io.reactivesw.customer.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * customer info service starter.
 */
@SpringBootApplication(scanBasePackages = "io.reactivesw")
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
