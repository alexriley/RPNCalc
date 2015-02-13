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
{   public RPNStack()
    {   super();
    }

    public RPNStack(double[] OldStack, int OldScount)
    {   super(OldStack,OldScount);
    }
    public enum Operation {PLUS, MINUS, MULTIPLY, DIVIDE, MOD};
    //op() returns 1 if operation performed, 0 otherwise
    public int op(Operation operation)
    {	if(this.scount > 1)
    	{	double b=pop(),a=pop();
    		switch(operation)
    		{	case PLUS:
    				push(a+b);
    				return 1;
    			case MINUS:
    				push(a-b);
    				return 1;
    			case MULTIPLY:
    				push(a*b);
    				return 1;
    			case DIVIDE:
    				push(a/b);
    				return 1;
    			case MOD:
    				push(a%b);
    				return 1;
    		}
    	}
    	else return 0;
    	return 0;
    }

}
