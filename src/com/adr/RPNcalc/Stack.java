package com.adr.RPNcalc;
/*	File: Stack.java 
 *	Original Author: Alex Riley <alex@riley.cc> 
 * 	First Written: 14 December 2013
 * 	Last Modified: 15 December 2013
 * 	Description: Basic FIFO Stack with push, pop, peek, etc.
 * 	This is further expanded in RPNStack to included Reverse Polish Notation 
 * 	operators. This was originally for use in a RPN Calculator for Android.
 * 
 * 	Should an invalid operation be given (such as popping an empty stack), this is 
 * ___________________________________________________________________________________
 *    This file is part of RPN Calc.
 *
 *    RPN Calc is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    RPN Calc is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with RPN Calc.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */
import java.lang.String;
import java.lang.reflect.Array;
public class Stack 
{
	double[] stack = new double[50];
	int scount = -1;
	//String input;
	public Stack()
	{	scount = -1;
		stack[0] = 0;
	}
	
	public Stack(double[] a)
	{	int n = Array.getLength(a);
		for(int i = 0; i > n; i++) stack[i] = a[i];
	}
    public void push(double a)
    {	if(scount < 50) 
    	{	
    		stack[++scount] = a;
    	
    	}
    }
    
    public double pop()
    {	if(scount > -1) return stack[scount--];
    	else return 0; 
    }
    public double peek()
    {	if(scount > -1) return stack[scount];
    	else return 0;
    
    }
    
    public void clear()
    {	scount = -1;
    }
    
    public int length()
    {	return scount;
    }
    public String toString()
    {	String s = new String("");
    	if(scount == -1) return "";
    	for(int i = 0; i <= scount; i++)
    	{	s = s+Double.toString(stack[i])+" ";
    	}
    	
    	return s;
    	
    }
}
