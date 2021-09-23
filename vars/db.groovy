import groovy.sql.Sql
import java.text.SimpleDateFormat
import java.time.LocalDateTime
def branch = "${env.BRANCH_NAME}"

// def call(){
//     def date = new Date()
//     sdf = new SimpleDateFormat("MM/dd/yyyy")
//     println sdf.format(date);
// }

// def dt = LocalDateTime.now()
// println dt



def inserting(Map config = [:]) {
    def url = 'jdbc:postgresql://localhost:5432/imqsdb'
    def user = 'postgres'
    def password = 'newPassword'
    def driver = 'org.postgresql.Driver'
    def sql = Sql.newInstance(url, user, password, driver)
   sql.execute """
      CREATE TABLE IF NOT EXISTS logstest5 (
   ID  serial PRIMARY KEY,
   logged_date DATE NOT NULL DEFAULT CURRENT_DATE,
    machine_name TEXT NOT NULL
);
   """

         
     echo "${env.BRANCH_NAME}";

    

    sql.execute "INSERT INTO logstest5(machine_name) VALUES (${config.branch_name})"
    sql.close()                                                                                                                                                                                                                                                                      
}
