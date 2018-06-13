package com.gxb.sdk.des.util;

import org.joda.time.DateTime;
import org.joda.time.Days;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Date;

/**
 * 黑名单共债工具类
 *
 * @author liruobin
 * @since 2018/6/11 上午11:27
 */
public class BlacklistUtil {
    private static DecimalFormat df = new DecimalFormat("#########0.#");

    /**
     * 格式化金额区间,以(万)为单位,用“-”隔开,如1-1.5代表 [10000,15000)之间的任意借款金额
     *
     * @param amount 金额
     * @return 0.5-1
     */
    public static String getAmountRange(double amount) {
        int a = (int) amount / 5000;
        return String.format("%s-%s", df.format(a * 0.5), df.format((a + 1) * 0.5));
    }

    /**
     * 将逾期日期转换为M(X), X=1,2..N, X=roundup(逾期天数/30)，如逾期10天=M(1)
     * @param overdueDate 逾期日期
     * @return NORMAL 正常,M(X)
     */
    public static String getOverdueMonth(Date overdueDate) {
        int dayDiff = Days.daysBetween(new DateTime(overdueDate).withTimeAtStartOfDay(), DateTime.now()).getDays();
        return getOverdueMonth(dayDiff);
    }

    /**
     * 将逾期天数转换为M(X), X=1,2..N, X=roundup(逾期天数/30)，如逾期10天=M(1)
     * @param overdueDays 逾期天数
     * @return NORMAL 正常,M(X)
     */
    public static String getOverdueMonth(int overdueDays) {
        if (overdueDays <= 0) {
            return "NORMAL";
        }
        return String.format("M(%s)", new BigDecimal(overdueDays).divide(new BigDecimal(30),0, RoundingMode.UP));
    }
}
