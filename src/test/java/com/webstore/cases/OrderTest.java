package com.webstore.cases;

import com.webstore.ui.pages.CommonPage;
import com.webstore.ui.pages.DressesPage;
import com.webstore.ui.pages.LoginPage;
import com.webstore.ui.pages.TShirtsPage;
import com.webstore.ui.utils.Constant;
import config.LaunchApplication;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class OrderTest {

    LoginPage loginPage = new LoginPage();
    LaunchApplication launchApplication = new LaunchApplication();

    /**
     * @param fistName:     User first name
     * @param lastName:     User last name
     * @param email:        User email Id
     * @param password:     User password
     * @param address:      User address
     * @param city:         User address city
     * @param state:        User address state
     * @param postCode:     User address pass code or zip code
     * @param mobileNumber: User mobile number
     */
    @Test(dataProvider = "userData")
    public void OrderConfirmation(
            String fistName, String lastName, String email, String password, String address,
            String city, String state, String postCode, String mobileNumber, String expectedResult) {
        launchApplication.launchApplication();
        loginPage.signUp(fistName, lastName, email, password, address,
                city, state, postCode, mobileNumber, expectedResult);
    }

    @DataProvider(name = "userData")
    public Object[][] userFormData() throws InvalidFormatException, IOException {
        Object[][] data = testData(Constant.USERDATAEXCELFILEPATH, Constant.USERDATAFILENAME);
        return data;
    }

    /**
     * @param xlFilePath excel file path
     * @param sheetName  sheet name in xlsx file
     * @return excel data
     * @throws InvalidFormatException
     * @throws IOException
     */
    public Object[][] testData(String xlFilePath, String sheetName) throws InvalidFormatException, IOException {
        FileInputStream file = new FileInputStream(xlFilePath);
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheetAt(0);
        int rowCount = sheet.getLastRowNum();
        int column = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rowCount][column];
        for (int i = 1; i <= rowCount; i++) {
            XSSFRow row = sheet.getRow(i);
            for (int j = 0; j < column; j++) {
                XSSFCell cell = row.getCell(j);
                DataFormatter formatter = new DataFormatter();
                String val = formatter.formatCellValue(cell);
                data[i - 1][j] = val;
            }
        }
        return data;
    }
}
