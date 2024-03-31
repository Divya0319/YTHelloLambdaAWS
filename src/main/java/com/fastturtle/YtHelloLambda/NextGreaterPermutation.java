package com.fastturtle.YtHelloLambda;

import java.util.Arrays;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fastturtle.YtHelloLambda.NextGreaterPermutation.RequestClass;

public class NextGreaterPermutation implements RequestHandler<RequestClass, String> {
	
	public String nextGreaterPermutation(int[] arr) {
		int n = arr.length;
		
		int i = n-1;
		
		for(; i >= 0; i--) {
			if(arr[i-1] < arr[i]) {
				break;
				
			}
		}
		
		i--;
		
		for(int j = n-1; j > i; j--) {
			if(arr[j] > arr[i]) {
				// swap arr[i] with arr[j]
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				
				break;
			}
		}
		
		reversePartOfSubArray(arr, i+1, n-1);
		
		return Arrays.toString(arr);
		
	}
	
	public void reversePartOfSubArray(int[] arr, int s, int e) {
		while(s < e) {
			int temp = arr[s];
			arr[s] = arr[e];
			arr[e] = temp;
			
			s++;
			e--;
		}
	}
	
	@Override
	public String handleRequest(RequestClass input, Context context) {
		int[] arr = input.getArr();
		
		return nextGreaterPermutation(arr);
	}
	
	public static void main(String[] args) {
		NextGreaterPermutation ngp = new NextGreaterPermutation();
		int[] arr = new int[] {1, 2, 3, 7, 6, 5};
		ngp.nextGreaterPermutation(arr);
		System.out.println("Next greater permutation: " + Arrays.toString(arr));
	}
	
	public static class RequestClass {
		int[] arr;

		public int[] getArr() {
			return arr;
		}

		public void setArr(int[] arr) {
			this.arr = arr;
		}
		
	}

}
