package customer;
import java.util.*;
public class corporatelogin
{
    Scanner s=new Scanner(System.in);
    static double fdrate;
    static double loanrate;
    static double currentrate;
    static double savingrate;
    static int locleft;
    public corporatelogin() // value may will become default when object is created again
    {
        fdrate=7.5;
        loanrate=10;
        currentrate=5.5;
        savingrate=4.5;
        locleft=50;
    }
    public void changerate()
    {
        System.out.println("\nEnter the choice of rate to update:");
        System.out.println("\n1. FD rate");
        System.out.println("\n2. loan rate");
        System.out.println("\n3. Current Acc rate");
        System.out.println("\n4. Saving Acc rate");
		int ch=0;
		try
		{
			ch=s.nextInt();
			//sc.next();
		}
		catch(Exception e)
		{
			System.out.println("Enter Proper Input Error "+e);
			s.next();
		}
        
        double newrate;
        switch(ch)
        {
            case 1: System.out.println("\n\t\tOld rate= "+fdrate);
                    System.out.println("\n\nEnter new rate");
                    newrate=s.nextDouble();
                    fdrate=newrate;
                    break;
            case 2: System.out.println("\n\t\tOld rate= "+loanrate);      
                    System.out.println("\n\nEnter new rate");
                    newrate=s.nextDouble();loanrate=newrate;
                    break;
            case 3: System.out.println("\n\t\tOld rate= "+currentrate);      
                    System.out.println("\n\nEnter new rate");
                    newrate=s.nextDouble();currentrate=newrate;
                    break;
            case 4: System.out.println("\n\t\tOld rate= "+savingrate);
                    System.out.println("\n\nEnter new rate");
                    newrate=s.nextDouble();
                    savingrate=newrate;
                    break;              
        }
    }
    public void lockeravailability()
    {
        System.out.println("\n\t\tNo of lockers available = " + locleft);
        System.out.println("\n\nEnter the no. of lockers available now");
        locleft=s.nextInt();
        System.out.println("\n\n\t\tLocker value updated");
    }
    public void display() 
    {
        System.out.println("\nFD rate : " + fdrate);
        System.out.println("\nLoan rate : " + loanrate);
        System.out.println("\nCurrent Acc rate : " + currentrate);
        System.out.println("\nSaving Acc rate : " + savingrate);
	}
}