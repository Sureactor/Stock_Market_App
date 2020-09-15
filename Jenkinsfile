pipeline {
    agent any
    tools {
        maven 'M3'
        jdk 'JDK'
        nodejs 'NODE'
    }
    stages {
         stage('BuildBackend') {
            steps {
                git branch: 'Surendar', url: 'https://github.com/Sureactor/Stock_Market_App'
                dir('Stock') {
                    bat 'mvn -B -DskipTests clean package'
                }
               
            }
        }
        stage('BuildEureka') {
            steps {
                dir('Eureka') {
                    bat 'mvn -B -DskipTests clean package'
                }
            }
        }
        stage('Build User') {
            steps {
                dir('User') {
                    bat 'mvn -B -DskipTests clean package'
                }
            }
        }
    }
}
