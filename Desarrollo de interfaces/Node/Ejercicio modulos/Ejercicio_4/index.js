/*
Ejercicio: utilizar la librería de terceros "moment" para procesar fechas y calcular
diferencias entre ellas
*/

const moment = require('moment');

// Fecha actual
let ahora = moment();
// Fecha pasada o vieja
let antes = moment("07/10/2015", "DD/MM/YYYY");
// Fecha futura
let despues = moment("24/05/2020", "DD/MM/YYYY");

// Años desde la fecha vieja a la actual
console.log("Años desde la fecha antigua:", moment.duration(ahora.diff(antes)).years());

// Años y meses hasta llegar a la fecha futura
console.log("Faltan", moment.duration(despues.diff(ahora)).years(), "años y", moment.duration(despues.diff(ahora)).months(), "meses para llegar a la fecha futura");

// Comprobamos que la fecha vieja es efectivamente anterior a la actual
if (antes.isBefore(ahora))
    console.log("La fecha vieja es anterior a la actual");

// Construimos una fecha un mes después de la actual
let unMesDespues = ahora.add(1, 'M');
console.log("Dentro de un mes será el", unMesDespues.format("DD/MM/YYYY"));