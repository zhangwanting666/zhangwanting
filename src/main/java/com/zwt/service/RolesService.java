package com.zwt.service;

import java.util.List;

import com.zwt.entity.Modules;
import com.zwt.entity.Roles;
import com.zwt.entity.qx;

public interface RolesService {

	
	/*
	 * ��ѯ
	 * */
	public List<Roles> getAllModules(String Name, Integer limit, Integer page);
	/*
	 * ҳ��
	 * */
	public int getCountModules(String Name);
	
	/*
	 * ���
	 * */
	public int addRoles(String id_a,String name_a);
	
	/*
	 * ɾ��
	 */
 	public int deleteRoles(String id);
	/*
	 * �޸�
	 */
     int updateRoles(String id,String name);
	
     /*
      * ��ɫȨ����ɾ�Ĳ�
      * */
     public List<qx> getLeft();
     public List<qx> getRight(String roleId);
     
     public int addrolesmodules(Integer mId,String rId);
     public int delrolesmodules(Integer mId,String rId);
    
     
}
