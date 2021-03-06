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
		<title>home</title>
		
<style type="text/css">
.ztree * {font-size: 10pt;font-family:"Microsoft Yahei",Verdana,Simsun,"Segoe UI Web Light","Segoe UI Light","Segoe UI Web Regular","Segoe UI","Segoe UI Symbol","Helvetica Neue",Arial}
.ztree li ul{ margin:0; padding:0}
.ztree li {line-height:30px;}
.ztree li a {width:200px;height:30px;padding-top: 0px;}
.ztree li a:hover {text-decoration:none; background-color: #E7E7E7;}
.ztree li a span.button.switch {visibility:hidden}
.ztree.showIcon li a span.button.switch {visibility:visible}
.ztree li a.curSelectedNode {background-color:#D4D4D4;border:0;height:30px;}
.ztree li span {line-height:30px;}
.ztree li span.button {margin-top: -7px;}
.ztree li span.button.switch {width: 16px;height: 16px;}

.ztree li a.level0 span {font-size: 150%;font-weight: bold;}
.ztree li span.button {background-image:url("${baseurl}/images/left_menuForOutLook.png"); *background-image:url("${baseurl}/images/left_menuForOutLook.gif")}
.ztree li span.button.switch.level0 {width: 20px; height:20px}
.ztree li span.button.switch.level1 {width: 20px; height:20px}
.ztree li span.button.noline_open {background-position: 0 0;}
.ztree li span.button.noline_close {background-position: -18px 0;}
.ztree li span.button.noline_open.level0 {background-position: 0 -18px;}
.ztree li span.button.noline_close.level0 {background-position: -18px -18px;}

a{
	text-decoration: none;
}
</style>

<script type="text/javascript">
var curMenu = null, zTree_Menu = null;
var setting = {
	view: {
		showLine: false,
		showIcon: false,
		selectedMulti: false,
		dblClickExpand: false,
		addDiyDom: addDiyDom
	},
	data: {
		simpleData: {
			enable: true
		}
	},
	callback: {
		onClick: onClick,
		beforeClick: beforeClick
	},
	edit:{
		/* 手动触发url，禁止框架触发 */
		enable: true
	}
};

function addDiyDom(treeId, treeNode) {
	var spaceWidth = 5;
	var switchObj = $("#" + treeNode.tId + "_switch"),
	icoObj = $("#" + treeNode.tId + "_ico");
	switchObj.remove();
	icoObj.before(switchObj);

	if (treeNode.level > 1) {
		var spaceStr = "<span style='display: inline-block;width:" + (spaceWidth * treeNode.level)+ "px'></span>";
		switchObj.before(spaceStr);
	}
}
/* 菜单点击 */
function onClick(event, treeId, treeNode) {
    addTab(treeNode.name, treeNode.url);
}
/* 添加tab页 */
function addTab(title, url){
	if ($('.easyui-tabs').tabs('exists', title)){
		$('.easyui-tabs').tabs('select', title);
	} else {
		var content = '<iframe scrolling="auto" frameborder="0"  src="${baseurl}'+url+'" style="width:100%;height:100%;"></iframe>';
		$('.easyui-tabs').tabs('add',{
			title:title,
			content:content,
			closable:true
		});
	}
}

function beforeClick(treeId, treeNode) {
	if (treeNode.level == 0 ) {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		zTree.expandNode(treeNode);
		return false;
	}
	return true;
}

$(document).ready(function(){
	var zNodes = ${activeUser.menus};
	var treeObj = $("#treeDemo");
	$.fn.zTree.init(treeObj, setting, zNodes);
	zTree_Menu = $.fn.zTree.getZTreeObj("treeDemo");
	var nodes = zTree_Menu.getNodes();
	for(var i=0; i<nodes.length; i++){
		zTree_Menu.expandNode(nodes[i],true,true,true);
	}
	/* curMenu = zTree_Menu.getNodes()[0].children[0].children[0];
	zTree_Menu.selectNode(curMenu);

	treeObj.hover(function () {
		if (!treeObj.hasClass("showIcon")) {
			treeObj.addClass("showIcon");
		}
	}, function() {
		treeObj.removeClass("showIcon");
	}); */
});
</script>
	</head>
	<body class="easyui-layout">
		<div region="north" style="height:55px">
			<span style="padding-right: 20px; float: right;">
			欢迎当前用户：${activeUser.username}&nbsp;&nbsp;
			&nbsp;&nbsp;
			<a title='修改密码' href='${baseurl}/user/updatepwd'id="modifypwd" >修改密码</a>
			&nbsp;&nbsp;
			<a id="loginout" href="${baseurl}/logout">退出系统</a>
			</span> 
			<span style="padding-left: 10px; font-size: 16px;">
			<img align="absmiddle" src="${baseurl}/images/zsc.png" width="80" height="40"/>
			<font color="#0081C2" size="4">江苏掌仓系统</font>
			</span> 
		</div>
		<div region="south" style="background: rgb(210, 224, 242); height: 30px;" split="false">
			<div align="center">
				@2018 使用江苏掌仓系统前必读 | 
				<a href="http://www.baidu.com" target="view_window">帮助</a>
			</div>			
		</div>
		
		<div region="west" title="导航菜单" style="width:240px;">
			<ul id="treeDemo" class="ztree"></ul>
		</div>
		<div region="center">
			<div id="tt" class="easyui-tabs" data-options="fit:true,border:false,plain:true">
				<div title="欢迎使用" data-options="href:'${baseurl }/welcome.jsp'" style="padding:10px" ></div>
			</div>
		</div>
			
	</body>
</html>