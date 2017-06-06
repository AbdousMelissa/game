<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Application game</title>
<c:url value="/webjars/bootstrap/3.1.0" var="bootstrapUrl" />
<c:url value="/webjars/jquery/3.1.1-1" var="jqueryUrl" />
<c:url value="/webjars/jquery-ui/1.12.1" var="jqueryuiUrl" />
<c:url value="/webjars/datatables/1.10.12" var="datatablesUrl" />
<c:url value="/webjars/datatables-colreorder/1.2.0"
	var="datatablesColreorderUrl" />
<c:url value="/css" var="appCssUrl" />

<!-- Jquery -->
<script type="text/javascript" src="${jqueryUrl}/jquery.min.js"></script>
<!-- Bootstrap -->
<script type="text/javascript" src="${bootstrapUrl}/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${bootstrapUrl}/css/bootstrap.min.css">
<!-- JQuery UI -->
<script type="text/javascript" src="${jqueryuiUrl}/jquery-ui.min.js"></script>
<link rel="stylesheet" href="${jqueryuiUrl}/jquery-ui.min.css">
<!-- Datatables plugin -->
<script type="text/javascript"
	src="${datatablesUrl}/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet"
	href="${datatablesUrl}/css/jquery.dataTables.min.css">
<!-- Application -->
<link rel="stylesheet" href="${appCssUrl}/application.css">
</head>
<body>
	<div id="header" class="navbar-default navbar-fixed-top">
		<h1>Ma super application de cocktails</h1>
		<div style="float: right;padding:10px">
			<form action="<c:url value="/logout" />" method="post">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}">
				<button>Se déconnecter</button>
			</form>
		</div>
	</div>
</body>
</html>