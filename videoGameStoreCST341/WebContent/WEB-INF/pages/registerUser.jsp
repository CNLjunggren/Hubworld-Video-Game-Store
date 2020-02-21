<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<body class="bg-dark">
<div class="container-fluid" style="height:100%">
    <div class="row" style="margin: 0 auto; height:100%">
        <div class="col-md-12" style="margin: 0 auto">
            <div class="form-box bg-primary border-info">
                <h2 class= "text-center text-dark border-bottom border-dark mt-1">Register for an Account</h2>
                <form:form method="POST" modelAttribute="user" action="registeruser">
                    <div class="row mb-4">
                        <div class="col">
                            <form:label path="username" class="text-dark">Username:</form:label>
                            <form:input path="username" class="form-control text-secondary" type="text" name="username" placeholder="JohnDoe123"></form:input>
                        	<form:errors path="username" class="error"/>
                        </div>
                        <div class="col">
                            <form:label path="password" class="text-dark">Password:</form:label>
                            <form:input path="password" class="form-control text-secondary" type="text" name="password" placeholder="*******"></form:input>
                        	<form:errors path="password" class="error"/>
                        </div>
                    </div>
                    <div class="row mb-4">
                        <div class="col">
                            <form:label path="emailAddress" class="text-dark">Email Address:</form:label>
                            <form:input path="emailAddress" class="form-control text-secondary" type="text" name="emailAddress" placeholder="JohnDoe@gmail.com"></form:input>
                       		<form:errors path="emailAddress" class="error"/>
                        </div>
                    </div>
                    <div class="row mb-4">
                        <div class="col">
                            <form:label path="firstName" class="text-dark">First Name:</form:label>
                            <form:input path="firstName" class="form-control text-secondary" type="text" name="firstname" placeholder="John"></form:input>
                        	<form:errors path="firstName" class="error"/>
                        </div>
                    </div>
                    <div class="row mb-4">
                        <div class="col">
                            <form:label path="lastName" class="text-dark">Last Name:</form:label>
                            <form:input path="lastName" class="form-control text-secondary" type="text" name="lastName" placeholder="Doe"></form:input>
                        	<form:errors path="lastName" class="error"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <form:label path="gender" class="text-dark">Gender:</form:label>
                            <div class="form-check form-check-inline ml-4">
                                <form:radiobutton path="gender" class="form-check-input" name="radio" id="inlineRadio1" value="0"></form:radiobutton>
                                <label class="form-check-label text-dark" for="inlineRadio1">Male</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <form:radiobutton path="gender" class="form-check-input" name="radio" id="inlineRadio2" value="1"></form:radiobutton>
                                <form:label path="gender" class="form-check-label text-dark" for="inlineRadio2">Female</form:label>
                            </div>
                            <form:errors path="gender" class="error"/>
                        </div>
                    </div>
                    <div class="row">
                    	<div class="col" style= "text-align: center;">
                    		<input class="btn-secondary mt-3" id="form-submit" type="submit" name="submit" value="Register"/>
                    	</div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>