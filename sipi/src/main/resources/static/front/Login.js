const axios = require('axios');

const apiUrl = 'https://tu-api-spring-boot.com';

// Ejemplo de inicio de sesión
axios.post(`${apiUrl}/login`, {
    username: 'usuario',
    password: 'contraseña',
})
    .then(response => {
        console.log('Respuesta del servidor:', response.data);
    })
    .catch(error => {
        console.error('Error en la solicitud:', error.message);
    });
