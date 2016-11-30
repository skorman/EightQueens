import java.util.ArrayList;
import java.util.Arrays;

import gpdraw.DrawingTool;
import gpdraw.SketchPad;

public class EightQueens {
	
	private int[][] queenPositions = new int[8][2];
	private ArrayList<Integer> temp = new ArrayList<Integer>();
	private ArrayList<int[][]> solutions = new ArrayList<int[][]>();
	private ArrayList<int[][]> things = new ArrayList<int[][]>();
	
	
	
	public void getEightQueens(){
		
		for (int i = 0; i < 8; i++){
			queenPositions[i][1] = i;
		}
		
		int[][] num = {
				{217, 0},
				{6, 1},
				{5, 2}, 
				{4, 3},
				{3, 4},
				{2, 5},
				{1, 6},
				{0, 7}
		};
		//System.out.println(isSolution(num));
		
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
																
																		queenPositions[0][0] = first;
																		queenPositions[1][0] = second;
																		queenPositions[2][0] = third;
																		queenPositions[3][0] = fourth;
																		queenPositions[4][0] = fifth;
																		queenPositions[5][0] = sixth;
																		queenPositions[6][0] = seventh;
																		queenPositions[7][0] = eigth;
																		
																		if (isSolution(queenPositions)){
																			//print(queenPositions);
																			//System.out.println("temp: " + temp);
																			//System.out.println();
																			things.add(queenPositions);
																			//print(solutions.get(solutions.size() - 1));
																			//System.out.println();
																			//System.out.println(solutions.size());
																			drawSolution(queenPositions);
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
		things.add(num);
				
		for(int i = 0; i < things.size(); i++){
			print(things.get(i));
		}
		//print(solutions.get(1));
		//drawSolution(num);
	}
	public void print(int[][] nums){
		for(int i = 0; i < nums.length; i++)
			System.out.println("solution: " + Arrays.toString(nums[i]));
	}
	
	private boolean isSolution(int[][] array){
		//print(array);
		for(int i = 0; i < array.length; i++){
			int[] firstQueen = array[i];
			//System.out.println("FirstQueen: " + Arrays.toString(firstQueen));
			for(int x = 0; x < array.length; x++){
				int[] secondQueen = array[x];
				//System.out.println("SecondQueen: " + Arrays.toString(secondQueen));
				if(firstQueen[1] != secondQueen[1]){
					double slope = (double)(firstQueen[1] - secondQueen[1]) / (firstQueen[0] - secondQueen[0]);
					//System.out.println("slope: " + slope);
					//System.out.println("FirstQueen: " + Arrays.toString(firstQueen));
					//System.out.println("SecondQueen: " + Arrays.toString(secondQueen));
					if (slope == 1 || slope == -1) return false;
				}
			}
		}
		return true;
	}
	
	private void drawSolution(int[][] solution){
		print(solution);
		SketchPad paper = new SketchPad(1000, 1000);
		DrawingTool pen = new DrawingTool(paper);
		
		double scale = 5;
		
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
			System.out.println(solution[i][0]);
			pen.up();
			pen.move((solution[i][0] * 10 - 35) * scale, (solution[i][1] * 10 - 35) * -scale);
			pen.down();
			pen.drawCircle(3 * scale);
		}
	}
}





























/*
for(int first = 0; first < 7; first++){
	if(!temp.contains((Integer) first))temp.add((Integer) first);

	for(int second = 0; second < 7; second++){
		if(!temp.contains((Integer) second))temp.add((Integer) second);
		
		for(int third = 0; third < 7; third++){
			if(!temp.contains((Integer) third))temp.add((Integer) third);
			
			for(int tempIndex = 0; tempIndex < temp.size(); tempIndex++){
				queenPositions[0][0] = first;
				queenPositions[1][0] = second;
				queenPositions[2][0] = third;
				print(queenPositions);
				temp.clear();
			}
		}
	}
}
*/

/*
for (int i = 0; i < 7; i++){
	if(!temp.contains((Integer) i))temp.add((Integer) i);
}
*/



/*
 * 

for (int i = 0; i < 8; i++){
	queenPositions[i][1] = i;
}
print(queenPositions);


queenPositions[0][0] = first;
queenPositions[1][0] = second;
queenPositions[2][0] = third;
queenPositions[3][0] = fourth;
queenPositions[4][0] = fifth;
queenPositions[5][0] = sixth;
queenPositions[6][0] = seventh;
queenPositions[7][0] = eigth;
print(queenPositions);
System.out.println("temp: " + temp);
temp.remove(temp.size() - 1);
*/
