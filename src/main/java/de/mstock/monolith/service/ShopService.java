package de.mstock.monolith.service;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.mstock.monolith.domain.Category;
import de.mstock.monolith.domain.CategoryI18n;
import de.mstock.monolith.domain.CategoryRepository;
import de.mstock.monolith.domain.Product;
import de.mstock.monolith.domain.ProductI18n;
import de.mstock.monolith.domain.ProductRepository;
import de.mstock.monolith.web.CategoryDTO;
import de.mstock.monolith.web.ProductDTO;

@Service
public class ShopService {

  @Autowired
  private CategoryRepository categoryRepository;

  @Autowired
  private ProductRepository productRepository;

  /**
   * Gets all categories of the current language.
   * 
   * @return A simplified Data Transfer Object.
   */
  public List<CategoryDTO> getCategories(Locale locale) {
    String language = locale.getLanguage();
    List<CategoryDTO> categories = new ArrayList<>();
    for (Category category : categoryRepository.findAllOrdered(language)) {
      CategoryI18n i18n = category.getI18n().get(language);
      categories.add(new CategoryDTO(i18n.getName(), i18n.getPrettyUrlFragment()));
    }
    return Collections.unmodifiableList(categories);
  }

  /**
   * Gets all products for a category in the current language.
   * 
   * @return A simplified Data Transfer Object.
   */
  public List<ProductDTO> getProductsForCategory(Locale locale, String prettyUrlFragment) {
    String language = locale.getLanguage();
    Category category = categoryRepository.findByPrettyUrlFragment(language, prettyUrlFragment);
    if (category == null) {
      throw new NotFoundException();
    }
    List<ProductDTO> products = new ArrayList<>();
    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
    for (Product product : category.getProducts()) {
      ProductI18n i18n = product.getI18n().get(language);
      String price = currencyFormat.format(i18n.getPrice());
      products.add(new ProductDTO(product.getItemNumber(), product.getUnit(), i18n.getName(),
          i18n.getPrettyUrlFragment(), price, i18n.getDescription()));
    }
    return Collections.unmodifiableList(products);
  }

  /**
   * Gets a products in the current language.
   * 
   * @return A simplified Data Transfer Object.
   */
  public ProductDTO getProduct(Locale locale, String prettyUrlFragment) {
    String language = locale.getLanguage();
    Product product = productRepository.findByI18nName(language, prettyUrlFragment);
    if (product == null) {
      throw new NotFoundException();
    }
    ProductI18n i18n = product.getI18n().get(language);
    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
    String price = currencyFormat.format(i18n.getPrice());
    return new ProductDTO(product.getItemNumber(), product.getUnit(), i18n.getName(),
        i18n.getPrettyUrlFragment(), price, i18n.getDescription());
  }

}
