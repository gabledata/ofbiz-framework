package org.apache.ofbiz.order.model;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class AmazonProduct {

  @JsonProperty("id")
  public Integer id;

  @JsonProperty("name")
  public String name;

  @JsonProperty("description")
  public String description;

  @JsonProperty("price")
  public Double price;

  @JsonProperty("quantity")
  public Integer quantity;

  @JsonProperty("status")
  public String status;

  @JsonProperty("category")
  public String category;

  @JsonProperty("image")
  public String image;

  @JsonProperty("rating")
  public Double rating;
}
