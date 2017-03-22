package io.reactivesw.customer.info.application.model.action;

import io.reactivesw.customer.info.infrastructure.update.UpdateAction;
import io.reactivesw.customer.info.infrastructure.util.UpdateActionUtils;
import lombok.Data;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

@Data
public class UpdateAddress implements UpdateAction, Serializable {

  @NotNull
  private String id;

  private String fullName;

  @NotNull
  private String zip;

  @NotNull
  private String phone;

  @NotNull
  private String firstLine;

  private String secondLine;

  @NotNull
  private String country;

  private String state;

  @NotNull
  protected String city;

  @Override
  public String getActionName() {
    return UpdateActionUtils.UPDATE_ADDRESS;
  }
}
