package lazy;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LazyWebElement implements WebElement {
    private final WebDriver driver;
    private final Lazy annotation;
    private WebElement element;

    public LazyWebElement(WebDriver driver, Lazy annotation) {
        this.driver = driver;
        this.annotation = annotation;
    }

    private void initialize() {
        if (element == null) {
            By locator = getByFromAnnotation(annotation);
            int timeout = annotation.timeout();

            if (timeout == 0) {
                element = driver.findElement(locator);
            } else {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            }
            
        }
    }

    private WebElement getElement() {
        if (element == null) {
            initialize();
        }
        return element;
    }

    private By getByFromAnnotation(Lazy annotation) {
        if (!annotation.id().isEmpty()) {
            return By.id(annotation.id());
        }
        if (!annotation.xpath().isEmpty()) {
            return By.xpath(annotation.xpath());
        }
        if (!annotation.css().isEmpty()) {
            return By.cssSelector(annotation.css());
        }
        if (!annotation.name().isEmpty()) {
            return By.name(annotation.name());
        }
        if (!annotation.className().isEmpty()) {
            return By.className(annotation.className());
        }
        if (!annotation.tagName().isEmpty()) {
            return By.tagName(annotation.tagName());
        }
        if (!annotation.linkText().isEmpty()) {
            return By.linkText(annotation.linkText());
        }
        if (!annotation.partialLinkText().isEmpty()) {
            return By.partialLinkText(annotation.partialLinkText());
        }
        throw new IllegalArgumentException("Locator not specified in LazyWebElement annotation");
    }

    @Override
    public void click() {
        getElement().click();
    }

    @Override
    public void submit() {
        getElement().submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        getElement().sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        getElement().clear();
    }

    @Override
    public String getTagName() {
        return getElement().getTagName();
    }

    @Override
    public String getAttribute(String name) {
        return getElement().getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return getElement().isSelected();
    }

    @Override
    public boolean isEnabled() {
        return getElement().isEnabled();
    }

    @Override
    public String getText() {
        return getElement().getText();
    }

    @Override
    public java.util.List<WebElement> findElements(By by) {
        return getElement().findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return getElement().findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return getElement().isDisplayed();
    }

    @Override
    public org.openqa.selenium.Point getLocation() {
        return getElement().getLocation();
    }

    @Override
    public org.openqa.selenium.Dimension getSize() {
        return getElement().getSize();
    }

    @Override
    public Rectangle getRect() {
        return getElement().getRect();
    }

    @Override
    public String getCssValue(String propertyName) {
        return getElement().getCssValue(propertyName);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return getElement().getScreenshotAs(target);    
    }
}
