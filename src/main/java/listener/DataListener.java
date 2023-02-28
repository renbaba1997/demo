package listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import impl.mapper.StudentMapper;
import lombok.extern.slf4j.Slf4j;
import model.Student;
import model.StudentInfoVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@Scope("prototype")
public class DataListener extends AnalysisEventListener<Student> {

    private static final int BATCH_COUNT = 100;

    private static final Logger logger = LoggerFactory.getLogger(DataListener.class);

    @Autowired
    private StudentMapper  studentMapper;

    List<Student> list = new ArrayList<>();

    @Override
    public void invoke(Student student, AnalysisContext analysisContext) {
        list.add(student);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
    }

    @Transactional(rollbackFor = Exception.class)
    public void saveData() {
        list.forEach(item -> {
            if (item.getStudentNo() != null) {
                StudentInfoVo studentInfoVo = new StudentInfoVo();
                BeanUtils.copyProperties(item, studentInfoVo);
                studentMapper.creatStudentInfo(studentInfoVo);
            }
        });
    }
}
