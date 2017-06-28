<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE HTML>
<html lang="ko">
<head>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<tiles:insertAttribute name="head" />
</head>
<tiles:insertAttribute name="body" />
</html>