# java-quiz-management

## Project Overview
This project is an **evaluation system** developed using Java as part of a course assignment at **Athens University of Economics and Business (AUEB)**. The system allows for the management of different types of questions, including multiple-choice, word-based answers, and sentence completion exercises. Users can input evaluators, questions, and answers, and the system provides various functionalities for handling and analyzing responses.

## Features

- **Question Types**:
  - **Multiple-Choice Questions**: Supports questions with multiple possible answers, where users can select one or more correct options.
  - **Word-Based Questions**: Questions that require a single word as the correct answer.
  - **Sentence Completion**: Users are provided with a sentence that has missing words, and they must fill in the blanks with the correct words from a given list.
  
- **Evaluator Management**:
  - Evaluators have unique IDs, names, and are able to answer the available questions.
  
- **Answer Processing**:
  - The system handles answers based on the question type and checks for correctness, supporting case-insensitive word comparisons.

- **Menu Functionality**:
  - Add new evaluators.
  - Add new questions.
  - Add new answers from evaluators.
  - Display the list of all questions.
  - Display an evaluator’s answers and calculate their correct answers.
  - Calculate and display the percentage of correct answers for each question and evaluator.

## Part 2 Enhancements

In the second part of the project, the system was extended to support reading and writing data to structured text files. The data for evaluators, questions, and answers is now stored in files, and the system can load and save data from/to these files during program execution.

### Additional Features:

- **File-Based Data Management**:
  - **Reading**: The system reads the evaluator list, question list, and answer list from three structured text files at the start of the program.
  - **Writing**: It updates the question and answer files with any changes (e.g., new questions or answers) made during program execution, either on termination or by user choice.

- **Error Handling**:
  - The program ensures that files are opened correctly and checks the validity of the data. If invalid or unrecognized data is found, it is ignored, and relevant warnings are displayed.


