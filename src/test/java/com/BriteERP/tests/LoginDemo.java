package com.BriteERP.tests;

import com.BriteERP.pages.CRMPages;
import com.BriteERP.pages.LoginPage;
import com.BriteERP.utilities.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;



public class LoginDemo extends TestBase {


    @Test
    public void test1()  {


        String email = ConfigurationReader.get("eventManagerUsername");
        String password = ConfigurationReader.get("eventManagerPassword");
        LoginPage loginPage = new LoginPage();
        loginPage.login(email, password);
        CRMPages crmPages = new CRMPages();

        BRPUtils.getTab("CRM");
        int count = BRPUtils.checkAmmount();
        if (count<=5) {
            BrowserUtils.waitForClickablility(crmPages.kanban,3).click();
            while (count<5) {
                BRPUtils.createInfo();
                count++;
            }
        } else {
            while (count > 5) {
                BRPUtils.deleteOpportunities();
                count--;
            }
        }

        BrowserUtils.waitFor(4);
        crmPages.pivot.click();
        BrowserUtils.clickWithTimeOut(crmPages.minusTotal,1);
        BrowserUtils.clickWithTimeOut(crmPages.plusTotal,1);
        BrowserUtils.clickWithTimeOut(crmPages.opportunity,1);
        String getSecondRevenuePivot=crmPages.secondExpectedRevenuePivot.getText();
        BrowserUtils.clickWithTimeOut(crmPages.list,3);
        String getSecondRevenueList=crmPages.secondExpectedRevenueList.getText();
        Assert.assertEquals(getSecondRevenuePivot,getSecondRevenueList);
crmPages.pivot.click();
BRPUtils.getSum();
String totalRevenue=Driver.get().findElement(By.xpath("//table[contains(@class,'table-hover table-condensed table')]/tbody/tr[1]/td[2]")).getText();
totalRevenue=totalRevenue.replace(",","");
double totalRevenue1=Double.parseDouble(totalRevenue);
//Assert.assertEquals(totalRevenue1, BRPUtils.getSum());

    }
}

