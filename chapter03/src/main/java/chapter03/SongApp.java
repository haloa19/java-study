package chapter03;

public class SongApp {

	public static void main(String[] args) {
		Song song = new Song();
		song.setTitle("좋은날");
		song.setArtist("아이유");
		song.setAlbum("real");
		song.setComposer("이수만");
		song.setTrack(3);
		song.setYear(2019);
		
		song.show();
		
		Song song2 = new Song("제목", "가수", null, "작곡가", 4, 2019);
		song2.show();
		
		Song song3 = new Song("먹구름", "윤하");
		song3.show();

	}

}
