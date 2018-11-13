<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/tag.jsp"%>
<%@ include file="/WEB-INF/jsp/common/css.jsp"%>
<%@ include file="/WEB-INF/jsp/common/js.jsp"%>
<html>
<head>
    <title></title>
    <meta charset="utf-8">
	<script type="text/javascript">
        var url;
        function newUser(){
            $('#dlg').dialog('open').dialog('center').dialog('setTitle','新增用户');
            $('#fm').form('clear');
            url = 'save_user.php';
        }
        function editUser(){
        	$('#fm').form('clear');
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $('#dlg').dialog('open').dialog('center').dialog('setTitle','编辑用户');
                $('#fm').form('load',row);
                url = '${baseurl }/user/addUser'+row.id;
            }
        }
        function saveUser(){
        	var fm = $("#fm").serializeArray();
        	var url;
        	if(fm[0].value != null && fm[0].value != ""){
        		url = "${baseurl }/user/editorUser";
        	}else{
        		url = "${baseurl }/user/addUser";
        	}
			$('#fm').form('submit',{
				url: url,
				onSubmit: function(){
					return $(this).form('validate');
				},
				success: function(result){
					$.messager.show({
						title: '提交成功',
						msg: result
					});
					$('#dlg').dialog('close');        // close the dialog
					$('#dg').datagrid('reload');    // reload the user data
					/* var result = eval('('+result+')');
					if (result.errorMsg){
						$.messager.show({
							title: '操作失败',
							msg: result
						});
					} else {
						$('#dlg').dialog('close');        // close the dialog
						$('#dg').datagrid('reload');    // reload the user data
					} */
				},
				error: function(result){
					$.messager.show({
						title: '请求失败',
						msg: '请求出错'
					});
				}
			});
		}
        function destroyUser(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $.messager.confirm('Confirm','确定禁用此用户吗',function(r){
                    if (r){
                        $.post('destroy_user.php',{id:row.id},function(result){
                            if (result.success){
                                $('#dg').datagrid('reload');    // reload the user data
                            } else {
                                $.messager.show({    // show error message
                                    title: 'Error',
                                    msg: result.errorMsg
                                });
                            }
                        },'json');
                    }
                });
            }
        }
        
	function reset(){
		var x = $("#searchTable input").val("");
		search1();
	}
	
	function search1(){
		var data = {};
		key = $("#opt").val();
		value = $("#val").val();
		data[key] = value;
		$.ajax({
			url: "${baseurl }/user/getUsers",
			data:data,
			dataType: "json",
			type:"post",
			success:function(data){
				 var list = data.rows;
				 $("#dg").datagrid("loadData", data.rows);
			},
			error:function(){
				$.messager.show({    // show error message
                    title: 'Error',
                    msg: "请求出错"
                });
			}
		})
		/* $("#dg").attr("url","${baseurl }/user/getUsers?page=1&rows=10&userId="+userId+"&userName="+userName);
		$("#dg").reload; */
	}
	//格式化时间
	function dateFormatter(value,row,index){
		return timestampToTime(value);
	}
	//渲染状态
	function delFormatter(value,row,index){
		if(value==0){
			var html = "<label style='color:green;'>启用</label>"
			return html;
		}else{
			var html = "<label style='color:red;'>禁用</label>"
			return html;
		}
	}
	function timestampToTime(timestamp) {
        var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
        var Y = date.getFullYear() + '-';
        var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
        var D = date.getDate() + ' ';
        var h = date.getHours() +':';
        var m = date.getMinutes();
        return Y+M+D+h+m;
    }
	
	$(function(){
		//绑定仓库下拉框
		$.ajax({
			url: "${baseurl }/warehouse/getWh",
			type: "post",
			success:function(data){
				var list = JSON.parse(data);
				$('#whCode').combobox({
					data: list.rows,
					valueField: 'whCode',
					textField: 'whName'}
				);
			},
			error:function(){
				$.messager.show({    // show error message
                    title: 'Error',
                    msg: "仓库下拉框请求失败"
                });
			}
		});
		
		//绑定货主下拉框
		$.ajax({
			url: "${baseurl }/consignor/getCons",
			type: "post",
			success:function(data){
				var list = JSON.parse(data);
				$('#theOwner').combobox({
					data: list.rows,
					valueField: 'consignorCode',
					textField: 'consignorName'}
				);
			},
			error:function(){
				$.messager.show({    // show error message
                    title: 'Error',
                    msg: "货主下拉框请求失败"
                });
			}
		});
		
		$("#dg").datagrid({  
	        onRowContextMenu: function (e, rowIndex, rowData) { //右键时触发事件  
	            //三个参数：e里面的内容很多，真心不明白，rowIndex就是当前点击时所在行的索引，rowData当前行的数据  
	            e.preventDefault(); //阻止浏览器捕获右键事件  
	            $(this).datagrid("clearSelections"); //取消所有选中项  
	            $(this).datagrid("selectRow", rowIndex); //根据索引选中该行  
	            $('#mm').menu('show', {  
	                //显示右键菜单  
	                left: e.pageX,//在鼠标点击处显示菜单  
	                top: e.pageY  
	            });  
	            e.preventDefault();  //阻止浏览器自带的右键菜单弹出  
	        }  
	    });
	})
	
	/* $("#del").append("<option value='0' selected='selected'>启用</option>");
	$("#del").append("<option value='1'>禁用</option>"); */
	/* $("#dg").datagrid({  
        onRowContextMenu: function (e, rowIndex, rowData) { //右键时触发事件  
            //三个参数：e里面的内容很多，真心不明白，rowIndex就是当前点击时所在行的索引，rowData当前行的数据  
            e.preventDefault(); //阻止浏览器捕获右键事件  
            $(this).datagrid("clearSelections"); //取消所有选中项  
            $(this).datagrid("selectRow", rowIndex); //根据索引选中该行  
            $('#menu').menu('show', {  
                //显示右键菜单  
                left: e.pageX,//在鼠标点击处显示菜单  
                top: e.pageY  
            });  
            e.preventDefault();  //阻止浏览器自带的右键菜单弹出  
        }  
    }); */
    </script>
    <style type="text/css">
    	.datagrid-cell-check{
    		vertical-align:middle
    	}
    </style>
