import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class MainMenu extends JFrame 
{

	private JPanel contentPane;
	private JTable gameTable;
	private JButton addButton;
	private JButton removeButton;
	private JButton resetButton;
	private JButton seasonButton;
	private JLabel titleLbl;
	private JScrollPane scrollPane;
	private JLabel recordLbl;
	private JLabel teamRecordLbl;
	private Team myTeam;
	int row = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMenu() 
	{
		myTeam = new Team();
		prepareGUI();
		displayGames();
	}

	private void prepareGUI()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		titleLbl = new JLabel("Stats and Plus Minus Calculator");
		titleLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		titleLbl.setForeground(new Color(102, 153, 255));
		titleLbl.setBounds(12, 9, 250, 19);
		contentPane.add(titleLbl);

		JButton exitButton = new JButton("Save and Exit");
		exitButton.setForeground(new Color(255, 255, 255));
		exitButton.setBackground(new Color(102, 153, 255));
		exitButton.setBounds(309, 12, 125, 23);
		exitButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
			}
		});
		contentPane.add(exitButton);

		recordLbl = new JLabel("Record:");
		recordLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		recordLbl.setForeground(new Color(102, 153, 255));
		recordLbl.setBounds(100, 39, 61, 14);
		contentPane.add(recordLbl);

		if(myTeam != null)
			teamRecordLbl = new JLabel(myTeam.getRecord());
		teamRecordLbl.setBounds(165, 39, 31, 14);
		contentPane.add(teamRecordLbl);

		scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(12, 57, 289, 188);
		contentPane.add(scrollPane);

		int i = myTeam.getGames().size();
		String[][] temp = new String[i][3];

		gameTable = new JTable();
		gameTable.setBackground(new Color(255, 255, 255));
		gameTable.setForeground(new Color(0, 0, 0));
		gameTable.setFocusable(false);
		gameTable.setRowSelectionAllowed(true);
		scrollPane.setViewportView(gameTable);
		gameTable.setModel(new DefaultTableModel(
				temp,
				new String[] {
						"Date", "Opponent", "Final Score"
				}
				) {
			boolean[] columnEditables = new boolean[] {
					false, false, false
			};

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});


		gameTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		gameTable.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent event) 
			{
				if(event.getClickCount() == 1)
				{
					int tempRow = gameTable.getSelectedRow();
					if(row == -1)
					{
						row = tempRow;
						gameTable.addRowSelectionInterval(row, row);
						gameTable.setSelectionBackground(Color.BLUE);
						gameTable.setSelectionForeground(Color.white);
					}
					else if(tempRow == row)
					{
						gameTable.addRowSelectionInterval(row, row);						
						gameTable.setSelectionBackground(Color.white);
						gameTable.setSelectionForeground(Color.black);
						row = -1;
					}
					else
					{
						gameTable.addRowSelectionInterval(row, row);
						gameTable.setSelectionBackground(Color.white);
						gameTable.setSelectionForeground(Color.black);
						gameTable.clearSelection();
						gameTable.addRowSelectionInterval(tempRow, tempRow);
						gameTable.setSelectionBackground(Color.BLUE);
						gameTable.setSelectionForeground(Color.white);
						row = tempRow;
					}
				}
				else 
				{
					int row = gameTable.getSelectedRow();
					GameDisplayInterface frame = new GameDisplayInterface(myTeam, row);
					frame.setVisible(true);
					dispose();
				}
			}
		});


		addButton = new JButton("Add");
		addButton.setForeground(new Color(255, 255, 255));
		addButton.setBackground(new Color(102, 153, 255));
		addButton.setBounds(309, 61, 99, 23);
		addButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
				AddGameInterface frame = new AddGameInterface();
				frame.setVisible(true);
			}
		});
		contentPane.add(addButton);

		removeButton = new JButton("Remove");
		removeButton.setForeground(new Color(255, 255, 255));
		removeButton.setBackground(new Color(102, 153, 255));
		removeButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				remove();
				teamRecordLbl.setText(myTeam.getRecord());
				displayGames();
			}
		});
		removeButton.setBounds(309, 92, 99, 23);
		contentPane.add(removeButton);

		resetButton = new JButton("Reset");
		resetButton.setForeground(new Color(255, 255, 255));
		resetButton.setBackground(new Color(102, 153, 255));
		resetButton.setBounds(309, 123, 99, 23);
		resetButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to reset?", "Reset Confirmation", JOptionPane.YES_NO_OPTION);
				if(result == 0)
				{
					reset();
					teamRecordLbl.setText(myTeam.getRecord());
				}

			}
		});
		contentPane.add(resetButton);

		seasonButton = new JButton("Season Statistics");
		seasonButton.setForeground(new Color(255, 255, 255));
		seasonButton.setBackground(new Color(102, 153, 255));
		seasonButton.setBounds(309, 154, 140, 23);
		seasonButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				SeasonStatisticsInterface frame = new SeasonStatisticsInterface(myTeam);
				frame.setVisible(true);
				dispose();
			}
		});
		contentPane.add(seasonButton);
	}

	//fills the game table with games
	public void displayGames()
	{
		ArrayList<Game> games = myTeam.getGames();
		for(int i = 0; i < games.size(); i++)
		{
			Game curr = games.get(i);
			gameTable.setValueAt((String)curr.getDate().getDate(), i, 0);
			gameTable.setValueAt(curr.getOpp(), i, 1);
			gameTable.setValueAt(curr.getScore().getScore(), i, 2);
		}
	}
	
	//removes games from the table then resets the team
	public void reset()
	{
		ArrayList<Game> games = myTeam.getGames();
		int total = games.size();
		while(total != 0)
		{
			((DefaultTableModel)gameTable.getModel()).removeRow(total-1);
			games.remove(total-1);
			total = games.size();
		}
		myTeam.resetAll();
	}
	
	//checks to make sure a row is selected then removes the game, updates the record, and saves
	private void remove()
	{
		if(row != -1)
		{
			((DefaultTableModel)gameTable.getModel()).removeRow(row);
			Game temp = myTeam.getGames().remove(row);
			myTeam.updateRecord(temp.win);
			row = -1;
			myTeam.save();
		}
		else
			JOptionPane.showMessageDialog(null, "Please select a game to remove");
	}
}
