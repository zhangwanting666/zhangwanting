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
				laydate.render({
					elem : "#beginDate",
					type:"date"
				});

				laydate.render({
					elem : "#endDate",
					type:"date"
				});

				table.render({
					elem : '#tab',
					"method" : "post",
					url : 'getAll',
					id:'idTest',
					page : true, //是否开启分页
					cols : [ [ {
						type : 'checkbox',
						fixed : 'left'
							
					}, {
						field : 'id',
						title : '编号',
						align : 'center',
						width:120
					}, {
						field : 'loginName',
						title : '用户名',
						align : 'center',
						width:100

					},{
							field : 'password',
							title : '密码',
							align : 'center',
							width:100

					}, {
						field : 'isLockout',
						title : '是否锁定',
						align : 'center',
							width:100

					}, {
						field : 'lastLoginTime',
						title : '上次登录',
						width:100,
						align : 'center',templet : function(r) {
							return util.toDateString(r.LastLoginTime, "yyyy-MM-dd")
						}

					}, {
						field : 'createTime',
						title : '创建时间',
						width:100,
						align : 'center',templet : function(r) {
							return util.toDateString(r.CreateTime, "yyyy-MM-dd")
						}

					}, {
						field : 'psdWrongTime',
						title : '密码错误次数',
						align : 'center',
							width:100

					}, {
						field : 'lockTime ',
						title : '用户锁定时间 ',
						align : 'center',
							width:100

					}, {
						field : 'protectEMail',
						title : '邮箱',
						align : 'center',
						width:100

					}, {
						field : 'protectMTel',
						title : '手机',
						align : 'center',
						width:100
						

					},  {
						title : '操作',
						align : 'center',
						toolbar : "#barDemo"
					,width:350
							
					} ] ],
					"toolbar" : "#toolbarDemo"
				});
/* 查询*/
				 form.on('submit(search)', function(data){
					  table.reload('idTest',{
						  where:data.field 
						});
					  return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
					});
			
			//添加
			  table.on('toolbar(test)', function(obj) {
                var checkStatus = table.checkStatus(obj.config.id);
                switch(obj.event) {
                  case 'add':
                    layer.open({
                      type: 1,
                      title:"添加",
                      shadeClose: true,
                      area: ['500px', '500px'],
                      content: $("#add") //这里content是一个普通的String
                    });
                    form.on('submit(addtj)', function(data) {
                        $.post("http://localhost:8080/testmaven/addUser", data.field, function(r) {
                            if(r.code = "0") {
                            table.reload('idTest');
                              layer.closeAll(); //疯狂模式，关闭所有层}
                                           }
                            }, "json");
                          return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
                        });

                    };
                });
					
					
				//删除
			 table.on('tool(test)', function(obj){
					  var data = obj.data; //获得当前行数据
					  var layEvent = obj.event;
					  var tr = obj.tr; 
					 if(layEvent === 'del'){ //删除
					    layer.confirm('确定删除么？', function(index){
					      $.post("http://localhost:8080/testmaven/deleteUser",{
					    	  "Id":data.id
					    	  },function(r){ 
					    		  if(r.code=="0"){
					    				 table.reload('idTest');
						    		  layer.closeAll(); //疯狂模式，关闭所有层
					    		  }
					    		 
					      },"json");
					    });
					  } 
					});
				
});
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
				<input type="text" name="userName" placeholder="请输入用户名:"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label">起止时间</label>
			<div class="layui-input-inline" style="width: 100px;">
				<input type="text" name="beginDate" id="beginDate"
					placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
			</div>
			<div class="layui-form-mid">-</div>
			<div class="layui-input-inline" style="width: 100px;">
				<input type="text" name="endDate" id="endDate"
					placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label">是否锁定</label>
			<div class="layui-input-inline" style="width: 100px;">
				<select name="isLock" lay-verify="">
					<option value="">--请选择--</option>
					<option value="是">是</option>
					<option value="否">否</option>
				</select>
			</div>
		</div>
		<div class="layui-inline">
			<button class="layui-btn layui-btn-radius layui-btn-normal"
				lay-submit lay-filter="search">查询</button>
		</div>
	</form>
	
<!-- 添加 -->
 <div id="add" style="display: none;">
	<form method="post" class="layui-form">
  <div>
         <label class="layui-form-label">ID:</label>
     <div class="layui-input-inline" style="width: 100px;">
      <input type="text" name="id" placeholder="id" autocomplete="off" class="layui-input">
  </div>
 </div>
  <div>
         <label class="layui-form-label">用户名:</label>
    <div class="layui-input-inline" style="width: 100px;">
      <input type="text" name="LoginName" placeholder="用户名" autocomplete="off" class="layui-input">
  </div>
 </div>
  <div>
         <label class="layui-form-label">密码:</label>
     <div class="layui-input-inline" style="width: 100px;">
      <input type="text" name="Password" placeholder="密码" autocomplete="off" class="layui-input">
  </div>
 </div>
 <div>
         <label class="layui-form-label">是否锁定:</label>
    <div class="layui-input-inline" style="width: 100px;">
     <select name="IsLockout" lay-verify="">
      <option value=" ">--请选择--</option>
       <option value="是">是</option>
       <option value="否">否</option>  
     </select>
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