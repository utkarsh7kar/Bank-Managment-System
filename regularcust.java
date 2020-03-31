package customer;
import java.util.*;
import java.io.*;
public class regularcust extends newcustomer
{
    Scanner sc = new Scanner(System.in);

    public void display(String username)
    {
        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new FileReader("C:/Users/HP/Desktop/bank/users/"+username+".txt"));
        }
	    catch(Exception e)
        {
            System.out.println(e);
        }
        try
        {
                System.out.println("\n\n\t\t\tAcc NO : " + br.readLine());
                System.out.println("\t\t\tIFSC Code : " + br.readLine());
                System.out.println("\t\t\tAcc Type : " + br.readLine());
                System.out.println("\t\t\tAcc Balance : " + br.readLine());
                br.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void fd(String uname)
    {
		int n=0,m=0;
        System.out.println("Enter the amount for the FD");
        
		try
		{
			do{
				n = sc.nextInt();
				if(n<0) System.out.println("\nEnter Proper Input");
				
			}while(n<0);	
			//sc.next();
		}
		catch(Exception e)
		{
			System.out.println("Enter Proper Input Error "+e);
			sc.next();
		}      
		try
        {
            FileReader fr = new FileReader("C:/Users/HP/Desktop/bank/users/"+uname+".txt");
            BufferedReader br = new BufferedReader(fr);
            String line1 = br.readLine();
            String line2 = br.readLine();
            String line3 = br.readLine();
            String line4 = br.readLine();
            //System.out.println(line1 + " " + line2 + " " + line3 + " " + line4);
            double bal = Double.parseDouble(line4);
            bal-=n;
            br.close();
            fr.close();
            if(bal<5000) System.out.println("\nFD can't be issued due to low account balance");
            else{
					System.out.println("Enter the time duration for the FD in months");
					//System.out.print("\t\t");
					try
					{
						do{
							m = sc.nextInt();
							if(m<0) System.out.println("\nEnter Proper Input");
							
						}while(m<0);	
						//sc.next();
					}
					catch(Exception e)
					{
						System.out.println("Enter Proper Input Error "+e);
						sc.next();
					}
					
					FileWriter fw = new FileWriter("C:/Users/HP/Desktop/bank/users/"+uname+".txt");
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(line1+"\n");
                    bw.write(line2+"\n");
                    bw.write(line3+"\n");
                    line4 = bal + "";
                    bw.write(line4+"\n");
                    System.out.println("\t\tFD Issued");
                    double fd = n + corporatelogin.fdrate*n/100;
                    fd = fd*m/12;
                    System.out.println("\t\tFD maturity amount after " + m + " months is " + fd);
                    bw.close();
                    fw.close();
                }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void order()
    {
        System.out.println("\n\nEnter\n\n1 to order Checkbook\n\n2 to order Passbook\n\n3 to debit card");
        int n = sc.nextInt();
        switch(n)
        {
        case 1:
            System.out.println("\n\t\tCheckbook Ordered Successfully");
            break;
        case 2:
            System.out.println("\n\t\tPassbook Ordered Successfully");
            break;
        case 3:
            System.out.println("\n\t\tDebit Card Ordered Successfully");
            break;
        default :
            System.out.println("\n\t\tEnter proper input");
        }
    }
    public void loan()
    {
		double n=0;
        System.out.println("\n\n\t\tEnter the loan amount");
		System.out.print("\t\t");
		try
		{
			do{
				n = sc.nextDouble();
				if(n<0) System.out.println("\nEnter Proper Input");
				
			}while(n<0);	
			//sc.next();
		}
		catch(Exception e)
		{
			System.out.println("Enter Proper Input Error "+e);
			sc.next();
		}
        
        System.out.println("\t\t\tSelect time duration for the Loan amount to returned");
        System.out.println("Enter\n\n1 to select 1 year\n\n2 to select 5 year\n\n3 to select 10 year");
        int m = sc.nextInt();
 
        double ln = n + n*corporatelogin.loanrate/100;
        if(m==2) ln = ln*5;
        else if(m==3) ln = ln*10;
        System.out.println("\t\t\tLoan amount to returned : " + ln);
        System.out.println("\n\n\t\t\tYou will be notified if eligible");
    }
    public void locker()
    {
        System.out.println("\n\t\tEnter Y to book the E-locker");
		System.out.print("\t\t");
        char c = sc.next().charAt(0);
        if(c=='y' || c=='Y')
        {
            if(corporatelogin.locleft-1 >= 0)
            {
                System.out.println("\n\t\t\tLocker reserved successfully");
            }
            else
            {
                System.out.println("\n\t\t\tLocker not available");
            }
        }
        else
        {
            System.out.println("\n\t\tLocker not Reserved");
        }
    }
    public void fundtransfer(String uname)
    {
        System.out.println("\n\nEnter\n\n1 to deposit money\n\n2 for withdrawal");
        //long ln = sc.nextLong();
        double n1=0;
		int n=0;
		try
		{
			n = sc.nextInt();
			//sc.next();
		}
		catch(Exception e)
		{
			System.out.println("Enter Proper Input Error "+e);
			sc.next();
		}  
        
        switch(n)
        {
            case 1:
                System.out.println("\n\nEnter the amount to be deposited");
				try
				{
					do{
						n1 = sc.nextDouble();
						if(n1<0) System.out.println("\nEnter Proper Input");
						
					}while(n1<0);
					
					//sc.next();
				}
				catch(Exception e)
				{
					System.out.println("Enter Proper Input Error "+e);
					sc.next();
				}      
                try
                {
                    FileReader fr = new FileReader("C:/Users/HP/Desktop/bank/users/"+uname+".txt");
                    BufferedReader br = new BufferedReader(fr);
                    String line1 = br.readLine();
                    String line2 = br.readLine();
                    String line3 = br.readLine();
                    String line4 = br.readLine();
                    //System.out.println(line1 + " " + line2 + " " + line3 + " " + line4);
                    double bal = Double.parseDouble(line4);
                    bal+=n1;
                    br.close();
                    fr.close();

                    FileWriter fw = new FileWriter("C:/Users/HP/Desktop/bank/users/"+uname+".txt");
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(line1+"\n");
                    bw.write(line2+"\n");
                    bw.write(line3+"\n");
                    line4 = bal + "";
                    bw.write(line4+"\n");
                    bw.close();
                    fw.close();
                }     //end try
                catch (Exception e)
                {
                    System.out.println(e);
                }
            break;

            case 2:
                System.out.println("\n\nEnter the amount to be withdrawn");
				//System.out.println(\t\t);
				try
				{
					do{
						n1 = sc.nextDouble();
						if(n1<0) System.out.println("\nEnter Proper Input");
						
					}while(n1<0);
					//sc.next();
				}
				catch(Exception e)
				{
					System.out.println("Enter Proper Input Error "+e);
					sc.next();
					break;
				}  
                
                try
                {
                    FileReader fr = new FileReader("C:/Users/HP/Desktop/bank/users/"+uname+".txt");
                    BufferedReader br = new BufferedReader(fr);
                    String line1 = br.readLine();
                    String line2 = br.readLine();
                    String line3 = br.readLine();
                    String line4 = br.readLine();
                    //System.out.println(line1 + " " + line2 + " " + line3 + " " + line4);
                    double bal = Double.parseDouble(line4);
                    bal-=n1;
                    if(bal<5000) System.out.println("Withdrwan not possible");

                    else{
                    br.close();
                    fr.close();
                    FileWriter fw = new FileWriter("C:/Users/HP/Desktop/bank/users/"+uname+".txt");
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(line1+"\n");
                    bw.write(line2+"\n");
                    bw.write(line3+"\n");
                    line4 = bal + "";
                    bw.write(line4+"\n");
                    System.out.println("Withdrawal Successful");
                    bw.close();
                    fw.close();
                    }
                    //System.out.println("Withdrawal Successful");
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
                break;
        }
    }
}