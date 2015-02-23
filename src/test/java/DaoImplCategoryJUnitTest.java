/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import javax.inject.Inject;
import org.hibernate.SessionFactory;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.cudlax.dao.impl.CategoryDAOImpl;
import pl.cudlax.domain.Category;



/**
 *
 * @author arekb
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class DaoImplCategoryJUnitTest {
    
    
    private Category category;
    public DaoImplCategoryJUnitTest() {
        category=new Category();
        category.setCategoryId((long)1);
        category.setName("kategoriaTestowa");
                
    }

    @Autowired
    public CategoryDAOImpl categoryDAOImpl;

    public void setCategoryDAOImpl(CategoryDAOImpl categoryDAOImpl) {
        this.categoryDAOImpl = categoryDAOImpl;
    }

      @Test
     public void firstTest() {//TEST-INICJALIZACJA OBIEKTU DAO
         assertEquals("kategoriaTestowa", category.getName());

     }
     @Test
     public void secondTest() {//TEST-DODANIE NOWEJ KATEGORII

         categoryDAOImpl.createCategory(category);
         int id=categoryDAOImpl.getAllCategories().size()-1;
         assertEquals("kategoriaTestowa",categoryDAOImpl.getAllCategories().get(id).getName() );
     }
    @Test
    public void thirdTest() {//TEST-USUNIECIE KATOEGORII
        int listSizeExpected=categoryDAOImpl.getAllCategories().size()-1;
        category.setCategoryId((long)categoryDAOImpl.getAllCategories().get(listSizeExpected).getCategoryId());
        category.setName(categoryDAOImpl.getAllCategories().get(listSizeExpected).getName());
        categoryDAOImpl.removeCategory(category);
        int listSizeGot=categoryDAOImpl.getAllCategories().size();
        assertEquals(listSizeExpected,listSizeGot);

    }
}
