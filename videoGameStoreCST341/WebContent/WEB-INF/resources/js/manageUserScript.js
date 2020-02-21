	$(document).ready(function(){
		generateTable();	
	})
	
	
	// This method will be initiated when the modify button in a row is pressed
	$(document).on('click', 'input[name="modify"]', function(e){
		e.preventDefault();
		
		// Get the form button is part of, create a new user object, retrieve the user ID, which is ID of the form
		var form = $(this.form);
		var user = new Object();
		var userId = form.attr('id');
		
		// Instantiate the user object with the input field values
		user.id = userId;
		user.username = $('#username-' +userId).val();
		user.password = $('#password-' +userId).val()
		user.emailAddress = $('#email-' +userId).val();
		user.firstName = $('#firstName-' +userId).val();
		user.lastName = $('#lastName-' +userId).val();
		user.gender = $('#gender-' +userId).val();
		user.userPrivilege = $('#privilege-' +userId).val();
		
		// Convert to JSON, send JSON to update user, with userID so row can be reloaded upon success
		var userData = JSON.stringify(user);
		updateUser(userData, userId);
	});
	
	
	// This method is called when the delete button in a row is pressed
	$(document).on('click', 'input[name="delete"]', function(e){
		e.preventDefault();
		
		// Get form the button is a part of, retrieve user ID, which is ID of form
		var form = $(this.form);
		var userId = form.attr('id');
		
		// This AJAX call will call the REST service's delete method, with the userID as a parameter
		$.ajax(
				{
					type:"DELETE",
					url: "/videoGameStoreCST341/userService/delete/" +userId,
					dataType:"json",
					success:function(data){
						if(data == true)
						{
							openNotification("Successfully deleted user(id:" +userId +")");		
							// If successful, remove the user row
							$('#user-' +userId).remove();
						}
						else
						{ openNotification("Something went wrong deleting user(id:" +userId +") from database" )}
						
					},
					error: function (xhr, ajaxOptions, thrownError) 
					{
						alert(xhr.status);
						alert(thrownError);
					}
				})
	});
	
	$(document).on('click', '#addUserButton', function(){
		var user = new Object();
		user.username = $("#addUsername").val();
		user.password = $("#addPassword").val();
		user.emailAddress = $("#addEmailAddress").val();
		user.firstName = $("#addFirstName").val();
		user.lastName = $("#addLastName").val();
		user.gender = $(".genderRadio:checked").val();
		user.userPrivilege = $("#addUserPrivilege").val();
		
		var userData = JSON.stringify(user);
		
		$.ajax(
				{
					type: "POST",
					url: "/videoGameStoreCST341/userService/add",
					contentType: "application/json",
					data: userData,
					success: function(data)
				{
						if(data == true)
						{
							openNotification("Successfully added a new user");
							generateTable();
						}
						else
						{ openNotification("Something went wrong adding user :(")}
				},
					error: function (xhr, ajaxOptions, thrownError) 
				{
					alert(xhr.status);
					alert(thrownError);
				}
				}
				);
		
	});
	
	// This method is called when the modify button is pressed, parameters are JSON formatted user and userID
	function updateUser(userData, userId)
	{
		// This AJAX call will send user in JSON format to the REST service's modify method
		$.ajax(
				{
					type: "PUT",
					url: "/videoGameStoreCST341/userService/modify",
					contentType: "application/json",
					data: userData,
					success: function(data)
				{
						if(data == true)
						{
							openNotification("Successfully updated user(id:" +userId +")");
							// If it was successful, change the input values to the new values that were set
							var user = JSON.parse(userData);
							$('#username-' +userId).val(user.username);
							$('#password-' +userId).val(user.password);
							$('#email-' +userId).val(user.emailAddress);
							$('#firstName-' +userId).val(user.firstName);
							$('#lastName-' +userId).val(user.lastName);
							$('#gender-' +userId).val(user.gender);
							$('#privilege-' +userId).val(user.userPrivilege);
						}
						else
						{ openNotification("Something went wrong updating user(id:"+userId +")")}
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
		$(".user-list tbody").empty();
		
		// Retrieve all of the users using the REST service, for each one, create a row, all inputs belonging to a form
		$.ajax({
			type:"GET",
			url: "/videoGameStoreCST341/userService/users",
			dataType: "json",
			success: function(data){
				for(var i = 0; i < data.length; i++)
				{
					var id = data[i].id;
					
					$(".user-list tbody").append("<tr id='user-" +id +"'><form id='" +id +"' method='POST' class='user-form'></form></tr>");
					$("#user-" +id).append("<td><input form='" +id +"' id='" +id  +"' path='id' class='form-control text-secondary' type='hidden' name='id' value='" +id +"'></input>" +id +"</td>"
					+"<td><input form='" +id +"' id='username-" +id +"' class='form-control text-secondary' type='text' name='username' value='" +data[i].username +"'></input></td>"
					+"<input form='" +id +"' id='password-" +id +"' class='form-control text-secondary' type='hidden' name='password' value='" +data[i].password +"'></input>"
					+"<td><input form='" +id +"' id='email-" +id +"' class='form-control text-secondary' type='text' name='email' value='" +data[i].emailAddress +"'></input></td>"
					+"<td><input form='" +id +"' id='firstName-" +id +"' class='form-control text-secondary' type='text' name='firstName' value='" +data[i].firstName +"'></input></td>"
					+"<td><input form='" +id +"' id='lastName-" +id +"' class='form-control text-secondary' type='text' name='lastName' value='" +data[i].lastName +"'></input></td>"
					+"<td><input form='" +id +"' id='gender-" +id +"' class='form-control text-secondary' type='text' name='gender' value='" +data[i].gender +"'></input></td>"
					+"<td><input form='" +id +"' id='privilege-" +id +"' class='form-control text-secondary' type='text' name='userPrivilege' value='" +data[i].userPrivilege +"'></input></td>"
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
	