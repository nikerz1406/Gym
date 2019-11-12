/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Search;

import SQLjava.*;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author LH
 */
public class Search2col {
   public JComboBox<String> combo = new JComboBox<String>();
    public void Search2col(String table) throws SQLException{
        DAO conn = new DAO();
        ArrayList<ArrayList<Object>> result = new ArrayList<>();
        ArrayList<String> field = new ArrayList<String>();
        field.add("name");
        result = conn.select(field, table);
        List<String> data = new ArrayList<String>();
        
        for (ArrayList<Object> j : result) {
                    for (Object i : j) {
                        data.add((String) i);
                    }
                }
        combo.add((PopupMenu) data);
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
        
    }
    
    
}
