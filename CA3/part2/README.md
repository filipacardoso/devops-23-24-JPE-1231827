# Class Assignment 3, Part 2 : Virtualization with Vagrant

### Assignment Overview
The goal of this assignment is to create a Vagrantfile that will create a virtual machine with the necessary dependencies to run the application.

### Create a Vagrant file

A Vagrant file is a configuration file  
that defines the software and resources required to 
create and configure a virtual machine. The  Vagrant file 
is used to create a new virtual machine, configure network
settings, install software packages, and run scripts on
the virtual machine.

For this assignment, a Vagrant file was developed based 
on the provided template from this [repository](https://bitbucket.org/pssmatos/vagrant-multi-spring-tut-demo/).

### Vagrant Configuration

The Vagrant file defines the configuration settings, such as the
Vagrant version and the settings of the virtual machines to be created.

```ruby
Vagrant.configure("2") do |config|
config.vm.box = "ubuntu/focal64"
config.ssh.insert_key = false
```
Two settings are defined:
1. `config.vm.box` :  Specifies the base box to use for the virtual machine. In this case, the `ubuntu/focal64` box was selected, which is an official Ubuntu 20.04 LTS box.
2. `config.ssh.insert_key` : This setting disables the automatic insertion of the SSH key into the virtual machine. It is useful when using a custom SSH key for authentication, which is not required for this assignment.

### 2. Common Provision Settings

The common provisioning settings for all the virtual machines are defined within the Vagrant file.

```ruby
config.vm.provision "shell", inline: <<-SHELL
sudo apt-get update -y
sudo apt-get install -y iputils-ping avahi-daemon libnss-mdns unzip \
    openjdk-17-jdk-headless
# ifconfig
SHELL
```

Two settings are defined:
1. `config.vm.provision` : Defines the provisioning settings for the virtual machine. In this case, a shell script is used to update the package list and install the necessary software packages.
2. The installed packages include:
- `iputils-ping`: Provides network utilities for network troubleshooting.
- `avahi-daemon`: Implements mDNS/DNS-SD service discovery.
- `libnss-mdns`: Provides a Name Service Switch (NSS) module for Multicast DNS (mDNS) name resolution.
- `unzip`: Allows extraction of zip archives.
- `openjdk-17-jdk-headless`: Installs the Java Development Kit (JDK) version 17 without graphical user interface components, essential for running Java applications.


### Database Configuration

The configuration settings for the database virtual machine are defined within the Vagrant file.

```ruby
config.vm.define "db" do |db|
db.vm.box = "ubuntu/focal64"
db.vm.hostname = "db"
db.vm.network "private_network", ip: "192.168.56.11"
```

The `config.vm.define` setting is used to define the virtual machine named "db". Within this block:
- `db.vm.box`: Specifies the base box to use for the virtual machine. In this case, the `ubuntu/focal64` box was selected, which is an official Ubuntu 20.04 LTS box.
- `db.vm.hostname`: Sets the hostname of the virtual machine to "db".
- `db.vm.network "private_network", ip: "192.168.56.11"` : Defines a private network interface with the IP address 192.168.56.11 for the virtual machine.

Port forwarding settings are defined for the database virtual machine to allow access to the database service from the host machine.

```ruby
db.vm.network "forwarded_port", guest: 8082, host: 8082
db.vm.network "forwarded_port", guest: 9092, host: 9092
```

Two port forwarding settings are defined:
- `db.vm.network "forwarded_port", guest: 8082, host: 8082`: Forwards port 8082 from the guest machine to port 8082 on the host machine.
- `db.vm.network "forwarded_port", guest: 9092, host: 9092`: Forwards port 9092 from the guest machine to port 9092 on the host machine.

The H2 database is used for this assignment.

```ruby
db.vm.provision "shell", inline: <<-SHELL
wget https://repo1.maven.org/maven2/com/h2database/h2/1.4.200/h2-1.4.200.jar
SHELL
```

The following steps are performed:
- `db.vm.provision "shell"`: Specifies that the provisioner will run a shell script on the "db" virtual machine.
- `wget https://repo1.maven.org/maven2/com/h2database/h2/1.4.200/h2-1.4.200.jar`: The H2 Database JAR file is downloaded and saved to the current directory on the virtual machine.

### WebServer Configuration

The configuration settings for the web server virtual machine are defined within the Vagrant file.

```ruby
    config.vm.define "web" do |web|
    web.vm.box = "ubuntu/focal64"
    web.vm.hostname = "web"
    web.vm.network "private_network", ip: "192.168.56.10"
```
The following settings are defined:
- `config.vm.define "web" do |web|`: Defines a virtual machine named "web".
- `web.vm.box = "ubuntu/focal64"`: Specifies the base box to use for the "web" virtual machine. In this case, the `ubuntu/focal64` box was selected, which is an official Ubuntu 20.04 LTS box.
- `web.vm.hostname = "web"`: Sets the hostname of the "web" virtual machine to "web".
- `web.vm.network "private_network", ip: "192.168.56.10"`: Defines a private network interface with the IP address `192.168.56.10` for the "web" virtual machine.

This code block is configuring provider-specific settings for the "web" virtual machine using VirtualBox.
```ruby
   web.vm.provider "virtualbox" do |v|
   v.memory = 1024
   end
```
The following settings are defined:
- `web.vm.provider "virtualbox" do |v|`: Specifies the provider-specific settings for VirtualBox for the "web" virtual machine.
- `v.memory = 1024`: Sets the memory (RAM) allocated to the "web" virtual machine to 1024 MB.

This code block is configuring port forwarding for the "web" virtual machine.
```ruby
web.vm.network "forwarded_port", guest: 8080, host: 8080
```
The following port forwarding setting is defined:
- `web.vm.network "forwarded_port", guest: 8080, host: 8080`: Configures port forwarding from port 8080 on the guest (virtual machine) to port 8080 on the host machine.

The provisioning settings for the "web" virtual machine are defined to install the necessary software packages and run the application.

```ruby
web.vm.provision "shell", inline: <<-SHELL, privileged: false
# sudo apt-get install git -y
# sudo apt-get install nodejs -y
# sudo apt-get install npm -y
# sudo ln -s /usr/bin/nodejs /usr/bin/node
sudo apt install -y tomcat9 tomcat9-admin
# If you want to access Tomcat admin web page do the following:
# Edit /etc/tomcat9/tomcat-users.xml
# uncomment tomcat-users and add manager-gui to tomcat user

# Change the following command to clone your own repository!
git clone https://github.com/filipacardoso/devops-23-24-JPE-1231827.git
cd devops-23-24-JPE-1231827/CA2/part2
chmod u+x gradlew
./gradlew clean build
nohup ./gradlew bootRun > /home/vagrant/spring-boot-app.log 2>&1 &
# To deploy the war file to tomcat9 do the following command:
# sudo cp ./build/libs/basic-0.0.1-SNAPSHOT.war /var/lib/tomcat9/webapps
SHELL
```

The script performs the following tasks:
- Installs Tomcat 9 and Tomcat admin.
- Clones a GitHub repository.
- Navigates to the project directory.
- Makes `gradlew` executable.
- Cleans the project and builds it using Gradle.
- Runs the project using Gradle's `bootRun` task with a timeout of 2 minutes.

### Run the VMs
After the setting defined in the Vagrantfile, the virtual machines can be created using the `vagrant up` command.
This command reads the Vagrantfile, creates the virtual machines, and runs the configured scripts to install the necessary software packages and configure the virtual machines.
Once the virtual machines are created and provisioned, the web server is accessed by opening a browser and navigating to the IP address of the web server virtual machine followed by the port number 8080.
The H2 database can be accessed by opening a browser and navigating to the IP address of the database virtual machine followed by the port number 8082 or 9092.


