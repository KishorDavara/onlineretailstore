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