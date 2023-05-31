package gr.upatras.Message;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MyProductService implements MyIProductService {
	List<MyProduct> MyProducts = new ArrayList<MyProduct>();
	int ix = 1000;
	/**
	* adding MyProducts to the List
	*/
	public MyProductService() {
	super();
	MyProducts.add(new MyProduct(100, "Mobile", "CLK98123", 9000.00, 6));
	MyProducts.add(new MyProduct(101, "Smart TV", "LGST09167", 60000.00, 3));
	MyProducts.add(new MyProduct(102, "Washing Machine", "38753BK9", 9000.00, 7));
	MyProducts.add(new MyProduct(103, "Laptop", "LHP29OCP", 24000.00, 1));
	MyProducts.add(new MyProduct(104, "Air Conditioner", "ACLG66721", 30000.00, 5));
	MyProducts.add(new MyProduct(105, "Refrigerator ", "12WP9087", 10000.00, 4));
	}
	/**
	* returns a list of MyProduct
	*/
	@Override
	public List<MyProduct> findAll() {
	return MyProducts;
	}
	@Override
	public MyProduct findById(int id) {
	for (MyProduct p : MyProducts) {
	if (p.getId() == id) {
	return p;
	}
	}
	return null;
	}
	@Override
	public MyProduct addMyProduct(MyProduct p) {
	ix = ix +1; //increase MyProduct index
	p.setId( ix );
	MyProducts.add( p );
	return p;
	}
	@Override
	public MyProduct editMyProduct(MyProduct p) {
	MyProduct editProd = findById( p.getId() );
	if ( editProd != null ) {
	editProd.setPname( p.getPname() );
	editProd.setPrice( p.getPrice() );
	return editProd;
	}
	return null;
	}
	@Override
	public Void deleteMyProduct(int id) {
	for (MyProduct p : MyProducts) {
	if (p.getId() == id) {
	MyProducts.remove(p);
	break;
	}
	}
	return null;
	}
}
