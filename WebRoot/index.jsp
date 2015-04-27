<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<html>
<head>
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/codemirror/codemirror.js"></script>
<script type="text/javascript" src="js/codemirror/javascript/javascript.js"></script>
<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="js/codemirror/codemirror.css">
<style type="text/css">
input {
 width:500px;
}
</style>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">ACF</div>
	<div data-options="region:'center',title:'..'">
		<form action="<%=path%>/generator/emit" method="post">
			<table border="0" width="100%" class="easyui-panel">
				<tr>
					<td>数据库服务器</td>
					<td><input type="text" name="url" value="jdbc:mysql://localhost:3306/jxt?characterEncoding=utf8" />
					</td>
					<td>用户名</td>
					<td><input type="text" name="user" value="sants" /></td>
				</tr>
				<tr>
					<td>驱动名称</td>
					<td><input type="text" name="className" value="com.mysql.jdbc.Driver" />
					</td>
					<td>密码</td>
					<td><input type="text" name="password" value="123456" />
					</td>
				</tr>
				<tr>
					<td>数据库名称</td>
					<td><input type="text" name="dbName" value="jxt" />
					</td>
					<td>业务表</td>
					<td><input type="text" name="tableName" value="jx_student" />
					</td>
				</tr>
				<tr>
					<td>作者</td>
					<td><input type="text" name="author" value="admin" /></td>
					<td>包路径</td>
					<td><input type="text" name="packageName" value="com.test.pub" /></td>
				</tr>
				<tr>
					<td>版本</td>
					<td><input type="text" name="version" value="0.1" /></td>
					<td>日期</td>
					<td><input type="text" name="createdate" class="easyui-datebox" /></td>
				</tr>
				<tr>
					<td>类名</td>
					<td><input type="text" name="classFullName" value="Admin" /></td>
					<td>类备注</td>
					<td><input type="text" name="classDesc" value="com.test.pub" />
					</td>
				</tr>
			</table>
			<table border="0" width="100%" class="easyui-panel">
				<tr>
					<td>Spring</td>
					<td><input type="checkbox" name="framework" value="spring" />
					</td>
				</tr>
			</table>
			<table border="0" width="100%" class="easyui-panel">
				<tr>
					<td>FTP服务器</td>
					<td><input type="text" name="ftp_ip" />
					</td>
					<td>用户名</td>
					<td><input type="text" name="ftp_username" /></td>
				</tr>
				<tr>
					<td>路径</td>
					<td><input type="text" name="ftp_path" /></td>
					<td>密码</td>
					<td><input type="text" name="ftp_password" />
					</td>
				</tr>
				<tr>
					<td>存储路径</td>
					<td colspan="2"><input type="text" name="local_path" /></td>
				</tr>
			</table>
			<table>
				<tr>
					<td>
						<textarea id="myTextArea" name="template_code" placeholder="Coding..">
						</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="submit">加工</button>
						<button type="reset">重置</button></td>
				</tr>
			</table>
		</form>
	</div>
</body>
<script type="text/javascript">
 CodeMirror.fromTextArea(document.getElementById("myTextArea"), {
    lineNumbers: true,
    viewportMargin:10,
    height:300,
    mode: "javascript"
  });
</script>
</html>
