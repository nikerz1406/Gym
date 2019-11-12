/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Viet
 */
public class ProjectLib {

    public static String imgChooser(JLabel lblAvatar) {
        try {
            String path = "";
            JFileChooser file = new JFileChooser();
            file.setCurrentDirectory(new File(System.getProperty("user.home")));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
            file.addChoosableFileFilter(filter);
            int result = file.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = file.getSelectedFile();
                path = selectedFile.getAbsolutePath();
                ImageIcon imgIco = new ImageIcon(path);
                imgResize(imgIco, lblAvatar);
                /*
            ImageIcon imgIco=new ImageIcon(path);
            Image img=imgIco.getImage().getScaledInstance(width,height,Image.SCALE_SMOOTH);
            imgIco=new ImageIcon(img);
                 */
            } else if (result == JFileChooser.CANCEL_OPTION) {
                path = "";
            }
            return path;
        } catch (HeadlessException e) {
            System.out.println(e);
        }
        return "";
    }

    public static void imgResize(ImageIcon imgIco, JLabel lblAvatar) {
        Image img = imgIco.getImage().getScaledInstance(lblAvatar.getWidth(), lblAvatar.getHeight(), Image.SCALE_SMOOTH);
        imgIco = new ImageIcon(img);
        lblAvatar.setIcon(imgIco);
    }

    public static void hideLbl(ArrayList<JLabel> lblList) {
        lblList.forEach(i -> {
            i.setText("");
        });
    }

    public static void setStatusComponent(JPanel panel, Boolean isEnabled) {
        panel.setEnabled(isEnabled);
        Component[] components = panel.getComponents();
        for (Component component : components) {
            if (component instanceof JPanel) {
                setStatusComponent((JPanel) component, isEnabled);
            }
            component.setEnabled(isEnabled);
        }
    }

    public static boolean checkRegExp(String text, String field) {
        Pattern pt;
        Matcher mc;
        switch (field) {
            case "name":
                pt = Pattern.compile("^[a-zA-Z]+(\\s[a-zA-Z]+)+$");
                mc = pt.matcher(text);
                return mc.matches();
            case "number":
                pt = Pattern.compile("^\\d+$");
                mc = pt.matcher(text);
                return mc.matches();
            case "email":
                pt = Pattern.compile("^[a-zA-Z0-9](([_\\.]|[a-zA-Z0-9]){0,}){5,30}@[a-zA-Z]{2,}(\\.[a-zA-Z]{2,4}){1,2}$");
                mc = pt.matcher(text);
                return mc.matches();
            case "password":
                pt = Pattern.compile("\"^[a-zA-Z0-9]+");
                mc = pt.matcher(text);
                return mc.matches();
            case "productName":
                pt = Pattern.compile("^[a-zA-Z]+(\\s[a-zA-Z0-9]+)*$");
                mc = pt.matcher(text);
                return mc.matches();
            case "productPrice":
                pt = Pattern.compile("^\\d+(.\\d+)?$");
                mc = pt.matcher(text);
                return mc.matches();
            default:
                return false;
        }
    }
}
