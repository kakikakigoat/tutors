package tutors.app.profile.form;

import org.springframework.web.multipart.MultipartFile;

import tutors.app.profile.validation.FileRequired;
import tutors.app.profile.validation.UploadFileMaxSize;
import tutors.app.profile.validation.UploadFileNotEmpty;
import tutors.app.profile.validation.ValidImage;

public class FileUploadForm
{
    @FileRequired(message="ファイルを選択して下さい")
    @UploadFileNotEmpty(message="ファイルが空です。")
    @ValidImage(message="PNG または JPGファイルを選択してください")
    @UploadFileMaxSize(message="1MB以下のファイルを選択してください")
    private MultipartFile uploadFile;

    public MultipartFile getUploadFile()
    {
        return uploadFile;
    }

    public void setUploadFile(MultipartFile uploadFile)
    {
        this.uploadFile = uploadFile;
    }
    
    

}
