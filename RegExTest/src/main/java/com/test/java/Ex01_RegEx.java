package com.test.java;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.catalina.tribes.util.Arrays;

public class Ex01_RegEx {

	public static void main(String[] args) {
		
		/*
		
			정규 표현식, Regular Expression
			- 정규식
			- 특정 패턴의 문자열을 검색하는 표현식(도구)
			- SQL의 like절과 유사
			- 유닉스
			
			
			정규 표현식 구성요소
			1. x
				- x는 임의의 한 문자
				- 고정 문자
				ex) "a" > abc
				ex) "abc" > abc
			
			2. 출현횟수
				- 바로 앞의 문자(집합)의 출현 횟수를 의미
				
				2.1 생략
					- 바로 앞의 대상의 출현 횟수가 생략X, 중복X
					- 출현횟수 > 1
					ex) "a?bc" > ab, abc, abbc, ac, bc, bbc, aaabc
				
				2.2 ?
					- 바로 앞의 대상의 출현 횟수가 생략O, 중복X
					- 출현횟수 > 0~1
					ex) "a?bc" > ab, abc, abbc, ac, bc, bbc, aaabc
					ex) "홍?길동" > 안녕~ 길동아~ 네 이름이 홍길동이었네?
					ex) "자바?코드"  > 자바코드가 있습니다. 코드에 에러가 났네요. 자코드
					ex) "(자바)?코드"  > 자바코드가 있습니다. 코드에 에러가 났네요. 자코드
				
				2.3 +
					- 바로 앞의 대상의 출현 횟수가 생략X, 중복O
					- 출현횟수 > 1~무한대
					ex) "a+bc" > ab, abc, abbc, ac, bc, bbc, aaabc
					ex) "홍+길동" > 안녕~ 길동아~ 네 이름이 홍길동이었네? 홍홍길동
					ex) "(자바)+코드"  > 자바코드가 있습니다. 코드에 에러가 났네요. 자바자바코드
				
				2.4 *
					- 바로 앞의 대상의 출현 횟수가 생략O, 중복O
					- 출현횟수 > 0~무한대
					ex) "a*bc" > ab, abc, abbc, ac, bc, bbc, aaabc
					ex) "(자바)*코드"  > 자바코드가 있습니다. 코드에 에러가 났네요. 자바자바코드
				
				ex) "ab?c+d*" > abcd, bcd, abc, acd, abbcd, abccd, abcccc, acccddd
				
				
			3. 선택, choice
				3.1 [열거값]
					ex) "[123]" > 123. 숫자 5입니다. 나이는 21살입니다. 사과가 223개 있습니다.
					ex) "[321]45" > 12345, 145, 245, 345, 45 
					ex) "[321]?45" > 12345, 145, 245, 345, 45
					ex) "[321]+45" > 12345, 145, 245, 345, 45
					ex) "[321]*45" > 12345, 145, 245, 345, 45
					ex) "[0123456789]+" > 123. 숫자 5입니다. 나이는 21살입니다. 사과가 223개 있습니다.
					ex) "[02468]", "[13579]+" > 2221
					
					ex) "2자리 숫자" > "[0123456789][0123456789]"
					ex) 전화번호 검색
						"010-[0123456789][0123456789][0123456789][0123456789]-[0123456789][0123456789][0123456789][0123456789]"
						
						주민등록번호
						"[0123456789][0123456789][0123456789][0123456789][0123456789][0123456789]-[12][0123456789][0123456789][0123456789][0123456789][0123456789][0123456789]"
						
						800124-1021547
						971125-2012457
						000547-3451578
						
						010-1234-5789
						010-6524-8594
						010-3625-5871
						
						010-123-4567
						011-2542-5874
						
						010-1234-57894
						010-25-5844-2563
						
						이메일 규칙?
						URL 규칙?
						태그 규칙? <태그명> <태그명 속성=""> <태그명 속성=''> <태그명 속성>..
					
					ex) 영어 소문자
						"[abcdefghijklmnopqrstuvwxyz]"
						
						영어 소문자 3개로 된 단어 검색
						"[abcdefghijklmnopqrstuvwxyz][abcdefghijklmnopqrstuvwxyz][abcdefghijklmnopqrstuvwxyz]"
						
					ex) 영어 대문자
						"[ABCDEFGHIJKLMNOPQRSTUVWXYZ]"
					
					ex) 한글
						"[가나다라마바사구규누뉴노뇨..]"
						
					
					** 연속된 문자를 간단하게 표현하는 방법
						- 문자코드 활용
					ex) 숫자 > "[0123456789]" > "[0-9]"
					ex) 영소문자 > "[abcdefghijklmnopqrstuvwxyz]" > "[a-z]"
					ex) 영대문자 > "[ABCDEFGHIJKLMNOPQRSTUVWXYZ]" > "[A-Z]"
					ex) 한글 > "[가-힣]"
					
						전화번호 > "010-[0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]"
						
						홍씨 성을 가진 사람 이름 > "홍[가-힣][가-힣]"
					
					ex) 영문자 > "[abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ]"
					            "[A-Za-z]"
					            "[0123789]" > "[0-37-9]"
					
					ex) 영문자 + 숫자 > "[A-Za-z0-9]"
					
					ex) 영문자 + 숫자 + 한글 > "[A-Za-z0-9가-힣]"
					
					ex) 식별자로 적합한 문자(영문자 + 숫자 + '_') > "[A-Za-z0-9_]"
						
				
				3.2 [^열거값]
					-열거값을 제외한 패턴 검색
					
					ex) [^0-9]
						[^aeiou] 
				
		
			4. 출현횟수
				- 바로 앞의 문자(집합)의 출현 횟수를 의미
				- ?, +, * > 더 세밀한 패턴 지정 가능
				
				4.1 {n}
					- n: 고정 출현 횟수
					ex) "a{1}bc" > ab, abc, abbc, ac, bc, bbc, aaabc
					ex) "a{3}bc" > ab, abc, abbc, ac, bc, bbc, aaabc
					
				4.2 {n,m}
					- n: 최소 출현 횟수
					- m: 최대 출현 횟수
					ex) "a{1,3}bc" > ab, abc, abbc, ac, bc, bbc, aaabc, aabc, aaaaaaabc
				
				4.3 {n,}
					- n: 최소 출현 횟수
					- 최대 출현 횟수 무한대
					
				ex) 전화번호: "010-[0-9]{4}-[0-9]{4}"
				ex) 주민번호: "[0-9]{6}-[0-9]{7}"
				ex) 주민번호: "[0-9]{6}-{0,1}[0-9]{7}"
				ex) 주민번호: "[0-9]{6}-?[0-9]{7}"
					
					950101-1010101
					9501011010101
				
				ex) 영어단어(3문자): "[A-Za-z]{3}"
				
				ex) 전화번호: "010-[0-9]{3,4}-[0-9]{4}"
					010-123-4567
					010-1234-5678
					
				ex) 1글자 이상 모든 영어단어: "[A-Za-z]{1,}" or "[A-Za-z]+"
				ex) 2글자 이상 모든 영어단어: "[A-Za-z]{2,}" or "[A-Za-z][A-Za-z]+"
				ex) 3글자 이상 모든 영어단어: "[A-Za-z]{3,}" or "[A-Za-z][A-Za-z][A-Za-z]+"
			
					
			5. 처음과 끝
				- 입력 컨트롤(텍스트 박스)을 대상으로 사용 
				
				5.1 ^
					- 뒤의 표현으로 반드시 시작
					- str.startsWith()
					ex) "^홍길동" > 대상 문자열이 '홍'으로 시작하면 찾아라!!
				
				5.2 $
					- 앞의 표현으로 반드시 끝
					- str.endsWith()
					ex) "홍길동$" > 대상 문자열이 '동'으로 끝나면 찾아라!!!
					
					
			6. 줄임표현
				
				6.1 \d or \D
					- Digital > 숫자
					- \d > [0-9]
					- \D > [^0-9]
					
					ex) [0-9]{3}-[0-9]{3,4}-[0-9]{4}
					    \d{3}-\d{3,4}-\d{4}
					    
					    "\d+"
					    "\D+"
				
				6.2 \s or \S
					- 공백문자(스페이스, 탭, 엔터)
					
					ex) "\s+", "\S+"
					
					ex) "홍\s?길동"
					
					홍길동, 홍  길동, 홍 길동
				
				6.3 \w or \W
					- word(영어 대소문자 + 숫자 + '_')
					
					ex) "\w{3,5}"
				
			
				question] 아이디 검색
						  1. 영어 대소문자 + 숫자 + _
						  2. 숫자로 시작X
						  3. 길이 4~12자 이내
						  
						  ex) "[A-Za-z_][A-Za-z0-9_]{3,11}"
				
				- test
				- test123
				- 123test
				- hong*hong
				- hong_111
				- Hong
				- Lee이순신
				
		
		*/
		
		//m1();
		//m2();
		//m3();
		//m4();
		m5();
		
	}//main

