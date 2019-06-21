package com.jdrx.springboot.demo.beans.commons;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io 

.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JsonDateDeSerializer extends JsonDeserializer<Date> {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public Date deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        try {
            String fieldData = parser.getText();
            return dateFormat.parse(fieldData);
        } catch (Exception e) {
            Calendar ca = Calendar.getInstance();
            ca.set(1970, Calendar.JANUARY, 1, 0, 0, 0);
            return ca.getTime();
        }
    }
}