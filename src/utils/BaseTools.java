package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class BaseTools{

	public static String getDate() throws Exception {
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		return df.format(new Date());
	}
	
	public static String getRandomNum() throws Exception {
		Random r = new Random();
		int s = r.nextInt(10000);
		String result = Integer.toString(s);
		return result;
	}
	
}
