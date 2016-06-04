<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=path%>/public/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/public/bootstrap/css/bootstrap-theme.min.css">
</head>
<body class="container">
<ul class="nav nav-tabs" id="menuTab">
    <li class="active"><a href="#normal" data-toggle="tab">Index</a></li>
    <li><a href="#console" data-toggle="tab">console</a></li>
    <li><a href="#usage" data-toggle="tab">usage</a></li>
    <li><a href="#wiki" data-toggle="tab">wiki</a></li>
</ul>
<div class="panel"></div>
<div class="tab-content">
<div class="tab-pane fade in active" id="normal">
<form class="form-horizontal" action="<%=path%>/generator/emit" method="post">
	<div class="panel panel-danger">
        <div class="panel-heading">数据源</div>
        <div class="panel-body">
            <div class="row">
            	<div class="col-md-4">
                    <div class="form-group">
                        <label class="col-md-3 control-label">数据库</label>
                        <div class="col-md-9">
                        	<select class="form-control dbType">
                        		<option value="-1">----</option>
                        		<option value="mysql">Mysql</option>
                        		<option value="oracle">Oracle</option>
                        	</select>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="server" class="col-md-3 control-label">服务器</label>
                        <div class="col-md-9">
                        	<input type="text" name="server" class="form-control server" placeholder="127.0.0.1" />
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="port" class="col-md-3 control-label">端口</label>
                        <div class="col-md-9">
                        	<input type="text" name="port" class="form-control port" placeholder="3306" />
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="panel panel-success">
        <div class="panel-heading">数据源</div>
        <div class="panel-body">
            <div class="row">
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="url" class="col-md-3 control-label">数据源</label>
                        <div class="col-md-9">
                            <input type="text" name="url" class="form-control url" placeholder="jdbc:mysql://ip:port/db?characterEncoding=utf8" />
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="user" class="col-md-3 control-label">用户名</label>
                        <div class="col-md-9">
                            <input type="text" name="user" class="form-control" placeholder="Sants" />
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="password" class="col-md-3 control-label">密码</label>
                        <div class="col-md-9">
                            <input type="text" name="password" class="form-control" placeholder="******" />
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="className" class="col-md-3 control-label">驱动</label>
                        <div class="col-md-9">
                            <input type="text" name="className" class="form-control className" placeholder="com.mysql.jdbc.Driver" />
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="dbName" class="col-md-3 control-label">数据库</label>
                        <div class="col-md-9">
                            <input type="text" name="dbName" class="form-control" placeholder="schema" />
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="tableName" class="col-md-3 control-label">业务表</label>
                        <div class="col-md-9">
                            <input type="text" name="tableName" class="form-control" placeholder="user" />
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="panel panel-info">
        <div class="panel-heading">数据源</div>
        <div class="panel-body">
            <div class="row">
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="author" class="col-md-3 control-label">作者</label>
                        <div class="col-md-9">
                            <input type="text" name="author" class="form-control" placeholder="Author" />
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="form-group" >
                        <label for="packageName" class="col-md-3 control-label">包路径</label>
                        <div class="col-md-9">
                            <input type="text" name="packageName" class="form-control" placeholder="com.test.pub" />
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="classFullName" class="col-md-3 control-label">类名</label>
                        <div class="col-md-9">
                            <input type="text" name="classFullName" class="form-control" placeholder="User" />
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="classDesc" class="col-md-3 control-label">类备注</label>
                        <div class="col-md-9">
                            <input type="text" name="classDesc" class="form-control" placeholder="Create By Author" />
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="createdate" class="col-md-3 control-label">日期</label>
                        <div class="col-md-9">
                            <input type="text" name="createdate" class="form-control" placeholder="2016-06-06" />
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="version" class="col-md-3 control-label">版本</label>
                        <div class="col-md-9">
                            <input type="text" name="version" class="form-control" placeholder="******" />
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
    	<div class="col-md-6">
    		<button class="btn btn-success btn-block btn-lg" type="submit">Emit</button>
		</div>
    	<div class="col-md-6">
    		<button class="btn btn-danger btn-block btn-lg" type="reset">Rest</button>
		</div>
	</div>    
</form>
</div>
<div class="tab-pane fade" id="usage">
	<h1>Usage</h1>
</div> 
<div class="tab-pane fade" id="wiki">
	<h1>Wiki</h1>
</div> 
<div class="tab-pane fade" id="console">
	<h1>Console</h1>
</div> 
</div> 
</body>
<script type="text/javascript" src="<%=path%>/public/jquery/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="<%=path%>/public/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=path%>/public/js/app.js"></script>
<script>
$('#menuTab a').click(function (e) {
  e.preventDefault()
  $(this).tab('show')
})
</script>
</html>
