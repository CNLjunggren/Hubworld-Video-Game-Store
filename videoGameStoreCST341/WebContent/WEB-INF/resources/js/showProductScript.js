$(document).ready(function() {
		getProducts();
	});
		
	
	// This function will update each row of the datatable
	function redrawTable(table)
	{
		
		$.ajax({
					type: "GET",
					url: "/videoGameStoreCST341/productService/products",
					dataType: "json",
					success: function(data)
					{
						// Iterate through the data that was returned
						var i = 0;
						// For every row in the table, change the data to data that was retrieve from database
						table.rows().every( function ( rowIdx, tableLoop, rowLoop ) {
						   var rowData = this.data();
						   rowData = data[i];
						   this.data(rowData);
						   i++;
						});
						table.draw();
					},
					error: function (xhr, ajaxOptions, thrownError) 
				{
					alert(xhr.status);
					alert(thrownError);
				}
				});
	}
	
	function getProducts()
	{
		$.ajax(
				{
					type: "GET",
					url: "/videoGameStoreCST341/productService/products",
					dataType: "json",
					success: function(data)
				{
					$('#products').dataTable({
											"data": data,
											"columns": [{"data": "id"}, {"data": "name"}, {"data": "price"}, {"data" : "condition"}, {"data" : "imagePath"},  {"data" : "seller"},
												{"data": null, "defaultContent": "<button name='modify' class='btn btn-secondary' data-toggle='modal' data-target='#modifyProduct'>Modify</button>",
												"orderable": false},
												{"data": null, "defaultContent": "<button name= 'delete' class='btn btn-secondary'>Delete</button>", "orderable": false}]
					});
				},
					error: function (xhr, ajaxOptions, thrownError) 
				{
					alert(xhr.status);
					alert(thrownError);
				}
				}
				);
	}
	
	// Open the modify modal and formulate it with data when the modify button is pressed
	$(document).on('click', "button[name='modify']", function(){
		// Get the table row parent of this button
		var row = $(this).closest('tr');
		// Get the text at the 
		var id = parseInt($(row).find('.sorting_1').text());
		
		$.ajax({
			type: "GET",
			url: "/videoGameStoreCST341/productService/product/" +id,	
			dataType: "json",
			success: function(data){
				populateModifyModal(data, id);
			}
			
		});
	});
	
	// Set the input fields in the modal to specific product values
	function populateModifyModal(product,id){		
		$("#product-id").val(id);
		$("#modifyProductName").val(product.name);
		$("#modifyProductPrice").val(product.price);
		$("#modifyProductSeller").val(product.seller);
		$("#modifyProductImagePath").val(product.imagePath);
	}
	
	$(document).on('click', 'button[name="modifyProduct"]', function(){
		$("#modifyProductForm").submit();	
	})
	
	$(document).on('submit', '#modifyProductForm', function(e){
		// Create object, populate object fields with new input values
		var product = new Object();
		product.id = $("#product-id").val();
		product.name = $("#modifyProductName").val();
		product.price = $("#modifyProductPrice").val();
		product.condition = $(this).closest("input[name='condition']:selected").val();
		product.seller = $("#modifyProductSeller").val();
		product.imagePath = $("#modifyProductImagePath").val();
		
		// Convert to JSON, send JSON to updateProduct, with productID so row can be reloaded upon success
		var productData = JSON.stringify(product);
		
		// Use AJAX to submit changes to REST service
		$.ajax({
					type: "PUT",
					url: "/videoGameStoreCST341/productService/modify",
					contentType: "application/json",
					data: productData,
					success: function(data)
				{
						if(data == true)
						{
							redrawTable($("#products").DataTable());
							openNotification("Successfully updated product(id:" +product.id +")");
						}
						else
						{ openNotification("Something went wrong updating product(id:"+product.id +")")}
				},
					error: function (xhr, ajaxOptions, thrownError) 
				{
					alert(xhr.status);
					alert(thrownError);
				}
				});
		
		e.preventDefault();
	});
	
	
	// This method is called when the delete button in a row is pressed
	$(document).on('click', 'button[name="delete"]', function(){
		
		var row = $(this).closest('tr');
		var productId = parseInt($(row).find('.sorting_1').text());
		
		
		// This AJAX call will call the REST service's delete method, with the productID as a parameter
		$.ajax(
				{
					type:"DELETE",
					url: "/videoGameStoreCST341/productService/delete/" +productId,
					dataType:"json",
					success:function(data){
						if(data == true)
						{
							$("#products").DataTable().row($(row)).remove();
							redrawTable($("#products").DataTable());
							openNotification("Successfully deleted product(id:" +productId +")");		
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
						if(data != null)
						{
							$("#products").DataTable().row.add(data);
							$("#products").DataTable().draw();
							redrawTable($("#products").DataTable());
							openNotification("Successfully added a new product");
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
		
		
	function openNotification(result){
        $('#notification-text').text(result);
        $('.notification-box').fadeIn(1500, function(){
        $(this).fadeOut(1500)})
	}
