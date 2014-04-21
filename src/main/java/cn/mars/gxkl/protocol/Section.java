package cn.mars.gxkl.protocol;

import java.util.List;
import java.util.Map;

public class Section extends Protocol {
	//名称，容量，管理员，管理员的ID，配置的内容
	private String NAME = "name", CAPACITY = "capacity", MANAGER = "manager",
			MANAGERID = "managerID",EQUIPMENTS="equipments";

	public Section() {
		super();
	}

	public Section(Map<String, Object> condition) {
		super(condition);
	}

	public void setName(String name) {
		setProperty(NAME, name);
	}

	public String getName() {
		return (String) getProperty(NAME);
	}

	public void setCapacity(String capacity) {
		setProperty(CAPACITY, capacity);
	}

	public String getCapacity() {
		return (String) getProperty(CAPACITY);
	}

	public void setManager(String manager) {
		setProperty(MANAGER, manager);
	}

	public String getManager() {
		return (String) getProperty(MANAGER);
	}

	public void setManagerID(String managerID) {
		setProperty(MANAGERID, managerID);
	}

	public String getManagerID() {
		return (String) getProperty(MANAGERID);
	}
	public void setEquipments(List<Equipment> equipments){
		setProperty(EQUIPMENTS, equipments);
	}
	public List<Equipment> getEquipments(){
		return (List<Equipment>) getProperty(EQUIPMENTS);
	}

}
