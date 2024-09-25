package utils;

import java.util.Date;

public class CommonUtils {
	
   public String getEmailWithTimeStamp() {
		
		Date date =  new Date();
		return "shweta.telka"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
		
		
	}


}
