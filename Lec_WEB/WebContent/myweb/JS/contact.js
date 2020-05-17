const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');
const signInContainer = document.getElementsByClassName('sign-in-container')[0];
const inputName = document.getElementById("inputName");
const inputInEmail = document.getElementById("inputInEmail");
const inputInPassword = document.getElementById('inputInPassword');
const inputUpEmail = document.getElementById('inputUpEmail');
const inputUpPassword = document.getElementById('inputUpPassword');

const signInBtn = document.getElementById('signInBtn');
const signUpBtn = document.getElementById('signUpBtn');


signUpButton.addEventListener('click', function() {
    container.classList.add("right-panel-active");
    signInContainer.style.display = "none";
    
});

signInButton.addEventListener('click', function() {
    container.classList.remove("right-panel-active");
    signInContainer.style.display = "block";
});


signInBtn.addEventListener("click", function(){
    if(inputInEmail.value != ""){
        if(inputInPassword.value != ""){
            alert('Login Successful!')
        location.href="index.html";
        }
    }

});

signUpBtn.addEventListener("click", function () {
    if(inputName.value != ""){
        if(inputUpEmail.value != ""){
            if(inputUpPassword.value != ""){
                alert('SignUp Successful!');
                location.href="index.html";
            }
         }
     }
     
  });