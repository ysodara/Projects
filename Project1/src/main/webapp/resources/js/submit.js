let form = document.getElementById('submitReimburstment').addEventListener('submit', submit);

async function submit(e){
	e.preventDefault();
	
	let amount = document.getElementById('amount').value;
	let description= document.getElementById('description').value;
	let select = document.getElementById('type');
	let typeId = select.options[select.selectedIndex].value;
	
	let rbRequest ={
		amount,
		description,
		typeId
	}
	console.log(rbRequest);
	try{
		let req = await fetch ('http://localhost:8080/Project1/api/employee/submit', {
			method: 'POST',
			headers: {
				'Content-Type' : 'application/json'
				
			},
			body: JSON.stringify(rbRequest)
		});
		var res = await req.json();
		
		
	}catch (e){
		console.log('Username or password was incorrect.')
		return
	}
	console.log(res);
	location.href='http://localhost:8080/Project1/home';
	

}
