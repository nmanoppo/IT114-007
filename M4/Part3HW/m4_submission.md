<table><tr><td> <em>Assignment: </em> IT114 - Sockets Part 1 - 3</td></tr>
<tr><td> <em>Student: </em> Nadia Manoppo (nm94)</td></tr>
<tr><td> <em>Generated: </em> 10/12/2022 12:57:39 AM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-007-F22/it114-sockets-part-1-3/grade/nm94" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <ol><li>Create a new branch for this assignment</li><li>Go through the socket lessons and get each part implemented (parts 1-3)</li><ol><li>You'll probably want to put them into their own separate folders/packages</li></ol><li>Create a new folder called Part3HW</li><li>Create an empty m4_submission.md file in Part3HW (or skip this step and download the file at the end)</li><ol><li>Add/commit/push the branch</li><li>Create a pull request to main and keep it open</li></ol><li>Copy the the Part3 code into this new folder (Part3HW)</li><li>Git add/commit all of the sample code and the Part3HW code</li><li>Implement two of the following <b>server-side</b> activities for all connected clients (majority of the logic should be processed server-side and broadcasted to all clients if/when applicable)</li><ol><li>Simple number guesser where all clients can attempt to guess</li><ol><li>Hint: may want separate commands to start, stop, and guess (or starting lasts for x rounds then stops)</li><li>No need to implement complexities like strikes</li></ol><li>Coin toss command (random heads or tails)</li><li>Dice roller given a command and text format of "roll #d#" (i.e., roll 2d6)</li><li>Math game (server outputs a basic equation, first person to guess it correctly gets congradulated and a new equation is given)</li><ol><li>Hint: may want separate start, stop, answer commands (or starting lasts for x rounds then stops)</li></ol><li>Private message (a client can send a message targetting another client where only the two can see the messages)</li><li>Message shuffler (randomizes the order of the characters of the given message)</li></ol><li>Fill in the below deliverables</li><li>Save and generated the markdown or markdown file</li><li>Update the m4_submission.md file in the Part3HW folder</li><li>Add/commit/push your changes</li><li>Merge the pull request</li><li>From the M4-Sockets branch, navigate to your m4_submission.md file on github and copy the link</li><li>Submit the direct link to Canvas</li></ol></td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Baseline </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add as many screenshots as necessary to show basic communication among 3 clients and 1 server</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/195250727-16fb3d26-98ae-464a-9780-39ca60803c59.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Code is showing the server (compilation, and running process), as well as the<br>3 connected clients. Each client is shown to receive all the messages each<br>client stating my name, UCID, and date.<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Feature Implementation 1 </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> What feature did you pick? Briefly explain how you implemented it</td></tr>
<tr><td> <em>Response:</em> <ol><li>Coin toss command (random heads or tails)</li></ol><div>On the server side.java file, under the<br>process command function, I implemented the coin toss command. I did this by<br>first having the user go into 'else if' loop if they typed in<br>the word "Coin Flip". From there I generated a random number limited only<br>to between 1,0 and I defined a string called "sideUp" which would result<br>to 'Heads' if the number was 0. Vice versa, if the number was<br>1, then the only other option the coin can have would be 'Tails'.<br>Lastly, I used the broadcast method to output the result to all connected<br>clients</div><br></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshot(s) showing the implemented feature working</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/195251934-732eff57-4a83-4bec-a4f3-e480ff62fed3.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>mage shows the code itself in the program for Coin Flip, and then<br>shows the clients using the feature.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Add screenshot(s) of related code changes to highlight the new logic</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/195251934-732eff57-4a83-4bec-a4f3-e480ff62fed3.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>mage shows the code itself in the program for Coin Flip, and then<br>shows the clients using the feature.<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Feature Implementation 2 </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> What feature did you pick? Briefly explain how you implemented it</td></tr>
<tr><td> <em>Response:</em> <ol><li>Simple number guesser where all clients can attempt to guess</li></ol><div>On the server side<br>file, I implemented a simple number guesser game within the process command function.<br>Using the same process as the previous implementation, I used the random function<br>to be able to generate a random number each time, starting from 0<br>to 9. The clients will interact with it through the server, however after<br>each input if it's not correct the program broadcast to the clients whether<br>they need to guess higher or lower, and the program goes until the<br>right number is guessed. I used a while function, to keep the program<br>looping until the program becomes false, and it exits the loop. And I<br>used a series of 'if statements' to be able to determine if the<br>user's guess was right, too high, or too low.</div><br></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshot(s) showing the implemented feature working</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/195253167-b6bfa47b-9f30-4dd6-b6dd-2ec864892847.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Feature 2 working in the server and between clients<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Add screenshot(s) of related code changes to highlight the new logic</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/195253276-366d11fe-48ae-42e0-95c8-66185c5d706f.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Feature 2 code screenshot with comments, and a brief explanation of the Guess<br>a number feature.<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Did you have an issues and how did you resolve them? If no issues, what did you learn during this assignment that you found interesting?</td></tr>
<tr><td> <em>Response:</em> <p>Throughout this entire process, one thing I struggled with was trying to broadcast<br>the result of my features to the clients, as it was initially only<br>showing up in the server side. To resolve this issue, I went back<br>and forth between classroom resources and the internet. And after just taking a<br>few minute break from looking at the code, and coming back to it<br>later, I think I was able to read the code and try to<br>see if I can implement that to do what I needed it to<br>do.&nbsp;<div>Additionally, the idea of servers and clients and being able to see how<br>it is done behind the scenes was very fascinating.</div><br></p><br></td></tr>
<tr><td> <em>Sub-Task 2: </em> Pull request link</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/nmanoppo/IT114-007/pull/8">https://github.com/nmanoppo/IT114-007/pull/8</a> </td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-007-F22/it114-sockets-part-1-3/grade/nm94" target="_blank">Grading</a></td></tr></table>