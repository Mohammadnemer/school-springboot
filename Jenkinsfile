node{
   environment {
    PATH = "C:\\Program Files\\Git\\usr\\bin;C:\\Program Files\\Git\\bin;${env.PATH}"
      stage('SCM Checkout'){
        git 'https://github.com/Mohammadnemer/school-springboot'
      }
      stage('Compile-Package'){
        def mvn =  tool name: 'Maven', type: 'maven'
        sh '${mvn}/bin/mvn package'
            }
   }
  }
