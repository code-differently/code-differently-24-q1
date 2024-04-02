const { error } = require('console')
const http = require('http')
const port = 3000

const server = http.createServer(function(req, res){

res.write( "Test")
res.end

})

server.listen(port,function(error){
if (error) {
    console.log("something went wrong", error)
} else {
    console.log("server is listening on port" + port)
}





})