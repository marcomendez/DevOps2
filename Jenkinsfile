pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
				sh './gradlew clean build'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
				sh './gradlew clean check'
            }
			post {
			success {
			  // publish html
			  publishHTML target: [
				  allowMissing: false,
				  alwaysLinkToLastBuild: false,
				  keepAll: true,
				  reportDir: 'build/reports/tests/test/',
				  reportFiles: 'index.html',
				  reportName: 'Test Report'
				]
			}
        }
        stage('Pachage') {
            steps {
                echo 'Deploying....'
				sh './gradlew clean war'
            }
			post {
				success {
				  // Archive the built artifacts
				  archive includes: 'build/libs/*.war'
				}
			}
        }
		stage('CodeQuality') {
            steps {
                echo 'Sonar....'
				sh './gradlew sonarqube -Dsonar.host.url=http://10.28.133.26:9000'
            }
        }
    }
}
