package cn.mars.gxkl.protocol;

import java.util.Map;

public class StaffInfo extends Protocol{

	private int id;
	private String name;
	private String password;
	public StaffInfo(){
		
	}
	public StaffInfo(Map<String,Object> condition){
		super(condition);
	}
   public void setId(int id){
	   this.id=id;
   }
   public int getId(){
	   return id;
   }
   public void setName(String name){
	   this.name=name;
   }
   public String getName(){
	   return name;
   }
   public void setPassword(String password){
	  this.password=password;
   }
 public String getPassword(){
	 return password;
 }
   
}
