package com.BriteERP.utilities;

import com.BriteERP.pages.CRMPages;
import com.BriteERP.pages.LoginPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BRPUtils {
    public static void createInfo() {

        Faker faker = new Faker();
        Random random = new Random();

        CRMPages crmPages = new CRMPages();

        String title = faker.book().title();
        BrowserUtils.clickWithTimeOut(crmPages.createBtn, 3);
        //TODO OPPORTUNITY TITLE
        BrowserUtils.clickWithTimeOut(crmPages.opportunityTitle, 2);
        crmPages.opportunityTitle.sendKeys(title);

        //TODO REVENUE FILL UP
        crmPages.expectedRevenue.click();
        BrowserUtils.waitForVisibility(crmPages.expectedRevenue, 1);
        crmPages.expectedRevenue.clear();

        double revenue = random.nextDouble() * 1000;
        crmPages.expectedRevenue.clear();
        crmPages.expectedRevenue.sendKeys(revenue + "");
        //TODO PRIORITY

        BrowserUtils.waitFor(1);
        int star = random.nextInt(3) + 1;
        WebElement priority;
        if (star == 1) {
            priority = Driver.get().findElement(By.xpath("//table[contains(@class,'o_group o_inner_group o_group_col')]/tbody/tr[4]//a[1]"));
            priority.click();
        } else if (star == 2) {
            priority = Driver.get().findElement(By.xpath("//table[contains(@class,'o_group o_inner_group o_group_col')]/tbody/tr[4]//a[2]"));
            priority.click();
        } else {
            priority = Driver.get().findElement(By.xpath("//table[contains(@class,'o_group o_inner_group o_group_col')]/tbody/tr[4]//a[3]"));
            priority.click();
        }

        BrowserUtils.waitForClickablility(Driver.get().findElement(By.xpath("//button[@name='close_dialog']")), 4).click();
    }

    public static int checkAmmount() {
        CRMPages crmPages = new CRMPages();

        BrowserUtils.waitForClickablility(crmPages.list, 3);
        crmPages.list.click();
        int count = Driver.get().findElements(By.xpath("//tbody/tr")).size();

        return count;

    }

    public static void deleteOpportunities() {
        CRMPages crmPages = new CRMPages();
        // BrowserUtils.waitForClickablility(crmPages.list,5).click();

        while (checkAmmount() > 5) {

            //BrowserUtils.waitFor(2);
            Driver.get().findElement(By.xpath("(//input[@type='checkbox'])[4]")).click();
            crmPages.actions.click();
            BrowserUtils.waitForClickablility(crmPages.deleteActions, 2).click();
            Driver.get().findElement(By.xpath("//span[contains(text(),'Ok')]")).click();
            BrowserUtils.waitFor(2);

        }
    }

    public static WebElement getTab(String tab) {
        String xpath = "//span[@class='oe_menu_text' and contains(text(),'" + tab + "')]";
        WebElement location = Driver.get().findElement(By.xpath(xpath));
        BrowserUtils.waitForClickablility(location, 5).click();
        return location;
    }


public static double getSum(){
int row=2;
    double total =0;
List<WebElement> sizeTable=Driver.get().findElements(By.xpath("//table[contains(@class,'table-hover table-condensed table')]/tbody/tr"));
              while(row<=sizeTable.size()) {
    WebElement revenue = Driver.get().findElement(By.xpath("//table[contains(@class,'table-hover table-condensed table')]/tbody/tr["+row+"]/td[2]"));
row++;
String getRevenue=revenue.getText();
total+=Double.parseDouble(getRevenue);



}
return total;
}

}

