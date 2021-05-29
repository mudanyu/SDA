import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Account {
    //总投入
    private BigDecimal totalInput;
    //总资产
    private BigDecimal totalMoney;
    //可用资产
    private BigDecimal availMoney;
    //幅度
    private BigDecimal ratio;
    //选购股票
    private List<UserCompanyStock> stockList;

    public Account() {
    }

    public Account(BigDecimal totalInput, BigDecimal totalMoney, BigDecimal availMoney, BigDecimal ratio, List<UserCompanyStock> stockList) {
        this.totalInput = totalInput;
        this.totalMoney = totalMoney;
        this.availMoney = availMoney;
        this.ratio = ratio;
        this.stockList = stockList;
    }

    //买入
    public void buy(int num ,BigDecimal route,UserCompanyStock userCompanyStock){
        CompanyStock companyStock = userCompanyStock.getCompanyStock();
        if(!(route.compareTo(companyStock.getTodayHighestRoute())==1||route.compareTo(companyStock.getTodayLowestRoute())==-1)){
            BigDecimal buyPrice = route.add(new BigDecimal(1)).multiply(companyStock.getTodayStartPrice());
            BigDecimal buyTotalPrice = buyPrice.multiply(new BigDecimal(num));
            if(availMoney.compareTo(buyTotalPrice)==-1){

            }else{
                userCompanyStock.setTotalNum(userCompanyStock.getTotalNum()+num);
                totalInput = totalInput.add(buyTotalPrice);
                availMoney = availMoney.subtract(buyTotalPrice);
                totalMoney = companyStock.getTodayEndPrice().multiply(new BigDecimal(userCompanyStock.getTotalNum()));
                ratio = getRatio();
            }
        }
    }
    //卖出
    public void sell(int num,BigDecimal route,UserCompanyStock userCompanyStock){
        CompanyStock companyStock = userCompanyStock.getCompanyStock();
        if(!(route.compareTo(companyStock.getTodayHighestRoute())==1||route.compareTo(companyStock.getTodayLowestRoute())==-1)){
            BigDecimal sellPrice = route.add(new BigDecimal(1)).multiply(companyStock.getTodayStartPrice());
            BigDecimal sellTotalPrice = sellPrice.multiply(new BigDecimal(num));
            if(userCompanyStock.getAvailNum()<num){

            }else {

                userCompanyStock.setTotalNum(userCompanyStock.getTotalNum() - num);
                totalInput = totalInput.subtract(sellTotalPrice);
                availMoney = availMoney.subtract(sellTotalPrice);
                totalMoney = companyStock.getTodayEndPrice().multiply(new BigDecimal(userCompanyStock.getTotalNum()));
                ratio = getRatio();
            }
        }
    }

    public BigDecimal getRatio(){
        return totalMoney.divide(totalInput, 4, BigDecimal.ROUND_HALF_UP).subtract(new BigDecimal(1)).setScale(4,BigDecimal.ROUND_HALF_UP);
    }

    public static void main(String[] args) {
        BigDecimal a = (new BigDecimal(31009).divide(new BigDecimal(40082), 4, BigDecimal.ROUND_HALF_UP)).subtract(new BigDecimal(1)).setScale(4,BigDecimal.ROUND_HALF_UP);
        System.out.println(a);
    }

}
