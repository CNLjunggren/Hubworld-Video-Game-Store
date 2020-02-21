<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<body class="bg-dark">
	<div class="container-fluid h-100">
		<table id="users" class="user-list mt-5 w-100">
			<thead>
				<tr>
					<th style="width:5%">ID</th>
					<th style="width:10%">Username</th>
					<th style="width:15%">Email</th>
					<th style="width:20%">First Name</th>
					<th style="width:20%">Last Name</th>
					<th style="width:5%">Gender</th>
					<th style="width:10%">Privilege</th>
					<th style="width:5%"></th>
					<th style="width:5%"></th>
				</tr>
			</thead>
			
			<tbody>
				<!-- Dynamically generate content -->
			</tbody>	
		</table>
	</div>

<script>
	$(document).ready(function() {
		getUsers();
				
	});
	
	
	function getUsers()
	{
		$.ajax(
				{
					type: "GET",
					url: "/videoGameStoreCST341/userService/users",
					dataType: "json",
					success: function(data)
				{
					$('#users').dataTable({
											"data": data,
											"columns": [{"data": "id"}, {"data": "username"}, {"data": "emailAddress"}, {"data" : "firstName"},
												{"data" : "lastName"},  {"data" : "gender"}, {"data" : "userPrivilege"},
												{"data": null, "defaultContent": "<button name='modify' class='btn btn-secondary'> Modify </button>", "orderable": false},
												{"data": null, "defaultContent": "<button name= 'delete' class='btn btn-secondary'> Delete </button>", "orderable": false}]
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

	</script>
</body>
