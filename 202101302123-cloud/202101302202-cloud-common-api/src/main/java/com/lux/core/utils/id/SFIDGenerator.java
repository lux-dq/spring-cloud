package com.lux.core.utils.id;

public class SFIDGenerator {
    //================================================Algorithm's Parameter=============================================
    // 系统开始时间截 (UTC 2017-06-28 00:00:00)
    private static final long startTime = 7000000000000L;

    // 毫秒内最大的序列数
    private static final int maxSequence = 99;
    //=================================================Works's Parameter================================================
    /**
     * 工作机器ID(0~9)
     */
    private static int workerId = 0;
    /**
     * 毫秒内序列(1~99)
     */
    private static int sequence = 1;
    /**
     * 上次生成ID的时间截
     */
    private static long lastTimestamp = -1L;

    //====================================================Test Case=====================================================
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            long id = SFIDGenerator.nextId();
            System.out.println(id);
        }
    }

    // ==================================================Methods========================================================
    // 线程安全地获得下一个 ID 的方法
    public static synchronized long nextId() {
        long timestamp = currentTime();
        //如果当前时间小于上一次ID生成的时间戳: 说明系统时钟回退过 - 这个时候应当抛出异常
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(
                    String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }
        //如果是同一时间生成的，则进行毫秒内序列
        if (lastTimestamp == timestamp) {
            sequence = sequence + 1;
            //毫秒内序列溢出 即 序列 > maxSequence
            if (sequence > maxSequence) {
                //阻塞到下一个毫秒,获得新的时间戳
                timestamp = blockTillNextMillis(lastTimestamp);
                sequence = 1;
            }
        }
        //时间戳改变，毫秒内序列重置
        else {
            sequence = 1;
        }
        //上次生成ID的时间截
        lastTimestamp = timestamp;
        return Long.parseLong((timestamp + startTime) + "" + workerId + String.format("%02d", sequence));
    }

    // 设置workId
    public static void setWorkerId(int workerId) {
        SFIDGenerator.workerId = workerId;
    }

    // getWorkId
    public static int getWorkerId() {
        return SFIDGenerator.workerId;
    }

    // 阻塞到下一个毫秒 即 直到获得新的时间戳
    protected static long blockTillNextMillis(long lastTimestamp) {
        long timestamp = currentTime();
        while (timestamp <= lastTimestamp) {
            timestamp = currentTime();
        }
        return timestamp;
    }

    // 获得以毫秒为单位的当前时间
    protected static long currentTime() {
        return System.currentTimeMillis();
    }
}
