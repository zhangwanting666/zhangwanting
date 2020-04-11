package com.zwt.util;
import java.util.HashMap;
import java.util.Map;

public class LayUiTableData {
   public int code;
   public String msg;
   public int count;
   public Object data;

   public static Map<String, Object> toClient(int status,String message,int total,Object data){
		Map<String , Object> map = new HashMap<String, Object>();
		 map.put("code", 0);
		 map.put("msg","");
		 map.put("count",total);
		 map.put("data",data); 	
		
		return map;
	}
   
   public static Map<String, Object> toClient(int status,String message){
		Map<String , Object> map = new HashMap<String, Object>();
		 map.put("code",status);
		 map.put("msg",message);

		return map;
	}
}
