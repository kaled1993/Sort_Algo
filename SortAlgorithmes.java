package Pack_Sort_Algo;
import java.util.Random;
import java.io.*;
import java.util.concurrent.*; 
/**
 *
 * @author kkrifa
 */
public class  SortAlgorithmes{
    private static int[] anArray;
    public static final int taille = 1000;  
     public static int randomFill(){
    Random rand = new Random();
    int randomNum = rand.nextInt();
    return randomNum;
    } 
      public static int[] list(){
        anArray = new int[taille];   
        return anArray;
    }

   
     
void echanger(int tab[], int x, int y)
{
    int tmp;
    tmp = tab[x];
    tab[x] = tab[y];
    tab[y] = tmp;
}
void Echange( int a,  int b)
        {
            int aux = a;
            a = b;
            b = aux;
        }

int max(int tab[])
{
    // on considère que le plus grand élément est le premier
    int i=0, indice_max=0;
    
    while(i < taille)
    {
        if(tab[i] > tab[indice_max])
            indice_max = i;
        i++;
    }
    
    return indice_max;
}

private void tri_selection(int tab[])
{
    int indice_max;
    int k ;
    k=taille ;
    for(; k > 1 ; k--) 
    {
        indice_max = max(tab);
        echanger(tab, k-1, indice_max); 
    }
}

 private  void triInsertion(int tableau[])
        {
        int longueur=tableau.length;
        
        for(int i=1;i<longueur;i++)
            {
            int memory=tableau[i];
            int compt=i-1;
            boolean marqueur;
            do
                {
                marqueur=false;
                if (tableau[compt]>memory)
                    {
                    tableau[compt+1]=tableau[compt];
                    compt--;
                    marqueur=true;
                    }
                if (compt<0) marqueur=false;
                }
            while(marqueur);
            tableau[compt+1]=memory;
            }
        }
 
  private void triBulle(int tableau[])
        {
        int longueur=tableau.length;
        boolean inversion;
        
        do
            {
            inversion=false;

            for(int i=0;i<longueur-1;i++)
                {
                if(tableau[i]>tableau[i+1])
                    {
                    echanger(tableau,i,i+1);
                    inversion=true;
                    }
                }
             longueur--;
             }
        while(inversion);
        }
  
  //**********************tri rapide 
   private  int partition(int tableau[],int deb,int fin)
        {
        int compt=deb;
        int pivot=tableau[deb];
        
        for(int i=deb+1;i<=fin;i++)
            {
            if (tableau[i]<pivot)
                {
                compt++;
                echanger(tableau,compt,i);
                }
            }
        echanger(tableau,deb,compt);
        return(compt);
        }

    private void triRapide(int tableau[],int deb,int fin)
        {
        if(deb<fin)
            {
            int positionPivot=partition(tableau,deb,fin);
            triRapide(tableau,deb,positionPivot-1);
            triRapide(tableau,positionPivot+1,fin);
            }
        }

  
  
  //********************************
    
     private  void triShell(int tableau[])
        {
        int longueur=tableau.length;
        int n=0;
        
        while(n<longueur)
            {
            n=3*n+1;
            }
        while(n!=0)
            {
            n=n/3;
            for (int i=n;i<longueur;i++)
                {
                int valeur=tableau[i];
                int j=i;

                while((j>(n-1)) && (tableau[j-n]>valeur))
                    {
                    tableau[j]=tableau[j-n];
                    j=j-n;
                    }
                tableau[j]=valeur;
                }
            }
        }
    //****************tri fusion 
     private static void triFusion(int tableau[])
        {
        int longueur=tableau.length;
        if (longueur>0)
            {
            triFusion(tableau,0,longueur-1);
            }
        }

    private static void triFusion(int tableau[],int deb,int fin)
        {
        if (deb!=fin)
            {
            int milieu=(fin+deb)/2;
            triFusion(tableau,deb,milieu);
            triFusion(tableau,milieu+1,fin);
            fusion(tableau,deb,milieu,fin);
            }
        }

