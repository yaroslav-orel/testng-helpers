import org.testng.Assert;
import org.testng.annotations.Test;

public class ListenerAbsentTest {
    private int beforeMethodInGroupInvokedCount = 0;
    private int afterMethodInGroupInvokedCount = 0;

    @BeforeMethodInGroup("target")
    public void before(){
        beforeMethodInGroupInvokedCount += 1;
    }

    @AfterMethodInGroup("target")
    public void after(){
        afterMethodInGroupInvokedCount += 1;
    }

    @Test
    public void startingTest(){
        Assert.assertEquals(beforeMethodInGroupInvokedCount, 0);
        Assert.assertEquals(afterMethodInGroupInvokedCount, 0);
    }

    @Test(groups = "target", dependsOnMethods = "startingTest")
    public void actualTest(){
        Assert.assertEquals(beforeMethodInGroupInvokedCount, 0);
        Assert.assertEquals(afterMethodInGroupInvokedCount, 0);
    }

    @Test(dependsOnMethods = "actualTest")
    public void closingTest(){
        Assert.assertEquals(beforeMethodInGroupInvokedCount, 0);
        Assert.assertEquals(afterMethodInGroupInvokedCount, 0);
    }
}