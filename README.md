# Fasta-Sequences-compare
Add fasta files and compare two sequnces 

# Tyma subject Malaga University

## Tools
<ol>
<li>Intellij IDEA</li>
<li>Maven</li>
<li>Java 8</li>
<li>Python</li>
<li>HTML</li>
<li>CSS</li>
</ol>

## Introduction
This is a web application developed by java using Spring boot mvc, its let the user to upload Fasta files and make comparison by identities between two sequences.
Also this application let the user to change the word size value (e.g: if word size = 1 then it will make the compration for just one nucleatids).
Threshold value is the number of repition if two words have the same match.

## File generation

This application generate two files: 
First folder is the matrix.txt which is a matrix (0,1) values who save it in the main folder to show the coincidence between two words.
Second folder who will be create by usin python code to generate the dotplot image which you can finde in the folder /static/img/img.png.

## Requirements
<ol>
<li>java version "1.8.0_281"</li>
<li>Create new Spring boot web application</li>
<li>pip install numpy</li>
<li>pip install matplotlib</li>
<li>Dependecies and plugins:

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-thymeleaf</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>


	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>
 </li>
</ol>
You need to add to your application.properties these commands to not save the cache files and take the resource files directly from your machine:
spring.thymeleaf.cache=false
project.base-dir=file:///(your application path)/New web application/demo/
spring.resources.static-locations=${project.base-dir}/src/main/resources/static/

## Results
Final result should be (check a [demo]).
Please note that the demo its not working when you make new comparison between two fasta files and that because in this method the application use the cmd to execute the python file.

<img width="780" alt="website" src="https://user-images.githubusercontent.com/49337666/111064837-a14ca080-84b6-11eb-9a59-aec8b486a3db.PNG">



 [demo]: <https://frozen-brushlands-86690.herokuapp.com/>
