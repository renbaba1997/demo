package impl;

import common.PaginationResult;
import model.StudentDTO;
import model.StudentInfoVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    StudentDTO queryStudentInfo(StudentDTO studentDTO);

    PaginationResult<StudentInfoVo> queryStudentInfos(StudentInfoVo studentInfoVo);

    int creatStudentInfo(StudentInfoVo studentInfoVo);

    int deleteStudentInfo(StudentInfoVo studentInfoVo);

    int deleteStudentInfos(List<String> studentNos);
}
