package io.reactivesw.customer.info.infrastructure.update;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.reactivesw.customer.info.application.model.action.AddAddress;
import io.reactivesw.customer.info.application.model.action.DeleteAddress;
import io.reactivesw.customer.info.application.model.action.SetDefaultAddress;
import io.reactivesw.customer.info.application.model.action.UpdateAddress;
import io.reactivesw.customer.info.application.model.action.UpdateCustomerInfo;
import io.reactivesw.customer.info.infrastructure.util.UpdateActionUtils;

import java.io.Serializable;

/**
 * configurations for common update actions that will be used in more thant one service
 * and this action also extends other action configure in each service.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property =
    "action")
@JsonSubTypes( {
    @JsonSubTypes.Type(value = AddAddress.class, name = UpdateActionUtils.ADD_ADDRESS),
    @JsonSubTypes.Type(value = UpdateAddress.class, name = UpdateActionUtils.UPDATE_ADDRESS),
    @JsonSubTypes.Type(value = DeleteAddress.class, name = UpdateActionUtils.DELETE_ADDRESS),
    @JsonSubTypes.Type(value = SetDefaultAddress.class, name = UpdateActionUtils
        .SET_DEFAULT_ADDRESS),
    @JsonSubTypes.Type(value = UpdateCustomerInfo.class, name = UpdateActionUtils
        .UPDATE_CUSTOMER_INFO)})
public interface UpdateAction extends Serializable {
  /**
   * get action name.
   *
   * @return name in string.
   */
  String getActionName();
}
