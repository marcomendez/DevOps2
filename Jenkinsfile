pipeline {
    agent any
    options {
       // Only keep the 10 most recent builds
       buildDiscarder(logRotator(numToKeepStr:'10'))
     }
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

        stages {
            stage ('Install') {
              steps {
                // install required gems
                sh 'bundle install'
              }
            }
            stage ('Build2') {
              steps {
                // build
                sh 'bundle exec rake build'
              }

              post {
                success {
                  // Archive the built artifacts
                  archive includes: 'pkg/*.gem'
                }
              }
            }
            stage ('Test2') {
              steps {
                // run tests with coverage
                sh 'bundle exec rake spec'
              }

              post {
                success {
                  // publish html
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
            }
          }
          post {
            always {
              echo "Send notifications for result: ${currentBuild.result}"
            }
          }



    }
}
