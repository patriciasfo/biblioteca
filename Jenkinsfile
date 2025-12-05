pipeline {
    agent any

    tools {
        jdk 'jdk-21'
        maven 'Maven3.9.11'
    }

    environment {
            VERSION = "1.0.0" // Define la variable de versión
        }

    stages {
        stage('Show messages'){
            steps {
                bat 'echo "Primer stage del pipeline"'
                bat 'echo "A continuación hacemos checkout del proyecto"'
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

        stage('Crear carpeta con variable'){
            steps {
                bat 'mkdir %VERSION%'
            }
        }
    }
}       
