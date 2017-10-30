package methodingroups;

import org.extendng.MethodInGroupListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MethodInGroupListener.class)
public class SubclassTest extends BaseTest {

    @Test(groups = "methodInBase")
    public void superclassBeforesArePickedUp(){
        Assert.assertEquals(beforeMethodInGroupInvokedCount, 1);
        Assert.assertEquals(afterMethodInGroupInvokedCount, 0);
    }

    @Test(dependsOnMethods = "superclassBeforesArePickedUp")
    public void superclassAftersArePickedUp(){
        Assert.assertEquals(afterMethodInGroupInvokedCount, 1);
    }
}