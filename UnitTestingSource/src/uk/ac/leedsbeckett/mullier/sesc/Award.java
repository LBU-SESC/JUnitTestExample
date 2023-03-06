
//represents an award such as a trophy
package uk.ac.leedsbeckett.mullier.sesc;
public class Award 
{
	private String name;
	private String description;
	
	
	public Award(String name)
	{
		this.name = name;
		
	}
	
	public Award(String name, String description)
	{
		this.name = name;
		this.description = description;
		
	}
	
	public String getName()
	{
		return this.name;
	}
	public Award(Competitor winner,String name)
	{
		this.name = name;
		
				
	}
	
	
	

}
