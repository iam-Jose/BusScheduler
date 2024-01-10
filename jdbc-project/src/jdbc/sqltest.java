package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class sqltest {

public static void main(String[] args) throws Exception {
// TODO Auto-generated method stub
//try {
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "password");
Statement st = con.createStatement();
String cit = "\"Los Angeles\"";
String msql = "SELECT * FROM employee.persons WHERE City = " + cit;

String newb = "INSERT into Persons VALUES(1, \"v\", \"brisy\", \"11039 1st street\", \"Los Angeles\");";
st.executeUpdate(newb);

ResultSet rs = st.executeQuery(msql);

while (rs.next()) {
String LastName = rs.getString("LastName");
String FirstName = rs.getString("FirstName");
String City = rs.getString("City");    
System.out.println(FirstName + " " + LastName + " " + City);
}
st.close();
con.close();
}
//catch (SQLException exc) {
// System.out.print("exception");
//}

}
