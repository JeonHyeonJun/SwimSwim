package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import protocol.Account;
import protocol.Message;

public class AccountServer implements Runnable {
	private AccountService service;
	private Socket socket;
	private ObjectOutputStream out;
	private ObjectInputStream in;

	public AccountServer(Socket socket) {
		// TODO Auto-generated constructor stub
		service = new AccountService();
		this.socket = socket;
		try {
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			boolean run = true;
			while (run) {
				Message message = (Message) in.readObject();
				if (message.getCode() == 1001) {
					String ano = (String) message.getParams().get("ANO");
					String name = (String) message.getParams().get("OWNER");
					int bal = (int) message.getParams().get("BALANCE");
					int result = service.createAccount(ano, name, bal);
					Message sendMsg = new Message();
					if (result == 1)
						sendMsg.setCode(1101);
					else if(result == 2)
						sendMsg.setCode(1201);
					else if(result == 3)
						sendMsg.setCode(1301);
					out.writeObject(sendMsg);
					out.flush();
					out.reset();
				} else if(message.getCode() == 2001){
					List<Account> list = service.accountList();
					Message sendMsg = new Message();
					sendMsg.setCode(2101);
					
					Map<String, Object> params = new HashMap<>();
					params.put("LIST", list);
					sendMsg.setParams(params);
					out.writeObject(sendMsg);
					out.flush();
					out.reset();
				} else if(message.getCode() == 3001){
					String ano = (String) message.getParams().get("ANO");
					int bal = (int) message.getParams().get("BALANCE");
					
					int result = service.deposit(ano, bal);
					Message sendMsg = new Message();
					if(result == 1)
						sendMsg.setCode(3101);
					else if(result == 2)
						sendMsg.setCode(3102);
					else if(result == 3)
						sendMsg.setCode(3103);
					out.writeObject(sendMsg);
					out.flush();
					out.reset();
				} else if(message.getCode() == 3002){
					String ano = (String) message.getParams().get("ANO");
					int bal = (int) message.getParams().get("BALANCE");
					
					int result = service.withdraw(ano, bal);
					Message sendMsg = new Message();
					if(result == 1)
						sendMsg.setCode(3201);
					else if(result == 2)
						sendMsg.setCode(3202);
					else if(result == 3)
						sendMsg.setCode(3203);
					else if(result == 4)
						sendMsg.setCode(3204);
					out.writeObject(sendMsg);
					out.flush();
					out.reset();
				} else if(message.getCode() == 3003){
					String ano = (String) message.getParams().get("ANO");
					String ano2 = (String) message.getParams().get("ANO2");
					int bal = (int) message.getParams().get("BALANCE");
					
					int result = service.transit(ano, ano2, bal);
					Message sendMsg = new Message();
					if(result == 1)
						sendMsg.setCode(3301);
					else if(result == 2)
						sendMsg.setCode(3302);
					else if(result == 3)
						sendMsg.setCode(3303);
					else if(result == 4)
						sendMsg.setCode(3304);
					out.writeObject(sendMsg);
					out.flush();
					out.reset();
				} else if(message.getCode() == 4001){
					String ano = (String) message.getParams().get("ANO");
					
					int result = service.delete(ano);
					Message sendMsg = new Message();
					if(result == 1)
						sendMsg.setCode(4101);
					else if(result == 2)
						sendMsg.setCode(4102);
					out.writeObject(sendMsg);
					out.flush();
					out.reset();
				} else if(message.getCode() == 9999){
					run = false;
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
