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
                dir('Eureka') {
                    bat 'mvn -B -DskipTests clean package'
                }
                dir('User') {
                    bat 'mvn -B -DskipTests clean package'
                }
            }
        }
    }
}
