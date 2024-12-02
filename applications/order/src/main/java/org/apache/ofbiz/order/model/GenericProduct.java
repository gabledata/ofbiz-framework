package org.apache.ofbiz.order.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class GenericProduct {

    public GenericProduct(Integer productId, String productName, String productDescription, Double productPrice,
            Integer productQuantity, String productStatus, String productCategory, String productImage,
            Double productRating) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productStatus = productStatus;
        this.productCategory = productCategory;
        this.productImage = productImage;
        this.productRating = productRating;
    }

    @JsonProperty("productId")
    public Integer productId;

    @JsonProperty("productName")
    public String productName;

    @JsonProperty("productDescription")
    public String productDescription;

    @JsonProperty("productPrice")
    public Double productPrice;

    @JsonProperty("productQuantity")
    public Integer productQuantity;

    @JsonProperty("productStatus")
    public String productStatus;

    @JsonProperty("productCategory")
    public String productCategory;

    @JsonProperty("productImage")
    public String productImage;

    @JsonProperty("productRating")
    public Double productRating;
}
