<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${locale}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
	
	<head>
		
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

		<title>Comente - Sobre</title>
		
		<link href="<c:url value="/comentesobre.css"/>" rel="stylesheet" type="text/css" media="screen" />
		
		<script type="text/javascript" src="<c:url value="/js/jquery-1.3.2.min.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/js/jquery.validate.min.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/js/jquery.autocomplete.min.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/js/jquery.puts.js"/>"></script>
		
	</head>
	<body>

	    <c:set var="path"><c:url value="/"/></c:set>

	    <div id="menuWrap">
 
	    	<form class="busca" action="${path }topico/busca" method="get">
		    	<ul id="menuElementsEn">
		        	<li><a href="${path }"><span>Comente Sobre</span></a></li>
		        </ul>
		    </form>
	    </div><!-- menuWrap-->
		<c:if test="${not empty errors}">
			<div id="errors">
				<ul>
					<c:forEach items="${errors }" var="error">
						<li>${error.category } - ${error.message }</li>
					</c:forEach>
				</ul>
			</div>
		</c:if>
		<c:if test="${not empty notice}">
			<div id="notice">
				<p>${notice }</p>
			</div>
		</c:if>
		<div id="contentWrap">