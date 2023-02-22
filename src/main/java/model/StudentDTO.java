package model;

import lombok.Data;

@Data
public class StudentDTO {

    /**
     * 学生姓名
     */
    String name;

    /**
     * 学生年龄
     */
    Integer age;

    /**
     * 学生城市
     */
    String City;
}
