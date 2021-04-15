
# Java-Albums
Implemented a Java class to represent an album using a UML representation.




## NetBeans 8 project 
 Java 8 program that opens and reads a delimited data file that is located relative to the NetBeans project root folder. The delimited data file contains information about prize winning music albums ranked by sales. The data file is called albums.txt. The data file should not be altered and should be considered as a read-only data file.
Within the ‘albums’ data file, there are 20 entries that each represent a single album. On the first line of each album entry there are six data fields representing the following information (in order): the current sales ranking, the title of the album, the name of the artist, the year the album was released, and the total number of sales to date (‘M’ denotes million and ‘K’ denotes thousand). The first line is then followed by the list of song tracks for the album (one per line, in the original published order), with each track indicating the duration of the song (minutes:seconds) in braces. Each album entry is separated by a dashed line in the text file.

You are required to implement a Java class to represent an album. The program should parse the data file, create an object for each album, and store all the objects into a suitable collection. Figure 3 provides a partial UML class representation of the class that you will need to implement. It indicates required data members and accessor (i.e., getter) methods that map to those data members, and a toString() method. It is left to you to determine class data types and how the Album objects should be initialised.
Figure 3: UML class specification for Album class

Once all the objects are loaded into the collection, the program should present the User with a consolebased menu to interact with the data set. This menu should loop until the User enters a character to exit the menu (e.g., zero as illustrated below). In addition to an exit option, the menu should offer three other options: list all albums, select a single album to view, and search in song titles.
2On starting the program, the following menu should be displayed to the console:

List albums.........1 Select album........2 Search titles.......3 Exit................0
Enter choice:>

The User can simply exit the program by entering zero. The three other menu options allow the User to inspect the information in the data set (note again that this program is entirely read-only and there is no requirement to add, update or delete any part of the data set). The necessary interaction of the program with respect to these options is illustrated in Appendix A. Note that console output should be neatly formatted, and some consideration will be given to formatting when the program is assessed. In particular, when the option to view a single trade company details is selected, it must result in the invocation of the toString() method for that particular Album object. You are encouraged to explore and utilise a StringBuilder object when implementing the toString() method for the Album class.

option 1 :

![list albums](https://user-images.githubusercontent.com/81979801/114888411-1cc8a700-9e01-11eb-9cf1-19805d682bac.PNG)

option 2 :

![select albums](https://user-images.githubusercontent.com/81979801/114888472-2ce08680-9e01-11eb-8ebd-6ed451cc4d68.PNG)

option 3 :

![search](https://user-images.githubusercontent.com/81979801/114888510-35d15800-9e01-11eb-904a-25f32bd99dac.PNG)
