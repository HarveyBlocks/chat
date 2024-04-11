package com.harvey.chart.client;

import java.util.Scanner;

/**
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2024-02-29 18:58
 */
public class RpcClient {
    public static final Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args) {
        RpcClientManager.run();
    }
}

