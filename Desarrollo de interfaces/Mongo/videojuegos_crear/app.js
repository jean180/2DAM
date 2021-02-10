const mongoose = require('mongoose');
const fs = require('fs');
const { title } = require('process');

let file = fs.readFileSync('./videojuegos.json');
var videojuegos = JSON.parse(file);

mongoose.Promise = global.Promise;
//conexion 
const url = 'mongodb://localhost:27017/videogames';
mongoose.connect(url, {
    useNewUrlParser: true,
    useCreateIndex: true,
    useUnifiedTopology: true
}).then(() => { console.log('connection succesful')})
    .catch((err) => {
        console.log('connection error')
    });

//esquema
let videojuegosSchema = new mongoose.Schema({
    title: String,
    category: String,
    img: String,
});

videojuegosSchema = new mongoose.Schema({
    title: {
        type: String,
        required: true,
        minlength: 1,
        unique: true,
        trim: true
    },
    category: {
        type: String,
        required: true,
        minlength: 1,
        trim: true
    },
    img: {
        type: String,
        required: true,
        minlength: 1,
        trim: true
    }
});


//modelo 
let Videojuegos = mongoose.model('videogames', videojuegosSchema);
let p1
videojuegos.forEach(Videojuego => {
    let juego = new Videojuegos();
    juego.title = Videojuego.title;
    juego.category = Videojuego.category;
    juego.img = Videojuego.img;
    p1 = juego.save().then(result => {
        console.log("Juego added:", result);
    }).catch(error => {
        console.log("ERROR adding book:", error);
    });

});
Promise.all([p1]).then(values => {
    mongoose.connection.close();
})