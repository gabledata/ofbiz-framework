package org.apache.ofbiz.order.util;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.nio.charset.StandardCharsets;

public class S3Uploader {

    private S3Client s3;
    private String bucketName;
    public S3Uploader(String bucketName) {
        this.bucketName = bucketName;
        this.s3 = S3Client.builder()
                    .region(Region.US_EAST_1)
                    .credentialsProvider(ProfileCredentialsProvider.create())
                    .build();
    }


    public void uploadContentsToFile(String contents, String bucketName, String key) {
        // Upload the contents to the specified file in the S3 bucket
        try {
            
            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(this.bucketName)
                    .key(key)
                    .contentType("application/json")
                    .build();
            s3.putObject(
                    putObjectRequest,
                    software.amazon.awssdk.core.sync.RequestBody.fromString(contents, StandardCharsets.UTF_8)
            );
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
