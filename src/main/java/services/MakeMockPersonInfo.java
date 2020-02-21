package services;


import constants.Constants;

import java.util.ArrayList;
import java.util.UUID;

import static utils.CreateChineseName.*;
import static utils.CreateEmail.makeEmail;
import static utils.CreateIDNum.makeIDNum;
import static utils.CreateTel.makeTel;
import static utils.RandomNum.getRandomNum;

public class MakeMockPersonInfo {

	private static String gender;
	private static boolean male;

	private static String makeName() {

		int index = getRandomNum(0, Constants.LASTNAME.length() - 1);
		String lastName = Constants.LASTNAME.substring(index, index + 1);

		String firstName = Constants.BOY;
		int firstNameIndex = firstName.length();
		int genderIndex = getRandomNum(0, 999);

		if (genderIndex % 2 == 0) {
			firstName = Constants.GIRL;
			firstNameIndex = firstName.length();
			gender = Constants.GENDER[0];
			male = false;
		} else if (genderIndex % 2 == 1) {
			gender = Constants.GENDER[1];
			male = true;
		}

		index = getRandomNum(0, firstNameIndex - 1);

		return getName(lastName, firstName, firstNameIndex, index);
	}

	private static String makeID() {
		return makeIDNum(male);
	}

	/**
	 * <p>随机生成指定数量的人员信息</p>
	 * @param num 数量
	 */
	public static void getPersonInfo(int num) {
		for (int i = 0; i < num; i++) {
			System.out.println(getPersonInfo());
		}
	}


	private static ArrayList<Object> getPersonInfo() {

		ArrayList<Object> info = new ArrayList<>();

		info.add(makeId());
		info.add(makeName());
		info.add(gender);
		info.add(makeID());
		info.add(makeTel());
		info.add(makeEmail());

		return info;
	}

	private static String makeId() {
		String uuid = UUID.randomUUID().toString();
		return uuid.replace("-", "");
	}
}
