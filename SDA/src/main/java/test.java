import java.math.BigDecimal;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        Account amount = new Account();
        CompanyStock companyStock1 = new CompanyStock("1","code1",new BigDecimal(20),new BigDecimal(0));
        CompanyStock companyStock2 = new CompanyStock("2","code2",new BigDecimal(20),new BigDecimal(0));
        int days = 5;
        Date now = new Date();
        for(int i = 0;i<days;i++) {
            Date date = DateUtil.addDate(now,5,i);
            companyStock1.oneDay(date);
            System.out.println(companyStock1);
        }
    }
}
