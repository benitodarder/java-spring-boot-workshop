package local.tin.tests.spring.boot.web.page.services;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;

/**
 *
 * @author benitodarder
 */
@Service
public class UpTimeSrv {

    public static final String TIMESTAMP_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSX";
    public static final long CURRENT_MILIS = System.currentTimeMillis();
    public long milis = System.currentTimeMillis();

    public String getResponse(String message) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(TIMESTAMP_FORMAT)
                .withZone(ZoneOffset.UTC);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hi ")
                .append(message)
                .append(", this service creation is (with static field) ")
                .append(dateTimeFormatter.format(Instant.ofEpochMilli(CURRENT_MILIS)))
                .append(", this service creation is (with no static field) ")
                .append(dateTimeFormatter.format(Instant.ofEpochMilli(milis)))
                .append(", and now it's ")
                .append(Instant.now());
        return stringBuilder.toString();
    }
}
