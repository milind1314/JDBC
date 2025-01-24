package adv_procedure_lab_jan23.stundent_details;

import java.sql.*;
import java.util.Scanner;

public class StudentDetails {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		try(in;) {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:orcl","c##mydbhome","home");
			
			CallableStatement cs = con.prepareCall("{call StudentDetails(?,?,?,?,?,?,?,?,?)}");
			
			System.out.print("Enter student id : ");
			int sid = Integer.parseInt(in.nextLine());
			
			System.out.print("Enter student roll no. : ");
			int srn = Integer.parseInt(in.nextLine());
			
			System.out.print("Enter student name : ");
			String sname = in.nextLine();
			
			System.out.print("Enter student branch : ");
			String sbr = in.nextLine();
			
			System.out.print("Enter student house no. : ");
			int shno = Integer.parseInt(in.nextLine());
			
			System.out.print("Enter student city : ");
			String scity = in.nextLine();
			
			System.out.print("Enter student city pincode : ");
			int spin = Integer.parseInt(in.nextLine());
			
			System.out.print("Enter student mail id : ");
			String smid = in.nextLine();
			
			System.out.print("Enter student phone no. : ");
			long sphno = Long.parseLong(in.nextLine());
			
			cs.setInt(1, sid);
			cs.setInt(2, srn);
			cs.setString(3, sname);
			cs.setString(4, sbr);
			cs.setInt(5, shno);
			cs.setString(6, scity);
			cs.setInt(7, spin);
			cs.setString(8, smid);
			cs.setLong(9, sphno);
			
			cs.execute();
			
			System.out.println("Student details successfully inserted.");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
