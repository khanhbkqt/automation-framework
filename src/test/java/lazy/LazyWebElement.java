package lazy;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LazyWebElement implements WebElement {
    private final WebDriver driver;
    private final FindBy locator;
    private WebElement element;

    public LazyWebElement(WebDriver driver, FindBy locator) {
        this.driver = driver;
        this.locator = locator;
    }

    private void initialize() {
        if (element == null) {
            element = driver.findElement(getByFromAnnotation(locator));
        }
    }

    private By getByFromAnnotation(FindBy locator) {
        if (!locator.className().isEmpty()) {
            return By.className(locator.className());
        } else if (!locator.css().isEmpty()) {
            return By.cssSelector(locator.css());
        } else if (!locator.id().isEmpty()) {
            return By.id(locator.id());
        } else if (!locator.linkText().isEmpty()) {
            return By.linkText(locator.linkText());
        } else if (!locator.name().isEmpty()) {
            return By.name(locator.name());
        } else if (!locator.partialLinkText().isEmpty()) {
            return By.partialLinkText(locator.partialLinkText());
        } else if (!locator.tagName().isEmpty()) {
            return By.tagName(locator.tagName());
        } else if (!locator.xpath().isEmpty()) {
            return By.xpath(locator.xpath());
        } else {
            throw new IllegalArgumentException("No valid locator found in @FindBy annotation");
        }
    }

    private WebElement getElement() {
        if (element == null) {
            initialize();
        }
        return element;
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
