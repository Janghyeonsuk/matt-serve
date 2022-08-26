package mat.mat_t.web.service;

import lombok.RequiredArgsConstructor;
import mat.mat_t.domain.class_.WaitingStudent;

import mat.mat_t.domain.user.User;

import mat.mat_t.web.repository.WaitingStudentsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class WaitingStudentsService {

    private final WaitingStudentsRepository waitingStudentsRepository;

    public void add(WaitingStudent student) {

        hasDuplicate(student);
        waitingStudentsRepository.save(student);
    }

    private void hasDuplicate(WaitingStudent student) {
        List<WaitingStudent> findStudents = waitingStudentsRepository.findListByClassId(student.getClassesWS().getClassId());
        if (!findStudents.isEmpty()) {
            throw new IllegalStateException("이미 신청한 클래스입니다.");
        }
    }



    public void delete(WaitingStudent student) {
        waitingStudentsRepository.remove(student);
    }


    public List<WaitingStudent> findStudentsByClassId(Long classId) {
        return waitingStudentsRepository.findListByClassId(classId);
    }

}