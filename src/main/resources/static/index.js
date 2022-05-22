const cargarCuentas = async(id) => {
	try {
		let url = "/api/accounts/byUser/"+id;
		let res = await fetch(url,{
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
				$('#example').DataTable( {
					 data: datos,
					 columns: [
						{ title: 'IBAN', data: 'iban' },
						{ title: 'Saldo', data: 'balance' },
						{ title: 'Tipo', data: 'userType' }
					 ] ,
					 "language": {
						"decimal":        "",
						"emptyTable":     "No hay datos disponibles",
						"info":           "Mostrando _START_ a _END_ de _TOTAL_ cuentas",
						"infoEmpty":      "Mostrando 0 a 0 de 0 cuentas",
						"infoFiltered":   "(filtrado a partir de _MAX_ cuentas)",
						"infoPostFix":    "",
						"thousands":      ",",
						"lengthMenu":     "Mostrar _MENU_ cuentas por página",
						"loadingRecords": "Cargando...",
						"processing":     "Procesando...",
						"search":         "Buscar:",
						"zeroRecords":    "No se han encontrado cuentas que coincidan con la busqueda",
						"paginate": {
							 "first":      "Primero",
							 "last":       "Último",
							 "next":       "Siguiente",
							 "previous":   "Anterior"
						}
				  },
				  paging: false,
				  searching: false,
 ordering:  false
				} );

				let table = $('#example').DataTable();

				$('#example tbody').on( 'click', 'tr', function () {
					console.log(table.row( this ).data());
					mostrarInfoCuenta(table.row( this ).data());
				} );
		  } );

		} else if(respuesta.status === 404){
			console.log('La cuenta que buscas no existe');
		} else {
			console.log('Hubo un error');
		}

	} catch(error){
		console.log(error);
	}

}

async function mostrarInfoCuenta(cuenta) {

	if ($.fn.dataTable.isDataTable('#tablaCuentas')) {
			$('#tablaCuentas').DataTable().destroy();
		}

	$("#tituloCuentas").text("Cuenta " + cuenta.iban);

	let url = "api/users/byAccount/"+cuenta.id;
	try {
		let res = await fetch(url,{
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
						{ title: 'DNI', data: 'dni' },
						{ title: 'Nombre', data: 'firstName' },
						{ title: 'Apellidos', data: 'lastName' },
						{ title: 'Email', data: 'email' },
						{ title: 'Tarifa', data: 'userType' }
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

	$('#cuentas').show();


}

async function borrarCuenta(cuenta){
	try{
	
	let res = await fetch("/api/accounts/delete/" + cuenta.id,{
		method : 'DELETE',
		credentials: 'same-origin'
	});

	if(res.status === 200){
		alert("Cuenta borrada correctamente");
		location.reload();
	} else if(res.status === 404){
		console.log('La cuenta que buscas no existe');
	} else {
		console.log('Hubo un error');
	}

} catch(error){
	console.log(error);
}
}

async function getUsername() {

	let url = "/username";
	console.log(url);
	try {
		let res = await fetch(url,{
			method : 'GET'
		});

		// Si la respuesta es correcta
		if(res.status === 200){
			res.text().then(function (text) {
				$('#nombreBienvenida').text(text);
			  });

		} else if(res.status === 404){
			console.log('El usuario que buscas no existe');
		} else {
			console.log('Hubo un error');
		}

	} catch(error){
		console.log(error);
	}


}

async function getUserId() {

	let url = "/currentId";
	console.log(url);
	try {
		let res = await fetch(url,{
			method : 'GET'
		});

		// Si la respuesta es correcta
		if(res.status === 200){
			res.text().then(function (text) {
				cargarCuentas(text);
			  });

		} else if(res.status === 404){
			console.log('El usuario que buscas no existe');
		} else {
			console.log('Hubo un error');
		}

	} catch(error){
		console.log(error);
	}


}

$('#cuentas').hide();
getUsername();
getUserId();