window.onload = function(e) {
  retrieveSesstion(e);
};

async function retrieveSesstion(e){
	e.preventDefault();
	
	try{
		let req = await fetch ('http://localhost:8080/Project1/api/getsession', {
			method: 'POST',
			headers: {
				'Content-Type' : 'application/json'
				
			},
		});
		var res = await req.json();
			
	}
	
	catch (e){
		location.href='http://localhost:8080/Project1/home';
		return
	}
	
}

let form11 = document.getElementById('submitReimburstment').addEventListener('submit', submitRB);

async function submitRB(e){
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
		return
	}
	location.href='http://localhost:8080/Project1/home';
	

}

async function logout(e){
	e.preventDefault();
	try{
		let req = await fetch ('http://localhost:8080/Project1/api/logout', {
			method: 'POST',
			headers: {
				'Content-Type' : 'application/json'
				
			},
		});
		var res = await req.json();		
	}catch (e){
		location.href='http://localhost:8080/Project1/home';
		return
	}
	location.href='http://localhost:8080/Project1/home';
}