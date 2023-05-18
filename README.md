# Esercizio - Spring Boot - Test CRUD
* scrivere un'applicazione Spring Boot con le dipendenze necessarie che:
  * ha un'entità chiamata "Studente" con le seguenti colonne:
    * una chiave primaria
    * `nome`
    * `cognome`
    * un booleano `isWorking`
  * ha un servizio di base per modificare il valore `isWorking`
  * dispone di un controller per le seguenti operazioni CRUD:
    * (1) creare un nuovo `Studente`
    * (2) ottenere un elenco di tutti gli `Studenti`
    * (3) ottenere uno `Studente` specifico tramite:
      * passando la chiave primaria come variabile di percorso
    * (4) aggiornando la chiave primaria di uno `Studente` mediante:
      * passando la chiave primaria come variabile di percorso
      * passando uno `Studente` nel corpo della richiesta
    * (5) aggiornando il valore `isWorking` tramite:
      * passando la chiave primaria come variabile di percorso
      * passando un parametro di richiesta chiamato `working`
    * (6) eliminazione di uno "Studente".
* test utilizzando un database fittizio `H2` con il profilo `test`:
  * (a) il responsabile del trattamento
  * (b) il servizio

# Exercise - Spring Boot - CRUD test
* write a Spring Boot application with the necessary dependencies that:
  * has an entity called `Student` with the following columns:
    * a primary key
    * `name`
    * `surname`
    * a boolean `isWorking`
  * has a basic service for changing the `isWorking` value
  * has a controller for the following CRUD operations:
    * (1) creating a new `Student`
    * (2) getting a list of all the `Student`s
    * (3) getting a specific `Student` by:
      * passing the primary key as path variable
    * (4) updating the primary key of a `Student` by:
      * passing the primary key as path variable
      * passing a `Student` in the request body
    * (5) updating the `isWorking` value by:
      * passing the primary key as path variable
      * passing a request param called `working`
    * (6) deleting a `Student`
* test using an `H2` mock database with the profile `test`:
  * (a) the controller
  * (b) the service
