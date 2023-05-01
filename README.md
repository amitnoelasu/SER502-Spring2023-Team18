# SER 502 - Project milestone 2 , Team 18

The team members are

- Amit Noel Thokala
- Sri Venkata Vivek Dhulipala
- Sowmya Veldandi
- Suvarshitha Kalvakuntla
- Yashwanth Reddy Kikkuri

The language is called as **Vyass** . The link to the youtube video is : https://youtu.be/gDcZwjXk-FM

The repository has the following structure:

- The "data" folder includes various sample programs. The "SampleCodes" subfolder has examples in the language source code, as well as the intermediate files generated during compilation.
- The "doc" folder contains all the project-related presentations.
- The "src" folder contains the complete source code of the project. 
- The "compiler" subfolder within the "src" folder contains the source code for the compiler.
- The "runtime" subfolder within the "src" folder contains the source code for the runtime.
- The "lib" folder contains the project dependencies, including ANTLR. 

follow these steps to be able to locate and organize different components of the project.



# Set up steps
# To set up ANTLR in IntelliJ IDEA project, follow these steps:

1. Open your IntelliJ IDEA project.
2. Click on "File" in the top menu and select "Project Structure".
3. In the left panel, select "Modules", and then click on the "Dependencies" tab.
4. Click on the "+" icon and choose either "JARs" or "Directories" option.
5. Navigate to the ANTLR JAR file included in the project (located inside the "lib" folder of the root directory).
6. Click on "Apply" and then "OK" to save the changes.

# follow these steps to be able to use ANTLR in your IntelliJ IDEA project.

# To create an artifact configuration for the JAR in IntelliJ IDEA, follow these steps:

1. Open the Project Structure dialog by selecting "File" in the main menu and then clicking "Project Structure". Next, click on "Artifacts" and then on the "+" icon. Choose "JAR" and select "From modules with dependencies".
2. Click on the folder icon located to the right of the "Main Class" field and select the main class (in our case, it is "vyass.java").
   This will create an artifact configuration and its settings will appear on the right side of the Project Structure dialog.
3. Once you have made the necessary changes, click on "Apply" and then close the dialog.
4. To build the JAR artifact, go to the main menu and select "Build" followed by "Build Artifacts". 
5. Point to the desired .jar file that needs to be created and select "Build".

# follow these steps to be able to create an artifact configuration for your JAR in IntelliJ IDEA.

# To execute the JAR file, follow these steps:

1. Navigate to the folder where the JAR file is located.
2. Open the command prompt or terminal and type "java -jar \<Jar-File-Name\>\.jar \<Path to file containing code\>".
3. Replace <Jar-File-Name> with the name of your JAR file and <Path to file containing code> with the path to the file containing your code.

# follow these steps to be able to execute your JAR file with your code.
