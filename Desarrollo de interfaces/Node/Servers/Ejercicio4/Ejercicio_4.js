const fs = require('fs');

var miStream = fs.createReadStream(__dirname+'/ghettobrothers.txt',{'bufferSize':1024});
var miStreamEscr = fs.createWriteStream(__dirname+'/ghettobrothercopia.txt');

miStream.on('data',function(chunk){
    console.log('nuevo trozo recibido');
    miStreamEscr.write(chunk);
});

