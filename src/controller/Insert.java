package controller;

import java.sql.*;
import java.util.*;

import model.Message;

//INSERT data
public class Insert {
    Connection con;
    Statement sql;
    ResultSet res;

    public int insert(Vector<Message> msg) {
        con = Connecter.connectDB();
        if (con == null) {
            return 1;
        }
        int fault = 0;
        try {
            sql = con.createStatement();
            Get g = new Get();
            
            for (Message s : msg) {
                String sqlcmd;
                Message tname = g.getMsg(s.name, 0);
                Message tnumber = g.getMsg(null, s.number);
                if(tname == null && tnumber == null) {
                    sqlcmd = "INSERT INTO book(`name`, `number`, `borrowed`, `remain`) VALUES (\"" + s.name + "\", "
                        + s.number + ", " + s.borrowed + ", " + s.remain + ");";
                    sql.executeUpdate(sqlcmd);
                } else {
                    fault++;
                }

            }
            // con.close();
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
        return fault;
    }

    public int insert(String name, int number, boolean borrowed, int remain) {
        con = Connecter.connectDB();
        int fault = 0;
        if (con == null) {
            return 1;
        }
        try {
            sql = con.createStatement();
            Get g = new Get();
            String sqlcmd;
            Message tname = g.getMsg(name, 0);
            Message tnumber = g.getMsg(null, number);
            if (tname == null && tnumber == null) {
                sqlcmd = "INSERT INTO book(`name`, `number`, `borrowed`, `remain`) VALUES (\"" + name + "\", "
                        + number + ", " + borrowed + ", " + remain + ");";
                sql.executeUpdate(sqlcmd);
            } else {
                fault++;
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
        return fault;
    }
}
