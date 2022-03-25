# Bulls And Cows

### *Game description*
*Let's start by reminding ourselves how the game goes.
There are two players: the first writes a secret 4-digit code using different digits, and the second has to guess it.
At each turn, the second player writes a 4-digit number that they think might be the correct answer. 
Then, the first player grades that answer using bulls and cows as a notation. 
If a digit in the given answer matches a digit and its position in the code, it's called a "bull." 
If a given digit appears in the code but its position doesn't match, then it's called a "cow." 
The first player reveals how many bulls and cows there are. 
The information is general; in other words, it isn't bound to any particular digit. For example:*

*The code is 4931.*

*The answer is 1234.*

*The grade is 1 bull and 2 cows.*

*Here, 3 is a bull, 1 and 4 are cows. 
If all the digits are bulls, the secret code has been guessed and the game ends.
If not, the game continues and the second player tries again.*


## About

Some players need a challenge, so let's make the secret code in the game harder to guess.

Now, the secret code can contain the numbers `0-9` and the lowercase Latin characters `a-z`. The maximum length for the code is `36`.

### Program should:

* Ask for the length of the secret code.
```
Input the length of the secret code:
> 4
```
* Ask for the range of possible characters in the secret code.
```
Input the number of possible symbols in the code:
> 16
```
* Generate a secret code using numbers and characters. Print the secret code using `*` characters and print which characters were used to generate the secret code.
```
The secret is prepared: **** (0-9, a-f).
```
### Examle
```
Input the length of the secret code:
> 4
Input the number of possible symbols in the code:
> 12
The secret is prepared: **** (0-9, a-b).
Okay, let's start a game!
Turn 1:
> a234
Grade: 1 bull and 1 cow
Turn 2:
> 73b4
Grade: 2 bulls and 1 cow
Turn 3:
> 9374
Grade: 4 bulls
Congratulations! You guessed the secret code.
```

### Also:
* Handle incorrect input. Print an error message that contains the word `error`. After that, don't ask for the numbers again, just finish the program.

### Examle 1
```
Input the length of the secret code:
> 6
Input the number of possible symbols in the code:
> 5
Error: it's not possible to generate a code with a length of 6 with 5 unique symbols.
```
### Examle 2
```
Input the length of the secret code:
> abc 0 -7
Error: "abc 0 -7" isn't a valid number.
```
### Examle 3
```
Input the length of the secret code:
> 6
Input the number of possible symbols in the code:
> 37
Error: maximum number of possible symbols in the code is 36 (0-9, a-z).
```
