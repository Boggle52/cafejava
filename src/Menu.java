import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.Scanner; 안 쓰는 건 빼기

public class Menu {

//	필드(멤버변수, 변수)
//	클래스 안에서는 실행 말고 초기화만 하기
//	ArrayList<String> arName=new ArrayList<String>();
//	ArrayList<Integer> arPrice=new ArrayList<Integer>();
	ArrayList<String> arName;
	ArrayList<Integer> arPrice;

//	생성자, 초기화
	Menu(){
		this.arName=new ArrayList<String>();
		this.arPrice=new ArrayList<Integer>();
	}

//	메소드

	int setPrice(int n) {
		return(this.arPrice.get(n));
	}
	String setName(int n) {
		return(this.arName.get(n));
	}
	int arNameSize() {
		return(this.arName.size());
	}

	void add(String n) {
		this.arName.add(n);
	}
	void add(int n) {
		this.arPrice.add(n);
	}
	void set(int a, String b, int c) {
		this.arName.set(a-1,b);
		this.arPrice.set(a-1,c);
	}
	void remove(int a) {
		 this.arName.remove(a-1);
		 this.arPrice.remove(a-1);
	}
	
	void display() {
		for(int i=0; i<arNameSize(); i++) {
			System.out.println((i+1)+"."+
					this.setName(i)+", "+
					this.setPrice(i));
		}
	}
	void build() {
//		Scanner s = new Scanner(System.in);
//		System.out.println("메뉴명을 입력하시오.");
//		String str=s.nextLine();
//		while(!str.equals("")) {
//			this.add(str);
//			System.out.println("가격을 입력하시오.");
//			int price=Integer.parseInt(s.nextLine());
//			this.add(price);
//			System.out.println("메뉴명을 입력하시오.");
//			str=s.nextLine();
		try {
			File f=new File("d:\\temp\\menu.txt");
			FileReader fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			String line=br.readLine();
			while(line!=null) {
				String[] ar=line.split(",");
				this.add(ar[0]);
				this.add(Integer.parseInt(ar[1]));
				line=br.readLine();
			} 
		br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
		}
	}
}
//		s.close(); 변수 close
