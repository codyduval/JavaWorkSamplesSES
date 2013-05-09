###Software Engineering at Scale - Java Work Samples

This is a collection of some of my work from General Assembly's 12-week [Software Engineering at Scale](https://generalassemb.ly/education/software-engineering-at-scale) course.  I took the course in the winter of 2012/2013.

Taught entirely in Java, the course aimed to replicate the topics taught in the first year or two of an undergraduate Computer Science curriculum.  This included topics like foundational data structures (eg arrays, lists, stacks, queues, trees, maps, graphs, etc), object oriented programming, algorithm analysis and Big "Oh" notation, basic algorithm design (using recursion, memoization, graph traversal, etc), databases, concurrency, threading, and performance testing.  

You can see the full course syllabus [here.](https://gist.github.com/codyduval/4741123)

####[NGram Text Generator](https://github.com/codyduval/JavaWorkSamplesSES/tree/master/codyd/NGramTextGenerator/src)
This program reads in the contents of a text file (such as the Constitution, an episode of Start Trek, or a presidential address), randomizes the words, and recombines them to create a nonsensical (yet almost readable) new document.

Under the hood, the text generator is using LinkedList to build a map of tri-grams (sets of three words that are next to each other in the original document).  The first two words of the tri-gram are stored as the key to the LinkedList with the third word as the payload (or value).  After printing a random trigram's key, the program searches the remaining nodes for a trigram that starts with the payload of the previous trigram.  And so it continues until all the trigrams are printed, with the result being a new (almost readable) script, speech, or document.

####[Library Manager](https://github.com/codyduval/JavaWorkSamplesSES/tree/master/codyd/LibraryBookManagment/src)
This simple program manages the inventory of an old-fashioned library, where patrons check out books, magazines, or other items.  It was our first practice with inheritance and object oriented design.

The main challenge centered around modeling the various objects in the program.  Since the various items that could be checked out shared some (but not all) properties, it made sense to create a single Item superclass with corresponding Book, DVD, and Magazine subclasses.  This allowed each subclass to inherit methods and properties common to all items while applying it's own specific characteristics.  The benefits include DRY and encapsulated code that is easier to maintain.

####[Restaurant Reservation System](https://github.com/codyduval/JavaWorkSamplesSES/tree/master/codyd/ReservationSystem/src)
This was an excercise to reinforce the principles (and benefits) of good object oriented design.  The application is designed to take in various types of reservations (be it from the phone, internet, or in person), store them in memory, and recall them by guest name.

In my solution, I implemented a single Reservation superclass with specific Phone, Internet, and InPerson subclasses.  Each subclass inherited properties common to all Reservations while defining properties unique to its own.  I stored the reservations in a HashMap with the guest's last name as the key, and the full reservation object as the value.  The HashMap allowed for O(1) performance in lookup time (ie, super fast).  

####[Dominoes](https://github.com/codyduval/JavaWorkSamplesSES/tree/master/codyd/Dominoes/src)
We built a Domino matching game to practice designing algorithms for building and searching graphs.  Given a bag of N random dominoes, the program starts with one domino and then searches the bag for another domino that matches the bottom number on the first domino.  The challenge is being able to design an algorithm that quickly searches through a large bag of dominoes to find a match.

My program generates X number of Domino objects and stores them in a HashMap with six keys, one for each possible value of a domino (1 to 6). Corresponding to each key is an ArrayList holding individual domino objects that have values that match that key.  The program when then play a random domino, checks its bottom value, and then looks in the HashMap under the key for that value for the next unplayed domino.  While the first lookup is O(1) performance, finding an unplayed domino in each value's corresponding ArrayList is O(N/3) performance (or essentially linear). So if I had 6000(N) dominoes, those would be divided into 6 buckets of 1000 dominoes each.  But since each domino has two values, it's stored twice, bringing each bucket to 2000.  Since these buckets are Arrays and it must iterate through them one by one, worst case complexity is ~2000 operations for 6000 dominoes (or O(N/3)).  Net net: my initial HashTable lookup has only a marginal effect on performance and the algorithm could be improved.

####[Words With Chums](https://github.com/codyduval/JavaWorkSamplesSES/tree/master/codyd/WordsWithChums/src)
Our final project was a Scrabble clone.  Each player receives 7 random letter tiles from a finite bag to start, and then plays them on an ASCII game board, in turn.  Words are scored based on the values of the letters played, and the game ends when all letters have been played.

This project was complex, and like any OO system, was really a number of smaller systems tied together.  Simply drawing a gameboard and regulating how and where a player could place a tile proved to be quite a bit of work.  In my implementation, each space on the gameboard was assigned an integer location.  As players put down a tile, an algorithm made a series of checks to see if it was valid (is it adjacent to another tile? is there already a tile there).  Once a word was played, the program then had to gather up every new possible word made by the move and check each against a dictionary.  If any of those words were not valid, the move was rejected and the player lost their turn.


