node{
  stage('SCM Checkout'){
    git 'https://github.com/Mohammadnemer/school-springboot.git'
  }
  stage('Compile-Package'){
      def mvn =  tool name: 'Maven', type: 'maven'
      sh '${mvn}/bin'
        }
  
  }
