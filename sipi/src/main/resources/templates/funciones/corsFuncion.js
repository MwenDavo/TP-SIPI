const express = require('express');
const cors = require('cors');

const app = express();

// Configuración básica de cors
app.use(cors());

// Resto de tu configuración del servidor
// ...

// Escucha en el puerto 8080
app.listen(8080, () => {
    console.log('Servidor escuchando en el puerto 8080');
});
