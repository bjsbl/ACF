(function(){
	var preurl = "";
	var ip = "";
	var port = "";
	var driver = "";
	$(".dbType").change(function(){
		var dbtype = $(this).children('option:selected').val();
		if(dbtype=="mysql"){
			preurl = "jdbc://mysql//";
			driver = "com.mysql.jdbc.Driver";
		}else if(dbtype=="oracle"){
			preurl = "jdbc:oracle:thin:@";
			driver = "oracle.jdbc.driver.OracleDriver";
		}else{
			preurl = "";
			driver = "";
		}
		$(".className").val(driver);
		$(".url").val(preurl+ip+port);
	})
	$(".server").change(function(){
		ip = $(this).val();
		$(".url").val(preurl+ip+port);
	})
	$(".port").change(function(){
		port = $(this).val();
		$(".url").val(preurl+ip+port);
	})
})()