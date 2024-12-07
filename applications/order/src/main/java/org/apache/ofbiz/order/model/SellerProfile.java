package org.apache.ofbiz.order.model;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class SellerProfile {

    @JsonProperty("id")
    public Integer id;

    @JsonProperty("name")
    public String name;
}