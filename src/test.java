import java.util.Vector;

import model.Message;

import controller.Insert;

public class test {
    public static void main(String args[]) {
        Insert in = new Insert();
        Vector<Message> msg = new Vector<>();
        msg.add(new Message("C", 1001, false, 20));

        System.out.println(in.insert(msg));

    }

}
