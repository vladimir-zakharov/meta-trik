function sendNetworkData(paramString) {
    var xhr = new XMLHttpRequest();
    xhr.open("post", "/network/wpa-writer"); 
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
            if (xhr.status == 200) {
                successMessage.style.display = 'block';
            } else if (xhr.status == 422) {
                errorMessage.innerHTML = 'Размер пароля должен быть в диапазоне 8..63 символов!';
                errorMessage.style.display = 'block';
            } else if (xhr.status == 500) {
                errorMessage.innerHTML = 'Внутреняя ошибка сервера. Пожалуйста, попробуйте снова.';
                errorMessage.style.display = 'block';
            }
        }
    };

    xhr.send(paramString);
}

function handle() {
    successMessage.style.display = 'none';
    errorMessage.style.display = 'none';
    var essid = document.getElementById("essid").value;
    var password = document.getElementById("password").value;
    sendNetworkData("essid=" + essid + "&password=" + password);    
}

var successMessage = document.getElementById('success_msg');
var errorMessage = document.getElementById('error_msg');
