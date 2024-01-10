package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.text.MessageFormat;
import java.util.Scanner;

public class BusTransitSystem {

	public static void main(String[] args) throws Exception {
		//initialize connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pomonatransitsystem", "root", "password"); 
		Statement st = con.createStatement();
		//start input scanner
		Scanner kb = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("What do you want to do:\n"
	    				  +"(1) Display schedule\n"
	    				  +"(2) Edit a schedule\n"
	    				  +"(3) Display stops of a given trip\n"
	    				  +"(4) Display weekly schedule of a given driver/date\n"
	    				  +"(5) Add a driver\n"
	    				  +"(6) Add a bus\n"
	    				  +"(7) Delete a bus\n"
	    				  +"(8) Record actual trip stop info\n");

	    int input = kb.nextInt();
	    
		//input into database switch case
		switch(input) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:		//add driver
			System.out.println("DriverID: ");
			int driverID = kb.nextInt();
			kb.nextLine();
			System.out.println("Driver Name: ");
			String driverName = kb.nextLine();
			//kb.nextLine();
			System.out.println("Driver Phone Number: ");
			String driverPhone = kb.nextLine();
			kb.close();
			String addDriver = "INSERT into driver VALUES("+driverID+", \""+driverName+"\", \""+driverPhone+"\");";
			//INSERT INTO `pomonatransitsystem`.`driver`
			st.executeUpdate(addDriver);
			break;
		case 6:		//add a bus
			System.out.println("BusID: ");
			int busid = kb.nextInt();
			kb.nextLine();
			System.out.println("Model: ");
			String bmodel = kb.nextLine();
			System.out.println("Year: ");
			int byear = kb.nextInt();
			kb.close();
			String addBus = "INSERT into Bus VALUES("+busid+", \""+bmodel+"\", "+byear+");";
			//System.out.println(addBus);
			st.executeUpdate(addBus);
			break;
		case 7:		//delete a bus
			System.out.println("Enter Bus ID ");
			busid = kb.nextInt();
			kb.nextLine();
			String delBus = "DELETE FROM bus WHERE BusID="+busid+";";
			st.executeUpdate(delBus);
			break;
		case 8: //insert actual trip info
			int tripNum, scheduledStart,stopNum, scheduledArrival, actualStart, actualArrival, numPassengersIn, numPassengersOut;
			System.out.print("Trip Number: ");
			tripNum = kb.nextInt();
			kb.nextLine();
			System.out.print("\nDate: ");
			String yyyymmdd = kb.nextLine();
			System.out.print("\nStop Number: ");
			stopNum = kb.nextInt();
			System.out.print("\n Scheduled Start Time: ");
			scheduledStart = kb.nextInt();
			System.out.print("\nActual Start Time: ");
			actualStart = kb.nextInt();
			System.out.print("\nScheduled Arrival Time: ");
			scheduledArrival = kb.nextInt();
			System.out.print("\nActual arrival time: ");
			actualArrival = kb.nextInt();
			System.out.print("\nNumber of Passengers IN: ");
			numPassengersIn = kb.nextInt();
			System.out.print("\nNumber of Passengers OUT: ");
			numPassengersOut = kb.nextInt();

			String recordActual ="INSERT into actualtripstoninfo VALUES("+tripNum+", \""+yyyymmdd+"\", "+scheduledStart+", "+stopNum+", "+scheduledArrival+", "+actualStart+", "+actualArrival+", "+numPassengersIn+", "+numPassengersOut+")";
			st.executeUpdate(recordActual);
			break;
		default:
			System.out.println("Not valid");
			break;
		}
		st.close(); 
		con.close();
	}
}