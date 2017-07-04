package NonParametric;

import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Andy on 01.07.2017.
 */
public class TestCreateFile implements TestCategories{

    //Path path;

    @Rule
    public TemporaryFolder path = new TemporaryFolder();

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

    @Test
    @Category(PositiveTests.class)
    public void createFileTest() throws IOException
    {
        File f = new File(this.path.getRoot()+"\\test.txt");
        f.createNewFile();
        Assert.assertTrue(f.exists());
        Assert.assertEquals(1,path.getRoot().listFiles().length);

    }

    @Test
    @Category(PositiveTests.class)
    public void weirdLegalname() throws IOException
    {
        File f = new File(this.path.getRoot()+"\\~!a.@");
        Assert.assertTrue(f.createNewFile());
        Assert.assertTrue(f.exists());
    }


    @Test
    @Category(PositiveTests.class)
    public void testEmpty() throws IOException {
        File f = new File(this.path.getRoot()+"\\test1.txt");
        Assert.assertTrue(f.createNewFile());
        Assert.assertTrue(f.exists());
        Assert.assertEquals(f.length(),0);

    }

    @Test
    @Category(NegativeTests.class)
    public void negativeTst1() throws IOException {
        File file1 = null;
        try {
            System.out.println(file1.createNewFile());
        }
        catch (NullPointerException e){
            System.out.println("catch");
        }
        Assert.assertEquals(0,path.getRoot().listFiles().length);

    }

    @Test
    @Category(NegativeTests.class)
    public void negativeTest2() {

        File file = new File(this.path.getRoot() + "\\:?d.txt");
        try {
            file.createNewFile();

        }
        catch (Exception e){
            //do nothing
        }
       Assert.assertTrue(!file.exists());
    }
}
