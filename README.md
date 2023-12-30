# Mushroom Predictor

Este proyecto utiliza aprendizaje automático (machine learning) para predecir si un hongo es comestible o venenoso basándose en sus atributos. El modelo se entrena con un conjunto de datos de entrenamiento de hongos y luego se utiliza para hacer predicciones sobre un conjunto de datos de prueba.

![mushroom](https://github.com/martacanirome4/mushroom-predictor/assets/50625677/bccd9e83-a9b2-486f-88ad-23554722d7ec)

## Estructura del Proyecto

- `training_data/`: Contiene el conjunto de datos de entrenamiento en formato ARFF.
- `test_data/`: Contiene el conjunto de datos de prueba en formato ARFF.
- `models/`: Almacena el modelo entrenado después de ejecutar el programa.

## Requisitos

- Java (JRE)
- Weka (biblioteca para aprendizaje automático en Java)

## Uso

1. **Entrenar el Modelo:**
   
   ```bash
   java -jar aprendizaje.jar train

Esto entrena el modelo utilizando el algoritmo J48 y guarda el modelo en el directorio models/.

2. **Realizar predicciones:**

   ```bash
   java -jar aprendizaje.jar predict
   
Esto utiliza el modelo entrenado para hacer predicciones sobre el conjunto de datos de prueba y muestra los resultados en la consola

## **Detalles Técnicos**

El código fuente está en el directorio modelos/.
Modelo.java contiene la lógica para leer instancias, entrenar el modelo y aplicar predicciones.

## **Conjunto de datos utilizado**

El conjunto de datos utilizado consiste en atributos como forma del sombrero, color de la tapa, olor, etc. Se ha obtenido del repositorio:
https://github.com/renatopp/arff-datasets/blob/master/classification/mushroom.arff

También hay información al respeto en: 
https://archive.ics.uci.edu/dataset/73/mushroom

## **Licencia**

Copyright 2023 Marta Canino Romero

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
    http://www.apache.org/licenses/LICENSE-2.0
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


