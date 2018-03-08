package me.shouheng.joda.time;

import org.joda.time.DateTime;
import org.joda.time.Days;

public class JodaTimeExample {

    /**
     * Joda time examples, Here are just some simple examples, but the library itself is really strong and powerful.
     *
     * @param args args */
    public static void main(String...args) {
        DateTime nowDateTime = new DateTime();
        DateTime futureDateTime = new DateTime(2018, 3, 20, 0, 0, 0);
        System.out.println(nowDateTime.getMonthOfYear()); // Mar->3
        System.out.println(nowDateTime.withTimeAtStartOfDay()); // 获取今天的开始时间
        System.out.println(nowDateTime.millisOfDay().withMaximumValue()); // 获取今天的结束时间
        System.out.println(Days.daysBetween(nowDateTime, futureDateTime).getDays()); // 计算两个日期的相隔天数
        System.out.println(nowDateTime.plusDays(3).toString("E MM/dd/yyyy HH:mm:ss.SSS")); // 以 Joda 的方式向某一个瞬间加上 3 天并输出结果
    }
}
