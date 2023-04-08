/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utility;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Hieucode
 */
public class Uhelper {
    public static boolean checkNull(JTextField txt, String mess) {
        if (txt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, mess);
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean checkNumber(JTextField txt, String mess) {
        if (!txt.getText().matches("[0-9.]+")) {
            JOptionPane.showMessageDialog(null, mess);
            return true;
        } else {
            return false;
        }
    }
    
}
