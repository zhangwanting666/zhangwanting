package com.zwt.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zwt.entity.Modules;
import com.zwt.entity.Roles;
import com.zwt.entity.qx;
import com.zwt.mapper.RolesMapper;
import com.zwt.service.RolesService;
@Service
public class RolesServiceImpl implements RolesService{

	@Resource(name="rolesMapper")
	private RolesMapper rolesMapper;
	
	/*
	 * 查询
	 * */
	public List<Roles> getAllModules(String Name, Integer limit, Integer page) {
		// TODO Auto-generated method stub
		return rolesMapper.selectAllRoles(Name, limit, page);
	}

	/*
	 * 页数
	 * */
	public int getCountModules(String Name) {
		// TODO Auto-generated method stub
		return rolesMapper.getCountRoles(Name);
	}

	/*
	 * 添加
	 * */
		public int addRoles(String id_a,String name_a) {
			// TODO Auto-generated method stub
			return rolesMapper.add(id_a, name_a);
		}

	/*
	 * 删除
	 * */
		public int deleteRoles(String id) {
			// TODO Auto-generated method stub
			return rolesMapper.deleteRoles(id);
		}
	/*
	 * 修改
	 * */
	public int updateRoles(String id, String name) {
		// TODO Auto-generated method stub
		return rolesMapper.update(id, name);
	}

	/*
	 * 角色权限增删改查
	 * */
	public List<qx> getLeft() {
		// TODO Auto-generated method stub
		return rolesMapper.getLeft();
	}

	public List<qx> getRight(String roleId) {
		// TODO Auto-generated method stub
		return rolesMapper.getRight(roleId);
	}

	public int addrolesmodules(Integer mId, String rId) {
		// TODO Auto-generated method stub
		return rolesMapper.addrolesmodules(mId, rId);
	}

	public int delrolesmodules(Integer mId, String rId) {
		// TODO Auto-generated method stub
		return rolesMapper.delrolesmodules(mId, rId);
	}


	
	

	


}
