package bankassignment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.lang.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import static bankassignment.Customer.ROUTING_NUMBER;
import static bankassignment.Customer.getAge;

class BankMain {
    Map<String,Customer> customerMap;
    BankMain()
    {
        customerMap = new HashMap <>();
    }
    public static void main(String args[])
    {
        Scanner sc  =  new Scanner(System.in);
        Customer customer;
        String username,password,bankName;
        double amount=0;
        int type=0,temp=0;
        boolean temp1=false,temp2=false,temp3=false,temp4=false,temp5=false,temp6=false,temp7=false,temp8=false;
        double transferAmount=0;
        int routingNumber;
        BankMain bankMain =  new BankMain();
        int choice;
        loop:do
        {
            System.out.println("\n----------------------");
            System.out.println("BANK    OF     IRELAND");
            System.out.println("------------------------\n");
            System.out.println("1. Create your account.");
            System.out.println("2. Login to your account for any transactions.");
            System.out.println("3. Exit.");
            System.out.print("\nEnter your choice : ");
            choice = sc.nextInt();
            sc.nextLine();
            switch(choice) {
                case 1:
                    System.out.print("Enter your name  : ");
                    String name = sc.nextLine();
                    do{
                        Pattern pattern=Pattern.compile("^([A-z][A-Za-z]*\\s+[A-Za-z]*)|([A-z][A-Za-z]*)$");
                        Matcher matcher=pattern.matcher(name);
                        if(matcher.matches()){
                            temp1=true;
                        }
                        else{
                            System.out.println("invalid name!!");
                            name = sc.nextLine();
                        }

                    }while(!temp1);
                    System.out.println("Enter address in the form of( house/flat no, street, city, state, country) : ");
                    String address1 = sc.nextLine();
                    do{
                        Pattern pattern=Pattern.compile("^[#.0-9a-zA-Z\\s,-]+$");
                        Matcher matcher=pattern.matcher(address1);
                        if(matcher.matches()){
                            temp2=true;
                        }
                        else{
                            System.out.println("invalid address!!");
                            address1 = sc.nextLine();
                        }

                    }while(!temp2);
                    System.out.print("Enter contact number : ");
                    String phone = sc.nextLine();
                    do{
                        Pattern pattern=Pattern.compile("\\d{10}");
                        Matcher matcher=pattern.matcher(phone);
                        if(matcher.matches()){
                            temp3=true;
                        }
                        else{
                            System.out.println("invalid mobile number!!");
                            phone = sc.nextLine();
                        }
                    }while(!temp3);
                    System.out.print("Enter adhaar number : ");
                    String adhaar = sc.nextLine();
                    do{
                        Pattern pattern=Pattern.compile("\\d{12}");
                        Matcher matcher=pattern.matcher(adhaar);
                        if(matcher.matches()){
                            temp4=true;
                        }
                        else{
                            System.out.println("invalid adhaar number!!");
                            adhaar = sc.nextLine();
                        }

                    }while(!temp4);
                    System.out.print("Enter pan number : ");
                    String pan = sc.nextLine();
                    do{
                        Pattern pattern = Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}");
                        Matcher matcher = pattern.matcher(pan);
                        if(matcher.matches()){
                            temp5=true;
                        }
                        else{
                            System.out.println("invalid pan number!!");
                            pan = sc.nextLine();
                        }

                    }while(!temp5);
                    System.out.println("enter your date of birth in the form of (yyyy-mm-dd): ");
                    String day=sc.next();
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
                    do{
                        Pattern pattern = Pattern.compile("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$");
                        Matcher matcher = pattern.matcher(day);
                        if(matcher.matches()){
                            temp6=true;

                        }
                        else{
                            System.out.println("invalid date of birth!!");
                            day = sc.nextLine();
                        }

                    }while(!temp6);
                    LocalDate dob = LocalDate.parse(day);
                    System.out.println("Age is:" + getAge(dob));
                    if(getAge(dob)<=0){
                        System.out.println("invalid date of birth");
                    }
                    else if(getAge(dob)>=110){
                        System.out.println("ohhh !!! common its time to die");
                    }
                    else if(getAge(dob)<18){
                        System.out.println(" You are still a minor!!!");
                        System.out.println("enter the name of your guardian: ");
                        String gname=sc.next();
                        do{
                            Pattern pattern=Pattern.compile("^([A-z][A-Za-z]*\\s+[A-Za-z]*)|([A-z][A-Za-z]*)$");
                            Matcher matcher=pattern.matcher(gname);
                            if(matcher.matches()){
                                temp7=true;
                            }
                            else{
                                System.out.println("invalid name!!");
                                gname = sc.nextLine();
                            }

                        }while(!temp7);
                        System.out.println("enter the contact number of your guardian:");
                        String gphone=sc.next();
                        do{
                            Pattern pattern=Pattern.compile("\\d{10}");
                            Matcher matcher=pattern.matcher(gphone);
                            if(matcher.matches()){
                                temp8=true;
                            }
                            else{
                                System.out.println("invalid mobile number");
                                gphone=sc.nextLine();
                            }

                        }while(!temp8);
                        System.out.println("enter the age of your guardian");
                        String gage=sc.next();
                    }
                    System.out.println("enter account type: (1.savings 2.current 3.fixed 4.recurring)");
                    type=sc.nextInt();
                    System.out.println("Set username : ");
                    username = sc.next();
                    while(bankMain.customerMap.containsKey(username))
                    {
                        System.out.println("Username already exists. Set again : ");
                        username = sc.next();
                    }
                    System.out.println("Set a password (minimum 8 chars; minimum 1 digit, 1 lowercase, 1 uppercase, 1 special character[!@#$%^&*_]) :");
                    password = sc.next();
                    sc.nextLine();
                    while(!password.matches((("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*_]).{8,}"))))
                    {
                        System.out.println("Invalid password condition. Set again :");
                        password=sc.nextLine();
                    }
                    System.out.println("Enter initial deposit : ");
                    while(!sc.hasNextDouble())
                    {
                        System.out.println("Invalid amount. Enter again :");
                        sc.nextLine();
                    }
                    amount=sc.nextDouble();
                    sc.nextLine();
                    customer = new Customer(username,password,name,address1,phone,amount,type,adhaar,pan,day);
                    bankMain.customerMap.put(username,customer);
                    break;
                case 2:
                    System.out.println("Enter username : ");
                    username = sc.next();
                    sc.nextLine();
                    System.out.println("Enter password : ");
                    password = sc.next();
                    sc.nextLine();
                    if(bankMain.customerMap.containsKey(username))
                    {
                        customer = bankMain.customerMap.get(username);
                        if(customer.password.equals(password))
                        {
                            while(true)
                            {
                                System.out.println("\n-------------------");
                                System.out.println("W  E  L  C  O  M  E");
                                System.out.println("-------------------\n");
                                System.out.println("1. Deposit.");
                                System.out.println("2. Transfer.");
                                System.out.println("3. Withdraw.");
                                System.out.println("4. User information.");
                                System.out.println("5. Logout.");
                                System.out.print("\nEnter your choice : ");
                                choice = sc.nextInt();
                                sc.nextLine();
                                switch(choice)
                                {
                                    case 1:
                                        System.out.print("Enter amount : ");
                                        while(!sc.hasNextDouble())
                                        {
                                            System.out.println("Invalid amount. Enter again :");
                                            sc.nextLine();
                                        }
                                        amount = sc.nextDouble();
                                        sc.nextLine();
                                        System.out.println("enter account type: (1.savings 2.current 3.fixed 4.recurring");
                                        type=sc.nextInt();
                                        if(type==1){
                                            customer.sDeposit(amount);
                                        }
                                        else if(type==2){
                                            customer.cDeposit(amount);
                                        }
                                        else if(type==3){
                                            customer.fDeposit(amount);
                                        }
                                        else{
                                            customer.rDeposit(amount);
                                        }
                                        break;
                                    case 2:
                                        System.out.print("Enter payee username : ");
                                        username = sc.next();
                                        sc.nextLine();
                                        System.out.println("Enter amount : ");
                                        while(!sc.hasNextDouble())
                                        {
                                            System.out.println("Invalid amount. Enter again :");
                                            sc.nextLine();
                                        }
                                        amount = sc.nextDouble();
                                        sc.nextLine();
                                        if(amount > 300000)
                                        {
                                            System.out.println("Transfer limit exceeded. Contact bankMain manager.");
                                            break;
                                        }
                                        System.out.println("Please enter recipient's routing number: ");
                                        routingNumber = sc.nextInt();
                                        {
                                            if (ROUTING_NUMBER == 12345) {
                                            bankName = "Bank of Ireland";
                                            }
                                            else {
                                            bankName = "Other bank";
                                            }
                                        }
                                        if (routingNumber == ROUTING_NUMBER) {
                                            System.out.println("Your funds will transfer instantly, you and your recipient share the same bank!");
                                            System.out.println("Bank name: " + bankName);
                                        } else {
                                            System.out.println("Your funds will transfer in 2-3 business days.");
                                        }
                                        /*customer.balance -= transferAmount;
                                        customer.balance += transferAmount;*/
                                        if(bankMain.customerMap.containsKey(username))
                                        {
                                            Customer payee = bankMain.customerMap.get(username);
                                            if(type==1){
                                                payee.sDeposit(amount);
                                                customer.sWithdraw(amount);
                                            }
                                            else if(type==2){
                                                payee.cDeposit(amount);
                                                customer.cWithdraw(amount);
                                            }
                                            else if(type==3){
                                                payee.fDeposit(amount);
                                            }
                                            else{
                                                customer.rDeposit(amount);
                                            }
                                        }
                                        else
                                        {
                                            System.out.println("Username doesn't exist.");
                                        }
                                        break;
                                    case 3:System.out.print("Enter amount : ");
                                        while(!sc.hasNextDouble())
                                        {
                                            if(amount<customer.balance)
                                            System.out.println("Invalid amount or amount is more than existing balance. Enter again :");
                                            sc.nextLine();
                                        }
                                        amount = sc.nextDouble();
                                        sc.nextLine();
                                        System.out.println("enter your account type:(1.savings 2.current 3.fixed 4.recurring.");
                                        type=sc.nextInt();
                                        if(type==1){
                                            customer.sWithdraw(amount);
                                        }
                                        else if(type==2){
                                            customer.cWithdraw(amount);
                                        }
                                        else if(type==3){
                                            System.out.println("You cannot withdraw as yours is fixed deposit account you can withdraw after the maturity");
                                        }
                                        else{
                                           System.out.println("withdraw is not allowed in recurring deposit account");
                                        }
                                        break;

                                    case 4:
                                        System.out.println("Account holder name : "+customer.name);
                                        System.out.println("Account holder address is : "+customer.address1);
                                        System.out.println("Account holder contact : "+customer.phone);
                                        System.out.println("Account holder balance :"+customer.balance);
                                        break;
                                    case 5:
                                        System.out.println("\nThank you for choosing BankMain Of Ireland.");
                                        continue loop;
                                    default:
                                        System.out.println("Wrong choice !");
                                }
                            }
                        }
                        else
                        {
                            System.out.println("Wrong username/password.");
                        }
                    }
                    else
                    {
                        System.out.println("Wrong username/password.");
                    }
                    break;

                case 3:
                    System.out.println("\nThank you for choosing BankMain Of Ireland.");
                    System.exit(1);
                    break;
                default:
                    System.out.println("Wrong choice !");
            }
        }while(choice!=3);
    }
}

