window.onload = function(e) {
  retrieveSesstion(e);
};

async function retrieveSesstion(e){
	console.log('Called get Session in JS')
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

let form5 = document.getElementById('updateAccount').addEventListener('submit', update);

async function update(e){
	e.preventDefault();
	
	let firstName = document.getElementById('firstName').value;
	let lastName = document.getElementById('lastName').value;
	let username = document.getElementById('username').value;
	let password = document.getElementById('password').value;
	let email = document.getElementById('email').value;
	
	let update ={
		firstName,
		lastName,
		username,
		password,
		email
	}
	console.log(update);
	try{
		let req = await fetch ('http://localhost:8080/Project1/api/employee/updateaccount', {
			method: 'POST',
			headers: {
				'Content-Type' : 'application/json'
				
			},
			body: JSON.stringify(update)
		});
		var res = await req.json();
		
		
	}catch (e){
		return
	}
	console.log(res);
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