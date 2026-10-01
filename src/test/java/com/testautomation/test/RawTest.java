package com.testautomation.test;

import com.testautomation.conf.BaseTest;
import org.junit.jupiter.api.Test;

public class RawTest extends BaseTest {
    @Test
    void test01(){
        page.navigate(configuration.getAppUrl());
        page.locator("#user-name").fill(configuration.getUserName());
        page.locator("#password").fill(configuration.getUserPassword());
        page.locator("#login-button").click();
    }
}
