import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient ingredient2;

    Database database = new Database();

    @Test
    public void setBunsTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals("Не выбрана булочка для бургера", bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        List<Ingredient> expected = new ArrayList<>();
        expected.add(ingredient);
        Assert.assertEquals("Должен добавиться ингредиент", expected, burger.ingredients);

    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.ingredients.add(ingredient);
        burger.removeIngredient(0);
        Assert.assertEquals("Ингредиент должен быть удален", true, burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredient2);
        burger.moveIngredient(0, 1);
        Assert.assertEquals("Ингредиенты должны поменяться местами!", ingredient, burger.ingredients.get(1));
        Assert.assertEquals("Ингредиенты должны поменяться местами", ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void getBurgerPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(1000f);
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        float actual = burger.getPrice();
        Assert.assertEquals("Неверное значение стоимости бургера", 2100f, actual, 0);
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);

        String bunName = database.availableBuns().get(0).name;
        String ingredientName = database.availableIngredients().get(0).name;
        float bunPrice = database.availableBuns().get(0).price;

        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(ingredient.getPrice()).thenReturn(100f);

        float totalPrice = bunPrice * 2f + database.availableIngredients().get(0).price;
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        String actual = burger.getReceipt();
        String expected = String.format("(==== %s ====)\r\n= sauce %s =\r\n(==== %s ====)\r\n\r\nPrice: %f\r\n", bunName, ingredientName, bunName, totalPrice);

        System.out.println(expected);
        System.out.println(actual);
        Assert.assertEquals("Неверный формат вывода чека", expected, actual);
    }
}
