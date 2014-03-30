package cn.mars.gxkl.observe;

public interface Observable {
	abstract public void register(Observer object, String job);
//	abstract public void removeByObject(Object object);
	abstract public void removeByJob(String job);
	abstract public void notifyByJob(String job,String msg);
	abstract public void notifyByObject(String object);
}
