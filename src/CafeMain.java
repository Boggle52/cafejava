import java.util.Scanner;

public class CafeMain {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		Menu menu = new Menu();
		Order order=new Order();
		Sales sales=new Sales();
		
		try{
			menu.build();
			System.out.println("작업을 선택하시오 [o:주문받기,s:매출보기,m:메뉴관리,x:프로그램 종료]");
			String str=s.nextLine();
			while(!str.equals("x")) {
				if(str.equals("s")) {
					sales.display();
				} else if(str.equals("o")) { //주문받기
					menu.display();
					System.out.println("메뉴 번호를 선택하시오.");
					str=s.nextLine();
					while(!str.equals("")) {
						int ndx=Integer.parseInt(str)-1;
						System.out.println("수량을 입력하시오.");
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
						System.out.println("메뉴번호를 선택하시오.");
						str=s.nextLine();
					}
					int sum=order.display();
					System.out.println("모바일 번호를 입력하십시오.");
					String mobile=s.nextLine();
					sales.add(mobile,sum);
					order=new Order();
//					order.clear()
				} else if(str.equals("m")) {
					menu.display();
					System.out.println("작업을 선택하시오 [c:신규메뉴추가,u:기존메뉴수정,d:기존메뉴삭제,x:메뉴관리종료]");
					str=s.nextLine();
					while(!str.equals("x")) {
						if(str.equals("c")) {
							System.out.println("추가할 메뉴와 가격을 입력하시오.");
							String newMenu=s.nextLine();
							int newPrice=Integer.parseInt(s.nextLine());
							menu.add(newMenu);
							menu.add(newPrice);
						} else if(str.equals("u")) {
							menu.display();
							System.out.println("변경할 메뉴 번호를 선택하시오.");
							int menuNum=Integer.parseInt(s.nextLine());
							System.out.println("변경할 메뉴명과 가격을 입력하시오.");
							String changeMenu=s.nextLine();
							int changePrice=Integer.parseInt(s.nextLine());
							menu.set(menuNum, changeMenu, changePrice);
						} else if(str.equals("d")) {
							menu.display();
							System.out.println("삭제할 메뉴 번호를 선택하시오.");
							int menuNum=Integer.parseInt(s.nextLine());
							menu.remove(menuNum);
							//menu.remove 메소드에 66-69 라인을 넣어서
							//단순화할 수도 있음
						}
						menu.display();
						System.out.println("작업을 선택하시오 [c:신규메뉴추가,u:기존메뉴수정,d:기존메뉴삭제,x:메뉴관리종료]");
						str=s.nextLine();
					}
					//메뉴 출력
					//작업 선택 (C:신규 메뉴 추가, U:기존 메뉴 수정, D:기존 메뉴 삭제, X:메뉴 관리 종료)
					//C: 새 메뉴명, 새 가격 입력받아서 메뉴 리스트(arName, arPrice)에 추가
					//U: 기존 메뉴 번호, 새 메뉴명, 새 가격 입력받고 해당 번호의 메뉴명 수정
					//D: 기존 메뉴 번호 입력받아서 메뉴 리스트에서 삭제
					//메뉴 출력
				}
				System.out.println("작업을 선택하시오 [o:주문받기,s:매출보기,m:메뉴관리,x:프로그램 종료]");
				str=s.nextLine();
			}
		} catch (Exception e) {
			System.out.println("예외 상황 처리 후 종료");
		}
	}
}
		
		/*
		
		캡슐화, 은닉을 위해 Menu class로 옮김
		
		System.out.println("메뉴명을 입력하시오.");
		String str=s.nextLine();
		while(!str.equals("")) {
			menu.add(str);
			System.out.println("가격을 입력하시오.");
			int price=Integer.parseInt(s.nextLine());
			menu.add(price);
			System.out.println("메뉴명을 입력하시오.");
			str=s.nextLine();
		}
		
		for(int i=0; i<menu.arName.size(); i++) {
			System.out.println(menu.arName.get(i)+", "+
					menu.arPrice.get(i));
		
		*/
