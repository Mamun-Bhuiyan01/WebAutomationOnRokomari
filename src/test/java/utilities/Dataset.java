package utilities;

import org.testng.annotations.DataProvider;

public class Dataset {

    @DataProvider(name = "ValidCredentials")
    public static Object ValidUserDataset(){

        Object[][] data = {//{email, password, errormessage},
                           {"rokomari@yopmail.com", "mamun1234", ""}
        };

        return data;
    }
}
