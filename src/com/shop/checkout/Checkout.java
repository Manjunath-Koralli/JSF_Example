package com.shop.checkout;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.flow.FlowScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Size;

import com.shop.product.ShoppingCart;
import com.shop.product.UserManager;

@Named
@FlowScoped("checkout")
public class Checkout implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Pattern(regexp = "[A-Za-z]{1,20}",message = "Please enter valid name")
	private String shippingName;
	
	@Pattern(regexp = "[A-Za-z0-9]{1,30}",message = "Please enter valid address")
	private String shippingAddress;
	
	@Pattern(regexp = "[A-Za-z]{1,20}",message = "Please enter valid city name")
	private String shippingCity;
	
	@Pattern(regexp = "[A-Za-z]{1,20}",message = "Please enter valid name")
	private String paymentName;
	
	@NotNull(message = "Please select a credit card type.")
	private CreditCartType creditCardType;
	
	@Pattern(regexp = "[0-9]{16}", message = "Please enter a valid credit card number.")
	private String creditCardNumber;
	
	private boolean paymentSuccess;
	
	@Inject
	private UserManager userManager;
	
	@Inject
	private ShoppingCart shoppingCart;
	
	@PostConstruct
	public void initialize() {
        if (userManager.isSignedIn()) {
            com.shop.product.User user = userManager.getCurrentUser();
            shippingName = user.getFirstName() + " " + user.getLastName();
            paymentName = shippingName;
        }
    }

    public void fulfillOrder() {
        paymentSuccess = !creditCardNumber.endsWith("00");
    }

    public String finishOrder() {
        if (paymentSuccess) {
            shoppingCart.empty();
        }

        return "finished";
    }
	
	public String getShippingName() {
		return shippingName;
	}
	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public String getShippingCity() {
		return shippingCity;
	}
	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}
	public String getPaymentName() {
		return paymentName;
	}
	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}
	public CreditCartType getCreditCardType() {
		return creditCardType;
	}
	public void setCreditCardType(CreditCartType creditCardType) {
		this.creditCardType = creditCardType;
	}
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public boolean isPaymentSuccess() {
		return paymentSuccess;
	}
	public void setPaymentSuccess(boolean paymentSuccess) {
		this.paymentSuccess = paymentSuccess;
	}
	
	
	

}

