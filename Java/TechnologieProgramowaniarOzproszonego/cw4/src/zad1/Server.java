/**
 *
 *  @author Prystupa Piotr S12463
 *
 */

package zad1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;


public class Server implements Runnable{
	private final int port;
	private ByteBuffer buff = ByteBuffer.allocate(255);
	private ServerSocketChannel serverSocketChannel;
	private Selector selector;

	
	public static void main(String[] args) throws IOException {
		Server server = new Server(10111);
		Thread serverThread = new Thread(server);
		serverThread.start();
	}

	public Server(int port) throws IOException {
		this.port = port;
		this.serverSocketChannel = ServerSocketChannel.open();
		this.serverSocketChannel.socket().bind(new InetSocketAddress(port));
		this.serverSocketChannel.configureBlocking(false);
		this.selector = Selector.open();
		this.serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
	}



	@Override
	public void run() {
		try {
			System.out.println("Czat biega. Dostepny pod portem:\n" + this.port);

			Iterator<SelectionKey> iter;
			SelectionKey key;
			while(this.serverSocketChannel.isOpen()) {
				selector.select();
				iter=this.selector.selectedKeys().iterator();
				while(iter.hasNext()) {
					key = iter.next();
					iter.remove();

					if(key.isAcceptable()) 
						this.accept(key);
					if(key.isReadable()) 
						this.read(key);
				}
			}
		} catch(IOException e) {
			System.out.println("IOException, server of port " +this.port+ " terminating. Stack trace:");
			e.printStackTrace();
		}

	}
	
	private void accept(SelectionKey key) throws IOException {
		SocketChannel sc = ((ServerSocketChannel) key.channel()).accept();
		String address = (new StringBuilder(sc.socket().getInetAddress().toString())).append(":")
				.append(sc.socket().getPort()).toString().substring(1);
		sc.configureBlocking(false);
		sc.register(selector, SelectionKey.OP_READ, address);
		System.out.println("polaczono z: " + address);
	}
	
	private void read(SelectionKey key) throws IOException {
		SocketChannel ch = (SocketChannel) key.channel();
		StringBuilder sb = new StringBuilder();

		buff.clear();
		int read = 0;
		while( (read = ch.read(buff)) > 0 ) {
			buff.flip();
			byte[] bytes = new byte[buff.limit()];
			buff.get(bytes);
			sb.append(new String(bytes));
			buff.clear();
		}
		String msg;
		if(read<0) {
			msg = key.attachment()+" opuscil czat.\n";
			ch.close();
		}
		else {
			msg = key.attachment()+": "+sb.toString();
		}
		send2All(msg);
	}
	private void send2All(String msg) throws IOException {
		ByteBuffer msgBuf=ByteBuffer.wrap(msg.getBytes());
		for(SelectionKey key : selector.keys()) {
			if(key.isValid() && key.channel() instanceof SocketChannel) {
				SocketChannel sch=(SocketChannel) key.channel();
				sch.write(msgBuf);
				msgBuf.rewind();
			}
		}
	}
}
