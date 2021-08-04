



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
		console.log('Username or password was incorrect.')
		return
	}
	populatePendingRequest(res);
	console.log(res);
	
	
}

function populatePendingRequest(data){
	$("#columnP").empty();
    $("#rowP").empty();
    $("#pending").empty();
    $('#header').empty();
    $('#ADTable').empty();

	$("#pending").append($('<h2>All Pending Requests</h2>'));
	
    $('#header').append($('<th>Amount</th>'));
    $('#header').append($('<th>Description</th>'));
    $('#header').append($('<th>Status</th>'));
    $('#header').append($('<th>Submitted On</th>'));
    $('#header').append($('<th>Type</th>'));
	

	for (rbObj of data) {
		let date = rbObj.submitted.month + ` ` +rbObj.submitted.dayOfMonth +`, ` + rbObj.submitted.year;
		
        $('#ADTable').append($('<tr id="rowP"><td id="columnP">'+ rbObj.amount +'</td><td id="columnP">' + rbObj.description + '</td><td id="columnP">' 
        + rbObj.status.reimBStatus + '</td><td id="columnP">'+ date + '</td><td id="columnP">' + rbObj.type.reimBType  + '</td></tr>'));                               
    }

}


async function retrieveResolvedRequest(){
	let res = await fetch('http://localhost:8080/Project1/api/employee/viewresolved');
	let data = await res.json();
	console.log(data);
	populateResolvedRequest(data);
}


function populateResolvedRequest(data){
	$("#column").empty();
    $("#row").empty();
    $("#resolved").empty();
	$('#headerR').empty();
	$('#RTable').empty();
	$("#resolved").append($('<h2>All Resolved Requests</h2>'));
	
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


async function viewAccountInfo(){
	let res = await fetch('http://localhost:8080/Project1/api/employee/viewaccount');
	let data = await res.json();
	console.log(data);
	//populateRequest(data);
}


async function logout(e){
	let res = await fetch('http://localhost:8080/Project1/api/logout');
	location.href='http://localhost:8080/Project1/home';
	location.reload();
}



