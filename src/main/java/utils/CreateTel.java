package utils;

import constants.Constants;

import static utils.RandomNum.getRandomNum;

public class CreateTel {

	/**
	 * <p>随机生成手机号码</p>
	 *
	 * @return 手机号码
	 */
	public static String getTel() {

		int index = getRandomNum(0, Constants.TEL_PRE.length - 1);

		String first = Constants.TEL_PRE[index];
		String second = String.valueOf(getRandomNum(1, 9999) + 10000).substring(1);
		String third = String.valueOf(getRandomNum(1, 9999) + 10000).substring(1);

		return first + second + third;
	}

	/**
	 * <p>指定前三位随机生成手机号码</p>
	 *
	 * @param tel_pre 前三位：176/135/。。。
	 * @return 手机号
	 */
	public static String getTel(int tel_pre) {

		String first = "" + tel_pre;
		String second = String.valueOf(getRandomNum(1, 9999) + 10000).substring(1);
		String third = String.valueOf(getRandomNum(1, 9999) + 10000).substring(1);

		return first + second + third;
	}

	public static String getTel(String tel_pre) {

		int telPre = Integer.parseInt(tel_pre);

		String first = "" + telPre;
		String second = String.valueOf(getRandomNum(1, 9999) + 10000).substring(1);
		String third = String.valueOf(getRandomNum(1, 9999) + 10000).substring(1);

		return first + second + third;
	}

}
