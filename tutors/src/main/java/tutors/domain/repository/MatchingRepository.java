package tutors.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import tutors.domain.model.Matching;


public interface MatchingRepository extends JpaRepository<Matching, Integer>
{
    
    /*user1 教師 user2　生徒*/
    
    Matching findTopByUser1_userIdAndUser2_userIdOrderByApplicationDateDesc
    (Integer teacherUserId,Integer userId);
    
    List<Matching> findByUser1_userIdAndContactAvailabilityIsNullOrderByApplicationDateDesc(int userId);
    
    //①未承認のマッチング申請リスト
    Matching findTopByUser1_userIdAndUser2_userIdAndContactAvailabilityIsNullOrderByApplicationDateDesc(int user1Id,int user2Id);
    
    //申請中のマッチングリスト
    List<Matching> findByUser2_userIdAndContactAvailabilityIsNullOrderByApplicationDateDesc(int userId);
    
    //契約中のTUTORリスト
    List<Matching> findByUser2_userIdAndContactAvailabilityAndContactEndTimeIsNullOrderByApplicationDateDesc(int userId,boolean available);
    
    //契約中の生徒
    List<Matching> findByUser1_userIdAndContactAvailabilityAndContactEndTimeIsNullOrderByApplicationDateDesc(int userId,boolean available);
    
    
    //契約終了時
    Matching findTopByUser1_userIdAndUser2_userIdAndContactEndTimeIsNullOrderByApplicationDateDesc(int user1Id,int user2Id);

}
