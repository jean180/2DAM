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
    },
    pegi: {
        type: String,
        required: true,
        minlength: 1,
        trim: true
    }
});

//modelo
let Videojuego = mongoose.model('videogames', videojuegosSchema);

//busqueda con find
let p1 = Videojuego.find().then(resultado => {
    MostrarTodo();
}).catch(error => {
    console.log("ERROR en find");
});

function MostrarTodo() {
    Videojuego.find().then(resultado => {
        let cadenaDOM = "";
        resultado.forEach(videogame => {
            cadenaDOM +=
                `<x-accordion>
                        <header>
                            <x-label style="width: 100px;">
                            <strong>${videogame.title}</strong>
                            </x-label>
                            <x-label>${videogame.category}</x-label>
                        </header>
                        <main><p>
                            <x-label><img src="./images/${videogame.img}" height="170" width="108"></x-label>
                            <x-label>+${videogame.pegi}</x-label></p>
                        </main>
                    </x-accordion>
                    <hr>`;
        });
        document.getElementById("cargando").style.display = "none";
        document.getElementById("wrapper").style.display = "block";
        document.getElementById("wrapper").innerHTML = cadenaDOM;
    }).catch(error => {
        console.log("ERROR en find");
    });
}