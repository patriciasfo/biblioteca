pipeline {
    agent any

    tools {
        jdk 'JDK17'
        maven 'Maven3'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
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
                    if pgrep -f "api-demo.jar"; then
                        echo "Stopping previous instance..."
                        pkill -f api-demo.jar
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
