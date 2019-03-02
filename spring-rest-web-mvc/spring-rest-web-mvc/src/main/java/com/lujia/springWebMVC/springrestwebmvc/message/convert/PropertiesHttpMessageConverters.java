package com.lujia.springWebMVC.springrestwebmvc.message.convert;

import com.lujia.springWebMVC.springrestwebmvc.domain.User;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * @author :lujia
 * @date :2018/7/22  19:44
 */
public class PropertiesHttpMessageConverters extends AbstractHttpMessageConverter<User> {

    public PropertiesHttpMessageConverters() {
        super(MediaType.valueOf("application/properties-user"));
        setDefaultCharset(Charset.forName("UTF-8"));
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(User.class);
    }

    @Override
    protected User readInternal(Class<? extends User> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {

        InputStream inputStream = inputMessage.getBody();
        Properties properties=new Properties();
        properties.load(inputStream);
        User user=new User();
        user.setAge(Integer.valueOf(properties.getProperty("user.age")));
        user.setName(properties.getProperty("user.name"));

        return user;
    }

    @Override
    protected void writeInternal(User user, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

        OutputStream outputStream = outputMessage.getBody();
        Properties properties=new Properties();

        properties.setProperty("user.age",String.valueOf(user.getAge()));
        properties.setProperty("user.name",user.getName());

        properties.store(outputStream,"write by web server");

    }
}
