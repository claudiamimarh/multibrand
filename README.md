# Arquitectura
Este servicio REST se ha desarrollado en Java 21 y Spring Boot  utilizando los principios de la
Arquitectura Hexagonal (Ports & Adapters), principios SOLID y diseño guiado por el dominio (DDD). 

## Estructura del proyecto
com.store.multibrand
│
├── domain/ --> Núcleo de Negocio 
│ ├── model/
│ │ └── Price.java 
│ └── port/
│ ├── input/
│ │ └── GetApplicablePriceUseCase.java --> Interfaz de caso de uso (API del dominio)
│ └── output/
│ └── PriceRepositoryPort.java --> Puerto de persistencia
│
├── application/ --> Casos de Uso e Implementación del Negocio
│ └── usecase/
│ └── GetApplicablePriceUseCaseImpl.java
│
└── infrastructure/ --> Adaptadores Tecnológicos (Detalles de Implementación)
├── adapter/
│ ├── input/
│ │ └── rest/
│ │ ├── PriceController.java --> Adaptador HTTP REST
│ │ └── dto/
│ │ └── PriceResponse.java --> DTO, salida del endpoint
│ └── output/
│ └── persistence/
│ ├── PricePersistenceAdapter.java --> Implementación del puerto de persistencia
│ ├── SpringDataPriceRepository.java --> Repositorio Spring Data JPA
│ └── PriceEntity.java --> Mapeo relacional para BD H2
└── config/
└── PriceConfig.java

### Diseño del API REST

GET /api/v1/prices

Parámetros de Entrada (Query Params)
  Parámetro         Tipo       Descripción                                   Ejemplo
applicationDate    String    Fecha y hora objetivo de la tarifa.             2020-06-14T16:00:00
productId           Long     Identificador único del producto.               35455
brandId             Long     Identificador de la cadena comercial(1 = ZARA).   1

Formato de Salida (JSON Response)
{
  "productId": 35455,
  "brandId": 1,
  "priceList": 2,
  "startDate": "2020-06-14T15:00:00",
  "endDate": "2020-06-14T18:30:00",
  "price": 25.45
}

#### Ejecución

1. Compilar y Ejecutar Pruebas
  mvn clean test

2. Levantar el Servidor Local
  mvn spring-boot:run
