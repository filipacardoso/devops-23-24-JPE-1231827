
# Technical Report for Class Assignment 1: Version Control with Git

## Introduction

This technical report outlines the progress of Class Assignment 1 (CA1), which  
focused on implementing Git's best practices for version control while also 
investigating an alternative version control system for comparison purposes. The 
assignment was structured into two segments: initially working on the master branch and 
later incorporating branching strategies for feature enhancements and bug fixes.

## Part 1: Direct Work on Master Branch

### Objective

To implement the initial setup and a new feature directly on the master branch
without using additional branches.


### Implementation Steps

#### Setup and Initial Commit

1. Initialize a new Git repository:
    ```bash
   git init
   ```
    - command git initializes a new Git repository
    - command git is assumed to be installed and available in the system
    - command git is assumed to be available in the system's PATH environment variable

2. Add README.md file to the project directory:
    ```bash
    echo "# devops-23-24-JPE-1231827" >> README.md
    ```
    - command echo writes the specified text to the standard output
    - the text is then redirected to the README.md file using the >> operator
    - the README.md file is created in the project directory
    - the text is a markdown heading for the README file

3. Add all files to the staging area:
    ```bash
    git add .
    ```
    - command git adds all files in the project directory to the staging area
    - the dot (.) specifies the current directory as the target for adding files to the staging area

4. Commit the changes to the master branch:
    ```bash
    git commit -m "add README.md"
    ```
    - command git commits the changes in the staging area to the master branch
    - the -m flag specifies the commit message
    - The initial setup and the first commit are now complete
    - The project is now under version control using Git
    - The master branch is the default branch for the project
    - The master branch contains the initial commit

5. Link the local repository to a remote repository:
    ```bash
    git remote add origin https://github.com/filipacardoso/devops-23-24-JPE-1231827.git
    ```
    - command git links the local repository to a remote repository
    - the origin is the default name for the remote repository

6. Push the changes to the remote repository:
    ```bash
    git push -u origin main
   ```
    - command git pushes the changes in the local repository to the remote repository
    - the origin is the default name for the remote repository
    - the main is the default name for the main branch

7. Add CA1 folder to project directory:
    ```bash
    mkdir CA1
    ```
    - command mkdir creates a new directory
    - CA1 is the name of the new directory
    - The new directory is created in the project directory
   

8. Navigate to the project directory (assuming the Tutorial React.js and Spring Data REST Application is already locally available):
   ```bash
   cd path/to/TutorialReactSpringDataREST
   ```
    - command cd changes the current directory
    - path/to/TutorialReactSpringDataREST is the path to the project directory
    - The project directory contains the source code for the Tutorial React.js and Spring Data REST Application
    - The project directory is assumed to be locally available
    - The project directory is assumed to be the root directory for the Git repository

9. Copy the application into a new CA1 folder:
   ```bash
   git mv ~/tut-react-and-spring-data-rest/basic/ ~/CA1/
   cd ../CA1
   ```
-
  - command cp copies the directories and files stated ('.', the current directory), the '-r' notation says it will be copied recursively (all its contents) and '../CA1' is the destination folder
  - command cd changes the current directory



#### Version Tagging

1. Tag the initial version of the application as `v1.1.0` and push the tag to the remote repository:
   ```bash
   git tag v1.1.0 -m "First version"
   git push origin v1.1.0
   ```
    - creates a tag named 'v1.1.0', holding the message stated above (after "-m")
    - pushes (same logic as before) the corresponding tag to the origin of the repository, saving the information about the state of the project in the tag itself


#### New Feature Implementation - Job Years 

1. Creating Issues 
    - Go to the repository on GitHub
    - Click on the "Issues" tab
    - Click on the "New issue" button
    - Fill in the issue title and description
    - Click on the "Submit new issue" button

2. After implementing the new features in the application, add the changes to the staging area:
   ```bash
   git add .
   ```
    - command git adds all files in the project directory to the staging area

3. Commit the changes to the master branch:
    ```bash
    git commit -m "Add job years to the application"
    ```
     - command git commits the changes in the staging area to the master branch
     - the -m flag specifies the commit message

4. push the changes to the remote repository:
   ```bash
   git push origin main
   ```
    - command git pushes the changes in the local repository to the remote repository
    - the origin is the default name for the remote repository
    - the main is the default name for the main branch

5. Tag the new version of the application as `v1.2.0` and push the tag to the remote repository:
    ```bash
    git tag v1.2.0 -m "Added job years implementation"
    git push origin v1.2.0
    ```
     - creates a tag named 'v1.2.0', holding the message stated above (after "-m")

## Part 2: Using Branches for Feature Enhancements and Bug Fixes

### Objective
Utilizing branches to introduce new features and address bugs, 
with the master branch acting as the foundation for the stable version.

