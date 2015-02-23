/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.cudlax.dao.impl.ProductDAOImpl;
import pl.cudlax.domain.Category;
import pl.cudlax.domain.Product;

/**
 *
 * @author arekb
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class DaoImplProductJUnitTest {
    private Product product;

    public DaoImplProductJUnitTest() {
        product=new Product();
        product.setAmount(24.0);
        product.setDescription("description");
        product.setCatalogNum("1");
        product.setName("testProduct");
        product.setProductId((long) 1);
        

    }
    
    @Autowired
    public ProductDAOImpl productDAOImpl;

    
    public void setProductDAOImpl(ProductDAOImpl productDAOImpl) {
        this.productDAOImpl = productDAOImpl;
    }

      @Test
     public void forthTest() {//TEST-INICJALIZACJA OBIEKTU DAO
         
         assertEquals("description", product.getDescription());
         assertEquals((double)24.0, (Object)product.getAmount());
         assertEquals("1", product.getCatalogNum());
         assertEquals("testProduct", product.getName());
         assertEquals((Object)(long)1, product.getProductId());
          

     }
    @Test
    public void fifthTest() {//TEST-DODANIE NOWEGO PRODUKTU
        productDAOImpl.createProduct(product);
        int id = productDAOImpl.getProducts().size() - 1;

        assertEquals("description", productDAOImpl.getProducts().get(id).getDescription());
        assertEquals((double) 24.0, (Object) productDAOImpl.getProducts().get(id).getAmount());
        assertEquals("1", productDAOImpl.getProducts().get(id).getCatalogNum());
        assertEquals("testProduct", productDAOImpl.getProducts().get(id).getName());


    }

    @Test
    public void sixthTest() {//TEST-AKTUALIZACJA PRODUKTU

        product.setAmount(25.0);
        productDAOImpl.updateProduct(product);
        assertEquals(product.getAmount(), (Object) productDAOImpl.getProducts().get(0).getAmount());
        product.setAmount(24.0);
        productDAOImpl.updateProduct(product);
    }
      @Test
     public void seventhTest() {//TEST-USUNIECIE PRODUKTU

         int productListSizeExpected=productDAOImpl.getProducts().size()-1;
         product.setProductId((long)productDAOImpl.getProducts().get(productListSizeExpected).getProductId());
         productDAOImpl.removeProduct(product);
         int productListSizeGot=productDAOImpl.getProducts().size();
         assertEquals(productListSizeExpected,productListSizeGot);

     }
}
