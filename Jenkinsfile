node{
  stage('SCM Checkout'){
    git 'https://github.com/Mohammadnemer/school-springboot'
  }
  stage('Compile-Package'){
      def mvn =  tool name: 'Maven', type: 'maven'
      sh '${mvn}/bin/mvn package'
        }

  }
