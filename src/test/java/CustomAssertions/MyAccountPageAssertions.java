package CustomAssertions;

import org.testng.Assert;

public class MyAccountPageAssertions {

    public static void AssertCreateANewAccount(String errorCode){
        Assert.assertEquals(errorCode, "Welcome to your account. Here you can manage all of your personal " +
                "information and orders.");
    }

}