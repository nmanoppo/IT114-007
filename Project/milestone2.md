<table><tr><td> <em>Assignment: </em> IT114 Chatroom Milestone 2</td></tr>
<tr><td> <em>Student: </em> Nadia Manoppo (nm94)</td></tr>
<tr><td> <em>Generated: </em> 11/16/2022 12:01:59 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-007-F22/it114-chatroom-milestone-2/grade/nm94" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p>Implement the features from Milestone2 from the proposal document:&nbsp; <a href="https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view">https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view</a></p>
</td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Payload </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Payload Screenshots</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/201727576-8c2efb4b-12a9-4636-a010-432aa8257c58.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Payload code<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Server-side commands </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show the code for the mentioned commands</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/202242646-f78c8457-cc3a-4989-8872-ef1d07ac1c0b.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>roll() and flip() code implementation<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Explain the logic/implementation of each commands</td></tr>
<tr><td> <em>Response:</em> <p>For both implementation they follow the same logic of using the random function<br>that generates a random number given a bound, then using an if statement<br>for flip it assigns 0 as heads, and 1 as tails. For roll<br>i used a bound of 10, and then i assigned the number to<br>a message that outputs back to the clients.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Text Display </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show the code for the various style handling</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/202244442-14c583b1-798d-4825-b71b-78ec9c7c47ee.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>code for the various style handling<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Show source message and the result output in the terminal (note, you won't actually see the styles until Milestone3)</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/202188542-34c080a6-1d58-47d5-9b1b-901a1bac4632.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing the output for when doing BOLD, ITALICIZE<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/202188789-13689af5-e103-461f-b346-45e590ae3452.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing a mixture of both BOLD &amp; ITALICIZE<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/202188944-21994a9a-f2d6-4132-a333-8351163b83e9.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing underline styling<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/202244038-56c6fb9c-5d34-40f7-8720-fd7a79bbf480.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Showing color styling (Red, green, blue, yellow)<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Explain how you got each style applied</td></tr>
<tr><td> <em>Response:</em> <p>For each styling they all follow the same logic, first the user must<br>trigger the text formatting using &#39;!&#39;, and then to achieve the bold styling,<br>I used regex to find the &#39;#&#39; symbol, and then I used the<br>.replace() method to replace the symbol with the closing html tags. Then I<br>used the .replaceFirst() method to replace the first instance of the html closing<br>tag and replace it with an opening tag, and then that message is<br>sent back to the client. And then italics, underline, and color follow the<br>same logic if looking for the symbol and replacing them with html tags.<br>In the case of color, I created three different if statements to account<br>for various colors (Red, Green, Blue, Yellow)<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Include the pull request for Milestone2 to main</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/nmanoppo/IT114-007/pull/12/">https://github.com/nmanoppo/IT114-007/pull/12/</a> </td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-007-F22/it114-chatroom-milestone-2/grade/nm94" target="_blank">Grading</a></td></tr></table>