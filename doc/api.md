The customer will be auto created by the service.

### updateCustomer
#### Path: /{id}
#### Method: PUT
#### Payload: UpdateRequest
```json
{
    "version":***,
    "actions":[
        {
            "action":"action name",
            ****Values****
        },
        
    ]
}
```
#### Return: CustomerView
##### Actions:
###### updateCustomerInfo
- CustomerView
```java
  
  private String id;

  /**
   * The customer number can be used to create a more human-readable (in contrast to ID) identifier
   * for the customer. It should be unique across a merchant. Once the field was set it cannot be
   * changed anymore.
   */
  private String customerName;

  private String firstName;

  private String lastName;

  private String middleName;

  private ZonedDateTime dateOfBirth;

  /**
   * The addresses have unique IDs in the addresses list.
   */
  private List<AddressView> addresses;

  /**
   * The address ID in the addresses list.
   */
  private String defaultShippingAddressId;

  /**
   * The address ID in the addresses list.
   */
  private String defaultBillingAddressId;
  
  private String locale;
```
- AddressView
```Java
  
  private String name;

  private String salutation;

  private String firstName;

  private String lastName;

  private String postalCode;

  private String phone;

  private String email;

  private String firstLine;

  private String secondLine;
```
- sample
```Json
{
	"version":1,
	"actions":[
		{
			"action":"updateCustomerInfo",
			"id": "customer1"
		},
		{
			"action":"addAddress",
			"name": "home"
		}
		]
}
```

### Get Address By Address Id
#### Path: /addresses/{addressId}
#### Payload: none
#### Method: GET