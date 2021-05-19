import lombok.Data;

import java.math.BigDecimal;
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
    private Double route;
    //最高幅度
    private Double highestRoute;
    //最低幅度
    private Double lowestRoute;
    //日期
    private Date date;

    public DailyCompanyStock() {
    }

    public DailyCompanyStock(String name, String code, BigDecimal startPrice, Double route, Double highestRoute, Double lowestRoute, Date date) {
        this.name = name;
        this.code = code;
        startPrice = startPrice;
        this.route = route;
        highestRoute = highestRoute;
        lowestRoute = lowestRoute;
        this.date = date;
        endPrice = startPrice.multiply(new BigDecimal(1+route));
        highestPrice = startPrice.multiply(new BigDecimal(1+highestRoute));
        lowestPrice = startPrice.multiply(new BigDecimal(1+lowestRoute));
    }
}
