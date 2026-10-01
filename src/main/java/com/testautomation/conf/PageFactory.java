package com.testautomation.conf;

import com.microsoft.playwright.Page;

public class PageFactory {


        public static <T extends BasePage> T createInstance(final Page page, final Class<T> clazz) {
            try {
                BasePage instance = clazz.getDeclaredConstructor().newInstance();
                instance.configure(page);
                return clazz.cast(instance);
            } catch (Exception e) {
                e.printStackTrace();
            }
            throw new NullPointerException("Page class instantiation failed.");
        }
}
