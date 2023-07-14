const db = require('monk')('127.0.0.1:27017/cdac')
var bodyParser = require('body-parser')
//console.log(db);

const express = require("express")
const app = express()
app.use(bodyParser.urlencoded())


app.get("/",(req , res)=>{
  db.get("users").find({}).then((results)=>{
    console.log(results);
    res.render("home.ejs",{x:results})
  })     
})

app.get("/add",(req , res)=>{
    res.render("adduser.ejs")
 })
app.post("/register",(req , res)=>{
    //res.end("route tested")
    console.log(req.body);
    // undefined or {name , age}
    db.get("users").insert(req.body).then((results)=>{
              //    console.log(results);
              res.redirect("/")
    })
}) 

app.listen(8000) 