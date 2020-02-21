<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<c:choose>
	<c:when test="${empty sessionScope.user.username}">
		<nav class="navbar navbar-expand-md bg-primary navbar-dark border-bottom border-info">
		    <div class="container"><a class="navbar-brand" href="store">Hubworld Trading</a> <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbar2SupportedContent"> <span class="navbar-toggler-icon"></span> </button>
		        <div class="collapse navbar-collapse text-center justify-content-end" id="navbar2SupportedContent">
		            <a class="btn navbar-btn btn-primary ml-2 text-white" href="register">Register</a>
		            <a class="btn navbar-btn btn-primary ml-2 text-white" href="login">Login</a>
		            <a class="btn navbar-btn btn-primary ml-2 text-white" href="store">Store</a>
		        </div>
		    </div>
		</nav>
	</c:when>
	<c:otherwise>
		<c:choose>
			<%--If the user that is logged in is a client, not admin--%>
			<c:when test="${sessionScope.user.userPrivilege == '0'}">
				<nav class="navbar navbar-expand-md bg-primary navbar-dark border-bottom border-info">
			    <div class="container"><a class="navbar-brand" href="store">Hubworld Trading</a> <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbar2SupportedContent"> <span class="navbar-toggler-icon"></span> </button>
			        <div class="collapse navbar-collapse text-center justify-content-end" id="navbar2SupportedContent">
			            <a class="btn navbar-btn btn-primary ml-2 text-white" href="store">Store</a>
			            <a class="btn navbar-btn btn-primary ml-2 text-white font-bold" href="login">Log Out</a>
			        </div>
			    </div>
			</nav>
			</c:when>
			<%--If the user that is logged in is an admin--%>
			<c:otherwise>
				<nav class="navbar navbar-expand-md bg-primary navbar-dark border-bottom border-info">
			    <div class="container"><a class="navbar-brand" href="store">Hubworld Trading</a> <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbar2SupportedContent"> <span class="navbar-toggler-icon"></span> </button>
			        <div class="collapse navbar-collapse text-center justify-content-end" id="navbar2SupportedContent">
			            <a class="btn navbar-btn btn-primary ml-2 text-white" href="store">Store</a>
				        <a class="btn navbar-btn btn-primary ml-2 text-white" href="showProducts">Product List</a>
			       		<div class="dropdown">
				            <button class='btn btn-primary dropdown-toggle' type='button' id='userDropdown' data-toggle='dropdown' aria-haspopup='true' aria-expanded='false'>
				            Manage Users </button>
				            <div class='dropdown-menu' aria-labelledby='userDropdown'>
					            <a class='dropdown-item' href='showUsers'>User List</a>
					            <a class='dropdown-item' href='manageUsers'>Manage Users</a>
				       		</div>
			       		</div>
			       		<a class="btn navbar-btn btn-primary ml-2 text-white font-bold" href="login">Log Out</a>
			       	</div>
			    </div>
			</nav>
			</c:otherwise>
		</c:choose>
	</c:otherwise>
</c:choose>




<div align="center">	
	<label>${errorMsg}</label>	
</div>
