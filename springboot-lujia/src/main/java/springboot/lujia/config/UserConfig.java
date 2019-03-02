package springboot.lujia.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author :lujia
 * @date :2018/11/13  16:36
 */
@Component
@PropertySource("user.properties")
@ConfigurationProperties(prefix = "user")
public class UserConfig {

    private String fullName;

    private int age;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
