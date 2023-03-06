package uk.ac.leedsbeckett.mullier.sesc;
import java.util.ArrayList;



public class Competitor 
{
	private String name;
	private String club;
	private String cat;
	private ArrayList<Object> awards = new ArrayList<Object>();
	private int eventsCompeted; //events competed in so far
	private int[] results;		//results achieved in the league
	
	private CycleLeague league; //league to which this competitor is attached
	
	public Competitor(CycleLeague league, String name, String club, String cat)
	{
		results = new int[league.getNumberOfEvents()];
		this.name = name;
		this.club = club;
		this.cat = cat;
		this.eventsCompeted = 0;
		this.league=league;
		league.addCompetitor(this);
		
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getClub()
	{
		return this.club;
	}
	
	public String getCat()
	{
		return this.cat;
	}
	
	public int getEventsCompeted()
	{
		return eventsCompeted;
	}
	
	public int getPoints()
	{
		int points=0;
		for(int i=1 ; i<eventsCompeted; i++)
			points = points + results[i];
		return points;
	}
	
	public int getPointsEvent(int event)
	{
		return results[event];
	}
	
	//assumes events are completed sequentially so points goes into the next slot
	public void setResult(int points)
	{
		results[eventsCompeted++] = points;
	
	}
	
	//set a particular result, returns false if that event does not exist
	public boolean setResult(int event, int points)
	{
		if(event < league.getNumberOfEvents())
		{
			results[event] = points;
			return true;
		}
		return false;
	}
	
	public void addAward(Award award)
	{
		awards.add((Object) award);
	}
	
	public int getNumberOfAwards()
	{
		return awards.size();
	}
	
	public ArrayList<Object> getAwards()
	{
		return awards;
	}

}
