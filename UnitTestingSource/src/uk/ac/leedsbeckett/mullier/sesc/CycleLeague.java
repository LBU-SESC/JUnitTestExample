
package uk.ac.leedsbeckett.mullier.sesc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class CycleLeague 
{
	private String leagueName;
	private int numberOfEvents;
	private ArrayList<Object> competitors = new ArrayList<Object>();
	
	public CycleLeague(String name, int events)
	{
		this.leagueName = name;
		this.numberOfEvents = events;
	}
	
	public String getLeagueName()
	{
	
		return leagueName;
	}
	
	public int getNumberOfEvents()
	{
		return numberOfEvents;
	}
	
	public void addCompetitor(Competitor c)
	{
		competitors.add((Object) c);
	}
	
	public Competitor getCompetitor(String name)
	{
		Competitor c;
		for(int i=0; i<competitors.size(); i++)
		{
			c = (Competitor) competitors.get(i); 
			String s = c.getName();
			if (s.compareToIgnoreCase(name)==0)
			{
				return c;
			}
			
		}
		throw new NoSuchElementException("can't find "+name) ;
	}
	
	//get the "position"th competitor (first is zero)
	public Competitor getCompetitor(int position)
	{
		return (Competitor) competitors.get(position);
	}
	
	//go through all the competitors and sort them based on total points
	public void sortResults()
	{
		Collections.sort(competitors, new Comparator<Object>()
		{
			 
            public int compare(Object o1, Object o2) 
            {
                Competitor c1 = (Competitor) o1;
                Competitor c2 = (Competitor) o2;
                return(c2.getPoints()-c1.getPoints());
              
            }
	
		});
	}
	
	public void displayCompetitors()
	{
		String Awards="";
		for(int i=0; i<competitors.size(); i++)
		{
			Competitor c;
			Awards="";
			c = (Competitor) competitors.get(i);
			int noAwards = c.getNumberOfAwards();
			if (noAwards>0)
			{
				ArrayList<Object> arr = c.getAwards();
				for(int j=0;j<noAwards; j++)
				{
					Award a = (Award) arr.get(j);
					Awards += a.getName()+" ";
				}
			}
			System.out.println(c.getName()+"\t"+c.getClub()+"\t"+c.getCat()+"\t"+c.getPoints()+" "+Awards);
		}
	}
}