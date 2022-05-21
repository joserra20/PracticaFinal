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

				$('#example tbody').on( 'click', 'tr', function () {
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

const mostrarInfoUsuario = (usuario) => {

	let str = `
	<div class="row">
	<div class="col-md-4">
	  <img class="logo mx-auto d-block" width="100" src="https://logo.clearbit.com/${gasolinera.Rótulo}.com" onerror="this.onerror=null; this.src='https://cdn-icons-png.flaticon.com/512/234/234789.png'">
	</div>
	<div class="col-md-6">
	  <h3 class="titulo">${usuario.firstName} ${usuario.lastName}</h3>
	  <p>${gasolinera.Dirección}</p>
	  <p class="font-weight-bold">${gasolinera.Municipio}</p>
	  <p class="font-weight-bold">${gasolinera.Provincia}</p>
	  <p>Horario: ${gasolinera.Horario}</p>
	</div>
</div>
<div class="row">
  <div class="col-md-4">
	  <h6>Gasolina</h6>
	  <p><strong>SP95 E5</strong> ${gasolinera["Precio Gasolina 95 E5"]}</p>
	  <p><strong>SP98 E5</strong> ${gasolinera["Precio Gasolina 98 E5"]}</p>
	</div>
	<div class="col-md-6">
	  <h6>Diesel</h6>
	  <p><strong>Gasoleo A</strong> ${gasolinera["Precio Gasoleo A"]}</p>
	  <p><strong>Gasoleo Premium</strong> ${gasolinera["Precio Gasoleo Premium"]}</p>
	  <p><strong>Gasoleo B</strong> ${gasolinera["Precio Gasoleo B"]}</p>
	</div>
  
</div>
	`
	$("#mensaje").html(str);
	$('#exampleModal').modal('show');
}


const cargarCuentas = async() => {
	try {
		let res = await fetch("/api/accounts/allAccounts/",{
			method : 'GET',
			headers : {
				'Content-Type': 'application/json',
				'Accept': 'application/json',
			}
		});

		$("#titulo-tabla").html("<h3>Cuentas</h3>");

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

const cargarTransacciones = async() => {
	try {
		let res = await fetch("/api/transactions/allTransactions/",{
			method : 'GET',
			headers : {
				'Content-Type': 'application/json',
				'Accept': 'application/json',
			}
		});

		$("#titulo-tabla").html("<h3>Transacciones</h3>");

		// Si la respuesta es correcta
		if(res.status === 200){
			const datos = await res.json();
			console.log(datos);
			$(document).ready(function() {
				$('#example').DataTable( {
					 data: datos,
					 columns: [
						{ title: 'Origen', data: 'originAcc' },
						{ title: 'Destino', data: 'destinationAcc' },
						{ title: 'Cantidad', data: 'amount' },
						{ title: 'Fecha', data: 'date' }
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