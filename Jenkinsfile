pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'

            }
        }
        stage('CodeQuality') {
            steps {
                echo 'Testing..'
-Dsonar.host.url=http://sonarqube:9000"
            }
        }
        stage('package') {
            steps {
                echo 'Deploying....'

            }
        }
    }
}
