package model;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudentInfoVo extends BaseSearchVo implements Serializable {

    /**
     * 学生编号
     */
    private String studentNo;

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 学生年龄
     */
    private int age;

    /**
     * 学生所在城市
     */
    private String city;
}
