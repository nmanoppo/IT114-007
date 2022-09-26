<table><tr><td> <em>Assignment: </em> IT114 M2 Java-HW</td></tr>
<tr><td> <em>Student: </em> Nadia Manoppo (nm94)</td></tr>
<tr><td> <em>Generated: </em> 9/26/2022 12:37:50 AM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-007-F22/it114-m2-java-hw/grade/nm94" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p><br></p><p><strong>Template Files</strong>&nbsp;You can find all 3 template files in this gist:&nbsp;<a href="https://gist.github.com/MattToegel/fdd2b37fa79a06ace9dd259ac82728b6">https://gist.github.com/MattToegel/fdd2b37fa79a06ace9dd259ac82728b6</a>&nbsp;<br></p><p>Setup steps:</p><ol><li><code>git checkout main</code></li><li><code>git pull origin main</code></li><li><code>git checkout -b M2-Java-HW</code></li></ol><p>You'll have 3 problems to save for this assignment.</p><p>Each problem you're given a template&nbsp;<strong>Do not edit anything in the template except where the comments tell you to</strong>.</p><p>The templates are done in such a way to make it easier to capture the output in a screenshot.</p><p>You'll copy each template into their own separate .java files, immediately git add, git commit these files (you can do it together) so we can capture the difference/changes between the templates and your additions. This part is required for full credit.</p><p>HW steps:</p><ol><li>Open VS Code at the root of your repository folder</li><li>In VS Code create a new folder/directory called M2</li><li>Create 3 new files in this new M2 folder (Problem1.java, Problem2.java, Problem3.java)</li><li>Paste each template into their respective files</li><li><code>git add .</code></li><li><code>git commit -m "adding template baselines</code></li><li>Do the related work (you may do steps 8 and 9 as often as needed or you can do it all at once at the end)</li><li><code>git add .</code></li><li><code>git commit -m "completed hw"</code></li><li>When you're done push the branch<ol><li><code>git push origin M2-Java-HW</code></li></ol></li><li>Create the Pull Request with <b>main</b>&nbsp;as base and&nbsp;<strong>M2-Java-HW</strong>&nbsp;as compare (don't merge/close it yet)</li><li>Create a new file in the M2 folder in VS Code called m2_submission.md</li><li>Fill out the below deliverable items, save the submission, and copy to markdown</li><li>Paste the markdown into the m2_submission.md</li><li>add/commit/push the md file<ol><li><code>git add m2_submission.md</code></li><li><code>git commit -m "adding submission file"</code></li><li><code>git push origin M2-Java-HW</code></li></ol></li><li>Merge the pull request from step 11</li><li>On your local machine sync the changes<ol><li><code>git checkout main</code></li><li><code>git pull origin main</code></li></ol></li><li>Submit the link to the m2_submission.md file from the main branch to Canvas</li></ol><p><br></p></td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Problem 1 - Only output Odd values of the Array under "Odds output" </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> 2 Screenshots: Clearly screenshot the output of Problem 1 showing the data and show the code</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/192193483-15233102-5904-442c-abaf-a5c2aa79b3f1.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Problem1 code<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/192193957-8783da02-454f-4e0d-b15b-6c872a5dcebf.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Problem1 output<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Describe how you solved the problem</td></tr>
<tr><td> <em>Response:</em> <p>It iterates through the arrays and does the &#39;%&#39; operator to see if<br>it is an even or odd value. If it is not divisible by<br>2 (making it odd),&nbsp; when using the modulo operator, the remainder should not<br>equal zero. Thus, only printing out those values.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Problem 2 - Only output the sum/total of the array values (the number must end in 2 decimal places, if it ends in 1 it must have a 0 at the end) </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> 2 Screenshots: Clearly screenshot the output of Problem 2 showing the data and show the code</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/192194093-ab213364-100a-43b0-91dc-93518db3d842.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Problem2 code<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/192194183-72c902d0-0ffd-4b5c-9c33-dd1a18e2d8e1.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Problem2 output<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Describe how you solved the problem</td></tr>
<tr><td> <em>Response:</em> <p>We initialized a new variable called &#39;total&#39; this will keep track of all<br>the values that are being added from the array. The for loop function<br>will just loop through thecontents of the&nbsp; array and storing (and totaling) the<br>values in the &#39;total&#39; variable. Once, the total was all added up. We<br>use the &#39;Math.round&#39; to round the number to the nearest integer after taking<br>the total mulitplied by 100.0 to move the decimal place over to the<br>right, which the math.round function will round it. Then we divide that number<br>by 100.0 to ensure it ends in 2 decimal places.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Problem 3 - Output the given values as positive under the "Positive Output" message (the data otherwise shouldn't change) </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> 2 Screenshots: Clearly screenshot the output of Problem 3 showing the data and show the code</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/192194301-670ae379-46eb-4af2-be7e-1cabb8b071cf.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Problem3 code<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/104607965/192194391-7d98bae6-2f41-4e53-9835-ea1d05996e76.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Problem3 output<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Describe how you solved the problem</td></tr>
<tr><td> <em>Response:</em> <p>I used a for loop to iterate through the arrays. Then using the<br>if statements, I went to check if my condition of &#39;instanceof&#39; results in<br>true or false. the instanceof method, checks the variable type of the data<br>and returns the result as a boolean. If it returned true, it would<br>output the index of that array as a positive number using the absolute<br>value method, that would convert the integer, and double data types from negatives<br>to positive. Additionally, if the data type was found to be a String,<br>we would still use the Math.abs method, however we would use the &#39;parseInt&#39;<br>function to convert the string to a integer type.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Misc Items </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Pull Request URL for M2-Java-HW to main</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/nmanoppo/IT114-007/pull/3">https://github.com/nmanoppo/IT114-007/pull/3</a> </td></tr>
<tr><td> <em>Sub-Task 2: </em> Talk about what you learned, any issues you had, how you resolve them</td></tr>
<tr><td> <em>Response:</em> <div>I first had an issue running java on VS code, to test my<br>output. After going through the steps again, and talking with Professor Toegel, I<br>was able to run Java code through VS Code.</div>The second issue I had<br>was with the first problem, trying to figure out the syntax of the<br>code. To resolve the issue, I did some reading on Zybooks and W3<br>schools and I was able to figure out the code I needed to<br>use.<div>The last problem I had was with the third problem, I couldn't figure<br>out how I could determine the data types, however after doing research on<br>the internet, zybooks, and help of firends I was able to find a<br>method in Java that would be able to return true/false if the data<br>type was a string, integer, or double.&nbsp;</div><br></td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-007-F22/it114-m2-java-hw/grade/nm94" target="_blank">Grading</a></td></tr></table>