package mat.mat_t.web.service;

import lombok.RequiredArgsConstructor;
import mat.mat_t.domain.review.StudentReview;
import mat.mat_t.web.repository.StudentReviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentReviewService {

    private final StudentReviewRepository studentReviewRepository;

    //저장
    public void saveReview(StudentReview studentReview) {
        studentReviewRepository.save(studentReview);
    }

    //수정
    public void updateReview(StudentReview newStudentReview, Long id) {
        StudentReview studentReview = studentReviewRepository.findById(id).get();
        studentReview.update(newStudentReview);
    }

    //삭제
    public void deleteReview(Long id) {
        studentReviewRepository.deleteById(id);
    }

    public List<StudentReview> checkAll() {
        return studentReviewRepository.findAll();
    }

    //클래스 단건 조회
    public StudentReview check(Long classId) {
        return studentReviewRepository.findById(classId).orElse(null);
    }

}
