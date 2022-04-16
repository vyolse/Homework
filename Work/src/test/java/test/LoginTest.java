package test;

import org.junit.Test;

public class LoginTest extends WebDriverSettings {

        @Test
        public void loginTest() {
            try {
                loginPage.clickSingIn();
                loginPage.clickLoginField();
                loginPage.inputLogin(ConfProperties.getProperty("login"));
                loginPage.clickPasswdField();
                loginPage.inputPasswd(ConfProperties.getProperty("password"));
                loginPage.clickLoginBtn();//Войти
                loginPage.clickYourAccount();
                System.out.println("Авторизация проведена успешно");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Вход не выполнен");
            }
        }

        @Test
        public void loginTest2() {

            loginPage.clickSingIn();
            loginPage.clickRegisterNow();
            loginPage.clickOrOver();
            loginPage.dayInput(ConfProperties.getProperty("day"));
            loginPage.monthInput(ConfProperties.getProperty("month"));
            loginPage.yearInput(ConfProperties.getProperty("year"));
            loginPage.clickSubmitButton();
            //loginPage.clickUserIdentifierInput();
            loginPage.userIdentifierInput(ConfProperties.getProperty("loginreg"));
            //loginPage.clickPasswordInput();
            loginPage.PasswordInput(ConfProperties.getProperty("passwordreg"));
            if (ConfProperties.getProperty("passwordreg").length() < 8) {
                System.out.println("Извините, этот пароль слишком короткий. " +
                        "В нём должно быть не менее 8 символов. " +
                        "Регистрация не пройдена.");
            } else {

                loginPage.clickSubmitButton();
            }

        }
    }


