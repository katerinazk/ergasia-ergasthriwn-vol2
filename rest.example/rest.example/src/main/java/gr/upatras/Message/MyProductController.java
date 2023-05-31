package gr.upatras.Message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class MyProductController {
	@Autowired
	private MyIProductService MyProductService;
private static final Logger log = LoggerFactory.getLogger( MyProductController.class);
@ApiOperation(value = "Retrieves all MyProducts", notes = "This operation retrieves all MyProduct entities. ", response
= MyProduct.class)
@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = MyProduct.class),
@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
@ApiResponse(code = 404, message = "Not Found", response = Error.class),
@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
@ApiResponse(code = 409, message = "Conflict", response = Error.class),
@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
@RequestMapping(value = "/MyProduct/" , produces = { "application/json;charset=utf-8" }, method =
RequestMethod.GET)
public List<MyProduct> getMyProduct() {
// finds all the MyProducts
List<MyProduct> MyProducts = MyProductService.findAll();
// returns the MyProduct list
return MyProducts;
}
@ApiOperation(value = "Retrieves a MyProduct by ID", notes = "This operation retrieves a MyProduct entity. ", response =
MyProduct.class)
@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = MyProduct.class),
@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
@ApiResponse(code = 404, message = "Not Found", response = Error.class),
@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
@ApiResponse(code = 409, message = "Conflict", response = Error.class),
@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
@RequestMapping(value = "/MyProduct/{id}" , produces = { "application/json;charset=utf-8" }, method =
RequestMethod.GET)
public MyProduct getMyProductById( @ApiParam(value = "Identifier of the Category", required = true) @PathVariable("id")
int id) {
log.info( String.format( "Will return MyProduct with id %s" , id) );
MyProduct MyProduct = MyProductService.findById(id);
return MyProduct;
}
@ApiOperation(value = "Deletes a MyProduct by ID", notes = "This operation retrieves a MyProduct entity. ", response =
MyProduct.class)
@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = MyProduct.class),
@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
@ApiResponse(code = 404, message = "Not Found", response = Error.class),
@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
@ApiResponse(code = 409, message = "Conflict", response = Error.class),
@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
@RequestMapping(value = "/MyProduct/{id}" , produces = { "application/json;charset=utf-8" }, method =
RequestMethod.DELETE)
public ResponseEntity<Void> deletetById( @ApiParam(value = "Identifier of the Category", required = true)
@PathVariable("id") int id) {
try {
log.info( String.format( "Will delete object with id %s" , id) );
return new ResponseEntity<Void>( MyProductService.deleteMyProduct(id), HttpStatus.OK);
} catch (Exception e) {
log.error("Couldn't serialize response for content type application/json", e);
return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
}
}
@ApiOperation(value = "Creates a MyProduct", notes = "This operation creates a MyProduct entity.", response =
MyProduct.class)
@ApiResponses(value = { @ApiResponse(code = 201, message = "Created", response = MyProduct.class),
@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
@ApiResponse(code = 409, message = "Conflict", response = Error.class),
@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
@RequestMapping(value = "/MyProduct", produces = { "application/json;charset=utf-8" }, consumes = {
"application/json;charset=utf-8" }, method = RequestMethod.POST)
public ResponseEntity<MyProduct> createMyProduct(@ApiParam(value = "The MyProduct to be created", required = true)
@RequestBody MyProduct p) {
log.info( "Will add a new MyProduct" );
MyProduct MyProduct = MyProductService.addMyProduct(p);
return new ResponseEntity<MyProduct>( MyProduct, HttpStatus.OK);
}
@ApiOperation(value = "Updates partially a MyProduct", nickname = "patchMyProduct", notes = "This operation updates partially a MyProduct entity.", response = MyProduct.class )
@ApiResponses(value = { @ApiResponse(code = 200, message = "Updated", response = MyProduct.class),
@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
@ApiResponse(code = 404, message = "Not Found", response = Error.class),
@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
@ApiResponse(code = 409, message = "Conflict", response = Error.class),
@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
@RequestMapping(value = "/MyProduct/{id}", produces = {
"application/json;charset=utf-8" }, consumes = {
"application/json;charset=utf-8" }, method = RequestMethod.PATCH)
ResponseEntity<MyProduct> patchMyProduct(
@ApiParam(value = "The MyProduct to be updated", required = true) @RequestBody MyProduct body,
@ApiParam(value = "Identifier of the MyProduct", required = true) @PathVariable("id") String id) {
MyProduct MyProduct = MyProductService.editMyProduct(body);
return new ResponseEntity<MyProduct>( MyProduct, HttpStatus.OK);
}
}
