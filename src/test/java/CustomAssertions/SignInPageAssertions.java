package CustomAssertions;

import org.testng.Assert;

public class SignInPageAssertions {

    public static void AssertUserIsNotRegister(String errorCode) {
        Assert.assertEquals(errorCode,"There is 1 error\n" + "Authentication failed." );
    }

    public static void AssertInvalidEmailAddress(String errorCode){
        Assert.assertEquals(errorCode, "Invalid email address.");
    }
}
