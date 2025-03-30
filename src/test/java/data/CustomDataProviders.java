package data;

import org.testng.annotations.DataProvider;

public class CustomDataProviders {
    public static final String DP_JSON_CREDENTIALS = "dpJsonCredentials";
    public static final String DP_EXCEL_CREDENTIALS = "dpExcelCredentials";

    @DataProvider(name = DP_JSON_CREDENTIALS)
    public static Object[][] jsonCredentialsDataProvider() {
        final var noEmail = JsonReader.getLoginCredential().get(0);
        final var noPassword = JsonReader.getLoginCredential().get(1);

        return new Object[][]{
                {noEmail.getEmail(), noEmail.getPassword(), noEmail.getErrorMessage()},
                {noPassword.getEmail(), noPassword.getPassword(), noPassword.getErrorMessage()}
        };
    }

    @DataProvider(name = DP_EXCEL_CREDENTIALS)
    public static Object[][] excelCredentialsDataProvider() {
        final var noPwdConfirm = ExcelReader.getSignUpCredential().get(0);
        final var noPassword = ExcelReader.getSignUpCredential().get(1);
        final var noEmail = ExcelReader.getSignUpCredential().get(2);

        return new Object[][]{
                {
                        noPwdConfirm.getEmail(),
                        noPwdConfirm.getPassword(),
                        "",
                        noPwdConfirm.getErrorMessage()
                },
                {
                        noPassword.getEmail(),
                        "",
                        noPassword.getPwdConfirm(),
                        noPassword.getErrorMessage()
                },
                {
                        "",
                        noEmail.getPassword(),
                        noEmail.getPwdConfirm(),
                        noEmail.getErrorMessage()
                }
        };
    }
}
