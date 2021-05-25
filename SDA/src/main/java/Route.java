import lombok.Data;

import java.math.BigDecimal;

@Data
public class Route {
    private BigDecimal Route;
    private BigDecimal highestRoute;
    private BigDecimal lowestRoute;
    public Route(){

        BigDecimal route1 = RouteUtil.getRoute();
        BigDecimal route2 = RouteUtil.getRoute();
        if(route1.compareTo(route2)==1) {
            highestRoute = route1;
            lowestRoute = route2;
        }else{
            highestRoute = route2;
            lowestRoute = route1;
        }
        Route = RouteUtil.getRoute(highestRoute,lowestRoute);
    }
}
