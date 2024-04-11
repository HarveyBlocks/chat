package com.harvey.chart.client.handler;


import com.harvey.chart.message.GroupChatResponseMessage;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 获取私信信息
 * 可能是自己发送的消息,然后返回是否成功
 * 也可能是别人发来的消息
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2024-03-01 14:42
 */
@ChannelHandler.Sharable
public class ReceiveGroupChatHandler extends SimpleChannelInboundHandler<GroupChatResponseMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupChatResponseMessage msg) throws Exception {
        Boolean success = msg.isSuccess();
        if (success == null){
            // 是别人发来的消息
            String from = msg.getFrom();
            String content = msg.getContent();
            System.out.println(from+"-"+msg.getGroupName()+":"+content);
        }else if(Boolean.TRUE.equals(success)){
            // 发送成功
            System.out.println(msg.getReason());
        }else {
            System.err.println(msg.getReason());
        }
    }
}
