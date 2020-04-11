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
	 * ��ѯ
	 * */
	public List<Roles> getAllModules(String Name, Integer limit, Integer page) {
		// TODO Auto-generated method stub
		return rolesMapper.selectAllRoles(Name, limit, page);
	}

	/*
	 * ҳ��
	 * */
	public int getCountModules(String Name) {
		// TODO Auto-generated method stub
		return rolesMapper.getCountRoles(Name);
	}

	/*
	 * ���
	 * */
		public int addRoles(String id_a,String name_a) {
			// TODO Auto-generated method stub
			return rolesMapper.add(id_a, name_a);
		}

	/*
	 * ɾ��
	 * */
		public int deleteRoles(String id) {
			// TODO Auto-generated method stub
			return rolesMapper.deleteRoles(id);
		}
	/*
	 * �޸�
	 * */
	public int updateRoles(String id, String name) {
		// TODO Auto-generated method stub
		return rolesMapper.update(id, name);
	}

	/*
	 * ��ɫȨ����ɾ�Ĳ�
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
