# Mac-engineering-quiz
This is a quiz designed to help you find out what type of engineering to choose at McMaster university.


import java.util.Scanner;

public class EngineeringStreamSelector {

	public static void main(String[] args) {
		// array to store student info
		int[] stud = new int[9];
		// array to store list of programs
		String[] engList = new String[9];

		// initialization for the list of programs
		engList[0] = "Chemical Engineering";
		engList[1] = "Material Science and Engineering";
		engList[2] = "Mechanical Engineering";
		engList[3] = "Mechatronics Engineering";
		engList[4] = "Civil Engineering";
		engList[5] = "Computer Engineering or Electrical Engineering";
		engList[6] = "Electrical and Biomedical Engineering";
		engList[7] = "Software Engineering";
		engList[8] = "Engineering Physics";

		Scanner sc = new Scanner(System.in);
		int input;

		// intro
		System.out.println(
				"Hello, future engineers! Are you interested in engineering at McMaster University? Then you have come to the right place! This is a quiz designed to help you find out what type of engineering to choose at McMaster university.");
		System.out.println(
				"How the quiz works: Read the question and the answers. After you decide on your answer, press the corresponding number on your keyboard, followed by the “enter” key. Repeat with the next question until the end where your result will come up.");

		// question 1
		System.out.println();
		System.out.println("The environment I want to work in is: ");
		System.out.println("1. a lab setting");
		System.out.println("2. outside the field");
		System.out.println("3. an office setting");
		System.out.println("4. a factory setting");
		input = sc.nextInt();
		if (input == 1) {
			stud[0] += 2;
			stud[1] += 3;
			stud[5] += 2;
			stud[6] += 2;
			stud[8] += 3;
		} else if (input == 2) {
			stud[4] += 3;
		} else if (input == 3) {
			stud[5] += 2;
			stud[7] += 3;
		} else if (input == 4) {
			stud[2] += 3;
			stud[3] += 3;
			stud[5] += 1;
		}

		// question 2
		System.out.println();
		System.out.println("In physics, I am most interested in:");
		System.out.println("1. none of the subtopics");
		System.out.println("2. thermodynamics");
		System.out.println("3. waves and oscillations");
		System.out.println("4. Electromagnetics");
		System.out.println("5. Mechanics");
		System.out.println("6. all of the above");
		input = sc.nextInt();
		if (input == 1) {
			stud[0] += 3;
			stud[7] += 3;
		} else if (input == 2) {
			stud[1] += 3;
			stud[3] += 1;
			stud[8] += 2;
		} else if (input == 3) {
			stud[6] += 3;
			stud[3] += 1;
			stud[8] += 2;
		} else if (input == 4) {
			stud[5] += 3;
			stud[6] += 3;
			stud[3] += 1;
			stud[8] += 2;
		} else if (input == 5) {
			stud[3] += 3;
			stud[8] += 3;
		}

		// question 3
		System.out.println();
		System.out.println("The person I admire the most is: ");
		System.out.println("1. Steve Jobs");
		System.out.println("2. Elon Musk");
		System.out.println("3. David Suzuki");
		System.out.println("4. Nikola Tesla");
		System.out.println("5. Frederick Banting");
		System.out.println("6. all of the above");
		input = sc.nextInt();
		if (input == 1) {
			stud[7] += 3;
			stud[5] += 3;
		} else if (input == 2) {
			stud[2] += 3;
			stud[3] += 3;
			stud[4] += 3;
		} else if (input == 3) {
			stud[0] += 3;
			stud[2] += 3;
			stud[4] += 3;
		} else if (input == 4) {
			stud[2] += 3;
			stud[5] += 3;
			stud[8] += 3;
		} else if (input == 5) {
			stud[3] += 1;
			stud[2] += 3;
			stud[6] += 3;
		} else if (input == 6) {
			stud[3] += 1;
			stud[2] += 3;
		}

		// question 4
		System.out.println();
		System.out.println("A company I would like to work for is: ");
		System.out.println("1. Nintendo, Google");
		System.out.println("2. Ministry of Transportation of Ontario (MTO)");
		System.out.println("3. Greenpeace");
		System.out.println("4. pharmaceutical industries");
		System.out.println("5. Ontario Power");
		System.out.println("6. a construction company");
		input = sc.nextInt();
		if (input == 1) {
			stud[3] += 2;
			stud[7] += 2;
		} else if (input == 2) {
			stud[2] += 2;
			stud[3] += 2;
			stud[4] += 2;
		} else if (input == 3) {
			stud[0] += 5;
			stud[1] += 5;
			stud[4] += 5;
		} else if (input == 4) {
			stud[2] += 1;
			stud[1] += 5;
			stud[4] += 2;
		} else if (input == 5) {
			stud[2] += 3;
			stud[5] += 3;
			stud[8] += 3;
		} else if (input == 6) {
			stud[2] += 3;
			stud[1] += 5;
			stud[4] += 3;
		}

		// question 5
		System.out.println();
		System.out.println("The invention people are taking for granted the most is: ");
		System.out.println("1. computers");
		System.out.println("2. medicines");
		System.out.println("3. recycling");
		System.out.println("4. batteries");
		System.out.println("5. paved roads");
		System.out.println("6. concrete");
		input = sc.nextInt();
		if (input == 1) {
			stud[3] += 2;
			stud[7] += 2;
		} else if (input == 2) {
			stud[2] += 1;
			stud[1] += 5;
			stud[4] += 2;
		} else if (input == 3) {
			stud[0] += 5;
			stud[1] += 5;
			stud[4] += 5;
		} else if (input == 4) {
			stud[2] += 3;
			stud[5] += 3;
			stud[8] += 3;
		} else if (input == 5) {
			stud[2] += 2;
			stud[3] += 2;
			stud[4] += 2;
		} else if (input == 6) {
			stud[2] += 3;
			stud[1] += 5;
			stud[4] += 3;
		}

		// question 6
		System.out.println();
		System.out.println("I prefer to do homework/research: ");
		System.out.println("1. with friends/in a team");
		System.out.println("2. by myself");
		input = sc.nextInt();
		if (input == 1) {
			stud[8] += 3;
			stud[0] += 3;
			stud[2] += 3;
		} else if (input == 2) {
			stud[1] += 3;
			stud[3] += 3;
			stud[4] += 3;
			stud[5] += 3;
			stud[6] += 3;
			stud[7] += 3;
		}

		// question 7
		System.out.println("Would you like to work in:");
		System.out.println("1. an industrial building");
		System.out.println("2. offfice building");
		System.out.println("3. hospital");
		System.out.println("4. outside in the wilderness");
		System.out.println("5. airports/roadways");
		System.out.println("6. construction site");
		input = sc.nextInt();
		if (input == 1) {
			stud[0] += 1;
			stud[2] += 3;
			stud[5] += 3;
			stud[8] += 3;
		} else if (input == 2) {
			stud[3] += 1;
			stud[5] += 3;
			stud[7] += 3;
		} else if (input == 3) {
			stud[2] += 3;
			stud[1] += 3;
			stud[6] += 3;
		} else if (input == 4) {
			stud[0] += 3;
			stud[1] += 3;
			stud[4] += 3;
			stud[8] += 1;
		} else if (input == 5) {
			stud[2] += 3;
			stud[5] += 3;
			stud[8] += 3;
		} else if (input == 6) {
			stud[2] += 3;
			stud[1] += 3;
			stud[4] += 3;
		}
		// question 8
		System.out.println("A birthday present I want the most is (they are of the same price):");
		System.out.println("1. a new iphone");
		System.out.println("2. a cosmetic product");
		System.out.println("3. video game console");
		System.out.println("4. puzzles");
		System.out.println("5. a fitness tracker");
		System.out.println("6. jenga");
		System.out.println("7. a model car");
		input = sc.nextInt();
		if (input == 1) {
			stud[7] += 3;
			stud[5] += 3;

		} else if (input == 2) {
			stud[1] += 3;
			stud[0] += 3;

		} else if (input == 3) {
			stud[2] += 3;
			stud[5] += 3;

		} else if (input == 4) {
			stud[8] += 3;
			stud[1] += 3;

		} else if (input == 5) {
			stud[6] += 3;
			stud[1] += 2;

		} else if (input == 6) {
			stud[4] += 3;

		} else if (input == 7) {
			stud[2] += 3;
			stud[3] += 3;
		}

		// get the index for the highest score
		int counter1 = 0;
		for (int i = 0; i < stud.length - 1; i++) {
			if (stud[i] < stud[i + 1]) {
				counter1 = i + 1;
			}
		}
		// output the most possible program
		System.out.println();
		System.out.println("Congratulations! Here are your results: ");
		System.out.println();
		System.out.println(engList[counter1]);
		progDescription(counter1);

		// get the index for the second largest score
		int counter2 = 0;
		int maxDiff = 100;
		for (int j = 0; j < stud.length; j++) {
			int diff = Math.abs(stud[counter1] - stud[j]);
			if (diff < maxDiff) {
				if (counter1 == j) {
				} else {
					counter2 = j;
				}
			}
		}
		// output the second most possible program
		System.out.println();
		System.out.println(engList[counter2]);
		progDescription(counter2);

	}

