RPNCalc
=======

Reverse Polish Notation for Android. Includes a java Stack with RPN operators.

README FOR RPN CALC
Original Author: Alex Riley <alex@riley.cc>
First created: 14 December 2013

This app is a Reverse Polish Notation calculator. Reverse Polish Notation is 
based on the prefix notation first invented by Polish logician Jan Łukasiewicz.
Rather than writing '1+2' for an equation, Reverse Polish Notation says '1 2 +'.
(Polish Notation would be '+ 1 2') This allows for equations without parentheses
or rules about order of operations. As numbers are stated, they are added to a 
LIFO stack. When an operator appears (such as '+', '-', '*'), 2 numbers from the
stack are popped, the operation is performed, and the result is pushed back onto 
the stack (Since the stack is LIFO, the result is now the next number to be 
popped out).
For example the equation (1+7)*(35/7) in Reverse Polish notation would be
	1 7 + 35 7 / *

The stack uses the type double (floating point), so decimal points are allowed.

This app is mostly an opportunity for me to relearn java, and learn a bit 
about android development. If you would like to use the source code for
something, it is licensed under GPLv2.
