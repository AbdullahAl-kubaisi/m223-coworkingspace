# ZLI - Multi-User-Applikationen realisieren 

Dieses Projekt verwendet Quarkus "Java Framework". Die offizielle Website: https://quarkus.io/.

Das Projekt ist besteht aus einer einfachen REST-API, die es ermöglicht, zu erstellen, zu lesen, zu aktualisieren, zu löschen von
Buchungen und Benutzer: https://github.com/AbdullahAl-kubaisi/m223-coworkingspace.git

# Test-Daten : Coworking Space

Die Testdaten befinden sich in /src/main/resources/import.sql.

## Setup

1. Machen Sie eine Kopie vom Projekt(Fork).
1. Stellen Sie sicher, dass der Postgres-Server auf „Port 5432“ läuft.
1. Öffnen Sie das Projekt in dienen Editor.


## Startup

1. `./mvnw compile quarkus:dev` Projekt starten
2. Gehen Sie auf http://localhost:8080.
3. http://localhost:8080/q/swagger-ui/.

## Database

Die Daten werden in einer PostgreSQL-Datenbank gespeichert. In der Entwicklungsumgebung wird diese in der docker-compose-yml konfiguriert.

Datenbankadministration
Über http://localhost:5050 ist PgAdmin4 erreichbar. Damit lässt sich die Datenbank komfortabel verwalten. Der Benutzername lautet zli@example.com und das Passwort zli*123. Die Verbindung zur PostgreSQL-Datenbank muss zuerst mit folgenden Daten konfiguriert werden:


## Database setup

- Host name/address:`db`
- Port: `5432`
- username: `postgres`
- password: `postgres`


## automated testings

Die automatischen Tests können mit ./mvnw quarkus:test ausgeführt werden. Für die automatischen Tests wird nicht die PostgreSQL-Datenbank verwendet, sondern eine H2-Datenbank, welche sich im Arbeitsspeicher während der Ausführung befindet.

## Mock Data

<table>
 <tr>
    <td><b style="font-size:15px">Admin</b></td>
    <td><b style="font-size:15px">Member</b></td>
 </tr>
 <tr>
    <td>

- `email` leo.ll@hotmail.com
- `password` Leo123
    </td>
    <td>
- `email` manu44@gmail.com
- `password` Manuuu123
    </td>
 </tr>
</table>
