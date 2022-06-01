pipeline {
    agent any
    tools {
         maven 'maven3'
    }
    stages{
        stage('Build'){
            steps{
                  sh script: 'mvn clean package'
            }
        }
        stage('Upload Jar To Nexus'){
            steps{ 
               nexusArtifactUploader artifacts: [
                 [
                   artifactId: 'BookStore',
                   classifier: '',
                   file: 'target/BookStore-0.0.1-SNAPSHOT.jar',
                   type: 'jar'
                 ]
               ],
                 credentialsId: '7ec855eb-e048-47fa-aecc-7f1cb7aa9742',
                 groupId: 'com.th',
                 nexusUrl: '52.1.243.152:8081',
                 nexusVersion: 'nexus3',
                 protocol: 'http', 
                 repository: 'Main', 
                 version: '0.0.1-SNAPSHOT'
            }
        }
    }
 }
