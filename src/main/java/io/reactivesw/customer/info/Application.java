package io.reactivesw.customer.info;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by umasuo on 17/2/9.
 */
@EnableSwagger2
@SpringBootApplication
public class Application {

  private static final Logger LOGGER = Logger.getLogger(Application.class);

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
