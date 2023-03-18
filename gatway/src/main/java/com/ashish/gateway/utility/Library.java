package com.ashish.gateway.utility;

public class Library {
	public static String getAmountConvertFromPaiseToRs(String strValue) {
		if(strValue!=null && !strValue.equals("")) {
			return ""+Float.parseFloat(strValue.trim())/100;
		}
		return "0";
	}
	public static Float getFloatValue(String strValue) {
	if(strValue!=null && !strValue.equals("")) {
		try {
			return  Float.parseFloat(strValue.trim());
		}catch(Exception ex) {
			ex.printStackTrace();
			}
	}
	return 0f;
}
	public static int getIntValue(String strValue) {
		if(strValue!=null && !strValue.equals("")) {
			try {
				return Integer.parseInt(strValue.trim());
			}catch(Exception ex) {
				ex.printStackTrace();
				}
		}
		return 0;
	}
	public static String trimAndRemoveSpecialCharacter(String str) throws Exception {
		if (str != null && !str.equals("")) {
			str = str.trim();
		}
		if (str != null) {
			str = str.replaceAll("'", "");
		}
		return str;
	}

	public static String toLowerCase(String str) throws Exception {
		if (str != null && !str.equals("")) {
			str = str.toLowerCase().trim();
		}
		return str;
	}

}
