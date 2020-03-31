package customer;
import java.util.*;
import java.io.*;
public class newcustomer
{
    Scanner s=new Scanner(System.in);
    Random rand=new Random();
  
    int n2=0;
    String username;
    String password;
    long accno;
    String ifsc="";
    String acctype;
    double balance;

    public void createuser()
    {
        System.out.println("\n\n\t\tCreate username");
        if(n2!=0) s.nextLine();  n2++;
		System.out.print("\t\t");
        username=s.next();
		BufferedReader br = null;
			try
			{
				br = new BufferedReader(new FileReader("C:/Users/HP/Desktop/bank/userinfo.txt"));
			}
			catch(Exception e)
			{
				System.out.println(e);
			}					
			String str[] = new String[2];
			String line;
			try
			{
				while((line = br.readLine()) != null)
				{
					str = line.split(" - ");
					if(str[0].equals(username))
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
			if (str[0].equals(username))
			{
				System.out.println("Username already Found");
			}
			else if(!str[0].equals(username))
			{
				//*****
				int flag=0;
				do
				{
					System.out.println("\n\t\tCreate password");
					System.out.print("\t\t");
					password=s.next();
					System.out.println("\n\t\tEnter password again");
					//s.nextLine();
					System.out.print("\t\t");
					String confirmpass=s.next();
					if(password.equals(confirmpass))
					{
						flag=1;
						File file=new File("userinfo.txt");
						PrintWriter output;
						try{
							FileWriter writer = new FileWriter(file, true);
							output=new PrintWriter(writer);
							output.println(username+" - "+password);
							output.close();
						}
						catch(Exception e)
						{
							System.out.println(e);
						}
					}
					else
					{
						System.out.println("Password mismatch Enter again");
					}
				}while(flag!=1);

				File file=new File("C:/Users/HP/Desktop/bank/users/"+username+".txt");
				PrintWriter output;

				try
				{
					FileWriter writer = new FileWriter(file,true);
					output=new PrintWriter(writer);
				   
					accno = (int)(rand.nextDouble()*100000000);
					output.println(accno);
					ifsc="";
					ifsc+="SWS-";
					int ran=rand.nextInt();
					ifsc+=ran;
					output.println(ifsc);
					System.out.println("\n\t\tEnter the type Saving or Current");
			
					do
					{
						System.out.print("\t\t");
						acctype=s.next();
						if(!(acctype.toLowerCase().equals("saving") || acctype.toLowerCase().equals("current")))
							System.out.println("\t\tEnter Proper Input");
					}while(!(acctype.toLowerCase().equals("saving") || acctype.toLowerCase().equals("current")));
					
					output.println(acctype);
					do
					{
						System.out.println("\n\t\tDeposit Your initial balance minimum 5000");
						System.out.print("\t\t");
						try
						{
							balance=s.nextInt();
							//sc.next();
						}
						catch(Exception e)
						{
							System.out.println("Enter Proper Input Error "+e);
							s.next();
						}
						if(balance<5000)
						{
							System.out.println("\n\t\tMinimun should be 5000");
						}
						else
						{
							output.println(balance);
							System.out.println("\n\n\t\t\tAccount Created:");
						}
					   
					}while(balance<5000);
					output.close();
				}
				catch(IOException ex)
				{
					System.out.println("Error:"+ex);
				}
			}
		}
		catch(Exception e)
		{}
    }
}
