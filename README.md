------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in wordPlay/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile wordPlay/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile wordPlay/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile wordPlay/src/build.xml run -Darg0="input.txt" -Darg1="output.txt" -Darg2="metrics.txt"

Note: Arguments accept the absolute path of the files.


-----------------------------------------------------------------------
## Description:
Assumptions:
1. Input file is well formatted with sentences that are equally spaced between two words and ends with a period.
2. Absoulte path of the files to be passed as input arguments while executing the program.
3. Input arguments to the run command are in the order input.txt file path, output.txt file path, metrics.txt file path.

Data structures:
  Arrays - Used character array for storing characters of each word and reversing the characters of the string. Also used for average number of characters.
  Arrays - Used for storing words for finding the longest word.
  HashMap - Used for storing words as key and count of frequency.
  TreeMap - Used for sorting the words by implementing the Comparator interface to compare the value associated with the key for sorting the TreeMap.
External Materials:
  Used HashMap, TreeMap as well as implementing the Comparator interface's compare method to find the most frequent words in the sentence.
Compiling:
  Follow the instruction as mentioned above.
Run:
  Follow the instructions as mentioned above.
Code working:
  The contents of input text file are read charcter wise and once a period character appears, store the sentence and process it accordingly.
  The sentence is written character wise in the output files.


-----------------------------------------------------------------------



