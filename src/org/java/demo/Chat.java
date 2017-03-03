package org.java.demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Chat extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextPane textPane;
	private JTextPane textPane_1;
	private boolean flag = false;
	private JTextField txtJony;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat frame = new Chat();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Chat() {
		setTitle("微信");

		ServerThread server = new ServerThread();
		server.start();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textPane = new JTextPane();
		textPane.setBounds(10, 10, 572, 299);
		contentPane.add(textPane);

		textField = new JTextField();
		textField.setText("192.168.14.135");
		textField.setBounds(627, 22, 122, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblIp = new JLabel("IP");
		lblIp.setBounds(595, 25, 22, 15);
		contentPane.add(lblIp);

		JLabel lblPort = new JLabel("PORT");
		lblPort.setBounds(595, 52, 29, 15);
		contentPane.add(lblPort);

		textField_1 = new JTextField();
		textField_1.setText("5899");
		textField_1.setBounds(628, 49, 122, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel label = new JLabel("消息");
		label.setBounds(22, 365, 54, 15);
		contentPane.add(label);

		textPane_1 = new JTextPane();
		textPane_1.setBounds(56, 343, 463, 69);
		contentPane.add(textPane_1);

		JButton button = new JButton("发送");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String msg = textPane_1.getText();
					String ip = textField.getText();
					Integer port = Integer.parseInt(textField_1.getText());
					String nickName = txtJony.getText().trim();
					
					Socket sk = new Socket(ip, port);
					OutputStreamWriter out = new OutputStreamWriter(sk.getOutputStream());
					out.write(nickName +":"+ msg);

					out.close();

					String old = textPane.getText().trim();
					old += "\r\n" + nickName +" 说：" + msg;
					textPane.setText(old);
					
					textPane_1.setText("");

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		button.setBounds(528, 346, 116, 66);
		contentPane.add(button);
		
		JLabel lblNickname = new JLabel("NickName");
		lblNickname.setBounds(592, 92, 116, 15);
		contentPane.add(lblNickname);
		
		txtJony = new JTextField();
		txtJony.setText("Jony");
		txtJony.setBounds(627, 117, 122, 21);
		contentPane.add(txtJony);
		txtJony.setColumns(10);
	}

	public class ServerThread extends Thread {
		@Override
		public void run() {
			try {
				ServerSocket server = new ServerSocket(4899);
				while (true) {
					Thread.sleep(500);
					Socket socked = server.accept();
					BufferedReader reader = new BufferedReader(new InputStreamReader(socked.getInputStream()));
					String msg = reader.readLine().trim();
					reader.close();
					String old = textPane.getText().trim();
					old += "\r\n" +msg.substring(0, msg.indexOf(":")) +" 说：" + msg.substring(msg.indexOf(":")+1, msg.length());
					textPane.setText(old);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
