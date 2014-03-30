package cn.mars.gxkl.controller;

import cn.mars.gxkl.handler.Decoder;
import cn.mars.gxkl.observe.Observer;

/**
 * 
 * @author hawklithm
 * 2014-3-30обнГ4:38:52
 */
public class PannelController implements Observer{
	private Decoder decoder;

	@Override
	public void exec(String msg) {
		Object object=decoder.decode(msg);
	}

	public Decoder getDecoder() {
		return decoder;
	}

	public void setDecoder(Decoder decoder) {
		this.decoder = decoder;
	}

}
