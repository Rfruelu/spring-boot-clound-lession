package springboot.lujia.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author :lujia
 * @date :2018/11/13  16:32
 */
@Component
@ConfigurationProperties(prefix = "book")
public class BookConfig {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
