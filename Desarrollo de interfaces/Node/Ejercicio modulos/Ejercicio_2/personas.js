/*
Módulo auxiliar con métodos para gestionar la inserción y borrado de personas
*/

// Arrow function para añadir personas, siempre que no exista ya su teléfono
let nuevaPersona = (vectorPersonas, persona) => {
    return new Promise((resolve, reject) => {
        let existe = vectorPersonas.filter(pers => pers.telefono === persona.telefono);
        if (existe.length == 0) {
            vectorPersonas.push(persona);
            resolve(persona);
        } else {
            reject("Error: el teléfono ya existe");
        }  
    });
}

// Arrow function para borrar una persona por su teléfono
let borrarPersona = (vectorPersonas, telefono) => {
    return new Promise((resolve, reject) => {
        let existePersona = vectorPersonas.filter(persona => persona.telefono === telefono);
        if (existePersona.length > 0) {
            vectorPersonas = vectorPersonas.filter(persona => persona.telefono != telefono);
            resolve(existePersona[0]);
        } else {
            reject("Error: no se han encontrado coincidencias");
        }
    });
}

module.exports = {
    nuevaPersona: nuevaPersona,
    borrarPersona: borrarPersona
};