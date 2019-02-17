import com.itheima.entity.PageBean;
import com.itheima.entity.Product;
import com.itheima.service.IProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class test {
    @Autowired
    private IProductService productService;

    @Test
    public void find(){
        System.out.println(productService.findAll());
    }

    @Test
    public void select(){
        PageBean<Product> byPage = productService.findByPage(1, 5);
        System.out.println(byPage);
    }
}
