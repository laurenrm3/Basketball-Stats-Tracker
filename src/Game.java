import java.util.ArrayList;

public class Game {
	String myOpp;
	Score myScore;
	ArrayList<Stat> myPoints;
	ArrayList<Stat> myStats;
	boolean win;
	Date date;
	PlusMinusCalculator calc;


	public Game(String opp, Date currdate, Score currscore, ArrayList<Stat> stats, ArrayList<Stat> points)
	{
		myOpp = opp;

		myStats = stats;

		myPoints = points;

		myScore = currscore;

		date = currdate;

		if(myScore.win())
			win = true;
		else
			win = false;

		calc = new PlusMinusCalculator(stats, points);
	}


	public String getOpp()
	{
		return myOpp;
	}

	public Date getDate()
	{
		return date;
	}

	public String getTotal()
	{
		return Integer.toString(calc.total);
	}

	public ArrayList<Stat> getPointStats()
	{
		return myPoints;
	}

	public ArrayList<Stat> getStats()
	{
		return myStats;
	}
	
	//checks to see if the stats have changed
	public boolean statEquals(ArrayList<Stat> otherPoints, ArrayList<Stat> otherStats)
	{
		for(int i = 0; i < otherPoints.size(); i++)
		{
			if(!myPoints.get(i).equals(otherPoints.get(i)))
				return false;
		}
		for(int i = 0; i < otherStats.size(); i++)
		{
			if(!myPoints.get(i).equals(otherStats.get(i)))
				return false;
		}
		return true;
	}

	public Score getScore()
	{
		return myScore;
	}

	public void setOpp(String opp)
	{
		myOpp = opp;
	}

	public void setDate(int day, int month, int year)
	{
		date = new Date(day, month, year);
	}

	public void setDate(Date otherDate)
	{
		date = new Date(otherDate.getDay(), otherDate.getMonth(), otherDate.getYear());
	}

	public void setScore(int myQ1, int myQ2, int myQ3, int myQ4, int oppQ1, int oppQ2, int oppQ3, int oppQ4)
	{
		myScore = new Score(myQ1, myQ2, myQ3, myQ4, oppQ1, oppQ2, oppQ3, oppQ4);
	}

	public void setScore(Score otherScore)
	{
		myScore = otherScore;
	}

	public void setStats(ArrayList<Stat> stats)
	{
		myStats = stats;
	}

	public void setPointStats(ArrayList<Stat> stats)
	{
		myPoints = stats;
	}

	//sets game to have the new game data if it has changed
	public void editGame(Game newGame)
	{		
		if(date.compareTo(newGame.getDate()) != 0)
			setDate(newGame.getDate());
		if(!myOpp.equals(newGame.getOpp()))
			myOpp = newGame.getOpp();
		if(!myScore.equals(newGame.getScore()))
			setScore(newGame.getScore());
		if(!statEquals(newGame.getPointStats(), newGame.getStats()))
		{
			myPoints =  newGame.getPointStats();
			myStats = newGame.getStats();			
		}
	}
}
