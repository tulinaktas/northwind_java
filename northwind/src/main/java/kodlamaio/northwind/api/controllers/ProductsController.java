package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.entities.concretes.Product;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
	
	private ProductService productService;
	
	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getall")
	public DataResult<List<Product>> getAll(){
		return this.productService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		return this.productService.add(product);
	}
	
	@GetMapping("/getbyproductname")
	public DataResult<Product> getByProductName(@RequestParam String productName) {
		return this.productService.getByProductName(productName);
	}

	@GetMapping("/getbyproductnameandcategoryid")
	public DataResult<Product> getByProductNameAndCategoryId(@RequestParam(name="productName") String productName, @RequestParam(name="categoryId") int categoryId) {
		return this.productService.getByProductNameAndCategoryId(productName, categoryId);
	}

	@GetMapping("/getbyproductnameorcategoryid")
	public DataResult<List<Product>> getByProductNameOrCategoryId(@RequestParam(name="productName") String productName, @RequestParam(name="categoryId") int categoryId) {
		return this.productService.getByProductNameOrCategoryId(productName, categoryId);
	}

	@GetMapping("/getbycategoryidin")
	public DataResult<List<Product>> getByCategoryIdIn(@RequestParam List<Integer> categories) {
		return this.productService.getByCategoryIdIn(categories);
	}

	@GetMapping("/getbyproductnamecontains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName) {
		return this.productService.getByProductNameContains(productName);
	}

	@GetMapping("/getbyproductnamestartswith")
	public DataResult<List<Product>> getByProductNameStartsWith(@RequestParam String productName) {
		return this.productService.getByProductNameStartsWith(productName);
	}

	@GetMapping("/getbynameandcategory")
	public DataResult<List<Product>> getByNameAndCategory(@RequestParam(name="productName") String productName,@RequestParam(name="categoryId") int categoryId) {
		return this.productService.getByNameAndCategory(productName, categoryId);
	}
	
	@GetMapping("/getallbypage")
	public DataResult<List<Product>> getAll(int pageNo, int pageSize){
		return this.productService.getAll(pageNo, pageSize);
	}
	
	@GetMapping("/getallsortedasc")
	public DataResult<List<Product>> getAllSorted(){
		return this.productService.getAllSorted();
	}

}
