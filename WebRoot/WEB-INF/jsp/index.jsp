<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
</head>
<body>
	<table width="50%" align="left">
		<tr>
			<td>
				<form action="flow/exe" method="post" id="form1" target="_self">
					<table border="1" width="100%">
						<tr>
							<td>IP地址</td>
							<td><input type="text" name="ip" id="ip" value="127.0.0.1" />
						</tr>
						<tr>
							<td>数据库服务器</td>
							<td><input type="text" name="dbUrl" id="dbUrl"
								value="jdbc:oracle:thin:@192.168.0.12:1521:orcl" /></td>
							<td>用户名</td>
							<td><input type="text" name="dbUser" id="dbUser" value="omc" />
							</td>
						</tr>
						<tr>
							<td>驱动名称</td>
							<td><input type="text" name="dbClassName" id="dbClassName"
								value="oracle.jdbc.driver.OracleDriver" /></td>
							<td>密码</td>
							<td><input type="text" name="dbPassword" id="dbPassword"
								value="omc" /></td>
						</tr>
						<tr>
							<td>数据库名称</td>
							<td><input type="text" name="dbName" id="dbName"
								value="orcl" /></td>
							<td>业务表</td>
							<td><input type="text" name="tablename" id="tablename"
								value="OMC_USER_TAB" /></td>
						</tr>
					</table>
					<table border="1" width="100%">
						<tr>
							<td>作者</td>
							<td><input type="text" name="author" id="author"
								value="admin" class="easyui-validatebox"
								data-options="required:true" />
							</td>
							<td>包路径</td>
							<td><input type="text" name="packageName" id="packageName"
								value="com.test.pub" /></td>
						</tr>
						<tr>
							<td>单位</td>
							<td><input type="text" name="company" id="company"
								value="company" class="easyui-validatebox"
								data-options="required:true" />
							</td>
							<td>日期</td>
							<td><input type="text" name="createdate" id="createdate"
								class="easyui-datebox" />
							</td>
						</tr>
						<tr>
							<td>类名</td>
							<td><input type="text" name="className" id="className"
								value="Admin" /></td>
							<td>类备注</td>
							<td><input type="text" name="classDesc" id="classDesc"
								value="com.test.pub" /></td>
						</tr>
					</table>
					<table border="1" width="100%">
						<tr>
							<th>生成项</th>
							<th>版本</th>
							<th>说明</th>
							<th>操作</th>
						</tr>
						<tr>
							<td>Action</td>
							<td><input type="text" name="version" value="0.1" />
							</td>
							<td><input type="text" name="version" value="" />
							</td>
							<td><input type="checkbox" checked="checked"></td>
						</tr>
						<tr>
							<td>Dao</td>
							<td><input type="text" name="version" value="0.1" />
							</td>
							<td><input type="text" name="version" value="" />
							</td>
							<td><input type="checkbox" checked="checked"></td>
						</tr>
						<tr>
							<td>Service</td>
							<td><input type="text" name="version" value="0.1" />
							</td>
							<td><input type="text" name="version" value="" />
							</td>
							<td><input type="checkbox" checked="checked"></td>
						</tr>
					</table>
					<table>
						<tr>
							<td>
								<input type="submit" value="生产">
							</td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>
