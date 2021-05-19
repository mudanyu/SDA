import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Random;

public class RouteUtil {
    public static Double getRoute(Double HighestRoute,Double lowestRoute){
        Double rtn = lowestRoute + (Double)(Math.random() * (HighestRoute - lowestRoute));
        NumberFormat nf = NumberFormat.getNumberInstance();
        // 保留两位小数
        nf.setMaximumFractionDigits(2);
        // 如果不需要四舍五入，可以使用RoundingMode.DOWN
        nf.setRoundingMode(RoundingMode.UP);
        String str = nf.format(rtn);
        return Double.valueOf(str);
    }
    public static Double getRoute(){
        double number = new Random().nextDouble()+new Random().nextInt(20) -9;
        NumberFormat nf = NumberFormat.getNumberInstance();
        // 保留两位小数
        nf.setMaximumFractionDigits(2);
        // 如果不需要四舍五入，可以使用RoundingMode.DOWN
        nf.setRoundingMode(RoundingMode.UP);
        String str = nf.format(number);
        return Double.valueOf(str);
    }


    public static void main(String[] args) {
        Double route1 = getRoute();
        Double route2 = getRoute();
        if(route1>route2) {
            Double route = getRoute(route1, route2);
            System.out.println("low:"+route2+",high:"+route1+",route:"+route);
        }else{
            Double route = getRoute(route2, route1);
            System.out.println("low:"+route1+",high:"+route2+",route:"+route);
        }

    }
}
