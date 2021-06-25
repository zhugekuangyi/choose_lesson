package com.test.ui;

import com.test.dao.LoginDao;
import com.test.dao.UICommonUtils;
import com.test.entity.Admin;
import com.test.entity.Student;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author chuqi
 * @description:
 * @create 2021-06-25 上午10:35
 */
public class Login {

    private        JPanel         LoginJPanel;
    private        JTextField     usernameTextField;
    private        JRadioButton   studentButton;
    private        JRadioButton   teacherButton;
    private        JRadioButton   sysButton;
    private        JPasswordField passwordField;
    private        JButton        LoginButton;
    private static JFrame         frame;

    public static void main(String[] args) {
        new Login();
    }

    public Login() {

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(studentButton);
        buttonGroup.add(teacherButton);
        buttonGroup.add(sysButton);

        LoginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (usernameTextField.getText() == null || usernameTextField.getText().length() <= 0) {
                    JOptionPane.showMessageDialog(frame, "请输入用户名", "提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (passwordField.getText() == null || passwordField.getText().length() <= 0) {
                    JOptionPane.showMessageDialog(frame, "请输入密码", "提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                LoginDao loginDao = new LoginDao();

                String username = usernameTextField.getText().trim();
                String password = passwordField.getText().trim();
                Object userinfo = null;

                if (studentButton.isSelected()) {
                    userinfo = new Student(username, password);
                } else {
                    userinfo = new Admin(username, password);
                }

                String result = loginDao.login(userinfo);
                if (!result.equals("登陆成功")) {
                    JOptionPane.showMessageDialog(frame, result, "提示", JOptionPane.WARNING_MESSAGE);
                    return;
                } else {

                    if (studentButton.isSelected()) {
                        //new HomeStudent();
                    } else {
                        new HomeAdmin();
                    }
                    frame.dispose();
                }
            }
        });


        frame = new JFrame("学生信息管理系统登陆页面");
        frame.setContentPane(LoginJPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        UICommonUtils.makeFrameToCenter(frame);
        frame.setSize(600, 600);

        frame.setVisible(true);


        usernameTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    passwordField.requestFocus();

                }
                super.keyPressed(e);
            }
        });
        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    LoginButton.doClick();

                }
                super.keyPressed(e);
            }
        });

    }
}
