
public class Stat 
{

	String name;
	int statNum;
	int calcValue;

	public Stat(String title, int num, int newValue)
	{
		name = title;
		statNum = num;
		calcValue = newValue;
	}

	public Stat(String title)
	{
		name = title;
		statNum = 0;
	}

	public void editValue(int newValue)
	{
		calcValue = newValue;
	}

	public int getValue()
	{
		return calcValue;
	}

	public int getNum()
	{
		return statNum;
	}

	public void editNum(int newNum)
	{
		statNum = newNum;
	}

	public String getName()
	{
		return name;
	}

	public boolean equals(Stat otherStat)
	{
		return name.equals(otherStat.getName()) && statNum == otherStat.getNum() && calcValue == otherStat.getValue();
	}

}
