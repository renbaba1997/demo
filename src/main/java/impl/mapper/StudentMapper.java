package impl.mapper;

import model.StudentDTO;
import model.StudentInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {
    StudentDTO queryStudentInfo(StudentDTO studentDTO);

    List<StudentInfoVo> queryStudentInfos(StudentInfoVo studentInfoVo);

    int creatStudentInfo(StudentInfoVo studentInfoVo);

    int deleteStudentInfo(StudentInfoVo studentInfoVo);

    int deleteStudentInfos(List<String> studentNos);
}

