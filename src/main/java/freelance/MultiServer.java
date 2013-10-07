package freelance;

public class MultiServer {

	public static void main(String[] args) {
	  
        Thread serverThread = new Thread() {
            public void run() {
                Server.main(new String[] { "5555", "-v" });
            }
        };
        serverThread.start();
        
        Thread serverThread2 = new Thread() {
            public void run() {
                Server.main(new String[] { "5556", "-v" });
            }
        };
        serverThread2.start();
        
        Thread serverThread3 = new Thread() {
            public void run() {
                Server.main(new String[] { "5557", "-v" });
            }
        };
        serverThread3.start();
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
  
	}
}
