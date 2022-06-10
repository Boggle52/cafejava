import java.util.ArrayList;

public class Sales {
	ArrayList<String> arMobile;
	ArrayList<Integer> arSum;
	
	Sales(){
		this.arMobile=new ArrayList<String>();
		this.arSum=new ArrayList<Integer>();
	}
	void add(String mobile,int sum) {
		this.arMobile.add(mobile);
		this.arSum.add(sum);
	}
	void display() {
		for(int i=0; i<this.arMobile.size();i++) {
			System.out.println(this.arMobile.get(i)+", "+
					this.arSum.get(i));
		}
	}
}
