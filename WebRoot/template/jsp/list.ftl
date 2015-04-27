<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="tag.jsp"%>
<!doctype html>
<html>
<head>
<title>列表${className}</title>
</head>
<body>
<form method="post" action="">
<table width="100%" border="0">
<tr>
<#if fields??>
<#list fields as field>
<td>${field.fieldComment}</td>
</#list>
</#if>
</tr>
<c:foreach var="item" items="object">
	<tr>
		<td><a href="#">编辑</a></td>
		<td><a href="#">删除</a></td>
	</tr>
</c:foreach>
</table>
</form>
</body>
</html>