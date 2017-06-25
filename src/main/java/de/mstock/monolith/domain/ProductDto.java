package de.mstock.monolith.domain;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {

    @NotNull
    @NotEmpty
	@JsonProperty("productId")
    private String productId;

	@JsonProperty("productId")
    public String getProductId() {
        return productId;
    }
	
	@JsonProperty("productId")
	public void setProductId(String productId){
		this.productId = productId;
	}
}