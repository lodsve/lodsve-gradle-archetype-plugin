# @artifactId@

This project demonstrates Spring Data MongoDB repositories and switching between the default MongoDB client and a named `archive` data source.

## Run

Set `MONGODB_URI` and `MONGODB_ARCHIVE_URI` if MongoDB is not available at the local defaults in `application.yml`, then start the application:

```shell
gradle bootRun
```

The default data source endpoints are `POST /demo/save`, `GET /demo/{id}`, and `GET /demo`. The archive data source endpoints are `POST /demo/archive/save`, `GET /demo/archive/{id}`, and `GET /demo/archive/list`. Prefix these paths with the configured `server.servlet.context-path` when it is not `/`.

Example request body:

```json
{
  "name": "Alice",
  "age": 30
}
```