</head>
<body>
<!-- 查询 -->
<div id="searchPanel" class="easyui-panel" style="padding:3px;" title="查询窗口" iconCls="icon-search" collapsible="true"
     closable="false">
    <table id="searchTable">
        <tr>
            <td>搜索选项：</td>
            <td style="width:120px;">
                <!-- <input type="text" name="userId" id="userId" style="width:100px;"/> -->
                <select id="opt" style="width: 100px;height: 20px">
                	<option value="userName">用户名</option>
                	<option value="phone">手机号</option>
                	<option value="whCode">仓库</option>
                	<option value="theOwner">货主</option>
                </select>
            </td>
            <td style="width:120px;">
                <input type="text" name="userName" id="val" style="width:100px;"/>
            </td>
            <!-- <td>单据日期：</td>
            <td>
               <input type="text" name="searchBeginTime" id="searchBeginTime"
                       onClick="WdatePicker()" style="width:100px;"/>
            </td>
            <td>-</td>
            <td>
                <input type="text" name="searchEndTime" id="searchEndTime" onClick="WdatePicker()"
                       style="width:100px;"/>
            </td> -->
            <td>&nbsp;</td>
            <td>
                <a onclick="search1()" class="easyui-linkbutton" iconCls="icon-search" id="searchBtn">查询</a>&nbsp;
                <a onclick="reset()" class="easyui-linkbutton" iconCls="icon-redo" id="resetBtn">重置</a>
            </td>
        </tr>
    </table>
</div>