	private static void m5() {
		
		//정규식을 지원하는 자바 메소드
		//- String 클래스 제공
		
		
		//완전 일치 검사
		String txt = "22세";
		System.out.println(txt.matches("[0-9]{2,3}"));
		
		
		//String names = "홍길동,아무개,,하하하;호호호,,,후후후";
		//String[] result = names.split("[,;]+");
		
		String names = "홍길동 아무개  하하하       호호호 후후후";
		String[] result = names.split("\\s+");
		
		for (String name : result) {
			System.out.println(name);
		}
		
		
		
		//개인정보 마스킹
		String line = "안녕하세요. 제 연락처는 010-5145-2874입니다. 연락이 안되면 010-1234-5678로 연락주세요.";
		
		//System.out.println(line.replace("010-2144-2541", "XXX-XXXX-XXXX").replace("010-5896-9854", "XXX-XXXX-XXXX"));
		
		System.out.println(line.replaceAll("[0-9]{3}-[0-9]{3,4}-[0-9]{4}", "XXX-XXXX-XXXX"));
		
		System.out.println(line.replaceFirst("[0-9]{3}-[0-9]{3,4}-[0-9]{4}", "XXX-XXXX-XXXX"));
		
		
	}

	private static void m4() {
		
		//회원 가입 > 사용자 입력 > 유효성 검사
		//1. 이름 > 필수, 한글, 2~5자 이내
		//2. 나이 > 필수, 숫자, 0~120세 이내
		//3. 아이디 > 필수, 영어+숫자+_ 조합, 숫자 시작 불가능, 4~12자 이내
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름: ");
		String name = scan.nextLine();
		
		System.out.print("나이: ");
		int age = scan.nextInt();
		scan.skip("\r\n");
		
		System.out.print("아이디: ");
		String id = scan.nextLine();
		
		if (check(name, age, id)) {
			System.out.println("가입 완료");
		} else {
			System.out.println("가입 실패");
		}
		
	}

