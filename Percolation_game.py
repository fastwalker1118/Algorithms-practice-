#Ran
#2020/11/10
#Percolation_game.py
#This is a 2 player percolation game where both player are trying to make a path from the top to the bottom by opening blocks
#This game is the application of the classic algorithm Quick union (making a tree through changing the array element that was the same with the index)
#more detailed description about how the game works are in the output

#this function returns the root of i (i stands for the index in the id array)
def root(i):
	while (i != id[i]): # tracks down to the root (as long as the element doesn't equal to it's index, I go the the upper level of the tree until the element is the same with it's index)
		i = id[i]
	return i  

#identical to root function but this one is for player 2
def root2(i) :
	while (i != id_player2[i]):
		i = id_player2[i]
	return i

#this function unions 2 elements on the array by changing the second ones length to the first one
def unionn(p, q): # p and q are the 2 indexs that we want to union
	i = root(p) 
	j = root(q)
	id[i] = j #changes the element in ith index to j so we know that they are connected

#identical to unionn function but this one is for player 2
def unionn2(p, q): 
	i = root2(p)
	j = root2(q)
	id_player2[i] = j
						     
#this function opens the block on the grid array
def open(row, col): #the parameters are real world indexs / doesn’t include 0
	grid[row-1][col-1] = True 
	#the code below checks if any of the adjacent blocks are opened, if they are we connect them by calling the union function 
	
	if (row - 2 >= 0): #checks if the element is on the first row
		# the above element has to be opened on the grid array but not on the grid_player2 array for us to connect the above elements with the chosen element
		if (grid[row-2][col-1] == True and grid_player2[row-2][col-1] != True) : 
			unionn((row-1)*length + col - 1, (row-2)*length + col - 1)  #connects the two

	#the following if statements are the same with the the first if statement, except they checks for the other 3 sides of the chosen block
	if (col - 2 >= 0) : #the left one
		if (grid[row-1][col-2] == True and grid_player2[row-1][col-2] != True) :
			unionn((row-1)*length + col - 2,(row-1)*length + col - 1)
	if (col + 1 <= length) : #the right one
		if (grid[row-1][col] == True and grid_player2[row-1][col] != True) :
			unionn((row-1)*length + col - 1,(row-1)*length + col - 2)
	if (row + 1 <= length) : #the below one
		if (grid[row][col-1] == True and grid_player2[row][col-1] != True) :
			unionn((row)*length + col - 1,(row-1)*length + col - 1)	
			
#identical to unionn function but this one is for player 2
def open2(row, col): 
	if(grid[row-1][col-1] == False):
		grid[row-1][col-1] = True 
		grid_player2[row-1][col-1] = True #also opening the block on the grid_player2 array because to identidy player 1 and 2's blocks on the grid arrau
	if (row - 2 >= 0) :
		if (grid_player2[row-2][col-1] == True) :
			unionn2((row-1)*length + col - 1, (row-2)*length + col - 1)
	if (col - 2 >= 0) :
		if (grid_player2[row-1][col-2] == True) :
			unionn2((row-1)*length + col - 2,(row-1)*length + col - 1)
	if (col + 1 <= length) :
		if (grid_player2[row-1][col] == True) :
			unionn2((row-1)*length + col - 1,(row-1)*length + col - 2)
	if (row + 1 <= length) :
		if (grid_player2[row][col-1] == True) :
			unionn2((row)*length + col - 1,(row-1)*length + col - 1)	
	
#return true if player1's block percolates (percolate here means that the play has reached to the bottom from the top)
def percolates():
	result = 0 #this variable is made to represent the result (1 is true, 2 is false)
	for j in range(length): #i represents the top level elements in the id array
		for i in range(length * (length - 1), length*length, 1): #i represents the bottom row elements
			if(root(i) == j) : #checks if the root of any bottom row elements is one of the top row elements
				result = 1 
	if(result == 1) : return True
	else : return False

#same with the percolate function / return true if player2's block percolates 
def percolates2():
	result = 0 
	for j in range(length):
		for i in range(length * (length - 1), length*length, 1):
			if(root2(i) == j):
				h = 1
	if(result ==1) : return True
	else : return False

#I use this array that will be filled with elements that are the same with the index to keep track of the blocks' connection
id = []
#same purpose with id array except that this is for player 2
id_player2 = [] 
#this array is going to be a 2d array and keeps track of which block is opened 
grid = [] 
#I made this array for player 2 becasue the percolation2 function needs a different array
grid_player2 = [] 

#prints out the instructions
print("hello, this is a 2 player game is called percolation, there is going to be a n*n grid all blocked initially")
print("you can choose the open a grid by typing that grid's row and colume length")
print("your goal is to start from the top and create a path by opening blocks to reach to the bottom")
print("not that 2 blocks can only be connected if you that are adjacent to each other horizontally or vertically (NOT DIAGONALLY)")
print("your opponent (player2) has the same goal, whoever reaches the bottom first wins the game!")
print()
print("now please enter a length n to generate a n*n grid")

length = int(input()) #this variable is the length of the grid

#this for loop makes grid array a 2d array and make all the elements False
for i in range(length): 
	grid.append([])
	for j in range(length):
		grid[-1].append(False)

#this for loop makes grid_player2 array a 2d array and make all the elements False
for i in range(length):
	grid_player2.append([])
	for j in range(length):
		grid_player2[-1].append(False)

#intializes id array with all the elements equal to it's index, and have length^2 elements
for i in range(length*length):
	id.append(i)

#initializes id_player2 array same way as id array
for i in range(length*length):
	id_player2.append(i)


while(True): #creates a infinite loop unless break keyword appears

	print("here's how the current grid looks like")
	#prints the current grid to let the user see how to grid looks like
	for i in range(length):
		for j in range(length):
			if(grid[i][j] == False):
				print('.  ', end='')
			elif(grid_player2[i][j] == True):
				print('x  ', end='')
			else:
				print('o  ', end='')
		print() 

	print("please enter the row number your block is at")
	row = int(input()) #takes the row number as input and assign it to row variable
	print("please enter the colume number your block is at")
	col = int(input()) #takes the colume number as input and assign it to col variable
	open(row, col) #calls the open function with row and col variable as arguments to open the grid

	print("here's how the current grid looks like")
	#prints the grid array again to show the user how it looks like
	for i in range(length):
		for j in range(length):
			if(grid[i][j] == False):
				print('.  ', end='')
			elif(grid_player2[i][j] == True):
				print('x  ', end='')
			else:
				print('o  ', end='')
		print()

	#checks is the block percolates yet
	if(percolates() == True): 
		print("congratulation player 1, you win!")
		break #breaks the while loop and prints congratulation if it percolates

	print("now it's player2's turn, please enter the row number your block is at")
	row2 = int(input()) #takes player2's row number as input and assign it to row2 variable
	print("please enter the colume number your block is at")
	col2 = int(input()) #takes player2's colume number as input and assign it to col2 variable
	open2(row2,col2) #calls the open2 function with row and col variable as arguments to open the grid

	#checks if player2's block percolates
	if(percolates2() == True):
		print("congratulation player 2, you win!")
		break #if it does, break the loop and print congratulations

	count = 0; #count variable is to keep track of how many blocks are opened
	#scan thruogh every element of the grid array
	for i in range(length):
		for j in range(length):
			if(grid[i][j] == True):
				count += 1 #add 1 to the count variable if a block is opened
	#if count equal to length squared then that means all blocks are opened and of both player's block doesn't percolate then its a tie
	if (count == length*length and percolates() == False and percolates2() == False):
		print("it's a tie!")
		break #breaks the loop

