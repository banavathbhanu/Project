package com.Productimage;

import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.Productimage.Repository.ProductRepository;
import com.Productimage.model.Product;

@SpringBootTest
class ProductimageApplicationTests {

	@MockBean
	ProductRepository repo;
	@Test
	void contextLoads() {
	}
	@Test

    public void saveProductTest() throws IOException
	{
		Product p = new Product();
        p.setId(1);
        p.setitemname("abcd");
        p.sethomemakername("mojaris");
        p.setImage(new byte[0]);
        p.setPrice(1000);
        when(repo.save(p)).thenReturn(p);

    }

}
