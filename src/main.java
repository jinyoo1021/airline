
public class main {

    public static void main(String[] args) {

        IdAndPasswards IdPass = new IdAndPasswards();

        LoginPage loginPage = new LoginPage(IdPass.getLoginInfo());
    }
}
