import java.util.ArrayList;

public class PlusMinusCalculator 
{
	int total;

	public PlusMinusCalculator(ArrayList<Stat> points, ArrayList<Stat> stat)
	{
		total = calculate(points, stat);
	}

	public int calculate(ArrayList<Stat> points, ArrayList<Stat> stat)
	{
		int total = 0;
		for (int i = 0; i < points.size(); i++)
		{
			Stat curr = points.get(i);
			total += (curr.getNum() * curr.getValue());
		}
		for (int i = 0; i < stat.size(); i++)
		{
			Stat curr = stat.get(i);
			total += (curr.getNum() * curr.getValue());
		}
		return total;
	}
}
