pipeline {
    agent any

    tools {
        jdk 'jdk-21'
        maven 'Maven3.9.11'
    }

    stages {
        stage('Show message'){
            steps {
                bat 'echo "Primer stage del pipeline"'
                bat 'echo "A continuación hacemos Checkout del proyecto"'
            }
        }

        stage('Checkout proyecto'){
            steps {
                git branch: 'master',
                    url: 'https://github.com/patriciasfo/biblioteca.git'
            }
        }

        stage('Maven clean'){
            steps {
                bat 'mvn clean'
            }
        }
    }
}       
