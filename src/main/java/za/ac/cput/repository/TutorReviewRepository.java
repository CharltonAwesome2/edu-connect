package za.ac.cput.repository;

import za.ac.cput.domain.TutorReview;

import java.util.ArrayList;
import java.util.List;
/* TutorReviewRepository.java
    TutorReview Repository class
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 24 March 2026
*/
public class TutorReviewRepository implements ITutorReviewRepository {

    private static ITutorReviewRepository repository = null;
    private List<TutorReview> tutorReviewList;

    private TutorReviewRepository(){
        tutorReviewList = new ArrayList<>();
    }

    public static ITutorReviewRepository getRepository(){
        if(repository == null){
            repository = new TutorReviewRepository();
        }
        return repository;
    }

    @Override
    public TutorReview create(TutorReview tutorReview) {
        boolean successfull = tutorReviewList.add(tutorReview);
        if (successfull){
            return  tutorReview;
        }
        return null;
    }
    @Override
    public TutorReview read(Long id) {
        for(TutorReview review : tutorReviewList){
            if(review.getReviewId().equals(id)){
                return review;
            }
        }
        return null;
    }

    @Override
    public TutorReview update(TutorReview tutorReview) {
        TutorReview oldTutorReview = read(tutorReview.getReviewId());
        if(oldTutorReview == null){
            return null;
        }
        tutorReviewList.remove(oldTutorReview);
        tutorReviewList.add(tutorReview);
        return tutorReview;
    }

    @Override
    public boolean delete(Long id) {
        TutorReview review = read(id);
        if(review == null){
            return false;
        }
        return tutorReviewList.remove(review);
    }

    @Override
    public List<TutorReview> getAll() {
        return new ArrayList<>(tutorReviewList);
    }


}


