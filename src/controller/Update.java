package controller;

import java.sql.*;
import java.util.*;

import model.Message;

//Update data
public class Update {
    Connection con;
    Statement sql;
    ResultSet res;

    public void update(Vector<Message> msg) {
        con = Connecter.connectDB();
        if (con == null) {
            return;
        }
        try {
            sql = con.createStatement();

            for (Message s : msg) {
                String sqlcmd;
                sqlcmd = ("INSERT INTO book VALUES (\"" + s.name + "\", " + s.number + ", " + s.borrowed + ", "
                        + s.remain + ") ON DUPLICATE KEY UPDATE name=\"" + s.name + "\", number=" + s.number
                        + ", remain=" + s.remain + ";");
                sql.executeUpdate(sqlcmd);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void undate(String n, int nu, boolean b, int r) {
        con = Connecter.connectDB();
        if (con == null) {
            return;
        }
        try {
            sql = con.createStatement();
            String sqlcmd;
            sqlcmd = ("INSERT INTO book VALUES (\"" + n + "\", " + nu + ", " + b + ", " + r
                    + ") ON DUPLICATE KEY UPDATE name=\"" + n + "\", number=" + nu + ", remain=" + r + ";");
            sql.executeUpdate(sqlcmd);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
