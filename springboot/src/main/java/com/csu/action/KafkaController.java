/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: KafkaController
 * Author:   yuanlin_csu
 * Date:     2019/6/27 16:13
 * Description: kafaka测试生产者与消费者控制器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.csu.action;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br> 
 * 〈kafaka测试生产者与消费者控制器〉
 *
 * @author yuanlin_csu
 * @create 2019/6/27
 * @since 1.0.0
 */
@RestController
public class KafkaController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping(value = "/consumer")
    public String consumer(){

        int count = 100;
        for ( int i = 0;i<count; i++){

            kafkaTemplate.send("yuanlin","key " + i,"data " + i);

        }


        return "Success !!!";
    }

    @KafkaListener(topics = "yuanlin",groupId = "kafka1")
    public void recive1(ConsumerRecord<?, ?> consumer) throws InterruptedException {
        //TimeUnit.SECONDS.sleep(1);
        System.out.println( "{ rec1 } "  + "{ " + consumer.topic()+ " }" + "{ " +consumer.key()+" : "+ consumer.value() + " }");

    }

    @KafkaListener(topics = "yuanlin",groupId = "kafka1")
    public void recive2(ConsumerRecord<?, ?> consumer) throws InterruptedException {
        //TimeUnit.SECONDS.sleep(1);
        System.out.println( "{ rec2 } "  + "{ " + consumer.topic()+ " }" + "{ " +consumer.key()+" : "+ consumer.value() + " }");
    }

}
