package com.zwt.util;

import java.util.Comparator;

import com.zwt.entity.Modules;


public class ModuleCompator implements Comparator<Modules> {

	public int compare(Modules o1, Modules o2) {
		// TODO Auto-generated method stub
		return o1.getId()-o2.getId();
	}

}
