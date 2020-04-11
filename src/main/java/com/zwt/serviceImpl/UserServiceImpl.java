package com.zwt.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zwt.entity.Roles;
import com.zwt.entity.User;
import com.zwt.entity.qx;
import com.zwt.mapper.UserMapper;
import com.zwt.service.UserService;
@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Resource(name="userMapper")
	private UserMapper userMapper;
	
		public List<User> getAll(String userName, String beginDate, String endDate, String isLock, Integer limit,
				Integer page) {
			// TODO Auto-generated method stub
			return userMapper.selectAll(userName,beginDate, endDate, isLock,limit, page);
		}
		
		public int getConut(String userName, String beginDate, String endDate, String isLock) {
			// TODO Auto-generated method stub
			return userMapper.getConut(userName, beginDate, endDate, isLock);
		}
	/*
	 * Ìí¼Ó
	 * */
		public int addUser(String id_a,String name_a,String pwd_a,String suo_a ) {
			// TODO Auto-generated method stub
			return userMapper.add(id_a, name_a, pwd_a, suo_a);
		}

	/*
	 * É¾³ý
	 * */
		public int deleteUser(String id) {
			// TODO Auto-generated method stub
			return userMapper.delete(id);
		}
	/*
	 * ÐÞ¸Ä
	 * */
	public int updateUser(String id_e, String name_e, String pass_e, String email_e, String tel_e) {
		// TODO Auto-generated method stub
		return userMapper.update(id_e, name_e, pass_e, email_e, tel_e);
	}

	public int suo(String id, String isLock) {
		// TODO Auto-generated method stub
		return userMapper.suo(id, isLock);
	}

	public int unsuo(String id, String isLock) {
		// TODO Auto-generated method stub
		return userMapper.unsuo(id, isLock);
	}

	public int ressetPass(String id, String Pass) {
		// TODO Auto-generated method stub
		return userMapper.ressetPass(id, Pass);
	}

	/*
	 * yh²éjuese
	 * */
	public List<qx> getLeft() {
		// TODO Auto-generated method stub
		return userMapper.getLeft();
	}

	public List<qx> getRight(String userId) {
		// TODO Auto-generated method stub
		return userMapper.getRight(userId);
	}

	public int addUserRoles(String uId, String rId) {
		// TODO Auto-generated method stub
		return userMapper.addUserRoles(uId, rId);
	}

	public int delUserRoles(String uId, String rId) {
		// TODO Auto-generated method stub
		return userMapper.delUserRole(uId, rId);
	}

	/*
	 * µÇÂ¼
	 * */
	public User login(String name, String pass) {
		// TODO Auto-generated method stub
		return userMapper.login(name, pass);
	}

	public int updateLastTime(String name, String lastLoginTime) {
		// TODO Auto-generated method stub
		return userMapper.updateLastTime(name, lastLoginTime);
	}

	public List<Roles> getRolesByid(String uid) {
		// TODO Auto-generated method stub
		return userMapper.getRolesByUserid(uid);
	}

	public List<String> getrname(List<Roles> rs) {
		// TODO Auto-generated method stub
		List<String> ls=new ArrayList<String>();
		for (int i = 0; i < rs.size(); i++) {
			ls.add(rs.get(i).getName());
		}
		return ls;
	}


	

	

}
