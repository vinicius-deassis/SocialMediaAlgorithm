/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dados;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javax.swing.ImageIcon;

/**
 *
 * @author USER
 */
public class SistemaImagens {
    private Random random;
    private ArrayList<Image> lista;
    private Set<Integer> numeros;
    
    public SistemaImagens(){
        this.numeros = new HashSet<Integer>();
        this.lista = new ArrayList();     
        }
    
        public Image setImageSize(String imageLink){
            ImageIcon imgg = new ImageIcon(getClass().getResource(imageLink));
            Image img = imgg.getImage().getScaledInstance(100, 149, Image.SCALE_DEFAULT);
            return img;
        }
        
        public ArrayList<Integer> RandomList(int Size, int Bound){
            while (this.numeros.size() < Size) {
            numeros.add(random.nextInt(Bound));
            }
        
            ArrayList<Integer> listaNumeros = new ArrayList(numeros);
            return listaNumeros;
        }
        
}   

