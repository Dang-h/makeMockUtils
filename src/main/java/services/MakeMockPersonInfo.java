package services;


import constants.Constants;

import java.util.ArrayList;
import java.util.UUID;

import static utils.CreateChineseName.gender;
import static utils.CreateChineseName.makeChineseName;
import static utils.CreateEmail.makeEmail;
import static utils.CreateIDNum.makeIDNum;
import static utils.CreateTel.makeTel;
import static utils.RandomNum.getRandomNum;

public class MakeMockPersonInfo {

	public static void getPersonInfo(int num){
		for (int i = 0; i < num; i++) {
			System.out.println(getPersonInfo());
		}
	}

	private static ArrayList<Object> getPersonInfo() {

		ArrayList<Object> info = new ArrayList<>();

		info.add(makeId());
		info.add(makeChineseName());
		info.add(gender);
		info.add(makeIDNum());
		info.add(makeTel());
		info.add(makeEmail());

		return info;
	}

	private static String makeId() {
		String uuid = UUID.randomUUID().toString();
		return uuid.replace("-", "");
	}
}
