package trng.imcs.threads;

public class ThreadApp {

	public static void main(String[] args) {
		ThreadsReadData t1=new ThreadsReadData("C:\\Temp\\Employee1.csv");
		ThreadsReadData t2=new ThreadsReadData("C:\\Temp\\Employee2.csv");
		t1.start();
		t2.start();
		
	}

}
