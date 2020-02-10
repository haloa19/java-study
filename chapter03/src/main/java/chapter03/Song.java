package chapter03;

public class Song {
	private String title;
	private String artist;
	private String album;
	private String composer;
	private int track;
	private int year;
	
	public Song() {
		
	}
	
	public Song(String title, String artist, String album, String composer, int track, int year) {
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.composer = composer;
		this.track = track;
		this.year = year;
		
		/* song codes */
		
	}
	
	public Song(String title, String artist) {
		//this.title = title;
		//this.artist = artist;
		
		/* song codes 중복인 경우 코드를 갖고있는 다른 생성자를 호출하여 코드 중복 줄이기*/
		this(title, artist, null, null, 0, 0);
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getComposer() {
		return composer;
	}
	public void setComposer(String composer) {
		this.composer = composer;
	}
	public int getTrack() {
		return track;
	}
	public void setTrack(int track) {
		this.track = track;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public void show() {
		System.out.println(
				artist + " " + 
			    title + " ( " + 
				album + ", " + 
			    year + ", " + 
				track + "번 track, " +
			    composer + " 작곡 )");
	}

}
