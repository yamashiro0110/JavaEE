package sample.payara.test.jackson;

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;

public class JacksonTest {

    private static ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JodaModule());

    public static void main(final String[] args) {
        DateTime value = objectMapper.convertValue("2014-12-20T02:30:00.000Z", DateTime.class);
        System.out.println(value.toString());
    }

}
