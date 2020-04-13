package tutors.domain.service.matching;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import tutors.domain.model.Matching;
import tutors.domain.repository.MatchingRepository;

@Service
public class MatchingService {

    @Autowired
    MatchingRepository matchingRepository;

    public String matchingApplicationCheckLogic(int userId) {
        //ログインユーザーの未承認申請をチェック
        List<Matching> matchingList =
                matchingRepository.findByUser1_userIdAndContactAvailabilityIsNullOrderByApplicationDateDesc(userId);
        
        List<Json> jsonList = new ArrayList<>();
        for(Matching matching:matchingList) {
            Json json = new Json();
            SimpleDateFormat sdf = new SimpleDateFormat("MM'/'dd' 'k'時'mm'分'");
           json.setApplicationDate(sdf.format(matching.getApplicationDate()));
           json.setUserName(matching.getUser2().getUserName());
           jsonList.add(json);
        }
        String jsonMatchingList = "";
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            //JSON文字列に変換
            jsonMatchingList = mapper.writeValueAsString(jsonList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        
        return jsonMatchingList;
        
    }
}
