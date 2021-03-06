package implementation;

public class Consumer extends Thread {

	private static String keyword;

	public static void setKeyword(String key) {
		keyword = key;
	}

	public static String getKeyword() {
		return keyword;
	}

	@Override
	public void run() {
		while (!ProductFactory.getInstance().isProducingFinished() || !ProductFactory.getInstance().isEmpty()) {
			LineDTO data = ProductFactory.getInstance().get();
			if (data.getLine().contains(keyword)) {
				System.out.println(data.toString());
			}
		}
	}
}
