package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import model.Message;

//Get data
public class Get {
	Connection con;
	Statement sql;
	ResultSet res;
    Vector<Message> msg;
    public Vector<Message> getMsg() {
    	con = Connecter.connectDB();
        if (con == null) { return msg; }
        String sqlcmd = "SELECT * FROM book";
        try {
            sql = con.createStatement();
            res = sql.executeQuery(sqlcmd);
            msg = new Vector<Message>();
            Message m;
            while(res.next()) {
                m = new Message(res.getString(1), res.getInt(2), res.getBoolean(3), res.getInt(4));
                msg.add(m);
            }
            //con.close();
            return msg;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
			try {
				if(con != null) con.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

        return msg;
    }
    public Message getMsg(String n, int number) {
        con = Connecter.connectDB();
        if (con == null) { return null; }

        String sqlcmd;
        if (n == null) sqlcmd = "SELECT * FROM book WHERE `number` = "+number+";";
        else sqlcmd = "SELECT * FROM book WHERE `name` = \""+n+"\";";
        try {
            sql = con.createStatement();
            res = sql.executeQuery(sqlcmd);
            if (res.next()) {
                return new Message(res.getString(1), res.getInt(2), res.getBoolean(3), res.getInt(4));
            }
        } catch (SQLException e) {
            System.out.println("Get"+e);
        } finally {
			try {
				if(con != null) con.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

        return null;
    }
}
