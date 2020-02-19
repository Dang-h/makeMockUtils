import org.junit.jupiter.api.Test;


import static services.MakeMockPersonInfo.makeTel;
import static utils.CreateChineseName.makeChineseName;
import static utils.CreateEmail.makeEmail;
import static utils.CreateIDNum.makeIDNum;

class TestMethod {

	@Test
	void testName(){
		for (int i = 0; i < 10; i++) {
//		System.out.print(makeChineseName() + " ");
		System.out.print(makeChineseName(false) + " ");

		}
	}

	@Test
	void testEmail(){
		for (int i = 0; i < 10; i++) {
//			System.out.print(makeEmail(7) + " ");
//			System.out.println(makeEmail());
			System.out.println(makeEmail("54danghao"));
		}
	}
	@Test
	void testTel(){
		for (int i = 0; i < 10; i++) {
			System.out.print(makeTel() + " ");
		}
	}

	@Test
	void testID(){
		for (int i = 0; i < 10; i++) {
			System.out.println(makeIDNum(1) );
		}
	}




}
