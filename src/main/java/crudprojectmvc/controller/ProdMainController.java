package crudprojectmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import crudprojectmvc.dao.ProductDao;
import crudprojectmvc.model.Product;

@Controller
public class ProdMainController {

	@Autowired
	private ProductDao productDao;

	@RequestMapping("/index")
	public String getIndex(Model m) {

		List<Product> allProducts = productDao.getAllProducts();
		System.out.println(allProducts);
		m.addAttribute("products", allProducts);

		return "index";
	}

	@RequestMapping("/")
	public String getHome() {
		return "redirect:/index";
	}

	@RequestMapping("/addproduct")
	public String addProduct(Model m) {

		m.addAttribute("title", "add product module");

		return "add-product";
	}

	@RequestMapping(value = "/handle-product", method = RequestMethod.POST)
	public RedirectView handlePage(@ModelAttribute Product product, HttpServletRequest request) {

		System.out.println(product);
		RedirectView redirectView = new RedirectView();
		productDao.createUpdateProduct(product);

		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	}

	@RequestMapping("/deletePost/{id}")
	public RedirectView deletePost(@PathVariable int id, HttpServletRequest request) {
		RedirectView redirectView = new RedirectView();
		productDao.deleteProduct(id);
		redirectView.setUrl(request.getContextPath() + "/index");
		return redirectView;
	}

	@RequestMapping("/updatePost/{id}")
	public String updatePost(@PathVariable int id, Model m, HttpServletRequest request) {
	
		Product prod = productDao.getProdByID(id);
		m.addAttribute("product", prod);
		return "updateForm";
	}

}
