import lombok.Data;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class CompanyStock {
    //公司名
    private String name;
    //公司编码
    private String code;
    //价格
    private BigDecimal price;
    //幅度
    private BigDecimal route;
    //开盘价
    private BigDecimal todayStartPrice;
    //收盘价
    private BigDecimal todayEndPrice;
    //最高价
    private BigDecimal todayHighestPrice;
    //最低价
    private BigDecimal todayLowestPrice;
    //幅度
    private BigDecimal todayRoute;
    //最高幅度
    private BigDecimal todayHighestRoute;
    //最低幅度
    private BigDecimal todayLowestRoute;

    private List<DailyCompanyStock> dailyCompanyStockList;

    /*public CompanyStock(int days,BigDecimal initPrice,String name,String code){
        Date now = new Date();
        for(int i = 0;i<days;i++){
            Date date = DateUtil.addDate(now,5,i);
            Route route = new Route();
            DailyCompanyStock stock = new DailyCompanyStock(name,code,initPrice,route.getRoute(),route.getHighestRoute(),route.getLowestRoute(),date);
            dailyCompanyStockList.add(stock);
        }
    }*/

    public CompanyStock(){};

    public CompanyStock(String name,String code,BigDecimal initPrice,BigDecimal route){
        this.name = name;
        this.code = code;
        this.price = initPrice;
        this.route = route;
        List<DailyCompanyStock> list = new ArrayList<DailyCompanyStock>();
        this.dailyCompanyStockList = list;
    }
    public void oneDay(Date now){
        //Date date = DateUtil.addDate(now,5,1);
        Route route1 = new Route();
        DailyCompanyStock stock = new DailyCompanyStock(name,code,price,route1.getRoute(),route1.getHighestRoute(),route1.getLowestRoute(),now);
        price = stock.getEndPrice();
        route = route.add(stock.getRoute()) ;
        todayStartPrice = stock.getStartPrice();
        todayEndPrice = stock.getEndPrice();
        todayHighestPrice = stock.getHighestPrice();
        todayLowestPrice = stock.getLowestPrice();
        todayRoute = stock.getRoute();
        todayHighestRoute = stock.getHighestRoute();
        todayLowestRoute = stock.getLowestRoute();
        dailyCompanyStockList.add(stock);
    }

    public DailyCompanyStock getByDate(Date now){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String time = format.format(now);
        for (DailyCompanyStock stock : dailyCompanyStockList) {
            if(time.equals(stock.getDate())){
                return stock;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "CompanyStock{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", price=" + price +
                ", route=" + route +
                ", todayStartPrice=" + todayStartPrice +
                ", todayEndPrice=" + todayEndPrice +
                ", todayHighestPrice=" + todayHighestPrice +
                ", todayLowestPrice=" + todayLowestPrice +
                ", todayRoute=" + todayRoute +
                ", todayHighestRoute=" + todayHighestRoute +
                ", todayLowestRoute=" + todayLowestRoute +
                ", dailyCompanyStockList=" + dailyCompanyStockList +
                '}';
    }
}
