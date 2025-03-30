package models;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

@ExcelSheet("data")
public class SignUpCredential {
    @ExcelCellName("EMAIL")
    private String email;
    @ExcelCellName("PASSWORD_1")
    private String password;
    @ExcelCellName("PASSWORD_2")
    private String pwdConfirm;
    @ExcelCellName("ERROR")
    private String errorMessage;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPwdConfirm() {
        return pwdConfirm;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
