package UI;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class ModernTable {

    public static void style(JTable table) {

        table.setRowHeight(30);
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 0));

        table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        table.setSelectionBackground(new Color(220, 240, 220));
        table.setSelectionForeground(Color.BLACK);

        JTableHeader header = table.getTableHeader();

        header.setFont(new Font("Segoe UI", Font.BOLD, 13));
        header.setBackground(new Color(76, 175, 80));
        header.setForeground(Color.WHITE);

        header.setReorderingAllowed(false);
        header.setResizingAllowed(false);

        ZebraRenderer zebra = new ZebraRenderer();

        table.setDefaultRenderer(Object.class, zebra);
    }

    public static JScrollPane wrap(JTable table) {
        JScrollPane scrollPane = new JScrollPane(table);

        scrollPane.setBorder(
            BorderFactory.createLineBorder(new Color(220, 220, 220))
        );

        scrollPane.getVerticalScrollBar()
                  .setUI(new ModernScrollBarUI());

        return scrollPane;
    }
}