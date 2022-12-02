# Completed Coding Challenge - Alvaro Castro Cid - Software Engineer : alvarocastrocid1@gmail.com;
## Completed Challenge Overview;
### Task 1 : How To Use 
The following endpoint is available to use: 
```
* READ
  * HTTP Method: GET
  * URL: localhost:8080/reports/{id}
  * BODY: NONE
  * RESPONSE: ReportingStructure
  * NOTES: id is an employeeId
  
```
### Task 2 : How To Use 
The following endpoints are available to use: 
```
* CREATE
  * HTTP Method: POST
  * URL: localhost:8080/gencompensation/{id}
  * BODY: { "salary" : 105000 } 
  * RESPONSE: Compensation
  * NOTES: Here is an id to test : 03aa1462-ffa9-4978-901b-7c001562cf6f
           Moreover, the value for "salary" can be set to any integer.

* READ
  * HTTP Method: GET
  * URL: localhost:8080/compensation/{compensationId}
  * BODY: NONE
  * RESPONSE: Compensation
  * NOTES: compensationId can be retrieved from the Compensation response object
           after a new compensation is created. Otherwise here is a test compensationId : 16a596ae-edd3-4847-99fe-c4518e82c86ftest
  
```

The ReportingStructure has a JSON schema of:
```json
{
  "type":"ReportingStructure",
  "properties": {
    "employeeId": {
      "type": "string"
    },
    "numberOfReports": {
      "type": "int"
    },
  }
}
```

The Compensation has a JSON schema of:
```json
{
  "type":"Compensation",
  "properties": {
    "compensationId": {
      "type": "string"
    },
    "employee": {
      "type": Employee
    },
    "salary" : {
      "type": "int"
    },
    "date" : {
      "type" : "string"
    }
  }
}
```
#Final Notes: 

I'm excited to get to discuss the project! It was a lot of fun. 

Please feel free to reach out if you have any questions. 

Best of regards, 

Alvaro 

Software Engineer 
alvarocastrocid1@gmail.com
