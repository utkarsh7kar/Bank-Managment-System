import customer.*;
import java.util.*;
import java.io.*;
class main1
{
    public static void main(String args[])
    {
        int n=4,n1=4,n2=8,n3=4;
        String strusername=new String();
		String strpassword;
        Scanner sc = new Scanner(System.in);
        regularcust reguser=new regularcust();
        corporatelogin crp=new corporatelogin();
        while(true)
        {
            System.out.println("\n\n\n\n******************************************************************************************\n");
            System.out.println("\n\t\t\t\tWelcome to Swiss Bank\n");
            System.out.println("\n************************************************************************************************\n");
            System.out.println("\n\t\tEnter");
            System.out.println("\n\t\t1 for corporate login");
            System.out.println("\n\t\t2 If you are regular customer");
            System.out.println("\n\t\t3 If you are new customer");
            System.out.println("\n\t\t0 to Exit");
			//while(n)
			try
			{
				System.out.print("\t\t");
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
					try
					{					
						System.out.println("\nEnter Username");
						strusername=sc.next();
					}
					catch(InputMismatchException e)
					{
						System.out.println("Invalid data");
					}
					System.out.println("\nEnter Password");
					strpassword=sc.next();
					String str1="",str2="";
                    try
                    {
                        BufferedReader br1 = new BufferedReader(new FileReader("./corporatelogin.txt"));
                        str1 = br1.readLine();
                        str2 = br1.readLine();
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                    if(str1.equals(strusername) && str2.equals(strpassword))
                    {
                         //if verified
                        while(true)
                        {
                            System.out.println("\n\t\tEnter");
                            System.out.println("\n\t\t1 to set the Interest Rate");
                            System.out.println("\n\t\t2 to update availability status of lockers");
                            System.out.println("\n\t\t3 to Check the Interest Rates ");
                            System.out.println("\n\t\t0 to Logout");
                            try
							{
								System.out.print("\t\t");
								n1= sc.nextInt();
								//sc.next();
							}
							catch(Exception e)
							{
								System.out.println("Enter Proper Input Error "+e);
								sc.next();
							}
                            switch(n1)
                            {
                                case 1:
                                    // provide the new interest rates
                                    crp.changerate();
                                break;
    
                                case 2:
                                    // update the no. of lockers available
                                    crp.lockeravailability();
                                break;

                                case 3:
                                    crp.display();
                                break;
                            }
                            if(n1==0) {System.out.println("Logged out successfully");break;}
                        }
                    }
                    else
                    {
                        System.out.println("Can't Login due to incorrect username or password");
                    }
                break;
               
                case 2:
               
                    BufferedReader br = null;
                    try
                    {
                        br = new BufferedReader(new FileReader("C:/Users/HP/Desktop/bank/userinfo.txt"));
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }					
					System.out.println("\nEnter Username");
					String uname = sc.next();
                    System.out.println("\nEnter Password");
                    String pass = sc.next();
                    String str[] = new String[2];
                    String line;
                    try
                    {
                        while((line = br.readLine()) != null)
                        {
                            str = line.split(" - ");
                            if(str[0].equals(uname))
							{
								break;
							}
                        }
                        br.close();
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                try
                {    
                    if (!str[0].equals(uname))
                    {
                        System.out.println("Username not Found");
                    }
                    else if(str[1].equals(pass))
                    {
                        //login
                        while(true)
                        {
                            System.out.println("\n\n\n\tEnter");
                            System.out.println("\n\t1 to see the Account Details");
                            System.out.println("\n\t2 for fund transfer");
                            System.out.println("\n\t3 to open a Fixed Deposit");
                            System.out.println("\n\t4 to pursue loan");
                            System.out.println("\n\t5 to order Checkbook, PassBook, Debit Card, etc");
                            System.out.println("\n\t6 to book a locker");
                            System.out.println("\n\t0 to Logout");
                            try
							{
								System.out.print("\t");
								n2= sc.nextInt();
								//sc.next();
							}
							catch(Exception e)
							{
								System.out.println("Enter Proper Input Error "+e);
								sc.next();
								n2=8;
							}
                        switch(n2)
                        {
                        // Provide the cases
                        case 1:
                            reguser.display(uname);
                            break;
                        case 2:
                            reguser.fundtransfer(uname);
                            break;
                        case 3:
                            reguser.fd(uname);
                            break;
                        case 4:
                            reguser.loan();
                            break;
                        case 5:
                            reguser.order();
                            break;
                        case 6:
                            reguser.locker();
                            break;
						case 0:
							break;
						default :
								System.out.println("Wrong input");
							break;
						
                        //closing left
                        }
                        if(n2==0)
                        {
                            System.out.println("Logged out successfully");
                            break;
                        }
                    }
                }
                else
                {
                    System.out.println("Pass Incorrect");
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
               
            break;

			case 3:
				
				System.out.println("\n\t\tEnter");
				System.out.println("\n\t\t1 to open a new Account");
				System.out.println("\n\t\t0 to exit");
				System.out.print("\t\t");
				try
				{
					
					n3= sc.nextInt();
				}
				catch(Exception e)
				{
					System.out.println("Enter Proper Input Error "+e);
					sc.next();
				}
				switch(n3)
				{
					// Provide the cases
					case 1:
						   reguser.createuser();
						   break;
					case 0:
						   break;
				}
			break;
			
			case 0:
					break;
                 
                
                default:
                    System.out.println("\nEnter proper Input\n");
					break;
            }
			if(n==0) break;
        }
    }
}