### Implementation Steps

#### Feature Implementation - Email Field

1. Create a new issue on GitHub for the new feature - add email field to the application:
   - after creating the issues, they can be associated with specific project branches
   - the issue is created on the repository's "Issues" tab

2. Create a new branch for the email field feature:
   ```bash
    git checkout -b email-field
    ```
     - command git creates a new branch named email-field
     - the -b flag specifies that a new branch should be created
     - the email-field is the name of the new branch

3. Implement the new feature in the application:
    - the new feature is implemented in the class Employee
    - implement tests for the new feature in the class EmployeeTest

4. After implementing the feature, add the changes to the staging area:
    ```bash
    git add .
    ```
     - command git adds all files in the project directory to the staging area

5. Commit the changes to the email-field branch:
    ```bash
    git commit -m "added tests to EmployeeTest class. JobYears added to Employee class"
    git commit -m "#1 added test to class EmployeeTest"
    git commit -m "#2 added method isValidConstructorArgument to class Employee. added tests to verify constructor arguments in class EmployeeTest"
    git commit -m "#3 added email field to Employee constructor and implemented validation of email in isValidConstructorArgument method. added setEmail and getEmail method"
    git commit -m "#4 added tests of email field null and empty"
    ```
     - command git commits the changes in the staging area to the email-field branch
     - the -m flag specifies the commit message

6. Push the changes to the remote repository:
    ```bash
    git push origin email-field
    ```
     - command git pushes the changes in the local repository to the remote repository
     - the origin is the default name for the remote repository
     - the email-field is the name of the branch

7. Merge and return to main branch:
    ```bash
    git checkout main
    git merge --no-ff email-field
    ```
     - command git merges the email-field branch into the main branch
     - command git returns to the main branch

8. Tag the new version of the application as `v1.3.0` and push the tag to the remote repository:
    ```bash
    git tag v1.3.0 -m "Implemented email field"
    git push origin v1.3.0
    ```
     - creates a tag named 'v1.3.0', holding the message stated above (after "-m")

#### Bug Fix - Valid Email 

1. Create a new issue on GitHub for the new feature - validate email field to the application:
    - after creating the issues, they can be associated with specific project branches
    - the issue is created on the repository's "Issues" tab

2. Create a new branch for the email field feature:
    ```bash
    git checkout -b fix-invalid-email
    ```
     - command git creates a new branch named fix-invalid-email
     - the -b flag specifies that a new branch should be created
     - the fix-invalid-email is the name of the new branch

3. Implement the new feature in the application:
    - the new feature is implemented in the class Employee
    - implement tests for the new feature in the class EmployeeTest

4. After implementing the feature, add the changes to the staging area:
    ```bash
    git add .
    ```
    - command git adds all files in the project directory to the staging area

5. Commit the changes to the fix-invalid-email branch:
    ```bash
    git commit -m "#5 implemented method to validate email field in Employee class. added tests to ensure that added method is detecting invalid email"
    ```
    - command git commits the changes in the staging area to the email-field branch
    - the -m flag specifies the commit message
    - the #5 is the issue number associated with the bug fix

6. Push the changes to the remote repository:
    ```bash
    git push origin fix-invalid-email 
    ```
   - command git pushes the changes in the local repository to the remote repository
   - the origin is the default name for the remote repository
   - the email-field is the name of the branch

7. Merge and return to main branch:
    ```bash
    git checkout main
    git merge --no-ff fix-invalid-email 
    ```
    - command git merges the email-field branch into the main branch
    - command git returns to the main branch

8. Tag the new version of the application as `v1.3.1` and push the tag to the remote repository:
    ```bash
    git tag v1.3.1 -m "Implemented email validation"
    git push origin v1.3.1
    ```
    - creates a tag named 'v1.3.1', holding the message stated above (after "-m")

## Alternative Version Control System Analysis

# Technical Report for Class Assignment 1: Version Control with mercurial

## Introduction

This is an alternative implementation to the technical report for Class Assignment 1 
(CA1), focused on an implementation based on Mercurial.

Both Git and Mercurial are examples of distributed version control systems (DVCS), 
providing developers with tools to monitor and oversee alterations made to their 
codebase. Despite their shared purpose, they possess distinct characteristics and share 
commonalities, impacting their applicability depending on project requirements and team 
inclinations.

### Comparison of Git and Mercurial
Git and Mercurial are both distributed version control systems (DVCS) commonly used 
for managing source code. While they share many similarities, there are some key
differences between them, such as:
- Git's lightweight branching system allows for agile experimentation, while Mercurial's 
more permanent branches often lead to the use of clones for feature development. 
- Git has a wider adoption and an extensive array of tools and integrations, 
including platforms such as GitHub, GitLab, and Bitbucket. Mercurial, on the other hand,
has a smaller user base and fewer integrations.

