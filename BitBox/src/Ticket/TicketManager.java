package Ticket;

import java.util.ArrayList;
import java.util.Scanner;
import Movie.MovieManager;
import TimeTable.Seat;
import TimeTable.TimeTable;
import TimeTable.TimeTableManager;

public class TicketManager {

	int serialCode = 10000;
	TimeTableManager tm = new TimeTableManager();
	MovieManager mM = MovieManager.getInstance();
	ArrayList<Ticket> tickets;
	Scanner sc = new Scanner(System.in);
	Ticket tic;	 // 예약 완료한 티켓
	int pos;

	public TicketManager() {
		tickets = new ArrayList<Ticket>();
		pos = 0;
	}

	public void creatTicket() {

		// 1. 영화 먼저 보여주고 영화 선택
		// 2. 선택한 영화에 따라
		TimeTable r_timeTable; // 예약한 시간표
		Seat r_seat; // 예약한 좌석

		int selectMovie; // 선택한 영화
		int selectTable; // 선택한 시간표

		int selectRow; // 선택한 좌석 열
		int selectSeat; // 선택한 좌석 번호

		// 상영중인 영화 보여주고 영화 선택
		System.out.println("<상영중인 영화>");
		for (int i = 0; i < mM.movieList.size(); i++) {
			System.out.print(i + "] ");
			System.out.println(mM.movieList.get(i).getTitle());
		}
		
		System.out.println("영화 선택 : ");
		selectMovie = sc.nextInt();
		sc.nextLine();

		// 상영중인 영화 중에 사용자가 선택한 영화에 맞는 영화제목을 시간표리스트에서 찾아서  출력
		// 시간표 선택
		System.out.println("<선택한 영화로 검색한 상영시간표>");
		for (int i = 0; i < tm.getTable().size(); i++) {
			if (mM.movieList.get(selectMovie).getTitle().equals(tm.getTable().get(i).getMovie().getTitle())) {
				System.out.println(i + "] ");
				tm.getTable().get(i).showTimeTable();
			}
		}
		selectTable = sc.nextInt();
		sc.nextLine();
		
		// 선택한 시간표안에 해당 스크린의 좌석 배열을 출력 후
		// 좌석 열과 좌석 번호를 선택
		System.out.println("<좌석 선택>");
		tm.getTable().get(selectTable).getScreen().seatMap();

		for (int i = 0; i < tm.getTable().get(selectTable).getScreen().getSeats().length; i++) {
			System.out.print(i + 1 + "] ");
			System.out.println((char) (i + 65) + "\t");
		}
		while (true) {
			System.out.println("원하시는 열의 알파벳을 선택 : ");
			selectRow = sc.nextInt();
			sc.nextLine();

			System.out.println("원하시는 좌석의 번호을 입력 : ");
			selectSeat = sc.nextInt();
			sc.nextLine();
			
			// 이미 예매가 된좌석이면 true 값이므로 예약좌석이라고 알려줌
			if (tm.getTable().get(selectTable).getScreen().getSeats(selectRow, selectSeat)) {
				System.out.println("이미 예약된 좌석이에요. 다시 선택해주세요");
				continue;
			}
			break;
		}
		
		// 선택한 시간표와 좌석 정보 출력
		tm.getTable().get(selectTable).showTimeTable();
		System.out.println("선택한 좌석 : " + (char) (selectRow + 64) + selectSeat);
		
		// 결제하시겠습니까?
		System.out.println("결제하실래요");

		r_timeTable = tm.getTable().get(selectTable);
		r_seat = new Seat((char) (selectRow + 64), selectSeat); //

		tm.getTable().get(selectTable).getScreen().setSeats(selectRow, selectSeat); // 스크린에 좌석배열에 true로 만들어주는거

		tic = new Ticket(serialCode, r_timeTable, r_seat);
		
		buyTicket(tic);
		
		
	}
	
	// 티켓리스트에 생성된 티켓 추가
	// serialCode +1 
	void buyTicket(Ticket tic) {
		
		tickets.add(tic);
		serialCode++;
	}
	
	// 티켓 출력
	void showTicket() {

		System.out.println("<예약 정보>");
		tic.showTicket();
		
		tickets.add(tic);
		System.out.println("현재 예매 티켓 수 : " + tickets.size());
		
	}
	
	int getTicketPrice() {
		
		return 0;
	}

}
