package utils;

import constants.Constants;
import static utils.RandomNum.getRandomNum;

public class CreateChineseName {

	public static String gender;

	private static void setGender(String gender) {
		CreateChineseName.gender = gender;
	}

	/**
	 * <p>随机生成姓名</p>
	 *
	 * @return 姓名
	 */
	public static String makeChineseName() {

		int index = getRandomNum(0, Constants.LASTNAME.length() - 1);

		// 姓
		String lastName = Constants.LASTNAME.substring(index, index + 1);
		// 名
		String firstName = Constants.BOY;
		int firstNameIndex = firstName.length();
		int sex = getRandomNum(0, 1);

		if (sex == 0) {
			firstName = Constants.GIRL;
			firstNameIndex = firstName.length();
			setGender(Constants.GENDER[sex]);
		} else {
			setGender(Constants.GENDER[sex]);
		}

		index = getRandomNum(0, firstNameIndex - 1);
		return getName(lastName, firstName, firstNameIndex, index);
	}

	/**
	 * <p>自定义性别随机生成姓名</p>
	 *
	 * @param male true：男；false：女
	 * @return 姓名
	 */
	public static String makeChineseName(Boolean male) {

		int index = getRandomNum(0, Constants.LASTNAME.length() - 1);

		// 姓
		String lastName = Constants.LASTNAME.substring(index, index + 1);
		// 名
		String firstName = Constants.BOY;
		int firstNameIndex = firstName.length();

		if (!male) {
			firstName = Constants.GIRL;
			firstNameIndex = firstName.length();
			setGender(Constants.GENDER[0]);
		} else {
			setGender(Constants.GENDER[1]);
		}

		index = getRandomNum(0, firstNameIndex - 1);
		return getName(lastName, firstName, firstNameIndex, index);
	}

	/**
	 * <p>自定义姓氏随机生成姓名</p>
	 *
	 * @param lastName 姓氏
	 * @return 姓名
	 */
	public static String makeChineseName(String lastName) {

		// 名
		String firstName = Constants.BOY;
		int firstNameIndex = firstName.length();
		int sex = getRandomNum(0, 1);

		if (sex == 0) {
			firstName = Constants.GIRL;
			firstNameIndex = firstName.length();
			setGender(Constants.GENDER[sex]);
		} else {
			setGender(Constants.GENDER[sex]);
		}

		int index = getRandomNum(0, firstNameIndex - 1);

		return getName(lastName, firstName, firstNameIndex, index);
	}

	/**
	 * @param lastName       姓
	 * @param firstName      名1
	 * @param firstNameIndex 名2
	 * @param index          是否有名2
	 * @return 姓名
	 */
	private static String getName(String lastName, String firstName, int firstNameIndex, int index) {
		String second = firstName.substring(index, index + 1);
		int hasThird = getRandomNum(0, 1);
		String third = "";

		if (hasThird == 1) {
			index = getRandomNum(0, firstNameIndex - 1);
			third = firstName.substring(index, index + 1);
		}

		return lastName + second + third;
	}

}
