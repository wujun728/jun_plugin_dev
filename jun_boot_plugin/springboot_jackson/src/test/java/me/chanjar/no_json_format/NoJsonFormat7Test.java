package me.chanjar.no_json_format;

import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = { NoJsonFormat7Test.class, JacksonAutoConfiguration.class }, properties = {
    "spring.jackson.date-format=yyyy-MMM-dd HH:mm:ss",
})
public class NoJsonFormat7Test extends NoJsonFormatTestBase {

}
