package tutors.app.profile.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class FileUploadExceptionAdvice {

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public String handleMaxSizeException(
      MaxUploadSizeExceededException exc,
      HttpServletRequest request,
      HttpServletResponse response,
      RedirectAttributes attributes ) {
        attributes.addFlashAttribute("error", "ファイルのサイズは最大1MBです");
        return "redirect:profile/edit";
    }
}