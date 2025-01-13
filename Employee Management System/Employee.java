package assignment3.employeeSalary;

import java.sql.*;

import java.util.Scanner;

public class Employee {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		//(eid,ename,edesg,bsal,hra,da,totsal)
		try (sc) 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "c##mydbhome", "home");
			
			
			while(true)
			{
				System.out.println("\n\t\t\t---------------Welcome Employee Records---------------");
				System.out.println("1.Add Employee.\r\n"
						+ "2.View All Employees.\r\n"
						+ "3.View Employee By Id.\r\n"
						+ "4.Update Employee By Id(bSal,hra,da,totSal).\r\n"
						+ "5.Delete Employee By Id.\r\n"
						+ "6.Exit.\n");
				System.out.print("Enter your choice : ");
				int choice = Integer.parseInt(sc.nextLine());
				switch (choice) 
				{
				case 1:
					System.out.println("\n\t\t\t---------------Inserting Employee Record---------------\n");
					System.out.print("Enter employee id : ");
					int eid = Integer.parseInt(sc.nextLine());
					
					System.out.print("Enter employee name : ");
					String ename = sc.nextLine();
					
					System.out.print("Enter employee designation : ");
					String edesg = sc.nextLine();
					
					System.out.print("Enter employee Salary : ");
					double esal = Double.parseDouble(sc.nextLine());
					
					if (esal < 0) {
					    System.err.println("Basic Salary must be Positive.");
					    break;
					}
					
					double hra = esal*0.96;
					double da = esal*0.61;
					double tsal = esal+hra+da;
					
					
					
					
					PreparedStatement pr1 = con.prepareStatement("Insert into Employee70 values(?, ?, ?, ?, ?, ?, ?)");
					
					pr1.setInt(1, eid);
					pr1.setString(2, ename);
					pr1.setString(3, edesg);
					pr1.setDouble(4, esal);
					pr1.setDouble(5, hra);
					pr1.setDouble(6, da);
					pr1.setDouble(7, tsal);
					
					int i = pr1.executeUpdate();
					if (i>0) 
					{
						System.out.println("Employee Record insert successfully");
					}
					else 
					{
						System.err.println("Operation failed...!");
					}
					break;
					
				case 2:
					System.out.println("\n\t\t\t---------------Employee Details---------------\n");
					PreparedStatement pr2 = con.prepareStatement("select * from Employee70");
					
					ResultSet rs = pr2.executeQuery();
					
					while(rs.next())
					{
						System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getDouble(4)+"\t"+rs.getDouble(5)+"\t"+rs.getDouble(6)+"\t"+rs.getDouble(7));
					}
					break;
					
				case 3:
					System.out.print("Enter employee id to view details : ");
					int vid = Integer.parseInt(sc.nextLine());
					
					PreparedStatement pr3 = con.prepareStatement("select * from Employee70 where Eid = "+vid+"");
					
					ResultSet rs1 = pr3.executeQuery();
					
					if (rs1.next()) 
					{
						System.out.println("\n\t\t\t---------------Employee detail of id "+vid+"---------------");
						System.out.println();
						System.out.println(rs1.getInt(1)+"\t"+rs1.getString(2)+"\t"+rs1.getString(3)+"\t"+rs1.getDouble(4)+"\t"+rs1.getDouble(5)+"\t"+rs1.getDouble(6)+"\t"+rs1.getDouble(7));
					}
					else
					{
						System.err.println("Employee not found");
					}
					break;
					
				case 4:
					System.out.println("\n\t\t\t---------------Update Employee by Id---------------\n");
					System.out.print("Enter employee id : ");
					int uid = Integer.parseInt(sc.nextLine());
					
					PreparedStatement pr4 = con.prepareStatement("select * from Employee70 where Eid = "+uid+"");
					ResultSet rs2 = pr4.executeQuery();
					if (rs2.next()) 
					{
						System.out.println("Enter new salary : ");
						double usal = Double.parseDouble(sc.nextLine());
						
						double uhra = usal*0.96;
						double uda = usal*0.61;
						double utsal = usal+uhra+uda;
						
						PreparedStatement pr5 = con.prepareStatement("Update Employee70 set BASICSALARY = ?, HRA = ?, DA = ?, TOTALSALARY = ? where EID = ?");
						
						pr5.setDouble(1, usal);
						pr5.setDouble(2, uhra);
						pr5.setDouble(3, uda);
						pr5.setDouble(4, utsal);
						pr5.setInt(5, uid);
						
						int u = pr5.executeUpdate();
						
						if (u>0) 
						{
							System.out.println("Empoyee salary updated successfully...");
						}
						else
						{
							System.err.println("Employee not found...!");
						}				
					}					
					else
					{
						System.err.println("Employee not found...!");
					}				
					
					break;
					
				case 5:
					System.out.println("\n\t\t\t---------------Delete Employee by Id---------------\n");
					System.out.print("Enter employee id : ");
					int did = Integer.parseInt(sc.nextLine());
					
					PreparedStatement pr6 = con.prepareStatement("select * from Employee70 where Eid = "+did+"");
					ResultSet rs3 = pr6.executeQuery();
					
					if(rs3.next())
					{
						System.out.println("Employee deleted successfully!");
					}
					else
					{
						System.err.println("Employee not found...!");
					}
					
					break;
					
				case 6:
					System.out.println("Thank you for visiting.");
					System.out.println("Exiting...");
					System.exit(0);

				default:
					System.err.println("Invalid Input..!");
					break;
				}
			}
			
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

	}

}


