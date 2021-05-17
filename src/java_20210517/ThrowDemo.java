package java_20210517;

public class ThrowDemo {
	public static double withdraw(String account, int amount) 
	throws InSufficientBalanceException, IncorrectAccountException {
		double myBalance=10000;
		String myAccount = "123-123-123456";
		if(myAccount.equals(account)) {
			if(myBalance-amount >= 0) {
				myBalance-=amount;
			}else {
				//return -1; -1이면 계좌 잔액 부족
				throw new InSufficientBalanceException("잔고가 부족합니다"); //잔고를 리턴하는 의미가 없는데 리턴을 해야할때 : 예외 를 생성
			}
		}else {
			//return -2; -2이면 계좌 번호 틀린거야.
			throw new IncorrectAccountException("잘못된 계좌번호 입니다.");
		}
		
		return myBalance;
	}
	public static void main(String[] args) {
		double balance = 0;
		try {
			balance = withdraw("123-123-123456",7000);
			System.out.printf("잔고 : %,.2f %n",balance);
		}catch(InSufficientBalanceException e) {
			System.err.println(e.getMessage());
		}catch(IncorrectAccountException e) {
			System.err.println(e.getMessage());
		}
	}
}
