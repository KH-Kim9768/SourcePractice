
import java.util.Scanner;

public class Zapangi {
    static Scanner scan = new Scanner(System.in);
    final static int COKE = 600;  
    final static int FANTA = 550; 
    final static int COFFEE = 370;
    final static int WATER = 420; 
    final static String D1 = "�ݶ�";
    final static String D2 = "ȯŸ"; 
    final static String D3 = "Ŀ��";
    final static String D4 = "��";
    static int money;       
    static int t_money=0;   

    public static void main(String args[]) {
        char exit;          // ���� üŷ�� ���� ����
        System.out.println("���Ǳ�  �׽�Ʈ");
        System.out.println("-----------------------------------------------");
        System.out.println("1.�ݶ�(600), 2.ȯŸ(550), 3.Ŀ��(370), 4.��(420)");
        System.out.println("-----------------------------------------------");
        System.out.println();

        money = 0;          

        while (true) {
            if(money==0) {
                money = InputCoin();
            }

            SelectDrink(money);
            System.out.print("�߰� ���� �Ͻðڽ��ϱ�(y/n)? ");
            exit = scan.next().charAt(0);
            money = t_money;

            if (exit == 'n' || exit == 'N') {   

               System.out.println("����� ���� ����");
               break;                           
            }
            System.out.println();
      }
    }


   static int InputCoin() {
        System.out.print("�ݾ��� �Է��ϼ���: ");
        money = scan.nextInt();     
        money += t_money;   
        t_money = money;    
        //System.out.println(">>Input Coin Money : " + money);
        return money;
  }

   static void SelectDrink(int money) { 
        int sel;
        System.out.print("���Ḧ �����ϼ���: ");
        sel = (int) (scan.next().charAt(0)) - 48; 

        if (sel < 1 || sel > 4) {
            System.out.println("Error input select agin 1~4");
            SelectDrink(money);
        }
        
        else {                         

            switch (sel) {
            case 1:
                ChangePay(money, COKE, D1);
                break;
            case 2:
                ChangePay(money, FANTA, D2);
                break;
            case 3:
                ChangePay(money, COFFEE, D3);
                break;
            case 4:
               ChangePay(money, WATER, D4);
                break;
            default:
                System.out.println("Switch error");
                break;
            }
        }
    }



   static void ChangePay(int money, int s, String drink) { 
        int temp;
        int m_1000, m_500, m_100, m_50, m_10;
        char sel;
		
        if (money < s) {      
            System.out.println("Error select money < drink");
            System.out.print("�ݾ��� �� �����ðڽ��ϱ�(y/n)? ");
           sel = scan.next().charAt(0);

            if(sel == 'y')                      
                InputCoin();
            else if(sel == 'n') {               
               System.out.println("���Ǳ� ����");
               System.exit(0);
            } 
           else
                SelectDrink(money); 
        }
        else {                      
            money -= s;
            m_1000 = money / 1000; 
            temp = money % 1000;
            m_500 = temp / 500;    
            temp = temp % 500;
            m_100 = temp / 100;    
            temp = temp % 100;
	m_50 = temp / 50;    
            temp = temp % 50;
            m_10 = temp / 10;       

            System.out.println();
            System.out.println("-----------------------------------------------");
            System.out.println("������ ������� " + drink +"�̸� �Ž�������  " + money + "�� �Դϴ�.");
            System.out.print("1000�� : " + m_1000 + ", ");
            System.out.print("500�� : " + m_500 + ", ");
            System.out.print("100�� : " + m_100 + ", ");
	System.out.print("50�� : " + m_50 + ", ");
            System.out.println("10�� : " + m_10);
            System.out.println("---------------------------------------- -------");
            System.out.println();
            t_money = money;
      }
    }    
}