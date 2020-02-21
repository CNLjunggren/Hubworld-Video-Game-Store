<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


	<body class="bg-dark">
		<div class="container-fluid" style="height:100%">
		    <div class="row" style="margin: 0 auto; height:100%">
		        <div class="col-md-12" style="margin: 0 auto">
		            <div class="form-box bg-primary border-info">
		                <h2 class= "text-center text-dark border-bottom border-dark mt-1">Add a Product</h2>
		                <form:form method="POST" modelAttribute="product" action="addProduct">
		                    <div class="row mb-4">
		                        <div class="col">
		                            <form:label path="name" class="text-dark">Name:</form:label>
		                            <form:input path="name" class="form-control text-secondary" type="text" name="firstname" placeholder="Product Name"></form:input>
		                        	<form:errors path="name" class="error"/>
		                        </div>
		                        <div class="col">
		                            <form:label path="price" class="text-dark">Price:</form:label>
		                            <form:input path="price" class="form-control text-secondary" type="text" name="firstname" placeholder="John"></form:input>
		                        	<form:errors path="price" class="error"/>
		                        </div>
		                    </div>
		                    <div class="row mb-4">
		                        <div class="col">
		                            <form:label path="seller" class="text-dark">Seller:</form:label>
		                            <form:input path="seller" class="form-control text-secondary" type="text" name="firstname" placeholder="John Doe"></form:input>
		                       		<form:errors path="seller" class="error"/>
		                        </div>
		                    </div>
		                    <div class="row mb-4">
		                        <div class="col">
		                        <form:label path="condition" class="text-dark">Condition:</form:label>
		                            <div class="form-check form-check-inline ml-4">
		                                <form:radiobutton path="condition" class="form-check-input" name="radio" id="inlineRadio1" value="0"></form:radiobutton>
		                                <label class="form-check-label text-dark" for="inlineRadio1">New</label>
		                            </div>
		                            <div class="form-check form-check-inline">
		                                <form:radiobutton path="condition" class="form-check-input" name="radio" id="inlineRadio2" value="1"></form:radiobutton>
		                                <form:label path="condition" class="form-check-label text-dark" for="inlineRadio2">Used</form:label>
		                            </div>
		                            <form:errors path="condition" class="error"/>                
								</div>
		                    </div>
		                    <div class="row mb-4">
		                        <div class="col">
		                            <form:label path="imagePath" class="text-dark">Image Path:</form:label>
		                            <form:input path="imagePath" class="form-control text-secondary" type="text" name="firstname" value="/resources/images/"></form:input>
		                        </div>
		                    </div>
		                    <div class="row">
		                    	<div class="col" style= "text-align: center;">
		                    		<input class="btn-secondary mt-3" id="form-submit" type="submit" name="submit" value="Add Product"/>
		                    	</div>
		                    </div>
		                </form:form>
		            </div>
		        </div>
		    </div>
		</div>
	</body>

