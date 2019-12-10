node{
  stage('SCM Checkout'){
    git 'https://github.com/Mohammadnemer/school-springboot.git'
  }
  stage('Compile-Package'){
        sh 'mvn-package'
      def mvn =  tool name: 'Maven', type: 'maven'
      sh '${mvn}/bin'
        }

  }
