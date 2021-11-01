# BlackJack Project

## Description
Welcome to BlackJack! This is my 4th week project for Skill Distillery. This version of BlackJack operates like any other version. The game starts off with a nice banner and a menu with 3 options. to play you will type 1, to look at the rules, you will type 2, and to quit you will type 3. 

Once you have typed 1 to play, the game will welcome you and prompt you for your name. I have incorporated a monetary system as one of my stretch goals for this project. So next, the game will prompt you for the amount of money you would like to deposit. Once the money is deposited, you will get a confirmation of the amount deposited. Next, the deck will be created and shuffled and ready for play.

To begin playing a hand of BlackJack, you will need to place a bet. Once your bet is placed you will press Enter, to deal the cards. Cards are dealt in order from the player to the dealer and then player and dealer again. Dealer's first card is face down [hidden] at the start of the game. 

Once the hands have been dealt, you have the option to hit or stay. You may hit until you decide to stay or you have busted.(hand total exceeds 21. If you have 21(BlackJack) after the deal, the game will check to see if the dealer has BlackJack as well. If the dealer has BlackJack too, then the game will result in a push and you will have your bet returned to you. If the dealer does not have BlackJack when you have BlackJack, you will win 1.5 times your original bet. After your turn is completed and you have decided to stand or busted, the game will proceed to the dealers turn. As the dealer is a function of the program, the turn is automatic based on 1 main rule. If dealer has to hit until their hand total is greater than 16. If the dealer busts, then you will win. If the the dealer decides to stand and you have not already busted, the game will compare your hand total to the dealers hand total and a winner will be decided. Depending on the outcome, you will either double your bet or lose your bet. Once the hand is over, the game will prompt the player to either play another hand, or quit.  

## Lessons Learned
Although this project was very involving, I had a lot of fun with programming it. Albeit, I spent the entire weekend working on it. But, after 3 versions and many lines of code being scrapped or re-written, I learned one main lesson. That is, the true functionality of OOP. It wasn't until this project that I realized how expansive programs can be and how beneficial it is to be able to create objects to reference fields and methods from one class to another. One additional thing I learned writing this program was the importance of methods returning values and assigning them to ensure that I was able to pass monetary variables throughout the program.

## Stretch Goals
I would like to add these additional functionalities to this program:

- Multiplayer capability
- Being able to choose whether and Ace is equal to 1 or 11
- Add a split and double down betting function to further the experience


## Technologies used
Java, Eclipse, Git