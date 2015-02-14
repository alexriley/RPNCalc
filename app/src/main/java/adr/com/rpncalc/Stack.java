package adr.com.rpncalc;
/*	File: Stack.java 
 *	Original Author: Alex Riley <alex@riley.cc>
 * 	Description: Basic LIFO Stack with push, pop, peek, etc.
 * 	This is further expanded in RPNStack to included Reverse Polish Notation 
 * 	operators.
 * 
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
 *    along with RPN Calc. If not, see <http://www.gnu.org/licenses/>.
 * 
 */
import java.lang.String;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Stack
{
    private int STACKSIZE = 8;
	double[] stack;
	int scount;

	public Stack(double[] OldStack, int OldScount)
	{	scount= OldScount;
        stack=OldStack;
        STACKSIZE = stack.length;
		//for(int i = 0; i > n; i++) stack[i] = a[i];
	}
    public Stack()
    {	stack = new double[STACKSIZE];
        scount = 0;
        stack[0] = 0;
    }
    public void push(double a)
    {	if(scount >= STACKSIZE-2)
    	{	ExpandStack();
    	}
        stack[scount] = a;
        scount++;
    }
    private void ExpandStack()
    {   double[] OldStack = stack;
        stack = new double[STACKSIZE * 2];
        for(int x=0; x<STACKSIZE-1;x++) stack[x] = OldStack[x];
        STACKSIZE *=2;
    }
    private void ContractStack()
    {   double[] OldStack = stack;
        stack = new double[STACKSIZE/2];
        for(int x=0; x<(STACKSIZE/2);x++) stack[x] = OldStack[x];
        STACKSIZE /= 2;

    }
    public double pop()
    {	if(scount < STACKSIZE / 4 && STACKSIZE > 8) ContractStack();
        if(scount > 0) return stack[--scount];
    	else return 0; 
    }
    public double peek()
    {	if(scount > 0) return stack[scount - 1];
    	else return 0;
    
    }
    
    public void clear()
    {	scount = 0;
    }
    
    public int length()
    {	return scount;
    }
    public String toString()
    {	String s = new String("");
    	if(scount == 0) return "";
    	for(int i = 0; i < scount; i++)
    	{	if(stack[i] == (long)stack[i]) //testing if stack[i] is an Integer (so that 3 is printed instead of 3.0)
                s=s+String.format("%d", (long)stack[i]) + " ";
            else s = s+String.format("%.4f", stack[i])+" ";
    	}
    	
    	return s;
    	
    }
    public double[] getStack() //When numbers are popped from stack, they are not removed, only scount is decremented
    {   for(int n = this.scount; n < STACKSIZE; n++) stack[n] = 0;// this removes those numbers when returning the array
        return stack;
    }

}
