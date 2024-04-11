package com.harvey.chart.client.handler;


import com.harvey.chart.message.GroupJoinResponseMessage;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * TODO
 * 
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2024-03-01 14:42
 */
@ChannelHandler.Sharable
public class GroupJoinResultHandler extends SimpleChannelInboundHandler<GroupJoinResponseMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupJoinResponseMessage msg) throws Exception {
        Handlers.responseSuccessHandler(msg);
    }
}
