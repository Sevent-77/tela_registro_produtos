package UI;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListCellRenderer;

import model.Product;
import model.ProductTableModel;
import service.ProductService;

import javax.swing.border.LineBorder;
import javax.swing.JComboBox;

public class RegisterScreen extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textName;
	private JTextField textCode;
	private JTextField textPrice;
	private JTable table;
	private ProductTableModel tableModel;
	private ArrayList products;
	private ProductService service;
	

	
	public RegisterScreen() {
		this.service = new ProductService();
		this.tableModel = new ProductTableModel((ArrayList<Product>) service.getProducts(), service.getColumns());
		//test
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 658);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(251, 253, 251));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon image = new ImageIcon(RegisterScreen.class.getResource("/img/img.png"));
		Image imageScaled = image.getImage();
		Image novaImg = imageScaled.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
		lblNewLabel.setIcon(new ImageIcon(novaImg));
		lblNewLabel.setBounds(99, 0, 123, 107);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cadastro de Produtos");
		lblNewLabel_1.setLabelFor(this);
		lblNewLabel_1.setBackground(new Color(245, 247, 250));
		lblNewLabel_1.setForeground(new Color(19, 107, 14));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 35));
		lblNewLabel_1.setBounds(220, 34, 377, 45);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(246, 249, 245));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(251, 253, 251));
		panel.setBounds(23, 111, 690, 170);
		contentPane.add(panel);
		panel.setBorder(new RoundedBorder(30));

		panel.setLayout(null);
		
		PlaceholderTextField textName = new PlaceholderTextField("Digite o nome do produto");
		textName.setBackground(new Color(251, 253, 251));
		textName.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		textName.setBounds(115, 37, 255, 29);
		panel.add(textName);
		textName.setBorder(new RoundedBorder(12));
		textName.setColumns(10);
		
		
		PlaceholderTextField textCode = new PlaceholderTextField("Digite o código do produto");
		textCode.setBackground(new Color(251, 253, 251));
		textCode.setBounds(115, 76, 255, 29);
		panel.add(textCode);
		textCode.setBorder(new RoundedBorder(12));
		textCode.setColumns(10);
		
		PlaceholderTextField textPrice = new PlaceholderTextField("Digite o preço do produto (ex: 12.50) ");
		textPrice.setBackground(new Color(251, 253, 251));
		textPrice.setBounds(115, 115, 255, 29);
		panel.add(textPrice);
		textPrice.setBorder(new RoundedBorder(12));
		textPrice.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nome do produto:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setBackground(new Color(240, 240, 240));
		lblNewLabel_2.setBounds(10, 43, 93, 17);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Código:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setBounds(10, 82, 60, 17);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Preço (R$):");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setBounds(10, 121, 60, 17);
		panel.add(lblNewLabel_4);
		
		String[] categorias = {
			    "Selecione...",
			    "Alimentício",
			    "Limpeza",
			    "Higiene",
			    "Bebidas",
			    "Hortifruti",
			    "Padaria",
			    "Açougue",
			    "Congelados",
			    "Eletrônicos",
			    "Papelaria",
			    "Vestuário",
			    "Outros"
			};
		
		JComboBox<String> CBCategory = new JComboBox<>(categorias);
		CBCategory.setUI(new ModernComboBoxUI());
		CBCategory.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		CBCategory.setBackground(Color.WHITE);
		CBCategory.setForeground(new Color(50, 50, 50));
		CBCategory.setFocusable(false);
		CBCategory.setBorder( new RoundedBorder(12));
		CBCategory.setBounds(422,43,255,35);
		CBCategory.setRenderer(new DefaultListCellRenderer() {

		    @Override
		    public Component getListCellRendererComponent(JList<?> list,Object value,int index,boolean isSelected,boolean cellHasFocus) {
		        JLabel label = (JLabel)
		                super.getListCellRendererComponent(list,value,index,isSelected,cellHasFocus);
		        label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		        label.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));

		        if (isSelected) {
		            label.setBackground(new Color(76, 175, 80));
		            label.setForeground(Color.WHITE);
		        } else {
		            label.setBackground(Color.WHITE);
		            label.setForeground(new Color(40, 40, 40));
		        }

		        return label;
		    }
		});
		panel.add(CBCategory);
		
		JLabel lblNewLabel_5 = new JLabel("Categoria:");
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_5.setBounds(422, 27, 60, 17);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Dados do Produto:");
		ImageIcon imagetag = new ImageIcon(RegisterScreen.class.getResource("/img/tag.png"));
		Image IMGtag = imagetag.getImage();
		Image NIMGtag = IMGtag.getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH);
		lblNewLabel_6.setIcon(new ImageIcon(NIMGtag));
		lblNewLabel_6.setForeground(new Color(31, 123, 25));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setBounds(10, 10, 199, 23);
		panel.add(lblNewLabel_6);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(new Color(251, 253, 251));
		panel_1.setForeground(new Color(251, 253, 251));
		panel_1.setBounds(23, 292, 690, 98);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBorder(new RoundedBorder(30));
		
		JLabel lblNewLabel_7 = new JLabel("Ações:");
		ImageIcon imagegear = new ImageIcon(RegisterScreen.class.getResource("/img/gear.png"));
		Image IMGgear = imagegear.getImage();
		Image NIMGgear = IMGgear.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
		lblNewLabel_7.setIcon(new ImageIcon(NIMGgear));
		lblNewLabel_7.setForeground(new Color(31, 123, 25));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7.setBounds(10, 10, 199, 23);
		panel_1.add(lblNewLabel_7);
		
		RoundedButton btnSave = new RoundedButton("  Salvar", 12);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSave.setBackground(new Color(76, 175, 80));
		btnSave.setForeground(new Color(255, 255, 255));
		ImageIcon imagesave = new ImageIcon(RegisterScreen.class.getResource("/img/save.png"));
		Image NIMSave = imagesave.getImage().getScaledInstance(20, 20,Image.SCALE_SMOOTH);
		btnSave.setIcon(new ImageIcon(NIMSave));
		btnSave.setBounds(20, 43, 125, 35);
		btnSave.addActionListener(e -> {
			if(CBCategory.getSelectedIndex() == 0) {
				JOptionPane.showMessageDialog(RegisterScreen.this, "Escolha uma categoria.", "Alerta", JOptionPane.WARNING_MESSAGE);
				return;
			}
			String name = textName.getText().toString();
			String code = textCode.getText().toString();
			double price;
			try {
				price = Double.parseDouble(textPrice.getText());}
			catch(Exception exception) {
				JOptionPane.showMessageDialog(RegisterScreen.this,"Preencha todos os campos", "Alerta", JOptionPane.WARNING_MESSAGE);
				return;
			}
			String category = CBCategory.getSelectedItem().toString();
			if(name.isBlank() || code.isBlank()) {
				JOptionPane.showMessageDialog(RegisterScreen.this,"Preencha todos os campos", "Alerta", JOptionPane.WARNING_MESSAGE);
				return;
			}
		    Product p = new Product(name,code,price,category);
		    if(!service.addProduct(p)) {
				JOptionPane.showMessageDialog(RegisterScreen.this,"Código repetido!", "Erro", JOptionPane.ERROR_MESSAGE);
		    } else {
				JOptionPane.showMessageDialog(RegisterScreen.this,"Inserido com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
				textName.setText("");
				textCode.setText("");
				textPrice.setText("");
				CBCategory.setSelectedIndex(0);
		    }
		    tableModel.notifyAdded();
		});		
		panel_1.add(btnSave);		
		
		RoundedButton btnDelete = new RoundedButton("  Excluir", 12);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelete.setBackground(new Color(203, 36, 40));
		ImageIcon imagebin = new ImageIcon(RegisterScreen.class.getResource("/img/bin.png"));
		Image NIMbin = imagebin.getImage().getScaledInstance(20, 20,Image.SCALE_SMOOTH);
		btnDelete.setIcon(new ImageIcon(NIMbin));
		btnDelete.setBounds(155, 43, 125, 35);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int index = table.getSelectedRow();
					String text = service.getProductDescription(index);
					if(text.isBlank()) {
						return;
					}
					StringBuilder message = new StringBuilder();
					message.append("Tem certeza que deseja escluir esse produto? ").append(text);
					int option = JOptionPane.showConfirmDialog(RegisterScreen.this, message.toString(), "Excluir", JOptionPane.YES_NO_OPTION);
					if(option == JOptionPane.YES_OPTION) {
						service.removeProduct(index);
						tableModel.notifyRemoved(index);
					}}
				catch(IndexOutOfBoundsException exception){
					JOptionPane.showMessageDialog(RegisterScreen.this,"Escolha um produto para excluir!", "Erro", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});	
		panel_1.add(btnDelete);
		
		RoundedButton btnSearch = new RoundedButton("  Buscar", 12);
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSearch.setBackground(new Color(10, 110, 221));
		ImageIcon imageSearch = new ImageIcon(RegisterScreen.class.getResource("/img/search.png"));
		Image NIMsearch = imageSearch.getImage().getScaledInstance(25, 25,Image.SCALE_SMOOTH		    );
		btnSearch.setIcon(new ImageIcon(NIMsearch));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				System.out.println(index);
			}
		});
		btnSearch.setBounds(320, 43, 114, 35);
		panel_1.add(btnSearch);
		
		PlaceholderTextField textSearch = new PlaceholderTextField("Digite o nome do produto paera buscar... ");
		textSearch.setColumns(10);
		textSearch.setBorder(new RoundedBorder(12));
		textSearch.setBackground(new Color(251, 253, 251));
		textSearch.setBounds(444, 47, 236, 29);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchName = textSearch.getText().toString();
				if(!searchName.isBlank()) {
					int index = service.searchProduct(searchName);
					table.setRowSelectionInterval(index, index);
				}
			}
		});

		panel_1.add(textSearch);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(192, 192, 192));
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBorder(null);
		panel_2.setBounds(295, 43, 1, 35);
		panel_2.setFocusable(false);
		panel_1.add(panel_2);

		
		this.tableModel = new ProductTableModel((ArrayList<Product>) service.getProducts(),service.getColumns());
		this.table = new JTable(tableModel);
		ModernTable.style(table);
		JScrollPane scrollPane = ModernTable.wrap(table);
		scrollPane.setBounds(20, 400, 690, 200);
		contentPane.add(scrollPane);
		
	}
	
}
