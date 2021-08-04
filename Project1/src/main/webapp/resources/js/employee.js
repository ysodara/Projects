



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
	$("td").empty();
    $("tr").empty();
    $("#pending").empty();

	$("#pending").append($('<h2>All Pending Requests</h2>'));
	
    $('#header').append($('<th>Amount</th>'));
    $('#header').append($('<th>Description</th>'));
    $('#header').append($('<th>Status</th>'));
    $('#header').append($('<th>Submitted On</th>'));
    $('#header').append($('<th>Type</th>'));
	

	for (rbObj of data) {
		let date = rbObj.submitted.month + ` ` +rbObj.submitted.dayOfMonth +`, ` + rbObj.submitted.year;
		
        $('#ADTable').append($('<tr><td>'+ rbObj.amount +'</td><td>' + rbObj.description + '</td><td>' 
        + rbObj.status.reimBStatus + '</td><td>'+ date + '</td><td>' + rbObj.type.reimBType  + '</td></tr>'));                               
    }

}


async function retrieveResolvedRequest(){
	let res = await fetch('http://localhost:8080/Project1/api/employee/viewresolved');
	let data = await res.json();
	console.log(data);
	//populateRequest(data);
}


async function viewAccountInfo(){
	let res = await fetch('http://localhost:8080/Project1/api/employee/viewaccount');
	let data = await res.json();
	console.log(data);
	//populateRequest(data);
}
async function updateAccountInfo(){
	let res = await fetch('http://localhost:8080/Project1/api/employee/updateaccount');
	let data = await res.json();
	console.log(data);
	//populateRequest(data);
}

async function logout(e){
	let res = await fetch('http://localhost:8080/Project1/api/logout');
	location.href='http://localhost:8080/Project1/home';
	location.reload();
}



