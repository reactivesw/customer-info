package io.reactivesw.customer.info.application.model.action;

import io.reactivesw.customer.info.infrastructure.update.UpdateAction;
import io.reactivesw.customer.info.infrastructure.util.UpdateActionUtils;
import lombok.Data;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * delete address.
 */
@Data
public class DeleteAddress implements UpdateAction, Serializable {

  /**
   * auto generated serial version id.
   */
  private static final long serialVersionUID = 5216512069351943745L;

  /**
   * id.
   */
  @NotNull
  private String id;

  /**
   * get action name.
   *
   * @return String
   */
  @Override
  public String getActionName() {
    return UpdateActionUtils.DELETE_ADDRESS;
  }
}
