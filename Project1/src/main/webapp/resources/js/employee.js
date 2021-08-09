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
		console.log('Catch Block');
		location.reload();
		return
	}
	
}

async function retrievePendingRequest(e){
	e.preventDefault();

	try{
		let req = await fetch ('http://localhost:8080/Project1/api/employee/viewpending', {
			method: 'POST',
			headers: {
				'Content-Type' : 'application/json'
				
			},
			//body: JSON.stringify(rbRequest)
		});
		var res = await req.json();
		
		
	}catch (e){
		console.log('Bad Request')
		return
	}
	populatePendingRequest(res);
	
	
	
}

function populatePendingRequest(data){
	if (data != null) {
   
    $("tr").empty();
    $("td").empty();
    $("#headerP").empty();

	$("#resolved").empty();
	$("#pending").empty();
	$("#accountInfoHeader").empty();
	$("#pending").append($('<h2>All Pending Requests</h2>'));
	
	
    $('#headerP').append($('<th>Amount</th>'));
    $('#headerP').append($('<th>Description</th>'));
    $('#headerP').append($('<th>Status</th>'));
    $('#headerP').append($('<th>Submitted On</th>'));
    $('#headerP').append($('<th>Type</th>'));
	

	for (rbObj of data) {
		let date = rbObj.submitted.month + ` ` +rbObj.submitted.dayOfMonth +`, ` + rbObj.submitted.year;
		
        $('#ADTable').append($('<tr id="rowP"><td id="columnP">'+ rbObj.amount +'</td><td id="columnP">' + rbObj.description + '</td><td id="columnP">' 
        + rbObj.status.reimBStatus + '</td><td id="columnP">'+ date + '</td><td id="columnP">' + rbObj.type.reimBType  + '</td></tr>'));                               
    }
    }else {
	alert('No Pending Reimbursement Request is found on the database!');
}

}


async function retrieveResolvedRequest(){
	let res = await fetch('http://localhost:8080/Project1/api/employee/viewresolved');
	let data = await res.json();
	
	populateResolvedRequest(data);
}


function populateResolvedRequest(data){
	if (data != null) {
	$("tr").empty();
    $("td").empty();
    $("#resolved").empty();
	$('#headerR').empty();
	$("#resolved").append($('<h2>All Resolved Requests</h2>'));
	
	$("#accountInfoHeader").empty();
	$("#pending").empty();
    $('#headerR').append($('<th>Amount</th>'));
    $('#headerR').append($('<th>Description</th>'));
    $('#headerR').append($('<th>Status</th>'));
    $('#headerR').append($('<th>Submitted On</th>'));
    $('#headerR').append($('<th>Type</th>'));
	

	for (rbObj of data) {
		let date = rbObj.submitted.month + ` ` +rbObj.submitted.dayOfMonth +`, ` + rbObj.submitted.year;
		
        $('#RTable').append($('<tr id="row"><td id="column">'+ rbObj.amount +'</td><td id="column">' + rbObj.description + '</td><td id="column">' 
        + rbObj.status.reimBStatus + '</td><td id="column">'+ date + '</td><td id="column">' + rbObj.type.reimBType  + '</td></tr>'));                               
    }
    }
    else {
	alert('No Resolved Reimbursement Request is found on the database!');
}

}


async function viewAccountInfo(){
	let res = await fetch('http://localhost:8080/Project1/api/employee/viewaccount');
	let data = await res.json();
	
	populateAccountInfo(data);
}

function populateAccountInfo(data){
	if (data != null) {
	$("tr").empty();
    $("td").empty();
    
    $("#pending").empty();
    $("#accountInfoHeader").empty();
	$('#tableHeaderInfo').empty();
	$("#resolved").empty();
	
	$("#accountInfoHeader").append($('<h2>Account Information</h2>'));
	
	
	
    $('#tableHeaderInfo').append($('<th>First Name</th>'));
    $('#tableHeaderInfo').append($('<th>Last Name</th>'));
    $('#tableHeaderInfo').append($('<th>Username</th>'));
    $('#tableHeaderInfo').append($('<th>Email On</th>'));
    $('#tableHeaderInfo').append($('<th>Password</th>'));
	
	$('#accountInfoTable').append($('<tr id="row"><td id="column">'+ data.firstName +'</td><td id="column">' + data.lastName + '</td><td id="column">' 
        + data.username + '</td><td id="column">'+ data.email + '</td><td id="column">' + data.password + '</td></tr>'));                               
   
   }
   else {
	alert('No Pending Reimbursement Request is found on the database!');
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
		console.log('Bad Request')
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



