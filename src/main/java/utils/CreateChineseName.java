package utils;

import constants.Constants;

import java.util.concurrent.CompletionService;

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
}
