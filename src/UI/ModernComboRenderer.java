package UI;

import java.awt.*;
import javax.swing.*;

public class ModernComboRenderer
        extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(
            JList<?> list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {

        JLabel label =
                (JLabel) super.getListCellRendererComponent(
                        list,
                        value,
                        index,
                        isSelected,
                        cellHasFocus);

        label.setFont(
                new Font("Segoe UI",
                        Font.PLAIN,
                        13));

        label.setBorder(
                BorderFactory.createEmptyBorder(
                        8,
                        12,
                        8,
                        12));

        if (isSelected) {

            label.setBackground(
                    new Color(76, 175, 80));

            label.setForeground(
                    Color.WHITE);

        } else {

            label.setBackground(
                    Color.WHITE);

            label.setForeground(
                    new Color(40, 40, 40));
        }

        return label;
    }
}