	// program descriptions
	public static void progDescription(int ind) {
		switch (ind) {
		case 0:
			System.out.println(
					"Chemical engineers design and manage the processes used to manufacture materials used in everyday life. They help develop an almost infinite number of products and materials, using basic scientific principles, mathematics and economics. Chemical engineers work in a variety of jobs, including food production, fuel production, pharmaceutical industry, and manufacturing.");
			break;

		case 1:
			System.out.println(
					"Materials engineers focus on developing new materials and characterizing their various properties such as mechanical, physical and chemical properties. They also improve existing materials already used to build items on a daily basis. Materials engineers work in all kinds of industries with all kinds of materials and are also involved in groundbreaking research. Some streams include metals, polymers and nanotechnology.");
			break;

		case 2:
			System.out.println(
					"Mechanical engineers apply the principles of physics to design, construct, analyze and maintain nearly all physical devices and systems. They also focus on the operation of machinery and power production. Mechanical engineers work in almost every type of industry, including automotive, metal, power plants, heavy equipment, and manufacturing.");
			break;

		case 3:
			System.out.println(
					"Mechatronics deals with the design, control and production of electro-mechanical devices, integrating the production of physical devices with electronics. It integrates electrical engineering and mechanical engineering. Mechatronics engineers are needed in all industries, including manufacturing, telecommunications, and power generation.");
			break;

		case 4:
			System.out.println(
					"Civil engineers plan, construct and maintain a sustainable infrastructure. Civil engineering is a broad discipline which includes structural engineering which deals with designing structures, construction engineering which manages construction projects, transportation engineering which deals with transportation systems and facilities, geotechnical engineering which deals with the behaviour of soil and rock, and environmental engineering which deals with improving the quality of our air, water and soil.");
			break;

		case 5:
			System.out.println(
					"Electrical engineers and computer engineers use their knowledge of digital circuit technology to create devices benefiting the public, which include computer hardware, electronics, robotics and other related technologies. Electrical engineers focus on employing the flow of electrons and photons in circuits, while computer engineers focus on computer hardware and software interaction to make integrated computer systems.");
			break;

		case 6:
			System.out.println(
					"Electrical and biomedical engineering focuses on integrating electrical circuit technology with their medical knowledge to design electronic devices to solve problems in medicine and biology. Technologies designed by these engineers include medical imaging devices, implants, medical instruments, and biological modelling.");
			break;

		case 7:
			System.out.println(
					"Software engineers design, build, test and troubleshoot the software in computer systems, which include systems controlling electrical devices, systems that design products, financial systems, and information systems. Software is used everywhere and now used to design every device so career opportunities are unlimited.");
			break;

		case 8:
			System.out.println(
					"Engineering physics is an interdisciplinary field of study where advanced devices, systems and materials are developed based on the principles of physics. Many new technologies are developed by engineering physicists, such as photonics, semiconductors, nuclear systems and electrical systems.");
			break;
		}
	}

}
