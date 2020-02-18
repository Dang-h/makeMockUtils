package services;


import constants.Constants;

import static utils.RandomNum.getRandomNum;

public class MakeMockPersonInfo {


	/**
	 * <h2>性别</h2>
	 */
	public static String gender;

	/**
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
	 *
	 * @param num 邮箱最大长度
	 * @return
	 */
	public static String makeEmail(int num) {

		if (num < 6 || num > 64) {
			System.out.println("邮箱长度不合法！长度应在6-64；此时设置为64");
			num = 64;
		}

		int length = getRandomNum(6, num);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int email_pre1 = (int) (Math.random() * Constants.EMAIL_PRE.length());
			sb.append(Constants.EMAIL_PRE.charAt(email_pre1));
		}
		sb.append(Constants.EMAIL_SUFFIX[(int) (Math.random() * Constants.EMAIL_SUFFIX.length)]);
		return sb.toString();
	}


}
