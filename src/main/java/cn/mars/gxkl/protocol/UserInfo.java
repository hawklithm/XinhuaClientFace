package cn.mars.gxkl.protocol;

import java.sql.Date;
import java.util.Map;

public class UserInfo extends Protocol{
	private String NAME="userName",PASSWORD="password";
	private String GMTCREATE="gmtCreate";
	private String GMTMODIFIED="gmtModified";
	private String USERID="userId";
	private String STAFFID="staffId";
	private String ISEMPLOYEE="isEmployee";
	private String ENABLE="enable";
	private String HOSPITALID="hospitalId";
	private String LEVEL="level";
	public UserInfo(){
		super();
	}
	public UserInfo(Map<String,Object> condition){
		super(condition);
	}
	public void setPasword(String password){
		setProperty(PASSWORD,password);
	}
	public String getPassword(){
		return (String)getProperty(PASSWORD);
	}
	public void setHospitalId(int hospitalId){
		setProperty(HOSPITALID,hospitalId);
	}
	
	 public String  getHopistalId(){
			Object object=getProperty(HOSPITALID);
			if (object instanceof Double){
				return String.valueOf(((Double)getProperty(HOSPITALID)).intValue());
			}else {
				return String.valueOf(object);
			}
	   }
	 public void setLevel(String level){
		 setProperty(LEVEL,level);
	 }
	 public String getLevel(){
		return  (String)getProperty(LEVEL);
	 }
	public void setName(String name){
		setProperty(NAME,name);
		}
   public String getName(){
	   return (String)getProperty(NAME);
   }
   public void setPassword(String password){
	   setProperty(PASSWORD,password);
   }
   public void setGmtCreated(Date gmtcreated){
	   setProperty(GMTCREATE,gmtcreated);
   }
   public Date getGmtCreate(){
	   return (Date)getProperty(GMTCREATE);
   }
   public void setGmtModified(Date gmtmodified){
	   setProperty(GMTMODIFIED,gmtmodified);
   }
   public Date getGmtModified(){
	   return (Date)getProperty(GMTMODIFIED);
   }
   public void setId(Integer id){
	   setProperty(USERID,id);
   }
   public String  getId(){
		Object object=getProperty(USERID);
		if (object instanceof Double){
			return String.valueOf(((Double)getProperty(USERID)).intValue());
		}else {
			return String.valueOf(object);
		}
   }
   public void setStaffId(Integer id){
	   setProperty(STAFFID,id);
   }
   public String  getSTAFFId(){
		Object object=getProperty(STAFFID);
		if (object instanceof Double){
			return String.valueOf(((Double)getProperty(STAFFID)).intValue());
		}else {
			return String.valueOf(object);
		}
   }
	public void setIsEmployee(boolean is_employee){
		setProperty(ISEMPLOYEE,is_employee);
	}
	public boolean getImployee(){
		return (boolean)getProperty(ISEMPLOYEE);
	}
	public String getEnable(){
		Object object=getProperty(ENABLE);
		if (object instanceof Double){
			return String.valueOf(((Double)getProperty(ENABLE)).intValue());
		}else {
			return String.valueOf(object);
		}
	}
	public void setEnable(int enable){
		setProperty(ENABLE,enable);
		
	}
}
