import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class test {
    public static void main(String[] args) {
        //初始化公司
        CompanyStock companyStock1 = new CompanyStock("1","code1",new BigDecimal(20),new BigDecimal(0));
        CompanyStock companyStock2 = new CompanyStock("2","code2",new BigDecimal(20),new BigDecimal(0));
        //天数
        int days = 5;
        Date now = new Date();
        for(int i = 0;i<days;i++) {
            Date date = DateUtil.addDate(now,5,i);
            companyStock1.oneDay(date);
            System.out.println(companyStock1);
            companyStock2.oneDay(date);
            System.out.println(companyStock2);
        }
        //总投入
        BigDecimal totalInput = new BigDecimal(0);
        //总资产
        BigDecimal totalMoney = new BigDecimal(100000);
        //可用资产
        BigDecimal availMoney = new BigDecimal(100000);
        //幅度
        BigDecimal ratio = new BigDecimal(0);
        //选购股票
        List<UserCompanyStock> stockList = new ArrayList<UserCompanyStock>();
        UserCompanyStock stock1 = new UserCompanyStock(companyStock1.getCode(),companyStock1,new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),0,0,new BigDecimal(0));
        UserCompanyStock stock2 = new UserCompanyStock(companyStock2.getCode(),companyStock2,new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),0,0,new BigDecimal(0));
        stockList.add(stock1);
        stockList.add(stock2);
        Account amount = new Account(totalInput,totalMoney,availMoney,ratio,stockList);
        amount.buy(2500,new BigDecimal(0),stock1,now);
        for(int i = 0;i<days;i++) {
            Date date = DateUtil.addDate(now,5,i);
            amount.buy(2500,new BigDecimal(-0.02),stock1,date);
        }
        //amount.getStockList()
        System.out.println(amount);
    }

}
