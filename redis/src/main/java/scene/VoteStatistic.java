/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: RedisString
 * Author:   yuanlin_csu
 * Date:     2019/7/25 11:33
 * Description: String类型
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
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
 * 〈一句话功能简述〉<br>
 * 〈投票系统，模拟〉
 *
 * @author yuanlin_csu
 * @create 2019/7/25
 * @since 1.0.0
 */
public class VoteStatistic {

    private final String adderss = "redis://127.0.0.1:6379";

    private int port = 6379;

    // 用于生成 articleId;
    private static SnowFlake snowFlakeArticleId =
            new SnowFlake(30L, 1, 1);

    // 用于生成 userId;
    private static SnowFlake snowFlakeUserId =
            new SnowFlake(31L, 1, 1);


    public static void main(String[] args) throws InterruptedException {

        new VoteStatistic().run();

    }

    public void run() throws InterruptedException {

        // 需要授权密码时 使用如下获取连接,默认从index=0 开始

        JedisShardInfo shardInfo = new JedisShardInfo(adderss);

        shardInfo.setPassword("yuanlin");
        Jedis jedis = new Jedis(shardInfo);

        jedis.connect();
        // 返回参数指令执行状态
        String str = jedis.select(14);

        if (!StringUtils.equalsIgnoreCase("OK", str)) {

            System.out.println("redis 数据库选择状态判断错误 : " + str);
            jedis.close();
            return;
        }

        /**
         *  1.0 生成10 个 user 存放于 key=user的集合，投票时
         *  随机返回一个用户做投票操作
         */
        // key的设计以 ：做分割符
        String userKey = "user:";
        for (int i = 0; i < 10; i++) {
            String userId = String.valueOf(snowFlakeUserId.nextId());
            jedis.sadd(userKey, userId);

        }

        // 返回集合set中元素的个数
        long userCount = jedis.scard(userKey);

        if (userCount <= 0) {

            System.out.println("生成用户数量判断错误 : " + userCount);
            jedis.close();
            return;
        }

        /**
         *  2.0 产生5 篇文章 信息，使用hash 机构存储,key = article: id
         *  2.1 先生成 articleId 的key ，记录在 一个set中，投票时随机取出一个做投票，
         *  2.2 以 articleId 为key 的 hash 存储
         *  2.3 hash 结构如下;
         *  <p type="hash">
         *      <title>标题</title>
         *      <link>连接地址<link/>
         *      <poster>作者</poster>
         *      <votes>票数得分每一票在分数上增加482 （依据展示天数等计算出）</vote>
         *      <time>时间戳可能出现重复</time>
         *  <p/>
         *
         *
         */

        String[] poster = {"YL", "ZWW", "ZWW1", "LQ", "ZZK"};
        String[] title = {"Remeo And Juliet", "Pride And Prejudic", "Hiroshima",
                "Sorrows Of Youang Werther", "Macbeth"};
        String linkStr = "127.0.0.1";
        // redis 中的 存放 文章信息id的 set 集合的key
        String artidleIdSetKey = "article-key";

        // 依据时间计录文章分数的key ，其将参与文章是否可投票的判断依据
        String timeScoreZSetKey = "time";

        // 依据 投票数计录分数的 zset的key
        String voteScoreZSetKey = "score";

        // 初始化分数默认 1 票，每票482.00 分
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

            //votedScore 初始评分 482.00

            jedis.zadd(voteScoreZSetKey,initScore,articleIdKeyStr);

            // key 放入 set
            jedis.sadd(artidleIdSetKey,articleIdKeyStr);

            // 放入hash
            jedis.hmset(articleIdKeyStr,articleTempMap);
            //避免时间重复
            TimeUnit.MILLISECONDS.sleep(10);

        }

        // 初始化已完成，开始进行用户投票环节，随机选择 10 次用户进行投票操作




        jedis.close();


    }


}
