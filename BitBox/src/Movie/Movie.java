package Movie;

public class Movie {
	public String title;
	String director;
	int runtime;
	
	Movie (String title, String director, int runtime){
		this.title = title;
		this.director = director;
		this.runtime = runtime;
				
	}
	
	void showMovieInfo() {
		System.out.println("영화 제목 : "+ this.title);
		System.out.println("영화 감독 : "+ this.director);
		System.out.println("런  타  임 : "+ this.runtime);
	}
}
