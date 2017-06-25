package de.mstock.monolith.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import de.mstock.monolith.domain.Basket;
import de.mstock.monolith.domain.BasketEntryDto;
import de.mstock.monolith.domain.Product;
import de.mstock.monolith.domain.ProductList;
import de.mstock.monolith.service.ShopService;

@Controller
public class BasketController {

  private static final String TEMPLATE = "basket";

  @Autowired
  private ShopService shopService;

  /**
   * Basket page
   * 
   * @param prettyUrlFragment Pretty URL fragment
   * @param model Template model
   * @param locale Current locale
   * @return The template's name.
   */
  @RequestMapping(value = "/basket", method = RequestMethod.GET)
  public String category(Model model, Locale locale) {
	  
	List<ProductDTO> testBasket = shopService.getProductsForCategory(locale, "vegetables");
	
	Basket basket = consumeRESTService();
	  
    //model.addAttribute("categories", shopService.getCategories(locale));
    //model.addAttribute("products", shopService.getProductsForCategory(locale, prettyUrlFragment));
    //model.addAttribute("prettyUrlFragment", prettyUrlFragment);
	//model.addAttribute("basket", testBasket);
	model.addAttribute("basket", basketToDTO(basket, locale));
    return TEMPLATE;
  }
  
  private Basket consumeRESTService(){
	  RestTemplate restTemplate = new RestTemplate();
      Basket basket = restTemplate.getForObject("http://localhost:8080/order/?user=martin", Basket.class);
      return basket;
  }
  
  private List<ProductDTO> basketToDTO(Basket basket, Locale locale){
	  ArrayList<ProductDTO> products = new ArrayList<ProductDTO>();
	  
	  for (BasketEntryDto product : basket.getProductList()){
		  ProductDTO proDTO = shopService.getProduct(locale, product.getProductDto().getProductId());
		  proDTO.setCount(product.getCount().toString());
		  products.add(proDTO);
	  }
	  
	  return products;
  }
}
