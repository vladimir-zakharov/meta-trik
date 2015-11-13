window.passwordPrompt = function(message, callback) {

    var shadow = document.createElement("div");
    shadow.className = "shadowBg";

    var prompt = document.createElement("div");
    prompt.className = "passwPrompt";

    var clear = function() { 
        document.body.removeChild(prompt);
        document.body.removeChild(shadow);
    };

    var submit = function() {
        callback(input.value);
        clear();
    };

    var label = document.createElement("label");
    label.textContent = message;
    label.for = "passwPromptInput";
    prompt.appendChild(label);

    var input = document.createElement("input");
    input.id = "passwPromptInput";
    input.type = "password";
    input.addEventListener("keyup", function(e) {
        if (e.keyCode == 13) submit();
    }, false);
    prompt.appendChild(input);
    
    var cancelButton = document.createElement("button");
    cancelButton.textContent = "Cancel";
    cancelButton.addEventListener("click", clear, false);
    prompt.appendChild(cancelButton);
    
    var okButton = document.createElement("button");
    okButton.textContent = "OK";
    okButton.addEventListener("click", submit, false);
    prompt.appendChild(okButton);

    document.body.appendChild(prompt);
    document.body.appendChild(shadow);
};

