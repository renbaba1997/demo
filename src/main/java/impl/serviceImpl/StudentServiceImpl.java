package impl.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import common.PaginationResult;
import impl.StudentService;
import impl.mapper.StudentMapper;
import listener.DataListener;
import lombok.extern.slf4j.Slf4j;
import model.Student;
import model.StudentDTO;
import model.StudentInfoVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.alibaba.excel.EasyExcel;

import java.util.List;


@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private DataListener dataListener;
    @Override
    public StudentDTO queryStudentInfo(StudentDTO studentDTO) {
        logger.info("查询学生的年龄为{}", studentDTO.getAge());
        return studentMapper.queryStudentInfo(studentDTO);
    }

    @Override
    public PaginationResult<StudentInfoVo> queryStudentInfos(StudentInfoVo studentInfoVo) {
        logger.info("页码为{}", studentInfoVo.getPageIndex());
        logger.info("数量为{}", studentInfoVo.getPageSize());
        PageHelper.startPage(studentInfoVo.getPageIndex(), studentInfoVo.getPageSize());
        List<StudentInfoVo> studentInfos = studentMapper.queryStudentInfos(studentInfoVo);
        PageInfo<StudentInfoVo> pageInfo = new PageInfo<>(studentInfos);
        PaginationResult<StudentInfoVo> paginationResult = new PaginationResult<>();
        paginationResult.setData(studentInfos);
        paginationResult.setTotal((int) pageInfo.getTotal());
        return paginationResult;
    }

    @Override
    public int creatStudentInfo(StudentInfoVo studentInfoVo) {
        return studentMapper.creatStudentInfo(studentInfoVo);
    }

    @Override
    public int deleteStudentInfo(StudentInfoVo studentInfoVo) {
        return studentMapper.deleteStudentInfo(studentInfoVo);
    }

    @Override
    public int deleteStudentInfos(List<String> studentNos) {
        return studentMapper.deleteStudentInfos(studentNos);
    }

    @Override
    public List<Student> getStudentInfos(List<String> studentNos) {
        return studentMapper.getStudentInfos(studentNos);
    }

    @Override
    public void importTable(MultipartFile file) {
        try {
            EasyExcel.read(file.getInputStream(), Student.class, dataListener).sheet().doRead();
        } catch (Exception e) {
            logger.info("批量导入数据失败！");
        }
    }
}
