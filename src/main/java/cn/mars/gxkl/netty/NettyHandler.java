package cn.mars.gxkl.netty;

import java.io.IOException;
import java.nio.charset.Charset;

import javax.swing.JFrame;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

public abstract class NettyHandler extends SimpleChannelHandler {

	private JFrame face;
	
	@Override
	final public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
		ChannelBuffer buffer = (ChannelBuffer) e.getMessage();
		System.out.println("receive: " + buffer.toString(Charset.defaultCharset()));
		messageHandler(buffer.toString(Charset.defaultCharset()));
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
		if (e.getCause() instanceof IOException) {
			System.out.println("���Ӵ���,�Ͽ�");
			ctx.getChannel().close();
		} else {
			e.getCause().printStackTrace();
		}
	}

	@Override
	public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e)
			throws Exception {
		System.out.println("channelDisconnect");
		super.channelDisconnected(ctx, e);
	}

	@Override
	public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
		System.out.println("channalClosed");
		super.channelClosed(ctx, e);
	}

	public void sendMessage(String message, Channel channel) {
		if(channel == null) {
			System.out.println("null channel,can't send message.");
			return ;
		}
		byte[] messageBytes=message.getBytes();
		ChannelBuffer buffer = ChannelBuffers.buffer(messageBytes.length);
		buffer.writeBytes(messageBytes);
		channel.write(buffer);
	}
	
	/**
	  * 
	  * ��Ϣ����
	  *
	  **/
	public abstract void messageHandler(String message);
	
	public void setFace(JFrame face) {
		this.face = face;
	}
	
}
