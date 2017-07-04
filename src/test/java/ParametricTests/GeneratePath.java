package ParametricTests;

/**
 * Created by Andy on 02.07.2017.
 */

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

@RunWith(DataProviderRunner.class)
public class GeneratePath {

//    Path path;
//    @Before
//    public void createTempDir() throws IOException {
//        Path tempPath = Paths.get("src");
//        this.path = Files.createTempDirectory(tempPath, "tmp");
//        // path.toFile().deleteOnExit();
//
//        System.out.println("Created temp dir "+path.toString());
//
//    }
//
//    @After
//    public void deleteTempDir(){
//        try{
//            FileUtils.deleteDirectory(new File(path.toString()));
//            System.out.println("deleted "+path.toString());
//        }
//        catch (Exception e)
//        {
//            System.out.println("not deleted "+path.toString());
//            //do nothing
//        }
//
//    }

    @Rule
    public TemporaryFolder path = new TemporaryFolder();


    @DataProvider
    public static Object[][] generateName() {
        // @formatter:off
        List<Object[]> data = new ArrayList<Object[]>();
        for (int i = 0; i < 5; i++) {
               data.add(new Object[]{generateRandName()});
        }
        return (Object[][])data.toArray(new Object[][]{});
        // @formatter:on
    }



    @Test
    @UseDataProvider("generateName")
    public void createFile(String name) throws IOException {
        File f = new File(this.path.getRoot()+"\\"+name);
        f.createNewFile();
        Assert.assertTrue(f.exists());
        Assert.assertEquals(1,path.getRoot().listFiles().length);
    }

    private static String generateRandName(){
        return "fname" + new Random().nextInt();
    }
}