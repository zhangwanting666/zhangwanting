<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="layui/css/layui.css" />
<script type="text/javascript" src="layui/layui.js"></script>
<script>
var table, form, layer, $, laydate, util;
layui.use([ 'table', 'util', 'form', 'layer', 'jquery', 'laydate' ],
		function() {
	table = layui.table;
	form = layui.form;
	layer = layui.layer;
	$ = layui.jquery;
	laydate = layui.laydate;
	util = layui.util;
	table.render({
		elem : '#tab',
		"method" : "post",
		url : 'getRoles',
		id:'idTest',
		page : true, //是否开启分页
			cols : [ [ {
				type : 'checkbox',
				fixed : 'left'
				
			}, {
				field : 'Id',
				title : '编号',
				align : 'center',
				width:100
			}, {
				field : 'Name',
				title : '用户名',
				align : 'center',
				width:100

			}, {
				field : 'Int0',
				title : 'int0',
				align : 'center',
				width:100

			}, {
				field : 'String0',
				title : 'String0',
				align : 'center',
				width:100

			}, {
				title : '操作',
				align : 'center',
				toolbar : "#barDemo"
			,width:450
					
			} ] ],
			"toolbar" : "#toolbarDemo"
		});
	
	
	
	

/* 查询*/
		 form.on('submit(ser)', function(data){
			  table.reload('idTest',{
				  where:data.field //设定异步数据接口的额外参数
				});
			  return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
			});
			
                 )};
		
			
</script>
<script type="text/html" id="toolbarDemo">
	<div class="layui-btn-container">
		<button class="layui-btn layui-btn-sm" lay-event="add">添加</button>
		<button class="layui-btn layui-btn-sm" lay-event="deletes">批量删除</button>
	</div>
</script>
<script type="text/html" id="barDemo">
	<a class="layui-btn layui-btn-xs" lay-event="block">锁定</a>
	<a class="layui-btn layui-btn-xs" lay-event="unblock">解锁</a>
	<a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
	<a class="layui-btn layui-btn-warm layui-btn-xs" lay-event="edit">编辑</a>
	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
</head>
<body>
<!-- 查询 -->
	<form method="post" class="layui-form"  >
		<div class="layui-inline">
			<label class="layui-form-label">用户名</label>
			<div class="layui-input-inline" style="width: 100px;">
				<input type="text" name="Name" placeholder="请输入用户名"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-inline">
		
			<button class="layui-btn layui-btn-radius layui-btn-normal"
				lay-submit lay-filter="ser">查询</button>
		</div>
	</form>
	
	<!-- 添加 -->
	<div id="add" style="display: none;">
	<form method="post" class="layui-form">
  <div>
         <label class="layui-form-label">Id:</label>
     <div class="layui-input-inline" style="width: 100px;">
      <input type="text" name="Id" placeholder="id" autocomplete="off" class="layui-input">
  </div>
 </div>
  <div>
         <label class="layui-form-label">用户名:</label>
    <div class="layui-input-inline" style="width: 100px;">
      <input type="text" name="Name" placeholder="用户名" autocomplete="off" class="layui-input">
  </div>
 </div>
    <div class="layui-form-lable">
       <button id="addtj" class="layui-btn layui-btn-radius layui-btn-normal"
                lay-submit lay-filter="addtj">提交</button>
    </div>
    </form>
    </div>
	
	<table class="layui-table" id="tab"  lay-filter="test"></table>

</body>
</html>