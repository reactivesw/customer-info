package io.reactivesw.customer.info.infrastructure;

/**
 * Created by umasuo on 16/12/20.
 */
public final class Router {

  /**
   * The ROOTER.
   */
  public static final String CUSTOMER_ROOT = "/";

  /**
   * customer id.
   */
  public static final String CUSTOMER_ID = "id";

  /**
   * customer root with id.
   */
  public static final String CUSTOMER_WITH_ID = CUSTOMER_ROOT + "{" + CUSTOMER_ID + "}";

  /**
   * customer address.
   */
  public static final String ADDRESS_ROOT = CUSTOMER_ROOT + "addresses";

  /**
   * address id.
   */
  public static final String ADDRESS_ID = "addressId";

  /**
   * address with id.
   */
  public static final String ADDRESS_WITH_ID = ADDRESS_ROOT + "/{" + ADDRESS_ID + "}";

  /**
   * customer's payment relationship.
   */
  public static final String PAYMENT_ROOT = CUSTOMER_WITH_ID + "/payments";

  /**
   * payment id.
   */
  public static final String PAYMENT_ID = "paymentId";

  /**
   * customer's payment with id.
   */
  public static final String PAYMENT_ROOT_WITH_ID = PAYMENT_ROOT + "/{" + PAYMENT_ID + "}";

  /**
   * The constant CUSTOMER_HEALTH_CHECK.
   */
  public static final String CUSTOMER_HEALTH_CHECK = CUSTOMER_ROOT + "health";

  /**
   * private router.
   */
  private Router() {
  }

  /**
   * get path with customer id.
   *
   * @param customerId customer id
   * @return String customer with id
   */
  public static String getCustomerWithId(String customerId) {
    return CUSTOMER_ROOT + "/" + customerId;
  }

  /**
   * url builder: get address with id.
   *
   * @param addressId String
   * @return String address with id
   */
  public static String getAddressWithId(String addressId) {
    return ADDRESS_ROOT + "/" + addressId;
  }

  /**
   * path builder: get customer with email.
   *
   * @param email String
   * @return String customer with email
   */
  public static String getCustomerWithEmail(String email) {
    return CUSTOMER_ROOT + "?email=" + email;
  }

  /**
   * path builder:get customer with google token.
   *
   * @param googleToken google token
   * @return String customer with google
   */
  public static String getCustomerWithGoogle(String googleToken) {
    return CUSTOMER_ROOT + "?gToken=" + googleToken;
  }

}
