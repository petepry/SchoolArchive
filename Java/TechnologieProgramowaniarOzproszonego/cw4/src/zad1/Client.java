package zad1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JTextField;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Client {

	private int port;

	private ByteBuffer writeBuffer;
	private ByteBuffer readBuffer;
	private SocketChannel channel;
	private String host;
	private Selector readSelector;
	private Thread readNshowThread;
	private boolean running;


	// GUI
	private JFrame frmNioczat;
	private JTextField textField_port;
	private JTextField txtLocalhost;
	private JTextArea textArea;
	private JTextField txtField_msg;
	private JLabel lblHost;
	private JLabel lblPort;
	private JLabel lblWiadomosc;
	private JButton buttonConnect;
	private JButton buttonSend;
	private JButton buttonDisconnect;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client window = new Client();
					window.frmNioczat.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Client() {
		initialize();
		writeBuffer = ByteBuffer.allocateDirect(255);
		readBuffer = ByteBuffer.allocateDirect(255);
	}

	private void connect() {
		try {
			textArea.setText("");
			readSelector = Selector.open();
			InetAddress addr = InetAddress.getByName(host);
			channel = SocketChannel.open(new InetSocketAddress(addr, port));
			channel.configureBlocking(false);
			channel.register(readSelector, SelectionKey.OP_READ, new StringBuffer());
		}

		catch (Exception e) {
		}
	}

	private void readAllFrom() {
		try {

			readSelector.selectNow();
			Set<SelectionKey> readyKeys = readSelector.selectedKeys();

			Iterator<SelectionKey> i = readyKeys.iterator();
			while (i.hasNext()) {
				SelectionKey key = (SelectionKey) i.next();
				i.remove();
				SocketChannel channel = (SocketChannel) key.channel();
				readBuffer.clear();
				StringBuilder sb = new StringBuilder();

				while( (channel.read(readBuffer)) > 0 ) {
					readBuffer.flip();
					byte[] bytes = new byte[readBuffer.limit()];
					readBuffer.get(bytes);
					sb.append(new String(bytes));
					readBuffer.clear();
				}
				String msg = key.attachment()+": "+sb.toString();

				//				System.out.println(msg);
				textArea.append(msg);
			}

		}
		catch (IOException ioe) {
		}
		catch (Exception e) {
		}
	}

	private void sendMessage(String mesg) {
		prepWriteBuffer(mesg);
		channelWrite(channel, writeBuffer);
	}

	private void prepWriteBuffer(String mesg) {
		writeBuffer.clear();
		writeBuffer.put(mesg.getBytes());
		writeBuffer.putChar('\n');
		writeBuffer.flip();
	}

	private void channelWrite(SocketChannel channel, ByteBuffer writeBuffer) {
		long nbytes = 0;
		long toWrite = writeBuffer.remaining();

		try {
			while (nbytes != toWrite) {
				nbytes += channel.write(writeBuffer);
				try {
					Thread.sleep(10L);
				}
				catch (InterruptedException e) {}
			}
		}
		catch (ClosedChannelException cce) {
		}
		catch (Exception e) {
		} 

		writeBuffer.rewind();
	}


	private void initialize() {
		frmNioczat = new JFrame();
		frmNioczat.setTitle("NIOczat");
		frmNioczat.setBounds(100, 100, 478, 344);
		frmNioczat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frmNioczat.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{107, 114, 0, 114, 0};
		gbl_panel.rowHeights = new int[]{19, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		lblHost = new JLabel("host:");
		GridBagConstraints gbc_lblHost = new GridBagConstraints();
		gbc_lblHost.insets = new Insets(0, 0, 5, 5);
		gbc_lblHost.anchor = GridBagConstraints.EAST;
		gbc_lblHost.gridx = 0;
		gbc_lblHost.gridy = 0;
		panel.add(lblHost, gbc_lblHost);

		txtLocalhost = new JTextField();
		txtLocalhost.setText("localhost");
		GridBagConstraints gbc_txtLocalhost = new GridBagConstraints();
		gbc_txtLocalhost.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtLocalhost.insets = new Insets(0, 0, 5, 5);
		gbc_txtLocalhost.gridx = 1;
		gbc_txtLocalhost.gridy = 0;
		panel.add(txtLocalhost, gbc_txtLocalhost);
		txtLocalhost.setColumns(10);

		lblPort = new JLabel("port:");
		GridBagConstraints gbc_lblPort = new GridBagConstraints();
		gbc_lblPort.insets = new Insets(0, 0, 5, 5);
		gbc_lblPort.anchor = GridBagConstraints.EAST;
		gbc_lblPort.gridx = 0;
		gbc_lblPort.gridy = 1;
		panel.add(lblPort, gbc_lblPort);

		textField_port = new JTextField();
		textField_port.setText("10111");
		GridBagConstraints gbc_textField_port = new GridBagConstraints();
		gbc_textField_port.insets = new Insets(0, 0, 5, 5);
		gbc_textField_port.anchor = GridBagConstraints.NORTHWEST;
		gbc_textField_port.gridx = 1;
		gbc_textField_port.gridy = 1;
		panel.add(textField_port, gbc_textField_port);
		textField_port.setColumns(10);

		buttonConnect = new JButton("zaloguj");
		buttonConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				host = txtLocalhost.getText();
				port = Integer.parseInt(textField_port.getText());
				connect();
				Runnable readNshow = new Runnable() {
					public void run() {
						running = true;
						while (running) {
							readAllFrom();
							try {
								Thread.sleep(66);
							}
							catch (InterruptedException ie) {
							}
						}

					}
				};

				readNshowThread = new Thread (readNshow);
				readNshowThread.start();

			}
		});
		GridBagConstraints gbc_btnPolcz = new GridBagConstraints();
		gbc_btnPolcz.insets = new Insets(0, 0, 5, 5);
		gbc_btnPolcz.gridx = 0;
		gbc_btnPolcz.gridy = 2;
		panel.add(buttonConnect, gbc_btnPolcz);

		buttonDisconnect = new JButton("wyloguj");
		buttonDisconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					channel.close();
					readSelector.close();
				} catch (IOException exx) {
					exx.printStackTrace();
				}
				running = false;
				readNshowThread.interrupt();
				textArea.setText("\n Wylogowano...");
			}
		});
		GridBagConstraints gbc_buttonDisconnect = new GridBagConstraints();
		gbc_buttonDisconnect.insets = new Insets(0, 0, 5, 5);
		gbc_buttonDisconnect.gridx = 1;
		gbc_buttonDisconnect.gridy = 2;
		panel.add(buttonDisconnect, gbc_buttonDisconnect);

		lblWiadomosc = new JLabel("wiadomość:");
		GridBagConstraints gbc_lblWiadomosc = new GridBagConstraints();
		gbc_lblWiadomosc.insets = new Insets(0, 0, 5, 5);
		gbc_lblWiadomosc.anchor = GridBagConstraints.EAST;
		gbc_lblWiadomosc.gridx = 0;
		gbc_lblWiadomosc.gridy = 3;
		panel.add(lblWiadomosc, gbc_lblWiadomosc);

		txtField_msg = new JTextField();
		txtField_msg.setText("Dobry dzien");
		GridBagConstraints gbc_txtField_msg = new GridBagConstraints();
		gbc_txtField_msg.insets = new Insets(0, 0, 5, 5);
		gbc_txtField_msg.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtField_msg.gridx = 1;
		gbc_txtField_msg.gridy = 3;
		panel.add(txtField_msg, gbc_txtField_msg);
		txtField_msg.setColumns(10);

		buttonSend = new JButton("wyślij");
		buttonSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendMessage(txtField_msg.getText());
				txtField_msg.setText("");
			}
		});
		GridBagConstraints gbc_btnWylij = new GridBagConstraints();
		gbc_btnWylij.insets = new Insets(0, 0, 5, 5);
		gbc_btnWylij.gridx = 2;
		gbc_btnWylij.gridy = 3;
		panel.add(buttonSend, gbc_btnWylij);

		textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridwidth = 4;
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 4;
//		panel.add(textArea, gbc_textArea);
		JScrollPane scroll = new JScrollPane (textArea);
//		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel.add(scroll, gbc_textArea);
	}

}
