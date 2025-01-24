package day07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Example2 {
	public static void main(String[] args) {
		
		// 1. ArrayList 인스턴스 생성
			// 1. 인스턴스 : new ArrayList<String>();
			// 2. 변수명 : list,
			// 3. 변수의 타입 : List<String> list
		List<String> list = new ArrayList<String>();	// ArrayList타입은 List인터페이스를 구현했으므로
		
		// 2. List 인터페이스 메소드들 
		list.add("유재석"); System.out.println(list);
		list.add("강호동"); System.out.println(list);
		list.add("신동엽"); System.out.println(list);
		list.add("하하"); System.out.println(list);
		list.add(2,"김희철"); System.out.println(list); // 3번째 위치에 추가
			// (2) .set(인덱스, 자료) : 리스트 내 지정한 인덱스에 지정한 자료의 요소 추가
		list.set(2, "서장훈");
		System.out.println(list); // set 써서 3번째 위치 변경
			// (3) .get(인덱스) : 리스트내 지정한 인덱스의 요소 값 반환
		System.out.println(list.get(2)); // 꺼내올 때 사용
		String str1 = list.get(0);
		System.out.println(str1);
		
			// (4) .size() : 리스트내 요소 전체 개수 반환
		System.out.println(list.size());
		
			// (5) .contains(자료) : 리스트내 지정한 자료 존재 여부 반환, true/false
		System.out.println(list.contains("서장훈"));
		boolean result1 =  list.contains("박명수");
		System.out.println(result1);
		
			// (6) .indexOf(자료) : 리스트내 지정한 자료의 인덱스 반환, 없으면 0 있으면 인덱스 수 반환
		System.out.println(list.indexOf("서장훈"));
		int result2 =  list.indexOf("박명수");
		System.out.println(result2);
		
			// (7) .remove(인덱스/자료) : 리스트내 지정한 인덱스/자료의 요소 삭제
		list.remove(0);
		System.out.println(list);
		
			// (8) .clear() : 리스트내 모든 요소 삭제
			// (9) .isEmpty() : 리스트내 요소가 비어 있으면 true 1 이상 존재하면 false 반환
		System.out.println(list.isEmpty());
		
			// (10) 리스트내 요소들을 순회(하나씩꺼내기) 하는 방법
		for(int i =0; i<=list.size()-1; i++) {
			System.out.println(list.get(i));
		}
		// 향상된 for 문, for( 타입 반복변수명 : 리스트명) { }
		for(String str : list) {
			System.out.println(str);
		}
		// forEach(), JS : () => { }, JAVA : ( ) -> { }
		list.forEach((str) -> {System.out.println(str);});
		
		// 3. 클래스 틀
		ArrayList<String> list1 = new ArrayList<String>();
		Vector<String> list2 = new Vector<String>();
		LinkedList<String> list3 = new LinkedList<String>();
			// 여러 클래스들의 인스턴스를 다루기 위해서는 주로 인터페이스 타입 사용한다.
		List<String> list4 = new ArrayList<String>();
		List<String> list5 = new Vector<String>();
		List<String> list6 = new LinkedList<String>();
		
	}
}
