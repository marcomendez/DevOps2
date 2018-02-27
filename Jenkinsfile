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
          // publish html report
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
    }
	stage('CodeQuality') {
      steps {
        echo 'Inspecting code..'
        sh './gradlew sonarqube -Dsonar.host.url=http://sonarqube:9000'
      }
    }
    stage('Package') {
      steps {
        echo 'Packaging....'
        sh './gradlew clean war'
      }
	  post {
        success {
          // Archive the built artifacts
          archive includes: 'build/libs/*.war'
        }
      }
    }
  }
}
