import org.junit.Test;
import org.junit.Assert;

public class GiveMeADiamondTest {
    @Test
    public void testDiamond3() {
        StringBuffer expected = new StringBuffer();
        expected.append(" *\n");
        expected.append("***\n");
        expected.append(" *\n");
        Assert.assertEquals(expected.toString(), GiveMeADiamond.print(3));
    }
}
