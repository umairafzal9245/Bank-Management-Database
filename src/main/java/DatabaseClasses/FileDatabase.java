package DatabaseClasses;

import java.io.FileOutputStream;
import MainClasses.Accounts;
import MainClasses.Customers;

public class FileDatabase extends DatabaseHandler{
    @Override
    public void addcustomerstodatabase(Customers object)
    {
        try {
            FileOutputStream fout = new FileOutputStream("Customers.txt");
                String message = object.getName() + "," + object.getAddress() + "," + object.getPhone() + ","
                        + object.getPhone() + "\n";
                fout.write(message.getBytes());
            fout.close();
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void addaccountstodatabase(Accounts object)
    {
        try {
            FileOutputStream fout = new FileOutputStream("Accounts.txt");
            String message = object.getAccountnumber() + "," + object.getBalance() + "," + object.getaccounttype() + ","
                    + object.getDatecreated() + "\n";
            fout.write(message.getBytes());
            fout.close();
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
