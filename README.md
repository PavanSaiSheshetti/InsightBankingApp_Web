# InsightBankingApp_Web


## Overview:

This is a simple Banking Operations Project(Web Application) where customers can create their bank account, check their balance, Deosit, Withdraw money and Transfer money to other valid accounts.
Bank Employee can approve or reject accounts, can view the all customer details also can see the log information.

## Technical Aspect:
<ul>
<li>Used Hibernate ORM Framework to connect to the database(postgreSQL)</li>
<li>Used DAO design pattern in the project
<li>Used session management techniques(URL Rewriting) to minimize the number of Servlets 
<li>Created Interactive Webpages using HTML5 for UI and CSS, Bootstrap for styling the website
<li>All the client side and server side validations were done using JavaScript and Servlet
<li>JSP is used to render the dynamic content to the end user
<li>Exception or Error Handling is done 
<li>Tested all the functionalities using JUnit4 
<li>Implemented Logging by Log4j
</ul>

## Working Procedure of model:

After Running this project in eclipse, it will run on a localhost with homepage. where Customer can register for an account in the bank(a unique account number and cif Id will be generated for each customer), can login after employee approved the bank account.
In the customer dashboard customer can view, deposit, withdraw and also transfer money . All the client side and server side validations were done using JavaScript and Servlet. System will
show the error messages for invalid transactions. Employee can login and view all bank accouunt details also the log information.

## Installation and Run:

Import this project by a Github Desktop(click [here](https://desktop.github.com/) to install) or by downloading the Zip file . If you downloaded the zip file then you need to unzip or extract it and import this in eclipse(file-->import-->select the project)
change the database configuration in hibernate.cfg file (Driver,Dialect,username and password).That's all you can run this project and see the results.
###### Note :
<ol>
<li>you can install eclipse IDE <a href="https://www.eclipse.org/downloads/">here</a></li>
<li>You need to run this project on server. Please <a href="https://youtu.be/ZpMmpEAGPaQ">refer</a> this for downloading and attaching the tomcat server to your project</li>
</ol>

## Bug / Feature Request:

If you find a bug (the website couldn't handle the query and / or gave undesired results), kindly open an issue [here](https://github.com/PavanSaiSheshetti/InsightBankingApp_Web/issues/new) by including your search query and the expected result.


## Technologies Used:

Java, PostgreSQL, JDBC, Hibernate, HTML, JavaScript, CSS, JSP


