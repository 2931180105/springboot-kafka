package com.lucky.springbootkafka.controller;

import com.lucky.springbootkafka.config.KfkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: H
 * @description:
 * @program: springboot-kafka
 * @create: 2019-12-16 19:56
 **/
@Controller
public class KafkaTestController {

    @Autowired
    private KfkaProducer producer;

    @RequestMapping("/testSendMsg/{message}")
    @ResponseBody
    public String testSendMsg(){
        producer.send();
        return "success";
    }

}