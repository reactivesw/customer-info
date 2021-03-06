The customer will be auto created by the service.
### Api Model
- CustomerView

|Column Name     | Type              | Constraint        | Means
---|---|---|---
id              | String            | UUID              | id of the customer, generated by customer-authentication when customer sign up.
version         | Integer           | Auto increment    | customer info version.
customerName    | String            | None              | Customer name of the customer.
createdAt       | ZonedDateTime     | Pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC"    | created time.
lastModifiedAt  | ZonedDateTime     | Pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC"    | Last modified time.
firstName       | String            | None              | customer's first name.
lastName        | String            | None              | customer's last name.
middleName      | String            | None              | customer's middle name.
addresses       | List<Address>     | None              | customer's address list, maybe empty. all address are sorted by created time.
defaultAddressId| String            | None              | default address

---


- AddressView

|Column Name     | Type              | Constraint        | Means
---|---|---|---
id              | String            | UUID              | id of the Address, auto generated.
createdAt       | String            | None              | created time
lastModifiedAt  | String            | None              | last modify time 
fullName        | String            | None              | full name of the receiver 
zip             | String            | None              | zip code 
phone           | String            | None              | phone number of the receiver 
firstLine       | String            | None              | first line of the address 
secondLine      | String            | None              | second line of the address
country         | String            | None              | country
state           | String            | None              | state
city            | String            | None              | city
 

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
#### Response: CustomerView 

##### Actions:
###### Action: updateCustomerInfo
Update all info here
- Payload
```java
  
  String customerName;

  String firstName;

  String lastName;

  String middleName;

  String defaultAddressId;

```


###### Action: AddAddress
- Payload
```Java
  
  String fullName;
   
  String zip;

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
- Sample
```Java
    {
        "action":"addAddress",
        "fullName":"HomeAddress",
        "zip": "this is ziasda",
        "phone": "this is phone",
        "country": "this is country",
        "firstLine":"adasdasda",
        "city": "this is city",
        "state":"this is stateasdasdas"
    }
```

###### Action: UpdateAddress
- Payload
```
  //NotNull
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
        "id":"6421b8d0-768b-4417-abd6-b2ab04941c29",
        "fullName":"HomeAddress",
        "zip": "this is ziasda",
        "phone": "this is phone",
        "country": "this is country",
        "firstLine":"adasdasda",
        "city": "this is city",
        "state":"this is stateasdasdas"
    }
```
###### Action: DeleteAddress
- Payload
```
  //NotNull
  String id;
```
- Sample
```Java
{
	"action":"deleteAddress",
	"id": "RGADV-GBFGHNSAWEA-GHNJDBSV"
}
```
###### Action: SetDefaultAddress
- Payload
```
  //NotNull
  String addressId;
```
- Sample
```Java
{
	"action":"setDefaultAddress",
	"addressId": "RGADV-GBFGHNSAWEA-GHNJDBSV"
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
