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
        stage('Show message'){
            steps {
                bat 'echo "Primer stage del pipeline"'                
            }
        }

        stage('Checkout proyecto'){
            steps {
                git branch: 'master',
                    url: 'https://github.com/patriciasfo/biblioteca.git'
            }
            post {
                success {
                    bat 'echo "Se hizo el checkout del proyecto"'
                }
                failure {
                    bat 'echo "Ocurrió un error al realizar el checkout del proyecto"'
                }
                always {
                    bat 'echo "Mensaje que se muestra siempre"'
                }
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

        stage('Copiar ficheros'){
            steps {
                bat 'copy *.jar %VERSION%'
            }
        }

        /*stage('Deploy') {
            steps {
                bat """
                    echo "Starting deploy..."
                    java -jar target/ExamenMOC_PSF-${VERSION}.jar
                """
            }
        }*/
    }
}       
