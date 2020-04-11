package com.zwt.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zwt.entity.Modules;
import com.zwt.entity.Roles;
import com.zwt.mapper.ModulesMapper;
import com.zwt.service.ModulesService;
@Service
public class ModulesServiceImpl implements ModulesService{

	@Resource(name="modulesMapper")
	private ModulesMapper modulesMapper;
	
	public List<Modules> getAllModules() {
		// TODO Auto-generated method stub
		return modulesMapper.getAllModules();
	}

	public int updateModulesById(Modules modules) {
		// TODO Auto-generated method stub
		return modulesMapper.updateModulesById(modules);
	}

	public int deleteModulesById(Integer id) {
		// TODO Auto-generated method stub
		return modulesMapper.deleteModulesById(id);
	}

	public int addModules(Modules modules) {
		// TODO Auto-generated method stub
		return modulesMapper.addModules(modules);
	}

	public Modules getAllModulesbyid(Integer id) {
		// TODO Auto-generated method stub
		return modulesMapper.getAllModulesbyid(id);
	}

	
}
