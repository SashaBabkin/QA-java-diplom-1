import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTest {

    private IngredientType ingredientType;
    private String ingredientName;
    private float ingredientPrice;

    static Database database = new Database();
    static IngredientType type1 = IngredientType.SAUCE;
    static IngredientType type2 = IngredientType.FILLING;

    static String name1 = database.availableIngredients().get(0).name;
    static String name2 = database.availableIngredients().get(1).name;
    static String name3 = database.availableIngredients().get(2).name;
    static String name4 = database.availableIngredients().get(3).name;
    static String name5 = database.availableIngredients().get(4).name;
    static String name6 = database.availableIngredients().get(5).name;

    static float price1 = database.availableIngredients().get(0).price;
    static float price2 = database.availableIngredients().get(1).price;
    static float price3 = database.availableIngredients().get(2).price;
    static float price4 = database.availableIngredients().get(3).price;
    static float price5 = database.availableIngredients().get(4).price;
    static float price6 = database.availableIngredients().get(5).price;


    public IngredientTest(IngredientType ingredientType, String ingredientName, float ingredientPrice) {
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientData() {
        return new Object[][] {
                {type1, name1, price1},
                {type1, name2, price2},
                {type1, name3, price3},
                {type2, name4, price4},
                {type2, name5, price5},
                {type2, name6, price6}
        };
    }

    @Test
    public void getIngredientPriceTest() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        float actual = ingredient.getPrice();
        Assert.assertEquals("Неверная цена ингредиента", ingredientPrice, actual, 0);
    }

    @Test
    public void getIngredientNameTest() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        String actual = ingredient.getName();
        Assert.assertEquals("Неверное наименование ингредиента", ingredientName, actual);
    }

    @Test
    public void getIngredientTypeTest() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        IngredientType actual = ingredient.getType();
        Assert.assertEquals("Неверный тип ингредиента", ingredientType, actual);
    }
}
