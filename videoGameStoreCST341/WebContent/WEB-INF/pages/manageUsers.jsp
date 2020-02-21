<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<body class="bg-dark">

	<script src="<spring:url value='/resources/js/manageUserScript.js'/>"></script>

	<div class="notification-box">
		<h5 class='text-center text-white' id='notification-text'></h5>
	</div>

	<div class="container-fluid" style="min-height:100%">
		<div class="row mt-4" >
			<div class="col-12 col-sm-12 col-md-4 col-lg-4 col-xl-4">
				<button class="btn btn-secondary float-left" name="add"  data-toggle="modal" data-target="#addUser">Add User</button>
			</div>
		</div>
		<table class="user-list mt-5">
			<thead>
				<tr>
					<th style="width:5%">ID</th>
					<th style="width:15%">Username</th>
					<th style="width:20%">Email</th>
					<th style="width:10%">First Name</th>
					<th style="width:10%">Last Name</th>
					<th style="width:5%">Gender</th>
					<th style="width:10%">Privilege</th>
					<th style="width:10%"></th>
					<th style="width:10%"></th>
				</tr>
			</thead>
			<tbody>
			
			</tbody>
		</table>
	</div>


	<!-- Modal -->
	<div class="modal fade" id="addUser" tabindex="-1" role="dialog" aria-labelledby="addUserLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="addUserLabel">Add a User</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <form:form method="POST" modelAttribute="user" id="addUserForm">
		                    <div class="row mb-4">
		                        <div class="col">
		                            <form:label path="username" class="text-dark float-left">Username:</form:label>
		                            <form:input id="addUsername" path="username" class="form-control text-secondary" type="text" name="username" placeholder="Username"></form:input>
		                        </div>
		                        <div class="col">
		                            <form:label path="password" class="text-dark float-left">Password:</form:label>
		                            <form:input id="addPassword" path="password" class="form-control text-secondary" type="text" name="password" placeholder="Password"></form:input>
		                        </div>
		                    </div>
		                    
		                    <div class="row mb-4">
		                        <div class="col">
		                            <form:label path="emailAddress" class="text-dark float-left">Email Address:</form:label>
		                            <form:input id="addEmailAddress" path="emailAddress" class="form-control text-secondary" type="text" name="emailAddress" placeholder="mail@mail.com"></form:input>
		                        </div>
		                    </div>
		                    
		                    <div class="row mb-4">
		                        <div class="col">
		                            <form:label path="firstName" class="text-dark float-left">First Name:</form:label>
		                            <form:input id="addFirstName" path="firstName" class="form-control text-secondary" type="text" name="firstName" placeholder="John"></form:input>
		                        </div>
		                        <div class="col">
		                            <form:label path="lastName" class="text-dark float-left">Last Name:</form:label>
		                            <form:input id="addLastName" path="lastName" class="form-control text-secondary" type="text" name="lastName" placeholder="Doe"></form:input>
		                        </div>
		                    </div>
		                    
		                    <div class="row mb-4">
		                        <div class="col">
		                        <form:label path="gender" class="text-dark float-left">Gender:</form:label>
		                            <div class="form-check form-check-inline ml-4">
		                                <form:radiobutton path="gender" class="form-check-input conditionRadio" name="radio" id="genderMale" value="0"></form:radiobutton>
		                                <label class="form-check-label text-dark" for="genderMale">Male</label>
		                            </div>
		                            <div class="form-check form-check-inline">
		                                <form:radiobutton path="gender" class="form-check-input conditionRadio" name="radio" id="genderFemale" value="1"></form:radiobutton>
		                                <form:label path="gender" class="form-check-label text-dark" for="genderFemale">Female</form:label>
		                            </div>           
								</div>
		                    </div>
		                    <div class="row mb-4">
		                        <div class="col">
		                            <form:label path="userPrivilege" class="text-dark float-left">User Privilege Status:</form:label>
		                            <form:input id="addUserPrivilege" path="userPrivilege" class="form-control text-secondary" type="text" name="userPrivilege" value="0"></form:input>
		                        </div>
		                    </div>
		                </form:form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-secondary" id="addUserButton" data-dismiss="modal">Add User</button>
	      </div>
	    </div>
	  </div>
	</div>
</body>