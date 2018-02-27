pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
              sh 'gradle clean Build'
                echo 'Building..'
            }
        }
        stage('Test') {
            steps {
                sh 'gradle clean check'
                echo 'Testing..'

            }
        }
        stage('CodeQuality') {
            steps {
                echo 'Testing..'
                 sh " clean"
                     "-Dsonar.host.url=http://sonarqube:9000"
            }
        }
        stage('package') {
            steps {
            sh 'gradle clean war'
                echo 'Deploying....'

            }
        }
    }
}
