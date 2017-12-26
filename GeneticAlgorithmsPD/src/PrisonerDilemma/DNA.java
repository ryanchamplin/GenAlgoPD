package PrisonerDilemma;

//import java.util.Comparator;
import java.util.Random;


public class DNA implements Comparable<DNA> { // may need impliment Comparable<DNA>
	
	Random rand = new Random();
	final String ALPHABET = "RTSP";
	private int fitness;
	char[] population;
	
	DNA(int popSize){
		population = new char[popSize];
		for(int i = 0; i < population.length; i++){		
			population[i] = (char) ALPHABET.charAt(rand.nextInt(ALPHABET.length()));
		}
	}
	
	public String returnSentence(){
		return new String(population);
	}
	
	public void eveulateDNAFitness(){
		//TODO	
		int myScore = 0;
		int yourScore = 0;
		for(int i=0; i < population.length; i++){
			char inChoice = population[i];
			
			switch(inChoice){
			case 'R':
				myScore += 6;
				yourScore +=6;
				break;
			case 'T':
				myScore +=10;
				yourScore +=0;
				break;
			case 'S':
				myScore += 0;
				yourScore +=10;
				break;
			case 'P':
				myScore += 2;
				yourScore += 2;
				break;
			default:
				myScore += 0;
				yourScore +=0;
				break;
			}
		}
		
		fitness = myScore + yourScore;
	}
	
	public DNA crossover(DNA secondParent){
		DNA child = new DNA(population.length);
		
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
				population[i] = (char) ALPHABET.charAt(rand.nextInt(ALPHABET.length()));
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