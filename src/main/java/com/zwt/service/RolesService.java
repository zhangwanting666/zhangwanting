package com.zwt.service;

import java.util.List;

import com.zwt.entity.Modules;
import com.zwt.entity.Roles;
import com.zwt.entity.qx;

public interface RolesService {

	
	/*
	 * 查询
	 * */
	public List<Roles> getAllModules(String Name, Integer limit, Integer page);
	/*
	 * 页数
	 * */
	public int getCountModules(String Name);
	
	/*
	 * 添加
	 * */
	public int addRoles(String id_a,String name_a);
	
	/*
	 * 删除
	 */
 	public int deleteRoles(String id);
	/*
	 * 修改
	 */
     int updateRoles(String id,String name);
	
     /*
      * 角色权限增删改查
      * */
     public List<qx> getLeft();
     public List<qx> getRight(String roleId);
     
     public int addrolesmodules(Integer mId,String rId);
     public int delrolesmodules(Integer mId,String rId);
    
     
}
