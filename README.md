# Springboot REST API project using Postgres Database
This is a spring boot project that implements REST APIs such as POST, GET, PUT and DELETE. 
It uses Postgres Database to store the data. The tables are automatically created when the program runs using Liquibase.
To get more clarity, you can check the android app.
App link: https://play.google.com/store/apps/details?id=com.liveasy.transport

Here are some endpoints you can call :

### Create, Get, Update and Delete information about load details.

```
http://localhost:8080/api/load
http://localhost:8080/api/{loadId}
```

### Create a load

```
POST /api/load
Accept: application/json
Content-Type: application/json

{
    "loadingPoint": "bombay",
    "unloadingPoint": "pune",
    "productType": "wood",
    "truckType": "mercedes",
    "noOfTrucks": "2",
    "weight": "78",
    "comment": "lorem ipsum",
    "shipperId": "A-2",
    "date" : "22-03-2022"
}

Response : Load details successfully added.
```

### Get a list of loads with the shipperId

```
GET /api/load

Query params - (shipperId)

Response : List of loads with this shipperId.
```

### Get load by loadId

```
GET /api/load/{loadId}

Response : Load details with the specific loadId.
```

### Update a load

```
PUT /api/load/{loadId}
Accept: application/json
Content-Type: application/json

{
    "loadId": 1,
    "loadingPoint": "delhi",
    "unloadingPoint": "kanpur",
    "productType": "chemicals",
    "truckType": "canter",
    "noOfTrucks": 2,
    "weight": 200,
    "comment": "lorem ipsum",
    "date": "2022-03-21T18:30:00.000+00:00"
}

Response : Load details successfully updated.
```

### Delete load by loadId

```
DELETE /api/load/{loadId}

Response : Load details successfully deleted.
```
