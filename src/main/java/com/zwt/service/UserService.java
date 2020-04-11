package com.zwt.service;

import java.util.List;

import com.zwt.entity.Roles;
import com.zwt.entity.User;
import com.zwt.entity.qx;

public interface UserService {

	public List<User> getAll(String userName, String beginDate, String endDate, String isLock, Integer limit, Integer page);

	/*
	 * 条数
	 */
	public int getConut(String userName, String beginDate, String endDate, String isLock);


	/*
	 * 添加
	 * */
	public int addUser(String id_a,String name_a,String pwd_a,String suo_a);
	
	/*
	 * 删除
	 */
 	public int deleteUser(String id);
	/*
	 * 修改
	 */
     int updateUser(String id_e,String name_e,String pass_e,String email_e,String tel_e);
	  int suo(String id,String isLock);
		int unsuo(String id,String isLock);
		/*
		 * 重置密码
		 * */
		int ressetPass(String id,String Pass);
		
		/*
		 * 根据用户id查询角色名
		 * */
		public List<qx> getLeft();
	     public List<qx> getRight(String userId);
	     
	     public int addUserRoles(String uId,String rId);
	     public int delUserRoles(String uId,String rId);
	     
	     /*	  
	 	 * 根据name查用户
	 	 * 根据name修改最后登录时间
	 	 */
	 	public User login(String name,String pass);
	 	public int updateLastTime(String name, String lastLoginTime);

	 	public List<Roles> getRolesByid(String uid);
	 	public List<String> getrname(List<Roles> rs);
	 
}