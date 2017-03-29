package io.reactivesw.customer.info.infrastructure.util;

import org.springframework.data.domain.AuditorAware;

/**
 * zoned date time.
 */
public class ZonedDateTimeAuditorAware implements AuditorAware<String> {

  /**
   * get current auditor.
   * @return null.
   */
  @Override
  public String getCurrentAuditor() {
    return null;
  }
}