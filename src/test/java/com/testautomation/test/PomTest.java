package com.testautomation.test;

import com.testautomation.conf.BaseTest;
import com.testautomation.pom.LoginPage;
import org.junit.jupiter.api.Test;

public class PomTest extends BaseTest {

    @Test
    public void test02(){
        page.navigate(configuration.getAppUrl());
        LoginPage loginPage = createInstance(LoginPage.class);
        loginPage.doLogin(configuration.getUserName(), configuration.getUserPassword());
    }
}
