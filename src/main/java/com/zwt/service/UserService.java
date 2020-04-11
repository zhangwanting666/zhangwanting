package com.zwt.service;

import java.util.List;

import com.zwt.entity.Roles;
import com.zwt.entity.User;
import com.zwt.entity.qx;

public interface UserService {

	public List<User> getAll(String userName, String beginDate, String endDate, String isLock, Integer limit, Integer page);

	/*
	 * ����
	 */
	public int getConut(String userName, String beginDate, String endDate, String isLock);


	/*
	 * ���
	 * */
	public int addUser(String id_a,String name_a,String pwd_a,String suo_a);
	
	/*
	 * ɾ��
	 */
 	public int deleteUser(String id);
	/*
	 * �޸�
	 */
     int updateUser(String id_e,String name_e,String pass_e,String email_e,String tel_e);
	  int suo(String id,String isLock);
		int unsuo(String id,String isLock);
		/*
		 * ��������
		 * */
		int ressetPass(String id,String Pass);
		
		/*
		 * �����û�id��ѯ��ɫ��
		 * */
		public List<qx> getLeft();
	     public List<qx> getRight(String userId);
	     
	     public int addUserRoles(String uId,String rId);
	     public int delUserRoles(String uId,String rId);
	     
	     /*	  
	 	 * ����name���û�
	 	 * ����name�޸�����¼ʱ��
	 	 */
	 	public User login(String name,String pass);
	 	public int updateLastTime(String name, String lastLoginTime);

	 	public List<Roles> getRolesByid(String uid);
	 	public List<String> getrname(List<Roles> rs);
	 
}