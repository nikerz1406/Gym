package Search;

import SQLjava.DAO;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * A Swing program that demonstrates how to create and use JComboBox component.
 * 
 * @author www.codejava.net
 * 
 */
public class Search extends JFrame {

	private JButton buttonSelect = new JButton("Select");
	private JButton buttonRemove = new JButton("Remove");
        final JComboBox<String> combo;

	public Search() throws SQLException {
		super("Swing JComboBox Demo");

        DAO conn = new DAO();
        ArrayList<ArrayList<Object>> result = new ArrayList<>();
        ArrayList<String> field = new ArrayList<String>();
        field.add("name");
        result = conn.select(field, "customers");

        
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		String[] bookTitles = new String[] { "Search customer"};

		// create a combo box with items specified in the String array:
		combo = new JComboBox<String>(bookTitles);

		// add more books

                   for (ArrayList<Object> j : result) {
                    for (Object i : j) {
                        combo.addItem((String)i);
                    }
                }

		// customize some appearance:
		combo.setForeground(Color.BLUE);
		combo.setFont(new Font("Arial", Font.BOLD, 14));
		combo.setMaximumRowCount(10);
		
		// make the combo box editable so we can add new item when needed
		combo.setEditable(true);

		// add an event listener for the combo box
		combo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				JComboBox<String> combo = (JComboBox<String>) event.getSource();
				String selectedBook = (String) combo.getSelectedItem();

				DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) combo
						.getModel();

				int selectedIndex = model.getIndexOf(selectedBook);
				if (selectedIndex < 0) {
					// if the selected book does not exist before, 
					// add it into this combo box
					model.addElement(selectedBook);
				}

			}
		});
                
		// add event listener for the button Select 
		buttonSelect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				String selectedBook = (String) combo.getSelectedItem();
				JOptionPane.showMessageDialog(Search.this,
						"You selected the book: " + selectedBook);
			}
		});

		// add event listener for the button Remove
		buttonRemove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				String selectedBook = (String) combo.getSelectedItem();
				combo.removeItem(selectedBook);
			}
		});

		// add components to this frame
		add(combo);
		add(buttonSelect);
		add(buttonRemove);

		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
        private void jComboKeyPressed(java.awt.event.KeyEvent evt) {                                      
            System.out.println("press");
        } 
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
                            try {
                                new Search().setVisible(true);
                            } catch (SQLException ex) {
                                Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}
		});
	}
}