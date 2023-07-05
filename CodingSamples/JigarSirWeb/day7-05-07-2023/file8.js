var fs = require("fs")
var http = require("http")

http.createServer((req , res)=>{
   // res.end("hello world")
   fs.readFile("./file8.html","utf-8" , (err , data)=>{
           if(err){
            console.log(err);
           }else{
            res.end(data)
           }
   })
}).listen(8000)