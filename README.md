# Item Management REST API

A simple Java Spring Boot backend application that provides RESTful APIs to manage a collection of items.  
This project demonstrates clean API design, input validation, in-memory data management, and global exception handling.

---

## 🚀 Features

- Add a new item
- Fetch an item by ID
- Input validation for request payloads
- Global exception handling with meaningful HTTP responses
- In-memory data storage using `ArrayList`
- Clean and readable JSON error responses

---

## 🛠 Tech Stack

- Java 21
- Spring Boot
- Spring Web
- Jakarta Bean Validation
- Maven

---

## 📦 Data Storage

- Uses **in-memory storage** (`ArrayList`)
- Data is **not persisted**
- Items reset when the application restarts

---

## 📑 Item Model

Each item contains the following fields:

| Field           | Type      | Description                          |
|----------------|-----------|--------------------------------------|
| id             | Long      | Auto-generated unique identifier     |
| name           | String    | Name of the item (required)          |
| description    | String    | Description of the item (required)   |
| price          | Double    | Price of the item (must be positive) |
| stockQuantity  | Integer   | Available stock (>= 0)               |

---

## 🔗 API Endpoints

### Add a new item
**POST** `/api/items`

**Request Body**
```json
{
  "name": "Wireless Mouse",
  "description": "Ergonomic wireless mouse",
  "price": 799.99,
  "stockQuantity": 10
}

Response – 201 Created
{
  "id": 1,
  "name": "Wireless Mouse",
  "description": "Ergonomic wireless mouse",
  "price": 799.99,
  "stockQuantity": 10
}
Get item by ID
GET /api/items/{id}
Response – 200 OK
{
  "id": 1,
  "name": "Wireless Mouse",
  "description": "Ergonomic wireless mouse",
  "price": 799.99,
  "stockQuantity": 10
}

❗ Error Handling
The application uses global exception handling to return clean and meaningful error responses.
Validation Error (400 Bad Request)
{
  "description": "Description is required"
}
Item Not Found (404 Not Found)
{
  "status": 404,
  "error": "Not Found",
  "message": "Item not found with id: 99",
  "timestamp": "2026-02-05T18:10:30"
}


▶️ Run Locally
## Prerequisites ##
- Java 21
- Maven

Steps:
git clone https://github.com/Vanshita-baghel/item-management-api
cd item-management-api
mvn spring-boot:run
Application will start at:
http://localhost:8080


🌐 Live Deployment
Base URL (Live):
https://item-management-api-ikho.onrender.com
Note: Since the application uses in-memory storage, all data will reset if the service  
restarts.


🔐 Security Notes
Authentication and authorization are intentionally not implemented as they were out of 
scope for this task.
In a production environment, endpoints can be secured using Spring Security and 
JWT-based authentication.


📝 Notes
Item IDs are generated server-side to prevent client manipulation.
Designed to be simple, readable, and easy to extend.

