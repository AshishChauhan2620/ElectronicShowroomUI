package com.example.electronicshowroomUI;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.example.pojo.Category;
import com.example.pojo.SubCategory;

public class JframeCategory extends JFrame implements ItemListener {

	private static final long serialVersionUID = 18347958347593L;
	private JFrame frame;
	private JTable table;
	RestClient client = new RestClient();
	JComboBox comboBoxforCategoryId;
	JLabel l1, l2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JframeCategory window = new JframeCategory();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JframeCategory() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {

		// Window page to add Category
		frame = new JFrame("Category");
		frame.setBounds(100, 100, 753, 394);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 11, 673, 229);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnAddCategory = new JButton("Add Category");
		final JTextField tf = new JTextField();
		JTextField textvalueCategory = new JTextField();
		tf.setBounds(50, 50, 150, 20);
		btnAddCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = new JFrame("Add Category");// creating instance of JFrame
				JButton b = new JButton("Submit");// creating instance of JButton

				JLabel l2 = new JLabel("Category Name: ");
				l2.setBounds(30, 90, 100, 30);

				textvalueCategory.setBounds(130, 90, 100, 30);
				f.getContentPane().add(textvalueCategory);
				f.getContentPane().add(l2);
				b.setBounds(130, 140, 100, 30);// x axis, y axis, width, height
				f.getContentPane().add(b);
				f.setSize(400, 500);
				f.getContentPane().setLayout(null);// using no layout managers
				f.setVisible(true);
				b.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Category category = new Category();
						category.setCategoryName(textvalueCategory.getText());
						client.addcategory(category);
					}
				});

			}

		});
//Add Sub Category Window

		JFrame f = new JFrame("Sub Category");// creating instance of JFrame
		JButton b = new JButton("Submit");// creating instance of JButton

		btnAddCategory.setBounds(31, 265, 140, 27);
		frame.getContentPane().add(btnAddCategory);
		btnAddSubCategory = new JButton("Add Sub-Category");
		btnAddSubCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				l1 = new JLabel("Category ID: ");
				l1.setBounds(30, 50, 120, 30);
				l2 = new JLabel("Sub-Category Name: ");
				l2.setBounds(30, 90, 120, 30);
				JTextField textvalueSubCategory;
				f.setLayout(new FlowLayout());
				List<Category> category = client.getCategory();
//				List<Category> category2 =  new ArrayList<Category>();
//				for (Category category3 : client.getCategory()) {
//					((Category) category3).getCategoryName();
//				}

				comboBoxforCategoryId = new JComboBox();
				comboBoxforCategoryId.addItem(category.size());
				textvalueSubCategory = new JTextField("Sub-Category Name");
				textvalueSubCategory.setBounds(150, 90, 120, 30);
				comboBoxforCategoryId.setBounds(150, 50, 60, 30);
				f.add(comboBoxforCategoryId);
				f.add(comboBoxforCategoryId);
				f.add(textvalueSubCategory);
				f.add(l1);
				f.add(l2);
				b.setBounds(130, 140, 100, 30);// x axis, y axis, width, height

				f.add(b);// adding button in JFrame

				f.setSize(400, 500);// 400 width and 500 height
				f.setLayout(null);// using no layout managers
				f.setVisible(true);// making the frame visible
				b.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						SubCategory subCategory = new SubCategory();
						subCategory.setSubCategoryName((textvalueCategory.getText()));
						client.addSubCategory(subCategory);
					}
				});

			}

		});
		btnAddSubCategory.setBounds(235, 267, 140, 27);
		frame.getContentPane().add(btnAddSubCategory);
		LoadData();
	}

	private void LoadData() {
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("CategoryId");
		dtm.addColumn("CategoryName");
		for (Category category : client.getCategory()) {
			dtm.addRow(new Object[] { category.getCategoryId(), category.getCategoryName() });
		}
		this.table.setModel(dtm);
	}

	private JButton btnAddSubCategory;

	@Override
	public void itemStateChanged(ItemEvent e) {
		// if the state combobox is changed
		if (e.getSource() == comboBoxforCategoryId) {

			l1.setText(comboBoxforCategoryId.getSelectedItem() + " selected");
		}
	}

}
