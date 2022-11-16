<table><tr><td> <em>Assignment: </em> It114 Milestone1</td></tr>
<tr><td> <em>Student: </em> Nadia Manoppo (nm94)</td></tr>
<tr><td> <em>Generated: </em> 10/20/2022 9:59:13 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-007-F22/it114-milestone1/grade/nm94" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <ol><li>Create a new branch called Milestone1</li><li>At the root of your repository create a folder called Project</li><li>Create a milestone1.md file inside the project folder</li><li>Git add/commit/push it to Github</li><li>Create a pull request from Milestone1 to main (don't complete/merge it yet)</li><li>Copy in the latest Socket sample code from the most recent Socket Part example of the lessons</li><ol><li>Recommended Part 5, but Part 4 should be sufficient</li><li><a href="https://github.com/MattToegel/IT114/tree/Module5/Module5">https://github.com/MattToegel/IT114/tree/Module5/Module5</a>&nbsp;<br></li></ol><li>Git add/commit the baseline</li><li>Ensure the sample is working and fill in the below deliverables</li><li>Get the markdown content or the file and paste it into the milestone1.md file or replace the file with the downloaded version</li><li>Git add/commit/push all changes</li><li>Complete the pull request merge from step 5</li><li>Locally checkout main</li><li>git pull origin main</li></ol></td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Startup </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot showing your server being started and running</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/197049203-7edb622a-3704-4bfc-a970-adcaef161c9c.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Server is properly listening to its port<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshot showing your client being started and running</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/197050874-b30f9b97-a0c2-429a-a028-e2af9b7580a6.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>The client is successfully waiting for input, and has been connected to the<br>server successfully<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the connection process</td></tr>
<tr><td> <em>Response:</em> <div>On the server-side, when it's compiled and run, it will be listening on<br>the port, and it will create room named lobby. Then once a connection<br>is attempted by a client, the Server Thread is being started, as well<br>as the thread. And the server is managing each client that connects to<br>the server and placing them into the rooms/lobby. Which it then waits for<br>another connection.</div><div><br></div>On the client-side, when trying to connect to the server using '/connect<br>localhost:#', the client is immediately sending a message to connect, and it is<br>going to connect to a socket that's open in the server. Once the<br>socket connects, the client-side will follow up with the user basic information such<br>as 'client name'.<br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Sending/Receiving </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot(s) showing evidence related to the checklist</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/197056455-f8adf5e7-d5ac-47cd-b78d-69a3e0cf9b3b.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>The image shows two clients connected to the server (names: nadia and angela),<br>both clients are in the same room and are able to send messages<br>back and forth and be able to know who the message is from.<br><br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/197057924-ae6fff82-bce7-4f2b-ae97-b7be9d4b9b38.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Image shows the clients in two different rooms, and they are unable to<br>see each other&#39;s messages in their individual rooms.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain how the messages are sent, broadcasted, and received</td></tr>
<tr><td> <em>Response:</em> <p>From the client perspective when sending a message,&nbsp; using the send methods implemented<br>in our code, we generate a payload that gets passed as the object<br>of communication between the server and client, and then we write it out.<div>From<br>the ServerThread, it helps keep our clients identifiable. we use methods that prepare<br>they payloads and that is used to send messages to the client, and<br>write the payloads to the output stream.</div><div>From the room perspective, using sendMessage as<br>a helper method to talk to the server. It sends the message from<br>the server side whether or not a room exists</div><div>From the client perspective it<br>connects to an open server, in which the server will continually broadcast messages<br>to the client using payloads. While the server is still connected, the client<br>is listening for strings from the server, with the help of payloads objects<br>which is used to read the messages being sent from server to client</div><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Disconnecting / Terminating </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot(s) showing evidence related to the checklist on the right</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/197089563-eedcf022-5e2b-41e0-a479-9d65d72fc9a3.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Shows one client disconnecting from the server, and the server is still running<br>without issues<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/197090161-7a4f5013-281d-49e4-9b1d-fe54ada3760b.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Shows the server terminating, with all clients disconnected but still running<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain how the various disconnects/terminations are handled</td></tr>
<tr><td> <em>Response:</em> <p>Once the client calls the &#39;disconnect&#39; keyword, the message is sent to the<br>server, in which the&nbsp; client leaves the current room it is in. Then<br>it&#39;ll automatically call it&#39;s cleanup functions, so it would close out its connection<br>to the server. It would close the output and input stream, it will<br>clean up all the rooms, and it closes the connection and socket which<br>explains why the program doesn&#39;t crash when terminated. Because all the rooms are<br>cleaned up, and the thread is wiped clean for the next use. And<br>even though all the clients disconnect, the server stays listening for input for<br>when the next client connects.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add the pull request for this branch</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/nmanoppo/IT114-007/pull/9">https://github.com/nmanoppo/IT114-007/pull/9</a> </td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-007-F22/it114-milestone1/grade/nm94" target="_blank">Grading</a></td></tr></table>