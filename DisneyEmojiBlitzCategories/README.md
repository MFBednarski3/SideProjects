# Disney Emoji Blitz Category Helper
One of my favorite app games that I play almost every morning and evening is called "Disney Emoji Blitz".
This app is basically a match-3 game and it allows you to collect emojis that are Disney-themed and not only allows you to
play with them but also send them as a sticker in a text message. One of the features in this game are missions where
you complete missions to level up and to get higher scores. Unfortunately, the game lacks the ability to tell which emojis count
for different categories (for example, Red emojis or Jewelry emojis). I also like doing multiple missions at once and I wanted to 
combine multiple categories to see if it would be possible to do the task.

Using an SQLite database that I plan to update every time a new update comes out, I created a Java program that allows this to happen.

### Functional Requirements
This program uses **JavaSE-11**, **JDK 12.0.2**, and **sqlite-jdbc-3.27.2.1.jar**.

### How to Run
1. Place the jar file anywhere you like.
2. Click on the jar file to run it. 
If it doesn't work:
3. Using command prompt or Terminal go to the directory that contains the jar file
4. Run the file as `java -jar DisneyEBGUI.jar`

### What's next?
I plan to update this almost every month when new major updates come out. In addition, I hope to add in pictures to correspond
to the boxes and emojis. Another possiblity is using an emoji checklist filter to use the results based on the emojis you have.
As of now, I do not have any intention into making this into a mobile app.
