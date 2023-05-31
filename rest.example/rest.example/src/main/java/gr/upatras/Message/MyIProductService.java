package gr.upatras.Message;
import java.util.List;

public interface MyIProductService
{
/**
* @return all MyProducts
*/
List<MyProduct> findAll();
/**
* @param id
* @return a {@link MyProduct}
*/
MyProduct findById(int id);
/**
* @param p
* @return the @MyProduct added
*/
MyProduct addMyProduct(MyProduct p);
/**
* @param p
* @return the edited {@link MyProduct}
*/
MyProduct editMyProduct(MyProduct p);
/**
* @param id of MyProduct
*/
Void deleteMyProduct(int id);
}