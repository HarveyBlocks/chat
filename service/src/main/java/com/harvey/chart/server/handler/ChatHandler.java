package com.harvey.chart.server.handler;


import com.harvey.chart.message.ChatRequestMessage;
import com.harvey.chart.message.ChatResponseMessage;
import com.harvey.chart.server.session.SessionFactory;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 处理私聊请求
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2024-02-29 22:19
 */
@ChannelHandler.Sharable
public class ChatHandler extends SimpleChannelInboundHandler<ChatRequestMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ChatRequestMessage msg) throws Exception {
        String target = msg.getTo();
        Channel targetChannel = SessionFactory.getSession().getChannel(target);
        ChatResponseMessage resp;
        if(targetChannel == null){
            // 不在线
            resp = new ChatResponseMessage(false,"对方不在线",msg.getSequenceId());
            ctx.writeAndFlush(resp);
        }else {
            ChatResponseMessage sendMessage = new ChatResponseMessage(msg);
            targetChannel.writeAndFlush(sendMessage);
            resp = new ChatResponseMessage(true, "发送成功",msg.getSequenceId());
            ctx.writeAndFlush(resp);
        }

    }
}