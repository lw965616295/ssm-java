<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/tag.jsp"%>
<%@ include file="/WEB-INF/jsp/common/css.jsp"%>
<%@ include file="/WEB-INF/jsp/common/js.jsp"%>
<html>
<head>
    <title>权限资源信息</title>
    <meta charset="utf-8">

</head>
<script type="text/javascript">
	$(function(){
		
	});
	/* 重置功能 */
	function reset(){
  	   $("#queryStr").val("");
    }
	/* 查询功能 */
    function query(){
    	var select = $("#select").val();
    	var queryStr = $("#queryStr").val();
    	var data = {};
    	data[select] = queryStr;
    	$("#dg").datagrid("load",data);
    }
	/* 回车查询 */
    document.onkeydown=function(event){
        if(event.keyCode==13){ 
        	query();
        }
    };
    /* 状态格式化 */
    function statusFor(val, row, index){
    	if(val == 0){
    		return "<label style='color:red'>禁用</label>"
    	}else if(val == 1){
    		return "<label style='color:green'>启用</label>"
    	}
    }
    /* 新增 */
    function add(){
    	$("#dlg").dialog("open").dialog("setTitle","新增");
    }
    /* 作废 */
    function del(){
    	var row = $("#dg").datagrid("getSelected");
    	if(row == null){
    		alert("请选择一行数据！");
    	}else{
	    	$.ajax({
	    		url: "${baseurl}/perm/delete",
	    		type: "post",
	    		data: {
	    			id: row.id,
	    			status: "0"
	    		},
	    		success: function(data){
	    			var code = JSON.parse(data).code;
	    			if(code == 1){
	    				$.messager.show({
	        				title: "msg",
	        				msg: "操作成功！",
	        				timeout: 2000
	        			});
	    				$("#dg").datagrid("reload");
	    			}else if(code == 0){
	    				$.messager.alert({
	        				title: "msg",
	        				msg: "操作失败！"+JSON.parse(data).msg
	        			});
	    			}
	    		}
	    	});
    	}
    }
    /* 编辑 */
    function update(){
    	var row = $("#dg").datagrid("getSelected");
    	if(row == null){
    		alert("请选择一行数据！");
    	}else{
	    	$("#dlg").dialog("open").dialog("setTitle", "编辑");
	    	$("#fm").form("load", row);
    	}
    }
    /* 保存 */
    function save(){
    	var title = $("#dlg").panel('options').title;
    	var url;
    	if(title == "新增"){
    		url = "${baseurl}/perm/save";
    	}else if(title == "编辑"){
    		url = "${baseurl}/perm/update";
    	}
    	$("#fm").form("submit",{
    		url: url,
    		onSubmit: function(){
    			return $(this).form('validate');
    		},
    		success: function(data){
    			var code = JSON.parse(data).code;
    			if(code == 1){
    				$.messager.show({
        				title: "msg",
        				msg: "操作成功！",
        				timeout: 1000
        			});
    				$("#dlg").dialog("close");
    				$("#dg").datagrid("reload");
    			}else if(code == 0){
    				$.messager.alert({
        				title: "msg",
        				msg: "操作失败！"+JSON.parse(data).msg
        			});
    			}
    			
    			
    		}
    	});
    }
    
</script>
<body>
<div id="searchPanel" class="easyui-panel" style="padding:3px;width:100%" title="查询窗口" iconCls="icon-search" collapsible="true"
     closable="false">
    <table id="searchTable">
        <tr>
            <td>
                <select id="select" label="搜索选项：" class="easyui-combobox" style="width:200px"  panelHeight="auto">
                	<option value="name">资源名称</option>
                	<option value="type">资源类型</option>
                </select>
            </td>
            <td>
                <input type="text" id="queryStr" style="width:200px;" class="easyui-textbox" prompt="查询字符" />
            </td>
            
            <td style="width:80px">&nbsp;</td>
            <td>
                <a onclick="query()" class="easyui-linkbutton" iconCls="icon-search" id="searchBtn">查询</a>&nbsp;
                <a onclick="reset()" class="easyui-linkbutton" iconCls="icon-redo" id="resetBtn">重置</a>
            </td>
        </tr>
    </table>
</div>

<!-- 数据显示table -->
    <table id="dg" title="列表窗口" class="easyui-datagrid" iconCls="icon-more" style="width:100%;height:90%"
            url="${baseurl }/perm/query" method="post" checkOnSelect="checked"
            toolbar="#toolbar" pagination="true" remoteSort="false" collapsible="true"
            rownumbers="true" fitColumns="false" singleSelect="true">

        <thead>
            <tr>
                <th field="id" width="150" sortable="true">ID</th>
                <th field="name" width="150" sortable="true">名称</th>
                <th field="type" width="150">类型</th>
                <th field="url" width="150">url</th>
                <th field="percode" width="150">权限码</th>
                <th field="pId" width="150">直接父id</th>
                <th field="pids" width="150">所有pId</th>
                <th field="sortstr" width="150">排序字段</th>
                <th field="status" width="150" formatter="statusFor">状态</th>
            </tr>
        </thead>
        
    </table>
    
    <!-- 工具栏 -->
    <div id="toolbar">
    	<shiro:hasPermission name="perm:add">
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add()">增加</a>
	    </shiro:hasPermission>
	    <shiro:hasPermission name="perm:update">
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="update()">编辑</a>
	    </shiro:hasPermission>
	    <shiro:hasPermission name="perm:delete">
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del()">禁用</a>
        </shiro:hasPermission>
    </div>
    
    <!-- 操作dialog -->
    <div id="dlg" class="easyui-dialog" style="width:400px" data-options="closed:true,modal:true,border:'thin',buttons:'#dlg-buttons'">
        <form id="fm" method="post" style="margin:0;padding:20px 50px">
            <div style="margin-bottom:10px">
                <input name="id" class="easyui-textbox" required="true" label="id：" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="name" class="easyui-textbox" required="true" label="名称：" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="type" class="easyui-textbox" required="true" label="类型：" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="url" class="easyui-textbox" label="url：" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="percode" class="easyui-textbox" label="权限码：" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="pId" class="easyui-textbox" label="直接父id：" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="pids" class="easyui-textbox" label="所有父id：" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="sortstr" class="easyui-textbox" label="排序字段：" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
            	<select name="status" class="easyui-combobox" editable="false" label="状态：" style="width:200px"  panelHeight="auto">
					<option value="1">启用</option>
					<option value="0">禁用</option>
				</select>
			</div>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="save()" style="width:90px">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
    </div>
    
</body>
</html>
