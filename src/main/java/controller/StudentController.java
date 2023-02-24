package controller;

import api.StudentApi;
import com.alibaba.excel.EasyExcel;
import common.ObjectRestResponse;
import common.PaginationResult;
import common.TableResultResponse;
import impl.StudentService;
import model.Student;
import model.StudentDTO;
import model.StudentInfoVo;
import org.apache.tomcat.util.http.fileupload.impl.IOFileUploadException;
import org.burningwave.core.assembler.StaticComponentContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
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

    @Override
    public void downTemplate(HttpServletResponse response) throws IOException {
        StaticComponentContainer.Modules.exportAllToAll();
        //设置防止文件名中文乱码
        List<Student> resList = new ArrayList<>();
        Student test1 = new Student();
        test1.setStudentNo("20230210");
        test1.setName("小军");
        test1.setAge(25);
        test1.setCity("三元");
        resList.add(test1);
        String fileName = URLEncoder.encode("studentTemplate", "utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes("utf-8"),"ISO8859-1") + ".xlsx");
        EasyExcel.write(response.getOutputStream(), Student.class).sheet("学生信息模板表").doWrite(resList);
    }

    @Override
    public void downTable(HttpServletResponse response, List<String> studentNos) throws IOException {
    }
}
