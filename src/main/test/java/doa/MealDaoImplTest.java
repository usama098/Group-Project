import org.springframework.boot.autoconfigure.integration.IntegrationProperties.Jdbc;
import org.springframework.jdbc.core.JdbcTemplate;

public class MealDaoImplTest {

    private JdbcTemplate jdbcTemplate;
    private MealDaoImpl mealDaoImpl;

    @Before
    public void setUp() {
        jdbcTemplate = new JdbcTemplate();
        mealDaoImpl = new MealDaoImpl(jdbcTemplate);
    }

    @Test
    public void testGetAllMeals() {
        List<Meal> meals = mealDaoImpl.getAllMeals();
        assertNotNull(meals);
        assertEquals(3, meals.size());
    }

    @Test
    public void testGetMealById() {
        Meal meal = mealDaoImpl.getMealById(1);
        assertNotNull(meal);
        assertEquals(1, meal.getId());
        assertEquals("FAVOURITE DINNER", meal.getMeal_title());
    }

    @Test
    public void testAddMeal() {
        Meal meal = new Meal();
        meal.setMeal_title("NEW MEAL");
        meal.setMeal_items("NEW MEAL ITEMS");
        meal.setCalories(100);
        meal.setSugar(10);
        meal.setProtein(20);
        meal.setSalt(5);
        meal.setFat(15);
        meal.setUserId(1);

        mealDaoImpl.addMeal(meal);

        List<Meal> meals = mealDaoImpl.getAllMeals();
        assertNotNull(meals);
        assertEquals(4, meals.size());
    }

    @Test
    public void testUpdateMeal() {
        Meal meal = mealDaoImpl.getMealById(1);
        meal.setMeal_title("UPDATED MEAL"); // Change the meal title
        meal.setMeal_items("UPDATED MEAL ITEMS"); // Change the meal items
        meal.setCalories(200);
        meal.setSugar(20);
        meal.setProtein(30);
        meal.setSalt(10);
        meal.setFat(25);

        mealDaoImpl.updateMeal(meal);

        Meal updatedMeal = mealDaoImpl.getMealById(1);

        assertEquals("UPDATED MEAL", updatedMeal.getMeal_title());
        assertEquals("UPDATED MEAL ITEMS", updatedMeal.getMeal_items());
        assertEquals(200, updatedMeal.getCalories(), 0);
        assertEquals(20, updatedMeal.getSugar(), 0);
        assertEquals(30, updatedMeal.getProtein(), 0);
        assertEquals(10, updatedMeal.getSalt(), 0);
        assertEquals(25, updatedMeal.getFat(), 0);
    }

    @Test
    public void testDeleteMeal() {
        mealDaoImpl.deleteMeal(1);

        List<Meal> meals = mealDaoImpl.getAllMeals();
        assertNotNull(meals);
        assertEquals(2, meals.size());
    }
    
}
