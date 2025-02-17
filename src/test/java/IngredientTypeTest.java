import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final IngredientType ingredientType;
    private final String name;

    public IngredientTypeTest(IngredientType ingredientType, String name) {
        this.ingredientType = ingredientType;
        this.name = name;
    }

    @Parameterized.Parameters

    public static Object[][] getData() {
        return new Object[][]{
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"}
        };
    }

    @Test
    public void nameIngredientTypeTest() {
        assertEquals(name, ingredientType.name());
    }




}
