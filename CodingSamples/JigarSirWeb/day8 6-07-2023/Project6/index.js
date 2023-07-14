const db = require("monk")("127.0.0.1:27017/cdac")
const bodyparser = require("body-parser");
// const e = require("express");
const express = require("express")
var mysql = require('mysql');
var cors = require('cors');
var connection = mysql.createConnection({
    host     : 'localhost',
    user     : 'root',
    password : 'root',
    database : 'cdac'
  });
const app = express()
app.use(cors())
app.use(bodyparser.urlencoded())
app.use(bodyparser.json())


app.get("/users" ,(req , res)=>{
  //  res.send("get route tested")
  db.get("users").find().then((results)=>{
     res.send(results)
  })
})
app.post("/users" ,(req , res)=>{
   // res.send("post route tested")
   console.log(req.body);
   db.get("users").insert(req.body).then((results)=>{
    res.send(results)
 })
})
app.put("/users" ,(req , res)=>{
    res.send("put route tested")
})
app.delete("/users" ,(req , res)=>{
    res.send("delete route tested")
})
app.get("/emp" ,(req,res)=>{
    connection.query('select * from emp ', function (error, results, fields) {
        if(!error){
            res.send(results)
        }
        else{
            console.log(error);
        }
      });
})
app.listen(8000)