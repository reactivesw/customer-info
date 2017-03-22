package io.reactivesw.customer.info.application.model.action;

import io.reactivesw.customer.info.infrastructure.update.UpdateAction;
import io.reactivesw.customer.info.infrastructure.util.UpdateActionUtils;
import lombok.Data;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

@Data
public class DeleteAddress implements UpdateAction, Serializable {

  @NotNull
  private String id;

  @Override
  public String getActionName() {
    return UpdateActionUtils.DELETE_ADDRESS;
  }
}
