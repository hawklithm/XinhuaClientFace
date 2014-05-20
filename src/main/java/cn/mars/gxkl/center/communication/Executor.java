package cn.mars.gxkl.center.communication;

import cn.mars.gxkl.protocol.AppProtocol;

/**
 * 
 * @author hawklithm
 * 2014-4-1����10:07:47
 */
public interface Executor {
	/**
	 * �ж��Ƿ���Ҫ�ڴ�����ʱ�򼴷��ͳ�ʼ������,�������豸��ˮ��Ϣ��֪ͨ��Ϣ��Ҫ��ǰ����������߷����������������ӱ�����Ϣʵʱ����
	 * 
	 * @return
	 */
	boolean isInitialFirst();

	/**
	 * ���ͳ�ʼ�����������������������
	 */
	void sendInitRequest();

	/**
	 * ���������н�����Ⱦ
	 * @param response
	 */
	void decode(AppProtocol response) throws Exception;
}
