package com.zwt.service;

import java.util.List;

import com.zwt.entity.Modules;

public interface ModulesService {

	/*
	 * ��ѯ
	 * */
	 public List<Modules> getAllModules();
	 /*
	  * �޸�
	  * */
	 public int updateModulesById(Modules modules);
	 /*
	  * ɾ��
	  * */
	 public int deleteModulesById(Integer id);
	 /*
	  * ���
	  * */
	 public int addModules(Modules modules);
	 
	 public Modules getAllModulesbyid(Integer id);
	 
	
}
