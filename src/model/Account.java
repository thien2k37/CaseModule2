package model;

public class Account {
    private int id;
    static int count = 0;
    private String accountName;
    private String passWord;
    private int age;
    private String email;
    private String phoneNumber;
    private Machine machine;

    public Account() {
    }

    public Account(String accountName, String passWord, int age, String email, String phoneNumber) {
        id = count++;
        this.accountName = accountName;
        this.passWord = passWord;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + "," + getAccountName() + "," + getPassWord() + "," + getAge() + "," + getEmail() + "," + getPhoneNumber();
    }
}
