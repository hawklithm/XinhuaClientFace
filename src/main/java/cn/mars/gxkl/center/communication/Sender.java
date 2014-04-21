package cn.mars.gxkl.center.communication;

public interface Sender {
//	void send(Object object);
	//客户端发送请求
	void query(Object object);//查询接口
	void update(Object object);//更新接口
}
