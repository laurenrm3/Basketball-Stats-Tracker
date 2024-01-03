import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;

public class GameDisplayInterface extends JFrame {

	private JPanel contentPane;
	private JTable scoreTable;
	private JTable statTable;
	private JLabel dateLbl;
	private JLabel vsLbl;
	private JLabel totalLbl;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JLabel totalValLbl;
	private JLabel oppLabel;
	private JLabel fullDateLbl;
	private Game myGame;
	private Score myScore;

	private Team myTeam;
	private int index;


	/**
	 * Create the frame.
	 */
	public GameDisplayInterface(Team team, Game game) 
	{
		myGame = game;
		myTeam = team;
		myScore = game.getScore();
		prepareGUI();
	}

	/**
	 * @wbp.parser.constructor
	 */
	public GameDisplayInterface(Team team, int currIndex) 
	{
		myTeam = team;
		index = currIndex;
		myGame = team.getGames().get(index);
		myScore = myGame.getScore();
		prepareGUI();
	}

	private void prepareGUI()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 507);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[25px][88px][27px][5px][80px][5px][55px][6px][83px]", "[23px][14px][62px][14px][266.00px][23px]"));

		vsLbl = new JLabel("Vs. ");
		vsLbl.setForeground(new Color(102, 153, 255));
		contentPane.add(vsLbl, "cell 2 0,alignx right,aligny center");

		oppLabel = new JLabel(myGame.getOpp());
		contentPane.add(oppLabel, "cell 4 0, alignx left, aligny center");

		JButton mainButton = new JButton("Main Menu");
		mainButton.setForeground(new Color(255, 255, 255));
		mainButton.setBackground(new Color(102, 153, 255));
		mainButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{				
				MainMenu frame = new MainMenu();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		contentPane.add(mainButton, "cell 8 0,alignx left,aligny top");

		dateLbl = new JLabel("Date:");
		dateLbl.setForeground(new Color(102, 153, 255));
		contentPane.add(dateLbl, "cell 2 1,alignx right,aligny center");

		fullDateLbl = new JLabel(myGame.getDate().getDate());
		contentPane.add(fullDateLbl, "cell 4 1,alignx left,aligny center");

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		contentPane.add(scrollPane_1, "cell 0 2 9 1,grow");

		scoreTable = new JTable();
		scoreTable.setRowSelectionAllowed(false);
		scoreTable.setEnabled(false);
		scoreTable.setRowHeight(19);
		scrollPane_1.setViewportView(scoreTable);
		scoreTable.setModel(new DefaultTableModel(
				new Object[][] {
					{"You", myScore.getMyQ1(), myScore.getMyQ2(), myScore.getMyQ3(), myScore.getMyQ4(), myScore.getMyTotal()},
					{"Opp", myScore.getOppQ1(), myScore.getOppQ2(), myScore.getOppQ3(), myScore.getOppQ4(), myScore.getOppTotal()},
				},
				new String[] {
						"", "1st", "2nd", "3rd", "4th", "Final"
				}
				));

		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 4 9 1,grow");

		statTable = new JTable();
		statTable.setRowSelectionAllowed(false);
		statTable.setEnabled(false);
		scrollPane.setViewportView(statTable);
		statTable.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
				},
				new String[] {
						"Statistic Type", "#", "Value"
				}
				));
		ArrayList<Stat> points = myGame.getPointStats();
		ArrayList<Stat> stats = myGame.getStats();

		for(int i = 0; i < points.size(); i++)
		{
			statTable.setValueAt(doSpaces(points.get(i).getName()), i, 0);
			statTable.setValueAt(points.get(i).getNum(), i, 1);
			statTable.setValueAt(points.get(i).getValue(), i, 2);
		}
		int j = 0;
		for(int k = points.size(); k < stats.size() + points.size(); k++)
		{
			statTable.setValueAt(doSpaces(stats.get(j).getName()), k, 0);
			statTable.setValueAt(stats.get(j).getNum(), k, 1);
			statTable.setValueAt(stats.get(j).getValue(), k, 2);

			j++;
		}

		totalLbl = new JLabel("Plus Minus Total:");
		totalLbl.setForeground(new Color(102, 153, 255));
		contentPane.add(totalLbl, "cell 4 5,alignx left,aligny center");

		totalValLbl = new JLabel(myGame.getTotal());
		contentPane.add(totalValLbl, "cell 6 5,alignx center,aligny center");

		JButton editButton = new JButton("Edit");
		editButton.setBackground(new Color(102, 153, 255));
		editButton.setForeground(new Color(255, 255, 255));
		editButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				EditGameInterface frame = new EditGameInterface(myGame, myTeam);
				frame.setVisible(true);
				dispose();
			}
		});
		contentPane.add(editButton, "cell 8 5,alignx left,aligny top");
	}
	
	//adds spaces to stat names to be displayed in the table
	private String doSpaces(String str)
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
