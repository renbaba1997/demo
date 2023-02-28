package model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@NoArgsConstructor
@ColumnWidth(20)
public class StudentInfoVo extends BaseSearchVo implements Serializable {

    /**
     * 学生编号
     */
    @ExcelProperty(value = "学生编号")
    private String studentNo;

    /**
     * 学生姓名
     */
    @ExcelProperty(value = "学生姓名")
    private String name;

    /**
     * 学生年龄
     */
    @ExcelProperty(value = "学生年龄")
    private Integer age;

    /**
     * 学生所在城市
     */
    @ExcelProperty(value = "学生城市")
    private String city;
}
