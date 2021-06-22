package beans;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import entitybeans.Account;
import entitybeans.DBConnection;

public class AccountOperations {

	Account acc;
	ArrayList<Account> list;
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	public Account getInfo(int accno)
	{
		try
		{
			DBConnection db=new DBConnection();
			con=db.Dbconnection();
		
			pst=con.prepareStatement("select * from Accounts where accno=?");
			pst.setInt(1, accno);
			rs=pst.executeQuery();
			if(rs.next())
			{
				acc=new Account();
				acc.setAccno(rs.getInt(1));
				acc.setAccnm(rs.getString(2));
				acc.setAcctype(rs.getString(3));
				acc.setBalance(rs.getDouble(4));
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.toString());
		}
		return acc;
	}
	
	public String newAccount(Account acc)
	{
		String stat=null;
		try
		{
			DBConnection db=new DBConnection();
			con=db.Dbconnection();
		
			pst=con.prepareStatement("insert into Accounts values(?,?,?,?)");
			pst.setInt(1, acc.getAccno());
			pst.setString(2, acc.getAccnm());
			pst.setString(3, acc.getAcctype());
			pst.setDouble(4, acc.getBalance());
			int cat = pst.executeUpdate();
			if(cat >0)
				stat = "New Account Create Successfully....";
			else
				stat = "Sorry Account Doesn't Created....";
		}
		catch(Exception ex)
		{
			System.out.println(ex.toString());
		}
		return stat;
	}
	
	
	public List<Account> getReport()
	{
		try
		{
			DBConnection db=new DBConnection();
			con=db.Dbconnection();
		
			pst=con.prepareStatement("select * from Accounts");
			rs=pst.executeQuery();  
			list=new ArrayList<Account>();
			while(rs.next())
			{
				acc=new Account();
				acc.setAccno(rs.getInt(1));
				acc.setAccnm(rs.getString(2));
				acc.setAcctype(rs.getString(3));
				acc.setBalance(rs.getDouble(4));
				list.add(acc);
			}
		
			con.close();
			}
		catch(Exception ex)
		{
		System.out.println(ex);
	}
		return list;
	}
	
	public List<Account> getReport2(String acctype)
	{
		try
		{
			DBConnection db=new DBConnection();
			con=db.Dbconnection();
		
			pst=con.prepareStatement("select * from Accounts where acctype=?");
			pst.setString(1, acctype);
			rs=pst.executeQuery();  
			list=new ArrayList<Account>();
			while(rs.next())
			{
				acc=new Account();
				acc.setAccno(rs.getInt(1));
				acc.setAccnm(rs.getString(2));
				acc.setAcctype(rs.getString(3));
				acc.setBalance(rs.getDouble(4));
				list.add(acc);
			}
		
			con.close();
			}
		catch(Exception ex)
		{
		System.out.println(ex);
	}
		return list;
	}
	
	
	public String updateBalance(int facc,int tacc,double bal)
	{
		String stat=null;
		try
		{
			DBConnection db=new DBConnection();
			con=db.Dbconnection();
			pst=con.prepareStatement("update Accounts set balance=balance-? where accno=?");
			pst.setDouble(1, bal);
			pst.setInt(2, facc);
			int cat=pst.executeUpdate();
			if(cat>0)
			{
				cat=0;
				pst=con.prepareStatement("update Accounts set balance=balance+? where accno=?");
				pst.setDouble(1, bal);
				pst.setInt(2, tacc);
				cat=pst.executeUpdate();
				if(cat>0)
					stat ="Transaction successful........";
				else
					stat = "Transaction failed .......";
			}
			else
				stat = "Transaction failed .......";
		}
		catch(Exception Ex)
		{
			System.out.println(Ex.toString());
		}
		return stat;
	}
	
	public String delAccount(int accno)
	{
		String stat=null;
		try
		{
			DBConnection db=new DBConnection();
			con=db.Dbconnection();
			pst=con.prepareStatement("delete from Accounts where accno=?");
			pst.setInt(1, accno);
			int cat=pst.executeUpdate();
			if(cat>0)
				stat="Account deleted succesfully";
			else
				stat="Account doesn't deleted";
		}
		catch(Exception ex)
		{
			System.out.println(ex.toString());
		}
		return stat;
	}
}
