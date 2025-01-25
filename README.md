**Comprehensive Documentation: Running ToDo and Post API with Postman**

 **Introduction**
In this documentation, I provided step-by-step guidance on using Postman to test the basic CRUD (Create, Read, Update, Delete) functionalities, including the `PATCH` method, for the ToDo and Post APIs I implemented using the JSONPlaceholder API.

 **Pre-requisites**
1. **Postman Installation**:
   - Ensure you have [Postman](https://www.postman.com/downloads/) installed on your system.

2. **Start the Application**:
   - Run your Spring Boot application. Confirm it is running on `http://localhost:8080` (or your configured port).

3. **Base URLs**:
   - For **Posts API**: `http://localhost:8080/posts`
   - For **Todos API**: `http://localhost:8080/todos`

 **1. CREATE (POST)**
 **Create a Post**
 **Endpoint**: `POST /posts`
 **URL**: `http://localhost:8080/posts`
**Request Body (JSON)**:
```json
{
  "title": "Sample Post Title",
  "body": "This is a sample body of the post."
}
```
 **Expected Response (JSON)**:
```json
{
  "id": 101,
  "title": "Sample Post Title",
  "body": "This is a sample body of the post."
}
```

 **Create a ToDo**
 **Endpoint**: `POST /todos`
 **URL**: `http://localhost:8080/todos`
 **Request Body (JSON)**:
```json
{
  "title": "Sample ToDo Title"
}
```
 **Expected Response (JSON)**:
```json
{
  "id": 101,
  "title": "Sample ToDo Title"
}
```

**2. READ (GET)**
**Get All Posts**
- **Endpoint**: `GET /posts`
- **URL**: `http://localhost:8080/posts`
- **Expected Response (JSON)**:
```json
[
  {
    "id": 1,
    "title": "First Post",
    "body": "This is the first post."
  },
  {
    "id": 2,
    "title": "Second Post",
    "body": "This is the second post."
  }
]
```
 **Get a Post by ID**
 **Endpoint**: `GET /posts/{id}`
**URL**: `http://localhost:8080/posts/1`
**Expected Response (JSON)**:
```json
{
  "id": 1,
  "title": "First Post",
  "body": "This is the first post."
}
```

 **Get All Todos**
 **Endpoint**: `GET /todos`
 **URL**: `http://localhost:8080/todos`
**Expected Response (JSON)**:
```json
[
  {
    "id": 1,
    "title": "First ToDo"
  },
  {
    "id": 2,
    "title": "Second ToDo"
  }
]
```

**Get a ToDo by ID**
 **Endpoint**: `GET /todos/{id}`
 **URL**: `http://localhost:8080/todos/1`
 **Expected Response (JSON)**:
```json
{
  "id": 1,
  "title": "First ToDo"
}
```

 **3. UPDATE (PUT)**
 **Update a Post**
 **Endpoint**: `PUT /posts/{id}`
 **URL**: `http://localhost:8080/posts/1`
 **Request Body (JSON)**:
```json
{
  "title": "Updated Post Title",
  "body": "Updated content of the post."
}
```
 **Expected Response (JSON)**:
```json
{
  "id": 1,
  "title": "Updated Post Title",
  "body": "Updated content of the post."
}
```

 **Update a ToDo**
 **Endpoint**: `PUT /todos/{id}`
 **URL**: `http://localhost:8080/todos/1`
 **Request Body (JSON)**:
```json
{
  "title": "Updated ToDo Title"
}
```
 **Expected Response (JSON)**:
```json
{
  "id": 1,
  "title": "Updated ToDo Title"
}
```

 **4. PARTIAL UPDATE (PATCH)**
 **Partially Update a Post**
 **Endpoint**: `PATCH /posts/{id}`
 **URL**: `http://localhost:8080/posts/1`
 **Request Body (JSON)**:
```json
{
  "title": "Partially Updated Post Title"
}
```
 **Expected Response (JSON)**:
```json
{
  "id": 1,
  "title": "Partially Updated Post Title",
  "body": "This is the first post."
}
```

**Partially Update a ToDo**
 **Endpoint**: `PATCH /todos/{id}`
 **URL**: `http://localhost:8080/todos/1`
 **Request Body (JSON)**:
```json
{
  "title": "Partially Updated ToDo Title"
}
```
 **Expected Response (JSON)**:
```json
{
  "id": 1,
  "title": "Partially Updated ToDo Title"
}
```
 **5. DELETE**
 **Delete a Post**
 **Endpoint**: `DELETE /posts/{id}`
 **URL**: `http://localhost:8080/posts/1`
**Expected Response**:
 Status Code: `200 OK`
 No body is returned.

 **Delete a ToDo**
 **Endpoint**: `DELETE /todos/{id}`
 **URL**: `http://localhost:8080/todos/1`
 **Expected Response**:
 Status Code: `200 OK`
 No body is returned.

**Notes**
1. Ensure the JSON payloads are properly formatted in Postman when sending requests.
2. Use the `Params` tab in Postman to pass any required path variables (like `{id}`).
3. If the application throws errors like `Ambiguous Mapping`, verify that endpoints in `PostController` and `TodoController` are unique.


 **Postman Collection Export**
You can also create a Postman collection for these endpoints, organize them by HTTP methods, and you can then export it for sharing with members of your team.


This documentation should help you thoroughly test all CRUD functionalities of the ToDo and Post rest APIs (sending and getting requests from the json-place-holder) using Postman.

