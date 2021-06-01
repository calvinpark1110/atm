package ATM;

import java.util.Random;

public class AccountManager {
	Random ran = new Random();
	
	static AccountManager instance = new AccountManager();

	
	public void creatAcc(int log) {
		int cnt = UserManager.instance.userList[log].accCnt;
		if (cnt == 3) {
			System.out.println("더이상 만들 수 없습니다. ");
			return;
		}
		UserManager.instance.userList[log].account[cnt] = new Account();
		
		boolean result = true;
		int account =0;
		while(result) {
			account = ran.nextInt(10000)+99999;
			result = UserManager.instance.checkAcc(account);
		}
		UserManager.instance.userList[log].account[cnt].number = account;
		UserManager.instance.userList[log].accCnt ++;
	}
}
