const cargarUsuarios = async() => {
	try {
		let res = await fetch("/api/users/allUsers/",{
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
						{ title: 'DNI', data: 'dni' },
						{ title: 'Nombre', data: 'firstName' },
						{ title: 'Apellidos', data: 'lastName' },
						{ title: 'Email', data: 'email' },
						{ title: 'Tarifa', data: 'userType' }
					 ] ,
					 "language": {
						"decimal":        "",
						"emptyTable":     "No hay datos disponibles",
						"info":           "Mostrando _START_ a _END_ de _TOTAL_ usuarios",
						"infoEmpty":      "Mostrando 0 a 0 de 0 usuarios",
						"infoFiltered":   "(filtrado a partir de _MAX_ usuarios)",
						"infoPostFix":    "",
						"thousands":      ",",
						"lengthMenu":     "Mostrar _MENU_ usuarios por página",
						"loadingRecords": "Cargando...",
						"processing":     "Procesando...",
						"search":         "Buscar:",
						"zeroRecords":    "No se han encontrado usuarios que coincidan con la busqueda",
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
					mostrarInfoUsuario(table.row( this ).data());
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

	let url = "api/accounts/byUser/"+usuario.id;
	console.log(url);
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