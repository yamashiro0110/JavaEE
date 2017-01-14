package sample.payara.controller.joda;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class JodaDateTimeRequest {
    /**
     * ISO DateFormatで受け取る<br>
     * ex) 2014-12-20T02:30:00.000Z
     */
    @JsonProperty
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private DateTime dateTime;

}
