Game of Life Rules: 
https://github.com/marcoemrich/game-of-life-rules/blob/master/gol_rules.pdf

---
###Thinking process 
Game of Life 
Empty Grid -> All the cells are dead 
Ask from the input (A list of Coordinates to decide which cells are alive) 
Based on the rules 
getTheNextGenra
Generation Zero -> Generation 1 -> Generation 2

Test 1: produce an empty grid which accept the length and width 
Test 2: produce Generation zero 
Test 3: count the neighbours Live Cells 
Test 4: Will Cell be alive in next Generation
---
###DEMO
````
                  Welcome to Conway's Game of Life!
                  How big would you like your grid:
                  Please enter the width:
                  5
                  Thank you!
                  Please enter the height:
                  5
                  Thank you!
                  Please input your live cell(s) coordinates:
                  1,2 2,2 3,2
                  How many generations will it run: 
                  3
                  Thank you!
                  .....
                  ***..
                  .....
                  .....
                  .....
                  
                  .*...
                  .*...
                  .*...
                  .....
                  .....
                  
                  .....
                  ***..
                  .....
                  .....
                  .....
                  
                  Thank for playing, the generation ends!
````

Game of Life UML diagram: 
<img src="https://github.com/DemiJiang/java-excercise/blob/master/conways-gameoflife/docs/gameoflifeuml.png" width="800" />

