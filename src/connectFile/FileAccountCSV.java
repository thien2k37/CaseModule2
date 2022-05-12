package connectFile;

import model.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileAccountCSV {
    public static List<Account> readFileAc() throws IOException {
        List<Account> accountList = new ArrayList<>();
        FileReader fr = new FileReader("/home/thien/IdeaProjects/caseMdTwo/src/data/dataAC.csv");
        BufferedReader br = new BufferedReader(fr);
        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            String[] arr = line.split(",");
            String acName = arr[1];
            String pass = arr[2];
            int age = Integer.parseInt(arr[3]);
            String email = arr[4];
            String phoneNb = arr[5];
            accountList.add(new Account(acName, pass, age, email, phoneNb));
        }
        return accountList;
    }
    public void writeToFile(List<Account> accountList) throws IOException {
        FileWriter writer = new FileWriter("/home/thien/IdeaProjects/caseMdTwo/src/data/dataAC.csv");
        BufferedWriter bw = new BufferedWriter(writer);
        for (Account account: accountList) {
            bw.write(account.toString());
            bw.newLine();
        }
        bw.close();
        writer.close();
    }
}
