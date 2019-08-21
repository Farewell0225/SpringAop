/**
 * Copyright (C), 2018-2019, XXX���޹�˾
 * FileName: SnowFlake
 * Author:   yuanlin_csu
 * Date:     2019/7/26 15:50
 * Description: Ϊ�����ṩ�����ظ���id
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package util;

/**
 * ��һ�仰���ܼ�����<br> 
 * ��Ϊ�����ṩ�����ظ���id��
 *
 * @author yuanlin_csu
 * @create 2019/7/26
 * @since 1.0.0
 */
public class SnowFlake {

    // ������Ǵ����˻���id
    private long workerId;
    // ������Ǵ����˻���id
    private long datacenterId;

    // ������Ǵ�����һ���������ɵĶ��id���������
    private long sequence;
    public SnowFlake(long workerId, long datacenterId, long sequence) {
        // sanity check for workerId
        // ������ͼ����һ�£�Ҫ������㴫�ݽ����Ļ���id�ͻ���id���ܳ���32������С��0
        if (workerId > maxWorkerId || workerId < 0) {

            throw new IllegalArgumentException(
                    String.format("worker Id can't be greater than %d or less than 0",maxWorkerId));
        }

        if (datacenterId > maxDatacenterId || datacenterId < 0) {

            throw new IllegalArgumentException(
                    String.format("datacenter Id can't be greater than %d or less than 0",maxDatacenterId));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
        this.sequence = sequence;
    }
    private long twepoch = 1288834974657L;
    private long workerIdBits = 5L;
    private long datacenterIdBits = 5L;

    // ����Ƕ��������㣬����5 bit���ֻ����31�����֣�Ҳ����˵����id���ֻ����32����
    private long maxWorkerId = -1L ^ (-1L << workerIdBits);
    // �����һ����˼������5 bit���ֻ����31�����֣�����id���ֻ����32����
    private long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);
    private long sequenceBits = 12L;
    private long workerIdShift = sequenceBits;
    private long datacenterIdShift = sequenceBits + workerIdBits;
    private long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
    private long sequenceMask = -1L ^ (-1L << sequenceBits);
    private long lastTimestamp = -1L;
    public long getWorkerId(){
        return workerId;
    }
    public long getDatacenterId() {
        return datacenterId;
    }
    public long getTimestamp() {
        return System.currentTimeMillis();
    }
    // ����Ǻ��ķ�����ͨ������nextId()�������õ�ǰ��̨�����ϵ�snowflake�㷨��������һ��ȫ��Ψһ��id
    public synchronized long nextId() {
        // ������ǻ�ȡ��ǰʱ�������λ�Ǻ���
        long timestamp = timeGen();
        if (timestamp < lastTimestamp) {
            System.err.printf(
                    "clock is moving backwards. Rejecting requests until %d.", lastTimestamp);
            throw new RuntimeException(
                    String.format("Clock moved backwards. Refusing to generate id for %d milliseconds",
                            lastTimestamp - timestamp));
        }

        // ������˵������ͬһ�������ڣ��ַ�����һ����������һ��id
        // ���ʱ��͵ð�seqence��Ÿ�����1��������4096
        if (lastTimestamp == timestamp) {

            // �����˼��˵һ�����������ֻ����4096�����֣������㴫�ݶ��ٽ�����
            //���λ���㱣֤ʼ�վ�����4096�����Χ�ڣ��������Լ����ݸ�sequence������4096�����Χ
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }

        } else {
            sequence = 0;
        }
        // �����¼һ�����һ������id��ʱ�������λ�Ǻ���
        lastTimestamp = timestamp;
        // �����������ĵĶ�����λ�������������һ��64bit��id
        // �Ƚ���ǰʱ������ƣ��ŵ�41 bit�Ƕ���������id���Ʒŵ�5 bit�Ƕ���������id���Ʒŵ�5 bit�Ƕ�������ŷ����12 bit
        // ���ƴ��������һ��64 bit�Ķ��������֣�ת����10���ƾ��Ǹ�long��
        return ((timestamp - twepoch) << timestampLeftShift) |
                (datacenterId << datacenterIdShift) |
                (workerId << workerIdShift) | sequence;
    }
    private long tilNextMillis(long lastTimestamp) {

        long timestamp = timeGen();

        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }
    private long timeGen(){
        return System.currentTimeMillis();
    }
    //---------------����---------------
   /* public static void main(String[] args) {

        SnowFlake worker = new SnowFlake(1,1,1);

       // for (int i = 0; i < 30; i++) {
            System.out.println(worker.nextId());
        //}
    }*/

}