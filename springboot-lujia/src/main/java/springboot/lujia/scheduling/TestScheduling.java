package springboot.lujia.scheduling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author :lujia
 * @date :2018/11/14  16:31
 */
@Component
@Slf4j
public class TestScheduling {


   // @Scheduled(cron = "0/1 * * * * ?")
    public void test(){
        log.error("test scheduling");
    }
}


