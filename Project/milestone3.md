<table><tr><td> <em>Assignment: </em> IT114 Chatroom Milestone3</td></tr>
<tr><td> <em>Student: </em> Nadia Manoppo (nm94)</td></tr>
<tr><td> <em>Generated: </em> 12/7/2022 6:10:44 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-007-F22/it114-chatroom-milestone3/grade/nm94" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p>Implement the features from Milestone3 from the proposal document:&nbsp;&nbsp;<a href="https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view">https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view</a></p>
</td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Connection Screens </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots showing the screens with the following data</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/206307668-2103ca46-9a5a-480b-b1df-eca778a50784.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Port and Host Screenshot<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/206307947-88e110cf-aea3-47f6-ac5c-520a1da49d44.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Connecting username and username list<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain the code for each step of the process</td></tr>
<tr><td> <em>Response:</em> <p>Using the code given by Professor Toegel, I was able to integrate UI<br>into my chatroom utilizing a file called connectionPanel.java that uses JPanel and helps<br>in displaying the correct port, host, and username.&nbsp;<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Chatroom view </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots showing the related UI</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/206316591-a76907f3-299c-492e-8dc8-dbdfed8b5301.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Chatroom views<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/206316781-6dcf5a43-b002-48ca-bd13-88544656b3ee.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>snippet for the code that lets the enter key send the message<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Chat Activities </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show screenshots of the result of the following commands</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/206310680-742aa51c-8249-42a2-920d-811217b7b317.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Flip and Roll output<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Show the code snippets for each command</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/206310901-446b6cb6-581c-4e70-9fce-f72d366e9d49.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Code for Flip and Roll<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/206310965-0ed0994e-61b5-42c0-87c7-da75ea237500.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>How it is output in the screen and formatting<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the code flow of each command</td></tr>
<tr><td> <em>Response:</em> <ul><li>Flip() method:</li><ul><li>uses the Random() function to generate a number from 0, 2</li><li>Using an<br>if-statement, it checks whether the generated number is 0 ("heads") or 1 ("tails")</li><li>To<br>display the message, I created a username variable that stores the name of<br>the user that calls the /flip function, and send it back to the<br>chat as bold.&nbsp;</li><li>To bold the message I just surrounded the output message with<br>html bold tags</li></ul><li>Roll() method:</li><ul><li>Uses the Random function to generate a number from 0<br>to 10</li><li>Then uses a for loop to generate the number that is outputted</li><li>Follows<br>the same logic for incorporating and bold and username</li></ul><li>Client --&gt; Server --&gt; Client<br>flow</li><ul><li>The client waits for a message from a user, then once a message<br>is sent, it is sent back to the server to process the message,<br>and then once it has been proceed it is sent back to the<br>client</li></ul></ul><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Custom Text </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Screenshots of examples</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/206312863-afe160a9-f892-4095-b187-cf7a1984ccd7.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Custom text in order of appearance: (Bold, Italicize, Underline, Red color, Bold and<br>Underline, Blue and Italicize)<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain how you got the UI side to render the text accordingly</td></tr>
<tr><td> <em>Response:</em> <p>In order to render the text correctly, i just changed the JEditorPane in<br>my ChatPanel.java from &quot;text/plaintext&quot; to &quot;text/html&quot; so it would recognize html commands and<br>adjust accordingly.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 5: </em> Whisper </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots showing a demo of whisper commands</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/206313795-a872b978-a7d7-47d8-bde2-a634919c8e8f.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Whisper in chatroom<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Show the server-side code snippets of how this feature works</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/206314066-8e7d5007-61d5-4e94-a3a9-a6a611fb746c.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Whisper Code Snippet<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the code logic of how this was achieved</td></tr>
<tr><td> <em>Response:</em> <p>First i delcared another command_trigger2 so the server knows when a specific command<br>is being used. Then I added to the if statement in the process<br>command, to detect the trigger. Then to get the username, i just continually<br>split the message until the desired username was left. Then i sent messages<br>to the log, and iterated through all the clients and find a match<br>in the targeted username. Then using an If statement, once it found the<br>user, it would only target that user to send the message to.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 6: </em> Mute/Unmute </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots demoing this feature</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/206315206-f070bb19-fcb4-4821-a683-7d207a444f36.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Attempted mute/unmute user feature<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshots of the code snippets that achieve this feature</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/206315408-85b70895-b70f-428d-a55a-2a63279bfe73.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Mute/Unmute code snippet from room.java<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/206315598-d28bf7f1-f759-41c6-816c-9bbc316d9832.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Mute/Unmute code snippet from ServerThread.java<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the code logic of how this was achieved</td></tr>
<tr><td> <em>Response:</em> <p>I was able to get trigger and display of it working. However, I<br>was unable to actually mute the user, or unmute them. From my code,<br>first I grabbed the desired username to be muted. Then i added it<br>to my list in serverthread of muted names. And then I called the<br>mute function to mute the user (which didn&#39;t work), then i sent a<br>message out to the users that __ has been muted.&nbsp;<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 7: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Pull request from milestone3 to main</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/nmanoppo/IT114-007/pull/13">https://github.com/nmanoppo/IT114-007/pull/13</a> </td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-007-F22/it114-chatroom-milestone3/grade/nm94" target="_blank">Grading</a></td></tr></table>