package ParametricTests;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Andy on 02.07.2017.
 */


@RunWith(DataProviderRunner.class)
public class GetNameFromFile {

   @DataProvider
   public static Object[][] getName() throws IOException {
       BufferedReader in = new BufferedReader(new InputStreamReader(
               GetNameFromFile.class.getResourceAsStream("/names.data")));

       List<Object[]> userData = new ArrayList<Object[]>();
       String line = in.readLine();
       while (line != null) {
           userData.add(line.split(";"));
           line = in.readLine();
       }

       in.close();

       return (Object[][]) userData.toArray(new Object[][]{});
   }

    @Rule
    public TemporaryFolder path = new TemporaryFolder();

    @Test
    @UseDataProvider("getName")
    public void createFile(String name) throws IOException {
        File f = new File(this.path.getRoot()+"\\"+name);
        f.createNewFile();
        Assert.assertTrue(f.exists());
        Assert.assertEquals(1,path.getRoot().listFiles().length);
    }

}


