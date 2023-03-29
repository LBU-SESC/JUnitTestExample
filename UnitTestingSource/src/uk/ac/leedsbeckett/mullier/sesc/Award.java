

package uk.ac.leedsbeckett.mullier.sesc;

/**
 * 
 * represents an award such as a trophy
 */
public class Award 
{
	private String name;
	private String description;
	
	/**
	 * create an award without a description
	 * @param name name of the award
	 */
	public Award(String name)
	{
		this.name = name;
		
	}
	
	/**
	 * Create an award with a name and a brief description
	 * @param name name of the award
	 * @param description description of what it is
	 */
	public Award(String name, String description)
	{
		this.name = name;
		this.description = description;
		
	}
	
	/**
	 * Create an award and also assign it to a competitor (the winner)
	 * @param winner object representing the Competitor
	 * @param name name of the award
	 */
	public Award(Competitor winner,String name)
	{
		this.name = name;
		
				
	}

	
	/**
	 * get stored description of this award
	 * @return String description
	 */
	
	public String getDescription() {
		return description;
	}

	/**
	 * set the stored description of this award
	 * @param description String description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * get stored name of this award
	 * @param name String description
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * get the award object's name
	 * @return string name
	 */

	public String getName()
	{
		return this.name;
	}
	

}