<!-- 数据显示table -->
    <table id="dg" title="列表窗口" class="easyui-datagrid" iconCls="icon-more"
            url="${baseurl }/user/query" method="post" checkOnSelect="checked"
            toolbar="#toolbar" pagination="true" remoteSort="false"
            rownumbers="true" fitColumns="false" singleSelect="true"
             >
             <!-- data-options="onRowContextMenu: function (e, rowIndex, rowData) {$('#mm').menu('show', { left: e.pageX, top: e.pageY }); e.preventDefault();}" -->
            
        <thead frozen="true">
        	<tr>
        		<th field="ck" checkbox="true"></th>
        		<th field="userId" width="100" sortable="true">编号</th>
        	</tr>
        </thead>
        <thead>
            <tr>
                
                <th field="userName" width="150" sortable="true">姓名</th>
                <th field="passWord" width="150" sortable="true">密码</th>
                <th field="phone" width="150">手机号</th>
                <th field="email" width="150">邮箱</th>
                <th field="whCode" width="150">仓库编码</th>
                <th field="theOwner" width="150">货主</th>
                <th field="loginTime" width="150">登录时间</th>
                <th field="createTime" width="150" formatter="dateFormatter">注册时间</th>
                <th field="modiTime" width="150" formatter="dateFormatter">修改时间</th>
                <th field="del" width="150" formatter="delFormatter">状态</th>
            </tr>
        </thead>
        
    </table>
    
	<div id="mm" class="easyui-menu" style="width:100px;display: none">
		<div iconCls="icon-shield" onclick="revoke()">授权</div>
		<div iconCls="icon-remove" onclick="destroyUser()">禁用</div>
		<div iconCls="icon-edit" onclick="editUser()">编辑</div>
		<!-- <div>
		<span>其它添加方式</span>
			<div style="width:100px;">
				<div iconCls="icon-commbook" onclick="saveToGroup()">存通讯录</div>
				<div iconCls="icon-qunzu" onclick="deptImport()">导入</div>
			</div>
		</div> -->
    </div>

    <div id="toolbar">
    	<shiro:hasPermission name="user:ad">
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">增加</a>
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">编辑</a>
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">删除</a>
        </shiro:hasPermission>
    </div>
    
    <div id="dlg" class="easyui-dialog" style="width:400px" data-options="closed:true,modal:true,border:'thin',buttons:'#dlg-buttons'">
        <form id="fm" method="post" novalidate style="margin:0;padding:20px 50px">
            <h3 align="center">用户信息</h3>
            <input name="userId" hidden="true"/>
            <div style="margin-bottom:10px">
                <input name="userName" class="easyui-textbox" required="true" label="姓名：" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="passWord" class="easyui-textbox" required="true" label="密码：" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="phone" class="easyui-textbox" required="true" label="手机号：" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="email" class="easyui-textbox" validType="email" label="邮箱：" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input id="whCode" name="whCode" class="easyui-combobox" label="仓库：" style="width:100%" data-options="panelHeight:'230'">
            </div>
            <div style="margin-bottom:10px">
                <input id="theOwner" name="theOwner" class="easyui-combobox" label="货主：" style="width:100%" data-options="panelHeight:'230'">
            </div>
            <div style="margin-bottom:10px">
            	<!-- <input id="del" name="del" class="easyui-combobox" required="true" label="停用标志：" editable="false" style="width:100%"> -->
            	
            	<input id="del" name="del" class="easyui-combobox" editable="false" required="true" label="停用标志：" style="width:100%" data-options="panelHeight:'auto',
					valueField: 'label',
					textField: 'value',
					data: [{
						label: '0',
						value: '启用'
					},{
						label: '1',
						value: '禁用'
					}]" />
			</div>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()" style="width:90px">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
    </div>
    

	
	
