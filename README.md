# API Crud Spring Boot Spring Data Jersey

# ADD or Modify
* POST: http://localhost:8080/customer/addOrUpdate
* Body: {
    "id": 1,
    "firstName": "Fabio",
    "lastName": "Vinicius"
}

# Delete

* POST: http://localhost:8080/customer/delete
* Body: {
    "id": 1,
    "firstName": "",
    "lastName": ""
}

# GET by id

* POST: http://localhost:8080/customer/getById
* Body: {
    "id": 1,
    "firstName": "",
    "lastName": ""
}

# List

* GET: http://localhost:8080/customer/list
