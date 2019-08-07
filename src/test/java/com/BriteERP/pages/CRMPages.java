package com.BriteERP.pages;


import com.BriteERP.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CRMPages {

    public CRMPages() {

        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//button[contains(text(), 'Action')]")
    public WebElement actions;
    @FindBy(xpath = "//a[contains(text(),'Delete')]")
    public WebElement deleteActions;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o-kanban-button-new' and contains(text(),'Create')]")
    public WebElement createBtn;

    @FindBy(xpath = "(//input[contains(@id,'o_field_input')])[1]")
    public WebElement opportunityTitle;
    @FindBy(xpath = "(//input[contains(@id, 'o_field_input')])[3]")
    public WebElement expectedRevenue;


    @FindBy(xpath = "//button[@aria-label='list']")
    public WebElement list;
    @FindBy (xpath = "//button[@aria-label='kanban']")
    public WebElement kanban;

    @FindBy(xpath = "//button[@aria-label='pivot']")
            public WebElement pivot;
    @FindBy(xpath = "//table[contains(@class, 'table-hover table-condensed table')]/tbody/tr[1]/td[1]")
    public WebElement minusTotal;

    @FindBy(xpath = "//td[@class='o_pivot_header_cell_closed']")
    public WebElement plusTotal;

    @FindBy(xpath = "//a[contains(text(),'Opportunity')]")
    public WebElement opportunity;

    @FindBy(xpath = "//table[contains(@class,'table-hover table-condensed table')]/tbody/tr[3]/td[2]")
    public WebElement secondExpectedRevenuePivot;
@FindBy(xpath = "//table[contains(@class,'o_list_view table table-condensed table-striped o_list')]/tbody/tr[4]/td[9]")
    public WebElement secondExpectedRevenueList;





}
