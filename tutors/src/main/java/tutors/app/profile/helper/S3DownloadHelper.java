package tutors.app.profile.helper;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class S3DownloadHelper{

    private static final String S3_BUCKET_PREFIX = "s3://";
    private static final String DIRECTORY_DELIMITER = "/";

    @Value("tutorsimage")
    private String bucketName;

    @Autowired
    ResourceLoader resourceLoader;

    public BufferedImage getImage(String imageFilePath){
        Resource resource = resourceLoader.getResource(
                new StringBuilder()
                .append(S3_BUCKET_PREFIX)
                .append(bucketName)
                .append(DIRECTORY_DELIMITER)
                .append(imageFilePath)
                .toString());
        BufferedImage image = null;
        //InputStreamで読み込み
        try(InputStream inputStream = resource.getInputStream()){
            image = ImageIO.read(inputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
        return image;
    }
}