# Game of Life

About this Kata
The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970.
The "game" is a zero-player game, meaning that its evolution is determined by its initial state, requiring no further input. One interacts with the Game of Life by creating an initial configuration and observing how it evolves.

https://github.com/MYOB-Technology/General_Developer/tree/master/katas/kata-conways-game-of-life

Rules: 

1. Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
2. Any live cell with more than three live neighbours dies, as if by overcrowding.
3. Any live cell with two or three live neighbours lives on to the next generation.
4. Any dead cell with exactly three live neighbours becomes a live cell.
https://github.com/marcoemrich/game-of-life-rules/blob/master/gol_rules.pdf

### DEMO
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

## Getting Started

Clone the repo to your local machine then navigate to the root folder and run the program:

```
$ git clone https://github.com/DemiJiang/java-excercise/tree/master/conways-gameoflife
$ javac Main.java
$ java main
```

## UML diagram: 

<img src="https://github.com/DemiJiang/java-excercise/blob/master/conways-gameoflife/docs/gameoflifeuml.png" width="800" />

