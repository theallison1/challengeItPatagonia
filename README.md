# Challenge Backend - Spring Boot

Este proyecto es una solución backend desarrollada en **Spring Boot** para gestionar empresas y transferencias. Incluye funcionalidades para adherir empresas, listar empresas adheridas en el último mes, listar empresas que realizaron transferencias en los últimos 30 días y crear transferencias.

---

## Requisitos

- **Java 17** o superior.
- **Maven** para la gestión de dependencias.
- **H2 Database**: Base de datos en memoria utilizada para desarrollo y pruebas.
- **Swagger**: Documentación interactiva de la API.

---

## Configuración

1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/tu-usuario/challenge-backend.git
   cd challenge-backend
Instalar dependencias:


mvn clean install
Ejecutar la aplicación:

mvn spring-boot:run
La aplicación estará disponible en http://localhost:8080.

Estructura del Proyecto
src/main/java: Código fuente de la aplicación.

com.example.challenge.domain.model: Entidades del dominio (Empresa, Transferencia).

com.example.challenge.domain.repository: Repositorios para acceder a la base de datos.

com.example.challenge.domain.service: Lógica de negocio.

com.example.challenge.application.controller: Controladores REST.

src/main/resources: Configuraciones y scripts.

application.properties: Configuración de la aplicación.

data.sql: Datos iniciales para la base de datos (opcional).

src/test: Pruebas unitarias y de integración.

Endpoints
1. Adherir una Empresa
Método: POST

Ruta: /empresas/adherir

Body:


{
  "cuit": "30-12345678-9",
  "razonSocial": "Empresa Ejemplo",
  "fechaAdhesion": "2023-10-01"
}
Respuesta:

json
Copy
{
  "id": 1,
  "cuit": "30-12345678-9",
  "razonSocial": "Empresa Ejemplo",
  "fechaAdhesion": "2023-10-01"
}
2. Listar Empresas Adheridas en el Último Mes
Método: GET

Ruta: /empresas/adheridas-ultimo-mes

Respuesta:


[
  {
    "id": 1,
    "cuit": "30-12345678-9",
    "razonSocial": "Empresa Ejemplo",
    "fechaAdhesion": "2023-10-01"
  }
]
3. Listar Empresas que Hicieron Transferencias en los Últimos 30 Días
Método: GET

Ruta: /empresas/transferencias-ultimo-mes

Respuesta:



[
  {
    "id": 1,
    "cuit": "30-12345678-9",
    "razonSocial": "Empresa Ejemplo",
    "fechaAdhesion": "2023-10-01"
  }
]
4. Crear una Transferencia
Método: POST

Ruta: /transferencias

Body:


{
  "importe": 1000.50,
  "cuentaDebito": "123456",
  "cuentaCredito": "654321",
  "fechaTransferencia": "2023-10-15",
  "empresaId": 1
}
Respuesta:

json

{
  "id": 1,
  "importe": 1000.50,
  "cuentaDebito": "123456",
  "cuentaCredito": "654321",
  "fechaTransferencia": "2023-10-15",
  "empresaId": 1
}
Documentación de la API con Swagger
La documentación interactiva de la API está disponible en:

Swagger UI: http://localhost:8080/swagger-ui.html

OpenAPI (JSON): http://localhost:8080/v3/api-docs

Pruebas
Pruebas Unitarias
Las pruebas unitarias se encuentran en el directorio src/test/java. Para ejecutarlas:


mvn test
Pruebas de Integración
Las pruebas de integración también están en src/test/java. Se ejecutan junto con las pruebas unitarias.

Base de Datos H2
La aplicación utiliza una base de datos H2 en memoria. Puedes acceder a la consola de H2 en:

URL: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:testdb

Usuario: sa

Contraseña: (vacío)

Licencia
Este proyecto está bajo la licencia MIT. Consulta el archivo LICENSE para más detalles.

