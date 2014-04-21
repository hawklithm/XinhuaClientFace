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
	public static final String ITEM_STATUS_TODO = "todo",
							   ITEM_STATUS_DOING = "doing",
							   ITEM_STATUS_DONE = "done";
	
}
