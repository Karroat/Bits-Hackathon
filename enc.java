import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.UUID;
import java.io.FileReader;
import java.io.FileReader.*;
import javax.sound.sampled.*;

class enc {
  public static void main(String args[]) throws Exception {

    // System.out.println("\t\t*~*~*~*~*~*~*~*~*~*~ Encryption
    // *~*~*~*~*~*~*~*~*~*~\n\n\n");
    String s = "";
    String s1 = "";
    int f1 = 10;
    int c = 0;
    // String o1="";

    try {
      FileReader fis = new FileReader("D:\\project\\inp.txt");

      BufferedReader bis = new BufferedReader(fis);

      while ((s1 = bis.readLine()) != null) {
        s = s + s1;
      }

      bis.close();
    } catch (Exception e) {
      System.out.println(e);
    }

    for (int f = 0; f <= f1; f++) {
      System.out.println("\t\t   --------");
      System.out.println("\t\t |          |");
      System.out.println("\t\t | BLOCK_NO |:" + f);
      System.out.println("\t\t |          |");
      System.out.println("\t\t   --------");
      s = s.toUpperCase();
      // System.out.println(s);
      int x = s.length();

      // int g=2;
      char space = ' ';
      // keys h=new keys();

      if (s.length() % 2 != 0) {
        s += space;
        x = s.length();
        // System.out.println("String length:" + x);
        // System.out.println(s);
      }
      int ascii[] = new int[s.length()];

      System.out.print("ascii array: ");

      for (int i = 0; i < s.length(); i++) {

        ascii[i] = (int) s.charAt(i);
        System.out.print(ascii[i] + " ");

      }
      System.out.println();
      int k[];
      int l[];
      int r[];

      int n = (int) x / 2;
      l = new int[n];
      r = new int[n];
      // System.out.print("Left: ")
      for (int i = 0; i < n; i++) {
        l[i] = ascii[i];
        // System.out.print(l[i]+" ");
      }
      // System.out.println();
      // System.out.print("Right: ")
      for (int i = n, j = 0; i < x && j < n; i++, j++) {

        r[j] = ascii[i];
        // System.out.print(r[j]+" ");
      }
      // System.out.println();

      // System.out.println("Enter no. of keys: ");
      int nk = 10;
      // sc.nextInt();
      k = new int[nk];
      FileInputStream fs = new FileInputStream("ke.txt");
      DataInputStream ds = new DataInputStream(fs);
      for (int i = 0; i < nk; i++) {
        k[i] = ds.readInt(); // h.generateRandomDigits(g)
                             // Math.abs(UUID.randomUUID().getMostSignificantBits());
        // System.out.println("k["+i+"] :" + k[i] );
      }
      ds.close();
      int funct[] = new int[r.length];
      int temp[] = new int[r.length];

      for (int j = 0; j < nk; j++) // exception
      {
        for (int i = 0, z = 0; i < r.length && z < l.length; i++, z++) {
          // System.out.println("before : l[]="+l[z]+"r[]="+r[i] + "k[]="+k[j]);
          // System.out.println((char)l[z]+""+(char)r[i]);
          temp[i] = r[i];
          funct[i] = (int) (r[i] ^ k[j]);
          r[i] = (int) (l[z] ^ funct[i]);
          l[z] = temp[i];
          // System.out.println("after : l[]="+l[z]+"r[]="+r[i]);
          // System.out.println((char)l[z]+""+(char)r[i]);
        }
        for (int i = 0, z = 0; i < r.length && z < l.length; i++, z++) {
          System.out.print((char) l[z] + "" + (char) r[i]);
        }
        System.out.println();
      }
      char lo[] = new char[l.length];
      char ro[] = new char[r.length];
      char o[] = new char[l.length + r.length];
      for (int j = 0, z = 0; j < l.length && z < r.length; j++, z++) {
        lo[j] = (char) l[j];
        ro[z] = (char) r[z];
      }
      for (int i = 0; i < l.length; i++) {
        o[i] = (char) l[i];
      }
      for (int i = 0; i < r.length; i++) {
        o[l.length + i] = (char) r[i];
      }
      System.out.println();
      System.out.print("Encrypted: ");
      s = "";
      for (int i = 0; i < l.length + r.length; i++) {
        // if (c != 2 || i == (l.length + r.length) - 1)
        // System.out.print(o[i]);
        // else
        // c = 0;
        s += (char) o[i];
      }
      System.out.println(s);
      c += 1;
      // o1=(String)s;

      String e;
      File fil = new File("D:\\project\\en.txt");

      BufferedReader bru = new BufferedReader(new FileReader(fil));

      while ((e = bru.readLine()) != null) {
        new FileOutputStream("D:\\project\\en.txt").close();
      }
      FileWriter fWriter = new FileWriter("D:\\project\\en.txt");
      fWriter.write("\n");
      fWriter.write(o);
      fWriter.close();
      bru.close();
      System.out.println();
    }

    // Scanner sc = new Scanner(System.in);
    // int a = sc.nextInt();
    // if (a == 113) {
    // FileReader fis = new FileReader("D:\\project\\en.txt");
    // BufferedReader bis = new BufferedReader(fis);
    // String sl = "";
    // String so = "";
    // while ((sl = bis.readLine()) != null) {
    // so = so + sl;
    // }
    // int f = so.length();
    // Soundl sou = new Soundl();
    // sou.tone(7000, 440 * f);

    // bis.close();
    // }

  }
}

// class Soundl {

// public static float SAMPLE_RATE = 8000f;

// public static void tone(int hz, int msecs) throws LineUnavailableException {
// tone(hz, msecs, 1.0);
// }

// public static void tone(int hz, int msecs, double vol) throws
// LineUnavailableException {
// byte[] buf = new byte[1];
// AudioFormat af = new AudioFormat(SAMPLE_RATE, 8, 1, true, false);
// SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
// sdl.open(af);
// sdl.start();
// for (int i = 0; i < msecs * 8; i++) {
// double angle = i / (SAMPLE_RATE / hz) * 2.0 * Math.PI;
// buf[0] = (byte) (Math.sin(angle) * 127.0 * vol);
// sdl.write(buf, 0, 1);
// }
// sdl.drain();
// sdl.stop();
// sdl.close();
// }
