/**
 * 
 * @author D Mullier
 * simple example to use Award, Competitor and Cycle League
 *
 */
package uk.ac.leedsbeckett.mullier.sesc;
import java.util.NoSuchElementException;



public class League 
{

	
	public static void main(String[] args) 
	{
		new League();
	}
	
	public League()
	{
		//some ad-hoc code to do some testing
		Competitor c;
		int events = 18;
		CycleLeague league = new CycleLeague("Time Trial League",events);
		for(int i = 0; i<20; i++)
		{
			c = new Competitor(league,"Person "+i,"Nova","Senior");
			for(int j = 0 ; j<events; j++)
			{
				double r = Math.random()*50;
				int ran = (int) Math.round(r);
				c.setResult(ran ); //random set of results
			}
		}
		
		
		
		try
		{
			league.sortResults();
			Competitor c2 = league.getCompetitor(0);	
			Award award = new Award("League Champion");
			c2.addAward(award);
			award = new Award("Hilly 19 Trophy");
			c2.addAward(award);
			c = league.getCompetitor("Person 9");
			c.addAward(new Award("Triangle Trophy"));
			league.displayCompetitors();
			c = league.getCompetitor("Person 9");
			
			
		
		}
		catch(NoSuchElementException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
}
