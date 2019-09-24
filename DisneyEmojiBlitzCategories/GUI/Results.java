package GUI;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

/**
 * 
 * @author MikeBednarski
 * This gives the results based on the SQL database
 */

public class Results extends JPanel implements ActionListener{
	

	private static final long serialVersionUID = 1L;
	private JList<String> list;
    private DefaultListModel<String> listModel;
    private JButton quitButton;
    private ArrayList<String> cats;
    Connection conn = null;
    JFrame frame;
	ArrayList<String> boxes;

    
    public Results() {
        frame = new JFrame("Results");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);        
    }
    
    public void setUp(ArrayList<String> categoriesToSearch) {
		boxes = new ArrayList<String>(Arrays.asList("Silver", "Gold", "Rainbow", "Series", "Villain"));
        cats = categoriesToSearch;
        listModel = new DefaultListModel<String>();
        
        getResults();
        
        if (listModel.isEmpty()) listModel.addElement("No Emojis");
        
        list = new JList<String>(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(list);
        
        quitButton = new JButton("Quit");
        quitButton.addActionListener(this);
        
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane,
                BoxLayout.LINE_AXIS));
        buttonPane.add(quitButton);
        
        frame.add(listScrollPane, BorderLayout.CENTER);
        frame.add(buttonPane, BorderLayout.PAGE_END);
    }
    
    void getResults() {
    	connect();
    	if (cats.size() == 1) oneCategory(cats.get(0));
		else if (cats.size() == 2) twoCategories(cats.get(0), cats.get(1));
		else threeCategories(cats.get(0), cats.get(1), cats.get(2));

    }
    
	private Connection connect() {
		String url = "jdbc:sqlite::resource:CategoryHelper/DisneyEB.db";
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
    
	void oneCategory(String cat) {
		if (boxes.contains(cat)) {
			selectFromBox(cat);
			return;
		}
		String sql = "SELECT Emoji FROM Categories WHERE " + cat + " = 'Yes'";
		categoryExecution(sql);

	}

	void twoCategories(String cat1, String cat2) {
		if (boxes.contains(cat2)) {
			selectFromBoxAndOne(cat2, cat1);
			return;
		}
		String sql = "SELECT Emoji FROM Categories WHERE " + cat1 + " = 'Yes' AND " + cat2 + " = 'Yes'";
		categoryExecution(sql);

	}

	void threeCategories(String cat1, String cat2, String cat3) {
		if (boxes.contains(cat3)) {
			selectFromBoxAndTwo(cat3, cat1, cat2);
			return;
		}
		String sql = "SELECT Emoji FROM Categories WHERE " + cat1 + " = 'Yes' AND " + cat2 + " = 'Yes' AND " + cat3
				+ " = 'Yes'";
		categoryExecution(sql);

	}

	private void selectFromBox(String box) {
		String sql = "SELECT Emoji FROM Categories WHERE Box = ?";
		boxExecution(box, sql);
	}

	private void selectFromBoxAndOne(String box, String cat1) {
		String sql = "SELECT Emoji FROM Categories WHERE Box = ? AND " + cat1 + " = 'Yes'";
		boxExecution(box, sql);
	}

	private void selectFromBoxAndTwo(String box, String cat1, String cat2) {
		String sql = "SELECT Emoji FROM Categories WHERE Box = ? AND " + cat1 + " = 'Yes' AND " + cat2 + " = 'Yes'";
		boxExecution(box, sql);

	}

	private void boxExecution(String box, String sql) {
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, box);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) listModel.addElement(rs.getString("Emoji"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void categoryExecution(String sql) {
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) listModel.addElement(rs.getString("Emoji"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		try {
			conn.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		frame.dispose();
	}
 

}
