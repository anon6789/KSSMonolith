function addToChart() {
	var itemName = window.location.pathname;
	itemName = itemName.split("/")[2];
	itemName = itemName.split(".")[0];
	
	var count = document.getElementById('count').value;
	
	console.log("try to add " + itemName + " to basket.");
	
    $.ajax({
        	    url: 'http://' + location.hostname + ':8080/basket/?user=' + 'martin',
        	    type: 'PUT',
        	    data: '{ "count": '+ count + ', "productDto": { "productId": "' + itemName + '" } }',
        	    contentType:"application/json; charset=utf-8",
        	    dataType:"json",
        	    success: function(data) { 
        	    	console.log(data);
        	    	$("#addIcon").fadeIn();
        	    	$(".addIcon").fadeOut("slow");
        	    },
        	    error: function(data) {
        	    	console.log("error");
        	    }
        	});
}

function increaseBasket(itemName, count){
console.log("increase " + itemName + " in basket.");

	itemName = itemName.toLowerCase()
	
    $.ajax({
        	    url: 'http://' + location.hostname + ':8080/basket/?user=' + 'martin',
        	    type: 'PUT',
        	    data: '{ "count": '+ count + ', "productDto": { "productId": "' + itemName + '" } }',
        	    contentType:"application/json; charset=utf-8",
        	    dataType:"json",
        	    success: function(data) { 
        	    	console.log(data);
        	    	location.reload(true); //TODO: ugly hack, implement nice reload
        	    },
        	    error: function(data) {
        	    	console.log("error");
        	    }
        	});
}


function deleteFromBasket(itemName, count) {
	
	itemName = itemName.toLowerCase()
		
	console.log("try to delete " + itemName + " from basket.");
	
    $.ajax({
        	    url: 'http://' + location.hostname + ':8080/basket/?user=' + 'martin',
        	    type: 'DELETE',
        	    data: '{ "count": '+ count + ', "productDto": {"productId": "' + itemName + '" } }',
        	    contentType:"application/json; charset=utf-8",
        	    dataType:"json",
        	    success: function() { 
        	    	  location.reload(true); //TODO: ugly hack, implement nice reload
        	    },
        	    error: function() {
        	    	console.log("error");
      	    	  	//location.reload(true); //TODO: ugly hack, implement nice reload
        	    }
        	});
}

function deleteOrder(){	
	console.log("try to delete order.");
	
    $.ajax({
        	    url: 'http://'+ location.hostname + ':8080/order/?user=' + 'martin',
        	    type: 'DELETE',
        	    success: function() { 
        	    	  location.reload(true); //TODO: ugly hack, implement nice reload
        	    },
        	    error: function() {
        	    	console.log("error");
      	    	  	//location.reload(true); //TODO: ugly hack, implement nice reload
        	    }
        	});
}

function deleteCoupon(){	
	console.log("try to delete coupon.");
	
    $.ajax({
        	    url: 'http://'+ location.hostname + ':8080/coupon/?user=' + 'martin',
        	    type: 'DELETE',
        	    success: function() { 
        	    	  location.reload(true); //TODO: ugly hack, implement nice reload
        	    },
        	    error: function() {
        	    	console.log("error");
      	    	  	//location.reload(true); //TODO: ugly hack, implement nice reload
        	    }
        	});
}