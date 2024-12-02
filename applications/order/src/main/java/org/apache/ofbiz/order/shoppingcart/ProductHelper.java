package org.apache.ofbiz.order.shoppingcart;

import org.apache.ofbiz.order.model.AliExpressProduct;
import org.apache.ofbiz.order.model.AmazonProduct;
import org.apache.ofbiz.order.model.GenericProduct;

public class ProductHelper {

    public static GenericProduct fromAmazonProduct(AmazonProduct ap) {
        GenericProduct gp = new GenericProduct(
                ap.id,
                ap.name,
                ap.description,
                ap.price,
                ap.quantity,
                ap.status,
                ap.category,
                ap.image,
                ap.rating);
        return gp;
    }

    public static GenericProduct fromAliExpressProduct(AliExpressProduct aep) {
        GenericProduct gp = new GenericProduct(
                aep.ali_id,
                aep.ali_name,
                aep.ali_description,
                aep.ali_price,
                aep.ali_quantity,
                aep.ali_status,
                aep.ali_category,
                aep.ali_image,
                aep.ali_rating);
        return gp;
    }

}
