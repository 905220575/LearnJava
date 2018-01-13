/**
 * 
 */
package TCP;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

/**
 * @author Administrator
 *
 */
public class Client extends JFrame {

	private PrintWriter writer;
	Socket socket;
	
	private JTextArea ta = new JTextArea();
	private JTextField tf = new JTextField();
	
	Container cc;
	
	private BufferedReader reader;
	
	public Client(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cc = this.getContentPane();
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(ta);
		cc.add(tf, "South");
		tf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				writer.println(tf.getText());
				ta.append('\n' + "发送：" + tf.getText() + '\n');
				ta.setSelectionEnd(ta.getText().length());
				tf.setText("");
			}
		});
	}
	
	private void connect() {
		ta.append("尝试连接\n");
		try {
			socket = new Socket("127.0.0.1", 8998);
			writer = new PrintWriter(socket.getOutputStream(),true);
			ta.append("完成连接");
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			getClientMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void getClientMessage() {
		try {
			while (true) {
				ta.append("服务器：" + reader.readLine());
				writer = new PrintWriter(socket.getOutputStream(),true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (reader != null) {
				reader.close();
			}
			if (socket != null) {
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Client client = new Client("向服务器发送数据");
		client.setSize(200, 200);
		client.setVisible(true);
		client.connect();
	}

}
