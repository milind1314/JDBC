package adv_lab_jan09.login_and_register;

import java.util.*;
import java.sql.*;

public class LoginRegister {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		try(sc) {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:orcl", "c##mydbhome","home");

			


			while(true)
			{
				System.out.println("\t\t------Customer Register & Login Process------");
				System.out.println("\t1.Register"
						+ "\n\t2.Login"
						+ "\n\t3.Exit");
				System.out.print("Enter your choice : ");
				int choice = Integer.parseInt(sc.nextLine());
				
				switch (choice) {
				case 1:
					System.out.print("Enter Customer Id : ");
					int rId = Integer.parseInt(sc.nextLine());
					
					System.out.print("Enter Customer UserName : ");
					String  rUser= sc.nextLine();
					
					System.out.print("Enter Customer Password : ");
					String  rPass= sc.nextLine();	
					
					System.out.print("Enter Customer First Name : ");
					String  rFname= sc.nextLine();
					
					System.out.print("Enter Customer Last Name : ");
					String  rLname= sc.nextLine();
					
					System.out.print("Enter Customer Mail Id : ");
					String  rMailId= sc.nextLine();
					
					System.out.print("Enter Customer Phone number : ");
					Long rPhno = Long.parseLong(sc.nextLine());
					
					PreparedStatement pr1 = con.prepareStatement("insert into customer_login values( ?, ?, ?, ?, ?, ?, ?)");
					try {
						
						pr1.setInt(1, rId);
						pr1.setString(2, rUser);
						pr1.setString(3, rPass);
						pr1.setString(4, rFname);
						pr1.setString(5, rLname);
						pr1.setString(6, rMailId);
						pr1.setLong(7, rPhno);
						int k = pr1.executeUpdate();
						if(k>0)
						{
							System.out.println("Successfully Register...");
						}
						else
						{
							System.err.println("Registration failed...!!!");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				
				
				case 2:
					System.out.print("Enter Customer UserName : ");
					String  lUser= sc.nextLine();
					
					System.out.print("Enter Customer Password : ");
					String  lPass= sc.nextLine();
					
					PreparedStatement pr2 = con.prepareStatement("select * from customer_login where CUSTOMER_NAME = ? and CUSTOMER_PASSWORD = ?"); 
					pr2.setString(1, lUser);
					pr2.setString(2, lPass);
					
					ResultSet r = pr2.executeQuery();
					
					if (r.next()) 
					{
					System.out.println("Login Succeessful.");
					boolean repeat = true;
					while(repeat)
					{

						System.out.println("\n\t1.Show all Customer."
								+ "\n\t2.Update Customer Mailid & phone number based on id."
								+ "\n\t3.Delete Customer whose name start with with 's'."
								+ "\n\t4.show those customer whose id is prime number."
								+ "\n\t5.Exit.");	
						
						System.out.print("\nEnter your choice : ");
						int choice1 = Integer.parseInt(sc.nextLine());
						
						switch (choice1) {
						case 1:
							PreparedStatement pr3 = con.prepareStatement("select * from customer_login");
							ResultSet rs = pr3.executeQuery();
							System.out.println("\t\t-------------Customer Details-------------");
							while(rs.next())
							{
								System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getLong(7));
							}
							break;
						case 2:
							System.out.print("Enter Customer ID for update: ");
							int customerId = Integer.parseInt(sc.nextLine());
							PreparedStatement pr4 = con
									.prepareStatement("Select * from customer_login where CUSTOMER_ID = " + customerId);
//							pr4.setInt(1, r.getInt("CUSTOMER_ID"));
							ResultSet rs2 = pr4.executeQuery();
							if (rs2.next()) {

								System.out.println("Existing Mail ID : " + rs2.getString(6));
								System.out.print("New Mail ID : ");
								String nMail = sc.nextLine();

								System.out.println("Existing Phone Number : " + rs2.getLong(7));
								System.out.print("New Phone Number : ");
								long nphno = Long.parseLong(sc.nextLine());

								PreparedStatement pr5 = con.prepareStatement(
										"Update customer_login set CUSTOMER_MAILID = ? , CUSTOMER_PHONENUMBER = ? where CUSTOMER_ID = "
												+ customerId + "");
								pr5.setString(1, nMail);
								pr5.setLong(2, nphno);

								int u = pr5.executeUpdate();

								if (u > 0) {
									System.out.println("Update Successfully...");
								} else {
									System.err.println("Update Failed...");
								}

							} else {
								System.out.println("Customer Id not Found...!");
							}
							
							break;
						case 3:
							PreparedStatement pr6 = con.prepareStatement("Delete from customer_login where CUSTOMER_NAME like 's%'");
							int delete = pr6.executeUpdate();
							if(delete > 0) {
								System.out.println(delete + " customer(s) deleted successfully.");
						    } else {
						        System.out.println("No customers with names starting with 'S' found.");
							}
							break;
						case 4:
							PreparedStatement pr7 = con.prepareStatement("select * from customer_login");
							ResultSet rs3 = pr7.executeQuery();
							int count;
							while(rs3.next())
							{
								count = 1;
								int id = rs3.getInt(1);
								for (int j = 2; j <= id; j++) {
									
									if (id % j == 0) {
										count++;
									}
								}
								if (count == 2) {
									System.out.println(rs3.getInt(1) + "\t" + rs3.getString(2) + "\t" +
											rs3.getString(3) + "\t" + rs3.getString(4) + "\t" +
											rs3.getString(5) + "\t" + rs3.getString(6) + "\t" + rs3.getLong(7));
								}
							}
							break;
						case 5:
							System.out.println("Exiting to home screen...");
							repeat = false;
							break;

						default:
							System.err.println("Invalid input...!!");
							break;
						}
						}
					}
					
					else
					{
						System.out.println("Wrong Password or email...");
					}
					break;

				case 3: 
					System.out.println("Thank You have nice day."
							+ "\nExiting...");
					System.exit(0);
				
				default:
					System.out.println("Operation failed.");
					break;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
