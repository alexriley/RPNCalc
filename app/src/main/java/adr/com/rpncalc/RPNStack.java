package adr.com.rpncalc;

/*	File: RPNStack.java
 * 	Original Author: Alex Riley <alex@riley.cc>
 * 	Description: Reverse Polish Notation stack
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
{   //op() returns 0 if operation performed, 1 otherwise
    public int op(char s)
    {	if(this.scount > 1)
    	{	double b=pop(),a=pop();
    		switch(s)
    		{	case '+':
    				push(a+b);
    				return 0;
    			case '-':
    				push(a-b);
    				return 0;
    			case '*':
    				push(a*b);
    				return 0;
    			case '/':
    				push(a/b);
    				return 0;
    			case '%':
    				push(a%b);
    				return 0;
    		}
    	}
    	else return 1; 
    	return 1;
    }
}
