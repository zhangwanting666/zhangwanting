package com.zwt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zwt.entity.Modules;
import com.zwt.entity.Roles;
import com.zwt.entity.qx;

public interface RolesMapper {

	
	/*
	 * ��ѯ
	 * */
	List<Roles> selectAllRoles(@Param("Name") String Name, @Param("limit") Integer limit, @Param("page") Integer page);
	
	/*
	 * ҳ��
	 * */
	int getCountRoles(@Param("Name") String Name);
	
	/*
	 * ���
	 */
	public int add(@Param("id") String id_a,@Param("name") String name_a);

	/*
	 * ɾ��
	 */
	public int deleteRoles(@Param("id")String id);
	/*
	 * �޸�
	 */
	public int update(@Param("id")String id,@Param("name")String name);
	
	 /*
     * ��ɫȨ����ɾ�Ĳ�
     * */
    public List<qx> getLeft();
    public List<qx> getRight(@Param("roleId")String roleId);
    
    public int addrolesmodules(@Param("mid")Integer mId,@Param("rid")String rId);
    public int delrolesmodules(@Param("mid")Integer mId,@Param("rid")String rId);
}
