package com.test.dao;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;

public class UICommonUtils {

    public static void makeFrameToCenter(JFrame frame) {
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension thissize = frame.getSize();

        if (thissize.width > screensize.width) {
            thissize.width = screensize.width;
        }
        if (thissize.height > screensize.height) {
            thissize.height = screensize.height;
        }
        frame.setSize(1000, 700);
        frame.setLocation((screensize.width - thissize.width) / 5 - 100,
                (screensize.height - thissize.height) / 5 - 100);
    }
}
