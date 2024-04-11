package com.harvey.chart.message;

import lombok.Data;
import lombok.ToString;

/**
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2024-02-29 18:58
 */
@Data
@ToString(callSuper = true)
public class GroupQuitRequestMessage extends Message {
    private String groupName;
    private String username;

    public GroupQuitRequestMessage(String username, String groupName) {
        this.groupName = groupName;
        this.username = username;
    }

    @Override
    public byte getMessageType() {
        return GROUP_QUIT_REQUEST_MESSAGE;
    }
}
