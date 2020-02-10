package chapter04;

import java.util.Calendar;

public class CalendarTest {
	public static final int MONTH = 1;
	
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		final int i = 10; // 값 고정 변경할 수 없음
		printDate(cal);
		
		cal.set(Calendar.YEAR, 2020);
		cal.set(Calendar.MONTH, 11); // month(12) - 1
		cal.set(Calendar.DATE, 25);
		printDate(cal);
		
		cal.set(1995, 04, 28);
		cal.add(Calendar.DATE, 10000);
		printDate(cal);
		
	}
	
	public static void printDate(Calendar cal) {
		String[] days = {"일", "월", "화", "수", "목", "금", "토"};
		// 년도
		int year = cal.get(Calendar.YEAR);
		
		// 월(0~11, +1)
		int month = cal.get(Calendar.MONTH);
		int date = cal.get(Calendar.DATE);
		
		// 요일(1(일) ~ 7(토))
		int day = cal.get(Calendar.DAY_OF_WEEK);
		int hours = cal.get(Calendar.HOUR);
		int minutes = cal.get(Calendar.MINUTE);
		int seconds = cal.get(Calendar.SECOND);
		
		System.out.println(year + "년" + (month + 1) + "월" + date + "일" + days[day-1] + "요일" + hours + "시" + minutes + "분" + seconds + "초");
	}

}
