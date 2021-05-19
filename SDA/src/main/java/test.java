import java.math.BigDecimal;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        Account amount = new Account();
        CompanyStock companyStock1 = new CompanyStock();
        CompanyStock companyStock2 = new CompanyStock();
        Date now = new Date();
        int days = 5;
        BigDecimal initPrice = new BigDecimal(20);
        for(int i = 0;i<days;i++){
            Date date = DateUtil.addDate(now,5,i);
            DailyCompanyStock stock = new DailyCompanyStock("1","code1",initPrice,5.00,7.00,2.00,date);

        }
    }
}
