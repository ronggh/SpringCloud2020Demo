package cn.alan;

import java.time.ZonedDateTime;

public class TestTimeZone {
    public static void main(String[] args) {
        // 默认时区
        ZonedDateTime zdt = ZonedDateTime.now();
        System.out.println(zdt);
    }
}
