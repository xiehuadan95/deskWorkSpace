import java.text.SimpleDateFormat;
import java.util.Date;

public class timestamp {
    public static void main(String[] args) {

        long timeMillis= System.currentTimeMillis();
        String tp =timeMillis+"";
        System.out.println("启动的时间："+tp);

        //获取时间戳
        Date date =new Date();
        //格式化日期格式
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        //格式化后的当前日期
        String nowdate =sdf.format(date);
        System.out.println("现在的日期"+nowdate);

        //格式化时间格式
        SimpleDateFormat sdf2= new SimpleDateFormat("HH:mm:ss");
        //格式化后的当前时间
        String stamp= sdf2.format(date);
        String timestamp2= stamp;
        System.out.println("时间："+timestamp2);
        String timestamp3=nowdate+"-"+timestamp2;
        System.out.println("格式化后的完整时间"+timestamp3);
        //将中间的符号去掉 只保留 数字
        String timestamp= timestamp3.replace("-", "").replace(":", "");

        System.out.println("时间戳："+timestamp3);
        System.out.println("最后的时间戳："+timestamp);

        long timeMillis2= System.currentTimeMillis();
        String tp2 =timeMillis2+"";
        System.out.println("结束的时间："+tp2);
        System.out.println("运行时间"+(timeMillis2-timeMillis));

    }
}
