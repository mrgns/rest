package entitybeans;

public class Account {

	private int accno;
	private String accnm;
	private String acctype;
	private double balance;
	
	
	
	
	public Account() {
		accno = 0;
		accnm = "";
		acctype = "";
		balance = 0.0;
	}
	
	
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getAccnm() {
		return accnm;
	}
	public void setAccnm(String accnm) {
		this.accnm = accnm;
	}
	public String getAcctype() {
		return acctype;
	}
	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
}
