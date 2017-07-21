package de.mstock.monolith.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "basketEntryDtoList" })
public class Basket {

	@JsonProperty("basketEntryDtoList")
	private List<BasketEntryDto> productList = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	@JsonProperty("couponDto")
	private CouponDto couponDto;


	@JsonProperty("basketEntryDtoList")
	public List<BasketEntryDto> getProductList() {
		return productList;
	}
	
	@JsonProperty("basketEntryDtoList")
	public void setProductList(List<BasketEntryDto> productList) {
		this.productList = productList;
	}
	
	@JsonProperty("couponDto")
	public CouponDto getCouponDto() {
		return this.couponDto;
	}

	@JsonProperty("couponDto")
	public void setCouponDto(CouponDto couponDto) {
		this.couponDto = couponDto;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
	
	@Override
    public String toString() {
		return "Basket contains " + productList.size() + " items." ;
	}

}