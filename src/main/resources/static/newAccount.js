async function nuevoUsuario(){
    event.preventDefault();
	let nombre = document.getElementById('nombreInput').value;
	let apellidos = document.getElementById('apellidosInput').value;
	let email = document.getElementById('emailInput').value;
	let password = document.getElementById('passwordInput').value;

    if (nombre == "" || apellidos == "" || email == "" || password == ""){
        alert("Por favor, completa todos los campos");
    }else if (password.length < 8){
        alert("La contraseña introducida es demasiado corta");
    }else if(email < 4){
        alert("El email introducido no es válido");
    }else{

        if (true){
            //No se incluye el ID porque se crea automáticamente siguiendo el orden
            const dataObj = {
                "firstName" : nombre,
                 "lastName" : apellidos,
                 "email" : email,
                 "password" : password
            };

            // Inserción del nuevo usuario
            let res = await fetch("/api/users/save",{
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(dataObj)
            });


            if (res.status == 201){
                alert("Usuario registrado");
                location.replace("users.html");
            }else{
                alert("Se ha producido un error");
            }

        }else{
            validu.innerHTML = '<p style="color:red;">Ya existe un usuario con este nombre</p>';
        }
    }
}




//FUNCION PARA VALIDAR EL EMAIL
function validarEmail(email){
    //REGEXP EMAIL
    const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
    return emailRegex.test(email);
}