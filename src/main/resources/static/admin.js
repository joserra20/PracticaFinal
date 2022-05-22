async function mostrarInfoUsuario() {

	let url = "/username";
	console.log(url);
	try {
		let res = await fetch(url,{
			method : 'GET'
		});

		// Si la respuesta es correcta
		if(res.status === 200){
			res.text().then(function (text) {
				$('#username').text(text);
				$('#username2').text(text);
			  });

		} else if(respuesta.status === 404){
			console.log('El usuario que buscas no existe');
		} else {
			console.log('Hubo un error');
		}

	} catch(error){
		console.log(error);
	}


}

mostrarInfoUsuario();