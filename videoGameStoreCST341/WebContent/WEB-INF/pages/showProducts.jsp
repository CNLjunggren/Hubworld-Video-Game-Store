<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<body class="bg-dark">

	<div class="notification-box">
		<h5 class='text-center text-white' id='notification-text'></h5>
	</div>
	
	<div class="container-fluid h-100">
		<div class="row mt-4" >
			<div class="col-12 col-sm-12 col-md-4 col-lg-4 col-xl-4">
				<button class="btn btn-secondary float-left" name="add"  data-toggle="modal" data-target="#addProduct">Add Product</button>
			</div>
		</div>
		<div class="row mt-2">
			<div class="col-12">
				<table class="show-product-list mt-5 w-100 text-light text-center" id="products">
					<thead>
						<tr>
							<th style="width:5%">ID</th>
							<th style="width:20%">Product Name</th>
							<th style="width:10%">Price</th>
							<th style="width:10%">Condition</th>
							<th style="width:20%">Image Path</th>
							<th style="width:15%">Seller</th>
							<th style="width:10%"></th>
							<th style="width: 10%"></th>
						</tr>
					</thead>
					<tbody>
						<!-- dynamically loaded content -->
					</tbody>
				</table>
			</div>
		</div>
		
		<!-- Modify Modal -->
	<div class="modal fade" id="modifyProduct" tabindex="-1" role="dialog" aria-labelledby="modifyProductLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="modifyProductLabel">Modify Product</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <form:form method="POST" modelAttribute="product" id="modifyProductForm">
		                    <div class="row mb-4">
		                        <div class="col">
		                            <form:label path="name" class="text-dark float-left">Name:</form:label>
		                            <form:input id="modifyProductName" path="name" class="form-control text-secondary" type="text" name="firstname" placeholder="Product Name"></form:input>
		                        </div>
		                        <div class="col">
		                            <form:label path="price" class="text-dark float-left">Price:</form:label>
		                            <form:input id="modifyProductPrice" path="price" class="form-control text-secondary" type="text" name="firstname" placeholder="John"></form:input>
		                        </div>
		                    </div>
		                    <div class="row mb-4">
		                        <div class="col">
		                            <form:label path="seller" class="text-dark float-left">Seller:</form:label>
		                            <form:input id="modifyProductSeller" path="seller" class="form-control text-secondary" type="text" name="firstname" placeholder="John Doe"></form:input>
		                        </div>
		                    </div>
		                    <div class="row mb-4">
		                        <div class="col">
		                        <form:label path="condition" class="text-dark float-left">Condition:</form:label>
		                            <div class="form-check form-check-inline ml-4">
		                                <form:radiobutton path="condition" class="form-check-input conditionRadio" name="radio" id="conditionNew" value="0"></form:radiobutton>
		                                <label class="form-check-label text-dark" for="conditionNew">New</label>
		                            </div>
		                            <div class="form-check form-check-inline">
		                                <form:radiobutton path="condition" class="form-check-input conditionRadio" name="radio" id="conditionUsed" value="1"></form:radiobutton>
		                                <form:label path="condition" class="form-check-label text-dark" for="conditionUsed">Used</form:label>
		                            </div>           
								</div>
		                    </div>
		                    <div class="row mb-4">
		                        <div class="col">
		                            <form:label path="imagePath" class="text-dark float-left">Image Path:</form:label>
		                            <form:input id="modifyProductImagePath" path="imagePath" class="form-control text-secondary" type="text" name="firstname" value="/resources/images/"></form:input>
		                        </div>
		                    </div>
		                    <input type='hidden' id='product-id'/>
		                </form:form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-secondary" id="modifyProductButton" data-dismiss="modal" name="modifyProduct">Modify Product</button>
	      </div>
	    </div>
	  </div>
	</div>
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="addProduct" tabindex="-1" role="dialog" aria-labelledby="addProductLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="addProductLabel">Add a Product</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <form:form method="POST" modelAttribute="product" id="addProductForm">
		                    <div class="row mb-4">
		                        <div class="col">
		                            <form:label path="name" class="text-dark float-left">Name:</form:label>
		                            <form:input id="addProductName" path="name" class="form-control text-secondary" type="text" name="firstname" placeholder="Product Name"></form:input>
		                        </div>
		                        <div class="col">
		                            <form:label path="price" class="text-dark float-left">Price:</form:label>
		                            <form:input id="addProductPrice" path="price" class="form-control text-secondary" type="text" name="firstname" placeholder="John"></form:input>
		                        </div>
		                    </div>
		                    <div class="row mb-4">
		                        <div class="col">
		                            <form:label path="seller" class="text-dark float-left">Seller:</form:label>
		                            <form:input id="addProductSeller" path="seller" class="form-control text-secondary" type="text" name="firstname" placeholder="John Doe"></form:input>
		                        </div>
		                    </div>
		                    <div class="row mb-4">
		                        <div class="col">
		                        <form:label path="condition" class="text-dark float-left">Condition:</form:label>
		                            <div class="form-check form-check-inline ml-4">
		                                <form:radiobutton path="condition" class="form-check-input conditionRadio" name="radio" id="conditionNew" value="0"></form:radiobutton>
		                                <label class="form-check-label text-dark" for="conditionNew">New</label>
		                            </div>
		                            <div class="form-check form-check-inline">
		                                <form:radiobutton path="condition" class="form-check-input conditionRadio" name="radio" id="conditionUsed" value="1"></form:radiobutton>
		                                <form:label path="condition" class="form-check-label text-dark" for="conditionUsed">Used</form:label>
		                            </div>           
								</div>
		                    </div>
		                    <div class="row mb-4">
		                        <div class="col">
		                            <form:label path="imagePath" class="text-dark float-left">Image Path:</form:label>
		                            <form:input id="addProductImagePath" path="imagePath" class="form-control text-secondary" type="text" name="firstname" value="/resources/images/"></form:input>
		                        </div>
		                    </div>
		                </form:form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-secondary" id="addProductButton" data-dismiss="modal">Add Product</button>
	      </div>
	    </div>
	  </div>
	</div>

<script src="<spring:url value='/resources/js/showProductScript.js'/>"></script>
</body>
