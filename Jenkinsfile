node{
  stage('SCM Checkout'){
    git 'https://github.com/Mohammadnemer/school-springboot'
  }
  stage('Compile-Package'){
    sh('''#!c:\path\to\bash.exe

echo "I am in bash"
''')
    def mvn =  tool name: 'Maven', type: 'maven'
      sh '${mvn}/bin/mvn package'
        }

  }
