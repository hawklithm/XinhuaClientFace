package cn.mars.gxkl.observe;

public interface Observable {
	abstract public void register(Observer object, String job);//ע��۲��ߺ���Ӧ�Ĺ���
//	abstract public void removeByObject(Object object);
	abstract public void removeByJob(String job);//�Ƴ���Ӧ�Ĺ����۲���
	abstract public void notifyByJob(String job,String msg);//֪ͨ��Ӧ�Ĺ���
	abstract public void notifyByObject(String object);//֪ͨ��Ӧ������
}
