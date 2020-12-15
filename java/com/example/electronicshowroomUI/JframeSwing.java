package com.example.electronicshowroomUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.example.pojo.Category;

public class JframeSwing {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JframeSwing window = new JframeSwing();
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
	public JframeSwing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Category");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 11, 369, 239);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		LoadData();
	}

	private void LoadData() {
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("CategoryId");
		dtm.addColumn("CategoryName");
//		dtm.addColumn("SubCategoryId");

		RestClient categoryRestClient = new RestClient();
		for (Category category : categoryRestClient.getCategory()) {
			dtm.addRow(
					new Object[] { category.getCategoryId(),
							category.getCategoryName()/* , category.getSubCategoryId() */ });
		}
		this.table.setModel(dtm);
	}
}
