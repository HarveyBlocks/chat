package com.harvey.chart.message;

/**
 * TODO
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2024-03-01 23:27
 */
public class PingMessage extends Message {
    @Override
    public byte getMessageType() {
        return PING_MESSAGE;
    }
}
