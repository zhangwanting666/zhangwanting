package com.zwt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zwt.entity.Roles;
import com.zwt.entity.qx;
import com.zwt.serviceImpl.RolesServiceImpl;
import com.zwt.util.Result;
@RestController
@Transactional
public class RolesController {

	@Resource(name="rolesServiceImpl")
	private RolesServiceImpl rolesServiceImpl;
	
	@RequestMapping("/goro")
	public String go1() {
		return "Roles";
	}
	
	/*
	 * ��ѯ
	 * */
	@RequestMapping(method = RequestMethod.POST, value = "/getRoles")
	public Map<String, Object> getRoles(String Name,Integer limit,Integer page){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int page1=(page - 1)*limit;
		List<Roles> r = rolesServiceImpl.getAllModules(Name, limit, page1);
		int count = rolesServiceImpl.getCountModules(Name);
		resultMap.put("code", 0);
		resultMap.put("msg", "");
		resultMap.put("count", count);
		resultMap.put("data", r);
		return resultMap;
		
	}
	
	/*
	 * ���
	 */
	@PostMapping("/addRoles")
	public String addR(String id_a, String name_a) {
		int a = rolesServiceImpl.addRoles(id_a, name_a);
		String dd = null;
		if (a != 0) {
			dd = Result.toClient("0", "��ӳɹ�");
		} else {
			dd = Result.toClient("1", "���ʧ��");
		}
		return dd;
	}
	
	/*
	 * ɾ��
	 */
	@RequestMapping("/deleteRole")
	public String deleteR(String id_d) {
		int a=rolesServiceImpl.deleteRoles(id_d);
		String dd=null;
		if(a!=0) {
		 dd = Result.toClient("0","ɾ���ɹ�");
		}else {
		 dd = Result.toClient("1","ɾ��ʧ��");	
		}
		return dd;

	}

	/*
	 * �޸�
	 */
	@RequestMapping("/upateRoles")
	public String updateR(String id_e, String name_e) {
		int a=rolesServiceImpl.updateRoles(id_e, name_e);
		String dd=null;
		if(a!=0) {
		 dd = Result.toClient("0","�޸ĳɹ�");
		}else {
		 dd = Result.toClient("1","�޸�ʧ��");	
		}
		return dd;
	}
	
	/*
	 *��ô����zuo
	 * */
	@RequestMapping("/getrolesmodulesLeft")
	public List<qx> getrolesmodulesLeft(){
		List<qx> l = rolesServiceImpl.getLeft();
		return l;
		
	}
	/*
	 * ��ô����you
	 * */
	@RequestMapping("/getrolesmodulesRightById")
	public List<qx> getrolesmodulesRightById(String RoleId){
		List<qx> l = rolesServiceImpl.getRight(RoleId);
		return l;
		
	}
	/*
	 * ����û���ɫ
	 * */
	@RequestMapping("/addrolesmodules")
	public List<Object> addrolesmodules(Integer mId,String rId){
		rolesServiceImpl.addrolesmodules(mId, rId);
		return null;
		
	}
	/*
	 * ɾ���û���ɫ
	 * */
	@RequestMapping("/delrolesmodules")
	public List<Object> delrolesmodules(Integer mId1,String rId1){
		rolesServiceImpl.delrolesmodules(mId1, rId1);
		return null;
		
	}
	
}
