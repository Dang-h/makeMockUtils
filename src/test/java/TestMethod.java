import org.junit.jupiter.api.Test;
import utils.CreateTel;


//import static services.MakeMockPersonInfo.makeTel;
import static services.MakeMockPersonInfo.getPersonInfo;
import static utils.CreateChineseName.gender;
import static utils.CreateChineseName.makeChineseName;
import static utils.CreateEmail.makeEmail;
import static utils.CreateIDNum.makeIDNum;
import static utils.CreateTel.makeTel;

class TestMethod {

	@Test
	void testName() {
		for (int i = 0; i < 10; i++) {
//		System.out.print(makeChineseName() + " " + gender  + " ");
		System.out.print(makeChineseName("党") + " " + gender  + " ");

//			System.out.print('|');
//			System.out.print(makeChineseName(true) + " ");
//			System.out.print('|');
//			System.out.print(makeChineseName("党") + " ");

		}
	}

	@Test
	void testEmail() {
		for (int i = 0; i < 10; i++) {
//			System.out.print(makeEmail(7) + " ");
			System.out.println(makeEmail(18));
//			System.out.println(makeEmail("54danghao"));
		}
	}
//	@Test
//	void testTel(){
//		for (int i = 0; i < 10; i++) {
//			System.out.print(makeTel() + " ");
//		}
//	}

	@Test
	void testID() {
		for (int i = 0; i < 10; i++) {
			System.out.println(makeIDNum("19491001"));
//			System.out.println(makeIDNum(1,2,false));
		}
	}

	@Test
	void testTel(){
		for (int i = 0; i < 10; i++) {
			System.out.println(CreateTel.makeTel(176));;
		}
	}

	@Test
	void testMakeInfo(){
		getPersonInfo(10);
	}




}
