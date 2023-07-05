const xyz = require("http")
const server = xyz.createServer((req , res)=>{
    res.end("hello world")
})
server.listen(8000)