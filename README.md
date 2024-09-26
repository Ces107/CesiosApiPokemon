# CesiosPokemonApi

CesiosPokemonApi es una API desarrollada en Java que te permite interactuar con datos de Pokémon de manera sencilla. Esta guía te mostrará cómo importar este proyecto como una dependencia en tu propio proyecto Java usando Maven.

## Requisitos Previos

- Java 16 o superior
- Apache Maven instalado
- Acceso al repositorio de GitHub de CesiosPokemonApi

## Instalación

Para usar CesiosPokemonApi como una dependencia en tu proyecto, sigue los siguientes pasos:

### 1. Clona y empaqueta el proyecto

Primero, clona el repositorio de GitHub:

```bash
git clone https://github.com/tu-usuario/CesiosPokemonApi.git
```

Cambia al directorio del proyecto clonado:

```bash
cd CesiosPokemonApi
```

Empaqueta el proyecto para instalarlo en tu repositorio local de Maven:

```bash
mvn clean install
```

Este comando compilará y empaquetará el proyecto, y lo instalará en tu repositorio local de Maven (`.m2`).

### 2. Agrega la dependencia en tu proyecto

En el archivo `pom.xml` de tu proyecto, agrega la siguiente dependencia:

```xml
<dependencies>
    <dependency>
        <groupId>com.laberit.sina.bootcamp.extra</groupId>
        <artifactId>CesiosPokemonApi</artifactId>
        <version>1.0.0-SNAPSHOT</version>
    </dependency>
</dependencies>
```

Con esto, ya puedes usar la API en tu proyecto Java.