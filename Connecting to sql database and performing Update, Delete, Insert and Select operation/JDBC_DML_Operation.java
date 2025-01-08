package adv_lab_jan08;

import java.sql.*;
import java.util.*;

public class JDBC_DML_Operation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try (sc) {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "c##mydbhome",
					"home");

			Statement stm = con.createStatement();

			ResultSet rs = stm.executeQuery("select * from EMPLOYEE_INFO");

			System.out.println("\n\t\t----------Employee Records-----------");

			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(4)
						+ "\t" + rs.getString(5) + "\t" + rs.getLong(6));
			}

			System.out.println("\n\t\t----------Operation Choice-----------");
			System.out.println("1.Insert Employee Record" 
					+ "\n2.Update Empoyee Record" 
					+ "\n3.Find Employee whose name starts with "
					+ "\n4.Count Total Employees"
					+ "\n5.Delete Employee With Maximum Salary"
					+ "\n6.Display All Employee Records");

			System.out.print("Enter your choice : ");
			int choice = Integer.parseInt(sc.nextLine());

			switch (choice) 
			{
			case 1:
				System.out.println("\n\t\t------------Insert a new record-------------");
				System.out.print("Enter employee id : ");
				int iId = Integer.parseInt(sc.nextLine());
				System.out.print("Enter employee name : ");
				String iName = sc.nextLine();
				System.out.print("Enter employee Salary : ");
				double iSal = Double.parseDouble(sc.nextLine());
				System.out.print("Enter employee city : ");
				String iCity = sc.nextLine();
				System.out.print("Enter employee mailId : ");
				String imailId = sc.nextLine();
				System.out.print("Enter employee Phone number : ");
				long iPhone = Long.parseLong(sc.nextLine());
				
				int ins = stm.executeUpdate("insert into EMPLOYEE_INFO values("+iId+", '"+iName+"', "+iSal+", '"+iCity+"', '"+imailId+"', "+iPhone+")");

				if (ins > 0) 
				{
					System.out.println("Employee details inserted successfully...");
				}
			
			else 
			{
				System.out.println("Employee record already exist...");
			}
				break;

			case 2:
				System.out.println("\n\t\t----------Update Employee Record-----------");
				System.out.println("Enter the Employee-Id to perform Update Operation:");
				int cId = Integer.parseInt(sc.nextLine());
				ResultSet rs2 = stm.executeQuery("select * from EMPLOYEE_INFO where EMPID =" + cId + "");
				if (rs2.next()) 
				{
					System.out.println("Existing salary: " + rs2.getDouble(3));
					System.out.print("Enter new salary: ");
					double nsal = Double.parseDouble(sc.nextLine());

					System.out.println("Existing mail ID : " + rs2.getString(5));
					System.out.print("Enter new mail ID : ");
					String nmailID = sc.nextLine();

					System.out.println("Existing phone number : " + rs2.getLong(6));
					System.out.print("Enter new phone number : ");
					long nphno = Long.parseLong(sc.nextLine());

					int k = stm.executeUpdate("update EMPLOYEE_INFO set EMPSALARY = " + nsal + ", EMPMAILID = '"
							+ nmailID + "', EMPPHNO = " + nphno + " where EMPID = " + cId + "");

					if (k > 0) 
					{
						System.out.println("Employee details update successfully...");
					}
				}
				else 
				{
					System.out.println("Invalid Employee-Id...");
				}
				break;

			case 3:
				System.out.println("\n\t\t----------Finding Employee Record-----------");

				try {
					System.out.print("Enter first initials of employee whome you want to find : ");
					char f = sc.next().charAt(0);
					
					rs = stm.executeQuery("select * from EMPLOYEE_INFO where empname like '"+Character.toUpperCase(f)+"%'");
					
					System.out.println("\n\t\t----------Matching Employees-----------\n");
					while(rs.next()) 
					{
						System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getDouble(3) + "\t" + rs.getString(4)
						+ "\t" + rs.getString(5) + "\t" + rs.getLong(6));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
					
				break;

			case 4:
				System.out.println("\n\t\t----------Counting Employee Records-----------");

				rs = stm.executeQuery("select count(*) from EMPLOYEE_INFO");
				if (rs.next()) {
					System.out.println("Total number of employee is : "+rs.getInt(1));
				}
				break;

			case 5:
				System.out.println("\n\t\t----------Delete Employee Record-----------");

				rs = stm.executeQuery("select empid from EMPLOYEE_INFO where empsalary = (select max(empsalary) from EMPLOYEE_INFO)");
				if (rs.next()) {
					int dempId = rs.getInt(1);
					int rs3 = stm.executeUpdate("DELETE FROM EMPLOYEE_INFO WHERE EMPID = " + dempId+"");
					if (rs3 > 0) {
						System.out.println("Employee record successfully deleted.");
					} else {
						System.out.println("deletion failed");
					}
				}
				else {
					System.out.println("No Employee found...");
				}
				break;
				
			case 6:
				ResultSet rs1 = stm.executeQuery("select * from EMPLOYEE_INFO");

				System.out.println("\n\t\t----------All Employee Records-----------");

				while (rs1.next()) {
					System.out.println(rs1.getInt(1) + "\t" + rs1.getString(2) + "\t" + rs1.getDouble(3) + "\t"
							+ rs1.getString(4) + "\t" + rs1.getString(5) + "\t" + rs1.getLong(6));
				}
				break;
				
			default:
				System.out.println("Invalid Choice.....");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
