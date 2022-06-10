import java.util.ArrayList;

public class Order {
	ArrayList<String> arMenu;
	ArrayList<Integer> arQty;
	ArrayList<Integer> arTotal;
	Order(){
		this.arMenu=new ArrayList<String>();
		this.arQty=new ArrayList<Integer>();
		this.arTotal=new ArrayList<Integer>();
	}
//	void addName(String str) {
//		this.arMenu.add(str);	
//	}
//	void addQty(int qty) {
//		this.arQty.add(qty);
//	}
//	void addTotal(int total) {
//		this.arTotal.add(total);
//	}
	
	void addOrder(String name,int qty,int total) {
		this.arMenu.add(name);
		this.arQty.add(qty);
		this.arTotal.add(total);
	}
	
	int display() {
		int nTotal=0;
		for(int i=0; i<this.arMenu.size();i++) {
			System.out.println(this.arMenu.get(i)+", x"+
					this.arQty.get(i)+", "+
					this.arTotal.get(i));
			nTotal+=this.arTotal.get(i);
		}
		return nTotal;
	}
}
