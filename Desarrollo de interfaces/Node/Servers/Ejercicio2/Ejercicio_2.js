const http=require('http');
const fs = require('fs');

var server = http.createServer(function(req,res){
    res.writeHead(200, {'Content-type':'application/json'});
    var file = fs.readFileSync('clients.json','utf8');
    res.end(file);
})

server.listen(3000, '127.0.0.1');