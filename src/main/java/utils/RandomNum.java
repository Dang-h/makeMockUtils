package utils;

public class RandomNum {

	/**
	 * <p>生成指定范围内的伪随机数</p>
	 *
	 * @param min 最小值
	 * @param max 最大值
	 * @return
	 */
	public static int getRandomNum(int min, int max) {
		return (int) (Math.random() * (max - min + 1) + min);
	}

	public static long getRandomNum(long min, long max) {
		return (long) (Math.random() * (max - min + 1) + min);
	}
}
