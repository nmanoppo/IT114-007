<table><tr><td> <em>Assignment: </em> IT114 Chatroom Milestone4</td></tr>
<tr><td> <em>Student: </em> Nadia Manoppo (nm94)</td></tr>
<tr><td> <em>Generated: </em> 12/15/2022 9:08:56 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-007-F22/it114-chatroom-milestone4/grade/nm94" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p>Implement the features from Milestone3 from the proposal document:&nbsp;&nbsp;<a href="https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view">https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view</a></p>
</td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Client can export chat history of their current session (client-side) </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot of related UI</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/207793325-72a4fecc-4a28-46ea-b567-2615401ca693.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showcasing the export button available to clients<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshot of exported data</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/207793666-d9d72310-ea21-4ec6-853a-59d847b7fe72.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Screenshot of export chat history<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain how you implemented this</td></tr>
<tr><td> <em>Response:</em> <p>I created a new button called &#39;export&#39;, then I added a click listener<br>that would create a &#39;chathistory.txt&#39; file whenever it was created and it would<br>save the client&#39;s chat history.&nbsp;<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Client's mute list will persist across sessions (server-side) </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add a screenshot of how the mute list is stored</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/208000625-3f706fa2-08aa-4ed0-90d5-e1f0990e090f.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Muted list screenshot<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add a screenshot of the code saving/loading mute list</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/208001387-f90676e5-3669-4d28-9aae-ea01a3efc7de.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>screenshot of the code saving/loading mute list<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain how you implemented this</td></tr>
<tr><td> <em>Response:</em> <ul><li>For the save muted list function, whenever it is called it creates a<br>new txt file for the client, and it writes into the file the<br>name of the client who the list belongs to, and documents all the<br>muted clients.</li><li>For the load mute list function, when the connection first starts it<br>is to load a file with the client name as a txt file,<br>and it will read into the file and the muted clients, and then<br>it will write that information into the file, and it notifies in the<br>server when the client list has synced up.</li></ul><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Client's will receive a message when they get muted/unmuted by another user </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add a screenshot showing the related chat messages</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/208003723-846079c9-405f-46c2-bb2d-0feb76b68afb.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>A message to the client that they have been muted, and by who<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add a screenshot of the related code snippets</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/208003999-0835911d-ac1f-4410-8544-899ee1e8eb6b.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>where/when the muted/unmuted message occurs<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain how you implemented this</td></tr>
<tr><td> <em>Response:</em> <p>for both the mute and unmute I added it to the process command<br>function; I created a new command trigger for mute and unmute, and implemented<br>into the switch/case logic. Whenever the user does /mute clientName, it will first<br>grab the name of the muted person, and then it will that to<br>the muted list. Then it will send out a message to the chat<br>from the client of who they muted. The unmute function follows the same<br>logic, just opposite of muting and it removes the client from the muted<br>list.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> User list should update per the status of each user </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/f2c037/000000?text=Partial"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot for Muted users by the client should appear grayed out</td></tr>
<tr><td><table><tr><td>Missing Image</td></tr>
<tr><td> <em>Caption:</em> (missing)</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshot for Last person to send a message gets highlighted</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/208005508-5f6b3f14-7475-456d-b94e-b52a3cb77e6b.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Partial code for Last person to send a message gets highlighted<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain how you implemented this</td></tr>
<tr><td> <em>Response:</em> <p>I tried implementing the code in the ClientUI, specifically in the onMessageReceive function.<br>However, it ended up applying the styling to every client that sent out<br>the message.&nbsp;<br></p><br></td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-007-F22/it114-chatroom-milestone4/grade/nm94" target="_blank">Grading</a></td></tr></table>