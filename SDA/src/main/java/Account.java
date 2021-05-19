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
    private Double ratio;
    //选购股票
    private List<CompanyStock> stockList;

    public Account() {
    }

    public Account(BigDecimal totalInput, BigDecimal totalMoney, BigDecimal availMoney, Double ratio, List<CompanyStock> stockList) {
        this.totalInput = totalInput;
        this.totalMoney = totalMoney;
        this.availMoney = availMoney;
        this.ratio = ratio;
        this.stockList = stockList;
    }
}
