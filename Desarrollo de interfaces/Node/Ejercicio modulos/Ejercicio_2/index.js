/*
Ejercicio para practicar con inclusión de módulos
Versión alternativa del ejercicio 1.4 donde separamos en un módulo aparte los métodos para
tratar el alta o baja de personas de un vector
*/

// Incluimos el módulo
const personas = require(__dirname + '/personas');

// Vector inicial de personas
let datos = [
    {nombre: "Nacho", telefono: "966112233", edad: 40},
    {nombre: "Ana", telefono: "911223344", edad: 35},
    {nombre: "Mario", telefono: "611998877", edad: 15},
    {nombre: "Laura", telefono: "633663366", edad: 17}
];

// Programa principal

// Inserciones
personas.nuevaPersona(datos, {nombre: "Juan", telefono:"965661564", edad: 60}).then(resultado => {
    console.log("Añadida persona:", resultado);
}).catch(error => {
    console.log(error);
});
personas.nuevaPersona(datos, {nombre: "Rodolfo", telefono:"910011001", edad: 20}).then(resultado => {
    console.log("Añadida persona:", resultado);
}).catch(error => {
    console.log(error);
});
// Inserción repetida para que dé error
personas.nuevaPersona(datos, {nombre: "Rodolfo", telefono:"910011001", edad: 20}).then(resultado => {
    console.log("Añadida persona:", resultado);
}).catch(error => {
    console.log(error);
});

// Borrados
personas.borrarPersona(datos, "910011001").then(resultado => {
    console.log("Borrada persona:", resultado);
}).catch(error => {
    console.log(error);
});
// Borrado con número equivocado para que dé error
personas.borrarPersona(datos, "000000000").then(resultado => {
    console.log("Borrada persona:", resultado);
}).catch(error => {
    console.log(error);
});
console.log(datos);