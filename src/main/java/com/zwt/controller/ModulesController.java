package com.zwt.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zwt.entity.Modules;
import com.zwt.entity.Roles;
import com.zwt.service.ModulesService;
@RestController
@Transactional
public class ModulesController {

	@Resource(name="modulesServiceImpl")
	private ModulesService modulesServiceImpl;
	
	//判断子节点
	public List<Object> pbChild(int id,List<Modules> list){
		List<Object> m=new ArrayList<Object>();
		for(Modules ls:list) {
			if(ls.getParentId()==id) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id",ls.getId());
				map.put("title", ls.getName());
				m.add(map);
			}
		}
		return m;
	}
	
	//渲染数据
	@RequestMapping("/getAllModules")
	public List<Object> getAllModules(){
		List<Object> list = new ArrayList<Object>();
		List<Modules> modules = modulesServiceImpl.getAllModules();
		for(Modules m:modules) {
			Map<String, Object> map = new HashMap<String, Object>();
			if(m.getParentId()==0) {
				map.put("id",m.getId());
				map.put("title", m.getName());
				map.put("children", pbChild(m.getId(),modules));
				list.add(map);
			}
		}
		return list;
	}
	
	//点击获取
	@RequestMapping("/getAllModulesbyid")
	public Map<String, Object> getAllModulesbyid(Integer id){
		Modules m = modulesServiceImpl.getAllModulesbyid(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		map.put("message", m);
		return map;	
	}
	
	//根据id修改节点名称
	@RequestMapping("/updateModulesById")
	public Map<String, Object> updateModulesById(Modules modules){
		int a = modulesServiceImpl.updateModulesById(modules);
		Map<String, Object> map = new HashMap<String, Object>();
		if(a>0) {
			map.put("success", true);
			map.put("message", "修改成功");
		}else {
			map.put("success", false);
			map.put("message", "修改失败");
		}
		return map;		
	} 
	
	//根据id删除节点
	@RequestMapping("/deleteModulesById")
	public Map<String, Object> deleteModulesById(Integer d_id){
		int a = modulesServiceImpl.deleteModulesById(d_id);
		Map<String, Object> map = new HashMap<String, Object>();
		if(a>0) {
			map.put("success", true);
			map.put("message", "删除成功");
		}else {
			map.put("success", false);
			map.put("message", "删除失败");
		}
		return map;		
	} 
	
	//添加
	 @RequestMapping("/addModules")
	 public Map<String, Object> addModules(Modules modules){
			int a = modulesServiceImpl.addModules(modules);
			Map<String, Object> map = new HashMap<String, Object>();
			if(a>0) {
				map.put("success", true);
				map.put("message", "添加成功");
			}else {
				map.put("success", false);
				map.put("message", "添加失败");
			}
			return map;		
		} 
	 
	   
}
