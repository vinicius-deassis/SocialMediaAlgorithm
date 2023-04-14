/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//Na hora de trasnferir os arquivos para um drive para baixar em sala, perdemos alterações importantes uma classe importante de dados SistemaImagens.java, então tentamos refazer nas pressas e é este aqruivo que o senhor vê
package desespero;
import LoginSystem.*;
import java.util.ArrayList;
import java.awt.Image;
import dados.*;
/**
 *
 * @author vinicius.assis
 */
public class myWay{
    ArrayList<String> esporte;
    ArrayList<String> desenho;
    ArrayList<String> animal;
    SistemaImagens image = new SistemaImagens();
    public myWay(){
        esporte = new ArrayList();
        desenho = new ArrayList();
        animal = new ArrayList();        
    }
    public ArrayList<String> Esportes(){
        
        this.esporte.add("/Images/esportes/basquete.jpg");
        this.esporte.add("/Images/esportes/futebol.jpg");
        this.esporte.add("/Images/esportes/handball.jpg");
        this.esporte.add("/Images/esportes/volei.jpg");
        this.esporte.add("/Images/esportes/tenis.jpg");
        
        return esporte;
    }
    
    public ArrayList<String> Desenho(){
        
        this.desenho.add("/Images/esportes/AT.jpg");
        this.desenho.add("/Images/esportes/avatar.jpg");
        this.desenho.add("/Images/esportes/jakelong.jpg");
        this.desenho.add("/Images/esportes/jackiechan.jpg");
        this.desenho.add("/Images/esportes/bobesponja.jpg");
        
        return desenho;
    }
    
    public ArrayList<String> Animal(){
        
        this.animal.add("/Images/esportes/gaviao.jpg");
        this.animal.add("/Images/esportes/gato.jpg");
        this.animal.add("/Images/esportes/cachorro.jpg");
        this.animal.add("/Images/esportes/leao.jpg");
        this.animal.add("/Images/esportes/porco.jpg");
        
        return animal;
    }
}
