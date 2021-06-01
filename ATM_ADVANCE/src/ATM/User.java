package ATM;

public class User {
	String id = "";
	String pw = "";
	
	Account [] account = new Account [UserManager.instance.ACC_CNT_MAX];
	int accCnt =0;
}
