package utilities;

import org.testng.annotations.DataProvider;

public class Dataset2 {

    @DataProvider(name = "InvalidCredentials")
    public static Object InvalidUserDataset(){

        Object[][] data = {//{email, errormessage},
                {"rokomariyopmail.com", "Invalid email! Please enter a valid email or phone number."}
        };

        return data;
    }
}
