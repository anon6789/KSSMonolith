package de.mstock.monolith.domain;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CouponDto {
	
	@NotNull
    @NotEmpty
	@JsonProperty("couponCode")
    private String couponCode;
	
	@NotNull
    @NotEmpty
	@JsonProperty("validFrom")
    private long validFrom;
	
	@JsonProperty("validUntil")
    private long validUntil;
	
	@NotNull
    @NotEmpty
	@JsonProperty("rate")
    private int rate;

	@JsonProperty("couponCode")
	public String getCouponCode() {
		return couponCode;
	}

	@JsonProperty("couponCode")
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	@JsonProperty("validFrom")
	public long getValidFrom() {
		return validFrom;
	}

	@JsonProperty("validFrom")
	public void setValidFrom(long validFrom) {
		this.validFrom = validFrom;
	}
	
	@JsonProperty("validUntil")
	public long getValidUntil() {
		return validUntil;
	}

	@JsonProperty("validUntil")
	public void setValidUntil(long validUntil) {
		this.validUntil = validUntil;
	}

	@JsonProperty("rate")
	public int getRate() {
		return rate;
	}

	@JsonProperty("rate")
	public void setRate(int rate) {
		this.rate = rate;
	}
	
	

}
