package br.com.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
*
* @since 18/10/201
* @author jleme
*/
public class MissaoCenaUtil {

	public static Timestamp convertStrToTimestamp(String dataStr) {
		Timestamp timestamp = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
			java.util.Date parsedDate = dateFormat.parse(dataStr);
			timestamp = new java.sql.Timestamp(parsedDate.getTime());
		} catch (Exception e) { // this generic but you can control nother types of exception
			System.err.println(e.getMessage());
		}
		return timestamp;
	}

	public static String convertTimestampToString(Timestamp dataVisita) {
        String dateConvert = dataVisita.toString();		
		return dateConvert;
	}

	public static String getDataHojeString() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = new java.util.Date();
		String today = df.format(date);
		return today;
	}

	public static Timestamp getDataHojeTimestamp() {
		Timestamp hoje = new Timestamp(System.currentTimeMillis());
		return hoje;
	}
	
	/*public static void main(String[] args) {
		Timestamp dataDeHoje = new Timestamp(System.currentTimeMillis());
		System.out.println(convertTimestampToString(dataDeHoje));
	}
*/
}
