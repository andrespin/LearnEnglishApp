package android.famme.learnenglishapp.utils.firebase;

public class AuthData {

    private String email = "";
    private String pass = "";
    private String error = null;
    private String msg = "";
    private String name = "";
    private AuthEvent authEvent;



    public AuthData(String email, String pass, String name ,AuthEvent authEvent, String msg) {
        this.pass = pass;
        this.email = email;
        this.authEvent = authEvent;
        this.msg = msg;
        this.name = name;
    }

    public AuthData(String email, String pass, AuthEvent authEvent, String msg) {
        this.pass = pass;
        this.email = email;
        this.authEvent = authEvent;
        this.msg = msg;
    }

    public AuthData(String error, AuthEvent authEvent, String msg) {
        this.error = error;
        this.authEvent = authEvent;
        this.msg = msg;
    }

    public AuthData(AuthEvent authEvent, String msg) {
        this.msg = msg;
        this.authEvent = authEvent;
    }

    public String getMessage() {
        return this.msg;
    }


    public AuthEvent getAuthEvent() {
        return this.authEvent;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass() {
        return this.pass;
    }

    public void getEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

}
