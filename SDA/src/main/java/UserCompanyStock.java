import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserCompanyStock {
    private CompanyStock companyStock;
    //总投入
    private BigDecimal totalInput;
    //总资产
    private BigDecimal totalMoney;
    //可用
    private int availNum;
    //总数
    private int totalNum;
    //幅度
    private Double ratio;

    //买入
    public void buy(int num ,Double route){

    }
    //卖出
}
