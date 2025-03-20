# 🍄 Proyecto de Aprendizaje Automático - Predicción de Comestibilidad de Setas

![Version](https://img.shields.io/badge/version-1.0.0-green)
![Java](https://img.shields.io/badge/language-Java-blue)
![Weka](https://img.shields.io/badge/tool-Weka-orange)
![License](https://img.shields.io/badge/license-Apache%202.0-lightgrey)

**Predice si un hongo es comestible o venenoso basándose en atributos mediante Aprendizaje Automático (ML)**  
Entrenado con el algoritmo **J48 (ID3)** y datos históricos reales sobre setas, este proyecto usa **Weka** y Java para predecir la comestibilidad de nuevas muestras.

![mushroom](https://github.com/martacanirome4/mushroom-predictor/assets/50625677/bccd9e83-a9b2-486f-88ad-23554722d7ec)

---

## 🌟 Descripción

1. Se eligió el problema de predicción sobre si una seta es **comestible** o **venenosa**.
2. Se utilizó el dataset `mushroom.arff` con atributos como olor, forma del sombrero, color, hábitat...
3. Se evaluaron varios algoritmos en **Weka** y se seleccionó **J48** por su precisión.
4. El modelo entrenado se usa para predecir datos nuevos y mostrar los resultados.

<img width="793" alt="J48-tree-view" src="https://github.com/martacanirome4/MushroomEdibilityPredictor/assets/50625677/513ec130-8ce3-471e-8fae-2a3581863653">

> El atributo **odor** (olor) es el más determinante según el árbol generado.

---

## 🔍 Estructura del Proyecto

- `training_data/` - Datos de entrenamiento (`.arff`)
- `test_data/` - Datos de prueba (`.arff`)
- `models/` - Modelos entrenados

---

## 📅 Requisitos

- Java (JRE)
- Weka (ML para Java)

---

## 🚀 Uso del Programa

1. Clona el repositorio
2. Navega al directorio del proyecto
3. Compila y empaqueta en `.jar`:
```bash
make jar
```
4. Ejecuta el programa:
```bash
java -jar aprendizaje.jar
```
> Resultado: Muestra si cada seta es **comestible** (`e`) o **venenosa** (`p`).

<img width="1154" alt="results" src="https://github.com/martacanirome4/MushroomEdibilityPredictor/assets/50625677/5ce146eb-0d2b-4885-8567-5868a503540f">

---

## 📊 Conjunto de Datos

- Fuente: [arff-datasets](https://github.com/renatopp/arff-datasets/blob/master/classification/mushroom.arff)
- Dataset original: [UC Irvine ML Repository](https://archive.ics.uci.edu/dataset/73/mushroom)

Atributos como: forma del sombrero, olor, hábitat, anillos...

> Proveniente de la Guía de campo de la Sociedad Audubon con descripciones de 23 especies de hongos.

---

## 🤖 Implementación de ML en Java con Weka

Este proyecto utiliza la biblioteca **Weka**, muy conocida en entornos educativos y de prototipado, que permite crear, entrenar y guardar modelos de aprendizaje automático en Java. El modelo J48 es **serializado** y cargado desde disco, lo que permite hacer predicciones sin tener que reentrenar, optimizando tiempo y recursos. Los datos están en formato `.arff`, un formato clásico en ML que describe atributos y valores de forma estructurada.

---

## 🧬 J48 (ID3): El Árbol Clásico pero Poderoso

- Basado en **ID3**, usa **entropía** e **información ganada** para elegir qué atributo usar en cada nodo.
- Se **poda** para evitar sobreajuste (overfitting).
- El atributo **odor** sale como raíz porque tiene la **mayor ganancia de información**: su valor predice fuertemente la comestibilidad.
- Muy usado en medicina, agricultura, bioinformática…

---

## 🌲 Random Forest y Random Tree: Más Random, Más Potencia

- **Random Forest**: combina muchos árboles diferentes → más robusto, menos riesgo de sobreajuste.
- **Random Tree**: más aleatorio, puede ser más rápido pero menos estable.
    
---

## 📊 Comparativa de Algoritmos (Weka)

### 💡 J48 (ID3)
- 🌟 Precisión: 100%
- Tiempo: 0.01 s
- Algoritmo basado en **árboles de decisión**, usa **ganancia de información** para decidir qué atributo dividir.
- Gran interpretabilidad: fácil de entender el porqué de cada predicción.

### 🌳 Random Forest
- 🌟 Precisión: 100%
- Tiempo: 0.25 s
- Combina **muchos árboles** con selección aleatoria de atributos → más robusto, menos overfitting.

### 🌳 Random Tree
- 🌟 Precisión: 100%
- Crea un solo árbol con decisiones aleatorias → más rápido pero menos estable.

> Todos los algoritmos mostraron un rendimiento excelente (100% accuracy) con este dataset. **J48** se eligió por su interpretabilidad y rapidez.

---

## 📖 Licencia

Apache License 2.0  
[Ver licencia](http://www.apache.org/licenses/LICENSE-2.0)

---

## 👨‍💻 Autoría

Marta Canino Romero  
[@martacanirome4](https://github.com/martacanirome4)  
GitHub 2023

![GitHub Stats](https://github-readme-stats.vercel.app/api?username=martacanirome4&show_icons=true&theme=merko)

---

# **Licencia**

Copyright 2023 Marta Canino Romero

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.

You may obtain a copy of the License at:  http://www.apache.org/licenses/LICENSE-2.0
 
 Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
