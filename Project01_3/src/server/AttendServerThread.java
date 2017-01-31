package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import protocol.Message;
import protocol.Subject;

public class AttendServerThread implements Runnable {
	private AttendService service;
	private Socket socket;
	private ObjectOutputStream out;
	private ObjectInputStream in;

	public AttendServerThread(Socket socket) {
		// TODO Auto-generated constructor stub
		service = new AttendService();
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
		boolean run = true;
		int fail = 1;
		while (run) {
			try {
				Message rMsg = (Message) in.readObject();
				if (rMsg.getCode() == 100) {
					String id = (String) rMsg.getParams().get("ID");
					String ps = (String) rMsg.getParams().get("PASSWORD");
					boolean st_result = service.st_login(id, ps);

					Message sMsg = new Message();
					if (st_result) {
						sMsg.setCode(101);
						List<Subject> list = service.st_subjectlist(id, ps);
						Map<String, Object> params = new HashMap<>();
						params.put("LIST", list);
						sMsg.setParams(params);
						out.writeObject(sMsg);
						out.flush();
						out.reset();

						rMsg = (Message) in.readObject();
						if (rMsg.getCode() == 110) {
							String subnum = (String) rMsg.getParams().get("SUBNUM");
							boolean st_result2 = service.st_subjectselect(id, ps, subnum);
							sMsg = new Message();
							if (st_result2) {
								sMsg.setCode(111);
								out.writeObject(sMsg);
								out.flush();
								out.reset();

								while (run) {
									rMsg = (Message) in.readObject();
									if (rMsg.getCode() == 120) {
										int num = (int) rMsg.getParams().get("ATT");
										int st_result3 = service.st_attend(subnum, num, fail);
										sMsg = new Message();
										params = new HashMap<>();
										
										if(st_result3 == 1){
											sMsg.setCode(121);
											int a = service.attendsuccess(id, ps, subnum);
											params.put("SUCCESS", a);
											sMsg.setParams(params);
											run = false;
										} else if(st_result3 == 2){
											fail++;
											sMsg.setCode(122);
										} else if(st_result3 == 3){
											sMsg.setCode(123);
											run = false;
										}
										out.writeObject(sMsg);
										out.flush();
										out.reset();
									}
								}
							} else {
								sMsg.setCode(112);
								out.writeObject(sMsg);
								out.flush();
								out.reset();
							}
						}
					} else {
						sMsg.setCode(102);
						out.writeObject(sMsg);
						out.flush();
						out.reset();
					}
				}
				//교수
				else if(rMsg.getCode() == 200){
					String id = (String) rMsg.getParams().get("ID");
					String ps = (String) rMsg.getParams().get("PASSWORD");
					boolean pr_result = service.pr_login(id, ps);

					Message sMsg = new Message();
					if (pr_result) {
						sMsg.setCode(201);
						List<Subject> list = service.pr_subjectlist(id, ps);
						Map<String, Object> params = new HashMap<>();
						params.put("LIST", list);
						sMsg.setParams(params);
						out.writeObject(sMsg);
						out.flush();
						out.reset();

						rMsg = (Message) in.readObject();
						if (rMsg.getCode() == 210) {
							String subnum = (String) rMsg.getParams().get("SUBNUM");
							boolean pr_result2 = service.pr_subjectselect(id, ps, subnum);
							sMsg = new Message();
							if (pr_result2) {
								int answer = service.pr_attend(subnum);
								params = new HashMap<>();
								sMsg.setCode(211);
								params.put("ATTNUM", answer);
								sMsg.setParams(params);
								out.writeObject(sMsg);
								out.flush();
								out.reset();		
							} else {
								sMsg.setCode(212);
								out.writeObject(sMsg);
								out.flush();
								out.reset();
							}
						}
					} else {
						sMsg.setCode(202);
						out.writeObject(sMsg);
						out.flush();
						out.reset();
					}
				} else if(rMsg.getCode() == 300){
					run = false;
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