	private static boolean check(String name, int age, String id) {
		
		String regex = "";
		Pattern pattern = null;
		Matcher matcher = null;
		
		//1. 이름 > 필수, 한글, 2~5자 이내
		regex = "^[가-힣]{2,5}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(name); //"홍길동"
		
		if (!matcher.find()) {
			return false;
		}
		
		
		//2. 나이 > 필수, 숫자, 0~120세 이내
		regex = "^[0-9]{1,3}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(age + "");
		
		if (!(matcher.find() && (age >= 0 && age <= 120))) {
			return false;
		}
		
		
		//3. 아이디 > 필수, 영어+숫자+_ 조합, 숫자 시작 불가능, 4~12자 이내
		regex = "^[A-Za-z_][A-Za-z0-9_]{3,11}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(id);
		
		if (!matcher.find()) {
			return false;
		}
		
		
		return true;
	}

	private static void m3() {
		
		String txt = "안녕하세요. 저는 홍길동입니다. hong@gmail.com 어? 당신 이름도 길동이네요? test_123@naver.com 김길동이네요. pinn.public@gmail.com 저쪽에 최길동도 있어요. 한명 더 있네요~ 남궁길동이도 있습니다.";
		
		//http://regexlib.com
		
		String regex = "(\\w+)@([a-zA-Z_]+?\\.[a-zA-Z]{2,3})";
		
		Pattern p1 = Pattern.compile(regex);
		
		Matcher m1 = p1.matcher(txt);
		
		while (m1.find()) {
			System.out.println("이메일: " + m1.group());
			System.out.println("아이디: " + m1.group(1));
			System.out.println("도메인: " + m1.group(2));
			System.out.println();
		}
		
	}

	private static void m2() {
		
		String txt = "안녕하세요. 저는 홍길동입니다. 어? 당신 이름도 길동이네요? 김길동이네요. 저쪽에 최길동도 있어요. 한명 더 있네요~ 남궁길동이도 있습니다.";
		
		//1. 모든 길동이 찾기!!
		
		//String regex = "([홍김최])?길동";
		String regex = "(홍|김|최|남궁)?길동";
		
		Pattern p1 = Pattern.compile(regex);
		
		Matcher m1 = p1.matcher(txt);
		
		
		while (m1.find()) {
			System.out.println("찾은 이름: " + m1.group());
			System.out.println("성씨: " + m1.group(1));
			System.out.println("성씨: " + m1.group().substring(0, 1));
			System.out.println();
		}
		
		
	}

	private static void m1() {
		
		String txt = "안녕하세요. 홍길동입니다. 010-1234-5678 지금 정규 표현식을 공부하는 중입니다. 010-8547-9854 밖에 비가 내립니다. 010-652-9854 배가 고픕니다.";
		
		//1. txt 안에 전화번호가 있는지 유무?
		
		//String regex = "[0-9]{3}-[0-9]{3,4}-[0-9]{4}";
		String regex = "([0-9]{3})-([0-9]{3,4})-([0-9]{4})";
		
		//정규식을 사용하는 검색 도구 > Pattern
		Pattern p1 = Pattern.compile(regex);
		
		//검색 결과 > Matcher
		Matcher m1 = p1.matcher(txt);
		
		//System.out.println(m1.find());
		
//		if (m1.find()) {
//			System.out.println("txt내에 전화번호가 발견되었습니다.");
//		} else {
//			System.out.println("txt내에 전화번호가 없습니다.");
//		}
		
		
		while (m1.find()) {
			System.out.println("전화번호를 발견했습니다.");
			System.out.println(m1.group());
			System.out.println("전체 문자열: " + m1.group(0));
			System.out.println("첫번째 괄호(통신사): " + m1.group(1));
			System.out.println("두번째 괄호(앞자리): " + m1.group(2));
			System.out.println("셋번째 괄호(뒷자리): " + m1.group(3));
			System.out.println();
		}
		
	}
	
}














































