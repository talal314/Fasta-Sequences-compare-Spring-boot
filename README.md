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

## Files generation

This application generate two files: 
First folder is the matrix.txt which is a matrix (0,1) values who save it in the main folder to show the coincidence between two words.
Second folder who will be create by usin python code to generate the dotplot image which you can finde in the folder /static/img/img.png.

## Requirements
<ol>
<li>java version "1.8.0_281"</li>
<li>pip install numpy</li>
<li>pip install matplotlib</li>
</ol>

You can check a [demo]

<img width="780" alt="website" src="https://user-images.githubusercontent.com/49337666/111064837-a14ca080-84b6-11eb-9a59-aec8b486a3db.PNG">



 [demo]: <https://frozen-brushlands-86690.herokuapp.com/>
