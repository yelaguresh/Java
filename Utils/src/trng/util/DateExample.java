package trng.util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


/**
 * @author Manohar
 *
 */
public class DateExample {
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String args[]) {
		Date mydate = new Date();
		System.out.println("Current Date: " + mydate);
		
		String ddMMyyyyFormat = "dd-MM-yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(ddMMyyyyFormat);
		System.out.println(" Today date in format " + ddMMyyyyFormat + " : " + sdf.format(mydate));
		
		
		String mmddyyyyFormat = "MM/dd/yyyy hh:mm:ss";
		SimpleDateFormat sdff = new SimpleDateFormat(mmddyyyyFormat);
		System.out.println(sdff.format(mydate));

		
		calendarUsage();
		
		dateParsing();
	}

	
	private static void calendarUsage() {
		Calendar calendar = Calendar.getInstance();
		//update a date
		calendar.set(Calendar.YEAR, 2014);
		calendar.set(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 30);
		
		calendar.set(Calendar.HOUR, 11);
		calendar.set(Calendar.MINUTE, 11);
		calendar.set(Calendar.SECOND, 30);
		Date date = calendar.getTime();
		System.out.println(" Date constrcuted through calendar is: " + date);
	}

	private static void dateParsing() {
		String ddMMyyyyFormat = "dd-MM-yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(ddMMyyyyFormat);
		String strDate = "12-09-2009";
		try {
			Date date1 = sdf.parse(strDate);
			System.out.println("Parsed Date : " + date1);
			
			long ms = date1.getTime();
			java.sql.Date sqlDate = new java.sql.Date(ms);
			System.out.println("SQL Date is : " + date1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
