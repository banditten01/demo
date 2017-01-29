

<h1>A small tool for formatting text</h1>

<h2>Objective:</h2>
Create a Java application which reads a text from standard in and writes the formatted output to the console.

Alignment and output width is given as program arguments.

Implement at least 3 of the following formatting algorithms:

    left align
    right align
    center
    justify
    wrap
    hard

The application must be written in a way that makes it possible to implement remaining algorithms without any considerably changes to existing code.

The project must be built with maven and produce an "executable" jar file called formatter.jar, e.g. java -jar target/formatter.jar.

The artifact id of the project should be the same as your name. 
 
It is not allowed to include any runtime dependencies.

jUnit must to be used for test.


To avoid any mail problems, please do an "mvn clean" before zipping and emailing your project.

<h1>How to build</h1>
Just do a mvn clean install

<h1>Running the demo</h1>
Execute by calling java target/formatter.jar with arguments as:
TextFormatDemo -a [left | right | center | justify] -l [hard | wrap] -w output-width

Eg. java -jar target/formatter.jar -a center -l wrap -w 80
Or java -jar target/formatter.jar -a center -l wrap -w 55 < ./src/main/resources/texts

<h1>How to implement a new Alignment formatter</h1>

<ul>
<li>Create a new class "MyAlignment" extending AbstractAlignFormatter and implements interface AlignFormatter</li>
<li>Constructer must call super constructor with output width.</li>
<li>Implement method alignText that takes a string as parameter and returns the formattet text as String:</li>
<li>Append your new java class to AlignFormatterFactory class.</li>
<li>Update syntax descriptions to reflect your changes</li>
<li>You are good to go</li>
</ul>

** the approach can be used with linebreakers.



