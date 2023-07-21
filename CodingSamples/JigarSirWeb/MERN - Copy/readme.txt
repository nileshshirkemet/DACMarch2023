MERN:
    Mongo
    Express
    React
    Node JS
MEAN:
    Mongo
    Express
    Angular
    Node JS

AWS
Devops

E-Commerce
----------------

React
    Components
    --------------------
        Menu
        Register
        Login
        Add Category
        Add Product
        Home
            Show Category
            Show Product
        Cart 
        App ( Main Component)

Node JS
----------------------------

http://localhost:9000/register-action(post)
http://localhost:9000/login-action(post)
http://localhost:9000/category-action(post)
http://localhost:9000/product-action(post)
http://localhost:9000/show-category(get)
http://localhost:9000/show-product(get)

MongoDB
--------------------
1 mernProject - Database
    collections
        users
        categories
        products


11) npx create-react-app client

12) in server/ folder run--> npm init -y

13) in server/
npm install express monk body-parser

14) create index.js

15) in package.json 
change:
"scripts": {
    "start": "nodemon index.js"
}

16) in client/src create components folder

17) in components/ create following components
( Perform rfc )
Menu.js
Login.js
Register.js
Home.js
    Showcategory.js
    Showproduct.js
Addcategory.js
Addproduct.js
Cart.js
App.js


18) Routing in React
https://reactrouter.com/en/main/start/tutorial
refer a diagram routing.jpg

19) install in client/
npm install react-router-dom

20) create routing in index.js

this is sample code
const clientRoutes = createBrowserRouter([
    {
      path:"/",
      element:<App />,
      children:[
        {
          path:"newuser",
          element:<Register />
        },
        {
          path:"login",
          element:<Login />
        },
        {
          path:"cart",
          element:<Cart />
        }
      ]
    }
]);

21) complete Home Component with
show cate
show product

22) use mernproject
    db.createCollection("categories");
    db.createCollection("products");
    db.createCollection("users");
    show collections;

23)
    db.categories.insert({name:"mens"});
    db.categories.insert({name:"women"});
    db.categories.find();
24) db.products.insert({
    name:"product 1",
    price:1000,
    category:"64ba26908fdf22b8fc4484e6"
});
db.products.insert({
    name:"product 2",
    price:2000,
    category:"64ba26908fdf22b8fc4484e6"
})
db.products.insert({
    name:"product 3",
    price:3000,
    category:"64ba26908fdf22b8fc4484e7"
});
db.products.insert({
    name:"product 4",
    price:5000,
    category:"64ba26908fdf22b8fc4484e7"
});

db.products.find();

25) fetch routes in category , product component

http://localhost:9000/show-category
http://localhost:9000/show-product

26) resolve errors which belongs to CORS
on server side env

npm i cors

server/index.js file
-----------------------------------
var cors = require('cors')
app.use(cors())

27) 
connect mongodb Database in 
server/index.js file using monk

const db = require('monk')('localhost:27017/mernproject')

28) in show category and in show product component

create state variable and store values from an api

29)
install redux devtool for browser
https://chrome.google.com/webstore/detail/redux-devtools/lmhkpmbekcpmknklioeibfkpmmfibljd

30)
Install redux :

https://redux-toolkit.js.org/introduction/getting-started

npm install @reduxjs/toolkit
npm install react-redux