## Part 1: Direct Work on Master Branch

### Objective

To implement the initial setup and a new feature directly on the master branch 
without using additional branches.

### Implementation Steps

#### Setup and Initial Commit

1. Initialize a new mercurial repository:
    ```bash
    hg init
    ```

2. Add README.md file to the project directory:
    ```bash
    echo "# devops-23-24-JPE-1231827" >> README.md
    ```
3. Add all files to the staging area:
    ```bash
    hg add .
    ```

4. Commit the changes to the master branch:
    ```bash
    hg commit -m "add README.md"
    ```

5. Link the local repository to a remote repository:
    ```bash
    hg remote add origin https://github.com/filipacardoso/devops-23-24-JPE-1231827.git
    ```

6. Push the changes to the remote repository:
    ```bash
    hg push origin main
    ```

7. Add CA1 folder to project directory:
    ```bash
    mkdir CA1
    ```

8. Navigate to the project directory:
    ```bash
    cd path/to/TutorialReactSpringDataREST
    ```

9. Copy the application into a new CA1 folder:
    ```bash
    hg mv ~/tut-react-and-spring-data-rest/basic/ ~/CA1/
    cd ../CA1
    ```

#### Version Tagging

#### Version Tagging

1. Tag the initial version of the application as `v1.1.0` and push the tag to the remote repository:
   ```bash
   hg tag v1.1.0 -m "First version"
   hg push origin v1.1.0
   ```

#### New Feature Implementation - Job Years

1. Create New Issue

2. After implementing the new features in the application, add the changes to the staging area:
   ```bash
   hg add .
   ```

3. Commit the changes to the master branch:
    ```bash
    hg commit -m "Add job years to the application"
    ```

4. push the changes to the remote repository:
   ```bash
   hg push origin main
   ```

5. Tag the new version of the application as `v1.2.0` and push the tag to the remote repository:
    ```bash
    hg tag v1.2.0 -m "Added job years implementation"
    hg push origin v1.2.0
    ```
## Part 2: Using Branches for Feature Enhancements and Bug Fixes

### Objective
Utilizing branches to introduce new features and address bugs,
with the master branch acting as the foundation for the stable version.

### Implementation Steps

#### Feature Implementation - Email Field

1. Create a new issue for the new feature - add email field to the application

2. Create a new branch for the email field feature:
   ```bash
    hg checkout -b email-field
    ```

3. Implement the new feature in the application:
   - the new feature is implemented in the class Employee
   - implement tests for the new feature in the class EmployeeTest

4. After implementing the feature, add the changes to the staging area:
    ```bash
    hg add .
    ```
   - command git adds all files in the project directory to the staging area

5. Commit the changes to the email-field branch:
    ```bash
    hg commit -m "added tests to EmployeeTest class. JobYears added to Employee class"
    hg commit -m "added test to class EmployeeTest"
    hg commit -m "added method isValidConstructorArgument to class Employee. added tests to verify constructor arguments in class EmployeeTest"
    hg commit -m "added email field to Employee constructor and implemented validation of email in isValidConstructorArgument method. added setEmail and getEmail method"
    hg commit -m "added tests of email field null and empty"
    ```

6. Push the changes to the remote repository:
    ```bash
    hg push origin email-field
    ```

7. Merge and return to main branch:
    ```bash
    hg checkout main
    hg merge --no-ff email-field
    ```

8. Tag the new version of the application as `v1.3.0` and push the tag to the remote repository:
    ```bash
    hg tag v1.3.0 -m "Implemented email field"
    hg push origin v1.3.0
    ```
#### Bug Fix - Valid Email

1. Create a new issue for the new feature - validate email field in the application

2. Create a new branch for the email field feature:
    ```bash
    hg checkout -b fix-invalid-email
    ```

3. Implement the new feature in the application:
   - the new feature is implemented in the class Employee
   - implement tests for the new feature in the class EmployeeTest

4. After implementing the feature, add the changes to the staging area:
    ```bash
    hg add .
    ```

5. Commit the changes to the fix-invalid-email branch:
    ```bash
    hg commit -m "implemented method to validate email field in Employee class. added tests to ensure that added method is detecting invalid email"
    ```

6. Push the changes to the remote repository:
    ```bash
    hg push origin fix-invalid-email 
    ```

7. Merge and return to main branch:
    ```bash
    hg checkout main
    hg merge --no-ff fix-invalid-email 
    ```

8. Tag the new version of the application as `v1.3.1` and push the tag to the remote repository:
    ```bash
    hg tag v1.3.1 -m "Implemented email validation"
    hg push origin v1.3.1
    ```



