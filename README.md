# inventory-management-system

<p align="center">
  <img src="./images/inv-manage-sys.png" alt="Inventory Management System logo" width="300" >
</p>

This is a simple inventory management system REST API, that allow managing Items, Customers, Orders, Suppliers, and supplies.

> NOTE: The API still under development and the documentation is not complete yet.


<p align="center">
    <a href="https://github.com/0xJ1NX">
        <img src="https://img.shields.io/badge/Author-0xJ1NX-blue?style=for-the-badge"  height="27" />
    </a>
    <a href="">
        <img src="https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=Swagger&logoColor=white" />
    </a>
    <img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white" />
    <img src="https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot" />
</p>
<br>
<p align="center">
    <a href="https://www.buymeacoffee.com/om4r">
        <img src="https://img.shields.io/badge/Buy%20me%20a%20coffee-donate-yellow?style=for-the-badge&logo=buy-me-a-coffee" />
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
        <td>`GET /items`</td>
        <td>Read</td>
        <td>Get all items</td>
        <td>200 (OK) &lt;br&gt; 401 (Unauthorized) &lt;br&gt; 403 (Forbidden) &lt;br&gt; 429(Too Many Requests) &lt;br&gt; 500(Internal Server Error)</td>
        <td>N/A</td>
        <td>&lt;br&gt;&lt;pre lang=&quot;json&quot;&gt;{&amp;#13; &quot;items&quot;: [&amp;#13; {&amp;#13; &quot;id&quot;: 1, &amp;#13; &quot;name&quot;: &quot;item1&quot;, &amp;#13; &quot;description&quot;: &quot;item1 description&quot;, &amp;#13; &quot;price&quot;: 100, &amp;#13; &quot;quantity&quot;: 10 &amp;#13; }, &amp;#13; {&amp;#13; &quot;id&quot;: 2, &amp;#13; &quot;name&quot;: &quot;item2&quot;, &amp;#13; &quot;description&quot;: &quot;item2 description&quot;, &amp;#13; &quot;price&quot;: 200, &amp;#13; &quot;quantity&quot;: 20 &amp;#13; } &amp;#13; ] &amp;#13; }&lt;/pre&gt; &lt;br&gt;</td>
    </tr>
    <tr>
        <td>`GET /items/{id}`</td>
        <td>Read</td>
        <td>Get item by id</td>
        <td>200 (OK) &lt;br&gt; 401 (Unauthorized)&lt;br&gt; 403 (Forbidden)&lt;br&gt; 404 (Not Found)&lt;br&gt; 429(Too Many Requests)&lt;br&gt; 500(Internal Server Error)</td>
        <td>N/A</td>
        <td>&lt;br&gt;&lt;pre lang=&quot;json&quot;&gt;{&amp;#13; &quot;item&quot;: {&amp;#13; &quot;id&quot;: 1, &amp;#13; &quot;name&quot;: &quot;item1&quot;, &amp;#13; &quot;description&quot;: &quot;item1 description&quot;, &amp;#13; &quot;price&quot;: 100, &amp;#13; &quot;quantity&quot;: 10 &amp;#13; } &amp;#13; }&lt;/pre&gt; &lt;br&gt;</td>
    </tr>
    <tr>
        <td>`POST /items`</td>
        <td>Create</td>
        <td>Create new item the quantity initiale zero</td>
        <td>201 (Created) &lt;br&gt; 401 (Unauthorized) &lt;br&gt; 403 (Forbidden) &lt;br&gt; 429(Too Many Requests) &lt;br&gt; 415 (Unsupported Media Type) &lt;br&gt; 500(Internal Server Error)</td>
        <td>&lt;br&gt;&lt;pre lang=&quot;json&quot;&gt;{&amp;#13; &quot;name&quot;: &quot;item1&quot;, &amp;#13; &quot;description&quot;: &quot;item1 description&quot;, &amp;#13; &quot;price&quot;: 100, &amp;#13; }&lt;/pre&gt; &lt;br&gt;</td>
        <td>&lt;br&gt;&lt;pre lang=&quot;json&quot;&gt;{&amp;#13; &quot;item&quot;: {&amp;#13; &quot;id&quot;: 1, &amp;#13; &quot;name&quot;: &quot;item1&quot;, &amp;#13; &quot;description&quot;: &quot;item1 description&quot;, &amp;#13; &quot;price&quot;: 100, &amp;#13; &quot;quantity&quot;: 10 &amp;#13; } &amp;#13; }&lt;/pre&gt; &lt;br&gt;</td>
    </tr>
    <tr>
        <td>`PUT /items/{id}`</td>
        <td>Update</td>
        <td>Update item by id</td>
        <td>200 (OK) &lt;br&gt; 401 (Unauthorized) &lt;br&gt; 403 (Forbidden) &lt;br&gt; 404 (Not Found) &lt;br&gt; 429(Too Many Requests) &lt;br&gt; 415 (Unsupported Media Type) &lt;br&gt; 500(Internal Server Error)</td>
        <td>&lt;br&gt;&lt;pre lang=&quot;json&quot;&gt;{&amp;#13; &quot;name&quot;: &quot;item1&quot;, &amp;#13; &quot;description&quot;: &quot;item1 description&quot;, &amp;#13; &quot;price&quot;: 100, &amp;#13; }&lt;/pre&gt; &lt;br&gt;</td>
        <td>&lt;br&gt;&lt;pre lang=&quot;json&quot;&gt;{&amp;#13; &quot;item&quot;: {&amp;#13; &quot;id&quot;: 1, &amp;#13; &quot;name&quot;: &quot;item1&quot;, &amp;#13; &quot;description&quot;: &quot;item1 description&quot;, &amp;#13; &quot;price&quot;: 100, &amp;#13; &quot;quantity&quot;: 10 &amp;#13; } &amp;#13; }&lt;/pre&gt; &lt;br&gt;</td>
    </tr>
    <tr>
        <td>`DELETE /items/{id}`</td>
        <td>Delete</td>
        <td>Delete item by id</td>
        <td>204 (No Content) &lt;br&gt; 401 (Unauthorized) &lt;br&gt; 403 (Forbidden) &lt;br&gt; 404 (Not Found) &lt;br&gt; 410 (Gone) &lt;br&gt; 429(Too Many Requests) &lt;br&gt; 500(Internal Server Error)</td>
        <td>N/A</td>
        <td>N/A</td>
    </tr>
    <tr>
        <td>`PATCH /items/{id}`</td>
        <td>Partial Update</td>
        <td>Partial Update item by id</td>
        <td>200 (OK) &lt;br&gt; 401 (Unauthorized) &lt;br&gt; 403 (Forbidden) &lt;br&gt; 404 (Not Found) &lt;br&gt; 429(Too Many Requests) &lt;br&gt; 415 (Unsupported Media Type) &lt;br&gt; 500(Internal Server Error)</td>
        <td>&lt;br&gt;&lt;pre lang=&quot;json&quot;&gt;{&amp;#13; &quot;name&quot;: &quot;item1&quot; &amp;#13; }&lt;/pre&gt; &lt;br&gt;</td>
        <td>&lt;br&gt;&lt;pre lang=&quot;json&quot;&gt;{&amp;#13; &quot;item&quot;: {&amp;#13; &quot;id&quot;: 1, &amp;#13; &quot;name&quot;: &quot;item1&quot;, &amp;#13; &quot;description&quot;: &quot;item1 description&quot;, &amp;#13; &quot;price&quot;: 100, &amp;#13; &quot;quantity&quot;: 10 &amp;#13; } &amp;#13; }&lt;/pre&gt; &lt;br&gt;</td>
    </tr>
</table>


### /suppliers

| HTTP Request | Operation | Description | HTTP Status Code | Request Body Sample | Response Body Sample |
| ------------ | --------- | ----------- | ---------------- | -------------- | --------------- |
| `GET /suppliers`    | Read | Get all suppliers | 200 (OK) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429(Too Many Requests) <br> 500(Internal Server Error) | N/A | <br><pre lang="json">{&#13; "suppliers": [&#13; {&#13; "id": 1, &#13; "name": "supplier1", &#13; "email": "supp@gmail.com", &#13; "phone": "123456789" &#13; }, &#13; {&#13; "id": 2, &#13; "name": "supplier2", &#13; "email": "supp2@gmil.com", &#13; "phone": "123456789" &#13; } &#13; ] &#13; }</pre> <br> |
| `GET /suppliers/{id}` | Read | Get supplier by id | 200 (OK) <br> 401 (Unauthorized)<br> 403 (Forbidden)<br> 404 (Not Found)<br> 429(Too Many Requests)<br> 500(Internal Server Error) | N/A | <br><pre lang="json">{&#13; "supplier": {&#13; "id": 1, &#13; "name": "supplier1", &#13; "email":"supp@gmail.com",&#13; "phone": "123456789" &#13; } &#13; }</pre> <br> |
| `GET /suppliers/{id}/supply` | Read | Get all supplies of a supplier | 200 (OK) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429(Too Many Requests) <br> 500(Internal Server Error) | N/A | <br><pre lang="json">{&#13; "supplies": [&#13; {&#13; "id": 1, &#13; "item_id": 1, &#13; "supplier_id": 1, &#13; "quantity": 10, &#13; "price_per_unit": 100, &#13; "date": "2021-10-10" &#13; }, &#13; {&#13; "id": 2, &#13; "item_id": 2, &#13; "supplier_id": 1, &#13; "quantity": 20, &#13; "price_per_unit": 200, &#13; "date": "2021-10-10" &#13; } &#13; ] &#13; }</pre> <br> |
| `GET /suppliers/{id}/item` | Read | Get the item of a supplier | 200 (OK) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429(Too Many Requests) <br> 500(Internal Server Error) | N/A | <br><pre lang="json">{&#13; "item": {&#13; "id": 1, &#13; "name": "item1", &#13; "description": "item1 description", &#13; "price": 100, &#13; "quantity": 10 &#13; } &#13; }</pre> <br> |
| `POST /suppliers` | Create | Create new supplier | 201 (Created) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500(Internal Server Error) | <br><pre lang="json">{&#13; "name": "supplier1", &#13; "email": "supp@gmail.com", &#13; "phone": "123456789" &#13; }</pre> <br> | <br><pre lang="json">{&#13; "supplier": {&#13; "id": 1, &#13; "name": "supplier1", &#13; "email": "supp@gmail.com", &#13; "phone": "123456789" &#13; } &#13; }</pre> <br> |
| `POST /suppliers/{id}/supply` | Create | Create new supply for a supplier | 201 (Created) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429 (Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500 (Internal Server Error) | <br><pre lang="json">{&#13; "item_id": 1, &#13; "supplier_id": 1, &#13; "quantity": 10, &#13; "price_per_unit": 100, &#13; "date": "2021-10-10" &#13; }</pre> <br> | <br><pre lang="json">{&#13; "supply": {&#13; "id": 1, &#13; "item_id": 1, &#13; "supplier_id": 1, &#13; "quantity": 10, &#13; "price_per_unit": 100, &#13; "date": "2021-10-10" &#13; } &#13; }</pre> <br> |
| `PUT /suppliers/{id}` | Update | Update supplier by id | 200 (OK) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 404 (Not Found) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500(Internal Server Error) | <br><pre lang="json">{&#13; "name": "supplier1", &#13; "email": "supp@gmail.com", &#13; "phone": "123456789" &#13; }</pre> <br> | <br><pre lang="json">{&#13; "supplier": {&#13; "id": 1, &#13; "name": "supplier1", &#13; "email": "supp@gmail.com", &#13; "phone": "123456789" &#13; } &#13; }</pre> <br> |
| `DELETE /supplier/{id}` | Delete | Delete supplier by id | 204 (No Content) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 404 (Not Found) <br> 429(Too Many Requests) <br> 410 (Gone) <br> 500(Internal Server Error) | N/A | N/A |
| `PATCH /suppliers/{id}` | Partial Update | Partial Update supplier by id | 200 (OK) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 404 (Not Found) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500(Internal Server Error) | <br><pre lang="json">{&#13; "name": "supplier1" &#13; }</pre> <br> | <br><pre lang="json">{&#13; "supplier": {&#13; "id": 1, &#13; "name": "supplier1", &#13; "email": "supp@gmail.com", &#13; "phone": "123456789" &#13; } &#13; }</pre> <br> |

### /customers

| HTTP Request | Operation | Description | HTTP Status Code | Request Body Sample | Response Body Sample |
| ------------ | --------- | ----------- | ---------------- | -------------- | --------------- |
| `GET /customers`    | Read | Get all customers | 200 (OK) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429(Too Many Requests) <br> 500(Internal Server Error) | N/A | <br><pre lang="json">{&#13; "customers": [&#13; {&#13; "id": 1, &#13; "name": "customer1", &#13; "email": "customer@gmail.com", &#13; "phone": "123456789" &#13; }, &#13; {&#13; "id": 2, &#13; "name": "customer2", &#13; "email": "customer@gmail.com", &#13; "phone": "123456789" &#13; } &#13; ] &#13; }</pre> <br> |
| `GET /customers/{id}` | Read | Get customer by id | 200 (OK) <br> 401 (Unauthorized)<br> 403 (Forbidden)<br> 404 (Not Found)<br> 429(Too Many Requests)<br> 500(Internal Server Error) | N/A | <br><pre lang="json">{&#13; "customer": {&#13; "id": 1, &#13; "name": "customer1", &#13; "email": "customer@gmail.com", &#13; "phone": "123456789" &#13; } &#13; }</pre> <br> |
| `GET /customers/{id}/order` | Read | Get all orders of a customer | 200 (OK) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429(Too Many Requests) <br> 500(Internal Server Error) | N/A | <br><pre lang="json">{&#13; "orders": [&#13; {&#13; "id": 1, &#13; "item_id": 1, &#13; "customer_id": 1, &#13; "quantity": 10, &#13; "date": "2021-10-10" &#13; }, &#13; {&#13; "id": 2, &#13; "item_id": 2, &#13; "customer_id": 1, &#13; "quantity": 20, &#13; "date": "2021-10-10" &#13; } &#13; ] &#13; }</pre> <br> |
| `POST /customers` | Create | Create new customer | 201 (Created) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500 (Internal Server Error) | <br><pre lang="json">{&#13; "name": "customer1", &#13; "email": "customer@gmail.com", &#13; "phone": "123456789" &#13; }</pre> <br> | <br><pre lang="json">{&#13; "customer": {&#13; "id": 1, &#13; "name": "customer1", &#13; "email": "customer@gmail.com", &#13; "phone": "123456789" &#13; } &#13; }</pre> <br> |
| `POST /customers/{id}/order` | Create | Create new order for a customer | 201 (Created) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500 (Internal Server Error) | <br><pre lang="json">{&#13; "item_id": 1, &#13; "customer_id": 1, &#13; "quantity": 10 &#13; }</pre> <br> | <br><pre lang="json">{&#13; "order": {&#13; "id": 1, &#13; "item_id": 1, &#13; "customer_id": 1, &#13; "quantity": 10, &#13; "date": "2021-10-10" &#13; } &#13; }</pre> <br> |
| `PUT /customers/{id}` | Update | Update customer by id | 200 (OK) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 404 (Not Found) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500(Internal Server Error) | <br><pre lang="json">{&#13; "name": "customer1", &#13; "email": "customer@gmail.com", &#13; "phone": "123456789" &#13; }</pre> <br> | <br><pre lang="json">{&#13; "customer": {&#13; "id": 1, &#13; "name": "customer1", &#13; "email": "Customer@gmail.com", &#13; "phone": "123456789" &#13; } &#13; }</pre> <br> |
| `DELETE /customers/{id}` | Delete | Delete customer by id | 204 (No Content) <br> 401 (Unauthorized) <br> (Forbidden) <br> (Not Found) <br> (Too Many Requests) <br> 410 (Gone) <br> 500(Internal Server Error) | N/A | N/A |
| `PATCH /customers/{id}` | Partial Update | Partial Update customer by id | 200 (OK) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 404 (Not Found) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500(Internal Server Error) | <br><pre lang="json">{&#13; "name": "customer1" &#13; }</pre> <br> | <br><pre lang="json">{&#13; "customer": {&#13; "id": 1, &#13; "name": "customer1", &#13; "email": "customer@gmail.com", &#13; "phone": "123456789" &#13; } &#13; }</pre> <br> |

### /orders

| HTTP Request | Operation | Description | HTTP Status Code | Request Body Sample | Response Body Sample |
| ------------ | --------- | ----------- | ---------------- | -------------- | --------------- |
| `GET /orders`    | Read | Get all orders | 200 (OK) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429(Too Many Requests) <br> 500(Internal Server Error) | N/A | <br><pre lang="json">{&#13; "orders": [&#13; {&#13; "id": 1, &#13; "item_id": 1, &#13; "customer_id": 1, &#13; "quantity": 10, &#13; "date": "2021-10-10" &#13; }, &#13; {&#13; "id": 2, &#13; "item_id": 2, &#13; "customer_id": 1, &#13; "quantity": 20, &#13; "date": "2021-10-10" &#13; } &#13; ] &#13; }</pre> <br> |
| `GET /orders/{id}` | Read | Get order by id | 200 (OK) <br> 401 (Unauthorized)<br> 403 (Forbidden)<br> 404 (Not Found)<br> 429(Too Many Requests)<br> 500(Internal Server Error) | N/A | <br><pre lang="json">{&#13; "order": {&#13; "id": 1, &#13; "item_id": 1, &#13; "customer_id": 1, &#13; "quantity": 10, &#13; "date": "2021-10-10" &#13; } &#13; }</pre> <br> |
| `GET /orders/{id}/item` | Read | Get the item of an order | 200 (OK) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429(Too Many Requests) <br> 500(Internal Server Error) | N/A | <br><pre lang="json">{&#13; "item": {&#13; "id": 1, &#13; "name": "item1", &#13; "description": "item1 description", &#13; "price": 100, &#13; "quantity": 10 &#13; } &#13; }</pre> <br> |
| `POST /orders` | Create | Create new order | 201 (Created) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500 (Internal Server Error) | <br><pre lang="json">{&#13; "item_id": 1, &#13; "customer_id": 1, &#13; "quantity": 10 &#13; }</pre> <br> | <br><pre lang="json">{&#13; "order": {&#13; "id": 1, &#13; "item_id": 1, &#13; "customer_id": 1, &#13; "quantity": 10, &#13; "date": "2021-10-10" &#13; } &#13; }</pre> <br> |
| `PUT /orders/{id}` | Update | Update order by id | 200 (OK) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 404 (Not Found) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500(Internal Server Error) | <br><pre lang="json">{&#13; "item_id": 1, &#13; "customer_id": 1, &#13; "quantity": 10 &#13; }</pre> <br> | <br><pre lang="json">{&#13; "order": {&#13; "id": 1, &#13; "item_id": 1, &#13; "customer_id": 1, &#13; "quantity": 10, &#13; "date": "2021-10-10" &#13; } &#13; }</pre> <br> |
| `DELETE /orders/{id}` | Delete | Delete order by id | 204 (No Content) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 404 (Not Found) <br> 429(Too Many Requests) <br> 410 (Gone) <br> 500(Internal Server Error) | N/A | N/A |
| `PATCH /orders/{id}` | Partial Update | Partial Update order by id | 200 (OK) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 404 (Not Found) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500(Internal Server Error) | <br><pre lang="json">{&#13; "quantity": 10 &#13; }</pre> <br> | <br><pre lang="json">{&#13; "order": {&#13; "id": 1, &#13; "item_id": 1, &#13; "customer_id": 1, &#13; "quantity": 10, &#13; "date": "2021-10-10" &#13; } &#13; }</pre> <br> |

### /supplies
| HTTP Request | Operation | Description | HTTP Status Code | Request Body Sample | Response Body Sample |
| ------------ | --------- | ----------- | ---------------- | -------------- | --------------- |
| `GET /supplies`    | Read | Get all supplies | 200 (OK) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429(Too Many Requests) <br> 500(Internal Server Error) | N/A | <br><pre lang="json">{&#13; "supplies": [&#13; {&#13; "id": 1, &#13; "item_id": 1, &#13; "supplier_id": 1, &#13; "quantity": 10, &#13; "price_per_unit": 100, &#13; "date": "2021-10-10" &#13; }, &#13; {&#13; "id": 2, &#13; "item_id": 2, &#13; "supplier_id": 1, &#13; "quantity": 20, &#13; "price_per_unit": 200, &#13; "date": "2021-10-10" &#13; } &#13; ] &#13; }</pre> <br> |
| `GET /supplies/{id}` | Read | Get supply by id | 200 (OK) <br> 401 (Unauthorized)<br> 403 (Forbidden)<br> 404 (Not Found)<br> 429(Too Many Requests)<br> 500(Internal Server Error) | N/A | <br><pre lang="json">{&#13; "supply": {&#13; "id": 1, &#13; "item_id": 1, &#13; "supplier_id": 1, &#13; "quantity": 10, &#13; "price_per_unit": 100, &#13; "date": "2021-10-10" &#13; } &#13; }</pre> <br> |
| `POST /supplies` | Create | Create new supply | 201 (Created) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500(Internal Server Error) | <br><pre lang="json">{&#13; "item_id": 1, &#13; "supplier_id": 1, &#13; "quantity": 10, &#13; "price_per_unit": 100, &#13; "date": "2021-10-10" &#13; }</pre> <br> | <br><pre lang="json">{&#13; "supply": {&#13; "id": 1, &#13; "item_id": 1, &#13; "supplier_id": 1, &#13; "quantity": 10, &#13; "price_per_unit": 100, &#13; "date": "2021-10-10" &#13; } &#13; }</pre> <br> |
| `PUT /supplies/{id}` | Update | Update supply by id | 200 (OK) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 404 (Not Found) <br> 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500(Internal Server Error) | <br><pre lang="json">{&#13; "item_id": 1, &#13; "supplier_id": 1, &#13; "quantity": 10, &#13; "price_per_unit": 100, &#13; "date": "2021-10-10" &#13; }</pre> <br> | <br><pre lang="json">{&#13; "supply": {&#13; "id": 1, &#13; "item_id": 1, &#13; "supplier_id": 1, &#13; "quantity": 10, &#13; "price_per_unit": 100, &#13; "date": "2021-10-10" &#13; } &#13; }</pre> <br> |
| `DELETE /supplies/{id}` | Delete | Delete supply by id | 204 (No Content) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 404 (Not Found) <br> 429(Too Many Requests) <br> 410 (Gone) <br> 500(Internal Server Error) | N/A | N/A |
| `PATCH /supplies/{id}` | Partial Update | Partial Update supply by id | 200 (OK) <br> 401 (Unauthorized) <br> 403 (Forbidden) <br> 404 (Not Found), 429(Too Many Requests) <br> 415 (Unsupported Media Type) <br> 500(Internal Server Error) | <br><pre lang="json">{&#13; "quantity": 10 &#13; }</pre> <br> | <br><pre lang="json">{&#13; "supply": {&#13; "id": 1, &#13; "item_id": 1, &#13; "supplier_id": 1, &#13; "quantity": 10, &#13; "price_per_unit": 100, &#13; "date": "2021-10-10" &#13; } &#13; }</pre> <br> |


## OpenAPI Documentation
- The OpenAPI v3.1.0 is available in the following link [SwaggerHub]()

