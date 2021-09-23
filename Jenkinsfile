def branch = "${env.BRANCH_NAME}"
def check_count=0
def flag = 0
@Library('first-shared-lib') _
pipeline {
  agent any
  stages {
    stage('checking restapi') {
      steps {
        script {
          arr = restapi.listsOfMachine()
          for(i=0;i<arr.size();i++) {
            if(arr[i].Name == "${branch}") {
              flag = 1
            }
          }
          
          if(flag == 1) {
            echo "machine already exist update the machine"
            restapi.updateMachine(branch_name: "${branch}");
            sleep 5;
          } else {
            echo "creating the machine"
            status = restapi.createMachine(branch_name: "${branch}");
          
            if(status == 200) {
              echo "Machine Created Successfully"
              
              for(check_out=0; check_out>=0; check_count++) {
                status_code = restapi.startMachine(branch_name: "${branch}");
                echo "${status_code}"
                if(status_code == 200) {
                  echo "Success"
                  return 0;
                }
                echo "${check_count}"
                if(check_count>=3) {
                  print("Giving up, machine taking too long time to create. Contact SysOps");
                  return 0;
                }
                sleep(60);
              }
          
            }
          }
          
        }
      }
    }
  }
}
