package cn.mars.gxkl.handler;

public  interface Decoder {
	 <T> T decode(String msg);
}
