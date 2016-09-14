package zad1;

import java.awt.EventQueue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;

public class Main implements MessageListener{
	//GUI
	JFrame frmCzatjms;
	private JTextField txtHello;
	private JTextArea textArea;
	
	//LOGIC RELATED
	public static Context ctx;
	public static Connection con;
	public static ConnectionFactory factory;
	public static Session session;
	public static MessageProducer sender;
	public static MessageConsumer receiver; 


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmCzatjms.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
		initConnection();
	}

	public void initConnection() {
		try{
			ctx = new InitialContext();
			factory = (ConnectionFactory) ctx.lookup("ConnectionFactory");
			String admDestName = "topic1";
			Destination dest = (Destination) ctx.lookup(admDestName);
			con = factory.createConnection();
			session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
			receiver = session.createConsumer(dest);
			receiver.setMessageListener(this);
			sender = session.createProducer(dest);
			con.start();
			
		} catch (Exception ex){
			System.out.println("Connection initialization exception\n");
			ex.printStackTrace();}
	}
	
	@Override
	public void onMessage(Message msg) {
		try {
			TextMessage text = (TextMessage) msg;
			textArea.append(text.getText() + "\n\n");
			
		} catch (JMSException e) {e.printStackTrace();}
	}
	public void sendMessage(String text) {
		TextMessage msg;
		try {
			msg = session.createTextMessage();
			msg.setText(text);
			sender.send(msg);
			
		} catch (JMSException e) {e.printStackTrace();}
	}
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCzatjms = new JFrame();
		frmCzatjms.setTitle("czatJMS");
		frmCzatjms.setBounds(100, 100, 325, 358);
		frmCzatjms.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCzatjms.addWindowListener(new WindowAdapter() {
		      public void windowClosing(WindowEvent e) {
		        try { 
		        	con.close(); 
		        } catch(Exception exc) {exc.printStackTrace();}
		        frmCzatjms.dispose();
		        System.exit(0);
		      }
		    });
		
		JPanel panel = new JPanel();
		frmCzatjms.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtHello = new JTextField();
		txtHello.setText("hello");
		txtHello.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtHello.setBounds(10, 31, 229, 34);
		panel.add(txtHello);
		txtHello.setColumns(10);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.setBounds(10, 76, 229, 39);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendMessage(txtHello.getText());
				txtHello.setText("");
			}
		});
		panel.add(btnNewButton);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(10, 146, 289, 162);
		panel.add(textArea);
		
		JLabel lblWriteHere = new JLabel("write here:");
		lblWriteHere.setBounds(10, 11, 70, 14);
		panel.add(lblWriteHere);
		
		JLabel lblNewLabel = new JLabel("czat:");
		lblNewLabel.setBounds(10, 126, 46, 14);
		panel.add(lblNewLabel);
	}


}
