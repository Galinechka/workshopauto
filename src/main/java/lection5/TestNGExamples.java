package lection5;

        import org.testng.annotations.Test;
        import org.testng.Assert;

public class TestNGExamples {

    private int expectedResult = 5;
    private String expectedString = "Test";

    @Test(expectedExceptions = ArithmeticException.class)
    public void testExcaption(){
        int i= 2/0;
    }

    @Test(groups = {"Smoke", "Strings"})
    public void testOurFirstAssertion(){
        int actualResult = 100/20;
        Assert.assertEquals(actualResult,expectedResult, "Comparing age of our users");
    }

    @Test(enabled = true, groups = "Smoke")
    public void testComparingStrings() throws Exception {
        String actualResult = "Test";

        Assert.assertTrue((actualResult==expectedString), "Comparing names");
    }

    @Test(timeOut = 5000)
    public void testTimeOut() throws Exception {
       while (true);
    }

}
