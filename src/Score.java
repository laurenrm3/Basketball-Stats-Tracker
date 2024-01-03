
public class Score 
{
	int myPoints;
	int oppPoints;
	int q1; 
	int q2;
	int q3;
	int q4;
	int q1Opp; 
	int q2Opp;
	int q3Opp;
	int q4Opp;

	public Score(int myQ1, int myQ2, int myQ3, int myQ4, int oppQ1, int oppQ2, int oppQ3, int oppQ4)
	{
		myPoints = myQ1 + myQ2 + myQ3 + myQ4;
		oppPoints = oppQ1 + oppQ2 + oppQ3 + oppQ4;
		q1 = myQ1;
		q2 = myQ2;
		q3 = myQ3;
		q4 = myQ4;
		q1Opp = oppQ1;
		q2Opp = oppQ2;
		q3Opp = oppQ3;
		q4Opp = oppQ4;
	}

	public boolean win()
	{
		return myPoints > oppPoints;
	}

	public String getScore()
	{
		return myPoints + " - " + oppPoints;
	}

	public int getMyQ1()
	{
		return q1;
	}

	public int getMyQ2()
	{
		return q2;
	}

	public int getMyQ3()
	{
		return q3;
	}

	public int getMyQ4()
	{
		return q4;
	}

	public int getOppQ1()
	{
		return q1Opp;
	}

	public int getOppQ2()
	{
		return q2Opp;
	}

	public int getOppQ3()
	{
		return q3Opp;
	}

	public int getOppQ4()
	{
		return q4Opp;
	}

	public int getMyTotal()
	{
		return myPoints;
	}

	public int getOppTotal()
	{
		return oppPoints;
	}

}
