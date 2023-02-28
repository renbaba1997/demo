package api;

import common.ObjectRestResponse;
import common.TableResultResponse;
import model.StudentDTO;
import model.StudentInfoVo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public interface StudentApi {
    /**
     * student表查询接口
     */
    @RequestMapping(value = "/api", method = RequestMethod.POST)
    ObjectRestResponse queryStudent(@RequestBody StudentDTO studentDTO);

    @RequestMapping(value = "/queryStudentInfo", method = RequestMethod.POST)
    TableResultResponse<StudentInfoVo> queryStudentInfo(@RequestBody StudentInfoVo studentInfoVo);

    @RequestMapping(value = "/addStudentInfo", method = RequestMethod.POST)
    ObjectRestResponse creatStudentInfo(@RequestBody StudentInfoVo studentInfoVo);

    @RequestMapping(value = "/deleteStudentInfo", method = RequestMethod.POST)
    ObjectRestResponse deleteStudentInfo(@RequestBody StudentInfoVo studentInfoVo);

    @RequestMapping(value = "/deleteStudentInfos", method = RequestMethod.POST)
    ObjectRestResponse deleteStudentInfos(@RequestBody List<StudentInfoVo> studentInfoVoList);

    @GetMapping("/downloadTemplate")
    void downTemplate(HttpServletResponse response) throws IOException;

    @GetMapping("/downloadTable")
    void downTable(HttpServletResponse response, @RequestParam(value = "studentNos") List<String> studentNos) throws IOException;

    @PostMapping("/importTable")
    void importTable(@RequestParam("files") MultipartFile file) throws IOException;
}
