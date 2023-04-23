import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.UUID;
import java.nio.file.*;
import java.nio.file.Files;
import java.nio.file.Path;

class dec {
   public static void main(String args[]) throws Exception {
      System.out.println("\t\t*~*~*~*~*~*~*~*~*~*~ Decryption *~*~*~*~*~*~*~*~*~*~\n\n\n");
      int f1 = 10;
      int c = 0;
      for (int f = 0; f <= f1; f++) {
         System.out.println("\t\t   --------");
         System.out.println("\t\t |          |");
         System.out.println("\t\t | BLOCK_NO |:" + (f1 - f));
         System.out.println("\t\t |          |");
         System.out.println("\t\t   --------");
         int nk = 10;
         int k[];
         k = new int[nk];
         FileInputStream fs = new FileInputStream("ke.txt");
         DataInputStream ds = new DataInputStream(fs);
         for (int i = 0; i < nk; i++) {
            k[i] = ds.readInt();
            // System.out.println("k["+i+"] :" + k[i] );
         }
         ds.close();

         File fi = new File("D:\\project\\en.txt");
         BufferedReader br = new BufferedReader(new FileReader(fi));
         String doi = "";
         String d = "";
         while ((d = br.readLine()) != null) {
            doi = doi + d;
         }

         System.out.println("Encrypted string:" + doi);

         new FileOutputStream("D:\\project\\en.txt").close();

         int dascii[] = new int[doi.length()];
         System.out.print("dascii array: ");
         for (int i = 0; i < doi.length(); i++) {
            dascii[i] = (int) doi.charAt(i);
            System.out.print(dascii[i] + " ");
         }
         System.out.println();
         int dl[];
         int dr[];
         int ei = doi.length();

         int dn = (int) ei / 2;
         dl = new int[dn];
         dr = new int[dn];
         // System.out.print("dleft: ");
         for (int i = 0; i < dn; i++) {
            dl[i] = dascii[i];
            // System.out.print(dl[i]+" ");
         }
         // System.out.println();
         // System.out.print("dright: ");
         for (int i = dn, j = 0; i < ei && j < dn; i++, j++) {

            dr[j] = dascii[i];
            // System.out.print(dr[j]+" ");
         }
         // System.out.println();

         int dfunct[] = new int[dl.length];
         int dtemp[] = new int[dl.length];

         for (int j = nk - 1; j >= 0; --j) // exception
         {
            for (int i = 0, z = 0; i < dr.length && z < dl.length; i++, z++) {
               // System.out.println("before : l[]="+dl[z]+"r[]="+dr[i]+"k[]="+k[j]);
               // System.out.println((char)dl[z]+""+(char)dr[i]);

               dtemp[z] = dl[z];
               dfunct[z] = (int) (dl[z] ^ k[j]);
               dl[z] = (int) (dr[i] ^ dfunct[i]);
               dr[i] = dtemp[z];

               // System.out.println("after : l[]="+dl[z]+"r[]="+dr[i]);
               // System.out.println((char)dl[z]+""+(char)dr[i]);

            }
            for (int i = 0, z = 0; i < dr.length && z < dl.length; i++, z++) {
               System.out.print((char) dl[z] + "" + (char) dr[i]);
            }
            System.out.println();
         }

         System.out.println();
         char dlo[] = new char[dl.length];
         char dro[] = new char[dr.length];
         char dou[] = new char[dl.length + dr.length];
         for (int j = 0, z = 0; j < dl.length && z < dr.length; j++, z++) {
            dlo[j] = (char) dl[j];
            dro[z] = (char) dr[z];
         }
         for (int i = 0; i < dl.length; i++) {
            dou[i] = (char) dl[i];
         }
         for (int i = 0; i < dr.length; i++) {
            dou[dl.length + i] = (char) dr[i];
         }
         System.out.print("Decrypted: ");
         doi = "";
         for (int i = 0; i < dl.length + dr.length; i++) {
            // if (i == (dl.length + dr.length) - 1 || i != 0 || c != 3)
            // System.out.print(dou[i]);
            // else
            // c = 0;
            doi += dou[i];
         }
         System.out.println(doi);
         FileWriter fWriter = new FileWriter("D:\\project\\en.txt");
         fWriter.write("\n");
         fWriter.write(doi);
         fWriter.close();
         System.out.println();
         // }
      }

   }
}