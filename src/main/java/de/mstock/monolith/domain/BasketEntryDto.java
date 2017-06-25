package de.mstock.monolith.domain;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class BasketEntryDto {

    @NotNull
	@JsonProperty("productDto")
    private ProductDto productDto;

    @NotNull
    @Min(1)
    @Max(10)
	@JsonProperty("count")
    private Integer count;

    public BasketEntryDto() {
    }
    
	@JsonProperty("productDto")
    public ProductDto getProductDto() {
        return productDto;
    }
    
	@JsonProperty("productDto")
    public void setProductDtc(ProductDto productDto){
    	this.productDto = productDto;
    }
    
	@JsonProperty("count")
    public Integer getCount() {
        return count;
    }
    
	@JsonProperty("count")
    public void setCount(Integer count){
    	this.count = count;
    }
}