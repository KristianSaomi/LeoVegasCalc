![Skärmbild 2022-10-20 025603](https://user-images.githubusercontent.com/38978953/196836821-24c01d28-0107-458f-988e-434ff31f0443.png)


# LeoVegasCalc
This project is made for LeoVegas group.

**Hi Leo Vegas!** 

Im now done with the task, however if im 100% please and know it couldnt be better... yeah it could. 
But it does the job, by the submitet project im trying to show that im capable of working with Spring in general and love to develop my skills, or rather want to.

**What I could do better/My own toughts on myself and the work:** 
* Encapsulate classes better, use private methods and fields to keep it more abstract and reduce coupling.

* The database structure could have been much better, but for the sake of the test, I chose to continue in the middle of the project. One difficulty was that I wanted to present the REST api project in a better view than what you might be used to through postman or similar, therefore I used Thymleaf as backend/frontend tool. The problem is that I don't have "very" advanced knowledge in thymleaf and then it became a bit problematic.
- In regards to database structure im particular talking about: The Account section can be allot more smother instead of having the "balance" presented as a variable, doesnt make sence in a real application.

* I can also honestly say that I did not create "unique" endpoints, I was a little stressed trying to tackle that point in the project. But a spontaneous idea I got into my head was honestly to create a method that returns a string using Math.random.



The reason I'm posting the project now is because I'm super interested and don't want my chance to go away, the recruiter said it's a bit first come first served.

**QUIDE - How to start:**
1) * Download  & Compile zip
2) * Download Sql file
3) * Connect project to mySql database (In application.properties add own mySql database password)
4) * Follow Sql statements descripiton in the file
5) * Have fun!

**Sneak peek at the project via video: https://www.loom.com/share/8c9937b6d53648a4a7cea7d8c5e949f5**

**Rest-endpoint to get started (Register>thank you> login> main menu with actions)**

1. Create account: http://localhost:9090/registerUser
2. Auto redirect after account registred: http://localhost:9090/register_success
3. Login: http://localhost:9090/login
4. Homepage with actions: http://localhost:9090/home

Actions:
Edit account: http://localhost:9090/personalData
Insert credit: http://localhost:9090/account/new
Withdraw debit: http://localhost:9090/account/new/debit
See history: http://localhost:9090/Accounts
Check balance: http://localhost:9090/checkTotal
![image](https://user-images.githubusercontent.com/38978953/196838324-653c7668-4be3-48a8-805d-2e34da7ee6b7.png)

