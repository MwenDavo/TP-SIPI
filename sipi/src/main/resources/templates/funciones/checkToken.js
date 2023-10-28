function checkToken(){
    if(localStorage.getItem('token') === 'undefined'){
        window.location.href = 'LoginTestV2.html';
        }
}

checkToken();