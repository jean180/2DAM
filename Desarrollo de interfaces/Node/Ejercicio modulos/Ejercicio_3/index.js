/* 
Ejercicio: utilizar el módulo de terceros "lodash" para sacar unidos
por comas los nombres de un vector 
*/

const lo = require('lodash');
const nombres = ["Nacho", "Ana", "Mario", "Laura"];
console.log(lo.join(nombres, ":"));
