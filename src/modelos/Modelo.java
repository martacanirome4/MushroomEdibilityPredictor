/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.classifiers.Classifier;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

/**
 *
 * @author mariano
 */
public class Modelo {

    private Instances leerInstancias(String ficherArff){
        try{
            Instances inst = new Instances(new BufferedReader(new FileReader(ficherArff)));
            inst.setClassIndex(inst.numAttributes() - 1);

            return inst;
        }catch (IOException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void aprenderModelo()
    {
        try {
            // create J48
            Classifier cls = new J48();

            // train
            Instances inst = leerInstancias("./training_data/mushroom.arff");
            cls.buildClassifier(inst);

            // serialize model
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./models/J58.model"));
            oos.writeObject(cls);
            oos.flush();
            oos.close();
        } catch (Exception ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String aplicarModelo() {
        try{
            // e = edible, p = poisonous -- PREDECIMOS DADOS LOS ATRIBUTOS DE PRUEBA SI SERA COMESTIBLE O NO
            String[] valoresAtributos = {"e", "p"};

            Classifier clasificador  = (Classifier) weka.core.SerializationHelper.read("./models/J58.model");

            Instances data = leerInstancias("./test_data/test.arff");

            // Build string form results to store predictions for all instances
            StringBuilder res = new StringBuilder();

            for (int i = 0; i < data.numInstances(); i++) {
                res.append(valoresAtributos[(int) clasificador.classifyInstance(data.instance(i))]);
    
                // Add a comma and space unless it's the last prediction
                if (i < data.numInstances() - 1) {
                    res.append(", ");
                }
            }
    
            return res.toString();
    

        }catch (Exception ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
            return "Error al intentar leer el modelo";
        }
    }
}
