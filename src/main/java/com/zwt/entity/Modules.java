package com.zwt.entity;

public class Modules {

	private int Id;
	private String Name;
	private int ParentId;
	private String Path;
	private int Weight;
	private String Ops;
	private int Int0;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getParentId() {
		return ParentId;
	}
	public void setParentId(int parentId) {
		ParentId = parentId;
	}
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}
	public int getWeight() {
		return Weight;
	}
	public void setWeight(int weight) {
		Weight = weight;
	}
	public String getOps() {
		return Ops;
	}
	public void setOps(String ops) {
		Ops = ops;
	}
	public int getInt0() {
		return Int0;
	}
	public void setInt0(int int0) {
		Int0 = int0;
	}
	public Modules(int id, String name, int parentId, String path, int weight, String ops, int int0) {
		super();
		Id = id;
		Name = name;
		ParentId = parentId;
		Path = path;
		Weight = weight;
		Ops = ops;
		Int0 = int0;
	}
	public Modules() {
		super();
	}
	
}
