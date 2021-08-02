let form = document.getElementById('submitReimburstment').addEventListener('submit', login);

async function login(e){
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
	//This is how we can Redirect to other page
	//location.href='resources/html/' + res +'.html';
	
}

async function retrievePendingRequest(e){
	e.preventDefault();
	
	
	
	let rbRequest ={
		
	}
	//console.log(rbRequest);
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
	console.log(res);
	//This is how we can Redirect to other page
	//location.href='resources/html/' + res +'.html';
	
}



let container = document.getElementById('post-container');

async function getPosts(){
	let res = await fetch('http://localhost:8080/SocialHubWeek3/api/posts');
	let data = await res.json();
	populatePosts(data);
}

function populatePosts(data){
	for (postObj of data) {
        let post = document.createElement('div');
        post.innerHTML = `<h2>${postObj.username}</h2>
                      <p>${postObj.content}</p>`;
        console.log(postObj);
        container.append(post);
    }
}

getPosts();