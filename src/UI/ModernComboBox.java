package UI;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.*;

public class ModernComboBox<E> extends JComboBox<E> {

    public ModernComboBox(E[] items) {
        super(items);

        setFont(new Font("Segoe UI", Font.PLAIN, 12));
        setBackground(Color.WHITE);
        setForeground(new Color(50, 50, 50));
        setFocusable(false);
        setBorder(new RoundedBorder(12));

        setRenderer(new ModernComboRenderer());
        setUI(new ModernComboBoxUI());
    }

    @Override
    public void updateUI() {
        super.updateUI();

        Object child =
                getAccessibleContext()
                        .getAccessibleChild(0);

        if (child instanceof BasicComboPopup popup) {

            JScrollPane scrollPane =
                    (JScrollPane) popup.getComponents()[0];

            scrollPane.getVerticalScrollBar()
                    .setUI(new ModernScrollBarUI());

            scrollPane.getVerticalScrollBar()
                    .setPreferredSize(
                            new Dimension(8, 0));

            scrollPane.setBorder(null);
        }
    }
}