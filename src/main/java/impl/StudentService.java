package impl;

import common.PaginationResult;
import model.Student;
import model.StudentDTO;
import model.StudentInfoVo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StudentService {

    StudentDTO queryStudentInfo(StudentDTO studentDTO);

    PaginationResult<StudentInfoVo> queryStudentInfos(StudentInfoVo studentInfoVo);

    int creatStudentInfo(StudentInfoVo studentInfoVo);

    int deleteStudentInfo(StudentInfoVo studentInfoVo);

    int deleteStudentInfos(List<String> studentNos);

    List<Student> getStudentInfos(List<String> studentNos);

    void importTable(MultipartFile file);
}
