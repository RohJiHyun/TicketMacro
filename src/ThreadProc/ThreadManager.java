package ThreadProc;

public class ThreadManager {

	Thread keyInputDetector;
	Thread serverTimeChecker;
	
	
	public ThreadManager() {
		serverTimeChecker = new Thread(new Runnable() {
			public void run() {
				
			}
		});
	}

}
