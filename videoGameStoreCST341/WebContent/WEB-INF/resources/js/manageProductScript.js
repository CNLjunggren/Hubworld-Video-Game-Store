	$(document).ready(function(){
		generateTable();	
	})
	
	
	// This method will be initiated when the modify button in a row is pressed
	$(document).on('click', 'input[name="modify"]', function(e){
		e.preventDefault();
		
		// Get the form button is part of, create a new product object, retrieve the product ID, which is ID of the form
		var form = $(this.form);
		var product = new Object();
		var productId = form.attr('id');
		
		// Instantiate the product object with the input field values
		product.id = productId;
		product.name = $('#name-' +productId).val();
		product.price = $('#price-' +productId).val();
		product.condition = $('#condition-' +productId).val();
		product.imagePath = $('#imagePath-' +productId).val();
		product.seller = $('#seller-' +productId).val();
		
		// Convert to JSON, send JSON to updateProduct, with productID so row can be reloaded upon success
		var productData = JSON.stringify(product);
		updateProduct(productData, productId);
	});
	
	
	// This method is called when the delete button in a row is pressed
	$(document).on('click', 'input[name="delete"]', function(e){
		e.preventDefault();
		
		// Get form the button is a part of, retrieve product ID, which is ID of form
		var form = $(this.form);
		var productId = form.attr('id');
		
		// This AJAX call will call the REST service's delete method, with the productID as a parameter
		$.ajax(
				{
					type:"DELETE",
					url: "/videoGameStoreCST341/productService/delete/" +productId,
					dataType:"json",
					success:function(data){
						if(data == true)
						{
							openNotification("Successfully deleted product(id:" +productId +")");		
							// If successful, remove the product row
							$('#product-' +productId).remove();
						}
						else
						{ openNotification("Something went wrong deleting product(id:" +productId +") from database" )}
						
					},
					error: function (xhr, ajaxOptions, thrownError) 
					{
						alert(xhr.status);
						alert(thrownError);
					}
				})
	});
	
	$(document).on('click', '#addProductButton', function(){
		var product = new Object();
		product.name = $("#addProductName").val();
		product.price = $("#addProductPrice").val();
		product.seller = $("#addProductSeller").val();
		product.condition= $(".conditionRadio:checked").val();
		product.imagePath = $("#addProductImagePath").val();
		
		var productData = JSON.stringify(product);
		
		$.ajax(
				{
					type: "POST",
					url: "/videoGameStoreCST341/productService/add",
					contentType: "application/json",
					data: productData,
					success: function(data)
				{
						if(data == true)
						{
							openNotification("Successfully added a new product");
							generateTable();
						}
						else
						{ openNotification("Something went wrong adding product :(")}
				},
					error: function (xhr, ajaxOptions, thrownError) 
				{
					alert(xhr.status);
					alert(thrownError);
				}
				}
				);
		
	});
	
	// This method is called when the modify button is pressed, parameters are JSON formatted product and productID
	function updateProduct(productData, productId)
	{
		// This AJAX call will send product in JSON format to the REST service's modify method
		$.ajax(
				{
					type: "PUT",
					url: "/videoGameStoreCST341/productService/modify",
					contentType: "application/json",
					data: productData,
					success: function(data)
				{
						if(data == true)
						{
							openNotification("Successfully updated product(id:" +productId +")");
							// If it was successful, change the input values to the new values that were set
							var product = JSON.parse(productData);
							$('#name-' +productId).val(product.name);
							$('#price-' +productId).val(product.price);
							$('#condition-' +productId).val(product.condition);
							$('#imagePath-' +productId).val(product.imagePath);
							$('#seller-' +productId).val(product.seller);
						}
						else
						{ openNotification("Something went wrong updating product(id:"+productId +")")}
				},
					error: function (xhr, ajaxOptions, thrownError) 
				{
					alert(xhr.status);
					alert(thrownError);
				}
				}
				);
	}
	
	function generateTable(){
		// Generating the table will first ensure that the table is empty first by calling empty on table body
		$(".product-list tbody").empty();
		
		// Retrieve all of the products using the REST service, for each one, create a row, all inputs belonging to a form
		$.ajax({
			type:"GET",
			url: "/videoGameStoreCST341/productService/products",
			dataType: "json",
			success: function(data){
				for(var i = 0; i < data.length; i++)
				{
					var id = data[i].id;
					
					$(".product-list tbody").append("<tr id='product-" +id +"'><form id='" +id +"' method='POST' class='product-form'></form></tr>");
					$("#product-" +id).append("<td><input form='" +id +"' id='" +id  +"' path='id' class='form-control text-secondary' type='hidden' name='id' value='" +id +"'></input>" +id +"</td>"
					+"<td><input form='" +id +"' id='name-" +id +"' path='name' class='form-control text-secondary' type='text' name='name' value='" +data[i].name +"'></input></td>"
					+"<td><input form='" +id +"' id='price-" +id +"' path='price' class='form-control text-secondary' type='text' name='price' value='" +data[i].price +"'></input></td>"
					+"<td><input form='" +id +"' id='condition-" +id +"' path='condition' class='form-control text-secondary' type='text' name='condition' value='" +data[i].condition +"'></input></td>"
					+"<td><input form='" +id +"' id='imagePath-" +id +"' path='imagePath' class='form-control text-secondary' type='text' name='imagePath' value='" +data[i].imagePath +"'></input></td>"
					+"<td><input form='" +id +"' id='seller-" +id +"' path='seller' class='form-control text-secondary' type='text' name='seller' value='" +data[i].seller +"'></input></td>"
					+"<td><input form='" +id +"' class='btn btn-secondary w-100' name='modify' type='submit' value='Modify'/></td>"
					+"<td><input form='" +id +"' class='btn btn-secondary w-100' name='delete' type='submit' value='Delete'/></td>");
				}
			}
			
		})
		
	}
	
	function openNotification(result){
        $('#notification-text').text(result);
        $('.notification-box').fadeIn(1500, function(){
        $(this).fadeOut(1500)});
    }
	