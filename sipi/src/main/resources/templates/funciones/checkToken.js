function checkToken(){
    if(localStorage.getItem('token') == null){
        window.location.href = 'LoginTestV2.html';
        }
}

checkToken();