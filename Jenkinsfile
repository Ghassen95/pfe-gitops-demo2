pipeline { 
	environment 
	{
	    registry = "touzria/devops-project" 
	    registryCredential = 'dockerhub_id'
	    dockerImage = ''
	    NEXUS_VERSION = "nexus3"
	    NEXUS_PROTOCOL = "http"
	    NEXUS_URL = "localhost:8081"
	    NEXUS_REPOSITORY = "maven-releases"
	    NEXUS_CREDENTIAL_ID = "nexus_cred"
    	}
	agent any 
	stages {
	    
		stage('Cloning Git project') {
		steps { git branch: 'main', url: 'https://github.com/AhmedFouratTouzri/jenkins-sonarqube-nexus-demo' }
		}
		stage('Print Environment') {
            steps {
                echo "${JD_IMAGE}"
            }
		}
		stage('Cleaning up project') {
		steps { bat 'mvn clean' }
		}
		stage('Compiling project') {
		steps { bat "mvn compile" }
		}
		stage('Packaging project') {
		steps { bat "mvn package" }
		}
		stage('Installing artifacts') {
		steps { bat "mvn install" }
		}
		stage("Publishing artifacts to Nexus") 
		{
            	steps {
                script {
                    pom = readMavenPom file: "pom.xml";
                    filesByGlob = findFiles(glob: "target/*.${pom.packaging}");
                    echo "${filesByGlob[0].name} ${filesByGlob[0].path} ${filesByGlob[0].directory} ${filesByGlob[0].length} ${filesByGlob[0].lastModified}"
                    artifactPath = filesByGlob[0].path;
                    artifactExists = fileExists artifactPath;
                    if(artifactExists) {
                        echo "*** File: ${artifactPath}, group: ${pom.groupId}, packaging: ${pom.packaging}, version ${pom.version}";
                        nexusArtifactUploader(
                            nexusVersion: NEXUS_VERSION,
                            protocol: NEXUS_PROTOCOL,
                            nexusUrl: NEXUS_URL,
                            groupId: pom.groupId,
                            version: pom.version,
                            repository: NEXUS_REPOSITORY,
                            credentialsId: NEXUS_CREDENTIAL_ID,
                            artifacts: [
                                [artifactId: pom.artifactId,
                                classifier: '',
                                file: artifactPath,
                                type: pom.packaging],
                                [artifactId: pom.artifactId,
                                classifier: '',
                                file: "pom.xml",
                                type: "pom"]
                            ]
                        );
                    } else {
                        error "*** File: ${artifactPath}, could not be found";
                    }
                }
            }
    	}
		stage('Static code analysis with Sonar') {
		steps { bat "mvn sonar:sonar" }
		}
		stage('jUnit e2e tests') {
		steps { bat "mvn test" }
		}
		stage('Building Docker image') {
		steps { bat "docker build -t $JD_IMAGE ."}
		}
		stage('Publish image to Docker Hub') {
        steps
			{
        		withDockerRegistry([ credentialsId: "dockerhub_id", url: "" ]) 
				{
          			bat  "docker push $JD_IMAGE"
        		}      
          	}
        }
	    stage('Cleaning up local Docker image'){
	    steps { bat "docker rmi $registry:$BUILD_NUMBER" } 
		}
	    stage('Sending email notification')
	    {
		    steps 
		    {
        	    emailext body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}",
        	    recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']],
        	    subject: "Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME}"
    	    }
	    }
    }
}