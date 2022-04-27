package login;

import java.sql.*;
import controller.*;

public class Login {
    private Connection con;
    private Statement sql;
    private ResultSet res;

    public boolean login(String ac, String pw) {
        con = Connecter.connectDB();

        if (con == null || ac.length() > 10 || pw.length()>10) return false;
        String sqlcmd = "SELECT * FROM admin";
        try {
            sql = con.createStatement();
            res = sql.executeQuery(sqlcmd);
            while (res.next()) {
                if (ac.equals(res.getString(1)) && md5.md(pw).equals(res.getString(2))) return true;
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
			try {
				if(con != null) con.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
        return false;
    }
}
