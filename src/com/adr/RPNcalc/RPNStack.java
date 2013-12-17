package com.adr.RPNcalc;

/*	File: RPNStack.java
 * 	Original Author: Alex Riley <alex@riley.cc>
 * 	First Written: 14 December 2013
 * 	Last Modified: 15 December 2013
 * 	Description: extending Stack, which is a basic FIFO Stack, to include 
 * 	Reverse Polish Notation operators. Reverse Polish Notation is based on
 * 	the notation written by Jan Łukasiewicz to create a parentheses-free 
 * 	mathematical notation. For example, the equation 8 + 16 in RPN would be
 * 	8 16 +. (In Polish notation it would be + 8 16). (21+7)*(6+2) in RPN is
 * 	21 7 + 6 2 + *. For more information, Google 'Reverse Polish Notation'.
 * ______________________________________________________________________________
 *     This file is part of RPN Calc.
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

public class RPNStack extends Stack
{
    public double op(char s)
    {	if(this.scount > 0)
    	{	double b=pop(),a=pop();
    		switch(s)
    		{	case '+':
    				push(a+b);
    				return a+b;
    			case '-':
    				push(a-b);
    				return a-b;
    			case '*':
    				push(a*b);
    				return(a*b);
    			case '/':
    				push(a/b);
    				return(a/b);
    			case '%':
    				push(a%b);
    				return(a%b);
    		}
    	}
    	return 0;
    }
}
