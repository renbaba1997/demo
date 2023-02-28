package model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@ColumnWidth(20)
public class Student {

    @ExcelProperty(value = "学生编号")
    private String studentNo;

    @ExcelProperty(value = "学生姓名")
    private String name;

    @ExcelProperty(value = "学生年龄")
    private Integer age;

    @ExcelProperty(value = "学生城市")
    private String city;

    public Student(String studentNo, String name, Integer age, String city) {
        this.studentNo = studentNo;
        this.name = name;
        this.age = age;
        this.city = city;
    }
}
