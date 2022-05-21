const cargarCuentas = async() => {
	try {
		let res = await fetch("/api/accounts/allAccounts/",{
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
						},
						"aria": {
							 "sortAscending":  ": activate to sort column ascending",
							 "sortDescending": ": activate to sort column descending"
						}
				  }
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

	try {
		let res = await fetch("api/accounts_and_users/UsersByAccount/"+cuenta.id,{
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

	$( "#btnBorrar" ).remove();
	var r = $('<button id="btnBorrar">Eliminar cuenta</button>');
	$("#cuentas").append(r);

	btnBorrar.addEventListener("click", function() {
		borrarCuenta(cuenta);
	  });

	$('#cuentas').show();


}

async function borrarCuenta(cuenta){
	try{
	
	let res = await fetch("/api/accounts/delete/" + cuenta.id,{
		method : 'DELETE'
	});

	if(res.status === 200){
		alert("Cuenta borrada correctamente");
		location.reload();
	} else if(respuesta.status === 404){
		console.log('La cuenta que buscas no existe');
	} else {
		console.log('Hubo un error');
	}

} catch(error){
	console.log(error);
}
}

$('#cuentas').hide();