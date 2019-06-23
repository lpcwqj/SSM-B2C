package conversion;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Lin
 * @Date 2019/6/21
 *
 *
 *  S:页面传递过来的数据
 *  T:转换后的类型
 *
 *  该方法是用于用户输入指定下面格式的日期形式后，页面依然能看明白，并转成jsp页面中设置的pattern
 *
 */

public class DateConversion implements Converter<String,Date> {
    @Override
    public Date convert(String s) {
        try{
            if (null != s){
                SimpleDateFormat dateFormat = new SimpleDateFormat
                        ("EEE MMM dd HH:mm:ss 格林尼治标准时间+0800 yyyy",Locale.ENGLISH);
                return dateFormat.parse(s);
            }
        }
        catch (Exception e){
            e.getStackTrace();
        }
        return null;
    }
}
