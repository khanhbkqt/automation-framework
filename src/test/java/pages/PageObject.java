package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import config.LocatorUtil;

import lazy.Lazy;
import lazy.LazyWebElement;

import java.lang.reflect.Field;

public abstract class PageObject {
    protected final WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        initializeLazyWebElements();
    }

    private void initializeLazyWebElements() {
        try {
            for (Field field : this.getClass().getDeclaredFields()) {
                if (!field.isAnnotationPresent(FindBy.class)) continue;

                FindBy annotation = field.getAnnotation(FindBy.class);

                if (field.isAnnotationPresent(Lazy.class)) {
                    field.setAccessible(true);
                    WebElement lazyWebElement = new LazyWebElement(driver, annotation);
                    field.set(this, lazyWebElement);
                } else {
                    By by = LocatorUtil.getByFromAnnotation(annotation);
                    WebElement element = driver.findElement(by);
                    field.set(this, element);
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to initialize lazy web elements", e);
        }
    }
}
