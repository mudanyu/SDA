import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class DailyCompanyStock {
    //公司名
    private String name;
    //公司编码
    private String code;
    //开盘价
    private BigDecimal startPrice;
    //收盘价
    private BigDecimal endPrice;
    //最高价
    private BigDecimal highestPrice;
    //最低价
    private BigDecimal lowestPrice;
    //幅度
    private BigDecimal route;
    //最高幅度
    private BigDecimal highestRoute;
    //最低幅度
    private BigDecimal lowestRoute;
    //日期
    private String date;

    public DailyCompanyStock() {
    }

    public DailyCompanyStock(String name, String code, BigDecimal startPrice, BigDecimal route, BigDecimal highestRoute, BigDecimal lowestRoute, Date date) {
        this.name = name;
        this.code = code;
        this.startPrice = startPrice;
        this.route = route;
        this.highestRoute = highestRoute;
        this.lowestRoute = lowestRoute;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String time = format.format(date);
        this.date = time;
        endPrice = startPrice.multiply(route.add(new BigDecimal(1))).setScale(2, RoundingMode.HALF_UP);
        highestPrice = startPrice.multiply(highestRoute.add(new BigDecimal(1))).setScale(2, RoundingMode.HALF_UP);
        lowestPrice = startPrice.multiply(lowestRoute.add(new BigDecimal(1))).setScale(2, RoundingMode.HALF_UP);
    }
}
