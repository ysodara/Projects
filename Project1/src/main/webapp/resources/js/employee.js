window.onload = function() {
  reload ();
};
function reload (){
	var c=true;
	if(c){
	location.reload();
	c=false;
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
		console.log('Username or password was incorrect.')
		return
	}
	populatePendingRequest(res);
	console.log(res);
	
	
}

function populatePendingRequest(data){
	
   
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

}


async function retrieveResolvedRequest(){
	let res = await fetch('http://localhost:8080/Project1/api/employee/viewresolved');
	let data = await res.json();
	console.log(data);
	populateResolvedRequest(data);
}


function populateResolvedRequest(data){
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


async function viewAccountInfo(){
	let res = await fetch('http://localhost:8080/Project1/api/employee/viewaccount');
	let data = await res.json();
	console.log(data);
	populateAccountInfo(data);
}

function populateAccountInfo(data){
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


async function logout(e){
	e.preventDefault();
	let res = await fetch('http://localhost:8080/Project1/api/logout');
	location.href='http://localhost:8080/Project1/logout';
}



