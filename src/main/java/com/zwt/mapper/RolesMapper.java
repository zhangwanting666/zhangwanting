package com.zwt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zwt.entity.Modules;
import com.zwt.entity.Roles;
import com.zwt.entity.qx;

public interface RolesMapper {

	
	/*
	 * 查询
	 * */
	List<Roles> selectAllRoles(@Param("Name") String Name, @Param("limit") Integer limit, @Param("page") Integer page);
	
	/*
	 * 页数
	 * */
	int getCountRoles(@Param("Name") String Name);
	
	/*
	 * 添加
	 */
	public int add(@Param("id") String id_a,@Param("name") String name_a);

	/*
	 * 删除
	 */
	public int deleteRoles(@Param("id")String id);
	/*
	 * 修改
	 */
	public int update(@Param("id")String id,@Param("name")String name);
	
	 /*
     * 角色权限增删改查
     * */
    public List<qx> getLeft();
    public List<qx> getRight(@Param("roleId")String roleId);
    
    public int addrolesmodules(@Param("mid")Integer mId,@Param("rid")String rId);
    public int delrolesmodules(@Param("mid")Integer mId,@Param("rid")String rId);
}
