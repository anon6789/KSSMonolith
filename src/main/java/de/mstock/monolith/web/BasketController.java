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

import de.mstock.monolith.domain.Basket;
import de.mstock.monolith.domain.Product;
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
	  
    //model.addAttribute("categories", shopService.getCategories(locale));
    //model.addAttribute("products", shopService.getProductsForCategory(locale, prettyUrlFragment));
    //model.addAttribute("prettyUrlFragment", prettyUrlFragment);
	model.addAttribute("basket", testBasket);
    return TEMPLATE;
  }
}
