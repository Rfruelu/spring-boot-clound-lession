package springboot.lujia.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import springboot.lujia.controller.ValueController;

/**
 * @author :lujia
 * @date :2018/11/15  15:22
 */
@Component
@Slf4j
public class TestRunner implements ApplicationRunner {

    @Autowired
    private ApplicationContext context;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ValueController bean = context.getBean(ValueController.class);
        log.info(bean.toString());
    }


}
