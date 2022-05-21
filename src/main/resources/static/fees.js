const cargarUsuarios = async() => {
	try {
		let res = await fetch("/api/fees/allFees/",{
			method : 'GET',
			headers : {
				'Content-Type': 'application/json',
				'Accept': 'application/json',
			}
		});

		// $("#titulo-tabla").html("<h3>Usuarios</h3>");

		// Si la respuesta es correcta
		if(res.status === 200){
			const datos = await res.json();
			console.log(datos);
			$(document).ready(function() {
				$('#example').DataTable( {
					 data: datos,
					 columns: [
						{ title: 'id', data: 'id' },
						{ title: 'Título', data: 'userType' },
						{ title: 'Comision anual', data: 'fee_amount' },
						{ title: 'Descripción', data: 'comment' }
					 ]
				} );

				let table = $('#example').DataTable();

				$('#example tbody').on( 'click', 'tr', function () {
					console.log(table.row( this ).data());
					
				} );
		  } );

		} else if(respuesta.status === 404){
			console.log('El usuario que buscas no existe');
		} else {
			console.log('Hubo un error');
		}

	} catch(error){
		console.log(error);
	}

}

async function mostrarInfoUsuario(usuario) {

	if ($.fn.dataTable.isDataTable('#tablaCuentas')) {
			$('#tablaCuentas').DataTable().destroy();
		}

	$("#tituloCuentas").text(usuario.firstName + " "+ usuario.lastName);

	console.log("api/accounts_and_users/UsersByAccount/"+usuario.id)
	try {
		let res = await fetch("api/accounts_and_users/AccountsByUser/"+usuario.id,{
			method : 'GET',
			headers : {
				'Content-Type': 'application/json',
				'Accept': 'application/json',
			}
		});

		// Si la respuesta es correcta
		if(res.status === 200){
			const datos = await res.json();
			console.log(datos);
			$(document).ready(function() {
				$('#tablaCuentas').DataTable( {
					 data: datos,
					 columns: [
						{ title: 'IBAN', data: 'iban' },
						{ title: 'Saldo', data: 'balance' },
						{ title: 'Tipo', data: 'userType' }
					 ] ,
					 paging: false,
					 searching: false,
    ordering:  false
				} );
		  } );

		} else if(respuesta.status === 404){
			console.log('El usuario que buscas no existe');
		} else {
			console.log('Hubo un error');
		}

	} catch(error){
		console.log(error);
	}

	$( "#btnBorrar" ).remove();
	var r = $('<button id="btnBorrar">Eliminar usuario</button>');
	$("#cuentas").append(r);

	btnBorrar.addEventListener("click", function() {
		borrarUsuario(usuario);
	  });

	$('#cuentas').show();


}

async function borrarUsuario(usuario){
	try{
	
	let res = await fetch("/api/users/delete/" + usuario.id,{
		method : 'DELETE'
	});

	if(res.status === 200){
		alert("Usuario borrado correctamente");
		location.reload();
	} else if(respuesta.status === 404){
		console.log('El usuario que buscas no existe');
	} else {
		console.log('Hubo un error');
	}

} catch(error){
	console.log(error);
}
}

$('#cuentas').hide();