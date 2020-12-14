const http=require('http');
const fs = require('fs');

fs.readFile('./readme.txt','utf8', (err, data) => {
    if (err) throw err;
    console.log('reading asynchronous file');
    console.log(data);

    fs.writeFile('./writeme.txt',data,(err) =>{
        if (err) throw err;
        err
            ? console.log(err)
            : console.log('File written correctly');
    })
});

fs.rename('./readme.txt','./leeme.txt', (err) =>{
    if (err) throw err;
    console.log('Nombre Editado satisfactoriamente');
});
fs.stat('./leeme.txt',(err, stats) =>{
    if (err) throw err;
    console.log(stats);
});

fs.unlink('./stuff/writeMe.txt',function(){
    fs.mkdir('stuff', function(err){
        if(err){
            throw err + ' borrando carpeta stuff';
        }
    });
}, function (err){
    if(err){
        throw err + ' borrando archivo stuff/writeMe.txt';
    }
});