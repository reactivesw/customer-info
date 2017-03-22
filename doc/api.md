The customer will be auto created by the service.

### updateCustomer
#### Path: /{id}
#### Method: PUT
#### Payload: UpdateRequest
- Payload structure
```json
{
    "version": ...,
    "actions":[
        {
            "action":"action name",
            ...payloads...
        },
        
    ]
}
```
#### Return: CustomerView
##### Actions:
###### Action: updateCustomerInfo
Update all info here
- Payload
```java
  
  String customerName;

  String firstName;

  String lastName;

  String middleName;

  ZonedDateTime dateOfBirth;

  String defaultAddressId;

  String locale;
```


###### Action: AddAddress
- Payload
```Java
  
  String fullName;
   
  //NotNull
  String zip;

  //NotNull
  String phone;

  //NotNull
  String firstLine;

  String secondLine;

  //NotNull
  String country;

  String state;

  //NotNull
  String city;
```

###### Action: UpdateAddress
- Payload
```
  
  String id;

  String fullName;

  String zip;

  String phone;

  String firstLine;

  String secondLine;

  String country;

  String state;

  String city;
```
- Sample
```Java
{
	"action":"updateAddress",
	"fullName": "Woossa Umasuo",
	"city": "NewYork"
}
```
###### Action: DeleteAddress
- Payload
```
  String id;
```
- Sample
```Java
{
	"action":"updateAddress",
	"id": "RGADV-GBFGHNSAWEA-GHNJDBSV"
}
```

---

### Get customer info by customer id
#### Path: /{id}
#### Payload: NONE
#### Method: GET
#### Return CustomerView

---

### Get address by addressId
#### Path: /addresses/{addressId}
#### Payload: NONE
#### Method: GET
#### Return: AddressView
