package com.github.jlescobosa.automation.ciklum.lottoland.task.tests;

import com.github.jlescobosa.automation.ciklum.lottoland.task.data.Users;
import com.github.jlescobosa.automation.ciklum.lottoland.task.pages.RegistrationPage;
import com.github.jlescobosa.automation.ciklum.lottoland.task.utils.RandomUtils;
import com.github.jlescobosa.automation.ciklum.lottoland.task.utils.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Arrays;


public class RegistrationTest {

    private static Logger logger = Logger.getLogger(RegistrationTest.class);
    private WebDriver driver;
    private RegistrationPage registrationPage;
    private ArrayList<String> userRandomList;

    @DataProvider
    public Object[] FiveRandomRegistrationTest_DataProvider() {
        ArrayList<String> userList = new ArrayList<>(Arrays.asList(Users.userList));
        ArrayList<String> userListFormatted = StringUtils.removeMiddleNames(userList);
        userRandomList = RandomUtils.getRandomElements(userListFormatted, 5);
        return userRandomList.toArray();
    }

    @BeforeClass
    private void setUp() {
        driver = new FirefoxDriver();
    }

    @BeforeMethod
    public void openHomePage() {
        registrationPage = new RegistrationPage(driver).open().checkURL();
    }


    @Test(dataProvider = "FiveRandomRegistrationTest_DataProvider")
    public void FiveRandomRegistrationTest(String fullName) {

        logger.info("****************************");
        logger.info("Registration pending list: " + userRandomList);
        logger.info("****************************");


        logger.info("****************************");
        logger.info("Registration started for: " + fullName);
        logger.info("****************************");


        String firstName = fullName.split(" ")[0];
        String lastName = fullName.split(" ")[1];

        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
        registrationPage.setRandomMaritalStatus();
        registrationPage.setRandomHobby();
        registrationPage.setRandomCountry();
        registrationPage.setRandomMonthOfBirth();
        registrationPage.setRandomDayOfBirth();
        registrationPage.setRandomYearOfBirth();
        registrationPage.setRandomPhoneNumber();
        registrationPage.setRandomUserName(firstName, lastName);
        registrationPage.setRandomEmail(firstName, lastName);
        registrationPage.setRandomAboutYourself();
        registrationPage.setRandomPassword();
        registrationPage.setRandomConfirmPassword();
        registrationPage.submitRegistration();

        userRandomList.removeIf((String name) -> name == fullName);
    }


    @AfterClass
    private void tearDown() {
        driver.quit();
    }

}