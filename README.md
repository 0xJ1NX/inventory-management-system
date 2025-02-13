# inventory-management-system

<p align="center">
  <img src="./images/inv-manage-sys.png" alt="Inventory Management System logo" width="300" >
</p>

This is a simple inventory management system REST API, that allow managing Items, Customers, Orders, Suppliers, and supplies,
and provide consistent and easy to use API.
> [!NOTE]
> If you find any issue please open an issue or contact me.


<p align="center">
    <a href="https://github.com/0xJ1NX">
        <img src="https://img.shields.io/badge/Author-0xJ1NX-blue?style=for-the-badge"  height="27"  alt=""/>
    </a>
    <a href="https://app.swaggerhub.com/apis/1201062/Inventory-management-system/1.0.0#/">
        <img src="https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=Swagger&logoColor=white"  alt=""/>
    </a>
    <img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white"  alt=""/>
    <img src="https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot"  alt=""/>
</p>
<br>
<p align="center">
    <a href="https://www.buymeacoffee.com/om4r">
        <img src="https://img.shields.io/badge/Buy%20me%20a%20coffee-donate-yellow?style=for-the-badge&logo=buy-me-a-coffee"  alt=""/>
    </a>
</p>

## 📝 Table of Contents
- [🧰 Resources](#-resources)
- [✏ ERD's and Diagrams](#-erds-and-diagrams)
- [📋 API Endpoints and Documentation](#-api-endpoints-and-documentation)
  - [/items](#items)
  - [/suppliers](#suppliers)
  - [/customers](#customers)
  - [/orders](#orders)
  - [/supplies](#supplies)
- [OpenAPI Documentation](#openapi-documentation)
- [Postman Collection](#postman-collection)
- [📦 Running the project](#-running-the-project)


## 🧰 Resources
the following are the resources in the inventory management system API
- ***Items*** : the products in the inventory

- ***Suppliers*** : the people who supply the items to the inventory

- ***Customers*** : are the people who buy the items

- ***Orders*** : the transactions of the items between the customers and the inventory

- ***Supplies*** : the transaction of the items between the suppliers and the inventory

## ✏ ERD's and Diagrams
- The following diagram shows the Entity Relationship Diagram.
    ![ERD](./images/inventory_managment_system.drawio.png)

- The following diagram shows the database Design.
    ![Database Design](./images/inventory_db_2.png)

## 📋 API Endpoints and Documentation
- The following are the API endpoints and their documentation

`Base URL : example.com/api/v1`

### /items


<!-- | HTTP Request | Operation | Description | HTTP Status Code | Request Body Sample | Response Body Sample |
| ------------ | --------- | ----------- | ---------------- | -------------- | --------------- |
| `GET /items`    | Read | Get all items | 200 (OK) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429(Too Many Requests) <br> 500(Internal Server Error) | N/A | <pre lang="json">{&#13; "items": [&#13; {&#13; "id": 1, &#13; "name": "item1", &#13; "description": "item1 description", &#13; "price": 100, &#13; "quantity": 10 &#13; }, &#13; {&#13; "id": 2, &#13; "name": "item2", &#13; "description": "item2 description", &#13; "price": 200, &#13; "quantity": 20 &#13; } &#13; ] &#13; } </pre> |
| `GET /items/{id}` | Read | Get item by id | 200 (OK) <br> 401 (Unauthorized)<br> 403 (Forbidden)<br> 404 (Not Found)<br> 429(Too Many Requests)<br> 500(Internal Server Error) | N/A |<pre lang="json">{&#13; "item": {&#13; "id": 1, &#13; "name": "item1", &#13; "description": "item1 description", &#13; "price": 100, &#13; "quantity": 10 &#13; } &#13; }</pre> |
| `POST /items` | Create | Create new item the quantity initiale zero | 201 (Created) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500(Internal Server Error) |<pre lang="json">{&#13; "name": "item1", &#13; "description": "item1 description", &#13; "price": 100, &#13; }</pre> | <pre lang="json">{&#13; "item": {&#13; "id": 1, &#13; "name": "item1", &#13; "description": "item1 description", &#13; "price": 100, &#13; "quantity": 10 &#13; } &#13; }</pre>|
| `PUT /items/{id}` | Update | Update item by id | 200 (OK) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 404 (Not Found) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500(Internal Server Error) | <pre lang="json">{&#13; "name": "item1", &#13; "description": "item1 description", &#13; "price": 100, &#13; }</pre> | <pre lang="json">{&#13; "item": {&#13; "id": 1, &#13; "name": "item1", &#13; "description": "item1 description", &#13; "price": 100, &#13; "quantity": 10 &#13; } &#13; }</pre>  |
| `DELETE /items/{id}` | Delete | Delete item by id | 204 (No Content) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 404 (Not Found) <br> 410 (Gone) <br> 429(Too Many Requests) <br> 500(Internal Server Error) | N/A | N/A |
| `PATCH /items/{id}` | Partial Update | Partial Update item by id | 200 (OK) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 404 (Not Found) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500(Internal Server Error) | <pre lang="json">{&#13; "name": "item1" &#13; }</pre> | <pre lang="json">{&#13; "item": {&#13; "id": 1, &#13; "name": "item1", &#13; "description": "item1 description", &#13; "price": 100, &#13; "quantity": 10 &#13; } &#13; }</pre> | -->

<table>
    <tr>
        <td>HTTP Request</td>
        <td>Operation</td>
        <td>Description</td>
        <td>HTTP Status Code</td>
        <td>Request Body Sample</td>
        <td>Response Body Sample</td>
    </tr>
    <tr>
<td>

`GET /items`

</td>
        <td>Read</td>
        <td>Get all items</td>
        <td>200 (OK) <br> 400 (Bad Request) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429(Too Many Requests) <br> 500(Internal Server Error)</td>
        <td>N/A</td>
<td>

```json
{
  "status": "success",
  "httpStatus": 200,
  "message": "Items fetched successfully",
  "data": [
    {
      "id": 4,
      "name": "kjdslkjfklds",
      "description": "1234",
      "price": 22.0,
      "quantity": 20
    }
  ]
}
```


</td>
    </tr>
    <tr>
<td>

`GET /items/{id}`

</td>
        <td>Read</td>
        <td>Get item by id</td>
        <td>200 (OK) <br> 400 (Bad Request) <br> 401 (Unauthorized)<br> 403 (Forbidden)<br> 404 (Not Found)<br> 429(Too Many Requests)<br> 500(Internal Server Error)</td>
        <td>N/A</td>
<td>

```json
{
  "status": "success",
  "httpStatus": 200,
  "message": "Item fetched successfully",
  "data": {
    "id": 4,
    "name": "kjdslkjfklds",
    "description": "1234",
    "price": 22.0,
    "quantity": 20
  }
}
```

</td>
    </tr>
    <tr>
<td>

`POST /items`
</td>
        <td>Create</td>
        <td>Create new item the quantity initiale zero</td>
        <td>201 (Created) <br> 400 (Bad Request) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500(Internal Server Error)</td>
<td>

```json
{
    "name": "item1",
    "description": "item1 description",
    "price": 100
}
```
</td>
<td>

```json
{
  "status": "success",
  "httpStatus": 201,
  "message": "Item created successfully",
  "data": {
    "id": 5,
    "name": "mfmo",
    "description": "1234",
    "price": 22.0,
    "quantity": 0
  }
}
```

</td>
    </tr>
    <tr>
<td>

`PUT /items/{id}`
</td>
        <td>Update</td>
        <td>Update item by id</td>
        <td>200 (OK) <br> 400 (Bad Request) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 404 (Not Found) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500(Internal Server Error)</td>
<td>

```json
{
    "name": "item1",
    "description": "item1 description",
    "price": 100
}
```
</td>
<td>

```json
{
  "status": "success",
  "httpStatus": 200,
  "message": "Item updated successfully",
  "data": {
    "id": 4,
    "name": "m",
    "description": "14",
    "price": 22.0,
    "quantity": 20
  }
}
```
</td>
    </tr>
    <tr>
<td>

`DELETE /items/{id}`
</td>
        <td>Delete</td>
        <td>Delete item by id</td>
        <td>204 (No Content) <br> 400 (Bad Request) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 404 (Not Found) <br> 410 (Gone) <br> 429(Too Many Requests) <br> 500(Internal Server Error)</td>
        <td>N/A</td>
<td>

```json
{
  "status": "success",
  "httpStatus": 200,
  "message": "Item deleted successfully",
  "data": {
    "id": 6,
    "name": "mfo",
    "description": "1234",
    "price": 22.0,
    "quantity": 0
  }
}

```

</td>
    </tr>
    <tr>
<td>

`PATCH /items/{id}`

</td>
        <td>Partial Update</td>
        <td>Partial Update item by id</td>
        <td>200 (OK) <br> 400 (Bad Request) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 404 (Not Found) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500(Internal Server Error)</td>
<td>

```json
{
    "name": "item1"
}
```
</td>
<td>

```json
{
  "status": "success",
  "httpStatus": 200,
  "message": "Item Updated successfully",
  "data": {
    "id": 6,
    "name": "mfo",
    "description": "1234",
    "price": 22.0,
    "quantity": 0
  }
}
```
</td>
    </tr>
</table>


### /suppliers

<!-- | HTTP Request | Operation | Description | HTTP Status Code | Request Body Sample | Response Body Sample |
| ------------ | --------- | ----------- | ---------------- | -------------- | --------------- |
| `GET /suppliers`    | Read | Get all suppliers | 200 (OK) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429(Too Many Requests) <br> 500(Internal Server Error) | N/A | <br><pre lang="json">{&#13; "suppliers": [&#13; {&#13; "id": 1, &#13; "name": "supplier1", &#13; "email": "supp@gmail.com", &#13; "phone": "123456789" &#13; }, &#13; {&#13; "id": 2, &#13; "name": "supplier2", &#13; "email": "supp2@gmil.com", &#13; "phone": "123456789" &#13; } &#13; ] &#13; }</pre> <br> |
| `GET /suppliers/{id}` | Read | Get supplier by id | 200 (OK) <br> 401 (Unauthorized)<br> 403 (Forbidden)<br> 404 (Not Found)<br> 429(Too Many Requests)<br> 500(Internal Server Error) | N/A | <br><pre lang="json">{&#13; "supplier": {&#13; "id": 1, &#13; "name": "supplier1", &#13; "email":"supp@gmail.com",&#13; "phone": "123456789" &#13; } &#13; }</pre> <br> |
| `GET /suppliers/{id}/supply` | Read | Get all supplies of a supplier | 200 (OK) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429(Too Many Requests) <br> 500(Internal Server Error) | N/A | <br><pre lang="json">{&#13; "supplies": [&#13; {&#13; "id": 1, &#13; "item_id": 1, &#13; "supplier_id": 1, &#13; "quantity": 10, &#13; "price_per_unit": 100, &#13; "date": "2021-10-10" &#13; }, &#13; {&#13; "id": 2, &#13; "item_id": 2, &#13; "supplier_id": 1, &#13; "quantity": 20, &#13; "price_per_unit": 200, &#13; "date": "2021-10-10" &#13; } &#13; ] &#13; }</pre> <br> |
| `GET /suppliers/{id}/item` | Read | Get the item of a supplier | 200 (OK) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429(Too Many Requests) <br> 500(Internal Server Error) | N/A | <br><pre lang="json">{&#13; "item": {&#13; "id": 1, &#13; "name": "item1", &#13; "description": "item1 description", &#13; "price": 100, &#13; "quantity": 10 &#13; } &#13; }</pre> <br> |
| `POST /suppliers` | Create | Create new supplier | 201 (Created) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500(Internal Server Error) | <br><pre lang="json">{&#13; "name": "supplier1", &#13; "email": "supp@gmail.com", &#13; "phone": "123456789" &#13; }</pre> <br> | <br><pre lang="json">{&#13; "supplier": {&#13; "id": 1, &#13; "name": "supplier1", &#13; "email": "supp@gmail.com", &#13; "phone": "123456789" &#13; } &#13; }</pre> <br> |
| `POST /suppliers/{id}/supply` | Create | Create new supply for a supplier | 201 (Created) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429 (Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500 (Internal Server Error) | <br><pre lang="json">{&#13; "item_id": 1, &#13; "supplier_id": 1, &#13; "quantity": 10, &#13; "price_per_unit": 100, &#13; "date": "2021-10-10" &#13; }</pre> <br> | <br><pre lang="json">{&#13; "supply": {&#13; "id": 1, &#13; "item_id": 1, &#13; "supplier_id": 1, &#13; "quantity": 10, &#13; "price_per_unit": 100, &#13; "date": "2021-10-10" &#13; } &#13; }</pre> <br> |
| `PUT /suppliers/{id}` | Update | Update supplier by id | 200 (OK) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 404 (Not Found) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500(Internal Server Error) | <br><pre lang="json">{&#13; "name": "supplier1", &#13; "email": "supp@gmail.com", &#13; "phone": "123456789" &#13; }</pre> <br> | <br><pre lang="json">{&#13; "supplier": {&#13; "id": 1, &#13; "name": "supplier1", &#13; "email": "supp@gmail.com", &#13; "phone": "123456789" &#13; } &#13; }</pre> <br> |
| `DELETE /supplier/{id}` | Delete | Delete supplier by id | 204 (No Content) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 404 (Not Found) <br> 429(Too Many Requests) <br> 410 (Gone) <br> 500(Internal Server Error) | N/A | N/A |
| `PATCH /suppliers/{id}` | Partial Update | Partial Update supplier by id | 200 (OK) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 404 (Not Found) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500(Internal Server Error) | <br><pre lang="json">{&#13; "name": "supplier1" &#13; }</pre> <br> | <br><pre lang="json">{&#13; "supplier": {&#13; "id": 1, &#13; "name": "supplier1", &#13; "email": "supp@gmail.com", &#13; "phone": "123456789" &#13; } &#13; }</pre> <br> | -->

<table>
    <tr>
        <td>HTTP Request</td>
        <td>Operation</td>
        <td>Description</td>
        <td>HTTP Status Code</td>
        <td>Request Body Sample</td>
        <td>Response Body Sample</td>
    </tr>
    <tr>
<td>

`GET /suppliers`

</td>
        <td>Read</td>
        <td>Get all suppliers</td>
        <td>200 (OK) <br> 400 (Bad Request) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429(Too Many Requests) <br> 500(Internal Server Error)</td>
        <td>N/A</td>
<td>

```json
{
  "status": "success",
  "httpStatus": 200,
  "message": "Suppliers fetched successfully",
  "data": [
    {
      "id": 2,
      "name": "sdfgh",
      "address": "ramallah",
      "email": "dsfdsfdsf",
      "phone": "0568347131"
    }
  ]
}
```

</td>
    </tr>
    <tr>
<td>

`GET /suppliers/{id}`
</td>
        <td>Read</td>
        <td>Get supplier by id</td>
        <td>200 (OK) <br> 400 (Bad Request) <br> 401 (Unauthorized)<br> 403 (Forbidden)<br> 404 (Not Found)<br> 429(Too Many Requests)<br> 500(Internal Server Error)</td>
        <td>N/A</td>
<td>

```json
{
  "status": "success",
  "httpStatus": 200,
  "message": "Suppliers fetched successfully",
  "data": {
      "id": 2,
      "name": "sdfgh",
      "address": "ramallah",
      "email": "dsfdsfdsf",
      "phone": "0568347131"
    }
}
```

</td>
    </tr>
    <tr>
<td>

`POST /suppliers`
</td>
        <td>Create</td>
        <td>Create new supplier</td>
        <td>201 (Created) <br> 400 (Bad Request) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500(Internal Server Error)</td>
<td>

```json
{
  "name":"omar",
  "address":"ramallah",
  "phone":"0568347131",
  "email":"dsfdsfdsf"
}
```

</td>
<td>

```json
{
  "status": "success",
  "httpStatus": 201,
  "message": "Supplier created successfully",
  "data": {
    "id": 3,
    "name": "omar",
    "address": "ramallah",
    "email": "dsffdsf",
    "phone": "8347131"
  }
}
```

</td>
    </tr>
    <tr>
<td>

`PUT /suppliers/{id}`
</td>
        <td>Update</td>
        <td>Update supplier by id</td>
        <td>200 (OK) <br> 400 (Bad Request) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 404 (Not Found) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500(Internal Server Error)</td>
<td>

```json
{
  "name":"omar",
  "address":"ramallah",
  "phone":"8347131",
  "email":"dsffdsf"
}
```
</td>
<td>

```json
{
  "status": "success",
  "httpStatus": 200,
  "message": "Supplier updated successfully",
  "data": {
    "id": 3,
    "name": "omar",
    "address": "rallah",
    "email": "dsfdsfdsf",
    "phone": "0568347131"
  }
}
```

</td>
    </tr>
    <tr>
<td>

`DELETE /suppliers/{id}`
</td>
        <td>Delete</td>
        <td>Delete supplier by id</td>
        <td>204 (No Content) <br> 400 (Bad Request) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 404 (Not Found) <br> 429(Too Many Requests) <br> 410 (Gone) <br> 500(Internal Server Error)</td>
        <td>N/A</td>
<td>

```json
{
  "status": "success",
  "httpStatus": 200,
  "message": "Supplier deleted successfully",
  "data": {
    "id": 3,
    "name": "omar",
    "address": "rallah",
    "email": "dsfdsfdsf",
    "phone": "0568347131"
  }
}
```


</td>
    </tr>
    <tr>
<td>

`PATCH /suppliers/{id}`
</td>
        <td>Partial Update</td>
        <td>Partial Update supplier by id</td>
        <td>200 (OK) <br> 400 (Bad Request) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 404 (Not Found) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500(Internal Server Error)</td>
<td>


```json
{
    "name": "supplier1"
}
```
</td>

<td>

```json
{
  "status": "success",
  "httpStatus": 200,
  "message": "Supplier updated successfully",
  "data": {
    "id": 3,
    "name": "omar",
    "address": "rallah",
    "email": "dsfdsfdsf",
    "phone": "0568347131"
  }
}
```
</td>
    </tr>
</table>

### /customers

<!-- | HTTP Request | Operation | Description | HTTP Status Code | Request Body Sample | Response Body Sample |
| ------------ | --------- | ----------- | ---------------- | -------------- | --------------- |
| `GET /customers`    | Read | Get all customers | 200 (OK) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429(Too Many Requests) <br> 500(Internal Server Error) | N/A | <br><pre lang="json">{&#13; "customers": [&#13; {&#13; "id": 1, &#13; "name": "customer1", &#13; "email": "customer@gmail.com", &#13; "phone": "123456789" &#13; }, &#13; {&#13; "id": 2, &#13; "name": "customer2", &#13; "email": "customer@gmail.com", &#13; "phone": "123456789" &#13; } &#13; ] &#13; }</pre> <br> |
| `GET /customers/{id}` | Read | Get customer by id | 200 (OK) <br> 401 (Unauthorized)<br> 403 (Forbidden)<br> 404 (Not Found)<br> 429(Too Many Requests)<br> 500(Internal Server Error) | N/A | <br><pre lang="json">{&#13; "customer": {&#13; "id": 1, &#13; "name": "customer1", &#13; "email": "customer@gmail.com", &#13; "phone": "123456789" &#13; } &#13; }</pre> <br> |
| `GET /customers/{id}/order` | Read | Get all orders of a customer | 200 (OK) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429(Too Many Requests) <br> 500(Internal Server Error) | N/A | <br><pre lang="json">{&#13; "orders": [&#13; {&#13; "id": 1, &#13; "item_id": 1, &#13; "customer_id": 1, &#13; "quantity": 10, &#13; "date": "2021-10-10" &#13; }, &#13; {&#13; "id": 2, &#13; "item_id": 2, &#13; "customer_id": 1, &#13; "quantity": 20, &#13; "date": "2021-10-10" &#13; } &#13; ] &#13; }</pre> <br> |
| `POST /customers` | Create | Create new customer | 201 (Created) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500 (Internal Server Error) | <br><pre lang="json">{&#13; "name": "customer1", &#13; "email": "customer@gmail.com", &#13; "phone": "123456789" &#13; }</pre> <br> | <br><pre lang="json">{&#13; "customer": {&#13; "id": 1, &#13; "name": "customer1", &#13; "email": "customer@gmail.com", &#13; "phone": "123456789" &#13; } &#13; }</pre> <br> |
| `POST /customers/{id}/order` | Create | Create new order for a customer | 201 (Created) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500 (Internal Server Error) | <br><pre lang="json">{&#13; "item_id": 1, &#13; "customer_id": 1, &#13; "quantity": 10 &#13; }</pre> <br> | <br><pre lang="json">{&#13; "order": {&#13; "id": 1, &#13; "item_id": 1, &#13; "customer_id": 1, &#13; "quantity": 10, &#13; "date": "2021-10-10" &#13; } &#13; }</pre> <br> |
| `PUT /customers/{id}` | Update | Update customer by id | 200 (OK) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 404 (Not Found) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500(Internal Server Error) | <br><pre lang="json">{&#13; "name": "customer1", &#13; "email": "customer@gmail.com", &#13; "phone": "123456789" &#13; }</pre> <br> | <br><pre lang="json">{&#13; "customer": {&#13; "id": 1, &#13; "name": "customer1", &#13; "email": "Customer@gmail.com", &#13; "phone": "123456789" &#13; } &#13; }</pre> <br> |
| `DELETE /customers/{id}` | Delete | Delete customer by id | 204 (No Content) <br> 401 (Unauthorized) <br> (Forbidden) <br> (Not Found) <br> (Too Many Requests) <br> 410 (Gone) <br> 500(Internal Server Error) | N/A | N/A |
| `PATCH /customers/{id}` | Partial Update | Partial Update customer by id | 200 (OK) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 404 (Not Found) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500(Internal Server Error) | <br><pre lang="json">{&#13; "name": "customer1" &#13; }</pre> <br> | <br><pre lang="json">{&#13; "customer": {&#13; "id": 1, &#13; "name": "customer1", &#13; "email": "customer@gmail.com", &#13; "phone": "123456789" &#13; } &#13; }</pre> <br> | -->

<table>
    <tr>
        <td>HTTP Request</td>
        <td>Operation</td>
        <td>Description</td>
        <td>HTTP Status Code</td>
        <td>Request Body Sample</td>
        <td>Response Body Sample</td>
    </tr>
    <tr>
<td>

`GET /customers`

</td>
        <td>Read</td>
        <td>Get all customers</td>
        <td>200 (OK) <br> 400 (Bad Request) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429(Too Many Requests) <br> 500(Internal Server Error)</td>
        <td>N/A</td>
<td>

```json
{
  "status": "success",
  "httpStatus": 200,
  "message": "Customers fetched successfully",
  "data": [
    {
      "id": 12,
      "name": "omsdjlsjdlkdsjlkar",
      "email": "dsfdsfdsf",
      "phone": "0568347131",
      "address": "ramallah"
    }
  ]
}

```

</td>
    </tr>
    <tr>
<td>

`GET /customers/{id}`
</td>
        <td>Read</td>
        <td>Get customer by id</td>
        <td>200 (OK) <br> 400 (Bad Request) <br> 401 (Unauthorized)<br> 403 (Forbidden)<br> 404 (Not Found)<br> 429(Too Many Requests)<br> 500(Internal Server Error)</td>
        <td>N/A</td>
<td>

```json
{
  "status": "success",
  "httpStatus": 200,
  "message": "Customer fetched successfully",
  "data": {
    "id": 12,
    "name": "omsdjlsjdlkdsjlkar",
    "email": "dsfdsfdsf",
    "phone": "0568347131",
    "address": "ramallah"
  }
}
```

</td>
    </tr>
    <tr>
<td>

`POST /customers`
</td>
        <td>Create</td>
        <td>Create new customer</td>
        <td>201 (Created) <br> 400 (Bad Request) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500(Internal Server Error)</td>
<td>

```json
{
  "name":"omar",
  "address":"ramallah",
  "phone":"056131",
  "email":"dsffdsf"
}
```

</td>
<td>

```json
{
  "status": "success",
  "httpStatus": 201,
  "message": "Customer created successfully",
  "data": {
    "id": 14,
    "name": "omar",
    "email": "dsffdsf",
    "phone": "056131",
    "address": "ramallah"
  }
}
```

</td>
    </tr>
    <tr>
<td>

`PUT /customers/{id}`
</td>
        <td>Update</td>
        <td>Update customer by id</td>
        <td>200 (OK) <br> 400 (Bad Request) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 404 (Not Found) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500(Internal Server Error)</td>
<td>

```json
{
  "name":"omar",
  "address":"ramallah",
  "phone":"056131",
  "email":"dsffdsf"
}
```

</td>
<td>

```json
{
  "status": "success",
  "httpStatus": 200,
  "message": "Customer updated successfully",
  "data": {
    "id": 12,
    "name": "omjlkjlklkar",
    "email": "dsfdsfdsf",
    "phone": "0568347131",
    "address": "ramallah"
  }
}
```

</td>
    </tr>
    <tr>
<td>

`DELETE /customers/{id}`

</td>
        <td>Delete</td>
        <td>Delete customer by id</td>
        <td>204 (No Content) <br> 400 (Bad Request) <br> 401 (Unauthorized) <br> (Forbidden) <br> (Not Found) <br> (Too Many Requests) <br> 410 (Gone) <br> 500(Internal Server Error)</td>
        <td>N/A</td>
<td>

```json
{
  "status": "success",
  "httpStatus": 200,
  "message": "Customer deleted successfully",
  "data": {
    "id": 14,
    "name": "omar",
    "email": "dsffdsf",
    "phone": "056131",
    "address": "ramallah"
  }
}
```

</td>
    </tr>
    <tr>

<td>

`PATCH /customers/{id}`

</td>
        <td>Partial Update</td>
        <td>Partial Update customer by id</td>
        <td>200 (OK) <br> 400 (Bad Request) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 404 (Not Found) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500(Internal Server Error)</td>
<td>

```json
{
    "name": "customer1"
}
```

</td>
<td>

```json
{
  "status": "success",
  "httpStatus": 200,
  "message": "Customer updated successfully",
  "data": {
    "id": 12,
    "name": "omjlkjlklkar",
    "email": "dsfdsfdsf",
    "phone": "0568347131",
    "address": "ramallah"
  }
}
```

</td>
    </tr>
</table>


### /orders

<!-- | HTTP Request | Operation | Description | HTTP Status Code | Request Body Sample | Response Body Sample |
| ------------ | --------- | ----------- | ---------------- | -------------- | --------------- |
| `GET /orders`    | Read | Get all orders | 200 (OK) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429(Too Many Requests) <br> 500(Internal Server Error) | N/A | <br><pre lang="json">{&#13; "orders": [&#13; {&#13; "id": 1, &#13; "item_id": 1, &#13; "customer_id": 1, &#13; "quantity": 10, &#13; "date": "2021-10-10" &#13; }, &#13; {&#13; "id": 2, &#13; "item_id": 2, &#13; "customer_id": 1, &#13; "quantity": 20, &#13; "date": "2021-10-10" &#13; } &#13; ] &#13; }</pre> <br> |
| `GET /orders/{id}` | Read | Get order by id | 200 (OK) <br> 401 (Unauthorized)<br> 403 (Forbidden)<br> 404 (Not Found)<br> 429(Too Many Requests)<br> 500(Internal Server Error) | N/A | <br><pre lang="json">{&#13; "order": {&#13; "id": 1, &#13; "item_id": 1, &#13; "customer_id": 1, &#13; "quantity": 10, &#13; "date": "2021-10-10" &#13; } &#13; }</pre> <br> |
| `GET /orders/{id}/item` | Read | Get the item of an order | 200 (OK) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429(Too Many Requests) <br> 500(Internal Server Error) | N/A | <br><pre lang="json">{&#13; "item": {&#13; "id": 1, &#13; "name": "item1", &#13; "description": "item1 description", &#13; "price": 100, &#13; "quantity": 10 &#13; } &#13; }</pre> <br> |
| `POST /orders` | Create | Create new order | 201 (Created) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500 (Internal Server Error) | <br><pre lang="json">{&#13; "item_id": 1, &#13; "customer_id": 1, &#13; "quantity": 10 &#13; }</pre> <br> | <br><pre lang="json">{&#13; "order": {&#13; "id": 1, &#13; "item_id": 1, &#13; "customer_id": 1, &#13; "quantity": 10, &#13; "date": "2021-10-10" &#13; } &#13; }</pre> <br> |
| `PUT /orders/{id}` | Update | Update order by id | 200 (OK) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 404 (Not Found) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500(Internal Server Error) | <br><pre lang="json">{&#13; "item_id": 1, &#13; "customer_id": 1, &#13; "quantity": 10 &#13; }</pre> <br> | <br><pre lang="json">{&#13; "order": {&#13; "id": 1, &#13; "item_id": 1, &#13; "customer_id": 1, &#13; "quantity": 10, &#13; "date": "2021-10-10" &#13; } &#13; }</pre> <br> |
| `DELETE /orders/{id}` | Delete | Delete order by id | 204 (No Content) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 404 (Not Found) <br> 429(Too Many Requests) <br> 410 (Gone) <br> 500(Internal Server Error) | N/A | N/A |
| `PATCH /orders/{id}` | Partial Update | Partial Update order by id | 200 (OK) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 404 (Not Found) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500(Internal Server Error) | <br><pre lang="json">{&#13; "quantity": 10 &#13; }</pre> <br> | <br><pre lang="json">{&#13; "order": {&#13; "id": 1, &#13; "item_id": 1, &#13; "customer_id": 1, &#13; "quantity": 10, &#13; "date": "2021-10-10" &#13; } &#13; }</pre> <br> | -->

<table>
    <tr>
        <td>HTTP Request</td>
        <td>Operation</td>
        <td>Description</td>
        <td>HTTP Status Code</td>
        <td>Request Body Sample</td>
        <td>Response Body Sample</td>
    </tr>
    <tr>
<td>

`GET /orders`

</td>
        <td>Read</td>
        <td>Get all orders</td>
        <td>200 (OK) <br> 400 (Bad Request) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429(Too Many Requests) <br> 500(Internal Server Error)</td>
        <td>N/A</td>
<td>

```json
{
  "status": "success",
  "httpStatus": 200,
  "message": "Orders fetched successfully",
  "data": [
    {
      "id": 8,
      "date": "2024-04-17T20:02:43.376+00:00",
      "customerId": 12,
      "orderItemsDTOS": [
        {
          "id": 12,
          "quantity": 2,
          "itemId": 4
        }
      ]
    }
  ]
}
```

</td>
    </tr>
    <tr>
<td>

`GET /orders/{id}`
</td>
        <td>Read</td>
        <td>Get order by id</td>
        <td>200 (OK) <br> 400 (Bad Request) <br> 401 (Unauthorized)<br> 403 (Forbidden)<br> 404 (Not Found)<br> 429(Too Many Requests)<br> 500(Internal Server Error)</td>
        <td>N/A</td>
<td>

```json
{
  "status": "success",
  "httpStatus": 200,
  "message": "Order fetched successfully",
  "data": {
    "id": 8,
    "date": "2024-04-17T20:02:43.376+00:00",
    "customerId": 12,
    "orderItemsDTOS": [
      {
        "id": 12,
        "quantity": 2,
        "itemId": 4
      }
    ]
  }
}
```

</td>
    </tr>
    <tr>
<td>

`POST /orders`

</td>
        <td>Create</td>
        <td>Create new order</td>
        <td>201 (Created) <br> 400 (Bad Request) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500(Internal Server Error)</td>
<td>

```json
{
  "customerId": 12,
  "orderItems": [
    {
      "itemId": 4,
      "quantity": 2
    }
  ]

}
```
</td>
<td>

```json
{
  "status": "success",
  "httpStatus": 201,
  "message": "Order created successfully",
  "data": {
    "id": 9,
    "date": "2024-04-17T20:33:45.529+00:00",
    "customerId": 12,
    "orderItemsDTOS": [
      {
        "id": 13,
        "quantity": 2,
        "itemId": 4
      }
    ]
  }
}
```

</td>
    </tr>
    <tr>
<td>

`PUT /orders/{id}`

</td>
        <td>Update</td>
        <td>Update order by id</td>
        <td>200 (OK) <br> 400 (Bad Request) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 404 (Not Found) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500(Internal Server Error)</td>
<td>

```json
{
  "customerId": 12,
  "orderItems": [
    {
      "itemId": 4,
      "quantity": 2
    }
  ]

}
```

</td>
<td>

```json

{
  "status": "success",
  "httpStatus": 200,
  "message": "Order updated successfully",
  "data": {
    "id": 8,
    "date": "2024-04-17T20:02:43.376+00:00",
    "customerId": 12,
    "orderItemsDTOS": [
      {
        "id": 14,
        "quantity": 11,
        "itemId": 4
      }
    ]
  }
}

```

</td>
    </tr>
    <tr>
<td>

`DELETE /orders/{id}`
</td>
        <td>Delete</td>
        <td>Delete order by id</td>
        <td>204 (No Content) <br> 400 (Bad Request) <br> 401 (Unauthorized) <br> (Forbidden) <br> (Not Found) <br> (Too Many Requests) <br> 410 (Gone) <br> 500(Internal Server Error)</td>
        <td>N/A</td>
<td>

```json
{
  "status": "success",
  "httpStatus": 200,
  "message": "Order deleted successfully",
  "data": null
}
```

</td>
    </tr>
    <tr>
<td>

`PATCH /orders/{id}`
</td>
        <td>Partial Update</td>
        <td>Partial Update order by id</td>
        <td>200 (OK) <br> 400 (Bad Request) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 404 (Not Found) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500(Internal Server Error)</td>
<td>

```json
{
    "quantity": 10
}
```

</td>

<td>

```json
{
  "status": "success",
  "httpStatus": 200,
  "message": "Order updated successfully",
  "data": {
    "id": 8,
    "date": "2024-04-17T20:02:43.376+00:00",
    "customerId": 12,
    "orderItemsDTOS": [
      {
        "id": 14,
        "quantity": 11,
        "itemId": 4
      }
    ]
  }
}
```

</td>
    </tr>
</table>



### /supplies
<!-- | HTTP Request | Operation | Description | HTTP Status Code | Request Body Sample | Response Body Sample |
| ------------ | --------- | ----------- | ---------------- | -------------- | --------------- |
| `GET /supplies`    | Read | Get all supplies | 200 (OK) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429(Too Many Requests) <br> 500(Internal Server Error) | N/A | <br><pre lang="json">{&#13; "supplies": [&#13; {&#13; "id": 1, &#13; "item_id": 1, &#13; "supplier_id": 1, &#13; "quantity": 10, &#13; "price_per_unit": 100, &#13; "date": "2021-10-10" &#13; }, &#13; {&#13; "id": 2, &#13; "item_id": 2, &#13; "supplier_id": 1, &#13; "quantity": 20, &#13; "price_per_unit": 200, &#13; "date": "2021-10-10" &#13; } &#13; ] &#13; }</pre> <br> |
| `GET /supplies/{id}` | Read | Get supply by id | 200 (OK) <br> 401 (Unauthorized)<br> 403 (Forbidden)<br> 404 (Not Found)<br> 429(Too Many Requests)<br> 500(Internal Server Error) | N/A | <br><pre lang="json">{&#13; "supply": {&#13; "id": 1, &#13; "item_id": 1, &#13; "supplier_id": 1, &#13; "quantity": 10, &#13; "price_per_unit": 100, &#13; "date": "2021-10-10" &#13; } &#13; }</pre> <br> |
| `POST /supplies` | Create | Create new supply | 201 (Created) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500(Internal Server Error) | <br><pre lang="json">{&#13; "item_id": 1, &#13; "supplier_id": 1, &#13; "quantity": 10, &#13; "price_per_unit": 100, &#13; "date": "2021-10-10" &#13; }</pre> <br> | <br><pre lang="json">{&#13; "supply": {&#13; "id": 1, &#13; "item_id": 1, &#13; "supplier_id": 1, &#13; "quantity": 10, &#13; "price_per_unit": 100, &#13; "date": "2021-10-10" &#13; } &#13; }</pre> <br> |
| `PUT /supplies/{id}` | Update | Update supply by id | 200 (OK) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 404 (Not Found) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500(Internal Server Error) | <br><pre lang="json">{&#13; "item_id": 1, &#13; "supplier_id": 1, &#13; "quantity": 10, &#13; "price_per_unit": 100, &#13; "date": "2021-10-10" &#13; }</pre> <br> | <br><pre lang="json">{&#13; "supply": {&#13; "id": 1, &#13; "item_id": 1, &#13; "supplier_id": 1, &#13; "quantity": 10, &#13; "price_per_unit": 100, &#13; "date": "2021-10-10" &#13; } &#13; }</pre> <br> |
| `DELETE /supplies/{id}` | Delete | Delete supply by id | 204 (No Content) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 404 (Not Found) <br> 429(Too Many Requests) <br> 410 (Gone) <br> 500(Internal Server Error) | N/A | N/A |
| `PATCH /supplies/{id}` | Partial Update | Partial Update supply by id | 200 (OK) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 404 (Not Found), 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500(Internal Server Error) | <br><pre lang="json">{&#13; "quantity": 10 &#13; }</pre> <br> | <br><pre lang="json">{&#13; "supply": {&#13; "id": 1, &#13; "item_id": 1, &#13; "supplier_id": 1, &#13; "quantity": 10, &#13; "price_per_unit": 100, &#13; "date": "2021-10-10" &#13; } &#13; }</pre> <br> | -->


<table>
    <tr>
        <td>HTTP Request</td>
        <td>Operation</td>
        <td>Description</td>
        <td>HTTP Status Code</td>
        <td>Request Body Sample</td>
        <td>Response Body Sample</td>
    </tr>
    <tr>
<td>

`GET /supplies`

</td>
        <td>Read</td>
        <td>Get all supplies</td>
        <td>200 (OK) <br> 400 (Bad Request) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429(Too Many Requests) <br> 500(Internal Server Error)</td>
        <td>N/A</td>
<td>

```json
{
  "status": "success",
  "httpStatus": 200,
  "message": "Supplies fetched successfully",
  "data": [
    {
      "id": 2,
      "itemId": 4,
      "supplierId": 2,
      "quantity": 22,
      "ppu": 220.0,
      "date": "2024-04-17T20:06:09.834+00:00"
    }
  ]
}
```

</td>
    </tr>
    <tr>
<td>

`GET /supplies/{id}`
</td>
        <td>Read</td>
        <td>Get supply by id</td>
        <td>200 (OK) <br> 400 (Bad Request) <br> 401 (Unauthorized)<br> 403 (Forbidden)<br> 404 (Not Found)<br> 429(Too Many Requests)<br> 500(Internal Server Error)</td>
        <td>N/A</td>
<td>

```json
{
  "status": "success",
  "httpStatus": 200,
  "message": "Supply fetched successfully",
  "data": {
    "id": 2,
    "itemId": 4,
    "supplierId": 2,
    "quantity": 22,
    "ppu": 220.0,
    "date": "2024-04-17T20:06:09.834+00:00"
  }
}
```

</td>
    </tr>
    <tr>
<td>

`POST /supplies`

</td>
        <td>Create</td>
        <td>Create new supply</td>
        <td>201 (Created) <br> 400 (Bad Request) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500(Internal Server Error)</td>
<td>

```json
{
  "itemId": 4,
  "quantity": 3,
  "supplierId":2,
  "ppu":220
}
```

</td>
<td>

```json
{
  "status": "success",
  "httpStatus": 201,
  "message": "Supply created successfully",
  "data": {
    "id": 3,
    "itemId": 4,
    "supplierId": 2,
    "quantity": 3,
    "ppu": 220.0,
    "date": "2024-04-17T20:36:57.956+00:00"
  }
}
```

</td>
    </tr>
    <tr>
<td>

`PUT /supplies/{id}`
</td>
        <td>Update</td>
        <td>Update supply by id</td>
        <td>200 (OK) <br> 400 (Bad Request) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 404 (Not Found) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500(Internal Server Error)</td>
<td>

```json
{
  "itemId": 4,
  "quantity": 100,
  "supplierId":2,
  "ppu":220
}
```

</td>
<td>

```json
{
  "status": "success",
  "httpStatus": 200,
  "message": "Supply updated successfully",
  "data": {
    "id": 2,
    "itemId": 4,
    "supplierId": 2,
    "quantity": 100,
    "ppu": 220.0,
    "date": "2024-04-17T20:06:09.834+00:00"
  }
}
```

</td>
    </tr>
    <tr>
<td>

`DELETE /supplies/{id}`
</td>
        <td>Delete</td>
        <td>Delete supply by id</td>
        <td>204 (No Content) <br> 400 (Bad Request) <br> 401 (Unauthorized) <br> (Forbidden) <br> (Not Found) <br> (Too Many Requests) <br> 410 (Gone) <br> 500(Internal Server Error)</td>
        <td>N/A</td>
<td>

```json
{
  "status": "success",
  "httpStatus": 200,
  "message": "Supply deleted successfully",
  "data": null
}
```

</td>
    </tr>
    <tr>
<td>

`PATCH /supplies/{id}`
</td>
        <td>Partial Update</td>
        <td>Partial Update supply by id</td>
        <td>200 (OK) <br> 400 (Bad Request) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 404 (Not Found), 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500(Internal Server Error)</td>
<td>

```json
{
    "quantity": 10
}
```

</td>
<td>

```json
{
  "status": "success",
  "httpStatus": 200,
  "message": "Supply updated successfully",
  "data": {
    "id": 2,
    "itemId": 4,
    "supplierId": 2,
    "quantity": 10,
    "ppu": 220.0,
    "date": "2024-04-17T20:06:09.834+00:00"
  }
}
```

</td>
    </tr>
</table>

## OpenAPI Documentation

<p align="center">
    <img src="./images/openapi-logo.png" alt="OpenAPI v3.1.0"  width="150" >
</p>


- The OpenAPI v3.1.0 is available in the following link [SwaggerHub](https://app.swaggerhub.com/apis/1201062/Inventory-management-system/1.0.0#/)




## Postman Collection

<p align="center">
    <img src="./images/postman-icon.svg" alt="Postman"  width="130" >
</p>

- The Postman collection is in the following file [Postman Collection](./postman/IMS.postman_collection.json)

## 📦 Running the project
- Clone the repository
    ```bash
    git clone https://github.com/0xJ1NX/inventory-management-system.git
    ```
- Change the directory to the project directory
    ```bash
    cd inventory-management-system
    ```
- Run the project
    ```bash
    gradle bootRun
    ```
- The project will run on the default port `8080`

