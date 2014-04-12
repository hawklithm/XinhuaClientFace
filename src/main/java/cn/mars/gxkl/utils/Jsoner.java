package cn.mars.gxkl.utils;

import java.io.StringReader;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class Jsoner {
	private  static Gson normalGson=new Gson();
	public static String toJson(Object src){
		return normalGson.toJson(src);
	}
	public static <T> T fromJson(String json,Class<T>classOfT){
		JsonReader reader = new JsonReader(new StringReader(json));
		reader.setLenient(true);
		return normalGson.fromJson(reader, classOfT);	
	}
	public static <T>T fromJson(String json,Type typeOfT){
		JsonReader reader = new JsonReader(new StringReader(json));
		reader.setLenient(true);
		return normalGson.fromJson(reader, typeOfT);	
	}
}
