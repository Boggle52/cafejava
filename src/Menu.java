import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.Scanner; �� ���� �� ����

public class Menu {

//	�ʵ�(�������, ����)
//	Ŭ���� �ȿ����� ���� ���� �ʱ�ȭ�� �ϱ�
//	ArrayList<String> arName=new ArrayList<String>();
//	ArrayList<Integer> arPrice=new ArrayList<Integer>();
	ArrayList<String> arName;
	ArrayList<Integer> arPrice;

//	������, �ʱ�ȭ
	Menu(){
		this.arName=new ArrayList<String>();
		this.arPrice=new ArrayList<Integer>();
	}

//	�޼ҵ�

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
//		System.out.println("�޴����� �Է��Ͻÿ�.");
//		String str=s.nextLine();
//		while(!str.equals("")) {
//			this.add(str);
//			System.out.println("������ �Է��Ͻÿ�.");
//			int price=Integer.parseInt(s.nextLine());
//			this.add(price);
//			System.out.println("�޴����� �Է��Ͻÿ�.");
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
//		s.close(); ���� close
