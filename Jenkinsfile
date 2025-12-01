pipeline {
    agent any

    tools {
        jdk 'jdk-21'
        maven 'Maven3.9.11'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'master',
                    url: 'https://github.com/patriciasfo/biblioteca.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Package') {
            steps {
                bat 'mvn package'
            }
            post {
                success {
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
            }
        }

        stage('Stop Previous Instance') {
            steps {
                bat """
                    if pgrep -f "biblioteca.jar"; then
                        echo "Stopping previous instance..."
                        pkill -f biblioteca.jar
                    fi
                """
            }
        }

        stage('Deploy') {
            steps {
                bat """
                    echo "Starting new instance..."
                    nohup java -jar target/*.jar > app.log 2>&1 &
                """
            }
        }
    }
}
