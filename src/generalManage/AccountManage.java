package generalManage;

import check.InputCheck;
import connectFile.FileAccountCSV;
import model.Account;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AccountManage implements General<Account> {

    InputCheck inputCheck = new InputCheck();
    Scanner sc = new Scanner(System.in);
    List<Account> list;

    FileAccountCSV fileAccountCSV = new FileAccountCSV();
    public static Account currentName = null;

    public AccountManage() throws IOException {
        list = FileAccountCSV.readFileAc();
    }

    public List<Account> getList() {
        return list;
    }

    public int login(String acName, String pass){
        for (Account account : getList()) {
            if (account.getAccountName().equals(acName) && account.getPassWord().equals(pass)) {
                currentName = account;
                return 1;
            }
        }
        return 0;
    }
    @Override
    public void add() throws IOException {
        getList().add(inputAccount());
        fileAccountCSV.writeToFile(getList());
    }

    @Override
    public void edit() {
        System.out.println("Nhập id sửa");
        int id = inputCheck.checkInteger();
        if (findIndexById(id) != 1) {
            System.out.println(id + " Không có máy nào nhận");
        }else {
            getList().set(findIndexById(id), inputAccount());
        }
    }

    @Override
    public void delete() throws IOException {
        System.out.println("Nhập id để xóa");
        int id = inputCheck.checkInteger();
        if(findIndexById(id) != 1) {
            System.out.println(id + " không có máy nào để xóa");
        }else {
            getList().remove(findIndexById(id));
            fileAccountCSV.writeToFile(getList());
        }
    }

    //done
    @Override
    public void display() throws IOException {
        for (Account o: getList()) {
            System.out.println(o);
            fileAccountCSV.writeToFile(getList());
        }
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < getList().size(); i++) {
            if (getList().get(i).getId() == id) {
                return i;
            }
        }
        return 0;
    }
    public void searchAccount(String acName) {
        for (int i = 0; i < getList().size(); i++) {
            if(getList().get(i).getAccountName().equals(acName)) {
                System.out.println(getList().get(i));
            }
        }
    }
    public String checkAccount() {
        String acName;
        do {
            System.out.println("Tên tài khoản: ");
            acName = sc.nextLine();
            if(check(acName) == 1) {
                System.out.println(acName + ": tài khoản đã đã được sử dụng. nhập lại");
            }else {
                break;
            }
        }while (true);
        return acName;
    }
    public int check(String acName) {
        for (Account o: getList()) {
            if (o.getAccountName().equals(acName)) {
                return 1;
            }
        }
        return -1;
    }
    public int checkAge(){
        int age = inputCheck.checkInteger();
        if (age < 18) {
            System.out.println("chưa đủ tuổi");
            return checkAge();
        }else if (age > 100) {
            System.out.println("già rồi chơi game gì nữa nhập lại đi");
            return checkAge();
        }else {
            return age;
        }
    }
    public String checkEmail() {
        Pattern pEmail = Pattern.compile("^\\w*@[a-z.]{6,}$");
        String email;
        do {
            System.out.println("Nhập Email");
            email =  sc.nextLine();
            if(!pEmail.matcher(email).find()) {
                System.out.println("Không hợp lệ, nhập lại");
            }else {
                break;
            }
        }while (true);
        return email;
    }
    public String phoneNB() {
        Pattern pPhoneNB = Pattern.compile("^\\d{10}$");
        String phoneNB;
        do {
            phoneNB = sc.nextLine();
            if(!pPhoneNB.matcher(phoneNB).find()) {
                System.out.println("Không hợp lệ, nhập lại");
            }else {
                break;
            }
        }while (true);
        return phoneNB;
    }
    public Account inputAccount() {
        String nameAC = checkAccount();
        System.out.println("Nhập mật khẩu");
        String pass =  sc.nextLine();
        System.out.println("nhập tuổi");
        int age = Integer.parseInt(String.valueOf(checkAge()));
        String email = checkEmail();
        System.out.println("Nhập số điện thoại khách!");
        String phoneNB  = phoneNB();
        return new Account(nameAC, pass, age, email, phoneNB);
    }
}