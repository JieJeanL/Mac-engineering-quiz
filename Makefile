all: classes run

run: $(classes)
	echo "#!/bin/bash" > run.sh
	echo "java EngineeringStreamSelector" >> run.sh
	chmod 754 run.sh 

classes:
	javac EngineeringStreamSelector.java

clean:
	rm *.class
	rm run.sh