    private static void fusion(int tableau[],int deb1,int fin1,int fin2)
        {
        int deb2=fin1+1;

        //on recopie les éléments du début du tableau
        int table1[]=new int[fin1-deb1+1];
        for(int i=deb1;i<=fin1;i++)
            {
            table1[i-deb1]=tableau[i];
            }
        
        int compt1=deb1;
        int compt2=deb2;
        
        for(int i=deb1;i<=fin2;i++)
            {        
            if (compt1==deb2) //c'est que tous les éléments du premier tableau ont été utilisés
                {
                break; //tous les éléments ont donc été classés
                }
            else if (compt2==(fin2+1)) //c'est que tous les éléments du second tableau ont été utilisés
                {
                tableau[i]=table1[compt1-deb1]; //on ajoute les éléments restants du premier tableau
                compt1++;
                }
            else if (table1[compt1-deb1]<tableau[compt2])
                {
                tableau[i]=table1[compt1-deb1]; //on ajoute un élément du premier tableau
                compt1++;
                }
            else
                {
                tableau[i]=tableau[compt2]; //on ajoute un élément du second tableau
                compt2++;
                }
            }
        }

     
     //*************************
    
    
    //*********************tri par tas 
     private  void Tamiser(int[] arbre, int noeud, int n)
        {
            int k = noeud;
            int j = 2 * k;
            while (j <= n)
            {
                if ((j < n) && (arbre[j] < arbre[j + 1]))
                    j++;
                if (arbre[k] < arbre[j])
                {
                    Echange(arbre[k],arbre[j]);
                    k = j;
                    j = 2 * k;
                }
                else
                    break;
            }
        }
     public  void TriParTas(int[] arbre)
        {
            for (int i = arbre.length; i >= 0; i--)
                Tamiser(arbre, i, arbre.length - 1);

            for (int i = arbre.length - 1; i >= 1; i--)
            {
                Echange(arbre[i] , arbre[0]);
                Tamiser(arbre, 0, i - 1);
            }
        }
    
    //*********************************
   public void triSelection_temp_execution(int[] a)
   {
       long startTime = System.nanoTime();
       tri_selection(anArray);
       long endTime = System.nanoTime() ; 
       double duration = (endTime - startTime); 
       System.out.println("tri selection taille "+taille+" temp d'execution = "+ duration/1000000000.0);
   }
   public void triInsertion_temp_execution(int[] a)
   {    
       long startTime = System.nanoTime();
       triInsertion(anArray);
       long endTime = System.nanoTime() ; 
       double duration = (endTime - startTime); 
       System.out.println("tri insertion taille "+taille+" temp d'execution = "+ duration/1000000000.0);
   }
    public void triRapide_temp_execution(int[] a)
   {    
       long startTime = System.nanoTime();
       triRapide(anArray,0,taille-1);
       long endTime = System.nanoTime() ; 
       double duration = (endTime - startTime); 
       System.out.println("tri rapide taille "+taille+" temp d'execution = "+ duration/1000000000.0);
   } 
    public  void triShell_temp_execution(int[] a)
   {    
       long startTime = System.nanoTime();
       triShell(anArray);
       long endTime = System.nanoTime() ; 
       double duration = (endTime - startTime); 
       System.out.println("tri Shell taille "+taille+" temp d'execution = "+ duration/1000000000.0);
   }
     public void triFusion_temp_execution(int[] a)
   {    
       long startTime = System.nanoTime();
       triFusion(anArray);
       long endTime = System.nanoTime() ; 
       double duration = (endTime - startTime); 
       System.out.println("tri fusion taille "+taille+" temp d'execution = "+ duration/1000000000.0);
   }
      public void TriParTas_temp_execution(int[] a)
   {    
       long startTime = System.nanoTime();
       TriParTas(anArray);
       long endTime = System.nanoTime() ; 
       double duration = (endTime - startTime); 
       System.out.println("tri par tas taille "+taille+" temp d'execution = "+ duration/1000000000.0);
   }
     //************************************
      
    public static void main(String[] args) {
        list();
        for(int i = 0; i < anArray.length; i++){
            anArray[i] = randomFill();
        }
       // new SortAlgorithmes().triSelection_temp_execution(anArray);
        //new SortAlgorithmes().triInsertion_temp_execution(anArray);
        //new SortAlgorithmes().triRapide_temp_execution(anArray);
        //new SortAlgorithmes().triShell_temp_execution(anArray);
        //new SortAlgorithmes().triFusion_temp_execution(anArray);
        new TP1_AG51().TriParTas_temp_execution(anArray);
    }
}
