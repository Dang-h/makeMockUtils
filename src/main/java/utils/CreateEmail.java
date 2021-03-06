package utils;

import constants.Constants;

import static utils.RandomNum.getRandomNum;

public class CreateEmail {

	/**
	 * <p>随机生成邮箱</p>
	 *
	 * @return 邮箱
	 */
	public static String makeEmail() {

		int length = getRandomNum(6, Constants.EMAIL_PRE.length());

		if (length < 6 || length > 16) {
			length = 16;
		}

		return getEmail(length);
	}

	private static String getEmail(int length) {

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < length; i++) {
			int email_pre1 = (int) (Math.random() * Constants.EMAIL_PRE.length());
			sb.append(Constants.EMAIL_PRE.charAt(email_pre1));
		}
		sb.append(Constants.EMAIL_SUFFIX[(int) (Math.random() * Constants.EMAIL_SUFFIX.length)]);
		return sb.toString();
	}

	/**
	 * <P>随机生成指定长度的邮箱</P>
	 *
	 * @param num 邮箱长度，num<=32
	 * @return 邮箱
	 */
	public static String makeEmail(int num) {

		if (num < 6 || num > 16) {
			System.out.println("邮箱长度不合法！长度应在6-16；此时设置为最长16");
			num = 16;
		}

		int length = getRandomNum(6, num);

		return getEmail(length);
	}

	/**
	 * <p>生成指定用户名的邮箱</p>
	 * @param name 用户名
	 * @return 邮箱
	 */
	public static String makeEmail(String name) {

		int num = name.length();

		if (num < 6 || num > 16) {
			num = 16;
		}

		int length = getRandomNum(6, num);
		StringBuffer sb = new StringBuffer();
		sb.append(name);
		sb.append(Constants.EMAIL_SUFFIX[(int) (Math.random() * Constants.EMAIL_SUFFIX.length)]);
		return sb.toString();
	}
}
