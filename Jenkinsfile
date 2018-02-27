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
        stage('publish reports') {
        steps {
            unstash 'source'

            script {
                sh 'ls target/jmeter/reports > listFiles.txt'
                def files = readFile("listFiles.txt").split("\\r?\\n");
                sh 'rm -f listFiles.txt'

                for (i = 0; i < files.size(); i++) {
                    publishHTML target: [
                        allowMissing:false,
                        alwaysLinkToLastBuild: false,
                        keepAll:true,
                        reportDir: 'target/jmeter/reports/' + files[i],
                        reportFiles: 'index.html',
                        reportName: files[i]
                    ]
                }
            }
        }
    }
    }
}
