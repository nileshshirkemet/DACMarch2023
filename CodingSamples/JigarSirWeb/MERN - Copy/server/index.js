const express = require('express');
var cors = require('cors')
const db = require('monk')('127.0.0.1:27017/mernproject');

const bodyParser = require('body-parser');

const app = express();
app.use(cors());
// app.use(bodyParser.urlencoded())
app.use(bodyParser.json())


app.get("/show-category" , (req,res)=>{
    //fetch products & categories from collection
    db.get('categories').find().then(function(resultFromDb){
        console.log(resultFromDb);
        res.send({valuesFromNode:resultFromDb})
    }).catch(err=>{
        console.log(err);
    })
    
})
app.get("/show-product" , (req,res)=>{
    //fetch products & categories from collection
    db.get('products').find().then(results=>{
        console.log(results);
        res.send({msg:results})
    }).catch()
})
app.post("/register-action" , (req,res)=>{
   //insert record in mongodb database 
   res.send('register-action called')

})
app.post("/login-action" , (req,res)=>{
    // check user with database
   res.send('login-action called')

})
app.post("/category-action" , (req,res)=>{
    //insert record in category collection
    // console.log(req.body);
    // {name:'kids'}
//    res.send('category-action called');

    db.get('categories').insert(req.body).then(()=>{
        res.send({msg : "Category Added" , status:true })
    })
})
app.post("/product-action" , (req,res)=>{
    //add product in product collection
   res.send('product-action called')

})

app.listen(9000);