package user;

import java.util.HashMap;
import java.util.Scanner;

public class InfoManager {
	
	// 회원가입 (회원 추가)
	// 회원 탈퇴
	// 회원 수정
	// 로그인
	// 회원정보 출력 (회원정보+보유금액+포인트)
	
	HashMap<String, MemberInfo> member;
	public Scanner sc;
	
	// 싱글톤 화
	private InfoManager(){
		member = new HashMap<>();
		sc = new Scanner(System.in);
	}
	
	private static InfoManager manager = new InfoManager();

	// InfoManager 객체 생성할 땐 이 메서드를 들고가세여
	public static InfoManager getInst() {
		return manager;
	}
	
	// 회원 가입
	public void creatId() {
		
		MemberInfo member = null;
		String id=null, pw=null, name=null, phoneNum=null, email=null;
		
		System.out.println("아이디를 입력하세요 >> ");
		id=sc.nextLine();
		System.out.println("패스워드를 입력하세요 >> ");
		pw=sc.nextLine();
		System.out.println("이름을 입력하세요 >> ");
		name=sc.nextLine();
		System.out.println("전화번호를 입력하세요 >> ");
		phoneNum=sc.nextLine();
		System.out.println("이메일을 입력하세요 >> ");
		email=sc.nextLine();
		member=new MemberInfo(id, pw, name, phoneNum, email); 
		addInfo(id, member);
	}
	
	// 생성된 인스턴스를 추가
	void addInfo(String id, MemberInfo m) {
		member.put(id, m);
	}

	// 회원 id를 기준으로 검색
	public void searchInfo(String id) {
		member.get(id).showBasicInfo();
		member.get(id).showMoney();
	}
	
	// 회원 id를 기준으로 탈퇴
	public void deleteInfo(String id) {
		member.remove(id);
	}
	
	// 회원 정보 수정
	public void editInfo(String id) {
		
		String editId=id;
		System.out.println("회원 정보를 수정합니다.");
		System.out.println("아이디 : "+editId);
		System.out.println("패스워드를 입력해주세요 >> ");
		String pw=sc.nextLine();
		System.out.println("이름을 입력해주세요 >>");
		String name=sc.nextLine();
		System.out.println("전화번호를 입력해주세요 >> ");
		String phoneNum=sc.nextLine();
		System.out.println("이메일을 입력해주세요 >> ");
		String email=sc.nextLine();
		member.remove(id);
		member.put(id, new MemberInfo(editId, pw, name, phoneNum, email));
		
	}
	
	// 회원 id와 pw를 입력하여 접속
	public boolean login(String id, String pw) {
		return member.get(id).getPw().equals(pw);
	}

	void payment(String id) {
		member.get(id).payment();
	}
	
	
	
	
}
