import java.util.HashMap;

public class IdAndPasswards {

    HashMap<String, String> loginInfo = new HashMap<String, String>();

    IdAndPasswards() {
        loginInfo.put("Henry", "Potter");
        loginInfo.put("code", "PASS");
        loginInfo.put("HenryCode", "PotterPass");
    }

    protected HashMap getLoginInfo() {
        return loginInfo;
    }
}
