package utils;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class GetIDInfo {

	/**
	 * 通过身份证号码获取出省市区代码、生日期、性别、年龄
	 *
	 * @param certificateNo 身份证号
	 * @return 返回的省市区代码：53-5301-530181	出生日期格式：1990-01-01   性别格式：F-女，M-男
	 */
	public static Map<String, String> getBirAgeSex(String certificateNo) {
		String native_place = "";
		String birthday = "";
		String age = "";
		String sexCode = "";

		int year = Calendar.getInstance().get(Calendar.YEAR);
		char[] number = certificateNo.toCharArray();
		boolean flag = true;

		if (number.length == 15) {
			for (char c : number) {
				if (!flag) {
					return new HashMap<String, String>();
				}
				flag = Character.isDigit(c);
			}
		} else if (number.length == 18) {
			for (int x = 0; x < number.length - 1; x++) {
				if (!flag) {
					return new HashMap<String, String>();
				}
				flag = Character.isDigit(number[x]);
			}
		}

		if (flag && certificateNo.length() == 15) {
			birthday = "19" + certificateNo.substring(6, 8) + "-"
					+ certificateNo.substring(8, 10) + "-"
					+ certificateNo.substring(10, 12);
			sexCode = Integer.parseInt(certificateNo.substring(certificateNo.length() - 3, certificateNo.length())) % 2 == 0 ? "F" : "M";
			age = (year - Integer.parseInt("19" + certificateNo.substring(6, 8))) + "";
		} else if (flag && certificateNo.length() == 18) {
			// 省市区代码
			native_place = certificateNo.substring(0, 2) + "-"
					+ certificateNo.substring(0, 4) + "-"
					+ certificateNo.substring(0, 6);
			// 生日
			birthday = certificateNo.substring(6, 10) + "-"
					+ certificateNo.substring(10, 12) + "-"
					+ certificateNo.substring(12, 14);
			// 性别
			sexCode = Integer.parseInt(certificateNo.substring(certificateNo.length() - 4, certificateNo.length() - 1)) % 2 == 0 ? "F" : "M";
			// 年龄
			age = (year - Integer.parseInt(certificateNo.substring(6, 10))) + "";
		}

		Map<String, String> map = new HashMap<String, String>();
		map.put("native_place", native_place);
		map.put("birthday", birthday);
		map.put("age", age);
		map.put("sexCode", sexCode);
		return map;
	}
}
