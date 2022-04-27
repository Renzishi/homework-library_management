package controller;

import java.sql.*;
import java.util.*;

import model.Message;

//Delete data
public class Delete {
    Connection con;
    Statement sql;
    ResultSet res;

    public void deleteMsg(Vector<Message> msg) {
        con = Connecter.connectDB();
        if (con == null) {
            return;
        }
        try {
            sql = con.createStatement();
            for (Message s : msg) {
                String sqlcmd;
                if (s.name != null) {
                    sqlcmd = "DELETE FROM book WHERE `name`=\"" + s.name + "\";";
                } else if (s.number != 0) {
                    sqlcmd = "DELETE FROM book WHERE `number`=" + s.number + ";";
                } else {
                    continue;
                }

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

    public void deleteMsg(String na, int nu) {
        con = Connecter.connectDB();
        if (con == null) {
            return;
        }
        try {
            sql = con.createStatement();

            String sqlcmd;
            if (na != null) {
                sqlcmd = "DELETE FROM book WHERE `name`=\"" + na + "\";";
            } else if (nu != 0) {
                sqlcmd = "DELETE FROM book WHERE `number`=" + nu + ";";
            } else {
                System.out.println("Delete failed");
                return;
            }

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
