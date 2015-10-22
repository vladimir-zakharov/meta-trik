var successMessage = document.getElementById('success_msg');
var errorMessage = document.getElementById('error_msg');

function sendHostnameToServer(paramString) {
    var xhr = new XMLHttpRequest();
    xhr.open("post", "hostname-writer"); 
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
            if (xhr.status == 200) {
                successMessage.style.display = 'block';
            } else if (xhr.status == 500) {
                errorMessage.innerHTML = 'Внутреняя ошибка сервера. Пожалуйста, попробуйте снова.';
                errorMessage.style.display = 'block';
            }
        }
    };

    xhr.send(paramString);
}

function validate(str) {
    return /^\s*((?=.{1,255}$)[0-9A-Za-z](?:(?:[0-9A-Za-z]|\b-){0,61}[0-9A-Za-z])?(?:\.[0-9A-Za-z](?:(?:[0-9A-Za-z]|\b-){0,61}[0-9A-Za-z])?)*\.?)\s*$/.test(str);
}

function submitHostname() {
    successMessage.style.display = 'none';
    errorMessage.style.display = 'none';
    var hostname = document.getElementById("hostname").value;
    if (validate(hostname)) {
        var params = "hostname=" + hostname;
        sendHostnameToServer(params);
    } else {
        console.log("test");
        errorMessage.innerHTML = 'Имя содержит недопустимые символы или состоит из более 255 символов. Пожалуйста, измените имя.';
        errorMessage.style.display = 'block';
    }
}
