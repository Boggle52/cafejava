import java.util.Scanner;

public class CafeMain {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		Menu menu = new Menu();
		Order order=new Order();
		Sales sales=new Sales();
		
		try{
			menu.build();
			System.out.println("�۾��� �����Ͻÿ� [o:�ֹ��ޱ�,s:���⺸��,m:�޴�����,x:���α׷� ����]");
			String str=s.nextLine();
			while(!str.equals("x")) {
				if(str.equals("s")) {
					sales.display();
				} else if(str.equals("o")) { //�ֹ��ޱ�
					menu.display();
					System.out.println("�޴� ��ȣ�� �����Ͻÿ�.");
					str=s.nextLine();
					while(!str.equals("")) {
						int ndx=Integer.parseInt(str)-1;
						System.out.println("������ �Է��Ͻÿ�.");
						str=s.nextLine();
						int net=menu.setPrice(ndx);
	//					int net=menu.arPrice.get(ndx);
	//					order.addName(menu.arName.get(ndx));
	//					order.addQty(Integer.parseInt(str));
	//					order.addTotal(net*Integer.parseInt(str));
						order.addOrder(menu.setName(ndx),
	//							       menu.arName.get(ndx),
								Integer.parseInt(str),
								net*Integer.parseInt(str));
						menu.display();
						System.out.println("�޴���ȣ�� �����Ͻÿ�.");
						str=s.nextLine();
					}
					int sum=order.display();
					System.out.println("����� ��ȣ�� �Է��Ͻʽÿ�.");
					String mobile=s.nextLine();
					sales.add(mobile,sum);
					order=new Order();
//					order.clear()
				} else if(str.equals("m")) {
					menu.display();
					System.out.println("�۾��� �����Ͻÿ� [c:�űԸ޴��߰�,u:�����޴�����,d:�����޴�����,x:�޴���������]");
					str=s.nextLine();
					while(!str.equals("x")) {
						if(str.equals("c")) {
							System.out.println("�߰��� �޴��� ������ �Է��Ͻÿ�.");
							String newMenu=s.nextLine();
							int newPrice=Integer.parseInt(s.nextLine());
							menu.add(newMenu);
							menu.add(newPrice);
						} else if(str.equals("u")) {
							menu.display();
							System.out.println("������ �޴� ��ȣ�� �����Ͻÿ�.");
							int menuNum=Integer.parseInt(s.nextLine());
							System.out.println("������ �޴���� ������ �Է��Ͻÿ�.");
							String changeMenu=s.nextLine();
							int changePrice=Integer.parseInt(s.nextLine());
							menu.set(menuNum, changeMenu, changePrice);
						} else if(str.equals("d")) {
							menu.display();
							System.out.println("������ �޴� ��ȣ�� �����Ͻÿ�.");
							int menuNum=Integer.parseInt(s.nextLine());
							menu.remove(menuNum);
							//menu.remove �޼ҵ忡 66-69 ������ �־
							//�ܼ�ȭ�� ���� ����
						}
						menu.display();
						System.out.println("�۾��� �����Ͻÿ� [c:�űԸ޴��߰�,u:�����޴�����,d:�����޴�����,x:�޴���������]");
						str=s.nextLine();
					}
					//�޴� ���
					//�۾� ���� (C:�ű� �޴� �߰�, U:���� �޴� ����, D:���� �޴� ����, X:�޴� ���� ����)
					//C: �� �޴���, �� ���� �Է¹޾Ƽ� �޴� ����Ʈ(arName, arPrice)�� �߰�
					//U: ���� �޴� ��ȣ, �� �޴���, �� ���� �Է¹ް� �ش� ��ȣ�� �޴��� ����
					//D: ���� �޴� ��ȣ �Է¹޾Ƽ� �޴� ����Ʈ���� ����
					//�޴� ���
				}
				System.out.println("�۾��� �����Ͻÿ� [o:�ֹ��ޱ�,s:���⺸��,m:�޴�����,x:���α׷� ����]");
				str=s.nextLine();
			}
		} catch (Exception e) {
			System.out.println("���� ��Ȳ ó�� �� ����");
		}
	}
}
		
		/*
		
		ĸ��ȭ, ������ ���� Menu class�� �ű�
		
		System.out.println("�޴����� �Է��Ͻÿ�.");
		String str=s.nextLine();
		while(!str.equals("")) {
			menu.add(str);
			System.out.println("������ �Է��Ͻÿ�.");
			int price=Integer.parseInt(s.nextLine());
			menu.add(price);
			System.out.println("�޴����� �Է��Ͻÿ�.");
			str=s.nextLine();
		}
		
		for(int i=0; i<menu.arName.size(); i++) {
			System.out.println(menu.arName.get(i)+", "+
					menu.arPrice.get(i));
		
		*/
