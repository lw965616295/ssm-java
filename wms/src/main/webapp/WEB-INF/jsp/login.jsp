<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/tag.jsp"%>
<%@ include file="/WEB-INF/jsp/common/css.jsp"%>
<%@ include file="/WEB-INF/jsp/common/js.jsp"%>
<html>
	<head>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta charset="UTF-8">
		<title>login</title>
		<meta name="description" content="particles.js is a lightweight JavaScript library for creating particles.">
	    <meta name="author" content="Vincent Garreau" />
	    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
	</head>
<body>
    <div id="particles-js">
        <div class="login">
            <div class="login-top">
                	掌上仓系统登录
            </div>
            <form id="loginform" name="loginform" action="${baseurl}/login" method="post">
	            <div class="login-center clearfix">
	                <div class="login-center-img"><img src="${baseurl }/images/name.png" /></div>
	                <div class="login-center-input">
	                    <input type="text" name="username" value="" placeholder="请输入您的用户名" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的用户名'" />
	                    <div class="login-center-input-text">用户名</div>
	                </div>
	            </div>
	            <div class="login-center clearfix">
	                <div class="login-center-img"><img src="${baseurl }/images/password.png" /></div>
	                <div class="login-center-input">
	                    <input type="password" name="password" value="" placeholder="请输入您的密码" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的密码'" />
	                    <div class="login-center-input-text">密码</div>
	                </div>
	            </div>
	            <div class="login-center clearfix">
	                    <input type="checkbox" name="rememberMe" />自动登陆
	            </div>
	            <div class="login-button">
	               	 登录
				</div>
            </form>
        </div>
        <div class="sk-rotating-plane"></div>
    </div>
   
    <script type="text/javascript">
        function hasClass(elem, cls) {
            cls = cls || '';
            if (cls.replace(/\s/g, '').length == 0) return false; //当cls没有参数时，返回false
            return new RegExp(' ' + cls + ' ').test(' ' + elem.className + ' ');
        }

        function addClass(ele, cls) {
            if (!hasClass(ele, cls)) {
                ele.className = ele.className == '' ? cls : ele.className + ' ' + cls;
            }
        }

        function removeClass(ele, cls) {
            if (hasClass(ele, cls)) {
                var newClass = ' ' + ele.className.replace(/[\t\r\n]/g, '') + ' ';
                while (newClass.indexOf(' ' + cls + ' ') >= 0) {
                    newClass = newClass.replace(' ' + cls + ' ', ' ');
                }
                ele.className = newClass.replace(/^\s+|\s+$/g, '');
            }
        }
        document.querySelector(".login-button").onclick = function() {
        	$("#loginform").submit();
            
            
            
        }
        document.onkeydown=function(event){
             if(event.keyCode==13){ 
            	 //enter键登录
            	 $("#loginform").submit();
            	 
            }
        }; 
        /* 成功登录动画 */
        function anim(){
        	addClass(document.querySelector(".login"), "active")
	       	setTimeout(function() {
	                addClass(document.querySelector(".sk-rotating-plane"), "active")
	                document.querySelector(".login").style.display = "none"
	            }, 800)
	       	setTimeout(function() {
	                removeClass(document.querySelector(".login"), "active")
	                removeClass(document.querySelector(".sk-rotating-plane"), "active")
	                document.querySelector(".login").style.display = "block"
	                alert("登录成功")
	
	            }, 3000)
        }
    </script>
</body>

</html>