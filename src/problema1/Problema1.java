/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema1;

/**
 * Clase que muestra en pantalla datos de las votaciones, porcentajes para cada candidato 
 * y determinar si hay ganador.
 * @author JOSE RINCON
 * @author José Luis Rincón y Diana Marcela Molina
 * @version 1.0
 * since 02/26/2016
 */
public class Problema1 {

    /**
     * @param args the command line arguments
     */    
    //c guarda la cantidad de candidatos ingresados por el registrador.
    static int c;
    //m guarda la cantidad de municipios ingresados por el registrador.
    static int m;
    //tablaVotaciones guarda los datos de las votaciones en una matriz.
    static int tablaVotaciones[][];
    //guarda el total de votos obtenidos para cada canditado.
    static int votoTotalPorCandidato[];
    static int totalDeVotos=0;
    
    public static void main(String[] args) {
        // TODO code application logic here
        ingresarNumCandidatos();
        ingresarNumMunicipios();
        tablaVotaciones=new int[c][m];
        votoTotalPorCandidato=new int[c];
        ingresarDatosVotaciones();
        mostrarTablaVotaciones();
        calcularVotosPorCandidato();
        mostrarVotosPorCandidato();
        candidatoMasVotado();
    }
    static void ingresarNumCandidatos(){
        java.util.Scanner lectura = new java.util.Scanner(System.in);
        boolean salida = false;
        while(!salida){
            System.out.println("Ingrese la cantidad de candidatos: ");
            c = lectura.nextInt();
            if(c < 21 && c > 0){
                salida=true;
            }
            else{
                System.out.println("Las opciones válidas son entre 1 y 20\n");
            }
        }
    }
    static void ingresarNumMunicipios(){
        java.util.Scanner lectura = new java.util.Scanner(System.in);
        boolean salida = false;
        while(!salida){
            System.out.println("Ingrese la cantidad de municipios: ");
            m = lectura.nextInt();
            if(m < 21 && m > 0){
                salida=true;
            }
            else{
                System.out.println("Las opciones válidas son entre 1 y 20\n");
            }
        }
    }
    static void ingresarDatosVotaciones(){
        java.util.Scanner lectura = new java.util.Scanner(System.in);
        for(int i=0; i<c; i++){
            System.out.println("Ingrese la información del candidato "+(i+1));
            for(int j=0; j<m; j++){
                System.out.print("Votos en el municipio "+(j+1)+" :");
                tablaVotaciones[i][j]=lectura.nextInt();
            }
        }
    }
    static void mostrarTablaVotaciones(){
        System.out.print("\t\t");
        for (int h=0; h<c; h++){
            System.out.print("\tCandidato "+(h+1));
        }
        System.out.print("\n");//salto de linea.
        for(int i=0; i<m; i++){
            System.out.print("Municipio "+(i+1));
            for(int j=0; j<c; j++){
                System.out.print("\t\t"+tablaVotaciones[j][i]);
            }
            System.out.print("\n");//salto de linea.
        }
    }
    static void calcularVotosPorCandidato(){
        for(int i=0; i<c; i++){
            votoTotalPorCandidato[i]=0;
            for(int j=0; j<m; j++){
                votoTotalPorCandidato[i]=tablaVotaciones[i][j]+votoTotalPorCandidato[i];
            }
            totalDeVotos=votoTotalPorCandidato[i]+totalDeVotos;
        }
    }
    static void mostrarVotosPorCandidato(){
        double porcentaje[]=new double[c];
        int marcador=-1;//variable para marcar si un candidato supera el 50% de las votaciones o si es necesario una segunda vuelta
        for(int i=0; i<c; i++){
            porcentaje[i]=(votoTotalPorCandidato[i]*100)/totalDeVotos;
            System.out.println("el candidato "+(i+1)+" obtuvo "+votoTotalPorCandidato[i]+" votos con un "+porcentaje[i]+"% de las votaciones");
            if(porcentaje[i]>50){
                marcador=i;
            }
        }
        if(marcador!=-1){
            System.out.println("\nEl ganador es el candidato "+(marcador+1)+" con un "+porcentaje[marcador]+"% de las votaciones\n");
        }
        else{
            System.out.println("\nEs necesario una segunda vuelta de votaciones\n");
        }
    }
    static void candidatoMasVotado(){
        int masVotado=0;
        for(int i=1; i<c; i++){
            if(votoTotalPorCandidato[i]>votoTotalPorCandidato[masVotado]){
                masVotado=i;
            }
        }
        System.out.println("El más votado fue el candidato "+(masVotado+1));
    }
}
