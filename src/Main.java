import java.io.*;
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
        Scanner input = new Scanner(System.in);

        do {
            System.out.print(encendermenu);
            System.out.println("\n");
            String archivo = input.nextLine();
            if (!archivo.equals("2")) {
                File archivoUsuario = new File(archivo);
                //El codigo de buffered reader es tomado de la siguiente pagina.
                //https://stackoverflow.com/questions/5868369/how-to-read-a-large-text-file-line-by-line-using-java
                try (BufferedReader br = new BufferedReader(new FileReader(archivoUsuario))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] parts = line.split(Pattern.quote(","));
                        String part1 = parts[0];
                        String part2 = parts[1];
                        //esto quita los parentesis para que solo queden las palabras
                        part1 = part1.replace("(", " ");
                        part2 = part2.replace(")", " ");
                        //agregar las palabras a un binary tree la palabra en ingles se va a agregar como el key y la palabra
                        //en espanol se va a agregar como el value.
                        BinaryTree<String> palabrasNuevas = new BinaryTree<>(part1,part2);
                        System.out.println(part1);
                        System.out.println(part2);
                    }

                } catch (Exception e) {
                    System.out.println("Intente ingresando la direccion del archivo de nuevo porque no se encontro");
                }
            }
            // imprimir el archivo de diccionario en inorder
            // TODO: 2019-03-19 HACER INORDER
            intepretacionDic = true;
            do {
                // PEDIR EL ARCHIVO QUE SE QUIERE LEER
                System.out.println(documentomenu);
                System.out.println("\n");
                String ingles = input.nextLine();
                if (!archivo.equals("2")) {
                    File archivoUsuarios = new File(archivo);
                    try (BufferedReader br = new BufferedReader(new FileReader(archivoUsuarios))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            String english = line;
                            String english1 = line.substring(1, english.length()-1);
                            System.out.println(english1);
                            String[] parts = line.split(Pattern.quote(","));
                        }
                    }catch (Exception e) {
                        System.out.println("Intente ingresando la direccion del archivo de nuevo porque no se encontro");
                    }
                    // TODO: 2019-03-19 HACER LECTURA DE ARCHIVO Y TRADUCTION
                    intepretacionDic = false;
                    deleViaje = false;


                }

            }while (intepretacionDic);

        } while (deleViaje);

    }
}
