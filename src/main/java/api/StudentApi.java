package api;

import common.ObjectRestResponse;
import common.TableResultResponse;
import model.StudentDTO;
import model.StudentInfoVo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
}
