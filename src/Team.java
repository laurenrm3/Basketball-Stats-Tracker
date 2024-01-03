import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Team 
{
	ArrayList<Game> games;
	int wins;
	int losses;
	String file;

	public Team()
	{
		games = new ArrayList<Game>();
		file = "data.txt";
		readData();

		wins = getNumWins();
		losses = games.size() - wins;		
	}

	public String getRecord()
	{
		return wins + " - " + losses;
	}

	public int getNumWins()
	{
		int count = 0;

		for(int i = 0; i < games.size(); i++)
		{
			if(games.get(i).win)
				count++;
		}
		return count;
	}

	public void addGame(String opp, Date currdate, Score currscore, ArrayList<Stat> stats, ArrayList<Stat> points)
	{
		Game adding = new Game(opp, currdate, currscore, stats, points);
		int index = 0;
		Game curr = games.get(index);
		while(curr != null)
		{
			if(adding.getDate().compareTo(curr.getDate()) < 0)
				games.add(index, adding);
			else
			{
				index++;
				curr = games.get(index);
			}
		}
		if(adding.getDate().compareTo(games.get(games.size()-1).getDate()) > 0)
			games.add(index, adding);
		save();
	}


	public int addGame(Game game)
	{
		Game adding = game;
		Date currDate = adding.getDate();
		if(games.size() == 0)
		{
			games.add(game);
			save();
			return 0;
		}
		int index = 0;
		Game curr;
		while(index < games.size())
		{
			curr = games.get(index);
			if(currDate.compareTo(curr.getDate()) <= 0)
			{
				games.add(index, adding);
				save();
				return index;
			}
			else
				index++;					
		}
		if(currDate.compareTo(games.get(games.size()-1).getDate()) > 0)
			games.add(adding);	
		save();
		return index;
	}


	public ArrayList<Game> getGames()
	{
		return games;
	}

	//write all the games and information to a text file
	public void save()
	{
		PrintWriter writer;
		try 
		{
			writer = new PrintWriter(new File(file));
			for(int i = 0; i < games.size(); i++)
			{
				Game curr = games.get(i);
				Date currDate = curr.getDate();
				Score currScore = curr.getScore();

				writer.print(currDate.getDay() + " ");
				writer.print(currDate.getMonth() + " ");
				writer.print(currDate.getYear() + " ");
				writer.print(currScore.getMyQ1() + " ");
				writer.print(currScore.getMyQ2() + " ");
				writer.print(currScore.getMyQ3() + " ");
				writer.print(currScore.getMyQ4() + " ");
				writer.print(currScore.getOppQ1() + " ");
				writer.print(currScore.getOppQ2() + " ");
				writer.print(currScore.getOppQ3() + " ");
				writer.print(currScore.getOppQ4() + " ");
				ArrayList<Stat> points = curr.getPointStats();
				ArrayList<Stat> stats = curr.getStats();
				for(int j = 0; j < points.size(); j++)
				{
					Stat currPointStat = points.get(j);
					writer.print(currPointStat.getName() + " ");
					writer.print(currPointStat.getNum() + " ");
					writer.print(currPointStat.getValue() + " ");
				}

				for(int j = 0; j < stats.size(); j++)
				{
					Stat currStat = stats.get(j);
					writer.print(currStat.getName() + " ");
					writer.print(currStat.getNum() + " ");
					writer.print(currStat.getValue() + " ");
				}
				writer.print(curr.getOpp() + " ");
				writer.println();
			}

			writer.close();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//gets data from text file and adds the games to the array list
	public void readData()
	{
		Scanner scanner;
		try 
		{
			if(new File(file).exists())
			{
				scanner = new Scanner(new File(file));
				while (scanner.hasNextLine() && scanner.hasNext())
				{
					ArrayList<Stat> points = new ArrayList<Stat>();
					ArrayList<Stat> stats = new ArrayList<Stat>();


					Date tempDate = new Date(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());

					Score tempScore = new Score(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());

					while(points.size() < 6)
					{
						String name = scanner.next();
						int num = scanner.nextInt();
						int val = scanner.nextInt();

						points.add(new Stat(name, num, val));
					}

					while(stats.size() < 9)
					{
						String name = scanner.next();
						int num = scanner.nextInt();
						int val = scanner.nextInt();

						stats.add(new Stat(name, num, val));
					}

					String opp = scanner.next();
					while(!scanner.hasNextInt() && scanner.hasNext())
						opp += " " + scanner.next();


					Game temp = new Game(opp,tempDate, tempScore, stats, points);

					addGame(temp);

				}
				scanner.close();
			}	
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}

	}
	
	//resets the text file and displayed record
	public void resetAll()
	{
		games = new ArrayList<Game>();
		PrintWriter writer;
		try 
		{
			writer = new PrintWriter("data.txt");
			writer.print("");
			writer.close();
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resetRecord();
	}
	
	//updates the record when a game is removed
	public void updateRecord(boolean win)
	{
		if(win)
			wins--;
		else
			losses--;
	}

	public void resetRecord()
	{
		wins = 0;
		losses = 0;
	}
}
