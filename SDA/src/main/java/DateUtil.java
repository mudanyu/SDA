import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    /**
     * 对指定日期进行添加操作
     * @param date  日期
     * @param addType   1表示添加年,2表示添加月,5表示添加日,11表示添加小时,12<br/>
     *                  表示添加分,13表示添加秒<br/>
     * @param addValue  添加值
     * @return newDateTime  新添加后的日期格式为YYYY-MM-DD HH:MM:SS,如果添加失败返回null
     */
    public  static Date addDate(Date date, int addType, int addValue){
        Calendar cal=Calendar.getInstance();
        Date returnDate = null;
        try{
            cal.setTime(date);
            cal.add(addType,addValue);
            returnDate = cal.getTime();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return returnDate;
    }
}
