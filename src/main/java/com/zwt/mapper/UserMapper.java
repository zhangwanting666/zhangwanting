package com.zwt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameters;

import com.zwt.entity.Roles;
import com.zwt.entity.User;
import com.zwt.entity.qx;

public interface UserMapper {

	/*
	 * cha
	 */

	List<User> selectAll(@Param("userName") String userName, @Param("beginDate") String beginDate,
			@Param("endDate") String endDate, @Param("isLock") String isLock, @Param("limit") Integer limit,
			@Param("page") Integer page);

	/*
	 * ����
	 */
	int getConut(@Param("userName") String userName, @Param("beginDate") String beginDate,
			@Param("endDate") String endDate, @Param("isLock") String isLock);

	/*
	 * ���
	 */
	public int add(@Param("id") String id_a,@Param("name") String name_a,@Param("pwd") String pwd_a,@Param("suo")String suo_a);

	/*
	 * ɾ��
	 */
	public int delete(@Param("id")String id);
	/*
	 * �޸�
	 */
	int update(@Param("id_e")String id_e,@Param("name_e")String name_e,@Param("pass_e")String pass_e,@Param("email_e")String email_e,@Param("tel_e")String tel_e);
	/*
	 * ����
	 * */
	int suo(@Param("id")String id,@Param("onsuo")String isLock);
	/*
	 * ����
	 * */
	int unsuo(@Param("id")String id,@Param("unsuo")String isLock);
	/*
	 * ��������
	 * */
	int ressetPass(@Param("id")String id,@Param("Pass")String Pass);
	
	
	/*
	 * �û���ɫ��ɾ�Ĳ�
	 * */
	public List<qx> getLeft();
	public List<qx> getRight(@Param("userId")String userId);

	
	@Insert("insert into userroles values(uuid(),#{rid},#{uid})")
	public int addUserRoles(@Param("uid")String uId, @Param("rid")String rId);
	public int delUserRole(@Param("uid")String uId, @Param("rid")String rId);
	
	/*
	 * ��¼
	 */
	public User login(@Param("name")String name,@Param("pass")String pass);
	public int updateLastTime(@Param("name")String name,@Param("lastLoginTime") String lastLoginTime);

	List<Roles> getRolesByUserid(@Param("uid")String uid);
	
}
