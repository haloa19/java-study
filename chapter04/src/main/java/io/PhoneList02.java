package io;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PhoneList02 {

	public static void main(String[] args) {
		Scanner scanner = null;
		
		try {
			
			File file = new File("phone.txt");
			
			if(!file.exists()) {
				System.out.println("파일 존재하지 않음.");
				return;
			}
			
			System.out.println("========= 파일정보 ===========");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length() + "bytes");
			System.out.println(new SimpleDateFormat("yyyy-MM-ddd hh:mm:ss").format(new Date(file.lastModified()))); // 최종 수정일
		
			System.out.println("========= 전화번호 ===========");
			scanner = new Scanner(file);
			
			while(scanner.hasNextLine()) {
				String name = scanner.next();
				String phone1 = scanner.next();
				String phone2 = scanner.next();
				String phone3 = scanner.next();
				
				System.out.println(name + ":" + phone1 + "-" + phone2 + "-" + phone3);
			}
			
		} catch (IOException e) {
			System.out.println("error : " + e);
		} finally {
			scanner.close();  // 내부적으로 try catch사용
		}

	}

}
