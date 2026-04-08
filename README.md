# Práctica 6: Servicios Web (Arquitectura de Microservicios)

Este repositorio contiene la implementación de un sistema distribuido orientado a servicios web para la gestión operativa de una franquicia comercial. La arquitectura está diseñada para aislar los dominios de datos y garantizar la comunicación síncrona interna mediante Spring Boot y Spring Cloud.

## Tecnologías y Requisitos Previos
* Java Development Kit (JDK) 17
* Apache Maven (versiones LTS para compatibilidad de dependencias)
* Entorno de desarrollo (Apache NetBeans recomendado)

## Topología de la Red
El ecosistema consta de cuatro componentes independientes. Para evitar colisiones y asegurar el aislamiento, operan en los siguientes puertos TCP:
* **Eureka Server** (Registro y descubrimiento): `localhost:8761`
* **MS-Inventario** (Lógica de almacén y persistencia H2): `localhost:8082`
* **MS-Ventas** (Orquestación y consumo interno vía OpenFeign): `localhost:8083`
* **API Gateway** (Punto de entrada unificado y enrutamiento): `localhost:8080`

## Instrucciones de Ejecución
Para garantizar que el enrutamiento dinámico funcione correctamente, los proyectos **deben inicializarse en el siguiente orden estricto**:

1. **eureka-server:** Compilar y ejecutar primero. Validar que el panel de control esté activo accediendo a `http://localhost:8761` desde un navegador web.
2. **ms-inventario:** Ejecutar el proyecto. La base de datos volátil H2 se inicializará automáticamente en memoria con el catálogo base.
3. **ms-ventas:** Ejecutar el proyecto. 
4. **api-gateway:** Ejecutar al final. 

*Nota de despliegue: Una vez inicializados todos los módulos, se recomienda esperar aproximadamente 30 segundos. Este tiempo es necesario para que Eureka registre completamente las instancias y propague los metadatos de red (heartbeats) hacia el Gateway y el servicio de Ventas.*

## Pruebas de Integración (Endpoints)
De acuerdo con el diseño arquitectónico, los clientes externos no tienen acceso directo a los puertos 8082 y 8083. Toda petición debe canalizarse a través del Gateway.

Para probar la traza completa de comunicación inter-servicio (B2B), ejecutar una petición `GET` a la siguiente ruta:
* **URL:** `http://localhost:8080/api/ventas/ver-disponibilidad`

**Flujo esperado:** El Gateway intercepta la petición, localiza el servicio de ventas y redirige el tráfico. Ventas utiliza su cliente OpenFeign para solicitar asíncronamente el catálogo al servicio de inventario. El JSON resultante viaja de regreso por todas las capas hasta el cliente.

---
**Autor:** Diaz Torres Jonathan Samuel
**Materia:** Sistemas Distribuidos
