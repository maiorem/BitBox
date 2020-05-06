package Main_Menu;


import Ticket.TicketManager;

/*
 * 2020.05.05
 * 작성자 : 홍세영
 * 유저 위주의 인터페이스 작성 : 회원 가입, 로그인한 후 회원정보 수정, 탈퇴 등
 */
import user.InfoManager;
import user.MemberInfo;

public class Menu {

	InfoManager info = InfoManager.getInst();
	TicketManager tm = new TicketManager();

	void userMenu() {
		while (true) {
			System.out.println("=======새로운 공간에서 펼쳐지는 당신만의 이야기");
			System.out.println("BITBOX에 오신 것을 환영합니다=======");
			System.out.println("1. 회원가입하기");
			System.out.println("2. 로그인");
			System.out.println("===========================");
			int choice=info.sc.nextInt();
			info.sc.nextLine();
			if(choice==1) {
				info.creatId();
				continue;
			} else {
				while(true) {
					System.out.print("아이디를 입력하세요 : ");
					String id=adminLogin();
					System.out.print("패스워드를 입력하세요 :");
					String pw=info.sc.nextLine();
					if(!(info.login(id, pw))) {
						System.out.println("-------------------------");
						System.out.println("아이디와 패스워드가 일치하지 않습니다.\n다시 입력해주세요.");
						System.out.println("-------------------------");
						continue;
					} else {
						System.out.println("-------------------------");
						System.out.println(id+"님, 환영합니다!");
					}
					while (true) {
						System.out.println("--------------------------");
						System.out.println("1.예매하기");
						System.out.println("2.예매내역확인");
						System.out.println("3.회원정보확인"); //회원정보와 보유금액, 포인트 확인
						System.out.println("4.회원정보수정"); //회원정보 수정, 탈퇴.
						System.out.println("0.프로그램 종료");
						System.out.println("--------------------------");

						int num=info.sc.nextInt();
						info.sc.nextLine();

						switch(num) {
						case 1:
							//info.payment(id);
							break;
						case 2:
							//tm.showTicket(id);
							break;

						case 3:
							info.searchInfo(id);
							break;
						case 4:	
							System.out.println("1.회원정보수정");
							System.out.println("2.회원 탈퇴");
							int sel=info.sc.nextInt();
							info.sc.nextLine();
							if (sel==1) {
								info.editInfo(id);
								break;
							} else {
								System.out.println("정말로 탈퇴하시겠습니까? >> ");
								System.out.println("1.예    2.아니오");
								int del=info.sc.nextInt();
								info.sc.nextLine();
								if (del==1) {
									info.deleteInfo(id);
									System.out.println("그동안 이용해 주셔서 감사합니다!");
									System.exit(0);
									break;
								} else {
									System.out.println("처음으로 돌아갑니다.");
									continue;
								}
							}
						case 0:
							System.out.println("다시 만나요!");
							System.exit(0);
							break;

						}

					}
				}
			}
		}
	}

	//관리자 로그인
	String adminLogin() {
		String str=info.sc.nextLine();
		if(str.equals("admin")) {
							
				System.out.println("==========================");
				System.out.println("==관리자로 로그인 하셨습니다.==");
				System.out.println("==========================");
				System.out.println("1.예약 관리");
				System.out.println("2.상영관/시간표 관리");
				System.out.println("3.매출 관리");
				System.out.println("4.회원관리");
				System.out.println("0.프로그램 종료");
				System.out.println("---------------------------");
				int choice=info.sc.nextInt();
				info.sc.nextLine();
				switch(choice) {
				case 1 :
					
					break;
				case 2:
					
					break;
				case 3:
					
					break;
				case 4:
					
					break;
				
				case 0:
					System.out.println("관리자 프로그램을 종료합니다.");
					System.exit(0);
					break;
				}
			
			}
						
		
		return str;
	}
	
	
}
