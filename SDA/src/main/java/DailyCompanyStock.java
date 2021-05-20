import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
    private Date date;

    public DailyCompanyStock() {
    }

    public DailyCompanyStock(String name, String code, BigDecimal startPrice, BigDecimal route, BigDecimal highestRoute, BigDecimal lowestRoute, Date date) {
        this.name = name;
        this.code = code;
        startPrice = startPrice;
        this.route = route;
        highestRoute = highestRoute;
        lowestRoute = lowestRoute;
        this.date = date;
        endPrice = startPrice.multiply(route.add(new BigDecimal(1))).setScale(2, RoundingMode.HALF_UP);
        highestPrice = startPrice.multiply(highestRoute.add(new BigDecimal(1))).setScale(2, RoundingMode.HALF_UP);
        lowestPrice = startPrice.multiply(lowestRoute.add(new BigDecimal(1))).setScale(2, RoundingMode.HALF_UP);
    }
}
