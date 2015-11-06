package com.piza.bean;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Peter on 2015/4/28.
 */
public class CustomDateTimeSerializer extends JsonSerializer<Date> {

    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider prov)
            throws IOException, JsonProcessingException {
        String formattedDate = formatter.format(value);

        gen.writeString(formattedDate);
    }

}
