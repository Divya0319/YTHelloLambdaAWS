package com.fastturtle.YtHelloLambda;

import java.util.Arrays;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fastturtle.YtHelloLambda.LeftRotateArrayByDPlaces.RequestClass;;

public class LeftRotateArrayByDPlaces implements RequestHandler<RequestClass, String> {

	/**
	 * We first reverse starting d elements, then we reverse remaining elements after d position
	 * Then we reverse the whole resultant array
	 * 
	 * T.C. is theta(n) as theta(d)+theta(n-d)+theta(n) = theta(2n) = theta(n)
	 * S.C. is theta(1) as no extra space needed.
	 *
	 */
	static String leftRotateByDPlaces(int[] arr, int d) {
		
		int n = arr.length;

		reverse(arr, 0, d-1);
		reverse(arr, d, n-1);
		reverse(arr, 0, n-1);
		
		return Arrays.toString(arr);
		
	}
	
	static void reverse(int[] arr, int l, int r) {
		while(l < r) {
			int temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			l++;
			r--;
		}
	}
	
	@Override
	public String handleRequest(RequestClass input, Context context) {
		int[] arr = input.getArr();
		int d = input.getD();
		return leftRotateByDPlaces(arr, d);
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		int d = 3;
		leftRotateByDPlaces(arr, d);
		System.out.print("Left rotated Array by " + d + " places: " + Arrays.toString(arr));
		
	}
	
	public static class RequestClass {
		private int[] arr;
		private int d;
		
		public int[] getArr() {
			return arr;
		}
		public void setArr(int[] arr) {
			this.arr = arr;
		}
		public int getD() {
			return d;
		}
		public void setD(int d) {
			this.d = d;
		}
		
	}

}
