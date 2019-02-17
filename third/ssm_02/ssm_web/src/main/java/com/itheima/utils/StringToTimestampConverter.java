package com.itheima.utils;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class StringToTimestampConverter implements Converter<String,Timestamp> {
    public Timestamp convert(String source) {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(source);
            Timestamp timestamp = new Timestamp(date.getTime());
            return timestamp;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
