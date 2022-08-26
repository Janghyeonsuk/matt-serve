package mat.mat_t.web.service;

import lombok.RequiredArgsConstructor;
import mat.mat_t.domain.class_.Classes;
import mat.mat_t.web.repository.ClassRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class ClassService {

    private final ClassRepository classRepository;


    //클래스 생성{
    public void saveClass(Classes classes){
        classRepository.save(classes);
    }

    //클래스 수정
    public void updateClass(Classes upClasses, Long ClassId){
        Classes classes = classRepository.findById(ClassId).get();
        classes.update(upClasses);
    }

    //클래스 삭제
    public void deleteClass(Long ClassId){
        classRepository.deleteById(ClassId);
    }


    //클래스 단건 조회
    public Classes findById(Long classId) {
        return classRepository.findById(classId).orElse(null);
    }

    //전체 클래스 조회
    public List<Classes> findAllClass() {
        return classRepository.findAll();
    }

    //클래스 강사 아이디로 조회
    public List<Classes> findByInstructorId(Long InstructorId) {
        return classRepository.findByInstructorC_InstructorId(InstructorId);
    }

}