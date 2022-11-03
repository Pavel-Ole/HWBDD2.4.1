package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {

    private SelenideElement heading = $("[data-test-id=dashboard]");
    private SelenideElement reloadButton = $("[data-test-id='action-reload']");

    public DashboardPage() {
        heading.shouldBe(visible);
    }

    private static ElementsCollection cards = $$(".list__item div");
    private static final String balanceStart = "баланс: ";
    private static final String balanceFinish = " р.";

    public TransferPage transferFirstCardBalance() {
        cards.first().$("button").click();
        return new TransferPage();
    }

    public static int getFirstCardBalance() {
        val text = cards.first().text();
        return extractBalance(text);
    }

    public static int getSecondCardBalance() {
        val text = cards.last().text();
        return extractBalance(text);
    }

    private static int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public TransferPage transferSecondCardBalance() {
        cards.last().$("button").click();
        return new TransferPage();
    }

    public TransferPage upDate() {
        reloadButton.click();
        return new TransferPage();
    }
}
