

package uk.ac.leedsbeckett.mullier.sesc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.NoSuchElementException;
/**
 * CycleLeague
 * holds a collection of competitors results in a Cycle League
 */
public class CycleLeague 
{
	private String leagueName;
	private int numberOfEvents;
	private ArrayList<Object> competitors = new ArrayList<Object>();
	
	/**
	 * generate a cycle league
	 * @param name String name of the league
	 * @param events int number of events in this league
	 */
	public CycleLeague(String name, int events)
	{
		this.leagueName = name;
		this.numberOfEvents = events;
	}
	
	/**
	 * get the stored name of this league
	 * @return String name
	 */
	public String getLeagueName()
	{
	
		return leagueName;
	}
	
	/**
	 * return stored number of events
	 * @return int number of events
	 */
	public int getNumberOfEvents()
	{
		return numberOfEvents;
	}
	
	/**
	 * add a Competitor object to this league
	 * @param c Competitor object to add
	 */
	public void addCompetitor(Competitor c)
	{
		competitors.add((Object) c);
	}
	
	/**
	 * get stored Competitor who matches the supplied name
	 * @param name String name of Competitor
	 * @return Competitor object
	 */
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
	
	/**
	 * get the "position"th competitor (first is zero)
	 * @param position position in the league to get competitor
	 * @return Competitor object
	 */
	
	public Competitor getCompetitor(int position)
	{
		return (Competitor) competitors.get(position);
	}
	
	/**
	 * sort competitors and sort them based on total points
	 */
	
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
	
	/**
	 * generate a string output for the league of Competitors
	 * @return String Competitors in one long string
	 */
	public String getCompetitorsList()
	{
		String Awards="";
		String table="";
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
			table += c.getName()+"\t"+c.getClub()+"\t"+c.getCat()+"\t"+c.getPoints()+" "+Awards+"\n";
		}
		return table;
	}
}