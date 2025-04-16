package com.dsa.readinputs;

public class ReadInputs {
	
	public static int[][] parse2DArray(String input) {
        input = input.replace("[[", "").replace("]]", ""); // Remove outer brackets
        String[] rows = input.split("\\],\\["); // Split into rows

        int[][] matrix = new int[rows.length][];

        for (int i = 0; i < rows.length; i++) {
            String[] elements = rows[i].split(","); // Split row into elements
            matrix[i] = new int[elements.length];

            for (int j = 0; j < elements.length; j++) {
                matrix[i][j] = Integer.parseInt(elements[j].trim()); // Convert to integer
            }
        }

        return matrix;
    }
	public static int[] parseArray(String input) {
		input = input.replace("[", "").replace("]", "");
		String[] elements = input.split(",");
		int l = elements.length;
		int[] arr = new int[elements.length];
		for(int i=0; i<l; i++) {
			arr[i] = Integer.parseInt(elements[i].trim()); // Convert to integer  
		}
		return arr;
	}

}
