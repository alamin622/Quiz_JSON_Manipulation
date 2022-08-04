# Quiz_JSON_Manipulation

## You can watch the program by playing the video.


https://user-images.githubusercontent.com/56792623/182957470-7fb8ce35-7dc0-4d54-b3a1-6fef705f6f96.mp4


Create a quiz program that will take questions, option and answer from admin user and save it to the question bank. Then if any user want to give the quiz, random 5 questions will be shown to the user from the question bank.

Program output:
1. Add Quiz
2. Start Quiz

if user select option 1, then system will tell user to input a question, 4 options and correct ans to save data in a quiz bank. The quiz bank will be a json file. For an example,

System>Please add a ques here:
User>Which testing is done by developer?
System>Input options.
Option a:
User> Unit Testing
Option b:

User> Integration Testing
Option c:

User> Sanity Testing
Option d:

User> Regression Testing
System> Please input the correct ans
User> a
System: Quiz saved at the database. Do you want to add more? (y/n)
if user press y, then the previous scenario will happen again otherwise the program will be closed.

If user select option 2,  then,
System> You will be asked 5 questions, each questions has 1 marks
1. Which testing is done by developer?
a. Unit Testing
b. Integration Testing
c. Sanity Testing
d. Regression Testing
User> a
System> Correct!
else not correct,
System: Not correct


Finally 5 different random questions will appear from your question database. At least add 20 questions from any category from testing.
Result: You got [correct_marks] out of 5


JSON Format:
[
{
"Question":"Which testing is done by developer?",
"option a":"Unit Testing",
"Option b":"Integration Testing",
"Sanity Testing":"Sanity Testing",
"Option d":"Regression Testing",
"answer":"a"
},
{
"Question":"Which is functional testing?",
"option a":"Load Testing",
"Option b":"Security Testing",
"Sanity Testing":"Gorilla Testing",
"Option d":"Benchmark Testing",
"answer":"c"
}
]
