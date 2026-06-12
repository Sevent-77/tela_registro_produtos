package UI;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class ModernComboBoxUI
        extends BasicComboBoxUI {

    @Override
    protected JButton createArrowButton() {

        JButton button =
                new JButton("▼");

        button.setBorder(null);
        button.setFocusable(false);
        button.setContentAreaFilled(false);

        button.setForeground(
                new Color(76, 175, 80));

        button.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        11));

        return button;
    }
}