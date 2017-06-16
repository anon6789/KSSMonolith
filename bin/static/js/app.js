function addToChart() {
	/** var data = {
		    'count': 1,
		    'productId': 'kiwis'
	} */
	
	var itemName = window.location.pathname;
	itemName = itemName.split("/")[2];
	itemName = itemName.split(".")[0];
	
	var count = document.getElementById('count').value;
	
	console.log("try to add " + itemName + " to basket.");
	
    $.ajax({
        	    url: 'http://localhost:8080/product/?user=' + 'martin',
        	    type: 'PUT',
        	    data: '{ "count": '+ count + ', "productId": "' + itemName + '" }',
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