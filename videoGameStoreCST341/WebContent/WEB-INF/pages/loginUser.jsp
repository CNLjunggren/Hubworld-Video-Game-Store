<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<body class="bg-dark">
	<div class="container-fluid" style="height:100%">
    <div class="row" style="margin: 0 auto; height:100%">
        <div class="col-md-12" style="margin: 0 auto">
            <div class="form-box bg-primary border-info">
                <h2 class= "text-center text-dark border-bottom border-dark mt-1">Login to Hubworld</h2>
                <form:form method="POST" modelAttribute="user" action="loginuser">
                    <div class="row mb-4">
                        <div class="col">
                            <form:label path="username" class="text-dark">Username:</form:label>
                            <form:input path="username" class="form-control text-secondary" type="text" name="username" placeholder="JohnDoe123"></form:input>
                        	<form:errors path="username" class="error"/>
                        </div>
                    </div>
                    <div class="row mb-4">
                        <div class="col">
                           <form:label path="password" class="text-dark">Password:</form:label>
                            <form:input path="password" class="form-control text-secondary" type="password" name="password" placeholder="*******"></form:input>
                        	<form:errors path="password" class="error"/>
                        </div>
                    </div>
                    <div class="row">
                    	<div class="col" style= "text-align: center;">
                    		<input class="btn-secondary mt-3" id="form-submit" type="submit" name="submit" value="Login"/>
                    	</div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>