/**
 * 
 */
package TCP;

import java.awt.BorderLayout;
import java.awt.Color;
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
public class Server extends JFrame {

	private PrintWriter writer;
	
	private JTextArea ta = new JTextArea();
	private JTextField tf = new JTextField();
	
	Container cc;
	
	private BufferedReader reader;
	private ServerSocket server;
	private Socket socket;
	
	public Server(String title) {
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
	
	void getserver() {
		try {
			server = new ServerSocket(8998);
			ta.append("服务套接字已经创建成功！" + '\n');
			while (true) {
				ta.append("等待客户机的连接\n");
				socket = server.accept();
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				getClientMessage();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void getClientMessage() {
		try {
			while (true) {
				ta.append("客户机：" + reader.readLine());
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
		Server server = new Server("向客户机发送数据");
		server.setSize(200,200);
		server.setVisible(true);
		server.getserver();
	}

}
