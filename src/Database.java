import java.sql.*;

public class Database {
    Connection con = null;
    Statement stmt = null;
    String url = "jdbc:mysql://127.0.0.1:3306/airline";
    String user = "root";
    String passwd = "1234";

    /* connect to database */
    Database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, passwd);
            stmt = con.createStatement();
            System.out.println("Connect Succeeded");
        } catch (Exception e) {
            System.out.println("Connect Failed " + e.toString());
        }
    }

    /* check login info */
    boolean logincheck(String _i, String _p) {
        boolean check = false;

        String id = _i;
        String pw = _p;

        try {
            String checkingStr = "SELECT password FROM member WHERE id='" + id + "'";
            ResultSet result = stmt.executeQuery(checkingStr);

            int count = 0;
            while(result.next()) {
                if (pw.equals(result.getString("password"))) {
                    check = true;
                    System.out.println("Login Successful");
                }

                else {
                    check = false;
                    System.out.println("Login Failed");
                }
                count++;
            }
        } catch (Exception e) {
            check = false;
            System.out.println("Login Failed " + e.toString());
        }

        return check;
    }

    /* make db for user */
    boolean joinCheck(String _i, String _p) {
        boolean check = false;

        try {
            String insertStr = "INSERT INTO member VALUES('" + _i + "', '" + _p + "')";
            stmt.executeUpdate(insertStr);
            
            check = true;
            System.out.println("Sign Up Successful");
        } catch (Exception e) {
            check = false;
            System.out.println("Sign up Failed in db" + e.toString());
        }

        return check;
    }

}
