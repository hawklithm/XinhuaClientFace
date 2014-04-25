package cn.mars.gxkl.protocol;

import java.util.Map;

public class Person extends Protocol {
	//人的头像，名称，性别，id，Rfid，还有工作
	private String PATH = "userIconPath",NAME = "staffName",GENDER = "staffGender",ID = "staffId",JOB = "staffDepartmentName",EQUIPMENT_ID="equipmentId";
	
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
		Object object=getProperty(ID);
		if (object instanceof Double){
			return String.valueOf(((Double)getProperty(ID)).intValue());
		}else {
			return String.valueOf(object);
		}
	}
	
	public void setID(Integer id) {
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
