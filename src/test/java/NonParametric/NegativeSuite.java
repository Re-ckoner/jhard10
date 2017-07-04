package NonParametric;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@SuiteClasses({
        TestCreateFile.class, MockTests.class
})
@RunWith(Categories.class)
@IncludeCategory(TestCategories.NegativeTests.class)
@Categories.ExcludeCategory(TestCategories.BrokenTests.class)
public class NegativeSuite{

}
