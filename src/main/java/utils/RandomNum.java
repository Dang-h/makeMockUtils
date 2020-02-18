package utils;

public class RandomNum {

	public static int getRandomNum(int start, int end) {
		return (int) (Math.random() * (end - start + 1) + start);
	}
}
