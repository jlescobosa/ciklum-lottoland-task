package com.github.jlescobosa.automation.ciklum.lottoland.task.pages;

import com.github.jlescobosa.automation.ciklum.lottoland.task.utils.RandomUtils;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RegistrationPage {

    private static final String REGISTRATION_HOME_PAGE_URL = "http://demoqa.com/registration/";
    private static final String SUCCESS_MESSAGE_EXPECTED_TEXT = "Thank you for your registration";
    private static final String EMAIL_DOMAIN_TEXT = "@demoqa.com";
    private static final int SUCCESS_MESSAGE_WAITING_TIME = 10;
    private static Logger logger = Logger.getLogger(RegistrationPage.class);
    private WebDriver driver;
    private Lorem lorem;
    private String randomPassword;


    @FindBy(css = "input[name='first_name']")
    private WebElement firstName;

    @FindBy(css = "input[name='last_name']")
    private WebElement lastName;

    @FindBy(css = "input[type='radio']")
    private List<WebElement> maritalStatus;

    @FindBy(css = "input[type='checkbox']")
    private List<WebElement> hobby;

    @FindBy(css = "select[id='dropdown_7']")
    private WebElement countryDropdown;

    @FindBy(css = "select[id^='mm_date']")
    private WebElement monthOfBirthDropdown;

    @FindBy(css = "select[id^='dd_date']")
    private WebElement dayOfBirthDropdown;

    @FindBy(css = "select[id^='yy_date']")
    private WebElement yearOfBirthDropdown;

    @FindBy(css = "input[id^='phone']")
    private WebElement phoneNumber;

    @FindBy(css = "input[id='username']")
    private WebElement userName;

    @FindBy(css = "input[id^='email']")
    private WebElement email;

    @FindBy(css = "textarea[id='description']")
    private WebElement aboutYourself;

    @FindBy(css = "input[id^='password']")
    private WebElement password;

    @FindBy(css = "input[id^='confirm_password']")
    private WebElement confirmPassword;

    @FindBy(css = "input[type='submit']")
    private WebElement submitButton;

    private By successMsgLocator = By.cssSelector(".piereg_message");


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.lorem = LoremIpsum.getInstance();
        this.randomPassword = RandomUtils.getRandomAlphaNumeric(10);
        PageFactory.initElements(driver, this);
    }

    public RegistrationPage open() {
        driver.get(REGISTRATION_HOME_PAGE_URL);
        return this;
    }

    public RegistrationPage checkURL() {
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, REGISTRATION_HOME_PAGE_URL);
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        this.firstName.clear();
        this.firstName.sendKeys(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        this.lastName.clear();
        this.lastName.sendKeys(lastName);
        return this;
    }

    public RegistrationPage setRandomMaritalStatus() {
        String randomMaritalStatus = maritalStatusEnum.randomMaritalStatus().toString();
        logger.info("Random Marital Status: " + randomMaritalStatus);
        for (WebElement we : this.maritalStatus) {
            if (we.getAttribute("value").equalsIgnoreCase(randomMaritalStatus)) {
                we.click();
                break;
            }
        }
        return this;
    }

    public RegistrationPage setRandomHobby() {
        String randomHobby = hobbyEnum.randomHobby().toString();
        logger.info("Random Hobby: " + randomHobby);
        for (WebElement we : this.hobby) {
            if (we.getAttribute("value").equalsIgnoreCase(randomHobby)) {
                we.click();
                break;
            }
        }
        return this;
    }

    public RegistrationPage setRandomCountry() {
        Select dropdown = new Select(countryDropdown);
        List<WebElement> listOfCountries = dropdown.getOptions();
        String randomCountry = listOfCountries.get(new Random().nextInt(listOfCountries.size())).getText();
        logger.info("Random Country: " + randomCountry);
        dropdown.selectByValue(randomCountry);
        return this;
    }

    public RegistrationPage setRandomMonthOfBirth() {
        String randomMonthOfBirth = RandomUtils.getRandomNumber(1, 12);
        logger.info("Random Month Of Birth: " + randomMonthOfBirth);
        Select dropdown = new Select(monthOfBirthDropdown);
        dropdown.selectByValue(randomMonthOfBirth);
        return this;
    }

    public RegistrationPage setRandomDayOfBirth() {
        String randomDayOfBirth = RandomUtils.getRandomNumber(1, 12);
        logger.info("Random Day Of Birth: " + randomDayOfBirth);
        Select dropdown = new Select(dayOfBirthDropdown);
        dropdown.selectByValue(randomDayOfBirth);
        return this;
    }

    public RegistrationPage setRandomYearOfBirth() {
        String randomYearOfBirth = RandomUtils.getRandomNumber(1950, 2014);
        logger.info("Random Year Of Birth: " + randomYearOfBirth);
        Select dropdown = new Select(yearOfBirthDropdown);
        dropdown.selectByValue(randomYearOfBirth);
        return this;
    }

    public RegistrationPage setRandomPhoneNumber() {
        String randomPhoneNumber = RandomUtils.getRandomNumber(1000000000L, 10000000000L);
        logger.info("Random Phone Number: " + randomPhoneNumber);
        this.phoneNumber.clear();
        this.phoneNumber.sendKeys(randomPhoneNumber);
        return this;
    }

    public RegistrationPage setRandomUserName(String firstName, String lastName) {
        String randomUserName = firstName + lastName + RandomUtils.getRandomNumber(10000L, 100000L);
        logger.info("Random User Name: " + randomUserName);
        this.userName.clear();
        this.userName.sendKeys(randomUserName);
        return this;
    }

    public RegistrationPage setRandomEmail(String firstName, String lastName) {
        String randomEmail = firstName + lastName + RandomUtils.getRandomNumber(10000L, 100000L) + EMAIL_DOMAIN_TEXT;
        logger.info("Random Email: " + randomEmail);
        this.email.clear();
        this.email.sendKeys(randomEmail);
        return this;
    }

    public RegistrationPage setRandomAboutYourself() {
        String randomAboutYourself = lorem.getParagraphs(1, 3);
        logger.info("Random About Yourself: " + randomAboutYourself);
        this.aboutYourself.clear();
        this.aboutYourself.sendKeys(randomAboutYourself);
        return this;
    }

    public RegistrationPage setRandomPassword() {
        logger.info("Random Password: " + randomPassword);
        this.password.clear();
        this.password.sendKeys(randomPassword);
        return this;
    }

    public RegistrationPage setRandomConfirmPassword() {
        logger.info("Random Confirm Password: " + randomPassword);
        this.confirmPassword.clear();
        this.confirmPassword.sendKeys(randomPassword);
        return this;
    }

    public RegistrationPage submitRegistration() {
        this.submitButton.click();
        WebElement successMsg = (new WebDriverWait(driver, SUCCESS_MESSAGE_WAITING_TIME))
                .until(ExpectedConditions.presenceOfElementLocated(successMsgLocator));
        Assert.assertEquals(successMsg.getText(), SUCCESS_MESSAGE_EXPECTED_TEXT);
        return this;
    }

    public enum maritalStatusEnum {
        SINGLE, MARRIED, DIVORCED;

        private static final List<maritalStatusEnum> VALUES =
                Collections.unmodifiableList(Arrays.asList(values()));
        private static final int SIZE = VALUES.size();
        private static final Random RANDOM = new Random();

        public static maritalStatusEnum randomMaritalStatus() {
            return VALUES.get(RANDOM.nextInt(SIZE));
        }
    }

    public enum hobbyEnum {
        DANCE, READING,
        CRICKET {
            public String toString() {
                return "cricket ";
            }
        };

        private static final List<hobbyEnum> VALUES =
                Collections.unmodifiableList(Arrays.asList(values()));
        private static final int SIZE = VALUES.size();
        private static final Random RANDOM = new Random();

        public static hobbyEnum randomHobby() {
            return VALUES.get(RANDOM.nextInt(SIZE));
        }
    }

}
