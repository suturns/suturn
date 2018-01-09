<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String basePath = (String)request.getAttribute("basePath");
%>
<!DOCTYPE html>
<html>
<head>
<title>存管系统</title>
<link rel="stylesheet" type="text/css" href="../../static/css/common.css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="shortcut icon" href="../../static/favicon.ico" type="image/x-icon"/>
</head>
<body>
<div class="error">
	<div class="error_404"></div>
	<div class="error_but_404">
		<a href="/index" class="error_a1_404">返回首页</a>
		<a href="#" onclick="goBack();" class="error_a2_404">返回上一页</a>
	</div>
</div>
</body>
</html>
<script>
	console.log(<%=basePath%>);
function goBack(){
    if ((navigator.userAgent.indexOf('MSIE') >= 0) && (navigator.userAgent.indexOf('Opera') < 0)){ // IE
        if(history.length > 0){
            window.history.go( -1 );
        }else{
            window.opener=null;window.close();
        }
    }else{ //非IE浏览器
        if (navigator.userAgent.indexOf('Firefox') >= 0 ||
            navigator.userAgent.indexOf('Opera') >= 0 ||
            navigator.userAgent.indexOf('Safari') >= 0 ||
            navigator.userAgent.indexOf('Chrome') >= 0 ||
            navigator.userAgent.indexOf('WebKit') >= 0){

            if(window.history.length > 1){
                window.history.go( -1 );
            }else{
                window.opener=null;window.close();
            }
        }else{ //未知的浏览器
            window.history.go( -1 );
        }
    }
}
</script>