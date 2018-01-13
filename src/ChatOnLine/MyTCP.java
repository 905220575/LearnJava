/**
 * 
 */
package ChatOnLine;

import java.io.BufferedReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Administrator
 *
 */
public class MyTCP {
	private BufferedReader reader;
	private ServerSocket server;
	private Socket socket;
	void getserver(){
		try{
			server = new ServerSocket(8998);
		}
	}
}
