package login;

import java.sql.*;
import controller.*;

public class Register {
    private Connection con;
    private Statement sql;
    private ResultSet res;
    private boolean result = true; 
    
    public boolean reg(String ac, String pw) {

        con = Connecter.connectDB();
        if (con == null || ac.length() > 10 || pw.length()>10) return false;
        String sqlcmd = "SELECT * FROM admin";
        try {
            sql = con.createStatement();
            res = sql.executeQuery(sqlcmd);
            while(res.next()) {
                if(ac.equals( res.getString(1))) {
                    result = false;
                }
            }

            if (result) { sql.executeUpdate("INSERT INTO admin(`account`, `password`) VALUES (\""+ac+"\", md5(\""+pw+"\"));"); }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
			try {
				if(con != null) con.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

        return result;
    }
}
