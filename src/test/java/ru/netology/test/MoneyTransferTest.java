package ru.netology.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPage;
import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.DataHelper.*;


public class MoneyTransferTest {

    @BeforeEach
    void setup() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
    }

    @Test
    void moneyTransferOnTheFirstCard() {

        var authInfo = getAuthInfo();
        var verificationCode = getVerificationCodeFor(authInfo);
        var cardNumber = getSecondCardBank();

        new LoginPage()
                .validLogin(authInfo)
                .validVerify(verificationCode);

        new DashboardPage()
                .transferFirstCardBalance()
                .cardReplenishment(String.valueOf(cardNumber), "1000")
                .upDate();
    }

    @Test
    void moneyTransferOnTheSecondCard() {

        var authInfo = getAuthInfo();
        var verificationCode = getVerificationCodeFor(authInfo);
        var cardNumber = getFirstCardBank();

        new LoginPage()
                .validLogin(authInfo)
                .validVerify(verificationCode);

        new DashboardPage()
                .transferSecondCardBalance()
                .cardReplenishment(String.valueOf(cardNumber), "2000")
                .upDate();
    }

    @Test
    void moneyTransferOverLimit() {

        var authInfo = getAuthInfo();
        var verificationCode = getVerificationCodeFor(authInfo);
        var cardNumber = getSecondCardBank();

        new LoginPage()
                .validLogin(authInfo)
                .validVerify(verificationCode);

        new DashboardPage()
                .transferFirstCardBalance()
                .cardReplenishment(String.valueOf(cardNumber), "21000")
                .upDate();
    }
}
