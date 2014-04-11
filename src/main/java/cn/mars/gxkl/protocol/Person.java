package cn.mars.gxkl.protocol;

import java.util.Map;

public class Person extends Protocol {
	
	private String PATH = "userIconPath",NAME = "staffName",GENDER = "gender",ID = "staffId",JOB = "departmentName",EQUIPMENT_ID="equipmentId";
	
	public Person() {
		super();
	}

	public Person(Map<String,Object> condition) {
		super(condition);
	}
	
	public String getImgPath() {
		return (String)getProperty(PATH);
	}
	
	public void setImgPath(String path) {
		setProperty(PATH,path);
	}
	
	public String getName() {
		return (String)getProperty(NAME);
	}
	
	public void setName(String name) {
		setProperty(NAME,name);
	}
	
	public String getID() {
		return (String)getProperty(ID);
	}
	
	public void setID(String id) {
		setProperty(ID,id);
	}
	
	public String getGender() {
		return (String)getProperty(GENDER);
	}
	
	public void setGender(String gender) {
		setProperty(GENDER,gender);
	}
	
	
	public String getJob() {
		return (String)getProperty(JOB);
	}
	
	public void setJob(String job) {
		setProperty(JOB,job);
	}
	
	public void setEquipmentId(int id){
		setProperty(EQUIPMENT_ID, id);
	}
	
	public Integer getEquipmentId(){
		return (Integer)getProperty(EQUIPMENT_ID);
	}
	
}
