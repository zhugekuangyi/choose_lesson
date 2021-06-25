package com.test.ui;

import com.test.dao.CourseDao;
import com.test.dao.Session;
import com.test.dao.UICommonUtils;
import com.test.entity.Admin;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chuqi
 * @description:
 * @create 2021-06-25 上午11:47
 */
public class HomeAdmin {

    private JPanel      HomeAdmin;
    private JButton     exitButton;
    private JLabel      nameLabel;
    private JTabbedPane tabbedPane1;
    private JButton     addOneCourseButton;
    private JButton     deleteOneButton;
    private JButton     saveCourseButton;
    private JTable      table1;
    private JButton     addStudentButton;
    private JButton     deletedStudentButton;
    private JButton     saveStudentButton;
    private JTable      table2;
    private JFrame      frame;

    private CourseModel courseModel;

    public HomeAdmin() {

        courseModel = new CourseModel();

        table1.setModel(courseModel);

        Admin admin = (Admin) Session.userInfo;
        nameLabel.setText(admin.getUsername());

        frame = new JFrame("HomeAdmin");
        frame.setContentPane(HomeAdmin);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();

        UICommonUtils.makeFrameToCenter(frame);

        frame.setVisible(true);
        addOneCourseButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Map<String, Object> map = new HashMap<String, Object>();
                courseModel.addRow(map);
            }
        });
        saveCourseButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                courseModel.save();
            }
        });

    }

    /**
     * 私有内部类
     */
    private class CourseModel extends AbstractTableModel {

        private static final long serialVersionUID = 2599352244912780000L;
        CourseDao                 courseService = new CourseDao();
        List<Map<String, Object>> list          = courseService.findAllCourse();

        String[] tableStrings = { "id", "courseName", "academicYear", "term", "teacherName", "courseQuality", "hours", "score", "count" };
        String[] showStrings  = { "课程编码", "课程名", "学年", "学期", "授课教师", "课程性质", "学时", "学分", "选修人数" };

        public void addRow(Map<String, Object> row) {
            list.add(row);
            fireTableDataChanged();
        }

        public void save() {

            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> map = list.get(i);
                courseService.saveCourse(map);
            }
            list = courseService.findAllCourse();
            fireTableDataChanged();

        }

        public void remove(int rowIndex) {
            Map<String, Object> map = list.get(rowIndex);
            if (map.containsKey("id")) {
                courseService.removeCourse(Integer.parseInt(map.get("id").toString()));
            }
            list.remove(rowIndex);
            fireTableDataChanged();

        }

        @Override
        public int getRowCount() {

            return list.size();
        }

        @Override
        public int getColumnCount() {
            return tableStrings.length - 1;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Map<String, Object> map = list.get(rowIndex);
            return map.get(tableStrings[columnIndex]);

        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex != 0;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Map<String, Object> map = list.get(rowIndex);
            map.put(tableStrings[columnIndex], aValue);
        }

        @Override
        public String getColumnName(int column) {
            return showStrings[column];
        }

    }

}