<!-- <div id="depotHeadDlgShow" class="easyui-dialog" style="width:1200px;padding:10px 20px;top:20px"
     closed="true" modal="true" cache="false" collapsible="false" closable="true">
    <table>
        <tr>
            <td style="width:60px;">客户：</td>
            <td style="padding:5px;width:130px;">
                <span id="OrganIdShow"></span>
            </td>
            <td style="width:70px;">销售人员：</td>
            <td style="padding:5px;width:130px;">
                <span id="SalesmanShow"></span>
            </td>
            <td style="width:80px;">单据日期：</td>
            <td style="padding:5px;width:140px;">
                <span id="OperTimeShow"></span>
            </td>
            <td style="width:70px;">单据编号：</td>
            <td style="padding:5px;width:140px;">
                <span id="NumberShow"></span>
            </td>
            <td style="width:100px;"></td>
        </tr>
        <tr>
            <td colspan="9" style="width: 1130px;">
                商品列表table
                <table id="materialDataShow" style="top:100px;border-bottom-color:#FFFFFF"></table>
            </td>
        </tr>
        <tr>
            <td style="width:60px;">单据备注：</td>
            <td colspan="8" style="height:35px;">
                <span id="RemarkShow" style="width: 1070px; height:35px;"></span>
            </td>
        </tr>
        <tr>
            <td>优惠率：</td>
            <td>
                <span id="DiscountShow" style="width: 110px;"></span>
                %
            </td>
            <td>收款优惠：</td>
            <td>
                <span id="DiscountMoneyShow" style="width: 120px;"></span>
            </td>
            <td>优惠后金额：</td>
            <td>
                <span id="DiscountLastMoneyShow" style="width: 120px;"></span>
            </td>
            <td>本次收款：</td>
            <td style="padding:5px">
                <span id="ChangeAmountShow"></span>
            </td>
            <td style="width:100px;"></td>
        </tr>
        <tr>
            <td>结算账户：</td>
            <td style="padding:5px">
                <span id="AccountIdShow"></span>
            </td>
            <td>本次欠款：</td>
            <td style="padding:5px">
                <span id="DebtShow"></span>
            </td>
            <td>销售费用：</td>
            <td style="padding:5px">
                <span id="OtherMoneyShow"></span>
            </td>
            <td>结算天数：</td>
            <td style="padding:5px">
                <span id="AccountDayShow"></span>
            </td>
            <td style="width:100px;"></td>
        </tr>
    </table>
</div>
<div id="depotHeadAccountDlg" class="easyui-dialog" style="width:380px;padding:10px 20px;top:80px"
     closed="true" modal="true" buttons="#accountDlgButtons" cache="false" collapsible="false" closable="true">
    <table class="account-dlg">
        <tr class="account-head-tmp">
            <td style="width:30px;"></td>
            <td style="width:140px; padding:5px;">结算账户</td>
            <td style="width:100px; padding:5px;">金额</td>
        </tr>
        <tr>
            <td style="width:30px;"></td>
            <td style="width:140px;text-align: center;">合计：</td>
            <td style="width:100px;"><span id="accountMoneyTotalDlg"></span></td>
        </tr>
    </table>
    <table class="tabs-tmp">
        <tr class="account-content-tmp">
            <td style="width:30px;"></td>
            <td style="width:140px; padding:3px;"><select class="account-id-dlg" style="width:140px;"></select></td>
            <td style="width:100px; padding:3px;"><input class="account-money-dlg" style="width:100px;"/></td>
        </tr>
    </table>
</div>
<div id="accountDlgButtons">
    <a href="javascript:void(0)" id="saveDepotHeadAccountDlg" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:void(0)" id="cancelDepotHeadAccountDlg" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>
<div id="otherMoneyDlg" class="easyui-dialog" style="width:380px;padding:10px 20px;top:80px"
     closed="true" modal="true" buttons="#otherMoneyDlgBtn" cache="false" collapsible="false" closable="true">
    <table class="money-dlg">
        <tr class="money-head-tmp">
            <td style="width:30px;"></td>
            <td style="width:140px; padding:5px;">结算账户</td>
            <td style="width:100px; padding:5px;">金额</td>
        </tr>
        <tr>
            <td style="width:30px;"></td>
            <td style="width:140px;text-align: center;">合计：</td>
            <td style="width:100px;"><span id="otherMoneyTotalDlg"></span></td>
        </tr>
    </table>
    <table class="tabs-tmp">
        <tr class="money-content-tmp">
            <td style="width:30px;"></td>
            <td style="width:140px; padding:3px;"><select class="money-id-dlg" style="width:140px;"></select></td>
            <td style="width:100px; padding:3px;"><input class="other-money-dlg" style="width:100px;"/></td>
        </tr>
    </table>
</div>
<div id="otherMoneyDlgBtn">
    <a href="javascript:void(0)" id="saveOtherMoneyDlg" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:void(0)" id="cancelOtherMoneyDlg" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div> -->

</body>
</html>
