const mongoose = require('mongoose');
mongoose.Promise = global.Promise;
//conexión
mongoose.connect('mongodb://localhost:27017/videogames', {
    useNewUrlParser: true,
    useUnifiedTopology: true
});
//esquema
let videojuegosSchema = new mongoose.Schema({
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
let Videojuego = mongoose.model('videogames', videojuegosSchema);