<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="tag.jsp"%>
<!doctype html>
<html>
<head>
<title>添加${className}</title>
</head>
<body>
<form method="post" action="">
<table width="100%" border="0">
<#if fields??>
<#list fields as field>
<tr>
<td>${field.fieldComment}</td>
<td><input type="text" name="${field.fieldName}" /></td>
</tr>
</#list>
</#if>
</table>
</form>
</body>
</html>