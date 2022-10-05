<table><tr><td> <em>Assignment: </em> IT114 - Number Guesser</td></tr>
<tr><td> <em>Student: </em> Nadia Manoppo (nm94)</td></tr>
<tr><td> <em>Generated: </em> 10/5/2022 12:35:17 AM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-007-F22/it114-number-guesser/grade/nm94" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <ol><li>Create the below branch name</li><li>Implement the NumberGuess4 example from the lesson/slides</li><li>Add/commit the files as-is from the lesson material (this is the base template)</li><li>Pick two (2) of the following options to implement</li><ol><li>Display higher or lower as a hint after a wrong guess</li><li>Implement anti-data tampering of the save file data (reject user direct edits)</li><li>Add a difficulty selector that adjusts the max strikes per level</li><li>Display a cold, warm, hot indicator based on how close to the correct value the guess is (example, 10 numbers away is cold, 5 numbers away is warm, 2 numbers away is hot; adjust these per your preference)</li><li>Add a hint command that can be used once per level and only after 2 strikes have been used that reduces the range around the correct number (i.e., number is 5 and range is initially 1-15, new range could be 3-8 as a hint)</li><li>Implement separate save files based on a "What's your name?" prompt at the start of the game</li></ol><li>Fill in the below deliverables</li><li>Create an m3_submission.md file and fill in the markdown from this tool when you're done</li><li>Git add/commit/push your changes to the HW branch</li><li>Create a pull request to main</li><li>Complete the pull request</li><li>Grab the link to the m3_submission.md from the main branch and submit that direct link to github</li></ol></td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Implementation 1 (one of the picked items) </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Two Screenshots: Add a screenshot demonstrating the feature during runtime; Add a screenshot (or so) of the snippets of code that implement the feature</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/193980628-fd511802-03f2-4372-aae1-a09a23212fc8.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Code screenshot with clear comments<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/193980848-80475db6-44bb-4b42-99e1-5fa021e0bc4b.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Screenshot from running the program<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain the logic behind your implementation</td></tr>
<tr><td> <em>Response:</em> <p>I implemented my code in the &#39;privare void processGuess(int guess)&#39; class because this<br>is the main chunk of code that determines if the user&#39;s guess was<br>incorrect or correct. My added two feature implementations, the code now gives the<br>user two hints after an incorrect guess. One feature tells the user to<br>guess higher or lower, using a series of if statements.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Implementation 2 (one of the picked items) </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Two Screenshots: Add a screenshot demonstrating the feature during runtime; Add a screenshot (or so) of the snippets of code that implement the feature</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/193980628-fd511802-03f2-4372-aae1-a09a23212fc8.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Code screenshot with clear comments<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/193980848-80475db6-44bb-4b42-99e1-5fa021e0bc4b.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Screenshot from running the program<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain the logic behind your implementation</td></tr>
<tr><td> <em>Response:</em> <p>As said before, I also implemented this code in the &#39;privare void processGuess(int<br>guess)&#39; class because this is the main chunk of code that handles the<br>guess process. So therefore, the second feature, tells the user how close they<br>are to a number, i.e. hotter (if the number difference is less than<br>5), warmer (if the number difference is less than 10), and colder (if<br>the number difference is anything higher than 10)--all this using yet another if<br>statements.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add a link to the related pull request of this hw</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/nmanoppo/IT114-007/pull/4">https://github.com/nmanoppo/IT114-007/pull/4</a> </td></tr>
<tr><td> <em>Sub-Task 2: </em> Discuss anything you learned during this lesson/hw or any struggles you had</td></tr>
<tr><td> <em>Response:</em> <p>When completing this task, I first struggled with getting my code running in<br>the first place. However, through the help of the professor we figured out<br>that it was a cache problem. Second, I struggled with trying to find<br>where I needed to implement my lines of codes. However, after running my<br>code over and over again, I was able to understand how the code<br>is written and where to implement the necessary code.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-007-F22/it114-number-guesser/grade/nm94" target="_blank">Grading</a></td></tr></table>