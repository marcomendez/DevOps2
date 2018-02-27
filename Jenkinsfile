pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
				sh './gradlew clean build'

        publishHTML target: [
            allowMissing: false,
            alwaysLinkToLastBuild: false,
            keepAll: true,
            reportDir: 'coverage',
            reportFiles: 'index.html',
            reportName: 'RCov Report'
          ]
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
				sh './gradlew clean check'
            }
        }
		stage('Package') {
            steps {
                echo 'Packaging..'
				sh './gradlew clean war'
            }
        }
        stage('CodeQuality') {
            steps {
                echo 'Code Quality....'
				sh './gradlew sonarqube -Dsonar.host.url=http://sonarqube:9000'
            }
        }
    }
}
