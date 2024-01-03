
public class Date 
{
	int myDay;
	int myMonth;
	int myYear;

	public Date(int da, int mon, int yr)
	{
		myDay = da;
		myMonth = mon;
		myYear = yr;
	}

	public String getDate()
	{
		String temp = String.valueOf(myMonth) + "/" + String.valueOf(myDay) + "/" + String.valueOf(myYear);
		return temp;
	}
	
	//return a number greater than zero if this.date is later, equal to zero if they are equal, and less than zero if other.year is later
	public int compareTo(Date other)
	{
		int comp = myYear - other.myYear;
		if(comp == 0)
		{
			comp = myMonth - other.myMonth;
			if(comp == 0)
			{
				comp = myDay - other.myDay;
				return comp;
			}
			else
				return comp;
		}
		else
			return comp;
	}

	public int getDay()
	{
		return myDay;
	}

	public int getMonth()
	{
		return myMonth;
	}

	public int getYear()
	{
		return myYear;
	}

	public boolean equals(Date other)
	{
		return compareTo(other) == 0;
	}
}
