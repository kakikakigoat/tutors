package tutors.app.profile.helper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


import com.amazonaws.services.s3.AmazonS3;


import org.apache.commons.io.IOUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.WritableResource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class S3UploadHelper{

    private static final String S3_BUCKET_PREFIX = "s3://";
    private static final String DIRECTORY_DELIMITER = "/";

    @Value("tutorsimage")
    private String bucketName;

    @Autowired
    ResourceLoader resourceLoader;

    @Autowired
    ResourcePatternResolver resourcePatternResolver;

    @Autowired
    AmazonS3 amazonS3;
    
    

    public String saveFile(MultipartFile multipartFile){
        String objectKey = new StringBuilder()
                .append(S3_BUCKET_PREFIX)
                .append(bucketName)
                .append(DIRECTORY_DELIMITER)
                .append(multipartFile.getOriginalFilename())
                .toString();
        WritableResource writableResource = (WritableResource)resourceLoader.getResource(objectKey);
        try(InputStream inputStream = multipartFile.getInputStream();
            OutputStream outputStream = writableResource.getOutputStream()){
            IOUtils.copy(inputStream, outputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
        return objectKey;
    }
    
    
    //テスト
    public String saveImage(int userId,MultipartFile multipartFile){
        String objectKey = new StringBuilder()
                .append(S3_BUCKET_PREFIX)
                .append(bucketName)
                .append(DIRECTORY_DELIMITER)
                .append(userId)
                .toString();
        WritableResource writableResource = (WritableResource)resourceLoader.getResource(objectKey);
        try(InputStream inputStream = multipartFile.getInputStream();
            OutputStream outputStream = writableResource.getOutputStream()){
            IOUtils.copy(inputStream, outputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
        return objectKey;
    }
}