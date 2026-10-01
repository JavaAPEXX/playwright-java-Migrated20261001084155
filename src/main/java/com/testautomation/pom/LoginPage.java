package com.testautomation.pom;

import com.testautomation.conf.BasePage;
import sun.rmi.runtime.Log;

public class LoginPage extends BasePage {

    public LoginPage(){

    }
    public void doLogin(String usr, String pwd){
        page.locator("#user-name").fill(usr);
        page.locator("#password").fill(pwd);
        page.locator("#login-button").click();
    }
}
