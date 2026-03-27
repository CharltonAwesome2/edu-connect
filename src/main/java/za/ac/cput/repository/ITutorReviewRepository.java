package za.ac.cput.repository;

import za.ac.cput.domain.TutorReview;

import java.util.List;
/* ITutorReviewRepository.java
    TutorReview Repository interface
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 24 March 2026
*/
public interface ITutorReviewRepository extends IRepositry <TutorReview, Long>{
    List<TutorReview> getAll();
}

