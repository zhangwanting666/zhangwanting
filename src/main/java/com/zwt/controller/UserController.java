package com.zwt.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zwt.entity.Roles;
import com.zwt.entity.User;
import com.zwt.entity.qx;
import com.zwt.service.UserService;
import com.zwt.util.RedisService;
import com.zwt.util.Result;
@RestController
@Transactional
public class UserController {
	
	@Resource(name="userServiceImpl")
	private UserService userServiceImpl;
	@Resource(name="redisService")
	private RedisService redisService;
	
	@RequestMapping("/go")
	public String go1() {
		return "User";
	}
	
	/*
	 * 查询
	 * */
	@RequestMapping(method = RequestMethod.POST, value ="/getAll" )
	public Map<String,Object> getAll(String userName, String beginDate, String endDate, String isLock, Integer limit,
			Integer page) {
         Map<String, Object> resultMap = new HashMap<String, Object>();
		int page1 = (page - 1) * limit;
		List<User> us = userServiceImpl.getAll(userName, beginDate, endDate, isLock, limit, page1);	
		int count = userServiceImpl.getConut(userName, beginDate, endDate, isLock);	
		resultMap.put("code", 0);
		resultMap.put("msg", "");
		resultMap.put("count",count);
		resultMap.put("data",us);
		return resultMap;
	}

	/*
	 * 添加
	 */
	@PostMapping("/addUser")
	  public String addU(String id_a,String name_a,String pwd_a,String suo_a ) {
	    int a =userServiceImpl.addUser(id_a, name_a, pwd_a, suo_a);
	    String dd=null;
	    if(a!=0) {
	     dd = Result.toClient("0","添加成功");
	    }else {
	     dd = Result.toClient("1","添加失败");  
	    }
	    return dd;
	  }
	
	/*
	 * 删除
	 */
	@RequestMapping("/deleteUser")
	public String deleteU(String id_d) {
		int a=userServiceImpl.deleteUser(id_d);
		String dd=null;
		if(a!=0) {
		 dd = Result.toClient("0","删除成功");
		}else {
		 dd = Result.toClient("1","删除失败");	
		}
		return dd;

	}

	/*
	 * 修改
	 */
	@RequestMapping("/upateUser")
	public String updateU(String id_e, String name_e, String pass_e, String email_e, String tel_e) {
		int a=userServiceImpl.updateUser(id_e, name_e, pass_e, email_e, tel_e);
		String dd=null;
		if(a!=0) {
		 dd = Result.toClient("0","修改成功");
		}else {
		 dd = Result.toClient("1","修改失败");	
		}
		return dd;
	}
	/*
	 * 上锁
	 */
	@RequestMapping("/suo")
	public String a(String id) {
		String isLock="是";
		System.out.println(id);
		int a=userServiceImpl.suo(id, isLock);
		
		String dd=null;
		if(a!=0) {
		 dd = Result.toClient("0","上锁成功");
		}else {
		 dd = Result.toClient("1","上锁失败");	
		}
		return dd;
	}
	/*
	 * 解锁
	 */
	@RequestMapping("/unsuo")
	public String b(String id) {
		String isLock="否";
		int a=userServiceImpl.unsuo(id, isLock);
		String dd=null;
		if(a!=0) {
		 dd = Result.toClient("0","解锁成功");
		}else {
		 dd = Result.toClient("1","解锁失败");	
		}
		return dd;
	}

	/*
	 * 重置密码
	 */
	@RequestMapping("/pass")
	public String c(String id) {
		String Pass="ysd123";
		int a=userServiceImpl.ressetPass(id, Pass);
		String dd=null;
		if(a!=0) {
		 dd = Result.toClient("0","重置成功");
		}else {
		 dd = Result.toClient("1","重置失败");	
		}
		return dd;
	}
	
	/*
	 *获得穿梭框zuo
	 * */
	@RequestMapping("/getUserRolesLeft")
	public List<qx> getUserRolesLeft(){
		List<qx> l = userServiceImpl.getLeft();
		return l;
		
	}
	/*
	 * 获得穿梭框you
	 * */
	@RequestMapping("/getUserRolesRightById")
	public List<qx> getUserRolesRightById(String UserId){
		List<qx> l = userServiceImpl.getRight(UserId);
		return l;
		
	}
	/*
	 * 添加用户角色
	 * */
	@RequestMapping("/addUserRoles")
	public List<Object> addUserRoles(String uId,String rId){
		userServiceImpl.addUserRoles(uId, rId);
		return null;
		
	}
	/*
	 * 用户删除角色
	 * */
	@RequestMapping("/delUserRole")
	public List<Object> delUserRole(String uId1,String rId1){
		userServiceImpl.delUserRoles(uId1, rId1);
		return null;
	}
	
	/*
	 * 登录
	 */
	@RequestMapping("/login")
	public Map<String, Object> login(String LoginName, String PassWord) {
		User u = userServiceImpl.login(LoginName, PassWord);
		Map<String, Object> resultmap = new HashMap<String, Object>();
		Map<String, Object> msgmap = new HashMap<String, Object>();
		if (u != null) {
			if (u.getPassword().equals(PassWord)) {
				// 密码正确
				if (u.getIsLockout().equals("是")) {// 密码锁定
					resultmap.put("msg", "账号被锁定,请解锁");
				} else {
					// 密码没锁定更新登录时间
					SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String LastLoginTime = dft.format(new Date());
					userServiceImpl.updateLastTime(LoginName, LastLoginTime);
					String uid = u.getId();
					List<Roles> rs = userServiceImpl.getRolesByid(uid);
					List<String> rname = userServiceImpl.getrname(rs);
					System.out.println(rname);
					msgmap.put("rname", rname);
					msgmap.put("uid", uid);
					resultmap.put("code", 0);
					resultmap.put("u", u);
					resultmap.put("msg", msgmap);
					redisService.set("dd", "ddd");
					redisService.set("rname", rname);
					redisService.set("uid", uid);
				}
			}
		} else {
			resultmap.put("code", 1);
			resultmap.put("msg", "用户或密码错误");
		}
		return resultmap;
	}
}
