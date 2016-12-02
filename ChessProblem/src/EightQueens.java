import java.util.ArrayList;
import java.util.Arrays;

import gpdraw.DrawingTool;
import gpdraw.SketchPad;

public class EightQueens {
	
	private int[][] queenPositions = new int[8][2];
	private ArrayList<Integer> temp = new ArrayList<Integer>();
	private ArrayList<int[][]> solutions = new ArrayList<int[][]>();
	private ArrayList<int[][]> nonSolutions = new ArrayList<int[][]>();
	
	public void getEightQueens(){
		
		for (int i = 0; i < 8; i++){
			queenPositions[i][1] = i;
		}
		
		for(int first = 0; first < 8; first++){
			if(!temp.contains((Integer) first)){
				temp.add((Integer) first);

				for(int second = 0; second < 8; second++){
					if(!temp.contains((Integer) second)){
						temp.add((Integer) second);
				
						for(int third = 0; third < 8; third++){
							if(!temp.contains((Integer) third)){
								temp.add((Integer) third);
						
								for(int fourth = 0; fourth < 8; fourth++){
									if(!temp.contains((Integer) fourth)){
										temp.add((Integer) fourth);
								
										for(int fifth = 0; fifth < 8; fifth++){
											if(!temp.contains((Integer) fifth)){
												temp.add((Integer) fifth);
										
												for(int sixth = 0; sixth < 8; sixth ++){
													if(!temp.contains((Integer) sixth)){
														temp.add((Integer) sixth);
												
														for(int seventh = 0; seventh < 8; seventh++){
															if(!temp.contains((Integer) seventh)){
																temp.add((Integer) seventh);
														
																for(int eigth = 0; eigth < 8; eigth++){
																	if(!temp.contains((Integer) eigth)){
																		temp.add((Integer) eigth);
																		
																		queenPositions = new int[8][2];
																		
																		for (int i = 0; i < 8; i++){
																			queenPositions[i][1] = i;
																		}
																		
																		queenPositions[0][0] = first;
																		queenPositions[1][0] = second;
																		queenPositions[2][0] = third;
																		queenPositions[3][0] = fourth;
																		queenPositions[4][0] = fifth;
																		queenPositions[5][0] = sixth;
																		queenPositions[6][0] = seventh;
																		queenPositions[7][0] = eigth;
																		
																		if (isSolution(queenPositions) && !isSolutionChosenBefore(queenPositions)){
																			solutions.add(queenPositions);
																			createNonAnswers(queenPositions);

																		}
																		
																		temp.remove(temp.size() - 1);
																	}
																}
																temp.remove(temp.size() - 1);
															}
														}
														temp.remove(temp.size() - 1);
													}
												}
												temp.remove(temp.size() - 1);
											}
										}
										temp.remove(temp.size() - 1);
									}
								}
								temp.remove(temp.size() - 1);
							}
						}
						temp.remove(temp.size() - 1);
					}
				}
				temp.remove(temp.size() - 1);
			}
		}
		
		for(int i = 0; i < solutions.size(); i++){
			drawSolution(solutions.get(i));
		}
	}
	public void print(int[][] nums){
		for(int i = 0; i < nums.length; i++){
			System.out.println(Arrays.toString(nums[i]));
		}
	}
	
	private boolean isSolution(int[][] array){
		for(int i = 0; i < array.length; i++){
			int[] firstQueen = array[i];
			for(int x = 0; x < array.length; x++){
				int[] secondQueen = array[x];
				if(firstQueen[1] != secondQueen[1]){
					double slope = (double)(firstQueen[1] - secondQueen[1]) / (firstQueen[0] - secondQueen[0]);
					if (slope == 1 || slope == -1) return false;
				}
			}
		}
		return true;
	}
	
	private void drawSolution(int[][] solution){
		double scale = 2;
		SketchPad paper = new SketchPad(80 * (int) scale + 100, 80 * (int) scale + 100);
		DrawingTool pen = new DrawingTool(paper);
		
		
		pen.down();
		pen.drawRect(80 * scale, 80 * scale);
		
		for(int i = 0; i < 80; i += 10){
			pen.up();
			pen.move(scale * (i - 40), scale * 40);
			pen.down();
			pen.move(scale * (i - 40), -40 * scale);
			pen.up();
			pen.move(-40 * scale, (i - 40) * scale);
			pen.down();
			pen.move(40 * scale, (i - 40) * scale);
		}
		

		
		for(int i = 0; i < solution.length; i++){
			pen.up();
			pen.move((solution[i][0] * 10 - 35) * scale, (solution[i][1] * 10 - 35) * -scale);
			pen.down();
			pen.drawCircle(3 * scale);
		}
	}
	
	private void createNonAnswers(int[][] array){
		int[][] one = createRotation(array);
		int[][] two = createRotation(one);
		int[][] three = createRotation(two);
		nonSolutions.add(array);
		nonSolutions.add(one);
		nonSolutions.add(two);
		nonSolutions.add(three);
		
		for(int i = 0; i < 4; i++){
			if(i == 0){
				int[][] yReflection = createReflection(array);
				nonSolutions.add(yReflection);
			}
			if(i == 1){
				int[][] yReflection = createReflection(one);
				nonSolutions.add(yReflection);
			}
			if(i == 2){
				int[][] yReflection = createReflection(two);
				nonSolutions.add(yReflection);
			}
			if(i == 3){
				int[][] yReflection = createReflection(three);
				nonSolutions.add(yReflection);
			}
		}
	}
	
	private int[][] createReflection(int[][] array){
		int[][] newArray = new int[8][2];
		for(int i = 7; i >= 0; i--){
			double xDistance = 3.5 - array[i][0];
			double newX = xDistance + 3.5;
			newArray[i][0] = (int) newX;
			newArray[i][1] = i;
		}
		return newArray;
	}
	
	private int[][] createRotation(int[][] array){
		int[][] newArray = new int[8][2];
		for(int i = 7; i >= 0; i--){
			for(int x = 0; x < array.length; x++){
				if(array[x][0] == i){
					newArray[Math.abs(array[x][0] - 7)][0] = array[x][1];
					newArray[Math.abs(array[x][0] - 7)][1] = Math.abs(array[x][0] - 7);
				}
			}
		}
		return newArray;
	}
	
	private boolean isSolutionChosenBefore(int[][] queenPositions){
		for(int i = 0; i < nonSolutions.size(); i++){
			if(Arrays.deepEquals(nonSolutions.get(i), queenPositions)){
				return true;
			}
		}
		return false;
	}
}






























/*

	private int[][] createReflectionAcrossXAxis(int[][] array){
		int[][] newArray = new int[8][2];
		for(int i = 7; i > 0; i--){
			double xDistance = 3.5 - array[i][0];
			double yDistance = 3.5 - array[i][1];
			double newX = xDistance + 3.5;
			double newY = yDistance + 3.5;
			newArray[i][0] = array[i][0];
			newArray[i][1] = (int) newY;
		}
		return newArray;
	}
	
	
	int[][] num = {
				{6, 0},
				{4, 1},
				{2, 2},
				{0, 3},
				{5, 4},
				{7, 5},
				{1, 6},	
				{3, 7}
		};
		int[][] num2 = {
				{4, 1},
				{6, 0},
				{2, 2},
				{0, 3},
				{5, 4},
				{7, 5},
				{1, 6},	
				{3, 7}
		};
*/