# Class Assignment 3, Part 1 : Virtualization with Vagrant

### Assignment Overview
In this assignment, a virtualized environment is used to migrate and run the application developed in the previous assignment. 

### First Steps
This section outlines the steps to set up and configure the virtual machine using VirtualBox ina Windows 11 machine, along with the installation of the necessary tools for the projects.

### Creating the Virtual Machine

1. *Download and Install VirtualBox*: 
- Start by downloading VirtualBox from [Oracle's website](https://www.virtualbox.org/).


2. *Setting Up a New VM*:
- Open VirtualBox/UTM and click on "New" to create a new virtual machine.
- Name your VM (e.g., "UbuntuDev") and choose "Linux" as the type and "Ubuntu (64-bit)" as the version.
- Allocate memory (RAM): Recommended to set at least 2048 MB for adequate performance.
- Create a virtual hard disk: Choose VDI (VirtualBox Disk Image) and allocate at least 20 GB of space. Set the storage on the physical hard disk as dynamically allocated.

3. *Install Ubuntu*:
- Download the Ubuntu Server ISO file from [Ubuntu's official site](https://ubuntu.com/download/server).
- Mount the ISO file to your VM: In VirtualBox, select your VM, click on "Settings," go to "Storage," click on "Empty" under Controller: IDE, then click on the disk icon next to "Optical Drive" and select "Choose a disk file..." Locate and select your downloaded ISO file.
- Start the VM and follow the on-screen instructions to install Ubuntu. During installation, select the standard utilities for a server and, if prompted, install OpenSSH server to enable remote connections.


4. *Virtualization and Networking Setup*:

    4.1 *Create a Host-Only Network*:
   - Open your VM application (e.g., VirtualBox).
   - Navigate to the **Host Network Manager**.
   - Click on **Create** to add a new host-only network.
   - Name and configure this network within my VM's network settings.

    4.2 *Setup Networking for the VM*:
   - In your VM's settings, set **Network Adapter 2** to be a **Host-only Adapter**.
   - Assign an appropriate IP from this range to the adapter, such as `192.168.56.5`.

5. *VM Setup*
- Start your VM and log in.
- Update package repositories:
  ```bash
  sudo apt update
  ```
- Install necessary network tools:
  ```bash
  sudo apt install net-tools
  ```
- Configure the network interface by editing the Netplan configuration file:
  ```bash
  sudo nano /etc/netplan/01-netcfg.yaml
  ```

-This is how the `01-netcfg.yaml`should look like:

    network:
        version: 2
        renderer: networkd
        ethernets:
            enp0s3:
                dhcp4: yes
            enp0s8:
                addresses:
                    - 192.168.56.5/24

- Apply the changes with:
  ```bash
  sudo netplan apply
  ```

### Software Installation

1. *Install Java Development Kit (JDK), Git, Maven and Gradle*:
- Install the OpenJDK 17:
  ```bash
  sudo apt install openjdk-17-jre
  ```
If different JDK versions are installed, chose the desired version with:
  ```bash
  sudo update-alternatives --config java
  ```
- Install Git:
  ```bash
    sudo apt install git
    ```
- Install Maven:
    ```bash
    sudo apt install maven
    ```
- Install Gradle:
    ```bash
    sudo apt install gradle
    ```
- Verify the installations:
    ```bash
    git --version
    java -version
    mvn -version
    gradle -version
    ```

These steps will ensure that the necessary tools are installed and ready for the project.

### Cloning the Repository

1. Change to the desired directory.

Since the project's repository was still private, 
an SSH key was generated and added to the GitHub account to allow 
the repository to be cloned.
2. Generate an SSH key to connect to the repository:
    ```bash
      ssh-keygen -t rsa
      cat ~/.ssh/id_rsa.pub
      ```
The generted SSH key should be copied and added to the GitHub account.

3. Clone the project repository:
    ```bash
    git clone git@github.com:filipacardoso/devops-23-24-JPE-1231827.git
    ```

#### Setting Up the Projects


**Setting Up CA1**:

1. Navigate to the project directory:
      ```bash
      cd devops-23-24-JPE-1231827/CA1/basic
      ```
   
2. Give executing permissions to Maven Wrapper:
      ```bash
      chmod +x mvnw
      ```
   
3. Build the project using Maven:
      ```bash
      ./mvnw clean install
      ```
4. Run the project:
      ```bash
      ./mvnw spring-boot:run
      ```

Open your browser and enter the VM's IP address followed by port 8080.

**Setting Up CA2 Part 1**:

1. Navigate to the project directory:
      ```bash
      cd devops-23-24-JPE-1231827/CA2/part1
      ```
2. Give executing permissions to Gradle Wrapper:
      ```bash
      chmod +x gradlew
      ```
3. Build the project using Gradle:
      ```bash
       ./gradlew build
      ```
4. Run the server in the VM:
      ```bash
      ./gradlew runServer
      ```
5. Run the client in the computer terminal:
    ``` bash
    gradle runClient --args="192.168.56.5 59001"
    ```

The chatroom should be accessible.
 
**Setting Up CA2 Part 2**:

1. Navigate to the project directory:
      ```bash
      cd devops-23-24-JPE-1231827/CA2/part2
      ```
2. Build the project using Gradle:
      ```bash
       ./gradlew build
      ```
3. Run the server in the VM:
    ```bash
    ./gradlew bootRun
    ```

To access the project, open a browser and enter the VM's IP address followed by port 8080.

### Conclusion

This assignment provided an overview of the steps to set up a virtualized environment using Vagrant and VirtualBox. The installation of the necessary tools and the configuration of the VM were detailed, along with the setup of the projects from previous assignments. The completion of these steps ensures that the projects can be run successfully in the virtualized environment.
