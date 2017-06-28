<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE HTML>
<html lang="ko">
<head>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<tiles:insertAttribute name="head" />
</head>
<body id="<tiles:insertAttribute name="main" />">
<tiles:insertAttribute name="accessibility" />
<div id="wrap">
	<div id="inBox">
		<div id="sideNav">
			<tiles:insertAttribute name="lnb" />
		</div>
		<div id="container">
			<tiles:insertAttribute name="body" />
		</div>
		<hr />
		<tiles:insertAttribute name="footer" />
	</div>
</div>
</body>
</html>