package TimeTable;


/*
 *20.05.05 스크린 생성자 가격 추가
 *
 */
public class Screen {
	String name;
	Seat[][] seats;
	int price;
	
	public int getPrice() {
		return price;
	}

	Screen(String name, int rowNum,int seatNum, int price) {
		this.name = name;
		this.seats = new Seat[rowNum][seatNum];
		this.price=price;
	}

	void seatMap() {
//		System.out.println(seats[0].length);
		
//		for (int i = 0; i< seats.length; i++) {
//			for (int j = 0 ; j<seats[i].length;j++) {
////				seats[i][j]=new Seat();
//				seats[i][j].rowNum = (char) (65+i);
//				seats[i][j].seatNum= j+1;
//			}
//		}
		seats[3][4]=new Seat();
		char row = 65;
		char seat=1;
		System.out.print("  ");
		for (int i=0;i<seats[0].length;i++) {
			System.out.print(" "+(seat+i)+" ");
		}
		System.out.println();
		for (int i=0; i<seats.length;i++) {
			System.out.print((char)(row+i)+" ");
			for (int j=0; j<seats[i].length ; j++) {
				if (seats[i][j]==null) {
					System.out.print(" □ ");
				}else {
					System.out.print(" ■ ");
				}
			}
			System.out.println();
		}
	}
}
