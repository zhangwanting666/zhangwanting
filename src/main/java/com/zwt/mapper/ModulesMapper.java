package com.zwt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zwt.entity.Modules;
import com.zwt.entity.Roles;


public interface ModulesMapper {

	 public List<Modules> getAllModules();
	  public Modules getAllModulesbyid(@Param("id")Integer id);
	   public int updateModulesById(Modules modules);
	   public int deleteModulesById(@Param("id")Integer id);
	   public int addModules(Modules modules);
	  
}
