import org.junit.jupiter.api.Test;

import static services.MakeMockPersonInfo.makeChineseName;
import static services.MakeMockPersonInfo.makeEmail;

class TestMethod {

	@Test
	void testName(){
		for (int i = 0; i < 10; i++) {
		System.out.print(makeChineseName() + " ");

		}
	}

	@Test
	void testEmail(){
		for (int i = 0; i < 10; i++) {
			System.out.print(makeEmail(7) + " ");
		}
	}
}
