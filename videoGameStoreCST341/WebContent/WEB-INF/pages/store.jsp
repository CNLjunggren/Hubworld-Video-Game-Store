<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<body class="bg-dark">

	<div class="container-fluid">
	<div class="col-2 col-sm-2 col-md-2 col-lg-2 border-info" style="border-right:1px solid black;"></div>
            <div class="col-lg-10 col-md-10 col-sm-10 col-10" style="margin-top:2%">
                <div class="row" style="width: 100%; padding-left:1%;">
                </div>
            </div>
		<div class="col-12 col-sm-12 col-md-12 col-lg-12 d-flex flex-row " style="padding-left: 0;">
		<div class="row" style="padding-left: 1%;">
			<c:forEach items="${products}" var="product">
				<div class="item-box border-dark bg-primary" style="border-bottom: 1px solid black; width: 310px; height: 400px; margin-left:10px">
					<div class="row image-row border-dark">
						<div class="container">
							<img src=<spring:url value="${product.imagePath}"/> style="max-width: 100%" />
						</div>
					</div>
					<div class="row item-info-row border-dark">
						<div class="col-md-8 item-info-col border-dark" style="border-right: 2px solid;">
							<a href="" class="text-dark">${product.name}</a>
						</div>
						<div class="col-md-4 item-info-col border-dark\">$${product.price}</div>
					</div>
					<div class="row item-select-row">
						<div class="col-md-12 item-select-col">
							<form class='addToCartForm' method='post' style='max-height: 100%;'>
								<input type='hidden' name='product_id' value='${product.id}' /> 
								<input class="btn-secondary" id="form-submit" type="submit" value="Add To Cart" style="width: 50%; cursor: pointer;"/>
							</form>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		</div>
	</div>
</body>