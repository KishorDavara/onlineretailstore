# onlineretailstore

=> Product Rest end points

- create product: POST   /products
   example json:
     {
       "name": "Orange",
       "price": 150,
       "productCategoryId": 2
     }
- Update product: PUT  /products/{id}
   example json:
     {
       "name": "Orange",
       "price": 200,
       "productCategoryId": 3
     }
- Delete product: DELETE  /products/{id}

- Get the list of products with only required details: GET /products

- Get the list of products with complete details: GET /products/full

- Get the product by Id with only required details: GET /products/{id}

- Get the product by Id with complete details: GET /products/full/{id}


=> Bill Rest end points

- create bill: POST /bills
  example json:
   {
	"billProducts": [
		{
		  "productId": 4,
		  "quantity": 2
		},
		{
		  "productId": 5,
		  "quantity": 6
		},
		{
		  "productId": 6,
		  "quantity": 3
		}
		]	
   }
   
- Update bill: PUT /bills/{id}
   {
	"billProducts": [
		{
		  "productId": 4,
		  "quantity": 2
		},
		{
		  "productId": 5,
		  "quantity": 6
		},
		{
		  "productId": 6,
		  "quantity": 3
		}
		]	
  }
- Delete bill: DELETE /bills/{id}

- Get the list of bill with only required details: GET /bills

- Get the list of bill with complete details: GET /bills/full

- Get the bill by Id with only required details: GET  /bills/{id}

- Get the bill by Id with complete details: GET /bills/full/{id}


# Installation and application setup:
=> Prerequsites: Installed Maven,Git,JDK

=> setup and build the application on the local environment:
- create the folder of your choice.
- go to that folder
- open cmd or git bash
- initiliaze git repository using "git init"
- clone repository using "git clone https://github.com/KishorDavara/onlineretailstore.git"
- go to basefolder ex; onlineretailstore
- run the command "mvn package" to install dependencies and build the application
- after build successful go to "target" folder
- run the command "java -jar checkout-0.0.1-SNAPSHOT.jar" and if you want to run the application on different port ie; 8181 run the command like "java -jar checkout-0.0.1-SNAPSHOT.jar --server.port=8181"
- It will start the spring boot application.
- Open your favorite API Development Tool and execute the above APIs to perform operations for products and bills.
   
