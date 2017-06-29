package de.mstock.monolith.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import de.mstock.monolith.domain.Basket;
import de.mstock.monolith.domain.BasketEntryDto;
import de.mstock.monolith.service.ShopService;

@Controller
public class BasketController {

  private static final String TEMPLATE = "basket";
  private double totalPrice = 0;

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
	  	
	Basket basket = consumeRESTService();

	model.addAttribute("basket", basketToDTO(basket, locale));
	model.addAttribute("totalPrice", totalPrice);
    return TEMPLATE;
  }
  
  private Basket consumeRESTService(){
	  RestTemplate restTemplate = new RestTemplate();
      Basket basket = restTemplate.getForObject("http://localhost:8080/order/?user=martin", Basket.class);
      return basket;
  }
  
  private List<ProductDTO> basketToDTO(Basket basket, Locale locale){
	  ArrayList<ProductDTO> products = new ArrayList<ProductDTO>();
	  totalPrice = 0;
	  
	  for (BasketEntryDto product : basket.getProductList()){
		  ProductDTO proDTO = shopService.getProduct(locale, product.getProductDto().getProductId());
		  proDTO.setCount(product.getCount().toString());
		  products.add(proDTO);
		  //TODO: Implement this calculation in frontend for better code-consistency 
		  totalPrice += calcPrice(proDTO.getPrice(), proDTO.getCount());
	  }
	  return products;
  }
  
  private double calcPrice(String price, String count){
	  double articlePrice = 0;
	  articlePrice = Double.valueOf(count) * Double.valueOf(price);  
	  return articlePrice;
  }
  
}
