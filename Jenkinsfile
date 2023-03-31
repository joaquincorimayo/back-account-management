pipeline {
    agent any
    tools{
        maven 'maven'
    }
    stages{
        stage('Build Maven') {
            steps {
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/joaquincorimayo/back-account-management']])
                sh 'mvn clean install'
            }
        }

        stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t imjoaquincorimayo/account-management .'
                }
            }
        }

        stage('Push image to Hub'){
            steps{
                script{

                    withCredentials([string(credentialsId: 'PASSDH', variable: 'dockerhubpwd')]) {
                        sh 'docker login -u imjoaquincorimayo -p $dockerhubpwd'
                    }

                    sh 'docker push imjoaquincorimayo/account-management'
                    sh 'docker rmi imjoaquincorimayo/account-management'
                }
            }
        }
    }
    post{
        always{
          sh 'docker logout'
        }
    }
}