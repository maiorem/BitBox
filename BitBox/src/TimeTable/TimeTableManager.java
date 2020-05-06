package TimeTable;

/*
 *20.05.05 가격추가  
 *
 */
import java.util.LinkedList;
import java.util.Scanner;

import Movie.MovieManager;

public class TimeTableManager {
	
	LinkedList<TimeTable> table;
	Screen [] sc;
	int pos;
	Scanner ip = new Scanner(System.in);
	MovieManager mManager= MovieManager.getInstance();
	
	public TimeTableManager() {
		table = new LinkedList<>();
		sc = new Screen[3];
		sc[0] = new Screen("1관", 5,5,10000);
		sc[1] = new Screen("2관", 5,6,10000);
		sc[2] = new Screen("IMax", 5,7,13000);
		
		table.add(new TimeTable(mManager.movieList.get(0), sc[0], "9시"));
		table.add(new TimeTable(mManager.movieList.get(1), sc[0], "12시"));
		table.add(new TimeTable(mManager.movieList.get(2), sc[0], "15시"));
		
		table.add(new TimeTable(mManager.movieList.get(0), sc[1], "10시"));
		table.add(new TimeTable(mManager.movieList.get(1), sc[1], "13시"));
		table.add(new TimeTable(mManager.movieList.get(2), sc[1], "16시"));
		
		table.add(new TimeTable(mManager.movieList.get(0), sc[2], "12시"));
		table.add(new TimeTable(mManager.movieList.get(1), sc[2], "9시"));
		table.add(new TimeTable(mManager.movieList.get(2), sc[2], "17시"));
		
	}
	
	void add() {
		
		int selectM;
		int selectS;
		System.out.println("<<영화 목록>>");
		for(int i=0; i< mManager.movieList.size();i++) {
			System.out.println(i+")");
			System.out.println(mManager.movieList.get(i).title);
			System.out.println("-----------");
		}
		
		System.out.println("시간 표에 입력하실 영화의 번호를 입력:");
		selectM = ip.nextInt();
		ip.nextLine();
		
		System.out.println("<<상영관 목록>>");
		for (int i=0; i< sc.length;i++) {
			System.out.println(i+")");
			System.out.println(sc[i].name);
			System.out.println("-----------");
		}
		System.out.println("영화를 상영할 상영관 입력");
		selectS = ip.nextInt();
		ip.nextLine();
		
		System.out.println("시간 입력 :");
		String h= ip.nextLine();
		System.out.println("분 입력 :");
		String min = ip.nextLine();
		
		String t1 = h+"시 "+min+"분";
		
		table.add(new TimeTable(mManager.movieList.get(selectM), sc[selectS], t1));
		table.get(0).showTimeTable();
		
		
	}
	
	
	
	
	
}
