pipeline {
    agent any

    tools {
        maven 'Maven 3.8.5'
        jdk 'Java 21'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/GoralTomaszGorski/shopapp-selenium.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }
    }
}
