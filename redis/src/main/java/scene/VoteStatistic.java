/**
 * Copyright (C), 2018-2019, XXX���޹�˾
 * FileName: RedisString
 * Author:   yuanlin_csu
 * Date:     2019/7/25 11:33
 * Description: String����
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package scene;

import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;
import util.SnowFlake;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * ��һ�仰���ܼ�����<br>
 * ��ͶƱϵͳ��ģ�⡵
 *
 * @author yuanlin_csu
 * @create 2019/7/25
 * @since 1.0.0
 */
public class VoteStatistic {

    private final String adderss = "redis://127.0.0.1:6379";

    private int port = 6379;

    // �������� articleId;
    private static SnowFlake snowFlakeArticleId =
            new SnowFlake(30L, 1, 1);

    // �������� userId;
    private static SnowFlake snowFlakeUserId =
            new SnowFlake(31L, 1, 1);


    public static void main(String[] args) throws InterruptedException {

        new VoteStatistic().run();

    }

    public void run() throws InterruptedException {

        // ��Ҫ��Ȩ����ʱ ʹ�����»�ȡ����,Ĭ�ϴ�index=0 ��ʼ

        JedisShardInfo shardInfo = new JedisShardInfo(adderss);

        shardInfo.setPassword("yuanlin");
        Jedis jedis = new Jedis(shardInfo);

        jedis.connect();
        // ���ز���ָ��ִ��״̬
        String str = jedis.select(14);

        if (!StringUtils.equalsIgnoreCase("OK", str)) {

            System.out.println("redis ���ݿ�ѡ��״̬�жϴ��� : " + str);
            jedis.close();
            return;
        }

        /**
         *  1.0 ����10 �� user ����� key=user�ļ��ϣ�ͶƱʱ
         *  �������һ���û���ͶƱ����
         */
        // key������� �����ָ��
        String userKey = "user:";
        for (int i = 0; i < 10; i++) {
            String userId = String.valueOf(snowFlakeUserId.nextId());
            jedis.sadd(userKey, userId);

        }

        // ���ؼ���set��Ԫ�صĸ���
        long userCount = jedis.scard(userKey);

        if (userCount <= 0) {

            System.out.println("�����û������жϴ��� : " + userCount);
            jedis.close();
            return;
        }

        /**
         *  2.0 ����5 ƪ���� ��Ϣ��ʹ��hash �����洢,key = article: id
         *  2.1 ������ articleId ��key ����¼�� һ��set�У�ͶƱʱ���ȡ��һ����ͶƱ��
         *  2.2 �� articleId Ϊkey �� hash �洢
         *  2.3 hash �ṹ����;
         *  <p type="hash">
         *      <title>����</title>
         *      <link>���ӵ�ַ<link/>
         *      <poster>����</poster>
         *      <votes>Ʊ���÷�ÿһƱ�ڷ���������482 ������չʾ�����ȼ������</vote>
         *      <time>ʱ������ܳ����ظ�</time>
         *  <p/>
         *
         *
         */

        String[] poster = {"YL", "ZWW", "ZWW1", "LQ", "ZZK"};
        String[] title = {"Remeo And Juliet", "Pride And Prejudic", "Hiroshima",
                "Sorrows Of Youang Werther", "Macbeth"};
        String linkStr = "127.0.0.1";
        // redis �е� ��� ������Ϣid�� set ���ϵ�key
        String artidleIdSetKey = "article-key";

        // ����ʱ���¼���·�����key ���佫���������Ƿ��ͶƱ���ж�����
        String timeScoreZSetKey = "time";

        // ���� ͶƱ����¼������ zset��key
        String voteScoreZSetKey = "score";

        // ��ʼ������Ĭ�� 1 Ʊ��ÿƱ482.00 ��
        double initScore = 482.00;
        for (int j = 0; j < 5; j++) {
            String articleIdKeyStr = "article:" + snowFlakeArticleId.nextId();
            Map<String,String> articleTempMap = new HashMap<String,String>();

            articleTempMap.put("title",title[j]);
            articleTempMap.put("link",linkStr);
            articleTempMap.put("votes","0");
            articleTempMap.put("poster",poster[j]);
            double timeHashKey = (double)System.currentTimeMillis();
            articleTempMap.put("time","" + timeHashKey);

            //timeScore
            jedis.zadd(timeScoreZSetKey,timeHashKey,articleIdKeyStr);

            //votedScore ��ʼ���� 482.00

            jedis.zadd(voteScoreZSetKey,initScore,articleIdKeyStr);

            // key ���� set
            jedis.sadd(artidleIdSetKey,articleIdKeyStr);

            // ����hash
            jedis.hmset(articleIdKeyStr,articleTempMap);
            //����ʱ���ظ�
            TimeUnit.MILLISECONDS.sleep(10);

        }

        // ��ʼ������ɣ���ʼ�����û�ͶƱ���ڣ����ѡ�� 10 ���û�����ͶƱ����




        jedis.close();


    }


}
