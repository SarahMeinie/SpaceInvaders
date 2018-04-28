1) Compiled and run
	- Libraries used: 'stdlib.jar'
	- Main class for compilation: 'Invaders'
	- Main class to run: 'Invaders'

2) Interface inheritance:
The interface 'Critter.java' is implemented by 'DefaultCritter.java' where the methods 'rotate_anti()', 'rotate_clock()', 
'move_right()' and 'move_left()' are definded. These methods are then used by 'shooter.java' which is a subclass of 'DefaultCritter.java'.

3) Class inheritance and polymorphism:
'DefaultCritter.java' is the parent class of 'Enemy.java', 'Shooter.java', 'Missile.java', 'Health.java' and 'Lives.java'. 
All of these classes use the constructor of the parent class to creat an object. This follows that these objects have the 
subtype of the particular class and of the type of the parent class 'DefaultCritter' as well. This is known as polymorphism. 
Thus, every object of the subclass has access to the methods of the parent class as indicated under 2).

4) Additional work:
	- Multiplayer mode
	- Different types of shooters, see also multiplayer mode
	- Leaderboard
	- Score
	- Extra Lives
	- Improved graphics
	- Hit-Points for a certain type of enemies
	- Different types of enemies; see also Hit-Points
	- Special sound when game over
	- Special sound when game won
	- 

5) Additional libraries
	- stdlib.jar
		Usage of 'StdDraw.java' is essential for the program

6) Changes to standard library
	- none

7) Diagrams illustrating the classes in your project and their dependencies.

'Critter.java' (Interface) is implemented by  'DefaultCritter.java' parent class for:
	- Enemy.java
	- Shooter.java
	- Miissile.java
	- Health.java
	- Lives.java

'InvaderGameState.java' is client for:
	- DefaultCritter.java
	- Enemy.java
	- Shooter.java
	- Miissile.java
	- Health.java
	- Lives.java

'Invaders.java' is client for:
	- InvaderGameState.java














