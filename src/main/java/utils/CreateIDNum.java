package utils;

import constants.Constants;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import static utils.CreateChineseName.gender;
import static utils.RandomNum.getRandomNum;

/**
 * <p>生成模拟身份证号</p>
 *
 * <p>18位身份证号码各位的含义:</p>
 * <p>1. 1-2位省、自治区、直辖市代码；</p>
 * <P>2. 3-4位地级市、盟、自治州代码；</P>
 * <P>3. 5-6位县、县级市、区代码；</P>
 * <P>4. 7-14位出生年月日，比如19670401代表1967年4月1日；</P>
 * <P>5. 15-17位为顺序号，其中17位（倒数第二位）男为单数，女为双数；</P>
 * <P>6. 18位为校验码，0-9和X。</P>
 */
public class CreateIDNum {

	/**
	 * <P>随机生成身份证号</P>
	 *
	 * @return 身份证号
	 */
	public static String makeIDNum() {
		int genderNum = getRandomNum(1, 2);
		boolean male = true;
		if (genderNum == 2) {
			male = false;
		}
		return makeIDNum(male);
	}

	/**
	 * <p>按性别随机生成身份证号</p>
	 *
	 * @param male 性别
	 * @return 身份证号
	 */
	public static String makeIDNum(boolean male) {

		//随机生成生日 1~99岁
		long begin = System.currentTimeMillis() - 3153600000000L;//100年内
		long end = System.currentTimeMillis() - 31536000000L; //1年内
		long rtn = getRandomNum(begin, end);
		Date date = new Date(rtn);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String birth = simpleDateFormat.format(date);

		return makeIDNum(birth, male);
	}

	/**
	 * <P>指定出生日期和性别随机生成身份证号</P>
	 *
	 * @param birth 出生日期：19491001
	 * @param male  性别
	 * @return 身份证号
	 */
	public static String makeIDNum(String birth, boolean male) {

		StringBuilder sb = new StringBuilder();
		int value = getRandomNum(0, Constants.ID_CITIES.length);

		sb.append(Constants.ID_CITIES[value]);
		sb.append(birth);

		return getGender(sb, male);
	}

	/**
	 * <p>指定出生日期随机生成身份证号</p>
	 *
	 * @param birth 出生日期：19491001
	 * @return 身份证号
	 */
	public static String makeIDNum(String birth) {

		StringBuilder sb = new StringBuilder();
		int value = getRandomNum(0, Constants.ID_CITIES.length);
		boolean male;

		sb.append(Constants.ID_CITIES[value]);
		sb.append(birth);

		int genderNum = getRandomNum(0, 1);
		male = genderNum != 0;

		return getGender(sb, male);
	}

	private static String getGender(StringBuilder sb, boolean male) {

		int value;
		value = getRandomNum(0, 999);
		if (male && value % 2 == 0) {
			value++;
			gender = Constants.GENDER[1];
		}
		if (!male && value % 2 == 1) {
			value++;
			gender = Constants.GENDER[0];
		}
		if (value >= 100) {
			sb.append(value);
		} else if (value >= 10) {
			sb.append('0').append(value);
		} else {
			sb.append("00").append(value);
		}

		sb.append(calcTrailingNumber(sb));

		return sb.toString();
	}

	/**
	 * <p>生成指定年龄段的身份证号</p>
	 *
	 * @param min 最小年龄
	 * @param max 最大年龄
	 * @return 身份证号
	 */
	public static String makeIDNum(int min, int max) {

		int genderNum = getRandomNum(1, 2);
		boolean male = true;
		if (genderNum % 2 == 0) {
			male = false;
		}

		SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");// 设置日期格式
		Calendar date = Calendar.getInstance();
		date.setTime(new Date());// 设置当前日期

		return getIDNum(min, max, male, dft, date);

	}

	/**
	 * @param min  年龄最小值
	 * @param max  年龄最大值
	 * @param male 性别
	 * @param dft  日期格式：yyyyMMdd
	 * @param date 当前日期
	 * @return 身份证号
	 */
	private static String getIDNum(int min, int max, boolean male, SimpleDateFormat dft, Calendar date) {

		int randomDay = 365 * min + new Random().nextInt(365 * (max - min));
		date.set(Calendar.DATE, date.get(Calendar.DATE) - randomDay);
		String birthDate = dft.format(date.getTime());

		return makeIDNum(birthDate, male);
	}


	/**
	 * <p>指定年龄段和性别生成随机身份证</p>
	 *
	 * @param min  年龄段最小值
	 * @param max  年龄段最大值
	 * @param male 性别
	 * @return 身份证号
	 */
	public static String makeIDNum(int min, int max, Boolean male) {

		if (!male) {
			male = false;
		}

		SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");// 设置日期格式
		Calendar date = Calendar.getInstance();
		date.setTime(new Date());// 设置当前日期

		return getIDNum(min, max, male, dft, date);

	}

	/**
	 * <p>按指定年龄随机生成身份证号</p>
	 *
	 * @param age 指定年龄
	 * @return 身份证号
	 */
	public static String makeIDNum(int age) {

		int genderNum = getRandomNum(1, 2);
		boolean male = true;
		if (genderNum % 2 == 0) {
			male = false;
		}

		SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");// 设置日期格式
		Calendar date = Calendar.getInstance();
		date.setTime(new Date());// 设置当前日期

		// 设置日期为age年的任意一天
		int randomDay;
		if (age == 1) {
			randomDay = getRandomNum(1, 365);
		} else {
			randomDay = getRandomNum((age - 1) * 365, age * 365);
		}
		date.set(Calendar.DATE, date.get(Calendar.DATE) - randomDay);
		String birthDate = dft.format(date.getTime());
		return makeIDNum(birthDate, male);

	}

	/**
	 * <p>第18位身份证验证</p>
	 *
	 * <h3>1.将前面的身份证号码17位数分别乘以不同的系数。从第一位到第十七位的系数分别为：7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2</h3>
	 * <h3>2.将这17位数字和系数相乘的结果相加。</h3>
	 * <h3>3.用加出来和除以11，看余数是多少？</h3>
	 * <h3>4.余数只可能有0 1 2 3 4 5 6 7 8 9 10这11个数字。其分别对应的最后一位身份证的号码为1 0 X 9 8 7 6 5 4 3 2。</h3>
	 * <h3>5.通过上面得知如果余数是2，就会在身份证的第18位数字上出现罗马数字的Ⅹ。如果余数是10，身份证的最后一位号码就是2。</h3>
	 */
	private static char calcTrailingNumber(StringBuilder sb) {

		int[] n = new int[17];
		int result = 0;

		for (int i = 0; i < n.length; i++) {
			n[i] = Integer.parseInt(String.valueOf(sb.charAt(i)));
		}
		for (int i = 0; i < n.length; i++) {
			result += Constants.ID_CALC_C[i] * n[i];
		}
		return Constants.ID_CALC_R[result % 11];
	}

}
