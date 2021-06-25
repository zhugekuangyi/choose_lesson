package com.test.dao;

import com.test.entity.Admin;
import com.test.entity.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chuqi
 * @description:
 * @create 2021-06-25 上午11:06
 */
public class LoginDao {


    private JdbcUtils jdbcUtils;

    /**
     * 初始化数据库链接
     */
    public LoginDao() {
        jdbcUtils = new JdbcUtils();
        jdbcUtils.getConnection();
    }

    /**
     * 登陆
     * @param object
     * @return
     */
    public String login(Object object) {
        String resultStr = "登陆失败";
        String username = null;
        String password = null;
        String sql = null;
        //根据class类型判断是哪种哟哦那个户登陆
        if (Admin.class == object.getClass()) {
            Admin admin = (Admin) object;
            username = admin.getUsername();
            password = admin.getPassword();
            sql = "select * from admin where username = ? and password = ?";
            List<Object> params = new ArrayList<>();
            params.add(username);
            params.add(password);
            try {
                Admin databaseAdmin = jdbcUtils.findSimpleRefResult(sql, params, Admin.class);
                if (databaseAdmin != null) {
                    Session.userInfo = databaseAdmin;
                    resultStr = "登陆成功";
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return resultStr;
            }
        } else if (Student.class == object.getClass()) {
            Student student = (Student) object;
            username = student.getUsername();
            password = student.getPassword();
            sql = "select * from student where username = ? and password = ?";
            List<Object> params = new ArrayList<>();
            params.add(username);
            params.add(password);
            try {
                Student databaseStudent = jdbcUtils.findSimpleRefResult(sql, params, Student.class);
                if (databaseStudent != null) {
                    Session.userInfo = databaseStudent;
                    resultStr = "登陆成功";
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return resultStr;
            }
        }
        return resultStr;

    }

    /**
     * 登出
     */
    public void logout() {
        Session.userInfo = null;
    }

    /**
     * 程序中止时垃圾回收所有对象，并断开数据库链接
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        if (jdbcUtils != null) {
            jdbcUtils.releaseConn();
            jdbcUtils = null;

        }
    }
}
