package controller;

import api.StudentApi;
import common.ObjectRestResponse;
import common.PaginationResult;
import common.TableResultResponse;
import impl.StudentService;
import model.StudentDTO;
import model.StudentInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController implements StudentApi {
    @Autowired
    private StudentService studentService;

    @Override
    public ObjectRestResponse<StudentDTO> queryStudent(StudentDTO studentDTO) {
        ObjectRestResponse<StudentDTO> res = new ObjectRestResponse<>();
        StudentDTO responseDTO = new StudentDTO();
        try {
            responseDTO = this.studentService.queryStudentInfo(studentDTO);
        } catch (Exception e) {
            return null;
        }
        res.setData(responseDTO);
        res.setCode("200");
        return res;
    }

    @Override
    public TableResultResponse<StudentInfoVo> queryStudentInfo(StudentInfoVo studentInfoVo) {
        TableResultResponse<StudentInfoVo> res = new TableResultResponse<>();
        try {
            PaginationResult<StudentInfoVo> queryRes = studentService.queryStudentInfos(studentInfoVo);
            res.setData(queryRes);
            res.setCode("200");
        } catch (Exception e) {
            return null;
        }
        return res;
    }

    @Override
    public ObjectRestResponse<StudentInfoVo> creatStudentInfo(StudentInfoVo studentInfoVo) {
        ObjectRestResponse<StudentInfoVo> res = new ObjectRestResponse<>();
        try {
            studentService.creatStudentInfo(studentInfoVo);
            res.setCode("200");
            res.setMessage("学生创建成功！");
            res.setData(null);
        } catch (Exception e) {
            return null;
        }
        return res;
    }

    @Override
    public ObjectRestResponse<StudentInfoVo> deleteStudentInfo(StudentInfoVo studentInfoVo) {
        ObjectRestResponse<StudentInfoVo> res = new ObjectRestResponse<>();
        try {
            studentService.deleteStudentInfo(studentInfoVo);
            res.setData(null);
            res.setCode("200");
            res.setMessage("删除成功！");
        } catch (Exception e) {
            return null;
        }
        return res;
    }

    @Override
    public ObjectRestResponse<StudentInfoVo> deleteStudentInfos(List<StudentInfoVo> studentInfoVoList) {
        ObjectRestResponse<StudentInfoVo> res = new ObjectRestResponse<>();
        List<String> studentNos = new ArrayList<>();
        for (StudentInfoVo studentInfoVo : studentInfoVoList) {
            studentNos.add(studentInfoVo.getStudentNo());
        }
        try {
            this.studentService.deleteStudentInfos(studentNos);
            res.setMessage("删除成功！");
            res.setCode("200");
            res.setData(null);
        } catch (Exception e) {
            return null;
        }
        return res;
    }
}
