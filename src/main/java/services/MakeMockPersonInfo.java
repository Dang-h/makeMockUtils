package services;


import constants.Constants;

import static utils.RandomNum.getRandomNum;

public class MakeMockPersonInfo {


	/**
	 * <h2>性别</h2>
	 */
	public static String gender;

	/**
	 * <h2>生成人员姓名和性别</h2>
	 * <h2>姓名</h2>
	 */
	public static String makeChineseName() {

		int index = getRandomNum(0, Constants.LASTNAME.length() - 1);
		// 姓
		String lastName = Constants.LASTNAME.substring(index, index + 1);
		int sex = getRandomNum(0, 1);

		// 名
		String firstName = Constants.BOY;
		int firstNameCount = Constants.BOY.length();

		// 性别
		if (sex == 0) {
			firstName = Constants.GIRL;
			firstNameCount = Constants.GIRL.length();
			gender = "女";
		} else {
			gender = "男";
		}

		index = getRandomNum(0, firstNameCount - 1);
		String second = firstName.substring(index, index + 1);
		int hasThird = getRandomNum(0, 1);
		String third = "";
		if (hasThird == 1) {
			index = getRandomNum(0, firstNameCount - 1);
			third = firstName.substring(index, index + 1);
		}
		return lastName + second + third;
	}


	/**
	 * <h2>生成指定长度邮箱</h2>
	 *
	 * @param num 邮箱最大长度
	 * @return
	 */


	/**
	 * <h2>生成手机号码</h2>
	 *
	 * @return tel
	 */
	public static String makeTel() {

		int index = getRandomNum(0, Constants.TEL_PRE.length - 1);
		String first = Constants.TEL_PRE[index];
		String second = String.valueOf(getRandomNum(1, 9999) + 10000).substring(1);
		String third = String.valueOf(getRandomNum(1, 9999) + 10000).substring(1);
		return first + second + third;
	}
}
