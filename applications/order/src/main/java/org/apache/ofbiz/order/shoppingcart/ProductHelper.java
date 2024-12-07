package org.apache.ofbiz.order.shoppingcart;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ofbiz.base.util.Debug;
import org.apache.ofbiz.order.model.AliExpressProduct;
import org.apache.ofbiz.order.model.AmazonProduct;
import org.apache.ofbiz.order.model.GenericProduct;
import org.apache.ofbiz.order.util.S3Uploader;
import org.apache.ofbiz.service.ServiceUtil;

import java.util.List;
import java.util.Map;

public class ProductHelper {
    private static final String ORDER_BUCKET = System.getenv("ENVIRONMENT") + "-order-bucket";
    private static final S3Uploader s3Uploader = new S3Uploader(ORDER_BUCKET);
    private static final String MODULE = ProductHelper.class.getName();

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

    public static Map<String, Object> buildCheckoutResults(List<GenericProduct> products, String orderId, String orderAdditionalEmails) {
        try {
            String orderJson = new ObjectMapper().writeValueAsString(products);
            s3Uploader.uploadContentsToFile(orderJson, ORDER_BUCKET, orderId);
        } catch (JsonProcessingException e) {
            Debug.logError(e, MODULE);
            return ServiceUtil.returnError(e.getMessage());
        }

        // set the orderId for use by chained events
        Map<String, Object> result = ServiceUtil.returnSuccess();
        result.put("orderId", orderId);
        result.put("orderAdditionalEmails", orderAdditionalEmails);
        result.put("orderProducts", products);

        return result;
    }
}
