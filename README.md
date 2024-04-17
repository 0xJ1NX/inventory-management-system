# inventory-management-system

<p align="center">
  <img src="./images/inv-manage-sys.png" alt="Inventory Management System logo" width="300" >
</p>

This is a simple inventory management system REST API, that allow managing Items, Customers, Orders, Suppliers, and supplies.
> [!NOTE]
> The API still under development and the documentation is not complete yet.


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
- [📦 Installation](#-installation)


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


### /suppliers


### /customers


### /orders


### /supplies


## OpenAPI Documentation

<p align="center">
    <img src="./images/openapi-logo.png" alt="OpenAPI v3.1.0"  width="150" >
</p>


- The OpenAPI v3.1.0 is available in the following link [SwaggerHub](https://app.swaggerhub.com/apis/1201062/Inventory-management-system/1.0.0#/)




## Postman Collection

<p align="center">
    <img src="./images/postman-icon.svg" alt="Postman"  width="130" >
</p>

- The Postman collection is in the following file [Postman Collection](./postman/IMA.postman_collection.json)

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

