package data;

import com.poiji.bind.Poiji;
import models.SignUpCredential;

import java.io.File;
import java.util.List;

public class ExcelReader {
    private static final String excelPath = "src/test/resources/data/registerErrorData.xlsx";

    public static List<SignUpCredential> getSignUpCredential() {
        return Poiji.fromExcel(new File(excelPath), SignUpCredential.class);
    }
}
