import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Random;

public class RouteUtil {
    public static BigDecimal getRoute(BigDecimal HighestRoute, BigDecimal lowestRoute){
        BigDecimal rtn = lowestRoute .add(HighestRoute.subtract(lowestRoute).multiply(new BigDecimal(Math.random()))).setScale(4,BigDecimal.ROUND_HALF_UP);
        return rtn;
    }
    public static BigDecimal getRoute(){
        double number = (new Random().nextDouble()+new Random().nextInt(20) -9)/100;
        return new BigDecimal(number).setScale(4,BigDecimal.ROUND_HALF_UP);
    }


    public static void main(String[] args) {
        BigDecimal route1 = getRoute();
        BigDecimal route2 = getRoute();
        if(route1.compareTo(route2)==1) {
            BigDecimal route = getRoute(route1, route2);
            System.out.println("low:"+route2+",high:"+route1+",route:"+route);
        }else{
            BigDecimal route = getRoute(route2, route1);
            System.out.println("low:"+route1+",high:"+route2+",route:"+route);
        }

    }
}
