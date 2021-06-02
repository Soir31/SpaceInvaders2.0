# Daniel Obando's group Documentation

In this project we upgraded our Space Invaders version which was used in the first project. In the upraded version you will see two new enemy classes, one of those is a binary
search tree and the other one is an AVL tree. Also in this new version you can play with friends thanks to the new multiplayer option that was implemented using a server-client
connection with sockets. And not only the visual part of the game was upgraded, we also made some upgrades in the code but that will be explained at the end.

### Jira

We kept a record of the tasks we assigned to each member of the group and its progress in [Jira](https://spaceinvaders2.atlassian.net/jira/software/projects/P02/boards/1/backlog).
In here you can watch how the different tasks were made, the person in charge and the progress of how we developed the game. It also helped us to manage the amount of work that
each person of the group was assigned to do so that nobody got an overcharge of work. In this project there were three main tasks to do: the creation of two new enemy classes, 
to create a server-client connection and to upgrade the code. In the next image you can see the 3 main tasks mentioned before.
![Jira Preview](https://raw.githubusercontent.com/Soir31/SpaceInvaders2.0/main/Doc%20Images/Jira.PNG)

### Class Diagram

We also made a class diagram to have an idea of what we needed and what we wanted to do before starting to make the upgrades of the game. We made this class diagram with the 
knowledge that we have about Java, hierarchical data structures, and Object Orientation Programming so it does not represents the final result of the game but instead it 
represents the general idea of what we thought that was necessary to complete our objective of upgrading the game in a good way. Also in this class diagram we did not put, or 
left in blank the classes and methods that were used for the first project, we only put the new ones that were neccessary to develop the new version of the game.
![Class Diagram](https://raw.githubusercontent.com/Soir31/SpaceInvaders2.0/main/Doc%20Images/Class%20Diagram.png)

### Upgrades of the code

The first upgrade was to improve the part of the code in which we generate the enemies and assign the levels of the games. In this part in the previous project we had one only
method in which we generate the enemies and assigned the level at the same time. Now, in this project we made two different methods to do this task. In the next image you can 
see a little of the code we implemented to do this.
![Upgrade1](https://raw.githubusercontent.com/Soir31/SpaceInvaders2.0/main/Doc%20Images/upgrade1.png)

Other upgrade that we made for this project was the improvement of the E class enemies' collisions because in the previous project, the collisions sometimes didn't worked
correctly throwing some errors about not detecting the shoots from the player and sometimes the game just crashed when a shoot from the player hits the enemy. So for this
project we fixed all that and now it works correctly. This is some of the code that we used for fixing the problem:
![Upgrade2](https://raw.githubusercontent.com/Soir31/SpaceInvaders2.0/main/Doc%20Images/upgrade2.png)

And also regarding the movement of the E class enemies', we also made a little upgrade for the circular movement that it does. At first the code was a little of a disorder so
we made some changes and now it looks better but the movement is still the same. In the next picture you can look how the code looked in the first project.
![Upgrade4](https://raw.githubusercontent.com/Soir31/SpaceInvaders2.0/main/Doc%20Images/upgrade4.PNG)

### Made by:

* Fabián Jesús Castillo Cerdas 
* Erick Daniel Obando Venegas 
* José Andrés Quirós Guzmán
