package com.test.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author chuqi
 * @description:
 * @create 2021-06-25 下午4:27
 */
public class CourseDao {


    private JdbcUtils jdbcUtils;

    public CourseDao() {
        jdbcUtils = new JdbcUtils();
        jdbcUtils.getConnection();
    }

    /**
     * 获得所有课程信息
     *
     * @return
     */
    public List<Map<String, Object>> findAllCourse() {
        String sql = "select * from course";

        List<Map<String, Object>> list = new ArrayList<>();
        try {
            list = jdbcUtils.findModeResult(sql, null);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 保存一个课程
     *
     * @param map
     * @return
     */
    public boolean saveCourse(Map<String, Object> map) {
        String sql = "";
        if (map.containsKey("id")) {
            sql = "update course set courseName = ? , academicYear = ?, term = ?,teacherId = ? " +
                  "where id = ?";
        } else {
            sql = "insert into course(courseName,academicYear,term,teacherId) values(?,?,?,?)";
        }

        List<Object> params = new ArrayList<>();
        params.add(map.get("courseName"));
        params.add(map.get("academicYear"));
        params.add(map.get("term"));
        params.add(map.get("teacherId"));
        if (map.containsKey("id")) {
            params.add(map.get("id"));
        }
        boolean flag = false;
        try {
            flag = jdbcUtils.updateByPreparedStatement(sql, params);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return flag;
    }

    /**
     * 删除课程
     * @param id
     * @return
     */
    public boolean removeCourse(int id) {
        String sql = "delete from course where id = ?";
        List<Object> params = new ArrayList<>();
        params.add(id);
        boolean flag = false;
        try {
            flag = jdbcUtils.updateByPreparedStatement(sql, params);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return flag;
    }
}
