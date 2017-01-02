all: classes run manifest

run: $(classes)
	echo "#!/bin/bash" > run.sh
	echo 'if [ "$$1" == "-t" ]; then' >> run.sh
	echo "    cd Text-Based" >> run.sh
	echo "    java EngineeringStreamSelector" >> run.sh
	echo "    cd .." >> run.sh
	echo "else" >> run.sh
	echo "    java -jar Main.jar" >> run.sh
	echo "fi" >> run.sh
	chmod 754 run.sh 

classes:
	javac UI/*.java
	javac Text-Based/*.java

manifest: $(classes)
	echo "Manifest-Version: 1.0" > Manifest.txt
	echo "Class-Path: ." >> Manifest.txt l
	echo "Main-Class: UI.EngineeringQuizUI" >> Manifest.txt 
	jar cfm Main.jar Manifest.txt UI/*.class

clean:
	rm UI/*.class
	rm Text-Based/*.class
	rm *.jar
	rm run.sh
	rm Manifest.txt
