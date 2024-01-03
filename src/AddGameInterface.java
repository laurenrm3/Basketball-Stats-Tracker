import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class AddGameInterface extends JFrame {

	private JPanel contentPane;
	private JTable scoreTable;
	private JTable statTable;
	private JButton saveButton;
	private JButton cancelButton;
	private JLabel monthLbl;
	private JLabel dayLbl;
	private JSpinner monthSpin;
	private JSpinner daySpin;
	private JLabel yearLbl;
	private JTextField yearField;
	private JSpinner assistNum;
	private JSpinner blockNum;
	private JSpinner chargeNum;
	private JSpinner dRebNum;
	private JSpinner foulNum;
	private JSpinner oppORebNum;
	private JSpinner oRebNum;
	private JSpinner thPMissNum;
	private JSpinner tPMissNum;
	private JSpinner stealNum;
	private JSpinner thPMakeNum;
	private JSpinner tPMissVal;
	private JSpinner thPMakeVal;
	private JSpinner ftMakeVal;
	private JSpinner thPMissVal;
	private JSpinner ftMissVal;
	private JSpinner ftMakeNum;
	private JSpinner ftMissNum;
	private JSpinner assistVal;
	private JSpinner blockVal;
	private JSpinner chargeVal;
	private JSpinner dRebVal;
	private JSpinner foulVal;
	private JSpinner oRebVal;
	private JSpinner oppORebVal;
	private JSpinner tPMakeNum;
	private JSpinner stealVal;
	private JSpinner tPMakeVal;
	private JScrollPane scrollPaneScore;
	private JScrollPane scrollPaneStats;
	private JLabel vsLbl;
	private JLabel numLbl;
	private JLabel valueLbl;
	private JSpinner toNum;
	private JSpinner toVal;
	private JTextField oppField;
	private Game myGame;
	private Team myTeam;
	private JLabel youLbl;
	private JLabel oppLbl;



	/**
	 * Create the frame.
	 */
	public AddGameInterface() {
		prepareGUI();
		save();
		cancel();
		myTeam = new Team();
		//myGame = game;
	}

	public AddGameInterface(Game game) {
		prepareGUI();
		cancelEdit();
		myTeam = new Team();
		myGame = game;
		setGUI();
	}

	private void prepareGUI()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 637);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 89, 60, 0, 23, 30, 65, 36, 7, 0};
		gbl_contentPane.rowHeights = new int[]{31, 28, 28, 28, 14, 21, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 20, 20, 23, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		vsLbl = new JLabel("Vs.");
		vsLbl.setForeground(new Color(102, 153, 255));
		GridBagConstraints gbc_vsLbl = new GridBagConstraints();
		gbc_vsLbl.insets = new Insets(0, 0, 5, 5);
		gbc_vsLbl.anchor = GridBagConstraints.EAST;
		gbc_vsLbl.gridx = 3;
		gbc_vsLbl.gridy = 0;
		contentPane.add(vsLbl, gbc_vsLbl);

		oppField = new JTextField();
		GridBagConstraints gbc_oppField = new GridBagConstraints();
		gbc_oppField.insets = new Insets(0, 0, 5, 5);
		gbc_oppField.fill = GridBagConstraints.HORIZONTAL;
		gbc_oppField.gridx = 4;
		gbc_oppField.gridy = 0;
		contentPane.add(oppField, gbc_oppField);
		oppField.setColumns(10);

		monthLbl = new JLabel("Month #:");
		monthLbl.setForeground(new Color(102, 153, 255));
		GridBagConstraints gbc_monthLbl = new GridBagConstraints();
		gbc_monthLbl.anchor = GridBagConstraints.EAST;
		gbc_monthLbl.insets = new Insets(0, 0, 5, 5);
		gbc_monthLbl.gridx = 1;
		gbc_monthLbl.gridy = 1;
		contentPane.add(monthLbl, gbc_monthLbl);

		monthSpin = new JSpinner();
		monthSpin.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		GridBagConstraints gbc_monthSpin = new GridBagConstraints();
		gbc_monthSpin.anchor = GridBagConstraints.NORTHWEST;
		gbc_monthSpin.insets = new Insets(0, 0, 5, 5);
		gbc_monthSpin.gridx = 2;
		gbc_monthSpin.gridy = 1;
		contentPane.add(monthSpin, gbc_monthSpin);

		scrollPaneScore = new JScrollPane();
		GridBagConstraints gbc_scrollPaneScore = new GridBagConstraints();
		gbc_scrollPaneScore.gridwidth = 3;
		gbc_scrollPaneScore.gridheight = 3;
		gbc_scrollPaneScore.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneScore.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneScore.gridx = 5;
		gbc_scrollPaneScore.gridy = 1;
		contentPane.add(scrollPaneScore, gbc_scrollPaneScore);

		scoreTable = new JTable();
		scoreTable.setFillsViewportHeight(true);
		scoreTable.setRowSelectionAllowed(false);
		scrollPaneScore.setViewportView(scoreTable);
		scoreTable.setModel(new DefaultTableModel(
				new Integer[][] {
					{0,0,0,0},
					{0,0,0,0},
				},
				new String[] {
						"1st", "2nd", "3rd", "4th"
				}
				));
		scoreTable.setRowHeight(26);

		dayLbl = new JLabel("Day:");
		dayLbl.setForeground(new Color(102, 153, 255));
		GridBagConstraints gbc_dayLbl = new GridBagConstraints();
		gbc_dayLbl.anchor = GridBagConstraints.EAST;
		gbc_dayLbl.insets = new Insets(0, 0, 5, 5);
		gbc_dayLbl.gridx = 1;
		gbc_dayLbl.gridy = 2;
		contentPane.add(dayLbl, gbc_dayLbl);

		daySpin = new JSpinner();
		daySpin.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		GridBagConstraints gbc_daySpin = new GridBagConstraints();
		gbc_daySpin.anchor = GridBagConstraints.NORTHWEST;
		gbc_daySpin.insets = new Insets(0, 0, 5, 5);
		gbc_daySpin.gridx = 2;
		gbc_daySpin.gridy = 2;
		contentPane.add(daySpin, gbc_daySpin);

		youLbl = new JLabel("You");
		youLbl.setForeground(new Color(102, 153, 255));
		GridBagConstraints gbc_youLbl = new GridBagConstraints();
		gbc_youLbl.anchor = GridBagConstraints.EAST;
		gbc_youLbl.insets = new Insets(0, 0, 5, 5);
		gbc_youLbl.gridx = 4;
		gbc_youLbl.gridy = 2;
		contentPane.add(youLbl, gbc_youLbl);

		yearLbl = new JLabel("Year:");
		yearLbl.setForeground(new Color(102, 153, 255));
		GridBagConstraints gbc_yearLbl = new GridBagConstraints();
		gbc_yearLbl.anchor = GridBagConstraints.EAST;
		gbc_yearLbl.insets = new Insets(0, 0, 5, 5);
		gbc_yearLbl.gridx = 1;
		gbc_yearLbl.gridy = 3;
		contentPane.add(yearLbl, gbc_yearLbl);

		yearField = new JTextField();
		GridBagConstraints gbc_yearField = new GridBagConstraints();
		gbc_yearField.anchor = GridBagConstraints.NORTH;
		gbc_yearField.fill = GridBagConstraints.HORIZONTAL;
		gbc_yearField.insets = new Insets(0, 0, 5, 5);
		gbc_yearField.gridx = 2;
		gbc_yearField.gridy = 3;
		contentPane.add(yearField, gbc_yearField);
		yearField.setColumns(10);

		oppLbl = new JLabel("Opp");
		oppLbl.setForeground(new Color(102, 153, 255));
		GridBagConstraints gbc_oppLbl = new GridBagConstraints();
		gbc_oppLbl.anchor = GridBagConstraints.EAST;
		gbc_oppLbl.insets = new Insets(0, 0, 5, 5);
		gbc_oppLbl.gridx = 4;
		gbc_oppLbl.gridy = 3;
		contentPane.add(oppLbl, gbc_oppLbl);

		scrollPaneStats = new JScrollPane();
		scrollPaneStats.setAlignmentY(Component.TOP_ALIGNMENT);
		scrollPaneStats.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPaneStats = new GridBagConstraints();
		gbc_scrollPaneStats.gridwidth = 4;
		gbc_scrollPaneStats.gridheight = 16;
		gbc_scrollPaneStats.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneStats.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneStats.gridx = 1;
		gbc_scrollPaneStats.gridy = 5;
		contentPane.add(scrollPaneStats, gbc_scrollPaneStats);

		statTable = new JTable();
		statTable.setFillsViewportHeight(true);
		statTable.setEnabled(false);
		statTable.setRowSelectionAllowed(false);
		scrollPaneStats.setViewportView(statTable);
		statTable.setModel(new DefaultTableModel(
				new Object[][] {
					{"Two P Makes"},
					{"Two P Misses"},
					{"Three P Makes"},
					{"Three P Misses"},
					{"Ft Makes"},
					{"Ft Misses"},
					{"Assists"},
					{"Blocks"},
					{"Charges"},
					{"D Reb"},
					{"Fouls"},
					{"O Reb"},
					{"Opp O Reb"},
					{"Steals"},
					{"Turnovers"},
				},
				new String[] {
						"Statistic Type"
				}
				));
		statTable.getColumnModel().getColumn(0).setResizable(false);
		statTable.setRowHeight(25);

		numLbl = new JLabel("#");
		GridBagConstraints gbc_numLbl = new GridBagConstraints();
		gbc_numLbl.insets = new Insets(0, 0, 5, 5);
		gbc_numLbl.gridx = 5;
		gbc_numLbl.gridy = 5;
		contentPane.add(numLbl, gbc_numLbl);

		valueLbl = new JLabel("Value");
		GridBagConstraints gbc_valueLbl = new GridBagConstraints();
		gbc_valueLbl.insets = new Insets(0, 0, 5, 5);
		gbc_valueLbl.gridx = 6;
		gbc_valueLbl.gridy = 5;
		contentPane.add(valueLbl, gbc_valueLbl);

		tPMakeNum = new JSpinner();
		tPMakeNum.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		GridBagConstraints gbc_tPMakeNum = new GridBagConstraints();
		gbc_tPMakeNum.anchor = GridBagConstraints.NORTH;
		gbc_tPMakeNum.insets = new Insets(0, 0, 5, 5);
		gbc_tPMakeNum.gridx = 5;
		gbc_tPMakeNum.gridy = 6;
		contentPane.add(tPMakeNum, gbc_tPMakeNum);

		tPMakeVal = new JSpinner();
		GridBagConstraints gbc_tPMakeVal = new GridBagConstraints();
		gbc_tPMakeVal.anchor = GridBagConstraints.NORTH;
		gbc_tPMakeVal.insets = new Insets(0, 0, 5, 5);
		gbc_tPMakeVal.gridx = 6;
		gbc_tPMakeVal.gridy = 6;
		contentPane.add(tPMakeVal, gbc_tPMakeVal);

		tPMissNum = new JSpinner();
		tPMissNum.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		GridBagConstraints gbc_tPMissNum = new GridBagConstraints();
		gbc_tPMissNum.anchor = GridBagConstraints.NORTH;
		gbc_tPMissNum.insets = new Insets(0, 0, 5, 5);
		gbc_tPMissNum.gridx = 5;
		gbc_tPMissNum.gridy = 7;
		contentPane.add(tPMissNum, gbc_tPMissNum);

		tPMissVal = new JSpinner();
		GridBagConstraints gbc_tPMissVal = new GridBagConstraints();
		gbc_tPMissVal.anchor = GridBagConstraints.NORTH;
		gbc_tPMissVal.insets = new Insets(0, 0, 5, 5);
		gbc_tPMissVal.gridx = 6;
		gbc_tPMissVal.gridy = 7;
		contentPane.add(tPMissVal, gbc_tPMissVal);

		thPMakeNum = new JSpinner();
		thPMakeNum.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		GridBagConstraints gbc_thPMakeNum = new GridBagConstraints();
		gbc_thPMakeNum.anchor = GridBagConstraints.NORTH;
		gbc_thPMakeNum.insets = new Insets(0, 0, 5, 5);
		gbc_thPMakeNum.gridx = 5;
		gbc_thPMakeNum.gridy = 8;
		contentPane.add(thPMakeNum, gbc_thPMakeNum);

		thPMakeVal = new JSpinner();
		GridBagConstraints gbc_thPMakeVal = new GridBagConstraints();
		gbc_thPMakeVal.anchor = GridBagConstraints.NORTH;
		gbc_thPMakeVal.insets = new Insets(0, 0, 5, 5);
		gbc_thPMakeVal.gridx = 6;
		gbc_thPMakeVal.gridy = 8;
		contentPane.add(thPMakeVal, gbc_thPMakeVal);

		thPMissNum = new JSpinner();
		thPMissNum.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		GridBagConstraints gbc_thPMissNum = new GridBagConstraints();
		gbc_thPMissNum.anchor = GridBagConstraints.NORTH;
		gbc_thPMissNum.insets = new Insets(0, 0, 5, 5);
		gbc_thPMissNum.gridx = 5;
		gbc_thPMissNum.gridy = 9;
		contentPane.add(thPMissNum, gbc_thPMissNum);

		thPMissVal = new JSpinner();
		GridBagConstraints gbc_thPMissVal = new GridBagConstraints();
		gbc_thPMissVal.anchor = GridBagConstraints.NORTH;
		gbc_thPMissVal.insets = new Insets(0, 0, 5, 5);
		gbc_thPMissVal.gridx = 6;
		gbc_thPMissVal.gridy = 9;
		contentPane.add(thPMissVal, gbc_thPMissVal);

		ftMakeNum = new JSpinner();
		ftMakeNum.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		GridBagConstraints gbc_ftMakeNum = new GridBagConstraints();
		gbc_ftMakeNum.anchor = GridBagConstraints.NORTH;
		gbc_ftMakeNum.insets = new Insets(0, 0, 5, 5);
		gbc_ftMakeNum.gridx = 5;
		gbc_ftMakeNum.gridy = 10;
		contentPane.add(ftMakeNum, gbc_ftMakeNum);

		ftMakeVal = new JSpinner();
		GridBagConstraints gbc_ftMakeVal = new GridBagConstraints();
		gbc_ftMakeVal.anchor = GridBagConstraints.NORTH;
		gbc_ftMakeVal.insets = new Insets(0, 0, 5, 5);
		gbc_ftMakeVal.gridx = 6;
		gbc_ftMakeVal.gridy = 10;
		contentPane.add(ftMakeVal, gbc_ftMakeVal);

		ftMissNum = new JSpinner();
		ftMissNum.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		GridBagConstraints gbc_ftMissNum = new GridBagConstraints();
		gbc_ftMissNum.anchor = GridBagConstraints.NORTH;
		gbc_ftMissNum.insets = new Insets(0, 0, 5, 5);
		gbc_ftMissNum.gridx = 5;
		gbc_ftMissNum.gridy = 11;
		contentPane.add(ftMissNum, gbc_ftMissNum);

		ftMissVal = new JSpinner();
		GridBagConstraints gbc_ftMissVal = new GridBagConstraints();
		gbc_ftMissVal.anchor = GridBagConstraints.NORTH;
		gbc_ftMissVal.insets = new Insets(0, 0, 5, 5);
		gbc_ftMissVal.gridx = 6;
		gbc_ftMissVal.gridy = 11;
		contentPane.add(ftMissVal, gbc_ftMissVal);

		assistNum = new JSpinner();
		assistNum.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		GridBagConstraints gbc_assistNum = new GridBagConstraints();
		gbc_assistNum.anchor = GridBagConstraints.NORTH;
		gbc_assistNum.insets = new Insets(0, 0, 5, 5);
		gbc_assistNum.gridx = 5;
		gbc_assistNum.gridy = 12;
		contentPane.add(assistNum, gbc_assistNum);

		assistVal = new JSpinner();
		GridBagConstraints gbc_assistVal = new GridBagConstraints();
		gbc_assistVal.anchor = GridBagConstraints.NORTH;
		gbc_assistVal.insets = new Insets(0, 0, 5, 5);
		gbc_assistVal.gridx = 6;
		gbc_assistVal.gridy = 12;
		contentPane.add(assistVal, gbc_assistVal);

		blockNum = new JSpinner();
		blockNum.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		GridBagConstraints gbc_blockNum = new GridBagConstraints();
		gbc_blockNum.anchor = GridBagConstraints.NORTH;
		gbc_blockNum.insets = new Insets(0, 0, 5, 5);
		gbc_blockNum.gridx = 5;
		gbc_blockNum.gridy = 13;
		contentPane.add(blockNum, gbc_blockNum);

		blockVal = new JSpinner();
		GridBagConstraints gbc_blockVal = new GridBagConstraints();
		gbc_blockVal.anchor = GridBagConstraints.NORTH;
		gbc_blockVal.insets = new Insets(0, 0, 5, 5);
		gbc_blockVal.gridx = 6;
		gbc_blockVal.gridy = 13;
		contentPane.add(blockVal, gbc_blockVal);

		chargeNum = new JSpinner();
		chargeNum.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		GridBagConstraints gbc_chargeNum = new GridBagConstraints();
		gbc_chargeNum.anchor = GridBagConstraints.NORTH;
		gbc_chargeNum.insets = new Insets(0, 0, 5, 5);
		gbc_chargeNum.gridx = 5;
		gbc_chargeNum.gridy = 14;
		contentPane.add(chargeNum, gbc_chargeNum);

		chargeVal = new JSpinner();
		GridBagConstraints gbc_chargeVal = new GridBagConstraints();
		gbc_chargeVal.anchor = GridBagConstraints.NORTH;
		gbc_chargeVal.insets = new Insets(0, 0, 5, 5);
		gbc_chargeVal.gridx = 6;
		gbc_chargeVal.gridy = 14;
		contentPane.add(chargeVal, gbc_chargeVal);

		dRebNum = new JSpinner();
		dRebNum.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		GridBagConstraints gbc_dRebNum = new GridBagConstraints();
		gbc_dRebNum.anchor = GridBagConstraints.NORTH;
		gbc_dRebNum.insets = new Insets(0, 0, 5, 5);
		gbc_dRebNum.gridx = 5;
		gbc_dRebNum.gridy = 15;
		contentPane.add(dRebNum, gbc_dRebNum);

		dRebVal = new JSpinner();
		GridBagConstraints gbc_dRebVal = new GridBagConstraints();
		gbc_dRebVal.anchor = GridBagConstraints.NORTH;
		gbc_dRebVal.insets = new Insets(0, 0, 5, 5);
		gbc_dRebVal.gridx = 6;
		gbc_dRebVal.gridy = 15;
		contentPane.add(dRebVal, gbc_dRebVal);

		foulNum = new JSpinner();
		foulNum.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		GridBagConstraints gbc_foulNum = new GridBagConstraints();
		gbc_foulNum.anchor = GridBagConstraints.NORTH;
		gbc_foulNum.insets = new Insets(0, 0, 5, 5);
		gbc_foulNum.gridx = 5;
		gbc_foulNum.gridy = 16;
		contentPane.add(foulNum, gbc_foulNum);

		foulVal = new JSpinner();
		GridBagConstraints gbc_foulVal = new GridBagConstraints();
		gbc_foulVal.anchor = GridBagConstraints.NORTH;
		gbc_foulVal.insets = new Insets(0, 0, 5, 5);
		gbc_foulVal.gridx = 6;
		gbc_foulVal.gridy = 16;
		contentPane.add(foulVal, gbc_foulVal);

		oRebNum = new JSpinner();
		oRebNum.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		GridBagConstraints gbc_oRebNum = new GridBagConstraints();
		gbc_oRebNum.anchor = GridBagConstraints.NORTH;
		gbc_oRebNum.insets = new Insets(0, 0, 5, 5);
		gbc_oRebNum.gridx = 5;
		gbc_oRebNum.gridy = 17;
		contentPane.add(oRebNum, gbc_oRebNum);

		oRebVal = new JSpinner();
		GridBagConstraints gbc_oRebVal = new GridBagConstraints();
		gbc_oRebVal.anchor = GridBagConstraints.NORTH;
		gbc_oRebVal.insets = new Insets(0, 0, 5, 5);
		gbc_oRebVal.gridx = 6;
		gbc_oRebVal.gridy = 17;
		contentPane.add(oRebVal, gbc_oRebVal);

		oppORebNum = new JSpinner();
		oppORebNum.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		GridBagConstraints gbc_oppORebNum = new GridBagConstraints();
		gbc_oppORebNum.anchor = GridBagConstraints.NORTH;
		gbc_oppORebNum.insets = new Insets(0, 0, 5, 5);
		gbc_oppORebNum.gridx = 5;
		gbc_oppORebNum.gridy = 18;
		contentPane.add(oppORebNum, gbc_oppORebNum);

		oppORebVal = new JSpinner();
		GridBagConstraints gbc_oppORebVal = new GridBagConstraints();
		gbc_oppORebVal.anchor = GridBagConstraints.NORTH;
		gbc_oppORebVal.insets = new Insets(0, 0, 5, 5);
		gbc_oppORebVal.gridx = 6;
		gbc_oppORebVal.gridy = 18;
		contentPane.add(oppORebVal, gbc_oppORebVal);

		stealNum = new JSpinner();
		stealNum.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		GridBagConstraints gbc_stealNum = new GridBagConstraints();
		gbc_stealNum.anchor = GridBagConstraints.NORTH;
		gbc_stealNum.insets = new Insets(0, 0, 5, 5);
		gbc_stealNum.gridx = 5;
		gbc_stealNum.gridy = 19;
		contentPane.add(stealNum, gbc_stealNum);

		stealVal = new JSpinner();
		GridBagConstraints gbc_stealVal = new GridBagConstraints();
		gbc_stealVal.anchor = GridBagConstraints.NORTH;
		gbc_stealVal.insets = new Insets(0, 0, 5, 5);
		gbc_stealVal.gridx = 6;
		gbc_stealVal.gridy = 19;
		contentPane.add(stealVal, gbc_stealVal);

		toNum = new JSpinner();
		toNum.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		GridBagConstraints gbc_toNum = new GridBagConstraints();
		gbc_toNum.anchor = GridBagConstraints.NORTH;
		gbc_toNum.insets = new Insets(0, 0, 5, 5);
		gbc_toNum.gridx = 5;
		gbc_toNum.gridy = 20;
		contentPane.add(toNum, gbc_toNum);

		toVal = new JSpinner();
		GridBagConstraints gbc_toVal = new GridBagConstraints();
		gbc_toVal.anchor = GridBagConstraints.NORTH;
		gbc_toVal.insets = new Insets(0, 0, 5, 5);
		gbc_toVal.gridx = 6;
		gbc_toVal.gridy = 20;
		contentPane.add(toVal, gbc_toVal);

		saveButton = new JButton("Save");
		saveButton.setForeground(new Color(255, 255, 255));
		saveButton.setBackground(new Color(102, 153, 255));
		GridBagConstraints gbc_saveButton = new GridBagConstraints();
		gbc_saveButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_saveButton.insets = new Insets(0, 0, 0, 5);
		gbc_saveButton.gridx = 5;
		gbc_saveButton.gridy = 21;
		contentPane.add(saveButton, gbc_saveButton);
	}

	//gets input from all the fields and creates a game, if there is not an input or input is invalid a popup will show
	public boolean getInput()
	{
		String opponent = oppField.getText();
		if(opponent.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please make sure all fields are filled");
			return false;
		}

		Date date;

		try
		{
			int year = Integer.parseInt(yearField.getText());			
			date = new Date((int)daySpin.getValue(), (int)monthSpin.getValue(), year);
			if(date.getYear() < 1)
				throw new NumberFormatException();
		}
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null, "Please make sure all fields are filled appropriately");
			return false;
		}

		Score myScore;
		try 
		{
			int q1 = Integer.parseInt(scoreTable.getValueAt(0, 0).toString());
			int q2 = Integer.parseInt(scoreTable.getValueAt(0, 1).toString());
			int q3 = Integer.parseInt(scoreTable.getValueAt(0, 2).toString());
			int q4 = Integer.parseInt(scoreTable.getValueAt(0, 3).toString());
			int q1Opp = Integer.parseInt(scoreTable.getValueAt(1, 0).toString());
			int q2Opp = Integer.parseInt(scoreTable.getValueAt(1, 1).toString());
			int q3Opp = Integer.parseInt(scoreTable.getValueAt(1, 2).toString());			
			int q4Opp = Integer.parseInt(scoreTable.getValueAt(1, 3).toString());
			if(q1 < 0 || q2 < 0 || q3 < 0 || q4 < 0 || q1Opp < 0 || q2Opp < 0 || q3Opp < 0 || q4Opp < 0)
				throw new NumberFormatException(); 	
			myScore = new Score(q1, q2, q3, q4, q1Opp, q2Opp, q3Opp, q4Opp);
		}
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null, "Please make sure score table is filled appropriately");
			return false;
		}


		ArrayList<Stat> points = new ArrayList<Stat>();
		ArrayList<Stat> stats = new ArrayList<Stat>();

		points.add(new Stat(removeSpaces((String)(statTable.getValueAt(0, 0))), (int)tPMakeNum.getValue(), (int)tPMakeVal.getValue()));
		points.add(new Stat(removeSpaces((String)(statTable.getValueAt(1, 0))), (int)tPMissNum.getValue(), (int)tPMissVal.getValue()));
		points.add(new Stat(removeSpaces((String)(statTable.getValueAt(2, 0))), (int)thPMakeNum.getValue(), (int)thPMakeVal.getValue()));
		points.add(new Stat(removeSpaces((String)(statTable.getValueAt(3, 0))), (int)thPMissNum.getValue(), (int)thPMissVal.getValue()));
		points.add(new Stat(removeSpaces((String)(statTable.getValueAt(4, 0))), (int)ftMakeNum.getValue(), (int)ftMakeVal.getValue()));
		points.add(new Stat(removeSpaces((String)(statTable.getValueAt(5, 0))), (int)ftMissNum.getValue(), (int)ftMissVal.getValue()));


		stats.add(new Stat((String)(statTable.getValueAt(6, 0)), (int)assistNum.getValue(), (int)assistVal.getValue()));
		stats.add(new Stat((String)(statTable.getValueAt(7, 0)), (int)blockNum.getValue(), (int)blockVal.getValue()));
		stats.add(new Stat((String)(statTable.getValueAt(8, 0)), (int)chargeNum.getValue(), (int)chargeVal.getValue()));
		stats.add(new Stat(removeSpaces((String)(statTable.getValueAt(9, 0))), (int)dRebNum.getValue(), (int)dRebVal.getValue()));
		stats.add(new Stat((String)(statTable.getValueAt(10, 0)), (int)foulNum.getValue(), (int)foulVal.getValue()));
		stats.add(new Stat(removeSpaces((String)(statTable.getValueAt(11, 0))), (int)oRebNum.getValue(), (int)oRebVal.getValue()));
		stats.add(new Stat(removeSpaces((String)(statTable.getValueAt(12, 0))), (int)oppORebNum.getValue(), (int)oppORebVal.getValue()));
		stats.add(new Stat((String)(statTable.getValueAt(13, 0)), (int)stealNum.getValue(), (int)stealVal.getValue()));
		stats.add(new Stat((String)(statTable.getValueAt(14, 0)), (int)toNum.getValue(), (int)toVal.getValue()));
		myGame = new Game(opponent, date, myScore, stats, points);

		return true;
	}

	public JButton getCancelButton()
	{
		return cancelButton;
	}

	public JButton getSaveButton()
	{
		return saveButton;
	}
	
	//if game needs to be edited, sets values in the input fields to current values
	public void setGUI()
	{
		Date date = myGame.getDate();

		monthSpin.setValue(date.getMonth());
		daySpin.setValue(date.getDay());
		yearField.setText(String.valueOf(date.getYear()));
		oppField.setText(myGame.getOpp());

		ArrayList<Stat> pointStats = myGame.getPointStats();
		ArrayList<Stat> stats = myGame.getStats();

		tPMakeNum.setValue(pointStats.get(0).getNum());
		tPMakeVal.setValue(pointStats.get(0).getValue());

		tPMissNum.setValue(pointStats.get(1).getNum());
		tPMissVal.setValue(pointStats.get(1).getValue());

		thPMakeNum.setValue(pointStats.get(2).getNum());
		thPMakeVal.setValue(pointStats.get(2).getValue());

		thPMissNum.setValue(pointStats.get(3).getNum());
		thPMissVal.setValue(pointStats.get(3).getValue());

		ftMakeNum.setValue(pointStats.get(4).getNum());
		ftMakeVal.setValue(pointStats.get(4).getValue());

		ftMissNum.setValue(pointStats.get(5).getNum());
		ftMissVal.setValue(pointStats.get(5).getValue());

		assistNum.setValue(stats.get(0).getNum());
		assistVal.setValue(stats.get(0).getValue());

		blockNum.setValue(stats.get(1).getNum());
		blockVal.setValue(stats.get(1).getNum());

		chargeNum.setValue(stats.get(2).getNum());
		chargeVal.setValue(stats.get(2).getNum());

		dRebNum.setValue(stats.get(3).getNum());
		dRebVal.setValue(stats.get(3).getNum());

		foulNum.setValue(stats.get(4).getNum());
		foulVal.setValue(stats.get(4).getNum());

		oRebNum.setValue(stats.get(5).getNum());
		oRebVal.setValue(stats.get(5).getNum());

		oppORebNum.setValue(stats.get(6).getNum());
		oppORebVal.setValue(stats.get(6).getNum());

		stealNum.setValue(stats.get(7).getNum());
		stealVal.setValue(stats.get(7).getNum());

		toNum.setValue(stats.get(8).getNum());
		toVal.setValue(stats.get(8).getNum());

		Score score = myGame.getScore();

		scoreTable.setValueAt(score.getMyQ1(), 0, 0);
		scoreTable.setValueAt(score.getMyQ2(), 0, 1);
		scoreTable.setValueAt(score.getMyQ3(), 0, 2);
		scoreTable.setValueAt(score.getMyQ4(), 0, 3);

		scoreTable.setValueAt(score.getOppQ1(), 1, 0);
		scoreTable.setValueAt(score.getOppQ2(), 1, 1);
		scoreTable.setValueAt(score.getOppQ3(), 1, 2);
		scoreTable.setValueAt(score.getOppQ4(), 1, 3);
	}
	
	//cancel adding a game
	public void cancel()
	{
		cancelButton = new JButton("Cancel");
		cancelButton.setForeground(new Color(255, 255, 255));
		cancelButton.setBackground(new Color(102, 153, 255));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel?", "Cancel Confirmation", JOptionPane.YES_NO_OPTION);				
				if(result == 0)
				{
					dispose();
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				}
			}
		});
		GridBagConstraints gbc_cancelButton = new GridBagConstraints();
		gbc_cancelButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_cancelButton.insets = new Insets(0, 0, 0, 5);
		gbc_cancelButton.gridx = 6;
		gbc_cancelButton.gridy = 21;
		contentPane.add(cancelButton, gbc_cancelButton);
	}
	
	//cancel editing a game
	public void cancelEdit()
	{
		cancelButton =  new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel?", "Cancel Confirmation", JOptionPane.YES_NO_OPTION);				
				if(result == 0)
				{
					dispose();
					GameDisplayInterface frame = new GameDisplayInterface(myTeam, myGame);
					frame.setVisible(true);
				}
			}
		});
		GridBagConstraints gbc_cancelButton = new GridBagConstraints();
		gbc_cancelButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_cancelButton.insets = new Insets(0, 0, 0, 5);
		gbc_cancelButton.gridx = 6;
		gbc_cancelButton.gridy = 21;
		contentPane.add(cancelButton, gbc_cancelButton);
	}
	
	//removes spaces to be properly stored in a text file
	public String removeSpaces(String string)
	{
		String temp = string;
		int index = temp.indexOf(" ");
		while(index != -1)
		{
			temp = temp.substring(0, index) + temp.substring(index + 1);
			index = temp.indexOf(" ");
		}
		return temp;
	}

	public Game getGame()
	{
		return myGame;
	}
	
	// saves input and displays the newly saved game
	public void save()
	{
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				boolean good = getInput();
				if(good == true)
				{

					int index = myTeam.addGame(myGame);
					GameDisplayInterface frame = new GameDisplayInterface(myTeam, index);					
					frame.setVisible(true);
					dispose();
				}
			}
		});
		GridBagConstraints gbc_saveButton = new GridBagConstraints();
		gbc_saveButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_saveButton.insets = new Insets(0, 0, 0, 5);
		gbc_saveButton.gridx = 5;
		gbc_saveButton.gridy = 21;
	}

	public Team getTeam()
	{
		return myTeam;
	}
}
