package PrisonerDilemma;
import java.util.Scanner;


public class RunPD {

	public static void main(String[] args) {
		
		String paramater = "";
		double mutationRate = 0.01;
		int maxPopulation = 20;
		Scanner scanner = new Scanner(System.in);
		

		System.out.println("Please enter your desired selection parameter: fp, sto, tour, or trun.");
		paramater = scanner.nextLine();
		
		Population population = new Population(mutationRate, maxPopulation, paramater);
		scanner.close();
		
		for(int i =0; i<1000; i++){
			population.selection();
			population.generateGeneration();
			population.calculateFitness();
			String answer = population.getBest();
			System.out.println("I currently think the best answer is " + answer);
		}
		
		System.out.println("We found this in " + population.getGenerationNumber() + " generations.");
	}

}
