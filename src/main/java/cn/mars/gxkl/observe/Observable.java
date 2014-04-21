package cn.mars.gxkl.observe;

public interface Observable {
	abstract public void register(Observer object, String job);//注册观察者和相应的工作
//	abstract public void removeByObject(Object object);
	abstract public void removeByJob(String job);//移出相应的工作观察者
	abstract public void notifyByJob(String job,String msg);//通知相应的工作
	abstract public void notifyByObject(String object);//通知相应的物体
}
