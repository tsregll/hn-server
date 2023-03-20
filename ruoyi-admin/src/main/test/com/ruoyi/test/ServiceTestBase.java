package com.ruoyi.test;


import com.ruoyi.RuoYiApplication;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { RuoYiApplication.class }) // 指定启动类
public class ServiceTestBase {

    protected Logger log = LoggerFactory.getLogger(this.getClass());

}
