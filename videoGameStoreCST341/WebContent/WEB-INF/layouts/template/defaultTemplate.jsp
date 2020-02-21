<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>Hubworld Trading</title>
	
	<spring:url value="/resources/css/bootstrap.css" var="mainCss" />
	<spring:url value="/resources/css/custom-style.css" var="customCss" />
	<spring:url value="/resources/js/bootstrap.bundle.min.js" var="bootstrapJS" />
	<spring:url value="/resources/js/jquery-3.3.1.min.js" var="jQuery" />
	<spring:url value="/resources/js/popper.min.js" var="popperJS" />
	<link href="${mainCss}" rel="stylesheet" />
	<link href="${customCss}" rel="stylesheet" />
	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css"></link>
	<link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.5.2/css/buttons.dataTables.min.css"></link>
	
	<script src="${jQuery}"></script>
	<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
	<script src="https://cdn.datatables.net/buttons/1.5.2/js/dataTables.buttons.min.js"></script>
	<script src="${bootstrapJS}"></script>
	<script src="${popperJS}"></script>
	
</head>

<body>
	<!-- Header -->
	<tiles:insertAttribute name="header" />

	<!-- Body Page -->
	<div align="center">
		<tiles:insertAttribute name="body" />
	</div>

	<!-- Footer Page -->
	<tiles:insertAttribute name="footer" />
</body>

<style>
</style>

</html>