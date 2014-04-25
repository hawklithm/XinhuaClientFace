package cn.mars.gxkl.constant;

public class Constant {
	
	public static String[] jobs = {
		"DefaultUI","ClientService","Translator"
	};
	//流程的过程名称
	public static final String processName[] = {"sortingprocess","cleananddisinfectprocess",
		"packagingprocess","secondarydisinfectprocess",
		"sterilestorageprocess"
	};
	//状态
	public static final int ITEM_STATUS_TODO = 0x00,
							   ITEM_STATUS_DOING = 0x01,
							   ITEM_STATUS_DONE = 0x02;
	
}
