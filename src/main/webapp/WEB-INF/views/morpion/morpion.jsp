<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<jsp:include page="../header.jsp" />
</head>
<body>
	<h1>Jeux du morpion:</h1>
	
	<p>${ Message }</p>
	<c:set var="index" value="0"/>
	<c:url value="/images" var="imgUrl" />
	<c:url value="/Jeu_Morpion?position=" var="MorpionUrl" />
	<c:forEach items="${ table }" var="elementTable">
		<c:set var="index" value="index+1"/>
		<a href="${ MorpionUrl }${ index }"><img src="${ imgUrl }/${ elementTable }.png"></a>
	</c:forEach>

	<jsp:include page="../footer.jsp" />
</body>
</html>