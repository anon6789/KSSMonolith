function addToChart() {
	var itemName = window.location.pathname;
	itemName = itemName.split("/")[2];
	itemName = itemName.split(".")[0];
	
	var count = document.getElementById('count').value;
	
	console.log("try to add " + itemName + " to basket.");
	
    $.ajax({
        	    url: 'http://localhost:8080/basket/?user=' + 'martin',
        	    type: 'PUT',
        	    data: '{ "count": '+ count + ', "productDto": { "productId": "' + itemName + '" } }',
        	    contentType:"application/json; charset=utf-8",
        	    dataType:"json",
        	    success: function(data) { 
        	    	console.log(data);
        	    },
        	    error: function(data) {
        	    	console.log("error");
        	    }
        	});
}

function deleteFromBasket(itemName) {
	
	itemName = itemName.toLowerCase()
		
	console.log("try to delete " + itemName + " from basket.");
	
    $.ajax({
        	    url: 'http://localhost:8080/product/?user=' + 'martin',
        	    type: 'DELETE',
        	    data: '{ "count": '+ 1 + ', "productId": "' + itemName + '" }',
        	    contentType:"application/json; charset=utf-8",
        	    dataType:"json",
        	    success: function() { 
        	    	  location.reload(true); //TODO: ugly hack, implement nice reload
        	    },
        	    error: function() {
        	    	console.log("error");
      	    	  	location.reload(true); //TODO: ugly hack, implement nice reload
        	    }
        	});
}