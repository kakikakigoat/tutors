package tutors.app.top;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import tutors.domain.model.LessonMenu;

public class DayOfTheWeekComparator implements Comparator<LessonMenu>{
    @Override
    public int compare(LessonMenu lessonMenu1,LessonMenu lessonMenu2) {
        String day1 = lessonMenu1.getId().getDayOfTheWeek();
        String day2 = lessonMenu2.getId().getDayOfTheWeek();
        Map<String,Integer> dayOfTheWeek = new HashMap<>();
        dayOfTheWeek.put("月曜日", 1);
        dayOfTheWeek.put("火曜日", 2);
        dayOfTheWeek.put("水曜日", 3);
        dayOfTheWeek.put("木曜日", 4);
        dayOfTheWeek.put("金曜日", 5);
        dayOfTheWeek.put("土曜日", 6);
        dayOfTheWeek.put("日曜日", 7);
        return dayOfTheWeek.get(day1) < dayOfTheWeek.get(day2) ? -1:1;
    }

}
