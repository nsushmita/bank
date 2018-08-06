package bankassignment;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.lang.String;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class Customer implements SavingsAccount,CurrentAccount,ReccuringDeposit,FixedDeposit {
    String username,password,name,address1,phone,adhaar,pan,day;
    double balance;
    int type;
    String bankName;
    static final int ROUTING_NUMBER = 12345;
    static boolean temp=false;
    ArrayList<String> transactions;
    Customer(String username,String password,String name,String address1,String phone,double balance,int type,String adhaar,String pan,String day)
    {
        this.username = username;
        this.password = password;
        this.name = name;
        this.address1 = address1;
        this.phone = phone;
        this.balance = balance;
        this.type=type;
        this.adhaar=adhaar;
        this.pan=pan;
        this.day=day;
        transactions  =  new ArrayList<>(100);
        addTransaction(String.format("Initial deposit - " +NumberFormat.getCurrencyInstance().format(balance)));
    }
    public void sDeposit(double amount)
    {
        balance += rate*balance;
        balance += amount;
        addTransaction(String.format(NumberFormat.getCurrencyInstance().format(amount)+" credited to your account. Balance - " +NumberFormat.getCurrencyInstance().format(balance)));
    }
    public void sWithdraw(double amount)
    {
        if(amount>(balance-200))
        {
            System.out.println("Insufficient balance.");
            return;
        }
        balance -= amount;
        addTransaction(String.format(NumberFormat.getCurrencyInstance().format(amount)+" debited from your account. Balance - " +NumberFormat.getCurrencyInstance().format(balance)));
    }
    public void cDeposit(double amount)
    {
        balance += amount;
        addTransaction(String.format(NumberFormat.getCurrencyInstance().format(amount)+" credited to your account. Balance - " +NumberFormat.getCurrencyInstance().format(balance)));
    }
    public void cWithdraw(double amount)
    {
        if(amount>(balance-200))
        {
            System.out.println("Insufficient balance.");
            return;
        }
        balance -= amount;
        addTransaction(String.format(NumberFormat.getCurrencyInstance().format(amount)+" debited from your account. Balance - " +NumberFormat.getCurrencyInstance().format(balance)));
    }
    public void fDeposit(double amount)
    {
        balance += (time*frate*balance)/100;
        balance += amount;
        addTransaction(String.format(NumberFormat.getCurrencyInstance().format(amount)+" credited to your account. Balance - " +NumberFormat.getCurrencyInstance().format(balance)));
    }
    public void rDeposit(double amount)
    {
        balance += rrate*balance;
        balance += amount;
        addTransaction(String.format(NumberFormat.getCurrencyInstance().format(amount)+" credited to your account. Balance - " +NumberFormat.getCurrencyInstance().format(balance)));
    }
    private void addTransaction(String message)
    {
        transactions.add(0,message);
        if(transactions.size()>100)
        {
            transactions.remove(5);
            transactions.trimToSize();
        }
    }

    public boolean isValidDate(String date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        Date testDate = null;
        try
        {
            testDate = sdf.parse(date);

        }
        catch (ParseException e)
        {
            System.out.println("the date you provided is in an invalid date" +" format.");
            return false;
        }
        if (!sdf.format(testDate).equals(date))
        {
            System.out.println("The date that you provided is invalid.");
            return false;
        }
        return true;
    }
    public static int getAge(LocalDate dob) {
        LocalDate curDate = LocalDate.now();
        return Period.between(dob, curDate).getYears();
    }



}




