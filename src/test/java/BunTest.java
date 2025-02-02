import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Database;

@RunWith(Parameterized.class)
public class BunTest {

    private String bunName;
    private float bunPrice;

    static Database database = new Database();

    static String name1 = database.availableBuns().get(0).name;
    static String name2 = database.availableBuns().get(1).name;
    static String name3 = database.availableBuns().get(2).name;

    static float price1 = database.availableBuns().get(0).price;
    static float price2 = database.availableBuns().get(1).price;
    static float price3 = database.availableBuns().get(2).price;

    public BunTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getBunData() {
        return new Object[][] {
                {name1, price1},
                {name2, price2},
                {name3, price3}
        };
    }

    @Test
    public void getBunNameTest() {
        Bun bun = new Bun(bunName, bunPrice);
        String actual = bun.getName();
        Assert.assertEquals("Неверное название булки", bunName, actual);
    }

    @Test
    public void getBunPriceTest() {
        Bun bun = new Bun(bunName, bunPrice);
        float actual = bun.getPrice();
        Assert.assertEquals("Неверная цена булки", bunPrice, actual, 0);
    }
}
