package ATM;

import java.util.Scanner;

public class UserManager {
	static UserManager instance = new UserManager();
	Scanner scan = new Scanner(System.in);

	final int ACC_CNT_MAX = 3;

	User[] userList = null;
	int userCnt = 0;

	public void printID() {
		for (int i = 0; i < UserManager.instance.userCnt; i++) {
			System.out.println(userList[i].id);
		}
	}
	public int logId() {
		int log = -1;
		System.out.println("아이디를 입력하시오 : ");
		String id = scan.next();
		System.out.println("비밀번호를 입력하시오 : ");
		String pw = scan.next();
		for(int i=0; i<UserManager.instance.userCnt; i++) {
			if(userList[i].id.equals(id)&&userList[i].pw.equals(pw)) {
				log = i;
			}else {
				System.out.println("비밀번호 또는 아이디 오류. ");
			}
		}
		return log;
	}
	public boolean checkId(String id) {
		boolean result = false;
		for (int i = 0; i < UserManager.instance.userCnt; i++) {
			if (userList[i].id.equals(id)) {
				result = true;
			}
		}
		return result;
	}
	
	public boolean checkAcc(int account) {
		boolean check = false;
		for(int i=0; i<userCnt; i++) {
			for(int j=0; j<userList[i].accCnt; j++) {
				if(account == userList[i].account[j].number) {
					check = true;
				}
			}
		}
		return check;
	}
	public void join() {
		System.out.println("회원가입 아이디를 입력하시오 : ");
		String id = scan.next();
		System.out.println("회원가입 비밀번호를 입력하시오 : ");
		String pw = scan.next();

		boolean check = checkId(id);
		if (check) {
			System.out.println("중복된 아이디 입니다. ");
			return;
		}
		if(userCnt == 0) {
			userList = new User[userCnt +1];
			userList[userCnt] = new User();
		}else if(userCnt >0) {
			User [] temp = userList;
			userList = new User[userCnt +1];
			userList[userCnt] = new User();
			for(int i=0; i<UserManager.instance.userCnt; i++) {
				userList[i] = temp[i];
			}
			temp = null;
		}
		userList[userCnt].id = id;
		userList[userCnt].pw = pw;
		userCnt ++;
	}
}
