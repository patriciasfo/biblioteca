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
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
            }
            post {
                success {
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
            }
        }

        stage('Stop Previous Instance') {
            steps {
                sh """
                    if pgrep -f "biblioteca.jar"; then
                        echo "Stopping previous instance..."
                        pkill -f biblioteca.jar
                    fi
                """
            }
        }

        stage('Deploy') {
            steps {
                sh """
                    echo "Starting new instance..."
                    nohup java -jar target/*.jar > app.log 2>&1 &
                """
            }
        }
    }
}
