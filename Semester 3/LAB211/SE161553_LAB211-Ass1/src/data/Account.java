package data;

public class Account {

    private String accName;
    private String pwd;
    private String role;

    public Account(String accName, String pwd, String role) {
        this.accName = accName; //ID
        this.pwd = pwd; //password
        this.role = role;
    }

    //Do không cần thay đổi giá trị nên không dùng setter cho AccName, Pwd, Role.
    public String getAccName() {
        return accName;
    }

    public String getPwd() {
        return pwd;
    }

    public String getRole() {
        return role;
    }

}
