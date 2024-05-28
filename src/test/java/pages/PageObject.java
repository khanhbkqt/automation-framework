package pages;
import org.openqa.selenium.WebDriver;

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
                if (field.isAnnotationPresent(Lazy.class)) {
                    field.setAccessible(true);
                    Lazy annotation = field.getAnnotation(Lazy.class);
                    LazyWebElement lazyWebElement = new LazyWebElement(driver, annotation);
                    field.set(this, lazyWebElement);
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to initialize lazy web elements", e);
        }
    }
}
