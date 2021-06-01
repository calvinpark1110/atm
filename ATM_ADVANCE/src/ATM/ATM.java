package ATM;

import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
	static ATM atm = new ATM();
	Scanner scan = new Scanner(System.in);
	Bank bank = new Bank();

	public void run() {
		while (true) {
			UserManager.instance.printID();
			System.out.println("[1] 로그인 ");
			System.out.println("[2] 회원가입");
			System.out.println("[0] 종료");

			int sel = scan.nextInt();

			if (sel == 1) {
				logIn();

			} else if (sel == 2) {
				UserManager.instance.join();
			}
		}
	}

	public void logIn() {
		bank.log = UserManager.instance.logId();
		if (bank.log != -1) {
			loginMen();
		} else {
			System.out.println("비밀번호 틀림 ");
		}
	}

	public void loginMen() {
		User[] temp = UserManager.instance.userList; //간략하세 만들기. 
		boolean run = true;
		while (true) {
			for(int i=0; i<UserManager.instance.userList[bank.log].accCnt;i++) {
				System.out.println(temp[bank.log].account[i].number + " : " + temp[bank.log].account[i].money+ "원");
			}
			System.out.println("[" + UserManager.instance.userList[bank.log].id + "]   환영합니다. ");
			System.out.println("[1] 계좌생성");
			System.out.println("[2] 계좌삭제");
			System.out.println("[3] 입금");
			System.out.println("[4] 이체");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				AccountManager.instance.creatAcc(bank.log);
			}else if(sel == 2) {
				
			}else if(sel == 3) {
				System.out.println("입금 계좌를 선택해 주세요 : ");
				int idx = scan.nextInt();
				System.out.println("입금할 금액을 입력해주세요 : ");
				int deposit = scan.nextInt();
				temp[bank.log].account[idx].money += deposit;
			}else if(sel ==4) {
				
			}
		}
	}
}
