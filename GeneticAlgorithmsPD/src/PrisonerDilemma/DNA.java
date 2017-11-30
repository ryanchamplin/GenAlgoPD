package PrisonerDilemma;

//import java.util.Comparator;
import java.util.Random;


public class DNA implements Comparable<DNA> { // may need impliment Comparable<DNA>
	
	Random rand = new Random();
	
	enum Choice {DEFECT, SILENT;	
		public static Choice getRandomChoice(){
			Random rand = new Random();
			return values()[rand.nextInt(values().length)];
		};
	}
	private double fitness;
	Choice[] population;
	
	DNA(){
		population = new Choice[1];
		for(int i = 0; i < population.length; i++){		
			population[i] = Choice.getRandomChoice();
		}
	}
	
	public String returnSentence(){
		return new String(population.toString());
	}
	
	public void eveulateDNAFitness(){
		int score = 0;
		if()
		fitness = score ;
	}
	
	public DNA crossover(DNA secondParent){
		DNA child = new DNA();
		
		int splitPoint = rand.nextInt(population.length);
		
		for (int i = 0; i<population.length; i++){
			if(i > splitPoint){
				child.population[i] = population[i];
			}
			else {
				child.population[i] = secondParent.population[i];
			}
		}
		return child;
	}
	
	public void mutate(double mutationRate){
		for (int i = 0; i<population.length; i++){
			if(rand.nextDouble() < mutationRate){
				population[i] =  Choice.getRandomChoice();
			}
		}
	}
	
	public double getFitness(){
		return fitness;
	}
	

	@Override
	public int compareTo(DNA other) {
		if(this.getFitness() == other.getFitness()){
			return 0;
		}
		if(this.getFitness() > other.getFitness()){
			return -1;
		}
		return 1;
	}
	
	

}