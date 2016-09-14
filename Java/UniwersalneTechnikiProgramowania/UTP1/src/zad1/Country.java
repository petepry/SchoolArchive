package zad1;

public class Country {
	
	private String name;
	private String capital;
	private Integer population;
	
	
	public Country(String name, String capital, Integer population){
		
		this.name = name;
		this.capital = capital;
		this.population = population;
		
	}
	
	public Country(String[] line) {
		name = line[0];
		capital = line[1];
		population = Integer.parseInt(line[2]);
	}

	public String getName (){
		return name;
	}
	public String getCapital (){
		return capital;
	}
	public Integer getPopulation (){
		return population;
	}
}
