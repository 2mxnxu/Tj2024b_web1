package day09;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Example1 {
	public static void main(String[] args) {
		
		// [1] 파일 출력(쓰기)
			//FileOutputStream out = new FileOutputStream("파일경로");
			// c드라이브에 'java' 폴더 생성
		try {
			FileOutputStream out = new FileOutputStream("C:/java/test1.txt");
			String str = "hello java";
			byte[] outStr = str.getBytes();
			out.write(outStr);
			System.out.println("파일 저장 성공");
		}catch (FileNotFoundException e) {
			System.out.println(e);
		}catch (IOException e) {
			System.out.println(e);
		}
		
		// [2] 
		try {
			FileOutputStream out = new FileOutputStream("C:/java/test1.txt");
			Scanner scan = new Scanner(System.in);
			System.out.println("[2] 메모장에 작성할 내용 입력 : ");
			String str = scan.nextLine();
			byte[] outStr = str.getBytes();
			out.write(outStr);
			System.out.println("파일저장 성공");
		} catch (IOException e) {
			System.out.println(e);
		}
		
		
		
	}
}
