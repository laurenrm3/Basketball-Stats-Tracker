import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class SeasonStatisticsInterface extends JFrame 
{

	private JPanel contentPane;
	private JTable statTable;
	private JLabel statLbl;
	private JScrollPane scrollPane;
	private Team myTeam;

	/**
	 * Create the frame.
	 */
	public SeasonStatisticsInterface(Team team) 
	{
		prepareGUI();
		myTeam = team;
		fillTable();
	}

	private void prepareGUI()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		statLbl = new JLabel("Season Statistics");
		statLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		statLbl.setForeground(new Color(102, 153, 255));
		statLbl.setBounds(12, 16, 149, 14);
		contentPane.add(statLbl);

		JButton mainButton = new JButton("Main Menu");
		mainButton.setBackground(new Color(102, 153, 255));
		mainButton.setForeground(new Color(255, 255, 255));
		mainButton.setBounds(276, 12, 114, 23);
		mainButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
				MainMenu frame = new MainMenu();
				frame.setVisible(true);
			}
		});
		contentPane.add(mainButton);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 39, 378, 240);
		contentPane.add(scrollPane);

		statTable = new JTable();
		statTable.setRowSelectionAllowed(false);
		statTable.setEnabled(false);
		scrollPane.setViewportView(statTable);
		statTable.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
				},
				new String[] {
						"Statistic Type", "#"
				}
				));
	}

	private void fillTable()
	{
		ArrayList<Game> games = myTeam.getGames();
		if(games.size() > 0)
		{		
			String[][] temp = new String[games.get(0).getStats().size() + games.get(0).getPointStats().size()][2];
			statTable.setModel(new DefaultTableModel(
					temp,
					new String[] {
							"Statistic Type", "#"
					}
					));
			//looping through stats
			for(int i = 0; i < games.get(0).getStats().size() + games.get(0).getPointStats().size(); i++)
			{
				int statCount = 0;
				Stat currStat;
				int pointSize = games.get(0).getPointStats().size();
				if(i < pointSize)
					currStat = games.get(0).getPointStats().get(i);
				else
				{
					int var = i-pointSize;
					currStat = games.get(0).getStats().get(var);
				}

				String name = currStat.getName();
				statTable.setValueAt(doSpaces(name), i, 0);
				//looping through games for a specific stat
				for(int j = 0; j < myTeam.getGames().size(); j++)
				{
					Game curr = games.get(j);
					if(i < games.get(0).getPointStats().size())
						statCount += curr.getPointStats().get(i).getNum();
					else
					{
						int var = i-curr.getPointStats().size();
						System.out.println(var);
						statCount += curr.getStats().get(var).getNum();
					}

				}
				statTable.setValueAt(statCount, i, 1);
			}
		}
	}
	
	//adds spaces to stat names to be displayed in the table
	public String doSpaces(String str)
	{
		String temp = str.substring(0,1);
		for(int i = 1; i < str.length(); i++)
		{
			char curr = str.charAt(i);
			if(Character.isUpperCase(curr))
				temp += " " + curr;
			else
				temp += curr;
		}
		return temp;
	}

}
