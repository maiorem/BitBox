package TimeTable;

import Movie.Movie;

public class TimeTable {
	Movie movie;
	Screen screen;
	String time;
	
	
	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public TimeTable(Movie movie, Screen screen, String time) {
		this.movie = movie;
		this.screen = screen;
		this.time = time;
		
	}
	
	void showTimeTable() {
		System.out.println("상영시간 : "+time);
		System.out.println("영화제목 : "+movie.title);
		System.out.println("상 영 관 : "+screen.name);
	}
	
	
}
