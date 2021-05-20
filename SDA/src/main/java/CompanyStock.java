import lombok.Data;

import java.math.BigDecimal;
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
        dailyCompanyStockList.add(stock);
    }

    @Override
    public String toString() {
        return "CompanyStock{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", price=" + price +
                ", route=" + route +
                ", dailyCompanyStockList=" + dailyCompanyStockList +
                '}';
    }
}
