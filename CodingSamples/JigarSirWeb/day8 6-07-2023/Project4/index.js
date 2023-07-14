const express = require("express");
// console.log(typeof express);
const app = express()
// console.log(app);
// creating routes in node js appli using express
app.get("/register", (req, res) => {
   // res.end("register page")
   res.render("register.ejs")
})
app.get("/login", (req, res) => {
 //   res.end("login page")
 res.render("login.ejs")
})
app.get("/", (req, res) => {
  //  res.end("home page")
  res.render("home.ejs")
})
app.listen(8000)
