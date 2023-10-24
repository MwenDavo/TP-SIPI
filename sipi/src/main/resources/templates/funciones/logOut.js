function LogOut(){
    localStorage.removeItem('token');
    // Puedes redirigir a la página de inicio de sesión u realizar otras acciones después del cierre de sesión
    console.log('Sesión cerrada. Redirigiendo...');
    // Ejemplo de redirección a la página de inicio de sesión
    window.location.href = 'LoginTestV2.html';
}