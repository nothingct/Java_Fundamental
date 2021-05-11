package java_20210511.step5;

public class StopWatchManager {
//singleton 만들기 : private 생성자를 사용하는 이유
	private static StopWatchManager single;

	private StopWatchManager() {
	};

	public static StopWatchManager getInstance() {
		if (single == null) {
			single = new StopWatchManager();
		}
		return single;
	}
	public void run(StopWatch s) {
		s.execute();
	}
}
