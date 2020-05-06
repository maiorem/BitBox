package Movie;

import java.util.ArrayList;
import java.util.Scanner;


public class MovieManager {
	//싱글톤 - 메서드사용해서 참조변수
	private static MovieManager mManager = new MovieManager();
	public static MovieManager getInstance() {
		return mManager;
	}
	
	public ArrayList<Movie> movieList;
	Scanner ip = new Scanner(System.in);
	
	
	MovieManager(){
		movieList = new ArrayList<>();
		movieList.add(new Movie("어벤져스", "감독1", 180));
		movieList.add(new Movie("스파이더맨","감독2",160));
		movieList.add(new Movie("너의이름은","감독3",120));
	}
	
	void addMovie() {
		String title;
		String director;
		int runtime;
		
		System.out.println("영화 제목 입력 : ");
		title = ip.nextLine();
		System.out.println("영화 감독 입력 : ");
		director = ip.nextLine();
		System.out.println("영화 런타임 입력 : ");
		runtime = ip.nextInt();
		ip.nextLine();
		
		movieList.add(new Movie(title, director, runtime));	
		System.out.println("신작영화가 등록되었습니다");
		
	}
	void delMovie() {
		
	}
	

}
