package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import protocol.Account;
import protocol.Message;

public class BankClientApplication {
	public static void main(String[] args) {
		Socket socket = null;
		ObjectOutputStream out = null;
		ObjectInputStream in = null;

		try {
			socket = new Socket("127.0.0.1", 5000);
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());
			Scanner scan = new Scanner(System.in);
			boolean run = true;
			
			while (run) {
				System.out.println("---------------------------------------------");
				System.out.println("1.계좌생성|2.계좌목록|3.예금|4.출금|5.이체|6.삭제|7.종료");
				System.out.println("---------------------------------------------");
				System.out.print("선택> ");
				int selectNo = scan.nextInt();
				
				if (selectNo == 1) {
					System.out.println("--------------");
					System.out.println("계좌 생성");
					System.out.println("--------------");

					System.out.print("계좌번호 : ");
					String ano = scan.next();
					System.out.print("계좌주 : ");
					String name = scan.next();
					System.out.print("초기 입금액 : ");
					int bal = scan.nextInt();
					Message sendMsg = new Message();
					sendMsg.setCode(1001);
					
					Map<String, Object> params = new HashMap<>();
					params.put("ANO", ano);
					params.put("OWNER", name);
					params.put("BALANCE", bal);
					sendMsg.setParams(params);
					
					out.writeObject(sendMsg);
					out.flush();
					out.reset();
					
					Message rMsg = (Message) in.readObject();
					if(rMsg.getCode() == 1101)
						System.out.println("계좌생성성공");
					else if(rMsg.getCode() == 1201)
						System.out.println("이미존재하는계좌");
					else if(rMsg.getCode() == 1301)
						System.out.println("입금액이음수");
				}
				else if (selectNo == 2){
					System.out.println("--------------");
					System.out.println("계좌목록");
					System.out.println("--------------");
					Message sMsg = new Message();
					sMsg.setCode(2001);
					out.writeObject(sMsg);
					out.flush();
					out.reset();
					Message rMsg = (Message)in.readObject();
					List<Account> list = (List<Account>) rMsg.getParams().get("LIST");
					for(int i= 0; i<list.size(); i++)
						System.out.println(list.get(i));
				}
				else if(selectNo == 3){
					System.out.println("--------------");
					System.out.println("예금");
					System.out.println("--------------");
					System.out.print("계좌번호 : ");
					String ano = scan.next();
					System.out.print("입금액 : ");
					int bal = scan.nextInt();
					Message sMsg = new Message();
					sMsg.setCode(3001);
					
					Map<String, Object> params = new HashMap<>();
					params.put("ANO", ano);
					params.put("BALANCE", bal);
					sMsg.setParams(params);
					out.writeObject(sMsg);
					out.flush();
					out.reset();
					
					Message rMsg = (Message)in.readObject();
					if(rMsg.getCode() == 3101)
						System.out.println("입금성공");
					else if(rMsg.getCode() == 3102)
						System.out.println("계좌없음");
					else if(rMsg.getCode() == 3103)
						System.out.println("입금액이음수");
				}
				else if(selectNo == 4){
					System.out.println("--------------");
					System.out.println("출금");
					System.out.println("--------------");
					System.out.print("계좌번호 : ");
					String ano = scan.next();
					System.out.print("출금액 : ");
					int bal = scan.nextInt();
					Message sMsg = new Message();
					sMsg.setCode(3002);
					
					Map<String, Object> params = new HashMap<>();
					params.put("ANO", ano);
					params.put("BALANCE", bal);
					sMsg.setParams(params);
					out.writeObject(sMsg);
					out.flush();
					out.reset();
					
					Message rMsg = (Message)in.readObject();
					if(rMsg.getCode() == 3201)
						System.out.println("출금성공");
					else if(rMsg.getCode() == 3202)
						System.out.println("계좌없음");
					else if(rMsg.getCode() == 3203)
						System.out.println("출금액이음수");
					else if(rMsg.getCode() == 3204)
						System.out.println("잔액부족");
				}
				else if(selectNo == 5){
					System.out.println("--------------");
					System.out.println("이체");
					System.out.println("--------------");
					System.out.print("이체할 계좌번호 : ");
					String ano = scan.next();
					System.out.print("이체받을 계좌번호 : ");
					String ano2 = scan.next();
					System.out.print("출금액 : ");
					int bal = scan.nextInt();
					Message sMsg = new Message();
					sMsg.setCode(3003);
					
					Map<String, Object> params = new HashMap<>();
					params.put("ANO", ano);
					params.put("ANO2", ano2);
					params.put("BALANCE", bal);
					sMsg.setParams(params);
					out.writeObject(sMsg);
					out.flush();
					out.reset();
					
					Message rMsg = (Message)in.readObject();
					if(rMsg.getCode() == 3301)
						System.out.println("이체성공");
					else if(rMsg.getCode() == 3302)
						System.out.println("계좌없음");
					else if(rMsg.getCode() == 3303)
						System.out.println("이체액이음수");
					else if(rMsg.getCode() == 3304)
						System.out.println("잔액부족");
				}
				else if(selectNo == 6){
					System.out.println("--------------");
					System.out.println("삭제");
					System.out.println("--------------");
					System.out.print("계좌번호 : ");
					String ano = scan.next();
					
					Message sMsg = new Message();
					sMsg.setCode(4001);
					
					Map<String, Object> params = new HashMap<>();
					params.put("ANO", ano);
					sMsg.setParams(params);
					out.writeObject(sMsg);
					out.flush();
					out.reset();
					
					Message rMsg = (Message)in.readObject();
					if(rMsg.getCode() == 4101)
						System.out.println("삭제성공");
					else if(rMsg.getCode() == 4102)
						System.out.println("계좌없음");
				}
				else if(selectNo == 7){
					Message sMsg = new Message();
					sMsg.setCode(9999);
					out.writeObject(sMsg);
					out.flush();
					out.reset();
					run = false;
					System.out.println("종료합니당");
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null)
					out.close();
				if (in != null)
					in.close();
				if(socket != null)
					socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
