package org.apache.ofbiz.order.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class AliExpressProduct {

    @JsonProperty("ali_id")
    public Integer ali_id;

    @JsonProperty("ali_name")
    public String ali_name;

    @JsonProperty("ali_description")
    public String ali_description;

    @JsonProperty("ali_price")
    public Double ali_price;

    @JsonProperty("ali_quantity")
    public Integer ali_quantity;

    @JsonProperty("ali_status")
    public String ali_status;

    @JsonProperty("ali_category")
    public String ali_category;

    @JsonProperty("ali_image")
    public String ali_image;

    @JsonProperty("ali_rating")
    public Double ali_rating;
}
