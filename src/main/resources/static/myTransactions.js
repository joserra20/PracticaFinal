const cargarTransacciones = async(userId) => {


	try {
		let url = "/api/transactions/getByAccount/"+userId;
		console.log(url)
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
						{ title: 'ID', data: 'id' },
						{ title: 'Fecha', data: 'date' },
						{ title: 'Origen', data: 'originAcc' },
						{ title: 'Destino', data: 'destinationAcc' },
						{ title: 'Cantidad', data: 'amount' }
					 ] ,
					 "language": {
						"decimal":        "",
						"emptyTable":     "No hay datos disponibles",
						"info":           "Mostrando _START_ a _END_ de _TOTAL_ transacciones",
						"infoEmpty":      "Mostrando 0 a 0 de 0 transacciones",
						"infoFiltered":   "(filtrado a partir de _MAX_ transacciones)",
						"infoPostFix":    "",
						"thousands":      ",",
						"lengthMenu":     "Mostrar _MENU_ transacciones por página",
						"loadingRecords": "Cargando...",
						"processing":     "Procesando...",
						"search":         "Buscar:",
						"zeroRecords":    "No se han encontrado transacciones que coincidan con la busqueda",
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

		  } );

		} else if(respuesta.status === 404){
			alert('No se ha encontrado la informacion');
		} else {
			alert('Hubo un error');
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
				cargarTransacciones(text);
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

getUsername();
getUserId();