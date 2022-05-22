async function nuevaCuenta(){
    event.preventDefault();
    let iban = document.getElementById('ibanInput').value;
	let balance = document.getElementById('balanceInput').value;
	let dni = document.getElementById('dniInput').value;
	let userType = document.getElementById('tipoInput').value;

    if (iban == "" || balance == "" || dni == "" ){
        alert("Por favor, completa todos los campos");
    }else{

        if (true){
            const dataObj = {
                "iban" : iban,
                "balance" : balance,
                 "dni" : dni,
                 "userType" : userType
            };

            // Inserción de la nueva cuenta
            let res = await fetch("/api/account/save",{
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(dataObj)
            });


            if (res.status == 201){
                alert("Cuenta creada correctamente");
                location.replace("accounts.html");
            }else{
                alert("Se ha producido un error");
            }

        }else{
            validu.innerHTML = '<p style="color:red;">Ya existe una cuenta con este IBAN</p>';
        }
    }
}
