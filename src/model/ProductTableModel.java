package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ProductTableModel extends AbstractTableModel {

    private final List<Product> products;
    private final String[] columnNames;

    public ProductTableModel(List<Product> products, String[] columnNames) {
        this.products = products;
        this.columnNames = columnNames;
    }

    @Override
    public int getRowCount() {
        return products.size();
    }

    @Override
    public int getColumnCount() {
    	
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Product p = products.get(row);

        return switch (col) {
            case 0 -> p.getName();
            case 1 -> p.getCode();
            case 2 -> p.getPrice();
            case 3 -> p.getCategory();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    public void notifyAdded() {
        int last = products.size() - 1;
        fireTableRowsInserted(last, last);
    }
    public void notifyRemoved(int index) {
        fireTableRowsDeleted(index, index);
    }
}