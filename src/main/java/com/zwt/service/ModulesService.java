package com.zwt.service;

import java.util.List;

import com.zwt.entity.Modules;

public interface ModulesService {

	/*
	 * ²éÑ¯
	 * */
	 public List<Modules> getAllModules();
	 /*
	  * ÐÞ¸Ä
	  * */
	 public int updateModulesById(Modules modules);
	 /*
	  * É¾³ý
	  * */
	 public int deleteModulesById(Integer id);
	 /*
	  * Ìí¼Ó
	  * */
	 public int addModules(Modules modules);
	 
	 public Modules getAllModulesbyid(Integer id);
	 
	
}
