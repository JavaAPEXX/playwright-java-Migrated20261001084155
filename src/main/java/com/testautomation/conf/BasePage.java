package com.testautomation.conf;

import com.microsoft.playwright.Page;

public abstract class BasePage {

    protected Page page;

    public void configure(final Page page){
        this.page = page;
    }

    public byte[] captureScreenshot(){
        return page.screenshot();
    }
}
