import org.testng.Assert;

import java.util.List;

public class HW4_Test {
    public static final int ID = 1;
    public static final String NAME = "Laptop";
    public static final int PRICE = 100000;
    public static final int QUANTITY = 10;
    Warehouse storehouse = new Warehouse();

    @Test
    public void addProductTest() {
        Product good = new Product(ID, NAME, PRICE, QUANTITY);
        storehouse.addProduct(good);
        List<Product> products = storehouse.getProducts();
        Assert.assertTrue(products.contains(good));
    }

    @Test
    public void removeProductTest() {
        Product product = new Product(ID, NAME, PRICE, QUANTITY);
        storehouse.addProduct(product);
        storehouse.removeProduct(product);
        List<Product> products = storehouse.getProducts();
        Assert.assertFalse(products.contains(product));
    }

    @Test
    public void findProductByIdTest() {
        Product product = new Product(ID, NAME, PRICE, QUANTITY);
        storehouse.addProduct(product);

        Product foundProduct = storehouse.findProductById(ID);
        Assert.assertNotNull(foundProduct);
        Assert.assertEquals(foundProduct.getName(), NAME);
    }

    @Test
    public void findNonexistentProductByIdTest() {
        Product foundProduct = storehouse.findProductById((int) Math.random());
        Assert.assertNull(foundProduct);
    }
}
