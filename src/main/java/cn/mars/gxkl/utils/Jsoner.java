package cn.mars.gxkl.utils;

import com.google.gson.Gson;

public class Jsoner {
	public static Gson normalGson=new Gson();
	public static String toJson(Object src){
		return normalGson.toJson(src);
	}
}
