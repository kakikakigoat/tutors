package tutors.app.ajax;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tutors.domain.model.User;
import tutors.domain.repository.MatchingRepository;
import tutors.domain.service.matching.MatchingService;
import tutors.domain.service.user.LoginUserDetails;

@Controller
public class AjaxController
{
    
    @Autowired
    MatchingRepository matchingRepository;
    
    @Autowired
    MatchingService matchingService;
    
    @ResponseBody
    @RequestMapping(value ="/checkdb",method=RequestMethod.POST)
    public String doProcessAjaxRequest(@AuthenticationPrincipal LoginUserDetails userDetails) {
        User user = userDetails.getUser();
        int userId = user.getUserId();
        //未承認の家庭教師申請チェックロジック
        String jsonMatchingList = matchingService.matchingApplicationCheckLogic(userId);
        
        //未承認のマッチングリストをajaxに渡す。
        return jsonMatchingList;
    }
}
