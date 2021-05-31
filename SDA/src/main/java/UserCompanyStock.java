import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserCompanyStock {
    private String code;
    private CompanyStock companyStock;
    //总投入
    private BigDecimal totalInput;
    //总资产
    private BigDecimal totalMoney;
    //可用
    private BigDecimal availMoney;
    //可用
    private int availNum;
    //总数
    private int totalNum;
    //幅度
    private BigDecimal ratio;

    public UserCompanyStock(){

    }

    public UserCompanyStock(String code,CompanyStock companyStock, BigDecimal totalInput, BigDecimal totalMoney, BigDecimal availMoney, int availNum, int totalNum, BigDecimal ratio) {
        this.code = code;
        this.companyStock = companyStock;
        this.totalInput = totalInput;
        this.totalMoney = totalMoney;
        this.availMoney = availMoney;
        this.availNum = availNum;
        this.totalNum = totalNum;
        this.ratio = ratio;
    }

}
