package utils;

import constants.Constants;

import static utils.RandomNum.getRandomNum;

public class CreateChineseName {

	/**
	 * <p>随机生成姓名</p>
	 *
	 * @return 姓名
	 */
	public static String makeChineseName() {
		String gender;

		int index = getRandomNum(0, Constants.LASTNAME.length() - 1);
		// 姓
		String lastName = Constants.LASTNAME.substring(index, index + 1);
		int sex = getRandomNum(0, 1);

		// 名
		String firstName = Constants.BOY;
		int firstNameCount = Constants.BOY.length();

		return getName(lastName, firstName, firstNameCount, sex);
	}

	/**
	 * <p>生成名字</p>
	 *
	 * @param lastName       姓
	 * @param firstName      名1
	 * @param firstNameCount 名2
	 * @param gender         性别
	 * @return 姓名
	 */
	private static String getName(String lastName, String firstName, int firstNameCount, int gender) {
		int index;
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
	 * <p>按性别生成姓名</p>
	 *
	 * @param male false为女性
	 * @return 姓名
	 */
	public static String makeChineseName(Boolean male) {

		int index = getRandomNum(0, Constants.LASTNAME.length() - 1);
		// 姓
		String lastName = Constants.LASTNAME.substring(index, index + 1);

		// 名
		String firstName = Constants.BOY;
		int firstNameCount = Constants.BOY.length();

		// 性别
		String gender;
		if (!male) {
			firstName = Constants.GIRL;
			firstNameCount = Constants.GIRL.length();
			gender = "女";
		} else {
			gender = "男";
		}

		return getName(lastName, firstName, firstNameCount, firstNameCount);
	}

	/**
	 * <p>指定姓氏随机生成姓名</p>
	 * @param lastName 姓氏
	 * @return 姓名
	 */
	public static String makeChineseName(String lastName) {

		int index = getRandomNum(0, Constants.LASTNAME.length() - 1);

		// 名
		String firstName = Constants.BOY;
		int firstNameCount = Constants.BOY.length();

		// 性别
		String gender;
		int sex = getRandomNum(0, 1);
		return getName(lastName, firstName, firstNameCount, sex);
	}

}
