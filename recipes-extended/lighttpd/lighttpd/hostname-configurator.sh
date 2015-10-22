cat << EOF
Content-Type: text/html

<html>
<head>

<title>hostname configurator</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="/styles/network-base.css">
<link rel="stylesheet" type="text/css" href="/styles/hostname-base.css">

</head>
<body>

<h2>Введите новое имя робота</h2>

<div id="success_msg" class="success">Данные успешно занесены!</div>
<div id="error_msg" class="error"></div>

<form id="submitForm" action="javascript:void(0);">
    Имя робота: <input type="text" id="hostname">
    <input class="btn" type="button" onclick="submitHostname()" value="Изменить">
</form>    

<script src="/js/hostname-configurator.js"></script>

</body>
</html>
EOF
