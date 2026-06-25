# Hospital VM

Backend Spring Boot para gestion de pacientes, medicos, fichas y atenciones.

## Requisitos

- Java 25
- MySQL local
- Usuario MySQL `root` sin password, o ajustar `src/main/resources/application.properties`

## Ejecutar

```powershell
.\mvnw.cmd spring-boot:run
```

La aplicacion usa la base `db_hospital_vm`. Si no existe, MySQL la crea por la opcion `createDatabaseIfNotExist=true`.

Flyway crea las tablas y carga datos iniciales:

- 3 tipos de usuario
- 3 medicos

Endpoint de prueba:

```text
GET http://localhost:8080/api/v1/medicos
```

## Si vienes de una base con errores anteriores

Si tu base `db_hospital_vm` ya tenia tablas incompletas o una tabla `flyway_schema_history` mal creada, recrea la base antes de ejecutar esta version. Flyway solo aplica migraciones pendientes; no repara automaticamente una migracion ya marcada como aplicada.

## Verificacion

Los tests usan una base separada llamada `db_hospital_vm_test_codex` para no tocar los datos de desarrollo.

```powershell
.\mvnw.cmd test
```
