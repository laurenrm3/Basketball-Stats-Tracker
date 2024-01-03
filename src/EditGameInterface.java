import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class EditGameInterface extends AddGameInterface 
{
	private Game myGame;
	private Team myTeam;

	/**
	 * Create the frame.
	 */
	public EditGameInterface(Game game, Team team) 
	{
		super(game);
		myTeam = team;
		setVisible(true);
		myGame = game;
		this.save();
	}

	public void save()
	{
		JButton save = getSaveButton();
		save.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				boolean good = getInput();
				if(good == true)
				{
					myGame.editGame(getGame());
					myTeam.save();
					GameDisplayInterface frame = new GameDisplayInterface(myTeam, myGame);
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

}
