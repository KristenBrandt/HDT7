import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

        static String encendermenu = "\n Diccionario : \n" +
                "\t Ingresar la direccion del archivo de diccionario que quiere:\n" +
                "\t La direccion del archivo tiene que ser en formato C:\\\\Users\\\\try\\\\Desktop\\\\intento.txt\n" +
                "\t Si la direccion no es aceptada al primer intento ponga la direccion de nuevo, es por un problema de cache ";

    static String documentomenu = "\n Lectura de archivo en ingles : \n" +
            "\t Ingresar la direccion del archivo en ingles que quiere:\n" +
            "\t La direccion del archivo tiene que ser en formato C:\\\\Users\\\\try\\\\Desktop\\\\intento.txt\n" +
            "\t Si la direccion no es aceptada al primer intento ponga la direccion de nuevo, es por un problema de cache ";

    public static void main(String[] args) {
        boolean deleViaje = true;
        boolean intepretacionDic = false;
        Node<Association<String,String>> palabrasNuevas = new Node<>();
        ArrayList<Association<String,String>> palabs = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        do {
            System.out.print(encendermenu);
            System.out.println("\n");
            String archivo = input.nextLine();
            if (!archivo.equals("2")) {
                File archivoUsuarios = new File(archivo);
                //El codigo de buffered reader es tomado de la siguiente pagina.
                //https://stackoverflow.com/questions/5868369/how-to-read-a-large-text-file-line-by-line-using-java
                try (BufferedReader br = new BufferedReader(new FileReader(archivoUsuarios))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] parts = line.split(Pattern.quote(","));
                        String paretes = parts[0];
                        String part1 = parts[0];
                        String part2 = parts[1];
                        //esto quita los parentesis para que solo queden las palabras
                        part1 = part1.replace("(", "");
                        part2 = part2.replace(")", "");
                        //agregar las palabras a un binary tree la palabra en ingles se va a agregar como el key y la palabra
                        //en espanol se va a agregar como el value.
                        Association palabrota = new Association(part1,part2);
                        palabrasNuevas.insert(palabrota);
                        String listo = palabrota.toString();
                        String[] party = line.split(Pattern.quote(","));
                        String parte = party[0];
                        String parti = party[1];
                        Object palab = palabrota.theKey;
                        String kr = palab.toString();
                        Object pelab =  palabrota.theValue;
                        String yep = pelab.toString();



                    }


                } catch (Exception e) {
                    System.out.println("Intente ingresando la direccion del archivo de nuevo porque no se encontro");
                }
            }
            // imprimir el archivo de diccionario en inorder

            System.out.print(" Se va a imprimir el diccionario en orden inorder \n");
            palabrasNuevas.inorder();
            intepretacionDic = true;
            do {
                // PEDIR EL ARCHIVO QUE SE QUIERE LEER
                System.out.println(documentomenu);
                System.out.println("\n");
                String ingles = input.nextLine();
                if (!archivo.equals("2")) {
                    File archivoUsuarios = new File(ingles);
                    try (BufferedReader br = new BufferedReader(new FileReader(archivoUsuarios))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            String english = line;
                            System.out.print("Se va a traducir el archivo :");
                            System.out.println(english);
                            ArrayList<String> hacer = new ArrayList<>(Arrays.asList(line.split(" ")));
                            System.out.print(hacer);


                            // TODO: 2019-03-19  TRADUCTION
                        }
                    }catch (Exception e) {
                        System.out.println("Intente ingresando la direccion del archivo de nuevo porque no se encontro");
                    }

                    intepretacionDic = false;
                    deleViaje = false;


                }

            }while (intepretacionDic);

        } while (deleViaje);

    }
}
