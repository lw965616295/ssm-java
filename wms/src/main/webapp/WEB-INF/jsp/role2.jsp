<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/tag.jsp"%>
<%@ include file="/WEB-INF/jsp/common/css.jsp"%>
<%@ include file="/WEB-INF/jsp/common/js.jsp"%>
<html>
<head>
    <title>角色信息</title>
    <meta charset="utf-8">

</head>
<script type="text/javascript">
var setting = {
		check: {
			enable: true
		},
		data: {
			simpleData: {
				enable: true
			}
		},
		callback: {
			onClick: function(event, treeId, treeNode) {
				//点击触发勾选checkbox
			    console.log(treeNode.tId + ", " + treeNode.name+","+treeNode.id);
			    
			    var ztree = $.fn.zTree.getZTreeObj("permTree");
			    if(treeNode.checked){
				    ztree.checkNode(treeNode, false, true);
			    }else{
			    	ztree.checkNode(treeNode, true, true);
			    }
			},
			onCheck: function (event, treeId, treeNode) {
				console.log(treeNode.tId + ", " + treeNode.name + "," + treeNode.checked);
			}
		},
		edit:{
			/*禁止框架触发url */
			enable: true,
			showRemoveBtn: false,
			showRenameBtn: false,
		}
	};
	$(function(){
		$.ajax({
			url: "${baseurl}/role/getAllPerms",
			type: "post",
			success: function(data){
				var zNodes = JSON.parse(data).rows;
				$.fn.zTree.init($("#permTree"), setting, zNodes);
				var ztree = $.fn.zTree.getZTreeObj("permTree");
				//获取所有节点
	            var nodes = ztree.transformToArray(ztree.getNodes());
	            console.log("nodes.length:"+nodes.length)
	            for (var i = 0; i < nodes.length; i++) { //设置节点展开
	            	ztree.expandNode(nodes[i], true, false, true);
	            }
	            ztree.checkNode(nodes[1], true, true);
			}
		});
	});
	
</script>
<body>
    <!-- 操作dialog -->
    <div id="dlg" class="easyui-dialog" style="width:400px" data-options="modal:true,border:'thin',buttons:'#dlg-buttons'">
        <ul id="permTree" class="ztree"></ul>
    </div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="save()" style="width:90px">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
    </div>
    
    
</body>
</html>
