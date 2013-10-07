import static org.junit.Assert.*;

import org.junit.Test;
import org.zeromq.ZMsg;

import freelance.Client;


public class FreelanceCase {

	private static final int NUM_OF_REQUESTS = 5000;
	
	@Test
	public void test() {
		//  Create new freelance client object
        Client client = new Client();

        //  Connect to several endpoints
        client.connect("tcp://localhost:5555");
        client.connect("tcp://localhost:5556");
        client.connect("tcp://localhost:5557");

        //  Send a bunch of name resolution 'requests', measure time
        int requests = NUM_OF_REQUESTS;
        long start = System.nanoTime();
        while (requests-- > 0) {
            ZMsg request = new ZMsg();
            request.add("random name");
            ZMsg reply = client.request(request);
            if (reply == null) {
                System.out.printf("E: name service not available, aborting\n");
                break;
            }
            reply.destroy();
        }
        System.out.printf("Average round trip cost: %d us\n",
                (int) (System.nanoTime() - start) / NUM_OF_REQUESTS / 1000);

        client.destroy();
	}

}
