# **Proyecto de Aprendizaje Automático - Predicción de Comestibilidad de Setas** (Mushroom Edibility Predictor)

## __Marta Canino y Yolanda Llop__

Este proyecto utiliza aprendizaje automático (machine learning) para predecir si un hongo es comestible o venenoso basándose en sus atributos. El modelo se entrena con un conjunto de datos de entrenamiento de hongos y luego se utiliza para hacer predicciones sobre un conjunto de datos de prueba.

![mushroom](https://github.com/martacanirome4/mushroom-predictor/assets/50625677/bccd9e83-a9b2-486f-88ad-23554722d7ec)


# **Sobre el proyecto**

Para llevar a cabo el proyecto, primero se eligió el problema a predecir como la comestibilidad de setas utilizando una base de datos con información sobre estas.

La fuente de datos consiste en un conjunto de datos históricos con una variedad de atributos sobre setas. A partir de estos datos se identificaron características como forma del sombrero, color de la tapa, y otros atributos que influyen en la comestibilidad de las setas.

Una vez localizada la fuente de datos, se obtuvo el archivo `mushroom.arff` codificado según las características seleccionadas para su uso en Weka.

Se evaluaron distintos algoritmos de aprendizaje automático utilizando la herramienta **Weka**, y se seleccionó el algoritmo con mejor rendimiento, que en este caso se trataba del algoritmo **J48** (o **ID3**).
Para aportar una visión general de los atributos que mejor discriminaban a este modelo, podemos observar el árbol de decisión generado por el algoritmo ID3, donde podemos comprobar que el atributo __odor__, que hace referencia al olor del hongo, tiene un factor muy determinante sobre al comestibilidad de este.

<img width="793" alt="J48-tree-view" src="https://github.com/martacanirome4/MushroomEdibilityPredictor/assets/50625677/513ec130-8ce3-471e-8fae-2a3581863653">

**__Al final del README se encuentran detallados los resultados obtenidos para cada uno de los algoritmos probados sobre los datos.__**

## Estructura del Proyecto

- `training_data/`: Contiene el conjunto de datos de entrenamiento en formato ARFF.
- `test_data/`: Contiene el conjunto de datos de prueba en formato ARFF.
- `models/`: Almacena el modelo entrenado después de ejecutar el programa.

## **Requisitos**

- Java (JRE)
- Weka (biblioteca para aprendizaje automático en Java)

## **Acerca del programa**
   
   El proyecto implementa un programa de prototipo de aplicación que consultando el objeto persistente de modelo generado por Weka y cargando en memoria el objeto persistente, lo entrena para poder realizar predicciones sobre los datos aportados y obtener el resultado predecido.
   
   1. Entrenar el Modelo: La aplicación entrena el modelo utilizando el algoritmo J48 utilizando la información y registros sobre setas aportados en training_data, en el formato .arff, y guarda el modelo en el directorio models/.
   
   2. Realizar predicciones: Se utiliza el modelo entrenado para hacer predicciones sobre el conjunto de datos de prueba, y a continuación muestra los resultados en la consola.

## **Uso**

Para poder utilizar la aplicación, es necesario en primer lugar navegar hasta el directorio que contiene el proyecto y ejecutar el siguiente comando desde la terminal para  compilar y empaquetar el proyecto en un archivo JAR:
 
   ```bash
   MAKE jar
   ```

Después de ejecutar make jar y crear el archivo JAR (aprendizaje.jar), se ejecuta el siguieinte comando que realiza las predicciones basadas en el modelo entrenado.

   ```bash
   java -jar aprendizaje.jar
   ```

La aplicación mostrará por la terminal los resultados predecidos para la información de prueba aportada en test_data, indicando para cada fila detallando las cualidades de una seta, si la misma es comestible (e: edible) o venenosa (p: poisonous):

<img width="1154" alt="results" src="https://github.com/martacanirome4/MushroomEdibilityPredictor/assets/50625677/5ce146eb-0d2b-4885-8567-5868a503540f">


## **Detalles Técnicos**

El código fuente está en el directorio modelos/. Modelo.java contiene la lógica para leer instancias, entrenar el modelo y aplicar predicciones.

## **Conjunto de datos utilizado**

El conjunto de datos utilizado consiste en atributos como forma del sombrero, color de la tapa, olor, etc. Se ha obtenido del repositorio:

https://github.com/renatopp/arff-datasets/blob/master/classification/mushroom.arff

Como se explica también, más detalladamente, en https://archive.ics.uci.edu/dataset/73/mushroom:

"De la Guía de campo de la Sociedad Audubon; hongos descritos en términos de características físicas; clasificación: venenoso o comestible (...) Este conjunto de datos incluye descripciones de muestras hipotéticas correspondientes a 23 especies de hongos con branquias de las familias Agaricus y Lepiota (págs. 500-525). Cada especie se identifica como definitivamente comestible, definitivamente venenosa o de comestibilidad desconocida y no recomendada (...)"

# Resultados obtenidos para los diferentes algoritmos

Utilizando la aplicación Weka, se probaron diferentes algoritmos sobre los datos utilizados con el fin de poder compararlos y elegir el de mayor rendimiento, para más tarde introducido como modelo en la aplicación.
A  continuación se muestran los resultados obtenidos para los algoritmos con mayor rendimiento:

   ## **J48 (ID3)**
   ```plaintext
      === Run information ===
      
      Scheme:       weka.classifiers.trees.J48 -C 0.25 -M 2
      Relation:     mushroom
      Instances:    8124
      Attributes:   23
                    cap-shape
                    cap-surface
                    cap-color
                    bruises?
                    odor
                    gill-attachment
                    gill-spacing
                    gill-size
                    gill-color
                    stalk-shape
                    stalk-root
                    stalk-surface-above-ring
                    stalk-surface-below-ring
                    stalk-color-above-ring
                    stalk-color-below-ring
                    veil-type
                    veil-color
                    ring-number
                    ring-type
                    spore-print-color
                    population
                    habitat
                    class
      Test mode:    10-fold cross-validation
      
      === Classifier model (full training set) ===
      
      J48 pruned tree
      ------------------
      
      odor = a: e (400.0)
      odor = c: p (192.0)
      odor = f: p (2160.0)
      odor = l: e (400.0)
      odor = m: p (36.0)
      odor = n
      |   spore-print-color = b: e (48.0)
      |   spore-print-color = h: e (48.0)
      |   spore-print-color = k: e (1296.0)
      |   spore-print-color = n: e (1344.0)
      |   spore-print-color = o: e (48.0)
      |   spore-print-color = r: p (72.0)
      |   spore-print-color = u: e (0.0)
      |   spore-print-color = w
      |   |   gill-size = b: e (528.0)
      |   |   gill-size = n
      |   |   |   gill-spacing = c: p (32.0)
      |   |   |   gill-spacing = d: e (0.0)
      |   |   |   gill-spacing = w
      |   |   |   |   population = a: e (0.0)
      |   |   |   |   population = c: p (16.0)
      |   |   |   |   population = n: e (0.0)
      |   |   |   |   population = s: e (0.0)
      |   |   |   |   population = v: e (48.0)
      |   |   |   |   population = y: e (0.0)
      |   spore-print-color = y: e (48.0)
      odor = p: p (256.0)
      odor = s: p (576.0)
      odor = y: p (576.0)
      
      Number of Leaves  : 	25
      
      Size of the tree : 	30
      
      
      Time taken to build model: 0.01 seconds
      
      === Stratified cross-validation ===
      === Summary ===
      
      Correctly Classified Instances        8124              100      %
      Incorrectly Classified Instances         0                0      %
      Kappa statistic                          1     
      Mean absolute error                      0     
      Root mean squared error                  0     
      Relative absolute error                  0      %
      Root relative squared error              0      %
      Total Number of Instances             8124     
      
      === Detailed Accuracy By Class ===
      
                       TP Rate  FP Rate  Precision  Recall   F-Measure  MCC      ROC Area  PRC Area  Class
                       1,000    0,000    1,000      1,000    1,000      1,000    1,000     1,000     e
                       1,000    0,000    1,000      1,000    1,000      1,000    1,000     1,000     p
      Weighted Avg.    1,000    0,000    1,000      1,000    1,000      1,000    1,000     1,000     
      
      === Confusion Matrix ===
      
          a    b   <-- classified as
       4208    0 |    a = e
          0 3916 |    b = p
   ```

 ## **Random Forest**
   ```plaintext
   === Run information ===
   
   Scheme:       weka.classifiers.trees.RandomForest -P 100 -I 100 -num-slots 1 -K 0 -M 1.0 -V 0.001 -S 1
   Relation:     mushroom
   Instances:    8124
   Attributes:   23
                 cap-shape
                 cap-surface
                 cap-color
                 bruises?
                 odor
                 gill-attachment
                 gill-spacing
                 gill-size
                 gill-color
                 stalk-shape
                 stalk-root
                 stalk-surface-above-ring
                 stalk-surface-below-ring
                 stalk-color-above-ring
                 stalk-color-below-ring
                 veil-type
                 veil-color
                 ring-number
                 ring-type
                 spore-print-color
                 population
                 habitat
                 class
   Test mode:    10-fold cross-validation
   
   === Classifier model (full training set) ===
   
   RandomForest
   
   Bagging with 100 iterations and base learner
   
   weka.classifiers.trees.RandomTree -K 0 -M 1.0 -V 0.001 -S 1 -do-not-check-capabilities
   
   Time taken to build model: 0.25 seconds
   
   === Stratified cross-validation ===
   === Summary ===
   
   Correctly Classified Instances        8124              100      %
   Incorrectly Classified Instances         0                0      %
   Kappa statistic                          1     
   Mean absolute error                      0.0004
   Root mean squared error                  0.0031
   Relative absolute error                  0.0756 %
   Root relative squared error              0.6126 %
   Total Number of Instances             8124     
   
   === Detailed Accuracy By Class ===
   
                    TP Rate  FP Rate  Precision  Recall   F-Measure  MCC      ROC Area  PRC Area  Class
                    1,000    0,000    1,000      1,000    1,000      1,000    1,000     1,000     e
                    1,000    0,000    1,000      1,000    1,000      1,000    1,000     1,000     p
   Weighted Avg.    1,000    0,000    1,000      1,000    1,000      1,000    1,000     1,000     
   
   === Confusion Matrix ===
   
       a    b   <-- classified as
    4208    0 |    a = e
       0 3916 |    b = p
   ```

   ## **Random Tree**
   ```plaintext
   === Run information ===
   
   Scheme:       weka.classifiers.trees.RandomTree -K 0 -M 1.0 -V 0.001 -S 1
   Relation:     mushroom
   Instances:    8124
   Attributes:   23
                 cap-shape
                 cap-surface
                 cap-color
                 bruises?
                 odor
                 gill-attachment
                 gill-spacing
                 gill-size
                 gill-color
                 stalk-shape
                 stalk-root
                 stalk-surface-above-ring
                 stalk-surface-below-ring
                 stalk-color-above-ring
                 stalk-color-below-ring
                 veil-type
                 veil-color
                 ring-number
                 ring-type
                 spore-print-color
                 population
                 habitat
                 class
   Test mode:    10-fold cross-validation
   
   === Classifier model (full training set) ===
   
   
   RandomTree
   ==========
   
   stalk-color-below-ring = b : p (432/0)
   stalk-color-below-ring = c : p (36/0)
   stalk-color-below-ring = e : e (96/0)
   stalk-color-below-ring = g : e (576/0)
   stalk-color-below-ring = n
   |   stalk-surface-above-ring = f : e (24/0)
   |   stalk-surface-above-ring = k : p (448/0)
   |   stalk-surface-above-ring = s : e (24/0)
   |   stalk-surface-above-ring = y : e (16/0)
   stalk-color-below-ring = o : e (192/0)
   stalk-color-below-ring = p
   |   ring-type = c : e (0/0)
   |   ring-type = e : p (864/0)
   |   ring-type = f : e (0/0)
   |   ring-type = l : p (432/0)
   |   ring-type = n : e (0/0)
   |   ring-type = p : e (576/0)
   |   ring-type = s : e (0/0)
   |   ring-type = z : e (0/0)
   stalk-color-below-ring = w
   |   population = a : e (384/0)
   |   population = c
   |   |   cap-color = b : e (24/0)
   |   |   cap-color = c : e (0/0)
   |   |   cap-color = e : e (24/0)
   |   |   cap-color = g : e (0/0)
   |   |   cap-color = n : e (24/0)
   |   |   cap-color = p : e (24/0)
   |   |   cap-color = r : e (0/0)
   |   |   cap-color = u : e (0/0)
   |   |   cap-color = w : p (8/0)
   |   |   cap-color = y : e (0/0)
   |   population = n : e (400/0)
   |   population = s
   |   |   gill-size = b
   |   |   |   habitat = d : e (0/0)
   |   |   |   habitat = g
   |   |   |   |   stalk-root = b
   |   |   |   |   |   bruises? = f : e (16.41/0)
   |   |   |   |   |   bruises? = t : p (72/0)
   |   |   |   |   stalk-root = c : e (157.16/0)
   |   |   |   |   stalk-root = e : e (471.49/0)
   |   |   |   |   stalk-root = r : e (58.94/0)
   |   |   |   |   stalk-root = u : e (0/0)
   |   |   |   |   stalk-root = z : e (0/0)
   |   |   |   habitat = l : e (0/0)
   |   |   |   habitat = m : e (128/0)
   |   |   |   habitat = p : e (48/0)
   |   |   |   habitat = u : p (72/0)
   |   |   |   habitat = w : e (0/0)
   |   |   gill-size = n : p (224/0)
   |   population = v
   |   |   gill-color = b : p (864/0)
   |   |   gill-color = e : e (0/0)
   |   |   gill-color = g
   |   |   |   cap-surface = f
   |   |   |   |   odor = a : e (0/0)
   |   |   |   |   odor = c : p (12/0)
   |   |   |   |   odor = f : e (0/0)
   |   |   |   |   odor = l : e (0/0)
   |   |   |   |   odor = m : e (0/0)
   |   |   |   |   odor = n : e (12/0)
   |   |   |   |   odor = p : e (0/0)
   |   |   |   |   odor = s : e (0/0)
   |   |   |   |   odor = y : e (0/0)
   |   |   |   cap-surface = g : e (0/0)
   |   |   |   cap-surface = s : p (24/0)
   |   |   |   cap-surface = y : p (12/0)
   |   |   gill-color = h
   |   |   |   bruises? = f : e (6/0)
   |   |   |   bruises? = t : p (48/0)
   |   |   gill-color = k
   |   |   |   bruises? = f : e (12/0)
   |   |   |   bruises? = t : p (32/0)
   |   |   gill-color = n
   |   |   |   gill-size = b : e (72/0)
   |   |   |   gill-size = n
   |   |   |   |   odor = a : e (16/0)
   |   |   |   |   odor = c : p (24/0)
   |   |   |   |   odor = f : e (0/0)
   |   |   |   |   odor = l : e (16/0)
   |   |   |   |   odor = m : e (0/0)
   |   |   |   |   odor = n : e (12/0)
   |   |   |   |   odor = p : p (32/0)
   |   |   |   |   odor = s : e (0/0)
   |   |   |   |   odor = y : e (0/0)
   |   |   gill-color = o : e (0/0)
   |   |   gill-color = p
   |   |   |   cap-surface = f
   |   |   |   |   bruises? = f
   |   |   |   |   |   habitat = d : p (12/0)
   |   |   |   |   |   habitat = g : e (0/0)
   |   |   |   |   |   habitat = l : e (0/0)
   |   |   |   |   |   habitat = m : e (0/0)
   |   |   |   |   |   habitat = p : e (0/0)
   |   |   |   |   |   habitat = u : e (12/0)
   |   |   |   |   |   habitat = w : e (0/0)
   |   |   |   |   bruises? = t : e (52/0)
   |   |   |   cap-surface = g : e (0/0)
   |   |   |   cap-surface = s
   |   |   |   |   cap-color = b : p (16/0)
   |   |   |   |   cap-color = c : e (0/0)
   |   |   |   |   cap-color = e : e (0/0)
   |   |   |   |   cap-color = g : p (20/0)
   |   |   |   |   cap-color = n : p (8/0)
   |   |   |   |   cap-color = p : p (4/0)
   |   |   |   |   cap-color = r : e (0/0)
   |   |   |   |   cap-color = u : e (0/0)
   |   |   |   |   cap-color = w
   |   |   |   |   |   gill-size = b : p (16/0)
   |   |   |   |   |   gill-size = n
   |   |   |   |   |   |   spore-print-color = b : e (0/0)
   |   |   |   |   |   |   spore-print-color = h : e (0/0)
   |   |   |   |   |   |   spore-print-color = k : p (6/0)
   |   |   |   |   |   |   spore-print-color = n
   |   |   |   |   |   |   |   odor = a : e (2/0)
   |   |   |   |   |   |   |   odor = c : p (2/0)
   |   |   |   |   |   |   |   odor = f : e (0/0)
   |   |   |   |   |   |   |   odor = l : e (2/0)
   |   |   |   |   |   |   |   odor = m : e (0/0)
   |   |   |   |   |   |   |   odor = n : e (0/0)
   |   |   |   |   |   |   |   odor = p : p (4/0)
   |   |   |   |   |   |   |   odor = s : e (0/0)
   |   |   |   |   |   |   |   odor = y : e (0/0)
   |   |   |   |   |   |   spore-print-color = o : e (0/0)
   |   |   |   |   |   |   spore-print-color = r : e (0/0)
   |   |   |   |   |   |   spore-print-color = u : e (4/0)
   |   |   |   |   |   |   spore-print-color = w : e (0/0)
   |   |   |   |   |   |   spore-print-color = y : e (0/0)
   |   |   |   |   cap-color = y : e (8/0)
   |   |   |   cap-surface = y
   |   |   |   |   habitat = d : e (42/0)
   |   |   |   |   habitat = g : p (8/0)
   |   |   |   |   habitat = l : e (0/0)
   |   |   |   |   habitat = m : e (0/0)
   |   |   |   |   habitat = p : e (0/0)
   |   |   |   |   habitat = u : p (8/0)
   |   |   |   |   habitat = w : e (0/0)
   |   |   gill-color = r : p (24/0)
   |   |   gill-color = u
   |   |   |   stalk-shape = e
   |   |   |   |   cap-shape = b : e (0/0)
   |   |   |   |   cap-shape = c : e (0/0)
   |   |   |   |   cap-shape = f : e (3/0)
   |   |   |   |   cap-shape = k : e (0/0)
   |   |   |   |   cap-shape = s : e (0/0)
   |   |   |   |   cap-shape = x
   |   |   |   |   |   odor = a : e (0/0)
   |   |   |   |   |   odor = c : p (24/0)
   |   |   |   |   |   odor = f : e (0/0)
   |   |   |   |   |   odor = l : e (0/0)
   |   |   |   |   |   odor = m : e (0/0)
   |   |   |   |   |   odor = n : e (3/0)
   |   |   |   |   |   odor = p : e (0/0)
   |   |   |   |   |   odor = s : e (0/0)
   |   |   |   |   |   odor = y : e (0/0)
   |   |   |   stalk-shape = t : e (72/0)
   |   |   gill-color = w
   |   |   |   habitat = d : e (110/0)
   |   |   |   habitat = g : p (52/0)
   |   |   |   habitat = l : e (0/0)
   |   |   |   habitat = m : p (12/0)
   |   |   |   habitat = p : e (16/0)
   |   |   |   habitat = u : p (40/0)
   |   |   |   habitat = w : e (0/0)
   |   |   gill-color = y : e (0/0)
   |   population = y : e (472/0)
   stalk-color-below-ring = y : p (24/0)
   
   Size of the tree : 169
   
   Time taken to build model: 0 seconds
   
   === Stratified cross-validation ===
   === Summary ===
   
   Correctly Classified Instances        8124              100      %
   Incorrectly Classified Instances         0                0      %
   Kappa statistic                          1     
   Mean absolute error                      0     
   Root mean squared error                  0     
   Relative absolute error                  0      %
   Root relative squared error              0      %
   Total Number of Instances             8124     
   
   === Detailed Accuracy By Class ===
   
                    TP Rate  FP Rate  Precision  Recall   F-Measure  MCC      ROC Area  PRC Area  Class
                    1,000    0,000    1,000      1,000    1,000      1,000    1,000     1,000     e
                    1,000    0,000    1,000      1,000    1,000      1,000    1,000     1,000     p
   Weighted Avg.    1,000    0,000    1,000      1,000    1,000      1,000    1,000     1,000     
   
   === Confusion Matrix ===
   
       a    b   <-- classified as
    4208    0 |    a = e
       0 3916 |    b = p
   ```

# **Licencia**

Copyright 2023 Marta Canino Romero

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.

You may obtain a copy of the License at:  http://www.apache.org/licenses/LICENSE-2.0
 
 Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
