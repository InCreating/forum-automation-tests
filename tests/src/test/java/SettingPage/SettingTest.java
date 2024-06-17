package SettingPage;

import org.testng.annotations.Test;

public class SettingTest extends BaseSettingPage{
    @Test
    public void setting() {
        runLoginTest();
        runUsernameChangeTest();
        runEmailChangeTest();
        //runPassChangeTest();
    }
}
