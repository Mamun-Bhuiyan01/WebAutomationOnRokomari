package utilities;

import org.testng.annotations.DataProvider;

public class Dataset0 {

    @DataProvider(name = "ValidCredentials_With_Otp")
    public static Object ValidUserDataset0(){

        Object[][] data = {//{email},
                {"rokomari@yopmail.com"}
        };

        return data;
    }
}
