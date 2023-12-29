
public class Main {
    Database db = null;
    LoginPage lp = null;
    RegistrationForm rf = null;


    public static void main(String[] args) {
        Main opt = new Main();
        opt.db = new Database();
        opt.lp = new LoginPage(opt);
        opt.rf = new RegistrationForm(opt);

    }
}
