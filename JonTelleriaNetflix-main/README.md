# JonTelleria NetflixRestAPI

This proyect has been developed by Jon Telleria student from Uni Eibar-Ermua.
First of all you have run de CSV to Json Converter for getting the Output.json to introduce it on the Database collection of mongo.


- Swagger access: http://localhost:8081/swagger-ui/index.html
- MongoDB connection String: mongodb+srv://admin:Admin123@cluster0.fzi8fxy.mongodb.net/?retryWrites=true&w=majority
- Database : netflix
- Collection : titles
- Usuario:admin
- Password:Admin123
- IP: 90.94.70.127/32 

## Dataset 
The dataset has been adquiered from https://www.kaggle.com/datasets/victorsoeiro/netflix-tv-shows-and-movies the dataset was originally taken as two CSV documents. After that y get a JSON file convinating both json with the conversor. To provide further detail about the data structure, I have created a Titles object, which contains an ArrayList of Credits objects within it. Before the dataset was imported to a MongoDB database it has been shorted beacouse if not it will bring us in the swagger doing it very slow. 


## Rest Service

As you can see in the image bellow you can see there are diferent endpoints as Put, Get ,Post & Update


<img src="./Swagger.png" width=%40>
In the image bellow you can see the expanation of the diferent endpoints.

<img src="./tabla.png" width=%40>


## MongoDB

This SpringBoot application is a service that creates request for a MongoDB database. For creating the database you can do it from mongo atlas or you cano install the Community edition of MongoDB and MongoDB Compass that is a MongoDB client. Once installed we open the client and we create a connection to the atlas. Here you can create remote connections to servers, to the local machine and even to the MongoDB cluster or the Cloud. To access to the databse you have to enter the data from the beggining.


## Class Diagram

<img src="./Diagrama.png" width=%100>
