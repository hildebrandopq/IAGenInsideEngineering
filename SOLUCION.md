Tengo un ejercicio de diseño de software en Java. Necesito un sistema de videoclub llamado 'Videoclub Don Mario' que cumpla lo siguiente: registrar películas físicas o digitales con disponibilidad, permitir al cliente seleccionar películas por número, calcular el precio total según membresía (BASICA = precio normal, PREMIUM = 20% descuento), y mostrar un recibo detallado. Las películas son: [Fisica] Interestellar $8000 disponible, [Fisica] El Padrino $7000 no disponible, [Digital] Inception $5000 disponible, [Digital] Matrix $6000 disponible. Aplica patrones de diseño apropiados (Strategy, Template Method o similares), principios SOLID, polimorfismo y encapsulamiento. Genera el código Java organizado en paquetes: model, service, enums.

RESPUESTADE LA IA 

Patrones de Diseño Identificados
1. Strategy (patrón principal)
   El cálculo del precio varía según la membresía del cliente. En lugar de usar if/else para cada tipo, el enum TipoMembresia encapsula la estrategia de descuento correspondiente. Cada valor del enum lleva su propio porcentaje, y CalculadorPrecio lo consume sin saber qué tipo es.
2. Template Method (implícito en la jerarquía de Pelicula)
   La clase abstracta Pelicula define el esqueleto del comportamiento (getTitulo(), getPrecio(), toString()), y las subclases PeliculaFisica y PeliculaDigital solo implementan el método variable: getTipo().
3. Single Responsibility aplicado como separación de servicios
   CalculadorPrecio y GeneradorRecibo son clases de servicio independientes, cada una con una única responsabilidad.

ESTRUCTURA DEL PROYECTO
videoclub/
└── src/main/java/videoclub/
├── enums/
│   └── TipoMembresia.java
├── model/
│   ├── Pelicula.java          ← clase abstracta
│   ├── PeliculaFisica.java
│   └── PeliculaDigital.java
├── service/
│   ├── CalculadorPrecio.java
│   └── GeneradorRecibo.java
└── VideoClubApp.java          ← main

