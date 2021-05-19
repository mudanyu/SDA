import lombok.Data;

import java.util.List;

@Data
public class CompanyStock {
    private List<DailyCompanyStock> dailyCompanyStockList;
}
