package user;

public class User {

    private String mail;
    private String password;
    private String mailText;


    public User(String mail, String password, String mailText) {
        this.mail = mail;
        this.password = password;
        this.mailText = mailText;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public String getMailText() {
        return mailText;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMailText(String mailText) {
        this.mailText = mailText;
    }
}
