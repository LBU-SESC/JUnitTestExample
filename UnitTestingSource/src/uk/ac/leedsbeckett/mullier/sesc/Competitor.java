
package uk.ac.leedsbeckett.mullier.sesc;
import java.util.ArrayList;

/**
 * class representing a Competitor
 * a competitor belongs to a cycle league and can have points allocated for events they've competed in and be attached to Awards that they've won.
 */

public class Competitor 
{
	private String name;
	private String club;
	private String cat;
	private ArrayList<Object> awards = new ArrayList<Object>();
	private int eventsCompeted; //events competed in so far
	private int[] results;		//results achieved in the league
	
	private CycleLeague league; //league to which this competitor is attached
	
	/**
	 *  Create a competitor
	 * @param league league that they belong to
	 * @param name name of competitor
	 * @param club club they belong to
	 * @param cat category of competitor
	 */
			
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
	
	/**
	 * returns the competitor's name
	 * @return competitor's name
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * returns the competitor's club
	 * @return competitor's club
	 */
	public String getClub()
	{
		return this.club;
	}
	
	/**
	 * returns the competitor's category
	 * @return competitor's category
	 */
	public String getCat()
	{
		return this.cat;
	}
	
	/**
	 * returns the number of events the competitor has currently competed in
	 * @return competitor total events
	 */
	public int getEventsCompeted()
	{
		return eventsCompeted;
	}
	
	/**
	 * returns the total number of points from all events competitor has competed in
	 * @return total points
	 */
	public int getPoints()
	{
		int points=0;
		for(int i=1 ; i<eventsCompeted; i++)
			points = points + results[i];
		return points;
	}
	
	/**
	 * returns the number of points received at a particular event
	 * @param event event rider competed at
	 * @return number of points
	 */
	public int getPointsEvent(int event)
	{
		return results[event];
	}
	
	/**
	 * set the points for sequential events
	 * @param points int for points
	 */
	
	public void setResult(int points)
	{
		results[eventsCompeted++] = points;
	
	}
	
	/**
	 * set a particular result, returns false if that event does not exist
	 * @param event event want the point for
	 * @param points set points to this value
	 * @return true if ok, false if event does not exist.
	 */
	
	public boolean setResult(int event, int points)
	{
		if(event < league.getNumberOfEvents())
		{
			results[event] = points;
			return true;
		}
		return false;
	}
	
	/**
	 * Adds an award to the awards arraylist
	 * @param award Award object to add to Competitor
	 */
	public void addAward(Award award)
	{
		awards.add((Object) award);
	}
	
	/**
	 * get how many awards there are
	 * @return number of awards
	 */
	public int getNumberOfAwards()
	{
		return awards.size();
	}
	
	/**
	 * get a reference to the Awards array list
	 * @return array list reference
	 */
	public ArrayList<Object> getAwards()
	{
		return awards;
	}

}