package NonParametric;

import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.TemporaryFolder;

/**
 * Created by Andy on 02.07.2017.
 */
public class MockTests implements TestCategories {

    @Test
    @Category(PositiveTests.class)
    public void test1() {
        System.out.println("positive test");
    }

    @Test
    @Category(NegativeTests.class)
    public void test2() {
        System.out.println("negative test");
    }

    @Test
    @Category(BrokenTests.class)
    public void test3() {
        System.out.println("broken test");
    }

    @Rule
    public TemporaryFolder tmpdir = new TemporaryFolder();

    @Test
    public void testSomething() {
        System.out.println(tmpdir.getRoot());
    }
}
